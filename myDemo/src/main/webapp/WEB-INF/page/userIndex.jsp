<!doctype html>
<html lang="zh">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/public/public.jsp" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户中心</title>

<link rel="stylesheet" type="text/css" href="${basePath }common/datatables/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="${basePath }common/datatables/css/dataTables.jqueryui.css">
<link rel="stylesheet" type="text/css" href="${basePath }common/datatables/css/jquery-ui.css">
<script src="${basePath }common/datatables/js/jquery.dataTables.min.js" type="text/javascript"></script>
<%-- <script src="${basePath }common/pagejs/userIndex.js" type="text/javascript"></script> --%>

</head>
<body>

<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th></th>
                <th>用户名</th>
                <th>邮箱</th>
                <th>创建时间</th>
                <th>电话号码</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${fUsersList}" var="fUsers">
            <tr>
                <td></td>
                <td>${fUsers.userName}</td>
                <td>${fUsers.email}</td>
                <td><fmt:formatDate value="${fUsers.creditTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${fUsers.loginName}</td>
            </tr>
          </c:forEach>
        </tbody>
    </table>

<script>
$(document).ready(function() {
    $('#example').dataTable( {
        "scrollY":        "200px",
        "scrollCollapse": true,
        "jQueryUI":       true,
        "targets": 0,
       "pagingType":   "full_numbers", 
        "language": {
                 "lengthMenu": "每页 _MENU_ 条记录",
                 "zeroRecords": "没有找到记录",
                 "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                 "infoEmpty": "无记录",
                 "infoFiltered": "(从 _MAX_ 条记录过滤)",
             },
    } );
} );
</script>

</body>
</html>