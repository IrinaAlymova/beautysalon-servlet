<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Our Services</title>
</head>
<body>
<table>
    <c:forEach items="${allServices}" var="service">
        <tr>
            <td>${service.name}</td>
            <td>${service.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
