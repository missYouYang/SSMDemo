<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登入成功页面</title>

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
                <a href="rest?url=pages/home">
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
                    <a href="rest?url=pages/userList">
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
<script src="<%=basePath%>static/js/pages/home.js" type="text/javascript"></script>
</body>
</html>