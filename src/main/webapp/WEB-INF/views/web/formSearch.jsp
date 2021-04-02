<%@ page import="java.util.Date" %>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="search_form p-3 mb-2 bg-warning text-dark">
    <c:set var="today" value="<%=new Date()%>"/>
    <c:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>

    <form>
        <h2>Search</h2>
        <div class="form-group row">
            <label for="check-inDate" >Check-in Date</label>
            <div class="col-10">
                <input class="form-control" type="date" value="<fm:formatDate value="${today}" pattern="yyyy-MM-dd"/>" id="check-inDate" name="check-inDate">
            </div>
        </div>
        <div class="form-group row">
            <label for="check-outDate">Check-out Date</label>
            <div class="col-10">
                <input class="form-control" type="date" value="<fm:formatDate value="${tomorrow}" pattern="yyyy-MM-dd"/>" id="check-outDate" name="check-outDate">
            </div>
        </div>
        <input name="submit" type="submit" class="btn btn-primary" value="Search">
    </form>
</div>