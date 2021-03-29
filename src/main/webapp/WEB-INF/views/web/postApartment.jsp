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

<form role="form" action="" method="post">
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
                    <input maxlength="100" type="text" required="required" class="form-control" placeholder="Enter Name">
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
                </div>


                <div class="form-group">
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="inputCity">City/Province</label>
                            <select id="inputCity" class="form-control" name="idCity" onchange="addViaAjax()" >
                                <option selected>Choose...</option>

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
                            <label for="inputZip">House number</label>
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
                        <option selected value="none">Choose...</option>

                        <c:forEach items="${listTypeRoom}" var="typeRoom">
                            <option value="${typeRoom.id}">${typeRoom.type}</option>


                        </c:forEach>
                    </select>
                </div>
                <hr>
                <div class="form-group selectRoomName">
                    <label for="RoomName">Room Name</label>
                    <select id="RoomName" class="form-control" name="RoomName" >
                        <option selected value="none">Choose...</option>
                    </select>
                </div>
                <hr>
                <div class="form-group">
                    <label for="smoking">Somking policy</label>
                    <select id="smoking" class="form-control" name="idCity" >
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
                        <option selected value="none">Choose...</option>
                        <c:forEach items="${listBed}" var="bed">
                            <option value="${bed.id}">${bed.typeName}</option>
                        </c:forEach>
                    </select>
                    <label for="qtyBeds">Quantity of beds</label>
                    <input type="number" class="form-control  col-md-3" id="qtyBeds" name="qtyBeds">
                </div>
                <div class="form-group row">
                    <label for="qty_customer">How many guests can stay in this room?</label>
                    <input type="number" class="form-control col-md-2" id="qty_customer" name="houseNumber" >
                </div>
                <hr>
                <div class="form-group row">
                    <label for="amount">Quantity rooms</label>
                    <input type="number" class="form-control col-md-2" id="amount" name="houseNumber" >
                    <span class="col-md-3"></span>
                    <label for="size">Room Size (M2)</label>
                    <input type="number" class="form-control  col-md-3" id="size" name="size" style="float: right">
                </div>

                <div class="form-group row justify-content-between">
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


            <h5>Select Images for your apartment</h5>
            <div class="col-md-12 form-group">
                <div class="form-group" style="height: 60px"> <select id="choices-multiple-remove-button" placeholder="Select upto 5 tags" multiple>

                    <c:forEach items="${listService}" var="service">
                        <option value="${service.id}">${service.detail}</option>
                    </c:forEach>
                </select> </div>
                <hr>
                <div class="form-group">
                    <input id="file-input" type="file" multiple  enctype="multipart/form-data">
                    <div id="preview"></div>
                </div>
                <br>
                <button class="btn btn-primary prevBtn btn-lg pull-left" type="button">Previous</button>
                <button class="btn btn-success btn-lg pull-right" type="submit">Submit</button>
            </div>
        </div>
    </div>
</form>

</div>
<script>
    $(document).ready(function () {
        var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allNextBtn = $('.nextBtn'),
            allPrevBtn = $('.prevBtn');

        allWells.hide();
        $('.selectRoomName').hide();
        $('#show_bill').hide();

        navListItems.click(function (e) {
            e.preventDefault();
            var $target = $($(this).attr('href')),
                $item = $(this);

            if (!$item.hasClass('disabled')) {
                navListItems.removeClass('btn-primary').addClass('btn-default');
                $item.addClass('btn-primary');
                allWells.hide();
                $target.show();
                $target.find('input:eq(0)').focus();
            }
        });

        allPrevBtn.click(function(){
            var curStep = $(this).closest(".setup-content"),
                curStepBtn = curStep.attr("id"),
                prevStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().prev().children("a");

            prevStepWizard.removeAttr('disabled').trigger('click');
        });

        allNextBtn.click(function(){
            var curStep = $(this).closest(".setup-content"),
                curStepBtn = curStep.attr("id"),
                nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
                curInputs = curStep.find("input[type='text'],input[type='url']"),
                isValid = true;

            $(".form-group").removeClass("has-error");
            for(var i=0; i<curInputs.length; i++){
                if (!curInputs[i].validity.valid){
                    isValid = false;
                    $(curInputs[i]).closest(".form-group").addClass("has-error");
                }
            }

            if (isValid)
                nextStepWizard.removeAttr('disabled').trigger('click');
        });

        $('div.setup-panel div a.btn-primary').trigger('click');
    });
    function show_bill(){
        var price=$('#price').val()
        var qty_person=$('#qty_customer').val();
        var qtyRooms=$('#amount').val();
        if(price==null || price<=0 || qty_person<=0 || qty_person==null || qtyRooms ==null ||qtyRooms<=0){
            $('#show_bill').hide();
        }
        else{
            $('#show_bill').show();
            $('#input_qtyPerson').html(qty_person);
            $('#input_price').html(price);
            $('#input_beds').html(qtyRooms);
        }
    }
    function previewImages() {

        var preview = document.querySelector('#preview');

        if (this.files) {
            [].forEach.call(this.files, readAndPreview);
        }

        function readAndPreview(file) {

            // Make sure `file.name` matches our extensions criteria
            if (!/\.(jpe?g|png|gif)$/i.test(file.name)) {
                return alert(file.name + " is not an image");
            } // else...

            var reader = new FileReader();

            reader.addEventListener("load", function() {
                var image = new Image();
                image.height = 100;
                image.title  = file.name;
                image.src    = this.result;
                preview.appendChild(image);
            });

            reader.readAsDataURL(file);

        }

    }

    document.querySelector('#file-input').addEventListener("change", previewImages);
    $(document).ready(function(){

        var multipleCancelButton = new Choices('#choices-multiple-remove-button', {
            removeItemButton: true,
            maxItemCount:1000,
            searchResultLimit:5,
            renderChoiceLimit:5
        });


    });
</script>