<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<jsp:include page="../form/main_menu_selector.jsp"/>
<link rel="stylesheet" href="css/create_user.css">
</head>
<body>
<p style="color: black">${info}</p>
<div class="create_user">
<h3 align="center">Create new user:</h3><br>
<form action="${pageContext.request.contextPath}/create_user" method="post">
  <label for="email">Email:</label><br>
  <input type="text" id="email" placeholder="Enter email:" name="email" required="required"><br>
  <label for="password">Password:</label><br>
  <input type="text" id="password" placeholder="Enter password:" name="password" required="required"><br>
    <label for="status">Status:</label><br>
     <select id="status" name="status" required="required">
      <option value="">Choose status:</option>
      <option value="Active">Active</option>
      <option value="Inactive">Inactive</option>
    </select><br><br>
    <label for="role">Role:</label><br>
    <select id="role" name="role" required="required">
    <option value="">Choose role:</option>
    <option value="Administrator">Administrator</option>
    <option value="Dispatcher">Dispatcher</option>
    <option value="Driver">Driver</option>
  </select><br><br><br>
    <input type="submit" value="Submit">
</form>
</div>
</body>
</html>