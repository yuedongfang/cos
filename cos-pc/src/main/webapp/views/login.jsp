<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css" href="../style/css/login.css"/>
    <script type="text/javascript" src="../js/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/jquery.form.min.js" charset="utf-8"></script>

    <script type="text/javascript" src="../js/login.js" charset="utf-8"></script>


</head>
<body onkeydown="enterlogin();">
<div class="top_div"></div>
<div style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231);border-image:none;width:400px;text-align: center;">
    <form method="post" id="loginform" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div style="width: 165px; height: 96px; position: absolute;">
            <div class="tou"></div>
            <div class="initial_left_hand" id="left_hand"></div>
            <div class="initial_right_hand" id="right_hand"></div>
        </div>
        <P style="padding: 30px 0px 10px; position: relative;">
            <span class="u_logo"></span>
            <input class="ipt" type="text" name="username" placeholder="请输入登录名"/>
        </P>
        <P style="position: relative;">
            <span class="p_logo"></span>
            <input class="ipt" id="password" type="password" name="password" placeholder="请输入密码"/>
        </P>
        <p style="padding: 10px 0px 10px; position: relative;">
            <input type="text" id="code" name="code" class="captcha" style="width:180px;" placeholder="请输入验证码"/>
            <img id="imageCode" style="position:relative;top: 14px;" alt="验证码" src="/cos-pc/validateCode" onclick="checkcode('<%=basePath%>')"/>
            <a href="#" onclick="checkcode('<%=basePath%>')">换一张</a>
        </p>

        <P style="position: relative;text-align: left;">
            <input class="rememberMe" type="checkbox" name="rememberMe" value="1" checked
                   style="vertical-align:middle;margin-left:40px;height:20px;"/> 记住密码
        </P>
        <div style="height: 50px; line-height: 50px; margin-top: 10px;border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
            <P style="margin: 0px 35px 20px 45px;">
                <span style="float: left;">
                    <a style="color: rgb(204, 204, 204);" href="javascript:;">忘记密码?</a>
                </span>
                <span style="float: right;">
                    <a style="color: rgb(204, 204, 204); margin-right: 10px;" href="javascript:;">注册</a>
                    <a style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
                       href="javascript:;" onclick="submitForm()">登录</a>
                </span>
            </P>
        </div>
    </form>
</div>
</body>
</html>
