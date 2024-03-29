<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <jsp:include page="../form/main_menu_selector.jsp"/>
</head>
<body>
<h3 align="center">Watch our autopark:</h3>
        <c:if test="${allCars != null}">
            <jsp:include page="../form/main_tabstl.jsp" />
            <table align="center">
                <tr>
                    <th>Car<br>ID</th>
                    <th>Photo</th>
                    <th>Brand</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>Engine</th>
                    <th>Price<br>per day,<br>€</th>
                    <th>Location</th>
                </tr>
                <c:forEach items="${allCars}" var="car">
                    <tr>
                        <td><a name="${car.id}"
                               href="${pageContext.request.contextPath}/payment#${car.id}">${car.id}</a></td>
                        <td> <img src="${car.photo}" height="152" width="225"></td>
                        <td>${car.brand}</td>
                        <td>${car.model}</td>
                        <td>${car.year}</td>
                        <td>${car.engine}</td>
                        <td>${car.price}</td>
                        <td>${car.location}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
</body>
</html>