<%--
  Created by IntelliJ IDEA.
  User: 康小康
  Date: 2022/1/12
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ldms.pojo.*" %>

<html>
<head>
    <meta charset="utf-8">
    <title>基本资料</title>
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
<div class="layuimini-container" lay-filter="AdminInfo" id="AdminInfo">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label">学生ID</label>
                <div class="layui-input-block">
                    <input type="text" name="id" id="id" value=<%=id %> class="layui-input" readonly="true">
                    <tip>学生ID不可修改。</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" id="password" value=<%=password %> class="layui-input"
                           readonly="true">
                    <tip>密码不可修改。</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学生姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="name" id="name" value=<%=name %> lay-reqtext="学生姓名不能为空"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-block">
                    <input type="text" name="age" id="age" value=<%=age %> lay-reqtext="年龄不能为空"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">联系方式</label>
                <div class="layui-input-block">
                    <input type="text" name="phone" id="phone" value=<%=phone %> lay-reqtext="联系方式不能为空"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">辅导员ID</label>
                <div class="layui-input-block">
                    <input type="text" name="teacherId" id="teacherId" value=<%=teacherId %> lay-reqtext="辅导员ID不能为空"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">班级</label>
                <div class="layui-input-block">
                    <input type="text" name="classes" id="classes" value=<%=classes %> lay-reqtext="班级不能为空"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">所属学院</label>
                <div class="layui-input-block">
                    <input type="text" name="college" id="college" value=<%=college %> lay-reqtext="所属学院不能为空"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户注册时间</label>
                <div class="layui-input-block">
                    <input type="text" name="createDate" id="createDate" value=<%=createDate %> class="layui-input"
                           readonly="true">
                    <tip>用户注册时间不可修改。</tip>
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="saveBtn" onclick="save()">
                        确认保存
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../layui/layui.js"></script>
<script src="../../../lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script src="../../../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    /**
     * 修改个人信息
     */
    function save() {
        // 获取文本框里的内容
        var id = $('#id').val();
        var name = $('#name').val();
        var password = $('#password').val();
        var age = $('#age').val();
        var phone = $('#phone').val();
        var teacherId = $('#teacherId').val();
        var classes = $('#classes').val();
        var college = $('#college').val();

        $.ajax({
            url: 'http://localhost:8080/EditStudentServlet?id=' + id + '&name=' + name + '&password=' + password + '&age=' + age + '&phone=' + phone + '&teacherId=' + teacherId + '&classes=' + classes + '&college=' + college,
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            dataType: 'text',
            data: {
                'id': id,
                'name': name,
                'password': password,
                'age': age,
                'phone': phone,
                'teacherId': teacherId,
                'classes': classes,
                'college': college
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

</script>


</body>
</html>