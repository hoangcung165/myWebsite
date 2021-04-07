<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Room Type</th>
            <th scope="col">Room Name</th>
            <th scope="col">Max customer</th>
            <th scope="col">Quantity rooms</th>
            <th scope="col">VNĐ/night/room</th>
            <th scope="col">Action
               </th>

        </tr>
        </thead>
        <tbody>

        <c:forEach var="room" items="${rooms}">

            <tr>

                <td>${room.typeRoom.type}</td>
                <td>${room.roomName.name}</td>
                <td>${room.quantityCustomer}</td>
                <td>${room.quantity_rooms}</td>
                <td> <fm:formatNumber type="number" maxFractionDigits="3" value="${room.price}"/> VNĐ</td>
                <td>
                    <a href="#" >Edit</a>
<%--                    <a href="<c:url value="/manager/${apartment.id}"/>">Manager Booking</a>--%>
<%--                    <a href="<c:url value="/manager/listRoom/${apartment.id}"/>">Manager Room</a>--%>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
    <a href="<c:url value="/manager/listRoom/addNewRoom/${apartment_id}"/>" class="border border-primary btn">Add new Room</a>
</div>

