<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="height: 1000px;">
    <c:if test="${not empty param.change && param.change.equals('fail')}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>Fail!</strong> You should check in on some of those fields below.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${not empty param.change && param.change.equals('success')}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Done!</strong> Your information have been changed.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <div class="row my-2">
        <div class="col-lg-8 order-lg-2">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="" data-target="#profile" data-toggle="tab" class="nav-link active">Profile</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#messages" data-toggle="tab" class="nav-link">Messages</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#edit" data-toggle="tab" class="nav-link">Edit</a>
                </li>
            </ul>
            <div class="tab-content py-4">
                <div class="tab-pane active" id="profile">
                    <h5 class="mb-3"><c:out value="${userProfile.name}"></c:out></h5>
                    <div class="row">

                        <div class="col-md-6">
                            <h6>Address: </h6>
                            <p>
                                ${userProfile.address}
                            </p>
                            <h6>Birthday</h6>
                            <p>
                                <fm:formatDate value="${userProfile.birtday}" var="birthday"></fm:formatDate>
                            </p>
                        </div>
                        <div class="col-md-6">
                            <h6>Email:</h6>
                            <p>${userProfile.mail}</p>
                            <h6>Gender: </h6>
                            <p> ${userProfile.gender}</p>
                            <h6>Phone:</h6>
                            <p>${userProfile.phone}</p>

                        </div>

                    </div>
                    <!--/row-->
                </div>

                <div class="tab-pane" id="edit">

                    <form:form role="form" method="post" modelAttribute="userUpdate" action="updateUser">
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Full name</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="text" value="${userProfile.name}" name="fullname">
                            </div>
                        </div>
                        <div class="form-input  col-md-6">
                            <label for="birthday">Birth day</label>
                            <input class="form-control" type="date" value="${birthday}" id="birthday" name="birthday">

                        </div>
                        <div class="form-group col-md-6">

                            <p style="color: black">Gender</p>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="Male">
                                <label class="form-check-label" for="inlineRadio1">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="Female">
                                <label class="form-check-label" for="inlineRadio2">Female</label>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Email</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="email" name="email" value="${userProfile.mail}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Nationality</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="text" name="nationality" value="${userProfile.nationality}">
                            </div>
                        </div>

                        <div class="form-group row">
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
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Phone</label>
                            <div class="col-lg-9">
                                    <%--                                <fm:parseDate value="${userProfile.birtday}" var="birthday" pattern="yyyy-MM-dd- HH:mm:ss"/>--%>

                                <input class="form-control" type="text" value="${userProfile.phone}" name="phone">
                            </div>
                        </div>
                        <input type="hidden" name="user_id" value="${userProfile.id}">
                        <input type="hidden" name="address_id" value="${userProfile.address.id}">

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label"></label>
                            <div class="col-lg-9">
                                <input type="reset" class="btn btn-secondary" value="Cancel">
                                <input type="submit" class="btn btn-primary" value="Save Changes" >
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-lg-4 order-lg-1 text-center" style="height: 70px;width: 70px;">
            <img src="<c:url value="/template/static/uploadfile/${userProfile.image.url}"/>" style="border:solid 1px;border-radius: 100%" class="mx-auto img-fluid img-circle d-block"  alt="avatar">
            <h6 class="mt-2">Upload a different photo</h6>
            <label class="custom-file">
               <form:form action="updateAvatar" method="post" enctype="multipart/form-data">
                   <input type="hidden" value="${userProfile.id}" name="user_id">
                   <input type="file" id="file-upload" class="custom-file-input" name="avatar">
                   <span class="custom-file-control">Change Avatar</span>
                   <input type="submit" class="btn-primary btn" id="change_img" value="Submit" style="display: none">
                   <div id="file-upload-filename"></div>
               </form:form>
            </label>
        </div>
    </div>
</div>
<script>
    var input = document.getElementById( 'file-upload' );
    var infoArea = document.getElementById( 'file-upload-filename' );

    input.addEventListener( 'change', showFileName );

    function showFileName( event ) {

        // the change event gives us the input it occurred in
        var input = event.srcElement;

        // the input has an array of files in the `files` property, each one has a name that you can use. We're just using the name here.
        var fileName = input.files[0].name;

        // use fileName however fits your app best, i.e. add it into a div
        infoArea.textContent = 'File name: ' + fileName;
        document.getElementById("change_img").style.display="block";
    }
</script>