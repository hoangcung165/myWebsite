<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="manager" style="height: 1000px">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Your apartment</th>
            <th scope="col">Action <a href="<c:url value="/manager/postAppartment"/>"><span style="float: right"><i class="fa fa-plus-circle"></i></span> </a></th>

        </tr>
        </thead>
        <tbody>

        <c:forEach var="apartment" items="${listApart}">

            <tr>
                <th scope="row">1</th>
                <td>${apartment.name}</td>
                <td>
                    <a href="#" >Edit</a>
                    <a href="<c:url value="/manager/${apartment.id}"/>">Manager Rooms</a>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
    <div class="dropdown ">
        <button class="btn btn-warning dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 100%">
            Dropdown button
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="width: 100%">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>