<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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




        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding"><h3 class="color-header text-uppercase">Lista kategorii</h3></div>
                    <sec:authorize access="hasAnyAuthority('ADMIN')">
                        <div class="col noPadding d-flex justify-content-end mb-2"><a href="/admin/category/add" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj kategorie</a></div>
                    </sec:authorize>
                </div>
                <table class="table border-bottom schedules-content">
                    <thead>
                    <tr class="d-flex text-color-darker">
                        <th scope="col" class="col-1"></th>
                        <th scope="col" class="col-7">Nazwa kategorii</th>
                        <th scope="col" class="col-2"> </th>
                        <th scope="col" class="col-2 center"> </th>
                    </tr>
                    </thead>
                    <tbody class="text-color-lighter">
                    <c:forEach items="${category}" var="category">
                        <tr class="d-flex">
                            <th scope="row" class="col-1"></th>
                            <td class="col-7">${category.nameCategory}</td>
                            <td class="col-2"> </td>
                            <td class="col-2 d-flex align-items-center justify-content-center flex-wrap">
                                <sec:authorize access="hasAnyAuthority('ADMIN')">
                                <%--<a href="/admin/category/remove?toRemoveId=${category.id}" class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz usunąć tą kategorie?');">Usuń</a>--%>
                                <a href="/admin/category/edit?idToEdit=${category.id}" class="btn btn-warning rounded-0 text-light m-1">Edytuj</a>
                                </sec:authorize>
                                <a href="/user/word/category?idCategory=${category.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>