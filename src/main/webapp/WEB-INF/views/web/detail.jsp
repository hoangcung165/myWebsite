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
            <h3> Rooms</h3>
            <div class="rooms">
                <table class="table">
                    <thead class="thead-dark">
                    <tr>

                        <th scope="col">Room Name</th>
                        <th scope="col">$/night/room</th>
                        <th scope="col">Max customer/room</th>
                        <th scope="col">Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${rooms}" var="room">
                        <tr>

                            <td> Type: ${room.typeRoom.type} <br>
                                  Name: ${room.roomName.name}</td>
                            <td> ${room.price}</td>
                            <td> ${room.quantityCustomer}</td>
                            <td><a href="<c:url value="/toBooking"/>" class="btn btn-primary">Book Now</a></td>

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