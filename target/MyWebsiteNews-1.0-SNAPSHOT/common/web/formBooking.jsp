<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="w3l-availability-form" id="booking">
    <c:set var="today" value="<%=new Date()%>"/>
    <c:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>
    <!-- /w3l-availability-form-section -->
    <div class="w3l-availability-form-main py-5">
        <div class="container pt-lg-3 pb-lg-5">
            <div class="forms-top">
                <div class="form-right">
                    <c:url value="/listApartmentByTinh" var="fiter"/>

                        <div class="form-inner-cont">
                            <h3 class="title-small">Check Availability</h3>
                            <form:form action="${fiter}" method="get" modelAttribute="preBooking">
                                <div class="row book-form">
                                    <div class="form-input col-md-4 col-sm-6 mt-3">
                                        <label>Check-in Date</label>
                                        <input type="date" id="check-inDay" name="beginDate" placeholder="Date" required="" value="<fm:formatDate value="${today}" pattern="yyyy-MM-dd"/>">
                                    </div>
                                    <div class="form-input col-md-4 col-sm-6 mt-3">
                                        <label>Check-out Date</label>
                                        <input type="date" id="check-outDay" name="endDate" placeholder="Date" required="" value="<fm:formatDate value="${tomorrow}" pattern="yyyy-MM-dd"/>">
                                    </div>
                                    <div class="form-input col-md-4 col-sm-6 mt-3">
                                        <label>Where you go to?</label>
                                        <select class="selectpicker" name="id_TinhThanh">
                                            <c:forEach items="${listTinhThanh}" var="t">
                                                <option value="${t.matp}">${t.name}</option>
                                            </c:forEach>


                                        </select>

                                    </div>
                                    <div class="form-input col-md-4 col-sm-6 mt-3">
                                        <label>Person</label>
                                        <input type="number" name="" placeholder="How many?" min="0" required onkeydown="return false" id="qty_customer" name="qty_customer"/>

                                    </div>
                                    <div class="form-input col-md-4 col-sm-6 mt-3">
                                        <label>Room</label>
                                        <input type="number" name="" placeholder="How many?" min="0" required onkeydown="return false" id="qty_rooms" name="qty_rooms" />

                                    </div>
                                    <div class="bottom-btn col-md-4 col-sm-6 mt-3">
                                        <label>Check availability </label>
                                        <input class="btn btn-style btn-primary w-100 px-2" id="checkAvailble" type="submit" value="Check Availble">
                                    </div>
                                </div>
                            </form:form>
                        </div>

                </div>
            </div>
        </div>
    </div>
</section>