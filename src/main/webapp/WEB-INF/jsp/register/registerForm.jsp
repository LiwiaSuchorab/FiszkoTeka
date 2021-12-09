<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<body>
<%@include file="../../../header_footer/header.jsp"%>
<%@include file="../../../header_footer/footer.jsp"%>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            Fiszko <span>Teka</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/login">logowanie</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/users/add">rejestracja</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="/about">o aplikacji</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/app/recipe/list">Fiszki</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/contact">Kontakt</a>
            </li>
        </ul>
    </nav>
</header>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->


                <form:form modelAttribute="users">
                <form:hidden path="id"/>
                    <h1 class="text-color-darker">Rejestracja</h1>
                    <div class="form-group">
                        <form:input path="firstName" type="text" class="form-control" id="name" name="name" placeholder="Podaj imię"/>
                        <form:errors path="firstName"/><br>
                    </div>
                    <div class="form-group">
                        <form:input path="lastName" type="text" class="form-control" id="surname" name="surname" placeholder="podaj nazwisko"/>
                        <form:errors path="lastName"/><br>
                    </div>
                    <div class="form-group">
                        <form:input type="email" path="email" class="form-control" id="email" name="email" placeholder="podaj email"/>
                        <form:errors path="email"/><br>
                    </div>
                    <div class="form-group">
                        <form:input type="password" path="password" class="form-control" id="password" name="password" placeholder="podaj hasło"/>
                        <form:errors path="password"/><br>
                    </div>
                    <input type="submit" value="Zarejestruj">
                </form:form>
            </div>
        </div>
    </div>
</section>
