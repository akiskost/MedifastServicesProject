<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Medifast - Update Patient</title>
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
<section class="our_depertment section_padding single_pepertment_page padding_bottom">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-12">
                <div class="depertment_content">
                    <div class="row justify-content-center text-left">
                        <div class="col-xl-4">
                            <h3>Update Patient Information</h3>
                            <br>
                            <form method="GET" action="${pageContext.request.contextPath}/update">
                                <div class="form-group">
                                    <input name="pid" type="text" class="form-control" id="forminp1" value="${param.pid}" readonly >
                                </div>
                                <div class="form-group">
                                    <input name="firstname" type="text" class="form-control" id="forminp2" placeholder="First Name" value="${param.firstname}">
                                </div>
                                <div class="form-group">
                                    <input name="lastname" type="text" class="form-control" id="forminp3" placeholder="Last Name" value="${param.lastname}">
                                </div>
                                <div class="form-group">
                                    <input name="address" type="text" class="form-control" id="forminp4" placeholder="Address" value="${param.address}">
                                </div>
                                <div class="form-group">
                                    <input name="phonenumber" type="text" class="form-control" id="forminp5" placeholder="Phone Number" value="${param.phonenumber}">
                                </div>
                                <div class="form-group">
                                    <input name="amka" type="text" class="form-control" id="forminp6" placeholder="AMKA" value="${param.amka}">
                                </div>
                                <div class="form-group">
                                    <input name="idno" type="text" class="form-control" id="forminp7" placeholder="ID Number" value="${param.idno}">
                                </div>

                                <button type="submit" id="submit-button" class="btn btn-primary" > Update Information </button>
                            </form>
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
                            <button type="submit" class="btn btn-lg btn-primary btn-block" >Sign in</button>
                        </form>
                        <br>
                    </div>


                </div>
            </div>
        </section>
    </c:otherwise>
</c:choose>

<!-- footer part start-->
<footer class="footer-area single-footer-widget">
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

<%--<script>--%>
<%--    $(function() {--%>
<%--        $("#submit").click(function() {--%>
<%--            if($("#firstname").val() !="" && $("#lastname").val() !="") {--%>
<%--                $('#exampleModal').modal('show');--%>
<%--                // $(this).closest("form").submit();--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

<%--<script>--%>
<%--    $(document).on('click', '#submit-button', function(e){--%>
<%--        if($("#firstname").val() != null){--%>
<%--            $("#exampleModal").show();--%>
<%--        }--%>
<%--    });--%>
<%--</script>--%>
</body>

</html>