<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>登入页面</title>
    <link rel="stylesheet" href="<%=basePath%>static/css/login.css" type="text/css">
    <script type="text/javascript" src="<%=basePath%>static/js/login.js"></script>
</head>

<body>
<!--整体-->
<div class="login">
    <div class="login-box">
        <form action="javascript:;" id="form_login" onsubmit="return user_login();">
            <div class="user-login" >用户登入
                <div id="login_error" class="error"></div>
            </div>

            <!--登入选择框-->
            <div class="user-b">
                <!--//用户-->
                <div class="userName-login">
                    <div id="username_error" class="error"></div>
                    <input type="text" maxlength="15" class="login-userName-input" name="userName" id="userName"  placeholder="请输入用户名">
                </div>

                <!--//m密码-->
                <div class="userName-login">
                    <div id="password_error" class="error"></div>
                    <input type="password" maxlength="15" class="login-userName-input" name="userPassword" id="password" placeholder="请输入密码">
                </div>

                <!-- //登入,注册按钮-->
                <div class="login-button">
                    <input type="submit" value="登入" class="login-button-input l0" id="userLogin" name="login" >
                    <input type="button" value="注册" class="login-button-input r0" onclick="user_register()">
                </div>
            </div>

        </form>
    </div>
</div>

</body>
</html>