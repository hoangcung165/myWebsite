<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="manager" style="height: 1000px">

    <div class="dropdown ">
        <button class="btn btn-warning dropdown-toggle" type="button" id="listWAIT" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 100%">
            Booking WAITING
        </button>
        <div class="dropdown-menu" aria-labelledby="listWAIT" style="width: 100%">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Customer Name</th>
                    <th scope="col">Apartment</th>
                    <th scope="col">Room</th>

                    <th scope="col">Quantity Rooms</th>
                    <th scope="col">Quantity Customers</th>
                    <th scope="col">Check-in date</th>
                    <th scope="col">Check-out date</th>
                    <th scope="col">Total Price</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${wait}" var="w">
                    <tr>
                        <td>${w.customer.name}</td>
                        <td>${w.apartment.name}</td>
                        <td>${w.room.roomName.name}</td>
                        <td>${w.qty_customer}</td>
                        <td>${w.qty_room}</td>
                        <td><fm:formatDate value="${w.begin}" pattern="dd-MM-yyyy"/> </td>
                        <td><fm:formatDate value="${w.finish}" pattern="dd-MM-yyyy"/> </td>
                        <td><fm:formatNumber type="number" maxFractionDigits="3" value="${w.pay}"/> VNĐ</td>
                        <td>
                            <a class="text-danger">Cancel</a>
                            <a class="text-success" href="<c:url value="/manager/accept/${w.id}"/>">Accept</a>
                            <a class="text-white bg-dark">Show Bill</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    <div class="dropdown ">
        <button class="btn btn-success dropdown-toggle" type="button" id="listAccept" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 100%">
            Booking WAITING
        </button>
        <div class="dropdown-menu" aria-labelledby="listAccept" style="width: 100%">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Customer Name</th>
                    <th scope="col">Apartment</th>
                    <th scope="col">Room</th>

                    <th scope="col">Quantity Rooms</th>
                    <th scope="col">Quantity Customers</th>
                    <th scope="col">Check-in date</th>
                    <th scope="col">Check-out date</th>
                    <th scope="col">Total Price</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${wait}" var="w">
                    <tr>
                        <td>${w.customer.name}</td>
                        <td>${w.apartment.name}</td>
                        <td>${w.room.roomName.name}</td>
                        <td>${w.qty_customer}</td>
                        <td>${w.qty_room}</td>
                        <td><fm:formatDate value="${w.begin}" pattern="dd-MM-yyyy"/> </td>
                        <td><fm:formatDate value="${w.finish}" pattern="dd-MM-yyyy"/> </td>
                        <td><fm:formatNumber type="number" maxFractionDigits="3" value="${w.pay}"/> VNĐ</td>
                        <td>
<%--                            <a class="text-danger">Cancel</a>--%>
<%--                            <a class="text-success">Accept</a>--%>
                            <a class="text-white bg-dark">Show Bill</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>