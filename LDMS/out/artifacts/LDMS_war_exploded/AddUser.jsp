<%--
  Created by IntelliJ IDEA.
  User: 康小康
  Date: 2021/12/1
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>LDMS-用户注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="css/admin.css" media="all">
    <link rel="stylesheet" href="css/login.css" media="all">
</head>
<body>


<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">

        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2 style="font-weight: bold">欢迎新用户注册</h2>
        </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>必填信息</legend>
        </fieldset>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-id"></label>
            <input type="text" name="id" id="LAY-user-login-id" placeholder="用户ID（工号/学号）" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-name"></label>
            <input type="text" name="name" id="LAY-user-login-name" placeholder="姓名" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                   for="LAY-user-login-password"></label>
            <input type="password" name="password" id="LAY-user-login-password" lay-verify="pass" placeholder="密码"
                   class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-repass"></label>
            <input type="password" name="repass" id="LAY-user-login-repass" lay-verify="required" placeholder="确认密码"
                   class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-age"></label>
            <input type="text" name="age" id="LAY-user-login-age" placeholder="年龄" class="layui-input">
        </div>
        <form action="" class="layui-form"> <!-- 加上form组件，解决三个单选框隐藏的问题 -->
            <div class="layui-input-item">
                <label class="layui-form-label">性别：</label>
                <input type="radio" name="sex" value="男" title="男" checked="">
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </form>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-phone"></label>
            <input type="text" name="phone" id="LAY-user-login-phone" placeholder="联系方式" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-college"></label>
            <input type="text" name="college" id="LAY-user-login-college" placeholder="所属学院" class="layui-input">
        </div>
        <form action="" class="layui-form"> <!-- 加上form组件，解决三个单选框隐藏的问题 -->
            <div class="layui-input-item">
                <label class="layui-form-label">身份：</label>
                <input type="radio" name="entity" value="教师" title="教师" checked="">
                <input type="radio" name="entity" value="学生" title="学生">
            </div>
        </form>


        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>选填信息</legend>
        </fieldset>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                   for="LAY-user-login-position"></label>
            <input type="text" name="position" id="LAY-user-login-position" placeholder="职位" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                   for="LAY-user-login-teacherId"></label>
            <input type="text" name="teacherId" id="LAY-user-login-teacherId" placeholder="辅导员ID" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-classes"></label>
            <input type="text" name="classes" id="LAY-user-login-classes" placeholder="班级" class="layui-input">
        </div>


        <div class="layui-form-item">
            <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-reg-submit" onclick="register()">
                注 册
            </button>
        </div>

        <div class="layui-trans layui-form-item layadmin-user-login-other">
            <!-- 向controller层发送请求，实现页面的跳转 -->
            <a href="LoginServlet" class="layadmin-user-jump-change layadmin-link layui-hide-xs">用已有帐号登入</a>
        </div>
    </div>
</div>

<script src="layui/layui.js"></script>
<script src="lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script src="js/public.js"></script>
<script type="text/javascript">
    function register() {
        // 获取用户的输入
        var id = $('#LAY-user-login-id').val();
        var name = $('#LAY-user-login-name').val();
        var password = $('#LAY-user-login-password').val();
        var repass = $('#LAY-user-login-repass').val();
        var age = $('#LAY-user-login-age').val();
        var sex = $('input[name="sex"]:checked').val(); //单选框不能直接通过jequery的#使用获取Id的方法获取值
        var phone = $('#LAY-user-login-phone').val();
        var college = $('#LAY-user-login-college').val();
        var entity = $('input[name="entity"]:checked').val(); //单选框不能直接通过jequery的#使用获取Id的方法获取值
        var position = $('#LAY-user-login-position').val();
        var teacherId = $('#LAY-user-login-teacherId').val();
        var classes = $('#LAY-user-login-classes').val();
        var createDate = nowTime();
        // alert(id+","+createDate+","+password+","+repass+","+age+","+sex+","+phone+","+college+","+entity+","+position+","+teacherId+","+classes);

        // 判断密码和确认密码是否相同
        if (password !== repass) {
            layer.msg('两次密码不相同，请重新设置！！', {icon: 5});
        } else {
            $.ajax({
                type: 'post',
                url: 'CheckRegisterServlet',
                data: {
                    'id': id,
                    'name': name,
                    'password': password,
                    'repass': repass,
                    'age': age,
                    'sex': sex,
                    'phone': phone,
                    'college': college,
                    'entity': entity,
                    'position': position,
                    'teacherId': teacherId,
                    'classes': classes,
                    'createDate': createDate
                },
                datatype: 'text',
                success: function (res) {
                    if (res === "success") {
                        layer.msg('注册成功！', {icon: 6});
                        setTimeout(function () {
                            window.location.href = "LoginServlet"; //注册成功1500ms后跳转到登录页面
                        }, 1500)
                    } else {
                        layer.msg('该用户已存在，请尝试登录！', {icon: 5});
                    }
                }
            })
        }
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
