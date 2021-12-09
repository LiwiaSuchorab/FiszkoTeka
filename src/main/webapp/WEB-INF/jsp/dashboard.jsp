<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<body>
<%@include file="../../header_footer/header.jsp"%>
<%@include file="../../header_footer/footer.jsp"%>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-between">
        <a href="/dashboard" class="navbar-brand main-logo main-logo-smaller">
            Fiszko <span>Teka</span>
        </a>
        <div class="d-flex justify-content-around">
            <h4 class="text-light mr-3">
                <sec:authentication property="principal.fullName"/>
            </h4>
            <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
        </div>
    </nav>
</header>

<section class="dashboard-section">
    <div id=container class="row dashboard-nowrap">
        <ul class="nav flex-column long-bg">
            <li class="nav-item">
                <a class="nav-link" href="/dashboard">
                    <span>Pulpit</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/word/all">
                    <span>Słowa</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/wordUser/all">
                    <span>Słowa Użytkownika</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/category/all">
                    <span>Kategorie</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <sec:authorize access="hasAnyAuthority('ADMIN')">
            <li class="nav-item">
                <a class="nav-link" href="/register/all">
                    <span>Użytkownicy</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            </sec:authorize>
            <li class="nav-item">
                <a class="nav-link disabled" href="/">
                    <span>Wyloguj</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
        </ul>

        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="/user/excise/all">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">Ćwicz słowa</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/user/exciseUser/all">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">Ćwicz swoje słowa</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

