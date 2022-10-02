<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Επιτυχής Εισαγωγή</title>
</head>
<body>
	<h1>Teacher inserted successfully</h1>
	<div>
		<p>${insertedteacher.fname}</p>
		<p>${insertedteacher.sname}</p>
	</div>
	
	<a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Επιστροφή στο Μενού</a>
</body>
</html>