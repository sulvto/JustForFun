<template>
  <section class="ns-base-section">

    <div style="position:relative;margin:0;">
      <!-- 面包屑导航 -->
            <div class="breadcrumb-nav">
        <a href="index.html">零基础学IT就来</a>
                  <i class="fa fa-angle-right"></i>
          <a href="/config/usernotice.html">网站</a>
                  <i class="fa fa-angle-right"></i>
          <!-- 需要加跳转链接用这个：http://showfx.niuteam.cn/admin/config/fixedtemplate -->
          <a href="javascript:;" style="color:#999;">手机端模板</a>
              </div>
            <!-- 三级导航菜单 -->

                <nav class="ns-third-menu">
          <ul>
            <li onclick="location.href='/config/pctemplate.html';">电脑端模板</li>
            <li class="selected" onclick="location.href='/config/fixedtemplate.html';">手机端模板</li>
            <li onclick="location.href='/config/wapcustomTemplateList.html';">手机端自定义模板</li>
          </ul>
        </nav>

      <div class="right-side-operation">
        <ul>
          <li>
            <a class="js-open-warmp-prompt" href="javascript:;" data-menu-desc=""><i class="fa fa-question-circle"></i>&nbsp;提示</a>
            <div class="popover">
              <div class="arrow"></div>
              <div class="popover-content">
                <div>
                                    <h4>功能提示</h4>
                  <p class="function-prompts"></p>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <div class="ns-main">

  <div class="set-style">
  <dl>
    <dt><span style="color:red;margin-right:10px;"></span>用户通知：</dt>
    <dd class="borderclass">
      <textarea rows="2" id="notice_message" class="textarea w400 input-common" maxlength="50"></textarea>
    </dd>
  </dl>
  <dl>
    <dt>是否启用用户通知：</dt>
    <dd class="borderclass">
      <p>
        <input id="is_enable" type="checkbox" class="checkbox" />
      </p>
    </dd>
  </dl>
  <dl>
    <dt>分类显示方式：</dt>
    <dd class="borderclass classified-display-mode">
        <label class="radio inline normal">
          <i class="radio-common "><input type="radio" name="input-classified-display-mode" value="1"></i>
          <span>缩略图模式</span>
        </label>
        <label class="radio inline normal">
          <i class="radio-common selected"><input type="radio" name="input-classified-display-mode" value="2" checked="checked"></i>
          <span>列表模式</span>
        </label>
    </dd>
  </dl>
  <dl class="hide">
    <dt>首页商品分类显示：</dt>
    <dd class="borderclass">
        <input id="is_category" type="checkbox" class="checkbox" onchange="chagecategoryblock();" simpleswitch="0" result="false" style="display: none;"><div class="Switch Switch_FlatRadius" id="Switch0"><span class="switch-open">是</span><span class="switch-close">否</span></div>
    </dd>
  </dl>
  <dl>
    <dt>模板列表：</dt>
    <dd class="borderclass">
      <div class="app-template">
        <ul>
                    <li class="selected" data-folder="default_new">
            <div class="img">
              <img width="170" height="353" alt="template" src="/template/wap/default_new/thumbnail.png">
            </div>
            <div class="introduce">清爽版模板 - NiuShop团队支持</div>
            <div class="theme">清爽版</div>
          </li>
                  </ul>
      </div>
    </dd>
  </dl>
  <dl>
    <dt></dt>
    <dd class="borderclass">
      <button class="btn-common btn-big" onclick="setConfigAjax();">保存</button>
    </dd>
  </dl>
  </div>

    </div>
  </section>
</template>
