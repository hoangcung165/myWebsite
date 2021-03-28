<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.myWebsite.utils.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="height: 1000px">
    <form:form action="changePassword/change" method="post" modelAttribute="changePassword">
        <div class="form-group">
            <label for="old_password">Password </label>
            <input type="password" class="form-control" name="old_pass" id="old_password" placeholder="Current Password" onchange="checkPass()">
        </div>
        <div class="form-group">
            <label for="password">New password</label>
            <input type="password" class="form-control" id="password" placeholder="New password" name="new_pass" onchange="checkPass()">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm new password</label>
            <input type="password" class="form-control" id="confirm_password" placeholder="Confirm new password" onchange="checkPass()">
        </div>
        <span id='message'></span>
        <input type="hidden" name="user_id" value="<%=SecurityUtils.getPrincial().getUser_id()%>">
        <input type="submit" class="btn btn-primary" value="Change Password" id="change_password" disabled="true">
    </form:form>

</div>
<script>
    var checkPass = function() {
        if (document.getElementById('password').value ==
            document.getElementById('confirm_password').value &&
            document.getElementById('password').value !=
            document.getElementById('old_password').value

           ) {
            document.getElementById('message').style.color = 'green';
            document.getElementById('message').innerHTML = 'matching';
            document.getElementById('change_password').disabled=false;
        } else {
            document.getElementById('message').style.color = 'red';
            document.getElementById('message').innerHTML = 'not matching';
        }
    }

</script>