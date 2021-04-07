<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.myWebsite.utils.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <c:url value="/manager/listRoom/addNewRoom/${apartment_id}" var="postNew"/>
    <form:form action="${postNew}" modelAttribute="NewRoom" method="post">
        <div class="row g5">
            <div class="col">
                <h4>Room Information</h4>
                <div class="form-group">
                    <label for="typeRoom">Room type</label>
                    <select id="typeRoom" class="form-control" name="typeRoom" onchange="selectRoomname()">
                        <option selected value="''">Choose...</option>

                        <c:forEach items="${listTypeRoom}" var="typeRoom">
                            <option value="${typeRoom.id}">${typeRoom.type}</option>


                        </c:forEach>
                    </select>
                </div>
                <div class="form-group selectRoomName">
                    <hr>
                    <label for="RoomName">Room Name</label>
                    <select id="RoomName" class="form-control" name="RoomName" >
                        <option selected value="''">Choose...</option>
                    </select>
                </div>
                <hr>
                <div class="form-group">
                    <label for="smoking">Somking policy</label>
                    <select id="smoking" class="form-control" name="smokking" >
                        <option selected value="Non-smoking">Non-smoking</option>
                        <option  value="Smoking">Smoking</option>
                        <option value="I have both smoking and non-smoking options for this room type">I have both smoking and non-smoking options for this room type</option>
                    </select>
                </div>
                <hr>
                <div class="form-group" >
                    <h3>Bed Options</h3>
                    <label for="kindOfBed">Kind of beds</label>
                    <select id="kindOfBed" class="form-control" name="kindOfBed" >
                        <option selected value="''">Choose...</option>
                        <c:forEach items="${listBed}" var="bed">
                            <option value="${bed.id}">${bed.typeName}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <label for="qtyBeds">Quantity of beds</label>
                    <input type="number" class="form-control  col-md-3" id="qtyBeds" name="qtyBeds">
                </div>
                <div class="form-group row">
                    <label for="qty_customer">How many guests can stay in this room?</label>
                    <input type="number" class="form-control col-md-2" id="qty_customer" name="qty_customer" >
                </div>
                <hr>
                <div class="form-group row">
                    <label for="amount">Quantity rooms</label>
                    <input type="number" class="form-control col-md-2" id="amount" name="qty_room" >
                </div>
                <hr>
                <div class="form-group row">
                    <label for="size">Room Size (M2)</label>
                    <input type="number" class="form-control  col-md-3" id="size" name="size" style="float: right">
                </div>
                <hr>
                <div class="form-group row justify-content-between">
                    <h5>How much money per night?</h5>
                    <div class="input-group mb-3  col-5">
                        <span class="input-group-text" style="height: 39px" id="basic-addon3">VNĐ/night</span>
                        <input type="number" class="form-control" id="price" aria-describedby="basic-addon3" name="price" onchange="show_bill()">
                    </div>
                    <div class="col-7" id="show_bill">
                        <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                            <div class="card-header">Summary</div>
                            <div class="card-body">
                                <h5 class="card-title">Price summary for your hotel</h5>
                                <p class="card-text">

                                    Quantity of Room: <span id="input_rooms"></span> room
                                    <br>
                                    Person: <span id="input_qtyPerson"></span> person/room
                                    <br>
                                    Price: <span id="input_price"></span> VNĐ/night

                                    <br>
                                    Beds: <span id="input_beds"></span> beds/room
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="submit" class="btn-primary btn" value="Add New">

            </div>

        </div>
    </form:form>

</div>