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
        <div class="register_welcome">欢迎注册 </div>

        <div class="register_user">
            <form action="#" method="post">
                <table>
                    <tr class="register_tr">
                        <td class="register_td_t fontFam"><div>用户名：</div></td>
                        <td><input class="register_td_i" type="text" name="userName" id="userName" maxlength="15" placeholder="请输入用户名"/></td>
                        <td><div id="error_userName" class="error_mage fontFam"><!--<span id="user_name_span" style="display: block">*</span>--></div></td>
                    </tr>

                    <tr class="register_tr">
                        <td class="register_td_t fontFam"><div class="register_divf2" >密码：</div></td>
                        <td><input class="register_td_i" type="password" name="userName" id="userPassword" maxlength="15" placeholder="请输入密码"/></td>
                        <td><div id="error_upserPassword" class="error_mage fontFam"></div></td>
                    </tr>

                    <tr class="register_tr">
                        <td class="register_td_t fontFam"><div>手机号：</div></td>
                        <td><input class="register_td_i" type="text" name="userName" id="userPhone" maxlength="11" placeholder="请输入手机号"/></td>
                        <td><div id="error_upserPhone" class="error_mage fontFam"></div></td>
                    </tr>

                    <tr class="register_tr">
                        <td class="register_td_t fontFam"><div class="register_divf2">性别：</div></td>
                        <td><span class="register_tr_spanb">男</span><input type="radio" name="sex" id="sex" value="男" checked/>
                            <span class="register_tr_spang">女</span><input type="radio" name="sex" id="sex2" value="女" /></td>
                    </tr>
                </table>
                <div class="register_b">
                    <a class="register_button" onclick="u_register()"><span>注册</span></a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>