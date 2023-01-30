<%--
  Created by IntelliJ IDEA.
  User: 康小康
  Date: 2022/1/19
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ldms.pojo.*" %>

<html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
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

<div class="layuimini-container">
    <div class="layuimini-main">
        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">教师ID</label>
                <div class="layui-input-block">
                    <input type="text" value=<%=id %> name="teacherId" id="teacherId" lay-verify="required" lay-reqtext="教师ID不能为空！"
                           placeholder=""
                           autocomplete="off" class="layui-input" readonly="true">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">实验室ID</label>
                <div class="layui-input-block">
                    <input type="text" name="laboratoryId" id="laboratoryId" lay-verify="required"
                           lay-reqtext="实验室ID不能为空！"
                           placeholder=""
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">使用日期</label>
                <div class="layui-input-block">
                    <input type="text" name="useDate" id="useDate" lay-verify="required" placeholder="请选择日期"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">开始使用时间</label>
                <div class="layui-input-block">
                    <input type="text" name="beginTime" id="beginTime" lay-verify="required" placeholder="请选择日期与时间"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">结束使用时间</label>
                <div class="layui-input-block">
                    <input type="text" name="endTime" id="endTime" lay-verify="required" placeholder="请选择日期与时间"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1" onclick="submit()"> 申 请</button>
                    <button type="reset" class="layui-btn layui-btn-primary" onclick="reset()"> 重 置</button>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="../../lib/layDate-v5.3.1/laydate/laydate.js"></script>
<script>
    // 使用日期
    laydate.render({
        elem: '#useDate'
    });
</script>
<script>
    // 开始使用时间
    laydate.render({
        elem: '#beginTime'
        , type: 'datetime'
    });
</script>
<script>
    // 结束使用时间
    laydate.render({
        elem: '#endTime'
        , type: 'datetime'
    });
</script>

<script src="../../js/public.js"></script>
<script src="../../layui/layui.js"></script>
<script src="../../lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script src="../../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<!-- 自定义规则 -->
<script>
    function submit() {
        // 获取文本框里的内容
        var laboratoryId = $('#laboratoryId').val();
        var teacherId = $('#teacherId').val();
        var useDate = $('#useDate').val();
        var beginTime = $('#beginTime').val();
        var endTime = $('#endTime').val();
        var state = '待审核';

        $.ajax({
            url: 'http://localhost:8080/AddLaboratoryUseServlet?laboratoryId=' + laboratoryId + '&teacherId=' + teacherId + '&useDate=' + useDate + '&beginTime=' + beginTime + '&endTime=' + endTime + '&state=' + state,
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            dataType: 'text',
            data: {
                'laboratoryId': laboratoryId,
                'teacherId': teacherId,
                'useDate': useDate,
                'beginTime': beginTime,
                'endTime': endTime,
                'state': state
            },
            success: function (res) {// 回调函数
                layer.msg('提交成功！', {icon: 6});
                setTimeout(function () {
                    reset();
                }, 1500)
            },
            error: function (res) {
                layer.msg('提交失败！', {icon: 5});
            }
        })

    }
</script>

</body>
</html>
