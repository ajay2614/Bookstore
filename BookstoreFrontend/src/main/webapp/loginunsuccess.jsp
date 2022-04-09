<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginUnsuccessful</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
</head>
<body>
<div id="div3" class="alert alert-secondary" role="alert">
  <h1 id="lus">Authentication Unsuccessfull</h1>
  <h4 id="lus1">Sorry, the entered Username does not match the Password</h4>
  <form action="logout" method="post">
  <button class="btn btn-warning" id="lus2">Try Again</button>
  </form>
</div>
</body>
</html>