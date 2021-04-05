<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="manager" style="height: 1000px">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Customer</th>
            <th scope="col">Apartment</th>
            <th scope="col">Room</th>
            <th scope="col">Quantity Room</th>
            <th scope="col">Quantity Customer</th>
            <th scope="col">Check-in date</th>
            <th scope="col">Check-out date</th>
            <th scope="col">Price</th>
            <th scope="col">Status</th>

            <th scope="col">Action <a href="<c:url value="/manager/postAppartment"/>"><span style="float: right"><i class="fa fa-plus-circle"></i></span> </a></th>

        </tr>
        </thead>
        <tbody>

        <c:forEach var="booking" items="${myBookings}">

            <tr>
                <th scope="row">1</th>
                <td>${booking.customer.name}</td>
                <td>${booking.apartment.name}</td>
                <td>${booking.room.roomName.name}</td>
                <td>${booking.qty_room}</td>
                <td>${booking.qty_customer}</td>
                <td><fm:formatDate value="${booking.begin}" pattern="dd-MM-yyyy"/> </td>
                <td><fm:formatDate value="${booking.finish}" pattern="dd-MM-yyyy"/> </td>
                <td>${booking.pay}</td>
                <td>
                    <c:if test="${booking.status==2}">
                        <p class="text-warning">Wait Reponse</p>
                    </c:if>
                    <c:if test="${booking.status==1}">
                        <p class="text-success">Success</p>
                    </c:if>
                    <c:if test="${booking.status==0}">
                        <p class="text-danger">Cancel</p>
                    </c:if>
                </td>

                <td>
                    <a href="#" >Edit</a>
                    <a href="#">Delete</a>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>

</div>
