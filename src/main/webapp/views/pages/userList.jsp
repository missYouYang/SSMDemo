<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<html>
<head>
    <title>后台管理</title>
    <link href="<%=basePath%>static/css/pages/body.css" rel="stylesheet" />

</head>
<body>
<!-- 头部 -->
<div class="header clearfix">
    <ul class="fr">
        <li class="dmovo_js">
            <i class="iconin icon_h_xt"></i>系统设置
            <div class="poptopbar_name dmbox">
                <a href="pages/admin.html">
                    <i class="iconin icon_name4"></i>管理员
                </a>
            </div>
        </li>
        <li class="dmovo_js">
            <i class="iconin icon_h_name"></i>Admin
            <div class="poptopbar_name dmbox">
                <a href="pages/person.html">
                    <i class="iconin icon_name1"></i>个人资料
                </a>
                <a href="javascript:;" id="passwordModalA">
                    <i class="iconin icon_name2"></i>修改密码
                </a>
                <a href="javascript:;">
                    <i class="iconin icon_name3"></i>退出登录
                </a>
            </div>
        </li>
    </ul>
</div>
<!-- 头部 -->
<!-- 左边-->
<div class="left">
    <div class="left_top">
        <!-- <span class="logo"></span>-->菜单栏
    </div>
    <!--  <div class="nav_title">导航</div>-->
    <!--列表-->
    <div class="nav">
        <div class="section section_js">
            <h3 class="active h3 nav_h3_js">
                <a href="pages/home">
                    <i class="icon icon_nav1"></i>
                    <span>首页</span>
                </a>
            </h3>
        </div>
        <!---->
        <div class="section section_js">
            <h3 class="h3 nav_h3_js">
                <a href="javascript:;">
                    <i class="icon icon_nav2"></i>
                    <i class="icon icon_down"></i>
                    <span class="txt_nav">用户</span>
                </a>
            </h3>
            <ul class="clearfix">
                <li class="nav_li_js">
                    <a  href="rest?url=pages/userList">
                        <span>>> 用户列表</span>
                    </a>
                </li>
                <li class="nav_li_js">
                    <a href="pages/attest.html">
                        <span>>> 用户认证</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="section section_js">
            <h3 class="h3 nav_h3_js">
                <a href="javascript:;">
                    <i class="icon icon_nav3"></i>
                    <i class="icon icon_down "></i>
                    <span class="txt_nav">订单</span>
                </a>
            </h3>
            <ul class="clearfix">
                <li class="nav_li_js">
                    <a href="pages/order.html">
                        <span>>> 订单管理</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="section section_js">
            <h3 class="h3 nav_h3_js">
                <a href="javascript:;">
                    <i class="icon icon_nav4"></i>
                    <i class="icon icon_down"></i>
                    <span class="txt_nav">产品</span>
                </a>
            </h3>
            <ul class="clearfix">
                <li class="nav_li_js">
                    <a href="pages/products.html">
                        <span>>> 产品列表</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="section section_js">
            <h3 class="h3 nav_h3_js">
                <a href="javascript:;">
                    <i class="icon icon_nav5"></i>
                    <i class="icon icon_down"></i>
                    <span class="txt_nav">消息</span>
                </a>
            </h3>
            <ul class="clearfix">
                <li class="nav_li_js">
                    <a href="pages/news.html">
                        <span>>> 消息管理</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="section section_js">
            <h3 class="h3 nav_h3_js">
                <a href="javascript:;">
                    <i class="icon icon_nav6"></i>
                    <i class="icon icon_down"></i>
                    <span class="txt_nav">财务</span>
                </a>
            </h3>
            <ul class="clearfix">
                <li class="nav_li_js">
                    <a href="pages/deposit.html">
                        <span>>> 订金</span>
                    </a>
                </li>
                <li class="nav_li_js">
                    <a href="pages/receipts.html">
                        <span>>> 收款</span>
                    </a>
                </li>
                <li class="nav_li_js">
                    <a href="pages/refunds.html">
                        <span>>> 退款</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--左边结束-->
<!-- body 开始 -->
<div class="body">
    <!--上部分-->
    <div class="body_top">

        <!--标题-->
        <div class="body_title">
            <div class="body_title_font">
                <div>用户列表</div>
            </div>
        </div>
        <!--左 添加 删除按钮-->
        <div class="body_top_l">
            <button class="btn btn_search" type="button">
                <i class="glyphicon glyphicon-plus body_top-l-i"></i><span>添加用户</span>
            </button>
            <button class="btn btn_search" type="button">
                <i class="glyphicon glyphicon-trash body_top-l-i"></i><span>删除用户</span>
            </button>
        </div>

        <!--有 搜索按钮-->
        <div  class="body_top_r">
            <div class="body_solr">
                <div class="body_input_l">
                    登入名：<input type="text" class="body_name" name="userName" id="body_userName">
                </div>
                <div class="body_input_r">
                    手机号：<input type="text" class="body_name" name="userTel" id="body_userTel">
                </div>
            </div>
            <div class="body_buton">
                <button class="btn btn_search" type="button" onclick="btn_search()">
                    <span>确认</span>
                </button>
                <button class="btn btn_empty" type="button" onclick="btn_empty()">
                    <span>清空</span>
                </button>
            </div>
        </div>
    </div>

    <!--列表-->
    <table class="" id="table">

    </table>
</div>


<!--body 结束-->

<script src="<%=basePath%>static/js/pages/user.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/pages/home.js" type="text/javascript"></script>
</body>
</html>
