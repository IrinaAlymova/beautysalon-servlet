<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Your Bookings</title>
</head>
<body>
<table>
    <c:forEach items="${allBookings}" var="booking">
        <tr>
            <td>${booking.user}</td>
            <td>${booking.master}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
