<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Medifast - Patient Profile</title>
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
<!--::header part start::-->
<header class="main_menu">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/jsps/home.jsp"> <img src="${pageContext.request.contextPath}/static/img/logo.png" alt="logo"> </a>
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
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/search">Patients Search</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/jsps/newpatient.jsp">Add New Patient</a>
                            </li>
                        </ul>
                    </div>
                    <a class="btn_2 d-none d-lg-block" href="${pageContext.request.contextPath}/index.jsp">Logout</a>
                </nav>
            </div>
        </div>
    </div>
</header>
<!-- Header part end-->

<!-- main-->
<section class="our_depertment section_padding single_pepertment_page">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-12">
                <div class="depertment_content">

                    <div class="row justify-content-center text-left">
                        <%--Patient Information Column--%>
                        <div class="col-xl-6">
                            <h3>Patient Information</h3>
                            <br>
                            <form method="GET" action="${pageContext.request.contextPath}/view">
                                <div class="form-group">
                                    <label for="forminp1">Patient ID</label>
                                    <input name="pid" type="text" class="form-control" id="forminp1" value="${param.pid}" readonly >
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="forminp2">First name</label>
                                        <input name="firstname" type="text" class="form-control" id="forminp2" value="${param.firstname}" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="forminp3">Last name</label>
                                        <input name="lastname" type="text" class="form-control" id="forminp3" value="${param.lastname}"readonly>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="forminp4">Address</label>
                                        <input name="address" type="text" class="form-control" id="forminp4" value="${param.address}"readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="forminp5">Phone Number</label>
                                        <input name="phonenumber" type="text" class="form-control" id="forminp5" value="${param.phonenumber}"readonly>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="forminp6">AMKA</label>
                                        <input name="amka" type="text" class="form-control" id="forminp6" value="${param.amka}"readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="forminp7">ID Number</label>
                                        <input name="idno" type="text" class="form-control" id="forminp7" value="${param.idno}"readonly>
                                    </div>
                                </div>

<%--                                button to redirect to edit patient--%>
<%--                                <a href="${pageContext.request.contextPath}/jsps/patientupdate.jsp?pid&firstname=${patient.fname}&lastname=${patient.lname}&address=${patient.address}&phonenumber=${patient.phonenumber}&amka=${patient.amka}&idno=${patient.idno}" class="btn btn-primary" aria-pressed="true">Update Patient Information</a>--%>



                            </form>
                        </div>
                        <%--Patient Exam History Column--%>
                        <div class="col-xl-6">
                            <h3>Patient Exam History</h3>
                            <br>
<%--
                            <form method="GET" action="${pageContext.request.contextPath}/view">
--%>
                            <div class="list-group">
                                <a href="#" class="list-group-item list-group-item-action active">
                                    Cras justo odio
                                </a>
                                <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in</a>
                                <a href="#" class="list-group-item list-group-item-action">Morbi leo risus</a>
                                <a href="#" class="list-group-item list-group-item-action">Porta ac consectetur ac</a>
                                <a href="#" class="list-group-item list-group-item-action disabled">Vestibulum at eros</a>
                            </div>
                                <%--                                button to redirect to edit patient--%>
                                <%--                                <a href="${pageContext.request.contextPath}/jsps/patientupdate.jsp?pid&firstname=${patient.fname}&lastname=${patient.lname}&address=${patient.address}&phonenumber=${patient.phonenumber}&amka=${patient.amka}&idno=${patient.idno}" class="btn btn-primary" aria-pressed="true">Update Patient Information</a>--%>



                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>
<!-- main-->

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

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Success!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ssssssssssssss
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
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