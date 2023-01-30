<%--
  Created by IntelliJ IDEA.
  User: 康小康
  Date: 2022/1/11
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ldms.pojo.*" %>

<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../../lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../css/public.css" media="all">
    <style>
        .layui-form-item .layui-input-company {
            width: auto;
            padding-right: 10px;
            line-height: 38px;
        }
    </style>
    <%
        Student student = (Student) session.getAttribute("student");
        String id = student.getId();
        String studentId = student.getStudentId();
        String name = student.getName();
        String password = student.getPassword();
        String age = student.getAge();
        String sex = student.getSex();
        String phone = student.getPhone();
        String teacherId = student.getTeacherId();
        String classes = student.getClasses();
        String college = student.getCollege();
        String createDate = student.getCreateDate();
    %>

</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label">学生ID</label>
                <div class="layui-input-block">
                    <input type="text" name="id_" id="id_" value=<%=id %> class="layui-input" readonly="true">
                    <tip>学生ID不可修改。</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">旧的密码</label>
                <div class="layui-input-block">
                    <input type="text" name="old_password" id="old_password" value=<%=password %>
                            class="layui-input" readonly="true">
                    <tip>旧的密码不可修改。</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">新的密码</label>
                <div class="layui-input-block">
                    <input type="text" name="password" id="password" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">确认密码</label>
                <div class="layui-input-block">
                    <input type="text" name="again_password" id="again_password" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit onclick="save()">确认保存</button>
                    <button type="reset" class="layui-btn layui-btn-primary" onclick="reset()"> 重 置</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../layui/layui.js"></script>
<script src="../../../js/public.js"></script>
<script src="../../../lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script src="../../../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    /**
     * 修改密码
     */
    function save() {
        // 获取文本框里的内容
        var id = $('#id_').val();
        var password = $('#password').val();
        var again_password = $('#again_password').val();

        // 判断两次输入的密码是否一致
        if (password !== again_password) {
            layer.msg('两次密码不相同，请重新设置！！', {icon: 5});
        } else {
            $.ajax({
                url: 'http://localhost:8080/EditStudentPasswordServlet?id=' + id + '&password=' + password,
                type: 'post',
                contentType: 'application/json; charset=utf-8',
                dataType: 'text',
                data: {
                    'id': id,
                    'password': password
                },
                success: function (res) {// 回调函数
                    layer.msg('修改成功，即将退出系统，请重新登录！', {icon: 6}, function () {
                        window.location.href = '../../../index.jsp';
                    });
                },
                error: function (res) {
                    layer.msg('修改失败！', {icon: 5});
                }
            })
        }
    }

</script>

</body>
</html>