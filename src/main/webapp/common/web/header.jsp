<%@ page import="com.myWebsite.utils.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="w3l-header-nav">
    <!--/nav-->
    <nav class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
        <div class="container">
            <a class="navbar-brand" href="index.html">
                <img src="<c:url value="/template/web/assets/images/hotels.png"/>" alt="Your logo" style="height:35px;" /> Hotels</a>
            <!-- if logo is image enable this
                        <a class="navbar-brand" href="#index.html">
                            <img src="image-path" alt="Your logo" title="Your logo" style="height:35px;" />
                        </a> -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link h2" href="index.html">Home</a>
                    </li>
                    <li class="nav-item @@about__active">
                        <a class="nav-link h2" href="about.html">About</a>
                    </li>
                    <li class="nav-item @@services__active">
                        <a class="nav-link h2" href="services.html">Services</a>
                    </li>
                    <li class="nav-item @@contact__active">
                        <a class="nav-link h2" href="contact.html">Contact</a>
                    </li>
                </ul>
                <security:authorize access="isAnonymous()">
                    <a href="<c:url value="/register"/> " class="ml-3 book btn btn-secondary btn-style">Register</a>
                    <a href="<c:url value="/login"/> " class="ml-3 book btn btn-secondary btn-style">Login</a>
                </security:authorize>

                <security:authorize access="isAuthenticated()">
                    <a href="<c:url value="/manager"/> " class="ml-3 book btn btn-secondary btn-style">Manager Hotel</a>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color: white;border: none">
                            <i class="fa fa-user" style="color: black;font-size:25px"></i> <p style="color: black"><%=SecurityUtils.getPrincial().getFullName()%></p>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="<c:url value="/profile"/> ">Profile</a>
                            <a class="dropdown-item" href="<c:url value="/changePassword" />">Change your password</a>
                            <a class="dropdown-item" href="<c:url value="/j_spring_security_logout"/>">Logout</a>
                        </div>
                    </div>
                </security:authorize>



            </div>
        </div>
    </nav>
    <!--//nav-->
</header>
