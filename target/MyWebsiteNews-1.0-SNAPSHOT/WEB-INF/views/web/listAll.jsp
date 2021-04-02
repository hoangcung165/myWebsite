<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2021
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    
   <div class="row">

       <div class="col">
           <%@include file="/common/web/formBooking.jsp"%>
       </div>
       <div class="col-8">
           <ul class="list-group">
               <c:forEach var="apartment" items="${listApartment}">
                   <li class="list-group-item">
                       <div class="card" style="width: 100%;">
<%--                           <p>${apartment.imageList.get(0)}</p>--%>
                           <img class="card-img-top" src="<c:url value="/template/static/uploadfile/${apartment.logo.url}"/>" alt="Card image cap">
                           <div class="card-body">
                               <h5 class="card-title">${apartment.name}</h5>
                               <p class="card-text">${apartment.shotDescribe}</p>
                               <br>
                               <p class="card-text">Adress: ${apartment.addressApartment}</p>

                               <a href=""  class="btn btn-primary">Details</a>
                           </div>
                       </div>
                   </li>
               </c:forEach>


           </ul>
       </div>
   </div>
</div>

