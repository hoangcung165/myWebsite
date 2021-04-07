<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    p{
        color: #0b0b0b;
    }
    i{
        color: #1e7e34;
    }
</style>
<div class="container">

    <div class="row">

        <div class="col-3">
            <%@include file="formSearch.jsp"%>
        </div>
        <div class="col-9">
            <c:if test="${param.formBooking.equals('none')}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    <strong>Holy guacamole!</strong> You should check in on some of those fields below.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <h2><span class="badge badge-secondary">${apartment.typeApartment.typeName}</span> ${apartment.name}</h2>
            <p class="text-info"><i class="fas fa-map-marker"></i>${apartment.addressApartment}</p>
            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="<c:url value="/template/static/uploadfile/${apartment.logo.url}"/>" alt="First slide">
                    </div>

                    <c:forEach var="i" items="${imgs}">
                        <div class="carousel-item">
                            <img  style="height: 500px;" class="d-block w-100" src="<c:url value="/template/static/uploadfile/${i.url}"/>" alt="First slide">
                        </div>
                    </c:forEach>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <br>
            <p class="text-justify">
                ${apartment.detailDescribe}
            </p>
            <br>
            <h2>Service</h2>
            <div class="service row">
                <c:forEach var="service" items="${services}">
                    <div class="col-3">
                        <p>${service.servicehotelHave.icon}<br> ${service.servicehotelHave.detail}</p>
                    </div>
                </c:forEach>
            </div>
            <div class="form_booking">
<%--                <c:if test="${sessionScope.booking==null}">--%>

                    <%@include file="/common/web/formCheckAvailble.jsp"%>
<%--                </c:if>--%>
            </div>

            <h3> Rooms</h3>
            <div class="rooms">
                <table class="table">
                    <thead class="thead-dark">
                    <tr>

                        <th scope="col">Room Name</th>
                        <th scope="col">$/night/room</th>
                        <th scope="col">Max customer/room</th>
                        <th scope="col" id="qtyRooms" >Quantity rooms</th>

                        <th scope="col" id="showBill" >Bill</th>


                        <th scope="col">Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${rooms}" var="room">
                        <tr>

                            <td> Type: ${room.typeRoom.type} <br>
                                  Name: ${room.roomName.name}</td>
                            <td id="money">
                                <fm:formatNumber type="number" maxFractionDigits="3" value="${room.price}"/> VNĐ
                                <input id="price_${room.id}" value="${room.price}" type="hidden">
                            </td>
                            <td> ${room.quantityCustomer}</td>

                                <td  class="qtyRoomsSelect">
                                    <div class="form-group">
                                        <label for="quantityRooms_${room.id}">Quantity rooms</label>
                                        <select onchange="changePrice(${room.id})" class="form-control qtyRs" id="quantityRooms_${room.id}" >
                                            <option value="0" selected>0</option>
                                        </select>
                                    </div>

                                </td>


                            <td id="formShowBill_${room.id}"></td>


                            <td>

<%--                                <a href="<c:url value="/booking/${apartment.id}/${room.id}"/>" class="btn btn-primary">Add</a>--%>
<%--                                <c:url value="/booking/checkBill" var="checkBill"></c:url>--%>
                                <form action="<c:url value="/booking/${apartment.id}/${room.id}"/>"  id="checkBillform_${room.id}">
                                    <input type="hidden" value="" id="amoutRooms_${room.id}" name="amount">
                                    <input type="hidden" name="dates" value="" id="dates">
                                    <input  class="btn btn-primary" value="Add" type="submit"/>
                                </form>
                            </td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
            <br>
            <h3>Manager</h3>
            <div class="manager-card row">
                <div class="avatar col-4">
                    <img class="rounded" style="height: 250px;width: 250px;" src="<c:url value="/template/static/uploadfile/${apartment.owner.person.image.url}"/> " alt="Card image cap">
                </div>
                <span class="col-1"></span>
                <div class="information col-7">

                    <p class="font-weight-normal">Name: ${apartment.owner.person.name}</p>
                    <p class="font-weight-normal">Phone: ${apartment.owner.person.phone}</p>

                    <p class="font-weight-normal">Email: ${apartment.owner.person.mail}</p>
                    <p class="font-weight-normal">Nationality: ${apartment.owner.person.nationality}</p>
                </div>
            </div>
        </div>



    </div>

</div>
<br>
<script>
   $(document).ready(function (){
       $('#qtyRooms').hide();
       $('.qtyRoomsSelect').hide();
   })
   function changePrice(id){

       var qtyRooms=parseInt($('#quantityRooms_'+id).val());
       var price=parseInt($('#price_'+id).val());
       var date=parseInt($('#dates').val());
       var out=qtyRooms*price*date;
       $('#amoutRooms_'+id).val(qtyRooms);

       <%--let tag = `<fm:formatNumber type="number" maxFractionDigits="3" value="`+ out +`"/>`;--%>
       $('#formShowBill_'+id).text('Total: '+ new Intl.NumberFormat().format(out)  +'VNĐ');

   }


</script>