<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link href="../static/css/register.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../static/js/register.js"></script>
</head>
<body  marginwidth="0" marginheight="0">
    <div class="register-1">
        <!--//注册页面-->
        <div class="register">
       		<div id="register-user" style="color: red;font-size: 15px;margin-left: 100px">${message }</div>
            <div class="register-welcome">欢迎注册
            	 
            </div>
	
            <div class="register-user">
                <form action="<%=basePath%>/user/insertUser" method="post" onsubmit="return u_register()">
                    <table>
                        <tr class="login-tr">
                            <td class="login-td">用户名</td>
                            <td class=".login-td2">
                                <input type="text" name="userName" id="userName" maxlength="15" onblur="p_a()"/>
                                <div id="error_password1" class="error_password"></div>
                            </td>
                        </tr>
                        <tr class="login-tr">
                            <td class="login-td">密码</td>
                            <td class=".login-td2">
                                <input type="password" name="password" id="password" maxlength="15" onblur="p_a()">
                                <div id="error_password" class="error_password"></div>
                            </td>
                        </tr>
                        <tr class="login-tr">
                            <td class="login-td">密码确认</td>
                            <td class=".login-td2">
                                <input type="password" name="rePassword" id="rePassword" maxlength="15" onblur="p_a()"/>
                                <div id="error_password4" class="error_password"></div>
                            </td>
                        </tr>
                        <tr class="login-tr">
                            <td class="login-td">电话</td>
                            <td class=".login-td2">
                                <input type="text" name="telPhone" id="telPhone" maxlength="11" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');" onblur="p_a()"/>
                                <div id="error_password2" class="error_password"></div>
                            </td>
                        </tr>
                        <tr class="login-tr">
                            <td class="login-td">性别</td>
                            <td>
                                男<input type="radio" name="sex" id="sex" value="男" checked/>
                                女<input type="radio" name="sex" id="sex2" value="女" />
                                <div id="error_password3" class="error_password"></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" class="register-get" >
                                <input type="submit" id="" value="注册" />
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>

</body>
</html>