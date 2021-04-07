<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <c:if test="${param.saveNew.equals('OK')}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Success!</strong> Added new Type Room.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${param.saveNew.equals('fail')}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>Fail!</strong> Check your input.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <h3>List Object Type Room</h3>
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Type</th>

            <th>
                Action

            </th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>Name</th>

            <th>Action</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${typeRooms}" var="tr">
            <tr>
                <td>${tr.type}</td>

                <td >
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#update${tr.id}">
                       Update
                    </button>
                    <div class="modal fade" id="update${tr.id}" tabindex="-1" aria-labelledby="updateLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="updateLabel${tr.id}">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="<c:url value="/admin/tableManager/TypeRoom/update/${tr.id}"/>" method="post">
                                        <div class="form-group">
                                            <label for="updateBed${tr.id}">Type</label>
                                            <input type="text" name="TypeName" class="form-control" id="updateBed${tr.id}" aria-describedby="emailHelp" value="${tr.type}">

                                        </div>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <input type="submit" class="btn btn-primary">
                                    </form>
                                </div>
                                <div class="modal-footer">


                            </div>
                        </div>
                    </div>
                </div>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete${tr.id}">
                       Delete
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="delete${tr.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="deleteLabel">Delete</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Are you sure?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="<c:url value="/admin/tableManager/TypeRoom/deleteTypeRoom/${tr.id}"/>" class="btn btn-danger">Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>


            </tr>
        </c:forEach>



        </tbody>
    </table>
    <br>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        Add new Type Room
    </button>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="<c:url value="/admin/tableManager/TypeRoom/addTypeRoom"/>" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Type Name</label>
                            <input type="text" name="TypeName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

                        </div>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary">
                    </form>
                </div>
                <div class="modal-footer">


                </div>
            </div>
        </div>
    </div>
</div>