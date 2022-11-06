<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Medifast Services</title>
  <link rel="icon" href="${pageContext.request.contextPath}/static/img/favicon.png">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
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
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/search">Patients Search</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/jsps/newpatient.jsp">Add New Patient</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/jsps/newappointment.jsp">New Appointment</a>
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


<!-- MAIN start-->
<section class="about_us padding_top">
  <div class="container">
    <div class="row justify-content-between align-items-center">
      <div class="col-md-6 col-lg-6">
        <div class="about_us_img">
          <img src="${pageContext.request.contextPath}/static/img/logolarge.png" alt="">
        </div>
      </div>
      <div class="col-md-6 col-lg-5 text-center">
        <div class="our_depertment">
          <h2>Welcome ${user.fname} ${user.lname}</h2>
          <br>
          <br>
          <div class="row">
            <div class="col-sm-6 col-sm-6">
              <div class="single_our_depertment" >
                <h4>Search Patients</h4>
                <a href="${pageContext.request.contextPath}/search" class="stretched-link"  aria-disabled="true"></a>
              </div>
            </div>
            <div class="col-sm-6 col-sm-6">
              <div class="single_our_depertment" >
                <h4>Add New Patient</h4>
                <a href="${pageContext.request.contextPath}/jsps/newpatient.jsp" class="stretched-link"  aria-disabled="true"></a>
              </div>
            </div>
            <div class="col-sm-6 col-sm-6">
              <div class="single_our_depertment" >
                <h4>Find Appointment</h4>
                <a href="${pageContext.request.contextPath}/appointmentsearch" class="stretched-link"  aria-disabled="true"></a>
              </div>
            </div>
            <div class="col-sm-6 col-sm-6">
              <div class="single_our_depertment" >
                <h4>New Appointment</h4>
                <a href="${pageContext.request.contextPath}/jsps/newappointment.jsp" class="stretched-link"  aria-disabled="true"></a>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- about us part end-->

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
<!-- contact js -->
<script src="${pageContext.request.contextPath}/static/js/jquery.ajaxchimp.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/mail-script.js"></script>
<script src="${pageContext.request.contextPath}/static/js/contact.js"></script>
<!-- custom js -->
<script src="${pageContext.request.contextPath}/static/js/custom.js"></script>
</body>

</html>