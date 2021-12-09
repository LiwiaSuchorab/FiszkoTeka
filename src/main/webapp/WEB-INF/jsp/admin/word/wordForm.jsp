<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<body>
<%@include file="../../../../header_footer/header.jsp"%>
<%@include file="../../../../header_footer/footer.jsp"%>
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



        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form:form modelAttribute="word">
                <form:hidden path="id"/>
                <div class="form-group">
                    <form:input path="firstWord" type="text" class="form-control" id="name" name="name" placeholder="Podaj słowo w języku Angielskim"/>
                    <form:errors path="firstWord"/><br>
                </div>
                <div class="form-group">
                    <form:input path="secondWord" type="text" class="form-control" id="surname" name="surname" placeholder="Podaj słowo w języku Polskim"/>
                    <form:errors path="secondWord"/><br>
                </div>
                <div class="form-group">
                    <form:input type="firstSentence" path="firstSentence" class="form-control" id="firstSentence" name="firstSentence" placeholder="Podaj zdanie w języku Angielskim"/>
                    <form:errors path="firstSentence"/><br>
                </div>
                    <div class="form-group">
                        <form:select path="categories" items="${categories}" itemLabel="nameCategory" itemValue="id"/><br>
                        <form:errors path="categories" cssClass="error"/> <br>
                    </div>

                    <input type="submit" value="Zapisz">
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>


