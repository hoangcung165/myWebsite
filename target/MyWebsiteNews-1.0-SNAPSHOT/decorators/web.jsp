<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>
        <dec:title default="Home page"/>
    </title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/template/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/template/css/blog-home.css"/>" rel="stylesheet">
</head>
<body>
    <%@include file="/common/web/header.jsp"%>
    <dec:body></dec:body>
    <%@include file="/common/web/footer.jsp"%>

<script src="<c:url value="/template/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/template/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>
