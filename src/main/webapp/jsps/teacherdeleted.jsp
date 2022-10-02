<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <p>Teacher: ${teacher.id} ${teacher.fname} ${teacher.sname}</p>
    <a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Επιστροφή</a>

</body>
</html>