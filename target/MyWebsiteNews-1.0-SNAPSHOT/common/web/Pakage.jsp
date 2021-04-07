<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="w3l-index3">
    <div class="midd-w3 py-5">
        <div class="container py-lg-5 py-md-3">
            <div class="row">
                <div class="col-lg-6 left-wthree-img text-righ">
                    <div class="position-relative">
                        <img src="<c:url value="/template/web/assets/images/videobg.jpg"/>" alt="" class="img-fluid" />
                        <a href="#small-dialog" class="popup-with-zoom-anim play-view text-center position-absolute">
                            <span class="video-play-icon">
                                <span class="fa fa-play"></span>
                            </span>
                        </a>
                        <!-- dialog itself, mfp-hide class is required to make dialog hidden -->
                        <div id="small-dialog" class="zoom-anim-dialog mfp-hide">
                            <iframe src="https://player.vimeo.com/video/246941769" allow="autoplay; fullscreen" allowfullscreen=""></iframe>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 mt-lg-0 mt-5 about-right-faq align-self">
                    <h6>Discover our Locations</h6>
                    <h3 class="title-big">20 Years of Hotels and Resort Experience</h3>
                    <p class="mt-3">Lorem ipsum viverra feugiat. Pellen tesque libero ut justo,
                        ultrices in ligula. Semper at tempufddfel.</p>
                    <ul class="w3l-right-book mt-4">
                        <li><span class="fa fa-check" aria-hidden="true"></span>We make the best for all our customers</li>
                        <li><span class="fa fa-check" aria-hidden="true"></span>Follow our Resort Luxury Hotels</li>
                        <li><span class="fa fa-check" aria-hidden="true"></span>Luxury hotels and best resorts</li>
                        <li><span class="fa fa-check" aria-hidden="true"></span>Double rooms and family rooms</li>
                        <li><span class="fa fa-check" aria-hidden="true"></span>Enjoy a luxury experience</li>
                    </ul>
                    <a href="about.html" class="btn btn-style btn-primary mt-4">Policy and Conditions</a>
                </div>
            </div>
        </div>
    </div>
</section>