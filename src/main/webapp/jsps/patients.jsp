<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patients</title>
</head>
<body>

    <div>
        <table>

            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Phone number</th>
                <th>AMKA</th>
                <th>ID Number</th>
                <th>Delete</th>
                <th>Update</th>
                <th>View</th>
            </tr>

            <c:forEach var = "patient" items="${patients}">
                <tr>
                    <td>${patient.id}</td>
                    <td>${patient.fname}</td>
                    <td>${patient.lname}</td>
                    <td>${patient.address}</td>
                    <td>${patient.phonenumber}</td>
                    <td>${patient.amka}</td>
                    <td>${patient.idno}</td>
                    <td><a href="${pageContext.request.contextPath}/delete?id=${patient.id}&fname=${patient.fname}&lname=${patient.lname}">Delete</a></td>
                    <td><a href="${pageContext.request.contextPath}/jsps/patientupdate.jsp?id=${patient.id}&fname=${patient.fname}&lname=${patient.lname}">Update</a></td>
                    <td><a href="${pageContext.request.contextPath}/jsps/patientsprofile.jsp?id=${patient.id}&fname=${patient.fname}&lname=${patient.lname}">View</a></td>
                </tr>
            </c:forEach>

        </table>

    </div>

    <div>
        <c:if test="${deleteAPIError}">
            <p>Something went wrong with Delete</p>
        </c:if>
    </div>

    <div>
        <c:if test="${updateAPIError}">
            <p>Something went wrong with Update</p>
        </c:if>
    </div>


</body>
</html>