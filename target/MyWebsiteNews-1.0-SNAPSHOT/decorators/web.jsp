<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hotels a Hotels Category Responsive Web Template | Home : W3layouts</title>

    <link href="//fonts.googleapis.com/css?family=Spartan:400,500,600,700,900&display=swap" rel="stylesheet">

    <!-- Template CSS -->
    <link rel="stylesheet" href="<c:url value="/template/web/assets/css/style.css" />">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
    <%@include file="/common/web/header.jsp"%>
    <%@include file="/common/web/silde.jsp"%>

    <dec:body></dec:body>

    <%@include file="/common/web/footer.jsp"%>

    <!-- Template JavaScript -->
    <script src="assets/js/jquery-3.3.1.min.js"></script>

    <script src="assets/js/owl.carousel.js"></script>
    <!-- script for banner slider-->
    <script>
        $(document).ready(function () {
            $('.owl-one').owlCarousel({
                loop: true,
                margin: 0,
                nav: false,
                responsiveClass: true,
                autoplay: false,
                autoplayTimeout: 5000,
                autoplaySpeed: 1000,
                autoplayHoverPause: false,
                responsive: {
                    0: {
                        items: 1,
                        nav: false
                    },
                    480: {
                        items: 1,
                        nav: false
                    },
                    667: {
                        items: 1,
                        nav: true
                    },
                    1000: {
                        items: 1,
                        nav: true
                    }
                }
            })
        })
    </script>
    <!-- //script -->

    <!-- script for owlcarousel -->
    <script>
        $(document).ready(function () {
            $('.owl-testimonial').owlCarousel({
                loop: true,
                margin: 0,
                nav: true,
                responsiveClass: true,
                autoplay: false,
                autoplayTimeout: 5000,
                autoplaySpeed: 1000,
                autoplayHoverPause: false,
                responsive: {
                    0: {
                        items: 1,
                        nav: false
                    },
                    480: {
                        items: 1,
                        nav: false
                    },
                    667: {
                        items: 1,
                        nav: true
                    },
                    1000: {
                        items: 1,
                        nav: true
                    }
                }
            })
        })
    </script>
    <!-- //script for owlcarousel -->
    <script src="<c:url value="/template/web/assets/js/jquery.magnific-popup.min.js"/>"></script>
    <script>
        $(document).ready(function () {
            $('.popup-with-zoom-anim').magnificPopup({
                type: 'inline',

                fixedContentPos: false,
                fixedBgPos: true,

                overflowY: 'auto',

                closeBtnInside: true,
                preloader: false,

                midClick: true,
                removalDelay: 300,
                mainClass: 'my-mfp-zoom-in'
            });

            $('.popup-with-move-anim').magnificPopup({
                type: 'inline',

                fixedContentPos: false,
                fixedBgPos: true,

                overflowY: 'auto',

                closeBtnInside: true,
                preloader: false,

                midClick: true,
                removalDelay: 300,
                mainClass: 'my-mfp-slide-bottom'
            });


        });
    </script>


    <!-- disable body scroll which navbar is in active -->
    <script>
        $(function () {
            $('.navbar-toggler').click(function () {
                $('body').toggleClass('noscroll');
            })
        });
    </script>
    <!-- disable body scroll which navbar is in active -->

    <script src="<c:url value="/template/web/assets/js/bootstrap.min.js"/>"></script>


    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script>
        var check = function() {
            if (document.getElementById('password').value ==
                document.getElementById('confirm_password').value) {
                document.getElementById('message').style.color = 'green';
                document.getElementById('message').innerHTML = 'matching';
                document.getElementById('chang_password').style.display='block'
            } else {
                document.getElementById('message').style.color = 'red';
                document.getElementById('message').innerHTML = 'not matching';
            }
        }
        var check_agree=function (){
            if(document.getElementById("gridCheck").checked==true){
                document.getElementById("submit").disabled=false;
            }
            else{
                document.getElementById("submit").disabled=true;
            }
        }

        function addViaAjax() {

            var tinh_id = $("#inputCity").val();


            $.ajax({
                type : "GET",
                headers : {
                    Accept : "application/json; charset=utf-8",
                    "Content-Type" : "application/json; charset=utf-8"
                },
                contentType : "application/json",
                url : "<c:url value="/findHuyen"/>",
                data : {
                    tinh_id : tinh_id
                },
                dataType : 'json',
                success : function(result) {
                    var select=$('#inputState')
                    select.children('option:not(:first)').remove();
                    $.each(result,function (index,value){
                        select.append(
                            $('<option></option>').val(value.id).html(value.name)
                        )
                    });
                },
                error : function(e) {
                    console.log("url"+this.url)
                    console.log("ERROR: ", e);
                }
            });
        }
        function findXa() {

            var huyen_id = $("#inputState").val();


            $.ajax({
                type : "GET",
                headers : {
                    Accept : "application/json; charset=utf-8",
                    "Content-Type" : "application/json; charset=utf-8"
                },
                contentType : "application/json",
                url : "<c:url value="/findXa"/>",
                data : {
                    huyen_id : huyen_id
                },
                dataType : 'json',
                success : function(result) {
                    var select=$('#inputWard')
                    select.children('option:not(:first)').remove();
                    $.each(result,function (index,value){
                        select.append(
                            $('<option></option>').val(value.id).html(value.name)
                        )
                    });
                },
                error : function(e) {
                    console.log("url"+this.url)
                    console.log("ERROR: ", e);
                }
            });
        }
        function selectRoomname(){
            if($('#typeRoom').val()=='') {
                    $('.selectRoomName').hide();

            }
            else {
                var typeRoomId = $("#typeRoom").val();
                $('.selectRoomName').show();

                $.ajax({
                    type : "GET",
                    headers : {
                        Accept : "application/json; charset=utf-8",
                        "Content-Type" : "application/json; charset=utf-8"
                    },
                    contentType : "application/json",
                    url : "<c:url value="/findRoomName"/>",
                    data : {
                        typeRoomId : typeRoomId
                    },
                    dataType : 'json',
                    success : function(result) {
                        var select=$('#RoomName')
                        select.children('option:not(:first)').remove();
                        $.each(result,function (index,value){
                            console.log(value.name);
                            select.append(
                                $('<option></option>').val(value.id).html(value.name)
                            )
                        });
                    },
                    error : function(e) {
                        console.log("url"+this.url)
                        console.log("ERROR: ", e);
                    }
                });
            }
        }


    </script>

</body>
</html>
