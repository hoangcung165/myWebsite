<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container" style="height: 1000px">


        <div class="card text-center" style="padding-top: 200px">
            <div class="card-header">
                Featured
            </div>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <input class="form-check-input" type="checkbox" id="gridCheck" onclick="check_agree()">
                <label class="form-check-label" for="gridCheck">
                    I agree <a href="#">policy and rules</a> of website
                </label>
                <br>
                <form action="<c:url value="/registerManager" />">
                    <button  class="btn btn-primary" id="submit" onchange="check_agree()" disabled="true">Go somewhere</button>
                </form>
            </div>
            <div class="card-footer text-muted">
                2 days ago
            </div>
        </div>


</div>
<script>
    var check_agree=function (){
        if(document.getElementById("gridCheck").checked==true){
            document.getElementById("submit").disabled=false;
        }
        else{
            document.getElementById("submit").disabled=true;
        }
    }
</script>