<template>

  <section class="ns-base-section">

    <div style="position:relative;margin:0;">
      <!-- 面包屑导航 -->
            <div class="breadcrumb-nav">
        <a href="index.html">大鵬系統</a>
                  <i class="fa fa-angle-right"></i>
          <a href="/wchat/config.html">微信</a>
                  <i class="fa fa-angle-right"></i>
          <!-- 需要加跳转链接用这个：http://showfx.niuteam.cn/admin/wchat/keyConcernConfig -->
          <a href="javascript:;" style="color:#999;">一键关注设置</a>
              </div>
            <!-- 三级导航菜单 -->

      <div class="right-side-operation">
        <ul>
          <li>
            <a class="js-open-warmp-prompt" href="javascript:;" data-menu-desc=""><i class="fa fa-question-circle"></i>&nbsp;提示</a>
            <div class="popover">
              <div class="arrow"></div>
              <div class="popover-content">
                <div>
                                    <h4>操作提示</h4>
                  <p>一键关注设置</p>
                  <hr>
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
                    <dt>效果预览：</dt>
                    <dd>
                        <img src="/public/admin/images/key_concern_preview.png" style="border: 1px solid #f0f0f0;">
                    </dd>
                </dl>
                <dl>
                    <dt>是否首页显示:</dt>
                    <dd>
                        <input type="checkbox" class="checkbox" name="is_show_follow" checked="checked" simpleswitch="0" result="true" style="display: none;"><div class="Switch Switch_FlatRadius On" id="Switch0"><span class="switch-open">是</span><span class="switch-close">否</span></div>
                    </dd>
                </dl>

                <dl>
                    <dt></dt>
                    <dd><button class="btn-common btn-big" onclick="setConfigAjax();">保存</button></dd>
                </dl>
            </div>
    </div>

  </section>
</template>
