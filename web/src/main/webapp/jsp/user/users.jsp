<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<jsp:include page="../form/main_menu_selector.jsp"/>
</head>
<body>
<h3 align="center">All users are here:</h3>
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