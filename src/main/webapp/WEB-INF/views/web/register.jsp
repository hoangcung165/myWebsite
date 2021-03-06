<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <form:form action="saveUser" method="post" class="signin-form" modelAttribute="formRegister">
        <div class="form-group">
            <label for="">Full Name</label>
            <input type="text" class="form-control" id="" placeholder="Your full name" name="fullName">
        </div>
        <div class="form-row">
            <div class="form-input  col-md-6">
                <label for="birthday">Birth day</label>
                <input class="form-control" type="date" value="2011-08-19" id="birthday" name="birthday">

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
        </div>
        <div class="form-group">
            <label for="inputEmail">Email</label>
            <input type="email" class="form-control" id="inputEmail" placeholder="Your email" name="email">
        </div>
        <div class="form-group">
            <label for="inputUsername">User Name</label>
            <input type="text" class="form-control" id="inputUsername" placeholder="Your username" name="userName">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password" onkeyup="check()" name="password">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input type="password" class="form-control" id="confirm_password" placeholder="Confirm password" onkeyup="check()">
            <span id='message'></span>
        </div>
        <div class="form-group">
            <label for="national">National</label>
            <input type="text" class="form-control" id="national" placeholder="Nationality" name="national">

        </div>
        <div class="form-row">
            <div class="form-group col-md-3">
                <label for="inputCity">City/Province</label>
                <select id="inputCity" class="form-control" name="idCity" onchange="addViaAjax()">
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
        <div class="form-group">
            <label for="phoneNumber">Phone</label>
            <input type="text" class="form-control" id="phoneNumber" placeholder="Phone Number" name="phone">
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck" onclick="check_agree()">
                <label class="form-check-label" for="gridCheck">
                    I agree <a href="#">policy and rules</a> of website
                </label>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <br>
        <input type="submit" class="btn btn-primary" onchange="check_agree()" id="submit" disabled="true" value="Register"></td>

    </form:form>


</div>







