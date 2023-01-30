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
        Admin admin = (Admin) session.getAttribute("admin");
        String id = admin.getId();
        String name = admin.getName();
        String password = admin.getPassword();
        String phone = admin.getPhone();
        String createDate = admin.getCreateDate();
    %>

</head>
<body>
<div class="layuimini-container" lay-filter="AdminInfo" id="AdminInfo">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label">管理员ID</label>
                <div class="layui-input-block">
                    <input type="text" name="id" id="id" value=<%=id %> class="layui-input" readonly="true">
                    <tip>管理员ID不可修改。</tip>
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
                <label class="layui-form-label">管理员姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="name" id="name" value=<%=name %> lay-reqtext="管理员姓名不能为空"
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
                    <input type="text" name="createDate" id="createDate" value=<%=createDate %> lay-reqtext="联系方式不能为空"
                           class="layui-input" readonly="true">
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
        var phone = $('#phone').val();

        $.ajax({
            url: 'http://localhost:8080/EditAdminServlet?id=' + id + '&name=' + name + '&password=' + password + '&phone=' + phone,
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            dataType: 'text',
            data: {
                'id': id,
                'name': name,
                'password': password,
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