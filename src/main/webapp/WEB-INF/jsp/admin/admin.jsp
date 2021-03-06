<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${cookie.userLanguage.value != null ? cookie.userLanguage.value : sessionScope.defaultLanguage}"/>
<c:set var="userRole" value="${cookie.role.value != null ? cookie.role.value : sessionScope.role}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="MovieRating">
    <meta name="keywords" content="Movie, MovieRating">
    <meta name="author" content="Sergey Podgaysky">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/sidebar-menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/login-modal-style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/top-navbar.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/loader.js"></script>
    <%--<script src="${pageContext.request.contextPath}/js/bootstrap-show-password.min.js"></script>--%>
    <link href="https://fonts.googleapis.com/css?family=Lato|Nunito|Open+Sans|Oxygen|Poppins|Roboto" rel="stylesheet">
    <title>MovieRating</title>
</head>
<body>
<div class="loader"></div>
<div class="container-fluid container-wrapper">
    <div class="row content-wrapper">
        <div class="col-sm-2 col__padding_0">
            <c:import url="../template/admin-navside-menu.jsp"/>
        </div>
        <div class="col-sm-10 col__padding_0">
            <c:import url="../template/header.jsp"/>
        </div>
    </div>
            <c:import url="/WEB-INF/jsp/template/footer.jsp"/>
</div>
</body>
</html>

