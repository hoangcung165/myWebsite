<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="manager container-fluida" style="height: 1000px">
            <div class="row">
                <div class="col-12">
                    <h5 class="p-3 mb-2 bg-warning text-dar">
                        Booking WAITING
                        <label for="show_wtb"><i class="fas fa-chevron-right" style="font-size: 18px;cursor: pointer"></i></label>
                        <input type="checkbox" hidden id="show_wtb" onchange="check_show()">
                    </h5>

                </div>
                <div class="w-100"></div>
                <div class="col-12" id="wtb">
                    <table class="table">
                        <thead class="thead-light">
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
                                    <a class="text-danger" href="<c:url value="/manager/cancel/${id_apartment}/${w.id}"/>">Cancel</a>
                                    <a class="text-success" href="<c:url value="/manager/accept/${id_apartment}/${w.id}"/>">Accept</a>

                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <h5 class="p-3 mb-2 bg-success text-white">
                        Booking ACCEPT
                        <label for="show_atb"><i class="fas fa-chevron-right" style="font-size: 18px;cursor: pointer"></i></label>
                        <input type="checkbox" hidden id="show_atb" onchange="check_show()">
                    </h5>
                </div>

                <div class="w-100"></div>
                <div class="col-12 " id="atb">
                    <table class="table">
                        <thead class="thead-light">
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
                        <c:forEach items="${accept}" var="a">
                            <tr>
                                <td>${a.customer.name}</td>
                                <td>${a.apartment.name}</td>
                                <td>${a.room.roomName.name}</td>
                                <td>${a.qty_customer}</td>
                                <td>${a.qty_room}</td>
                                <td><fm:formatDate value="${a.begin}" pattern="dd-MM-yyyy"/> </td>
                                <td><fm:formatDate value="${a.finish}" pattern="dd-MM-yyyy"/> </td>
                                <td><fm:formatNumber type="number" maxFractionDigits="3" value="${a.pay}"/> VNĐ</td>
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
    <div class="row">
        <div class="col-12">
            <h5 class="p-3 mb-2 bg-danger text-white">
            Booking CANCEL
            <label for="show_ctb"><i class="fas fa-chevron-right" style="font-size: 18px;cursor: pointer"></i></label>
            <input type="checkbox" hidden id="show_ctb" onchange="check_show()"> </h5>
        </div>

        <div class="w-100"></div>
        <div class="col-12" id="ctb">
            <table class="table">
                <thead class="thead-light">
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
                <c:forEach items="${cancel}" var="a">
                    <tr>
                        <td>${a.customer.name}</td>
                        <td>${a.apartment.name}</td>
                        <td>${a.room.roomName.name}</td>
                        <td>${a.qty_customer}</td>
                        <td>${a.qty_room}</td>
                        <td><fm:formatDate value="${a.begin}" pattern="dd-MM-yyyy"/> </td>
                        <td><fm:formatDate value="${a.finish}" pattern="dd-MM-yyyy"/> </td>
                        <td><fm:formatNumber type="number" maxFractionDigits="3" value="${a.pay}"/> VNĐ</td>
                        <td>
                                <%--                            <a class="text-danger">Cancel</a>--%>
                                <%--                            <a class="text-success">Accept</a>--%>
                        <a class="text-success" href="<c:url value="/manager/accept/${w.id}"/>">Accept</a>
                        <a class="text-danger" href="#"/>">Report</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>



</div>
<script>
    $(document).ready(function (){
        $('#ctb').hide();
        $('#atb').hide();
        $('#wtb').hide();

    })
    function check_show(){
        var check_ctb=$('#show_ctb');
        var check_atb=$('#show_atb');
        var check_wtb=$('#show_wtb');
        if(check_ctb.is(':checked')){
            $('#ctb').show();
        }
        if(!check_ctb.is(':checked')){
            $('#ctb').hide();
        }

        if(check_atb.is(':checked')){
            $('#atb').show();
        }
        if(!check_atb.is(':checked')){
            $('#atb').hide();
        }

        if(check_wtb.is(':checked')){
            $('#wtb').show();
        }
        if(!check_wtb.is(':checked')){
            $('#wtb').hide();
        }
    }
</script>