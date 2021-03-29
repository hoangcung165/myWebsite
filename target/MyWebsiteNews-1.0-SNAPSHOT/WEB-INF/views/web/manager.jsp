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
                    <a href="#">Delete</a>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>