<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row row-cols-1 row-cols-md-2">
        <div class="col mb-4">
            <div class="card">

                <div class="card-body">
                    <h5 class="card-title">Manager Object Bed</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <a href="<c:url value="/admin/tableManager/Bed"/> " class="btn btn-primary">Manager</a>
                </div>
            </div>
        </div>
        <div class="col mb-4">
            <div class="card">

                <div class="card-body">
                    <h5 class="card-title">Manager Object Type Room</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <a href="<c:url value="/admin/tableManager/TypeRoom"/> " class="btn btn-primary">Manager</a>
                </div>
            </div>
        </div>
        <div class="col mb-4">
            <div class="card">

                <div class="card-body">
                    <h5 class="card-title">Manager Object Room Name</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="<c:url value="/admin/tableManager/RoomName"/>" class="btn btn-primary">Manager</a>
                </div>
            </div>
        </div>

    </div>
</div>
