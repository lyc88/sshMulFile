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
</head>
<body>
<table id="lyc">
    <tr>
        <th>name</th>
        <th>desc</th>
        <th>down</th>
    </tr>

    <s:iterator value="#request.pageModel.datas" var="l">
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
    </tr>
</table>
<pg:pager url="listPage.action" items="${requestScope.pageModel.total}" export="currentPageNumber=pageNumber" maxPageItems="10">

    <pg:first><a href="${pageUrl}">首页</a></pg:first>
    <pg:prev><a href="${pageUrl}">上一页</a></pg:prev>
    <pg:pages>

        <c:choose>
            <c:when test="${currentPageNumber eq pageNumber}">
                <font color="red">${pageNumber}</font>
            </c:when>
            <c:otherwise>
                <a href="${pageUrl}">${pageNumber}</a>
            </c:otherwise>
        </c:choose>
    </pg:pages>
    <pg:next><a href="${pageUrl}">下一页</a></pg:next><pg:skip pages="${10}">跳转</pg:skip>
    <pg:last>
        <a href="${pageUrl}">尾页</a>
    </pg:last>
</pg:pager>
</body>
</html>
