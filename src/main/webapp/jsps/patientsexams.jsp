<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>patients Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/patientsmenu.css">
</head>
<body>
    <div class="center">
        
        <div class="insert-wrapper">
	        <div class="bot-gap">
	            <span class="title">New Exam for patient</span>
	        </div>
	        <div class="bot-gap">
	            <form method="GET" action="${pageContext.request.contextPath}/insertexam>
	                <input name="lastname" type="text" class="insert rounded" placeholder="Last name" autofocus/><br>
	                <input name="firstname" type="text" class="insert rounded" placeholder="First name"/>
	                <br><br>
	                <button class="search-btn rounded color-btn" type="submit">Insert</button>
	            </form>
	        </div>
        </div>


    </div>
    
    <div class="center">
    	<c:if test="${sqlError}">
    		<p>Error in insert. Please try again</p>
    	</c:if>
    </div>
    
     <div class="center">
    	<c:if test="${patientsNotFound}">
    		<p>No patients found</p>
    	</c:if>
    </div>
</body>
</html>
        
    