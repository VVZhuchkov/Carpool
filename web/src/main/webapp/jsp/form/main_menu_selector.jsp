 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <script src="js/main_menu.js" type="text/javascript"></script>
  <c:if test="${role == 'administrator'}">
  <link rel="stylesheet" href="css/main_menu_admin.css">
 <jsp:include page="../form/main_menu_admin.jsp"/>
 </c:if>
  <c:if test="${role != 'administrator'}">
   <link rel="stylesheet" href="css/main_menu.css">
 <jsp:include page="../form/main_menu.jsp"/>
 </c:if>