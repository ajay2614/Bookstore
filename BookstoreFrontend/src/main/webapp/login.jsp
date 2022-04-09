<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

</head>
<body id="loginbody">
<div class="hf">
</div>
 <div class="container col-md-8 col-md-offset-3" id="login" style="overflow: auto">
 <div id="lh1"><h1 id="loh1">Login Form</h1></div>
  <form action="<%=request.getContextPath()%>/login" method="post" id="loginform" onsubmit="return f1()">
   <div class="form-group">
    <label for="uname">UserName:</label> 
    <input type="text"
     class="form-control" id="username" placeholder="Username"
     name="username" required>
   </div>
   <div class="form-group">
    <label for="uname">Password:</label> 
    <input type="password"
     class="form-control" id="password" placeholder="Password"
     name="password" required>
   </div>
   <button type="button" class="btn btn-primary" id="btnl" onclick="fn1()">Login</button>
  </form>
 </div>
 <footer>
        <p>
          Copyright 2020-2021 
        </p>
      </footer>
</body>
<script src="<c:url value="/resources/js/index.js" />"></script>
</html>