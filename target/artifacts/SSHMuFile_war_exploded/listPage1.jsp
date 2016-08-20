<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/15
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        li{list-style:none;display:inline;margin-left: 5px;}

    </style>
    <script src="/uploadify/jquery-1.8.3.js" type="text/javascript"></script>
</head>
<body>

<table id="lyc">
    <tr>
        <th>name</th>
        <th>desc</th>
        <th>down</th>
    </tr>

    <%--<s:iterator value="#request.pageModel.datas" var="l">
    <tr>
        <td>${l.name}</td>
        <td>${l.description}</td>
        <td>
            <s:iterator value="#l.files" var="f">
                <ul>
                    <li>
                            ${f.fileName}
                        <a href="/servlet/Down?path=${f.filePath}&fileName=${f.fileName}">下载</a>

                    </li>
                </ul>
            </s:iterator>
        </td>
        </s:iterator>
    </tr>--%>
</table>
<form action="listPage1.action" method="post" id="formId">
    <div>${page1}</div>
</form>

<%--<div>${page2}</div>
<div>${page3}</div>
<div>${page4}</div>--%>
<script type="text/javascript">

    var v =   $("input[name=targetPage]").val();//
    var v1 =  document.all("pageSize",0).value;

    console.log(v);
</script>
</body>
</html>
