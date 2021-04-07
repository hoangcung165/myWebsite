<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://res.cloudinary.com/dxfq3iotg/raw/upload/v1569006288/BBBootstrap/choices.min.css?version=7.0.0">
<script src="https://res.cloudinary.com/dxfq3iotg/raw/upload/v1569006273/BBBootstrap/choices.min.js?version=7.0.0"></script>
<style>
    body {
        margin-top:40px;
    }
    .stepwizard-step p {
        margin-top: 10px;
    }
    .stepwizard-row {
        display: table-row;
    }
    .stepwizard {
        display: table;
        width: 50%;
        position: relative;
    }
    .stepwizard-step button[disabled] {
        opacity: 1 !important;
        filter: alpha(opacity=100) !important;
    }
    .stepwizard-row:before {
        top: 14px;
        bottom: 0;
        position: absolute;
        content: " ";
        width: 100%;
        height: 1px;
        background-color: #ccc;
        z-order: 0;
    }
    .stepwizard-step {
        display: table-cell;
        text-align: center;
        position: relative;
    }
    .btn-circle {
        width: 30px;
        height: 30px;
        text-align: center;
        padding: 6px 0;
        font-size: 12px;
        line-height: 1.428571429;
        border-radius: 15px;
    }
    .ck-editor__editable {
        min-height: 300px;
        max-width: 700px;
    }
</style>
<div class="container"></div>,<div class="container">

<div class="stepwizard col-md-offset-3">
    <div class="stepwizard-row setup-panel">
        <div class="stepwizard-step">
            <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
            <p>Step 1</p>
        </div>
        <div class="stepwizard-step">
            <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
            <p>Step 2</p>
        </div>
        <div class="stepwizard-step">
            <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
            <p>Step 3</p>
        </div>
    </div>
</div>

<form:form action="postNewHotel" modelAttribute="newHotel" method="post" enctype="multipart/form-data">

        <div class="row setup-content" id="step-1">
            <div class="col-xs-6 col-md-offset-3">
                <div class="col-md-12">
                    <h3> Step 1</h3>
                    <div class="form-group">
                        <label for="typeApartment">Type </label>
                        <select id="typeApartment" class="form-control" name="typeApartment"  >
                            <option selected>Choose...</option>

                            <c:forEach items="${listTypeAp}" var="t">
                                <option value="${t.id}">${t.typeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Name</label>
                        <input maxlength="100" type="text" required="required" class="form-control" placeholder="Enter Name" name="name">
                    </div>
                    <h5>Logo</h5>
                    <div class="form-group" style="border: whitesmoke 1px solid;border-radius: 2px">
                        <input id="file-input_logo" type="file" multiple name="logo">
                        <div id="show_img"></div>
                    </div>
                    <h4>User</h4>
                    <div class="row">

                        <div class="form-group col-md-6">
                            <label class="control-label">User Name</label>
                            <input maxlength="100" type="text" required="required" class="form-control" value="${user.name}" disabled="true">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label">Phone</label>
                            <input maxlength="100" type="text" required="required" class="form-control" value="${user.phone}" disabled="true">
                        </div>
                        <input type="hidden" name="id_user" value="${user.id}">
                    </div>


                    <div class="form-group">
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="inputCity">City/Province</label>
                                <select id="inputCity" class="form-control" name="idCity" onchange="addViaAjax()" >
                                    <option selected value="''">Choose...</option>

                                    <c:forEach items="${listT}" var="t">
                                        <option value="${t.matp}">${t.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="inputState">District</label>
                                <select id="inputState" class="form-control" onchange="findXa()" name="idDistrict">
                                    <option selected>Choose...</option>

                                </select>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="inputWard">Ward</label>
                                <select id="inputWard" class="form-control" name="idWard">
                                    <option selected>Choose...</option>

                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="inputZip">House no</label>
                                <input type="text" class="form-control" id="inputZip" name="houseNumber">
                            </div>

                        </div>
                    </div>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button">Next</button>
                </div>
            </div>
        </div>
        <div class="row setup-content" id="step-2">
            <div class="col-xs-6 col-md-offset-3">
                <div class="col-md-12">
                    <h3> Step 2</h3>
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
                    <button class="btn btn-primary prevBtn btn-lg pull-left" type="button">Previous</button>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button">Next</button>
                </div>
            </div>
        </div>
        <div class="row setup-content" id="step-3">

            <div class=" col-xs-6 col-md-offset-3">
                <h3> Step 3</h3>

                <div class="col-md-12 form-group">

                    <hr>
                    <h5>Select Images for your apartment</h5>
                    <div class="form-group" style="border: whitesmoke 1px solid;border-radius: 2px">
                        <input id="file-input" type="file" multiple name="listImages">
                        <div class="preview"></div>
                    </div>
                    <br>
                    <div class="form-group" style="border: whitesmoke 1px solid;border-radius: 2px">
                        <h5>Short describe for your Apartment</h5>
                        <textarea id="shortDes" name="shortDes" style="height: 200px;width: 100%" ></textarea>
                    </div>
                    <br>
                    <div class="form-group" style="border: whitesmoke 1px solid;border-radius: 2px">
                        <h5>Describe Detail for your Apartment</h5>
                        <textarea id="editor" name="detail" ></textarea>
                    </div>

                    <br>
                    <div class="form-group" style="height: 60px ">
                        <select id="choices-multiple-remove-button" placeholder="Select your service" multiple name="listService" >

                            <c:forEach items="${listService}" var="service">
                                <option value="${service.id}">${service.detail}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <button class="btn btn-primary prevBtn btn-lg pull-left" type="button">Previous</button>
                    <button class="btn btn-success btn-lg pull-right" type="submit">Submit</button>
                </div>
            </div>
        </div>

</form:form>


</div>
