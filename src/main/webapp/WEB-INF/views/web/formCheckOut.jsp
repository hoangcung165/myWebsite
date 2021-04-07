<%@ page import="java.util.Date" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <div class="row g5">
        <div class="col-8">
            <h4>Customer Information</h4>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" class="form-control" id="fullName" value="${person.name}" placeholder="Name" disabled=true>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="birthday">Birthday</label>
                        <input type="text" class="form-control" id="birthday" value="<fm:formatDate value="${person.birtday}"/>" placeholder="Birthday" disabled=true>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <input type="text" class="form-control" id="gender" value="${person.gender}" placeholder="Gender" disabled=true>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <label for="Email">Email</label>
                        <input type="email" class="form-control" id="Email" value="${person.mail}" placeholder="Email" disabled=true>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" class="form-control" id="address" value="${person.address}" placeholder="address" disabled=true>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <label for="Phone">Phone</label>
                        <input type="text" class="form-control" id="Phone" value="${person.phone}" placeholder="Phone" disabled=true>
                    </div>
                </div>
            </div>
            <h4>Apartment</h4>
            <div class="row">
                <div class="col-12">
                    <div class="form-group">
                        <label for="nameApart">Name</label>
                        <input type="text" class="form-control" id="nameApart" value="${apartment.name}" placeholder="Name" disabled=true>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="typeApart">Type</label>
                        <input type="text" class="form-control" id="typeApart" value="${apartment.typeApartment.typeName}" placeholder="Birthday" disabled=true>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="address_Apartment">Address</label>
                        <input type="text" class="form-control" id="address_Apartment" value="${apartment.addressApartment}" placeholder="Gender" disabled=true>
                    </div>
                </div>
            </div>
            <h4>Room</h4>
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="typeRoom">Type Room</label>
                        <input type="text" class="form-control" id="typeRoom" value="${room.typeRoom.type}" placeholder="Birthday" disabled=true>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="roomName">Room Name</label>
                        <input type="text" class="form-control" id="roomName" value="${room.roomName.name}" placeholder="Gender" disabled=true>
                    </div>
                </div>
            </div>
<%--            <div class="row">--%>
<%--                <div class="col-12">--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="roomName">Room Name</label>--%>
<%--                        <input type="text" class="form-control" id="roomName" value="${room.}" placeholder="Name" disabled=true>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <h4>Booking Information</h4>
            <c:url var="saveBooking" value="/booking/saveBooking"/>
            <form:form action="${saveBooking}" method="get" modelAttribute="bookingInfor">
            <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="beginDate">Check-in date</label>
                            <input type="date" class="form-control" name="beginDate" id="beginDate" readonly value="${sessionScope.booking.beginDate}" placeholder="begin" >
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="roomName">Check-out date</label>
                            <input type="date" class="form-control" id="endDate" name="endDate" readonly value="${sessionScope.booking.endDate}" placeholder="Gender">
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="qty_Room">Amount Room</label>
                            <input type="number" class="form-control" id="qty_Room" name="qty_Room" readonly value="${amountRooms}"  >
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="qty_Cus">Amount Customer</label>
                            <input type="number" class="form-control" id="qty_Cus" name="qty_Cus" readonly value="${sessionScope.booking.qty_customer}">
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="qty_dates">Quantity date</label>
                            <input type="number" class="form-control" id="qty_dates" name="qty_dates" readonly value="${amountDates}">
                        </div>
                    </div>
                    <input type="hidden" name="apartment_id" value="${apartment.id}">
                    <input type="hidden" name="room_id" value="${room.id}">
                    <input type="hidden" name="payment" value="${amountRooms*room.price*amountDates}">


            </div>
                <input type="submit" class="btn btn-primary" value="Cofim">
            </form:form>
        </div>
        <div class="col-4">
            <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                <div class="card-header">Bill</div>
                <div class="card-body">
                    <h5 class="card-title">You will pay</h5>
                    <p class="card-text" style="color: white">
                        ${amountRooms} rooms
                        <br>
                            <fm:formatNumber type="number" maxFractionDigits="3" value="${room.price}"/> VNĐ/night/room
                        <br>
                            ${amountDates} dates
                        <hr>
                        Total: <fm:formatNumber type="number" maxFractionDigits="3" value="${amountRooms*room.price*amountDates}"/>  VNĐ
                    </p>
                </div>
            </div>
        </div>

    </div>
</div>