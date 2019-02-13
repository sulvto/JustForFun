package me.qinchao.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import me.qinchao.example.config.Constant;
import me.qinchao.example.model.User;
import me.qinchao.example.repository.UserRepository;
import me.qinchao.example.utils.Response;
import me.qinchao.example.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/admin")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    LoadingCache<String, String> jwtBlacklist = CacheBuilder.newBuilder().expireAfterWrite(Constant.JWT_TTL, TimeUnit.MINUTES).build(new CacheLoader<String, String>() {
        @Override
        public String load(String key) throws Exception {
            return null;
        }
    });

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User loginUser, HttpServletResponse response) {
        User user = userRepository.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());

        if (user != null) {
            user.setPassword(null);

            String token = TokenUtil.createJWT(Constant.JWT_ID, TokenUtil.generalSubject(user), Constant.JWT_TTL);

            JSONObject responseData = new JSONObject();
            responseData.put("access_token", token);
            responseData.put("token_type", "bearer");
            responseData.put("expires_in", Constant.JWT_TTL);
            responseData.put("userinfo", user);
            response.addCookie(new Cookie("token", token));
            return Response.success("登录成功", responseData);
        } else {
            response.addCookie(new Cookie("token", ""));
            return Response.error(-1, "用户名或密码错误");
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        String token = (String) request.getAttribute(Constant.ATTR_TOKEN);
        response.addCookie(new Cookie("token", ""));
        jwtBlacklist.put(token, "");
        return Response.success();
    }

    @PostMapping("/me")
    public String me(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getAttribute(Constant.ATTR_USER);

        logger.info("/me {}", user);
        if (user != null) {
            return Response.success("", user);
        } else {
            logger.error("/me user is null");
            return Response.error(-1, "用户未登录");
        }
    }

    @PostMapping("/refreshToken")
    public String refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String token = (String) request.getAttribute(Constant.ATTR_TOKEN);
        if (jwtBlacklist.getIfPresent(token) == null) {
            jwtBlacklist.put(token, "");

            User user = (User) request.getAttribute(Constant.ATTR_USER);
            String newToken = TokenUtil.createJWT(Constant.JWT_ID, TokenUtil.generalSubject(user), Constant.JWT_TTL);
            JSONObject responseData = new JSONObject();
            responseData.put("token", newToken);
            responseData.put("type", "bearer");
            responseData.put("userinfo", user);
            response.addCookie(new Cookie("token", newToken));
            return Response.success("", responseData);
        } else {
            return Response.error(-1, "非法访问");
        }
    }

}

