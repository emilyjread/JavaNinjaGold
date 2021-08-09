<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Ninja Gold</title>
</head>
<body>
<a href="/reset">Reset</a>
<h1>Your gold: <c:out value="${gold}"/></h1>

<div class="locs">
	<div class="location">
		<h1>Farm</h1>
		<p>Earns 10-20 gold</p>
		<form method="POST" action="/mine">
			<input type="hidden" name= "location" value="farm"> 
			<input type="submit" value="Find Gold">
		</form>
	</div>
	<div class="location">
		<h1>Cave</h1>
		<p>Earns 5-10 gold</p>
		<form method="POST" action="/mine">
			<input type="hidden" name= "location" value="cave"> 
			<input type="submit" value="Find Gold">
		</form>
	</div>
	<div class="location">
		<h1>House</h1>
		<p>Earns 2-5 gold</p>
		<form method="POST" action="/mine">
			<input type="hidden" name= "location" value="house"> 
			<input type="submit" value="Find Gold">
		</form>
	</div>
	<div class="location">
		<h1>Casino!</h1>
		<p>Earns/takes 0-50 gold</p>
		<form method="POST" action="/mine">
			<input type="hidden" name= "location" value="casino"> 
			<input type="submit" value="Find Gold">
		</form>
	</div>
	<div class="location">
		<h1>Spa</h1>
		<p>Takes 5-20 gold</p>
		<form method="POST" action="/mine">
			<input type="hidden" name= "location" value="spa"> 
			<input type="submit" value="Treat yo'self">
		</form>
	</div>
</div>
	<div class= "activities">
		<c:forEach var="act" items="${activities}">
			<p><c:out value="${act}"></c:out></p>
		</c:forEach>
	</div>
</body>
</html>