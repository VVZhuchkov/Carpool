<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
</head>
<body>
<center>
<h3>Login</h3>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email">email</label>
    <input id="email" type="test" name="email"> <br/>
    <label for="password">password</label>
    <input id="password" type="password" name="password"><br/>
    <input type="submit">
</form>
<p style="color: red">${error}</p>
</center>
</body>
</html>