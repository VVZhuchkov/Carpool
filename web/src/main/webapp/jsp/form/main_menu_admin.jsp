<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="page">
<nav>
  <ul class="menu">
    <li class="dropdown"><a href="${pageContext.request.contextPath}/users" class="dropbtn">Users</a>
                <div class="dropdown-content">
                  <a href="#">Create</a>
                  <a href="#">Update</a>
                  <a href="#">Delete</a>
                </div>
                </li>
    <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Employees</a>
        <div class="dropdown-content">
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
          <a href="#">Link 3</a>
        </div>
        </li>
    <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Park</a>
         <div class="dropdown-content">
           <a href="#">Link 1</a>
           <a href="#">Link 2</a>
           <a href="#">Link 3</a>
         </div>
         </li>
     <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Orders</a>
          <div class="dropdown-content">
            <a href="#">Link 1</a>
            <a href="#">Link 2</a>
            <a href="#">Link 3</a>
          </div>
          </li>
   <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Routes</a>
        <div class="dropdown-content">
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
          <a href="#">Link 3</a>
        </div>
        </li>
    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
  </ul>
</nav>
</div>