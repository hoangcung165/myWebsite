<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="w3l-availability-form" id="booking">
    <!-- /w3l-availability-form-section -->
    <div class="w3l-availability-form-main py-5">
        <div class="container pt-lg-3 pb-lg-5">
            <div class="forms-top">
                <div class="form-right">
                    <div class="form-inner-cont">
                        <h3 class="title-small">Check Availability</h3>
                        <form action="search-results.html" method="post" class="signin-form">
                            <div class="row book-form">
                                <div class="form-input col-md-4 col-sm-6 mt-3">
                                    <label>Check-in Date</label>
                                    <input type="date" name="" placeholder="Date" required="">
                                </div>
                                <div class="form-input col-md-4 col-sm-6 mt-3">
                                    <label>Check-out Date</label>
                                    <input type="date" name="" placeholder="Date" required="">
                                </div>
                                <div class="form-input col-md-4 col-sm-6 mt-3">
                                    <label>Where you go to?</label>
                                    <select class="selectpicker">
                                        <option>01</option>
                                        <option>02</option>
                                        <option>03</option>
                                        <option>04</option>
                                    </select>

                                </div>
                                <div class="form-input col-md-4 col-sm-6 mt-3">
                                    <label>Children</label>
                                    <input type="number" name="" placeholder="How many?" min="0" required onkeydown="return false"/>

                                </div>
                                <div class="form-input col-md-4 col-sm-6 mt-3">
                                    <label>Adult</label>
                                    <input type="number" name="" placeholder="How many?" min="0" required onkeydown="return false"/>

                                </div>
                                <div class="bottom-btn col-md-4 col-sm-6 mt-3">
                                    <label>Check availability </label>
                                    <button class="btn btn-style btn-primary w-100 px-2">Check Availability</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>