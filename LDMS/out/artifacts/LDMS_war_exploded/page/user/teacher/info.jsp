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
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        String id = teacher.getId();
        String teacherId = teacher.getTeacherId();
        String name = teacher.getName();
        String password = teacher.getPassword();
        String age = teacher.getAge();
        String sex = teacher.getSex();
        String college = teacher.getCollege();
        String position = teacher.getPosition();
        String phone = teacher.getPhone();
        String createDate = teacher.getCreateDate();
    %>

</head>
<body>
<div class="layuimini-container" lay-filter="AdminInfo" id="AdminInfo">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label">教师ID</label>
                <div class="layui-input-block">
                    <input type="text" name="id" id="id" value=<%=id %> class="layui-input" readonly="true">
                    <tip>教师ID不可修改。</tip>
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
                <label class="layui-form-label">教师姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="name" id="name" value=<%=name %> lay-reqtext="教师姓名不能为空"
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
                <label class="layui-form-label">所属学院</label>
                <div class="layui-input-block">
                    <input type="text" name="college" id="college" value=<%=college %> lay-reqtext="所属学院不能为空"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">职位</label>
                <div class="layui-input-block">
                    <input type="text" name="position" id="position" value=<%=position %> lay-reqtext="职位不能为空"
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
        var password = $('#password').val();
        var name = $('#name').val();
        var age = $('#age').val();
        var college = $('#college').val();
        var position = $('#position').val();
        var phone = $('#phone').val();

        $.ajax({
            url: 'http://localhost:8080/EditTeacherServlet?id=' + id + '&name=' + name + '&password=' + password + '&age=' + age + '&college=' + college + '&position=' + position + '&phone=' + phone,
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            dataType: 'text',
            data: {
                'id': id,
                'name': name,
                'password': password,
                'age': age,
                'college': college,
                'position': position,
                'phone': phone
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