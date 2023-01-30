<%--
  Created by IntelliJ IDEA.
  User: 康小康
  Date: 2022/1/18
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ldms.pojo.*" %>

<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../../lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../css/public.css" media="all">
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

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 75px">实验室ID</label>
                        <div class="layui-input-inline">
                            <input type="text" name="laboratoryId" id="laboratoryId" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 75px">使用日期</label>
                        <div class="layui-input-inline">
                            <input type="text" name="useDate" id="useDate" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-primary" lay-event="search" onclick="search()">
                            <i class="layui-icon"></i> 搜 索
                        </button>
                    </div>
                </div>
            </div>
        </fieldset>

        <%--        <script type="text/html" id="toolbarDemo">--%>
        <%--            <div class="layui-btn-container">--%>
        <%--                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加</button>--%>
        <%--                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除</button>--%>
        <%--            </div>--%>
        <%--        </script>--%>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <%--        <script type="text/html" id="currentTableBar">--%>
        <%--            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>--%>
        <%--            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>--%>
        <%--        </script>--%>

    </div>
</div>

<script src="../../../layui/layui.js"></script>
<script src="../../../lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script src="../../../lib/layui-v2.6.3/layui.js" charset="utf-8"></script>

<script>
    var id_ = <%=id %>;

    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
                form = layui.form,
                table = layui.table;
        var entity = 'teacher';
        var id = id_;

        table.render({
            elem: '#currentTableId',
            url: 'http://localhost:8080/LaboratoryUseListServlet?entity=' + entity + '&id=' + id,
            date: {
                'entity': entity,
                'id': id
            },
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            id: 'searchList',
            cols: [[
                // {type: "checkbox", width: 50},
                {field: 'laboratoryId', width: 200, title: '实验室ID', sort: true},
                // {field: 'teacherId', width: 140, title: '教师ID', sort: true},
                {field: 'useDate', width: 241, title: '使用日期', sort: true},
                {field: 'beginTime', width: 300, title: '开始使用时间', sort: true},
                {field: 'endTime', width: 300, title: '结束使用时间', sort: true},
                {field: 'state', width: 241, title: '申请状态'},
                // {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'
        });


        /**
         * 添加
         */
        // table.on('toolbar(currentTableFilter)', function (obj) {
        //     if (obj.event === 'add') {  // 监听添加操作
        //         var index = layer.open({
        //             title: '添加实验室使用信息',
        //             type: 2,
        //             shade: 0.2,
        //             maxmin: true,
        //             shadeClose: true,
        //             area: ['60%', '95%'],
        //             content: 'addLaboratoryUse.html',
        //         });
        //         $(window).on("resize", function () {
        //             layer.full(index);
        //         });
        //         // window.location.replace("listLaboratoryUse.html")
        //     } else if (obj.event === 'delete') {  // 监听删除操作
        //         var checkStatus = table.checkStatus('currentTableId')
        //                 , data = checkStatus.data;
        //         layer.alert(JSON.stringify(data));
        //     }
        // });


        /**
         * 表格复选框选择
         */
        // table.on('checkbox(currentTableFilter)', function (obj) {
        //     console.log(obj)
        // });


        /**
         * 修改和修改
         */
        // table.on('tool(currentTableFilter)', function (obj) {
        //     var data = obj.data;
        //     if (obj.event === 'edit') {
        //
        //         var index = layer.open({
        //             title: '编辑实验室使用信息',
        //             type: 2,
        //             content: 'editLaboratoryUse.html',
        //             maxmin: true,
        //             area: ['60%', '95%'],
        //             btn: ['确定', '取消'],
        //             yes: function (index, layero) {
        //                 // 回调的数值
        //                 var laboratoryId = $(layero).find('iframe')[0].contentWindow.laboratoryId.value;//只读
        //                 // var teacherId = $(layero).find('iframe')[0].contentWindow.document.getElementById('teacherId').value;
        //                 var useDate = $(layero).find('iframe')[0].contentWindow.document.getElementById('useDate').value;
        //                 var beginTime = $(layero).find('iframe')[0].contentWindow.document.getElementById('beginTime').value;
        //                 var endTime = $(layero).find('iframe')[0].contentWindow.document.getElementById('endTime').value;
        //
        //                 // 同步数据表个中的数据
        //                 obj.update({
        //                     'laboratoryId': laboratoryId,
        //                     // 'teacherId': teacherId,
        //                     'useDate': useDate,
        //                     'beginTime': beginTime,
        //                     'endTime': endTime
        //                 })
        //
        //                 // 使用ajax
        //                 $.ajax({
        //                     // 跳转到 EditLaboratoryServlet 里，将参数也传递进去
        //                     url: 'http://localhost:8080/EditLaboratoryUseServlet?laboratoryId=' + laboratoryId + '&useDate=' + useDate + '&beginTime=' + beginTime + '&endTime=' + endTime,
        //                     type: 'post',
        //                     contentType: 'application/json; charset=utf-8',
        //                     dataType: 'text',
        //                     data: {
        //                         'laboratoryId': laboratoryId,
        //                         // 'teacherId': teacherId,
        //                         'useDate': useDate,
        //                         'beginTime': beginTime,
        //                         'endTime': endTime
        //                     },
        //                     success: function (res) {// 回调函数
        //                         layer.msg('修改成功！');
        //                     },
        //                     error: function (res) {
        //                         layer.msg('修改失败！');
        //                     }
        //                 })
        //                 layer.close(index);// 关闭弹窗
        //             },
        //             success: function (layero, index) {// 将选中的数据放入弹出窗里
        //                 var div = layero.find('iframe').contents().find('#editLaboratoryUse');
        //                 var body = layer.getChildFrame('body', index);
        //                 var iframeWindow = window['layui-layer-iframe' + index];
        //                 body.find('#laboratoryId').val(data.laboratoryId);
        //                 // body.find('#teacherId').val(data.teacherId);
        //                 body.find('#useDate').val(data.useDate);
        //                 body.find('#beginTime').val(data.beginTime);
        //                 body.find('#endTime').val(data.endTime);
        //             }
        //         });
        //     } else if (obj.event === 'delete') {
        //         layer.confirm('是否删除该实验室使用记录？', function (index) {
        //             var laboratoryId = data.laboratoryId;
        //
        //             $.ajax({
        //                 url: 'http://localhost:8080/DeleteLaboratoryUseServlet?laboratoryId=' + laboratoryId,
        //                 type: 'post',
        //                 contentType: 'application/json; charset=utf-8',
        //                 dataType: 'text',
        //                 data: {
        //                     'laboratoryId': laboratoryId
        //                 }
        //             })
        //
        //             layer.close(index);
        //             window.location.replace("listLaboratoryUse.html")
        //         });
        //     }
        // });

    });
</script>
<script>
    /**
     * 搜索
     */
    function search() {
        var laboratoryId = $('#laboratoryId').val();
        var useDate = $('#useDate').val();
        var table = layui.table;
        var entity = 'teacher';
        var id = <%=id %>;

        table.reload('searchList', {
            url: 'http://localhost:8080/SearchLaboratoryUseServlet?laboratoryId=' + laboratoryId + '&useDate=' + useDate + '&entity=' + entity + '&id=' + id,
            where: {
                laboratoryId: laboratoryId,
                useDate: useDate,
                entity: entity,
                id: id
            }
        })

    }
</script>

</body>
</html>