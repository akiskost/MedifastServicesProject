<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Επιτυχής Εισαγωγή</title>
</head>
<body>
	<h1>patient inserted successfully</h1>
	<div>
		<p>${insertedpatient.fname}</p>
		<p>${insertedpatient.lname}</p>
	</div>
	
	<a href="${pageContext.request.contextPath}/jsps/patientsmenu.jsp">Επιστροφή στο Μενού</a>
</body>
</html>