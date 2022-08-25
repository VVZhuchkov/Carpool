<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel="stylesheet" href="css/main_menu.css">
 <script src="js/main_menu.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="../form/main_menu.jsp"/>

<h3 align="center">Users:</h3>
        <c:if test="${authUserList != null}">
            <jsp:include page="../form/main_tabstl.jsp" />
            <table align="center">
                <tr>
                    <th>Auth User ID</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Status</th>
                </tr>
                <c:forEach items="${authUserList}" var="authUser">
                    <tr>
                        <td>${authUser.id}</td>
                        <td>${authUser.email}</td>
                        <td>${authUser.password}</td>
                        <td>${authUser.status}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
</body>
</html>