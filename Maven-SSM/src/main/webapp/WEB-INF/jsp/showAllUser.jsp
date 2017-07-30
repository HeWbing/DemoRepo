<%--
  Created by IntelliJ IDEA.
  User: Zhangxq
  Date: 2016/7/16
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
    <c:if test="${!empty userList}">
        <c:forEach var="user" items="${userList}">
            ID：${user.id} &nbsp;&nbsp;姓名：${user.userName} &nbsp;&nbsp;<br>
            性别：${user.sex} &nbsp;&nbsp;年龄：${user.age} &nbsp;&nbsp;<br>
            生日：${user.birthday} &nbsp;&nbsp;<br><br>
        </c:forEach>
    </c:if>
</body>
</html>
