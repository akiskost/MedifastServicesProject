<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/patientsmenu.css">

</head>
<body>

    <p>patient: ${patient.pid} ${patient.fname} ${patient.lname}</p>
    <a href="${pageContext.request.contextPath}/jsps/patientsmenu.jsp">Επιστροφή</a>

</body>
</html>