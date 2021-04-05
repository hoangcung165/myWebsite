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


        </div>
    </div>
</div>