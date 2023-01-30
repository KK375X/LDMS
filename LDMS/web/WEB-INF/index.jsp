<%--
  首页
  Created by IntelliJ IDEA.
  User: 康小康
  Date: 2021/12/1
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>LDMS系统后台管理-登陆</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="lib/layui-v2.6.3/css/layui.css" media="all">

    <style>
        html, body {
            width: 100%;
            height: 100%;
            overflow: hidden
        }

        body {
            background: #1E9FFF;
        }

        body:after {
            content: '';
            background-repeat: no-repeat;
            background-size: cover;
            -webkit-filter: blur(3px);
            -moz-filter: blur(3px);
            -o-filter: blur(3px);
            -ms-filter: blur(3px);
            filter: blur(3px);
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            z-index: -1;
        }

        .layui-container {
            width: 100%;
            height: 100%;
            overflow: hidden
        }

        .admin-login-background {
            width: 360px;
            height: 300px;
            position: absolute;
            left: 50%;
            top: 40%;
            margin-left: -180px;
            margin-top: -100px;
        }

        .logo-title {
            text-align: center;
            letter-spacing: 2px;
            padding: 14px 0;
        }

        .logo-title h1 {
            color: #1E9FFF;
            font-size: 25px;
            font-weight: bold;
        }

        .login-form {
            background-color: #fff;
            border: 1px solid #fff;
            border-radius: 3px;
            padding: 14px 20px;
            box-shadow: 0 0 8px #eeeeee;
        }

        .login-form .layui-form-item {
            position: relative;
        }

        .login-form .layui-form-item label {
            position: absolute;
            left: 1px;
            top: 1px;
            width: 38px;
            line-height: 36px;
            text-align: center;
            color: #d2d2d2;
        }

        .login-form .layui-form-item input {
            padding-left: 36px;
        }

        .captcha {
            width: 60%;
            display: inline-block;
        }

        .captcha-img {
            display: inline-block;
            width: 34%;
            float: right;
        }

        .captcha-img img {
            height: 34px;
            border: 1px solid #e6e6e6;
            height: 36px;
            width: 100%;
        }

    </style>

</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form" style="width: 410px">
            <form class="layui-form" action="">
                <div class="layui-form-item logo-title">
                    <h1>LDMS-后台登录</h1>
                </div>
                <div class="layui-form-item">
                    <%--@declare id="username"--%><label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" name="id" id="id" lay-verify="required|account" placeholder="用户名"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <%--@declare id="password"--%><label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" name="password" id="password" lay-verify="required|password" placeholder="密码"
                           autocomplete="off" class="layui-input">
                </div>
                <%--                用户身份 --%>
                <div>
                    <form action="" class="layui-form" style="width: 400px; height: 100px">
                        <!-- 加上form组件，解决三个单选框隐藏的问题 -->
                        <div class="layui-input-item">
                            <label class="layui-form-label" style="color: #029789">您的身份：</label>
                            <input type="radio" name="entity" value="管理员" title="管理员" checked="">
                            <input type="radio" name="entity" value="教师" title="教师">
                            <input type="radio" name="entity" value="学生" title="学生">
                        </div>
                    </form>
                </div>
                <%--                验证码部分暂时不需要 --%>
                <%--                <div class="layui-form-item">--%>
                <%--                    &lt;%&ndash;@declare id="captcha"&ndash;%&gt;<label class="layui-icon layui-icon-vercode" for="captcha"></label>--%>
                <%--                    <input type="text" name="captcha" lay-verify="required|captcha" placeholder="图形验证码"--%>
                <%--                           autocomplete="off" class="layui-input verification captcha" value="xszg">--%>
                <%--                    <div class="captcha-img">--%>
                <%--                        <img id="captchaPic" src="../images/captcha.jpg">--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <div class="layui-form-item" style="height: 50px">
                    <div style="float: left">
                        <input type="checkbox" name="rememberMe" value="true" lay-skin="primary" title="记住密码">
                    </div>
                    <div style="float: right">
                        <button class="layui-btn layui-btn layui-btn-normal layui-btn-fluid" lay-submit=""
                                lay-filter="register" onclick="register()"
                                style="height: 28px; line-height: 100%; margin-top: 5px">
                            <a href="AddUserServlet" style="color: #FFFFFF"> 注 册 </a>
                        </button>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn layui-btn-normal layui-btn-fluid" lay-submit=""
                            lay-filter="login" onclick="login()"> 登 录
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="./lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="./lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="./lib/jq-module/jquery.particleground.min.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
                layer = layui.layer;

        // 登录过期的时候，跳出ifram框架
        if (top.location !== self.location) top.location = self.location;

        // 粒子线条背景
        $(document).ready(function () {
            $('.layui-container').particleground({
                dotColor: '#7ec7fd',
                lineColor: '#7ec7fd'
            });
        });

        // 进行登录操作
        form.on('submit(login)', function (data) {
            data = data.field;
            // username 即 id
            if (data.id === '') {
                layer.msg('用户名不能为空');
                return false;
            }
            if (data.password === '') {
                layer.msg('密码不能为空');
                return false;
            }
            return false;
        });
    });
</script>

<script type="text/javascript">

    // 登录
    function login() {
        // 这里的username 都是用户的 id，并非是用户名
        var id = $('#id').val(); // 获取ID
        var password = $('#password').val(); // 获取password
        var entity = $('input[name="entity"]:checked').val(); // 获取身份

        $.ajax({
            type: 'post', //两种方式get和post
            url: 'CheckLoginServlet', //通讯地址
            data: {'id': id, 'password': password, 'entity': entity}, //发送用户输入的数据到服务器
            dataType: "text", //传回来的数据类型 text json
            success: function (res) {
                if (res === "success") {
                    if (entity === "管理员") {
                        // 延迟0.5秒跳转到管理员界面
                        setTimeout(500);
                        window.location.href = "MainServlet";
                    } else if (entity === "学生") {
                        // 延迟0.5秒跳转到学生页面
                        setTimeout(500);
                        window.location.href = "StudentMainViewServlet";
                    } else if (entity === "教师") {
                        // 延迟0.5秒跳转到教师页面
                        setTimeout(500);
                        window.location.href = "TeacherMainViewServlet";
                    }
                } else {
                    alert("登录失败！");
                }
            }
        });
    }

</script>

<script>
    layui.use('form', function () {
        var form = layui.form;
        form.render();
    });
</script>

</body>
</html>