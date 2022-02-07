<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Please log in</h1>
<form action="/login" method="post">
    <table style="with: 50%">
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table>
    <input type="submit" value="Submit"/></form>
</body>
</html>
