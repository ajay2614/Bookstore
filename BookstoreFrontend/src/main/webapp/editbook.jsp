<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.model.Books" %>
<%@page import="com.model.Authors" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
<div id="logout3">
<form action = "logout" method="post">
<button class="btn btn-secondary" id="logou2">Logout</button>
</form>
</div>
<div id="div4">
<h3>
AVAILABLE Authors
</h3>
</div>
<div id="div1">
		<form action="<%=request.getContextPath()%>/editbook" method="post">
				<div class="form-group row" id="bookid">
				<div id="bookdidlabel">
				<h5>Book Code</h5>
				</div>
						<input type="number" class="form-control" id="inputId" name="bookid" value="<%=request.getAttribute("bookid") %>"
						readonly>
				</div>
				<div class="form-group row" id="bookname">
				<div id="booknamelabel">
				<h5>Book Name</h5>
				</div>
						<input class="form-control" id="inputName" placeholder="Enter Book Name" name="bookname" type="text" required>
				</div>
				<div class="form-group row" id="bookauthor">
				<div id="bookauthorlabel">
				<h5>Book Author</h5>
				</div>
				<select name="authors" class="form-select" id="inputbookauthor">
				<%List<Authors> author = (List<Authors>) request.getAttribute("listauthors");
				if(author!=null){
				for(Authors a: author){
				%>
				<option value="<%=a.getId() %>">
				<%=a.getName() %>
				</option>
				<%}} %>
				</select>
				</div>
				<div class="form-group row" id="bookdate">
				<div id="bookdatelabel">
				<h5>Book Date</h5>
				</div>
				<input class="form-control" id="inputBookDate" name="bookdate" value="<%= request.getAttribute("date") %>" readonly>
				</div>
			<button type="submit" class="btn btn-success" id="btnls">Submit Details</button>
		</form>
		</div>
		<div id="cenceldiv">
		<form action="cancel" method="post">
		<button type="submit" class="btn btn-danger" id="cancelbtn">Cancel</button>
		</form>
		</div>
		 <footer id="footer">
        <p>
          Copyright 2020-2021
        </p>
      </footer>
</body>
</html>