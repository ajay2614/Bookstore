<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.model.Books" %>
<%@page import="com.model.Authors" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
</head>
<body id="outputbody">
<div class="hf">
</div>
<div id="refreshid">
<form action="add" method="post">
<button class="btn btn-primary" id="refresh">Add Book</button>
</form>
</div>
<div id="logout3">
<form action = "logout" method="post">
<button class="btn btn-secondary" id="logou2">Logout</button>
</form>
</div>
<div id="div4">
<h3 id="hb">
Books Listing
</h3>
</div>
<div id="div5">
<table class="table table-bordered" id="table">
		<tr>
		<th>
		Book Code
		</th>
		<th>
		Book Name
		</th>
		<th>
		Author
		</th>
		<th>
		Date Added
		</th>
		<th>
		Actions
		</th>
		</tr>
		<%List<Books> book = (List<Books>) request.getAttribute("listbooks");
		if(book!=null){
			for(Books d: book){
		%>
		<tr>
		<td><%=d.getId() %>
		</td>
		<td><%=d.getName() %>
		</td>
		<td><%=d.getAuthor().getName() %>
		</td>
		<td><%=d.getDate() %>
		</td>
		<td>
		<form action="edit" method="post">
		<input type="hidden" name="hid" value="<%=d.getId() %>">
		<input type="hidden" name="hdate" value="<%=d.getDate() %>">
		<button class="btn btn-info" id="editid">Edit</button>
		</form>
		<form action="delete" method="post">
		<input type="hidden" name="hid" value="<%=d.getId() %>">
		<button class="btn btn-danger" id="deleteid">Delete</button>
		</form>
		</td>
		</tr>
		<%}} %>
		</table>
		</div>
		 <footer>
        <p>
          Copyright 2020-2021
        </p>
      </footer>
</body>
</html>