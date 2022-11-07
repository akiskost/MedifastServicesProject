<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Medifast - Login</title>
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
                        <br>
                        <div class="text-xl-center h5 mb-4 font-weight-bold">${message}</div>
                        <br>
<%--                        Remember me link--%>
<%--                        <div class="checkbox mb-2">--%>
<%--                            <label>--%>
<%--                                <input type="checkbox" value="remember-me"> Remember me--%>
<%--                            </label>--%>
<%--                        </div>--%>
                        <button type="submit" class="btn btn-lg btn-primary btn-block" >Sign in</button>
                    </form>
                    <br>
<%--                    Lost your password link  --%>
<%--                    <div class="col-md text-center">--%>
<%--                        <a href="#">Lost your password?</a>--%>
<%--                    </div>--%>
<%--                    <br>--%>
<%--                    Sign Up link --%>
<%--                    <div class="col-md text-center">--%>
<%--                        <p>Don't have an account? <a href="#">Sign up here!</a></p>--%>
<%--                    </div>--%>
                </div>


            </div>
        </div>
</section>


<div class=container>
    <c:if test="${error}">
        <p>Login Error</p>
    </c:if>
</div>

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
</footer><!-- footer part end-->

<div class="center">
    <c:if test="${sqlError}">
        <p>Error in insert. Please try again</p>
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

