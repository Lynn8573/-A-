
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户登录</title>

    <!-- Bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
            rel="stylesheet">
    <link
            href="https://cdn.bootcss.com/jquery-confirm/3.2.3/jquery-confirm.min.css"
            rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link
            href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css"
            rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js "></script>
    <script
            src="https://cdn.bootcss.com/jquery-confirm/3.2.3/jquery-confirm.min.js "></script>
    <script src="https://cdn.bootcss.com/jquery.form/4.2.1/jquery.form.js"></script>
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        #dropdownMenu2 {
            padding-right: 28px;
            background-image: url(../images/my/2.png);
            background-repeat: no-repeat;
            background-position-x: right;
        }
    </style>
    <head>
        <meta charset="UTF-8">
        <title>用户注册</title>
        <link rel="stylesheet" type="text/css" href="../css/login.css">
        <script type="text/javascript" src="../js/jquery.js"></script>

        <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-18" data-genuitec-path="/FengMi/WebRoot/before/register.html">
<form id="form"  method="post" action="${pageContext.request.contextPath}/UserAddServlet" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-18" data-genuitec-path="/FengMi/WebRoot/before/register.html">
    <div style="text-align:center" align="center">
        <img src="../images/default.jpg" sizes="25px 25px"/>
    </div>
    <div class="regist" align="center">
        <div class="regist_center">
            <div class="regist_top">
                <div class="left fl">会员注册</div>
                <div class="right fr"><a href="./index.html" target="_self">锋迷网</a></div>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="regist_main center">
                <div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" id="userName" name="username" placeholder="请输入你的用户名[至少6位]"/><span id="message" style="font-size:18px"></span></div>
                <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" id="mm1" name="password" placeholder="请输入你的密码[6-8位]"/></div>

                <div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="repassword" placeholder="请确认你的密码" id="mm2"/><span id="msg" style="font-size:18px"></span></div>
                <div class="username">性别:&nbsp;&nbsp;<input class="shurukuang" type="text" name="sex" placeholder="请填写正确的性别"/></div>
                <div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="phone" placeholder="请填写正确的手机号"/></div>
                <div class="username">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:&nbsp;&nbsp;<input class="shurukuang" id="mail" type="text" name="mail" placeholder="请填写邮箱地址"/><span id="result" style="font-size:18px"></span></div>

                <!-- <div class="username">
                    <div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="yanzhengma" type="text" name="username" placeholder="请输入验证码"/></div>
                    <div class="right fl"><img src="./image/yanzhengma.jpg"></div>
                    <div class="clear"></div>
                </div> -->
            </div>
            <div class="regist_submit">
                <input class="submit" type="submit" onclick="validateForm()"  name="submit" value="立即注册" >
            </div>

        </div>
    </div>
</form>
<script type="text/javascript">
    function validateMail(){
        var mail= $("#mail").val();
        var regex= /^\w+@\w+.\w+$/;
        if(mail.match(regex)){
            $("#result").text("此邮箱格式正确");
            return true;
        }else{
            $("#result").text("此邮箱格式错误");
            return false;
        }
    }

    function validateMm(){
        var v1= $("#mm1").val();
        var v2= $("#mm2").val();

        if(v1!='' && v1==v2){

            return true;
        }else{
            $("#msg").text("两次密码不一致，请检查");
            $("#msg").css("color","red");
            return false;
        }
    }

    var result = true;
    function validateName(){
        var name = $("#userName").val();
        if(name!=''){
            $.get("../user/validateName?name="+name,function(data){
                // alert(data);
                if(data=="0"){
                    $("#message").text("该用户名可以用");
                    $("#message").css("color","green");
                    result = true;
                }else{
                    $("#message").text("该用户名已经被占用");
                    $("#message").css("color","red");
                    result = false;
                }
            });
        }else{
            result = false;
            $("#message").text("该用户名不能为空");
            $("#message").css("color","red");
        }

    }

    $(function(){

        $("#userName").blur(function(){
            validateName();
        });

    });

    function validateForm(){
        //alert("1");
        //alert($("#form"));
        $("#form").submit(function(){
            //alert("2");
            if(validateMm() && result && validateMail()){
                //此表单都正确，可以提交给服务器
                //alert("3");
                return true;
            }else{
                //alert("4");
                return false;
            }

        });

    }
</script>
</body>
</html>