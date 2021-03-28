<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container" style="height: 1000px">


        <div class="card text-center" style="padding-top: 200px">
            <div class="card-header">
                Notification
            </div>
            <div class="card-body">
                <h5 class="card-title">You are not Manager</h5>
                <p class="card-text">Become a Manager to post information of your hotel to every one</p>
                <input class="form-check-input" type="checkbox" id="gridCheck" onclick="check_agree()">
                <label class="form-check-label" for="gridCheck">
                    I agree <a href="#">policy and rules</a> of website
                </label>
                <br>
                <form action="<c:url value="/registerManager"/>">
                    <button  class="btn btn-primary" id="submit" onchange="check_agree()" disabled="true">Go somewhere</button>
                </form>
            </div>
            <div class="card-footer text-muted">
                <a href="<c:url value="/home"/>">Back home page</a>
            </div>
        </div>


</div>
