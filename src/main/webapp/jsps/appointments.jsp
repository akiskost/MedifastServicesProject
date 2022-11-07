<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Medifast - Appointment Search</title>
    <link rel="icon" href="${pageContext.request.contextPath}/static/img/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap-table.min.css">

    <!-- animate CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/owl.carousel.min.css">
    <!-- themify CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/themify-icons.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/flaticon.css">
    <!-- magnific popup CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/magnific-popup.css">
    <!-- nice select CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/nice-select.css">
    <!-- swiper CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/slick.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>

<body>
<c:choose>
<c:when test="${not empty user}">


<!--::header part start::-->
<header class="main_menu home_menu">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/jsps/home.jsp">
                        <img src="${pageContext.request.contextPath}/static/img/logo.png" alt="logo"> </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse main-menu-item justify-content-center"
                         id="navbarSupportedContent">
                        <ul class="navbar-nav align-items-center">
                            <li class="nav-item active">
                                <a class="nav-link" href="${pageContext.request.contextPath}/jsps/home.jsp">Home</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                                   role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Patients
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item nav-link" href="${pageContext.request.contextPath}/search">Search for Patients</a>
                                    <a class="dropdown-item nav-link" href="${pageContext.request.contextPath}/jsps/newpatient.jsp">Add New Patient</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
                                   role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Appointments
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item nav-link" href="${pageContext.request.contextPath}/appointmentsearch">Search Appointments</a>
                                    <a class="dropdown-item nav-link" href="${pageContext.request.contextPath}/newappointment">New Appointment</a>

                                </div>
                            </li>




                        </ul>
                    </div>
                    <a class="btn_2 d-none d-lg-block" href="${pageContext.request.contextPath}/logout">Logout</a>
                </nav>
            </div>
        </div>
    </div>
</header>
<!-- Header part end-->

<!-- main-->
<section class="about_us_text padding_top">
    <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-xl-12">
                <div class="depertment_content">
                    <div class="row justify-content-center">
                        <div class="col-xl">
                            <h2>Appointment Search</h2>
                            <br>
                            <table id="app_table" class="table table-striped table-bordered" style="width:100%">
                                <thead>
                                <tr>
                                    <th>Appoint. No.</th>
                                    <th>Patient ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Date</th>
                                    <th>Exam</th>
                                    <th>Result</th>
                                    <th>Reschedule</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var = "appointment" items="${appointments}">
                                    <tr>
                                        <td>${appointment.apid}</td>
                                        <td>${appointment.pid}</td>
                                        <td>${appointment.fname}</td>
                                        <td>${appointment.lname}</td>
                                        <td>${appointment.date}</td>
                                        <td>${appointment.exam}</td>
                                        <td>${appointment.result}</td>
                                        <td><a id="${appointment.apid}" href="${pageContext.request.contextPath}/jsps/appointmentreschedule.jsp?pid=${appointment.pid}&apid=${appointment.apid}&firstname=${appointment.fname}&lastname=${appointment.lname}&date=${appointment.date}&exam=${appointment.exam}&result=${appointment.result}">Reschedule</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th>Appoint. No.</th>
                                    <th>Patient ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Date</th>
                                    <th>Exam</th>
                                    <th>Result</th>
                                    <th>Reschedule</th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
    <!-- main-->

</c:when>
    <c:otherwise>
        <section class="our_depertment padding_top padding_bottom">
            <div class="container">
                <div class="row justify-content-center text-center">
                    <div class="col-xl-4">
                        <form method="POST" action="${pageContext.request.contextPath}/login" class="form-signin">
                            <img class="mb-4" src="${pageContext.request.contextPath}/static/img/logolarge.png" alt="" width="72" height="72">
                            <h1 class="h3 mb-4 font-weight-bold">Please sign in</h1>
                            <div class="form-group">
                                <input type="text" name="email" class="form-control mb-3" placeholder="Email address" required autofocus>
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control mb-3" placeholder="Password" required>
                            </div>
                            <br>${message}
                            <div class="checkbox mb-2">
                                <label>
                                    <input type="checkbox" value="remember-me"> Remember me
                                </label>
                            </div>
                            <button type="submit" class="btn btn-lg btn-primary btn-block" >Sign in</button>
                        </form>
                        <br>
                        <div class="col-md text-center">
                            <a href="#">Lost your password?</a>
                        </div>
                        <br>
                        <div class="col-md text-center">
                            <p>Don't have an account? <a href="#">Sign up here!</a></p>
                        </div>
                    </div>


                </div>
            </div>
        </section>
    </c:otherwise>
</c:choose>


<!-- footer part start-->
<footer class="footer-area fixed-bottom">
    <div class="footer section-top-border ">
        <div class="container">
            <div class="row justify-content-center text-center">
                <div class="col-xl-2 col-md-4 col-sm-6 single-footer-widget">
                    <a href="#" class="footer_logo"> <img src="${pageContext.request.contextPath}/static/img/logo.png" alt="#"> </a>
                    <div class="social_logo justify-content-center">
                        <a href="#"><i class="ti-facebook"></i></a>
                        <a href="#"> <i class="ti-twitter"></i> </a>
                        <a href="#"><i class="ti-instagram"></i></a>
                        <a href="#"><i class="ti-skype"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- footer part end-->

<!-- jquery plugins here-->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<!-- owl carousel js -->
<script src="${pageContext.request.contextPath}/static/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.nice-select.min.js"></script>
<!-- custom js -->
<script src="${pageContext.request.contextPath}/static/js/custom.js"></script>
<!-- table js -->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap5.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-table.min.js"></script>
<script>
    $(document).ready(function () {
        $('#app_table').DataTable()
    });
</script>

<%-- //bootstrap method to get data on page load--%>

<script>
    var data = ${appointments};
    data_json=JSON.parse(data);
    $('#appointments').bootstrapTable({
        data: data_json
    });
</script>

</body>

</html>