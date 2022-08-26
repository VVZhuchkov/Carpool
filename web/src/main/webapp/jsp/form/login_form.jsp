<img src="img/company_logo.png" alt="VZ" width="10%" height="12%">
<form action="${pageContext.request.contextPath}/login" method="post">
  <div class="row">
    <label for="email">Email</label>
    <input type="email" name="email" autocomplete="off">
  </div>
  <div class="row">
    <label for="password">Password</label>
    <input type="password" name="password">
  </div>
  <button type="submit">Login</button>
</form>
<p style="color: red">${error}</p>