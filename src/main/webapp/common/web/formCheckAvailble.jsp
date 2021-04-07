<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--Date picker -->
<c:url value="/checkAvailable" var="booking"/>
<c:set var="today" value="<%=new Date()%>"/>
<c:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>
<form:form action="${booking}" method="get" modelAttribute="preBooking" id="preBooking">
    <h3>Form Boooking</h3>
    <div class="row">
        <div class="form-group col-6">
            <label for="check-inDay" class="col-2 col-form-label">Check-in Date</label>
            <div class="col-10">
                <input class="form-control" type="date" value="<fm:formatDate value="${today}" pattern="yyyy-MM-dd"/>" id="check-inDay" name="beginDate">
            </div>
        </div>
        <div class="form-group col-6">
            <label for="check-outDay" class="col-2 col-form-label">Check-out Date</label>
            <div class="col-10">
                <input class="form-control" type="date" value="<fm:formatDate value="${tomorrow}" pattern="yyyy-MM-dd"/>" id="check-outDay" name="endDate">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-6">
            <label for="qty_customer" class="col-2 col-form-label">Customers</label>
            <div class="col-10">
                <input class="form-control" type="number" value="" id="qty_customer" name="qty_customer" min="1" >
            </div>
        </div>
        <div class="form-group col-6">
            <label for="qty_rooms" class="col-2 col-form-label">Room</label>
            <div class="col-10">
                <input class="form-control" type="number" value="" id="qty_rooms" name="qty_rooms" min="1" max="${qtyCus}" onchange="checkQtyRooms()">
            </div>
        </div>
    </div>


    <input class="btn btn-primary" id="checkAvailble" type="submit" value="Check Price">
</form:form>
<div class="alert alert-success" role="alert" id="saveSuccess" style="display: none" >
    <h4 class="alert-heading">Well done!</h4>
    <p>Your information have been saved. You can booking</p>

</div>

<script>
    $('#preBooking').submit(function (e){
        var data=$(this).serialize();
        e.preventDefault();
        $.ajax({
            type : "GET",
            headers : {
                Accept : "application/json; charset=utf-8",
                "Content-Type" : "application/json; charset=utf-8"
            },
            contentType : "application/json",
            url : "${booking}",
            data : data,

            success : function(result) {
                if(result!=null){
                    $('#preBooking').hide();
                    document.getElementById("saveSuccess").style.display="block";
                    $('#qtyRooms').show();
                    $('.qtyRoomsSelect').show();
                    var select=$('.qtyRs')
                    select.children('option:not(:first)').remove();
                    // $.each(result,function (index,value){
                    //     select.append(
                    //         $('<option></option>').val(index+1).html(value.name)
                    //     )
                    // });
                    for(var i=0;i<result.qtyRoomMax;i++){
                        select.append(
                            $('<option></option>').val(i+1).html(i+1)
                        )
                    }
                    var bill=$('#formShowBill');
                    var dateNumber=result.dates
                    $('#dates').val(dateNumber)

                    // console.log(result.qtyRoomMax)
                }
            },
            error : function(e) {
                console.log("url"+this.url)
                console.log("ERROR: ", e);
            }
        });
    })
    <%--function cal_bill(){--%>
    <%--    var select=$('#quantityRooms').val();--%>
    <%--    $.ajax({--%>
    <%--        type : "GET",--%>
    <%--        headers : {--%>
    <%--            Accept : "application/json; charset=utf-8",--%>
    <%--            "Content-Type" : "application/json; charset=utf-8"--%>
    <%--        },--%>
    <%--        contentType : "application/json",--%>
    <%--        url : "${booking}",--%>
    <%--        data : {--%>

    <%--        },--%>

    <%--        success : function(result) {--%>
    <%--            if(result!=null){--%>
    <%--                $('#preBooking').hide();--%>
    <%--                document.getElementById("saveSuccess").style.display="block";--%>
    <%--                $('#qtyRooms').show();--%>
    <%--                $('#qtyRoomsSelect').show();--%>
    <%--                var select=$('#quantityRooms')--%>
    <%--                select.children('option:not(:first)').remove();--%>
    <%--                // $.each(result,function (index,value){--%>
    <%--                //     select.append(--%>
    <%--                //         $('<option></option>').val(index+1).html(value.name)--%>
    <%--                //     )--%>
    <%--                // });--%>
    <%--                for(var i=0;i<result.qtyRoomMax;i++){--%>
    <%--                    select.append(--%>
    <%--                        $('<option></option>').val(i+1).html(i+1)--%>
    <%--                    )--%>
    <%--                }--%>
    <%--                var bill=$('#formShowBill');--%>

    <%--                // console.log(result.qtyRoomMax)--%>
    <%--            }--%>
    <%--        },--%>
    <%--        error : function(e) {--%>
    <%--            console.log("url"+this.url)--%>
    <%--            console.log("ERROR: ", e);--%>
    <%--        }--%>
    <%--    });--%>
    <%--}--%>


</script>