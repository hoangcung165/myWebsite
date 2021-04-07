<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <c:if test="${param.saveNew.equals('OK')}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Success!</strong> Added new Bed.
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
    <h3>List Object Beds</h3>
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>

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
        <c:forEach items="${beds}" var="bed">
            <tr>
                <td>${bed.typeName}</td>

                <td >
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#update${bed.id}">
                       Update
                    </button>
                    <div class="modal fade" id="update${bed.id}" tabindex="-1" aria-labelledby="updateLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="updateLabel">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="<c:url value="/admin/tableManager/update/${bed.id}"/>" method="post">
                                        <div class="form-group">
                                            <label for="updateBed${bed.id}">Bed Name</label>
                                            <input type="text" name="BedName" class="form-control" id="updateBed${bed.id}" aria-describedby="emailHelp" value="${bed.typeName}">

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
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete${bed.id}">
                       Delete
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="delete${bed.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="deleteLabel">Delete</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Are you sure? Delete ${bed.typeName}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="<c:url value="/admin/tableManager/deleteBed/${bed.id}"/>" class="btn btn-danger">Delete</a>
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
        Add new Bed
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
                    <form action="<c:url value="/admin/tableManager/addNewBed"/>" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Bed Name</label>
                            <input type="text" name="BedName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

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