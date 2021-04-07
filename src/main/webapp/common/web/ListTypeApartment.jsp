<%@ page import="com.myWebsite.utils.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .card-img-top{
        max-height: 180px;
        min-height:180px;
        height:100%;
        width: 100%;
    }
</style>
<div class="container">
    <h3 style="text-align: center">Browse by property type</h3>
    <br>
    <div class="card-group">
        <div class="card">
            <img class="card-img-top" src="https://cf.bstatic.com/xdata/images/xphoto/square300/57584488.webp?k=bf724e4e9b9b75480bbe7fc675460a089ba6414fe4693b83ea3fdd8e938832a6&o=" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"><a href="<c:url value="/listApartment/1"/> ">Hotel</a></h5>
                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>

        </div>
        <div class="card">
            <img class="card-img-top" src="https://cf.bstatic.com/static/img/theme-index/carousel_320x240/card-image-apartments_300/9f60235dc09a3ac3f0a93adbc901c61ecd1ce72e.jpg" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"><a href="<c:url value="/listApartment/2"/>">Apartment</a></h5>
                <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            </div>

        </div>
        <div class="card">
            <img class="card-img-top" src="https://cf.bstatic.com/static/img/theme-index/carousel_320x240/bg_resorts/6f87c6143fbd51a0bb5d15ca3b9cf84211ab0884.jpg" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"><a href="<c:url value="/listApartment/3"/>">Resort</a></h5>
                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
            </div>

        </div>
        <div class="card">
            <img class="card-img-top" src="https://cf.bstatic.com/static/img/theme-index/carousel_320x240/card-image-villas_300/dd0d7f8202676306a661aa4f0cf1ffab31286211.jpg" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"><a href="<c:url value="/listApartment/4"/>">Villa</a></h5>
                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
            </div>

        </div>
    </div>

</div>
<br>
<br>
