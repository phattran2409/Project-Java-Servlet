<%-- Document : shop.jsp Created on : Jun 12, 2024, 5:00:30 PM Author : ADMIN --%>
<%@page import="model.Customer.Customer"%>
<%@page import="model.Product.CategoryDAO" %>
<%@page import="model.Product.Category" %>
<%@page import="model.Product.ProductDAO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.List" %>
<%@page import="model.Product.Product" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
 <!DOCTYPE html>
 <html lang="en">

     <head>
         <title>Zay Shop - Product Listing Page</title>
         <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">

         <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
         <link rel="shortcut icon" type="image/x-icon"
               href="assets/img/favicon.ico">

         <link rel="stylesheet" href="assets/css/bootstrap.min.css">
         <link rel="stylesheet" href="assets/css/templatemo.css">
         <link rel="stylesheet" href="assets/css/custom.css">
         <link rel="stylesheet" href="assets/css/toast.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">


         <!-- Load fonts style after rendering the layout styles -->
         <link rel="stylesheet"
               href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
         <link rel="stylesheet" href="assets/css/fontawesome.min.css">

         <link rel="stylesheet"
               href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
               integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
               crossorigin="anonymous" referrerpolicy="no-referrer" />


     </head>

     <body>
         <!-- Start Top Nav -->
         <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block"
              id="templatemo_nav_top">
             <div class="container text-light">
                 <div class="w-100 d-flex justify-content-between">
                     <div>
                         <i class="fa fa-envelope mx-2"></i>
                         <a class="navbar-sm-brand text-light text-decoration-none"
                            href="mailto:info@company.com">info@company.com</a>
                         <i class="fa fa-phone mx-2"></i>
                         <a class="navbar-sm-brand text-light text-decoration-none"
                            href="tel:010-020-0340">010-020-0340</a>
                     </div>
                     <div>
                         <a class="text-light" href="https://fb.com/templatemo"
                            target="_blank" rel="sponsored"><i
                                 class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                         <a class="text-light" href="https://www.instagram.com/"
                            target="_blank"><i
                                 class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                         <a class="text-light" href="https://twitter.com/"
                            target="_blank"><i
                                 class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                         <a class="text-light" href="https://www.linkedin.com/"
                            target="_blank"><i
                                 class="fab fa-linkedin fa-sm fa-fw"></i></a>
                     </div>
                 </div>
             </div>
         </nav>
         <!-- Close Top Nav -->
         

         <!-- Header -->
         <nav class="navbar navbar-expand-lg navbar-light shadow">
             <div
                 class="container d-flex justify-content-between align-items-center">

                 <a class="navbar-brand text-success logo h1 align-self-center"
                    href="index.jsp">
                     ShoesStore
                 </a>

                 <button class="navbar-toggler border-0" type="button"
                         data-bs-toggle="collapse"
                         data-bs-target="#templatemo_main_nav"
                         aria-controls="navbarSupportedContent" aria-expanded="false"
                         aria-label="Toggle navigation">
                     <span class="navbar-toggler-icon"></span>
                 </button>

                 <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between"
                      id="templatemo_main_nav">
                     <div class="flex-fill">
                         <ul
                             class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                             <li class="nav-item">
                                 <a class="nav-link" href="index.jsp">Home</a>
                             </li>
                             <li class="nav-item">
                                 <a class="nav-link" href="about.html">About</a>
                             </li>
                             <li class="nav-item">
                                 <a class="nav-link" href="shop.jsp">Shop</a>
                             </li>
                             <li class="nav-item">
                                 <a class="nav-link"
                                    href="contact.html">Contact</a>
                             </li>
                         </ul>
                     </div>
                     <div class="navbar align-self-center d-flex">
                         <div
                             class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                             <div class="input-group">
                                 <input type="text" class="form-control"
                                        id="inputMobileSearch"
                                        placeholder="Search ...">
                                 <div class="input-group-text">
                                     <i class="fa fa-fw fa-search"></i>
                                 </div>
                             </div>
                         </div>
                         <a class="nav-icon d-none d-lg-inline" href="#"
                            data-bs-toggle="modal"
                            data-bs-target="#templatemo_search">
                             <i class="fa fa-fw fa-search text-dark mr-2"></i>
                         </a>
                         <!-- Session User Customer  -->
                          <c:set var="User" value="${sessionScope.loginUser}"/>
                        <input id="C_ID" value="${User.getID()}" hidden> 
                        
                    <c:if test="${User != null}">
                         <a class="nav-icon position-relative text-decoration-none" href="loadCart">
                        <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                        <span
                            class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">${sessionScope.cartCount}</span>
                    </a>
                    <!-- Wish List -->
                    <a class="nav-icon position-relative text-decoration-none" href="">
                        <i class="fa fa-fw far fa-heart text-dark mr-1"></i>
                        <span
                            class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                    </a>
                    <a class="nav-icon position-relative text-decoration-none" href="#" id="btn-user-dropdown">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span
                            class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                    </a>
                    
                      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="dropdown-menu">
                                <a class="dropdown-item" href="OrderHistory">Orders History</a>

                            </div>

                    </c:if>
                    <c:if test="${User == null}">
                    <a href="login?page=shop" class="btn btn-success mx-3 text-light text-decoration-none text" style="width:100px ; height: auto; font-weight: 900;" > 
                        <span>Login</span>
                    </a>
                    </c:if>
                     </div>
                 </div>

             </div>
         </nav>
         <!-- Close Header -->

         <!-- Modal -->
         <div class="modal fade bg-white" id="templatemo_search" tabindex="-1"
              role="dialog" aria-labelledby="exampleModalLabel"
              aria-hidden="true">
             <div class="modal-dialog modal-lg" role="document">
                 <div class="w-100 pt-1 mb-5 text-right">
                     <button type="button" class="btn-close"
                             data-bs-dismiss="modal" aria-label="Close"></button>
                 </div>
                 <form action="MainController" method="get"
                       class="modal-content modal-body border-0 p-0">
                     <div class="input-group mb-2">
                         <input type="text" class="form-control"
                                id="inputModalSearch" name="searchByName" 
                                placeholder="Search ...">
                         <button type="submit"
                                 class="input-group-text bg-success text-light" name="action" value="search">
                             <i class="fa fa-fw fa-search text-white"></i>
                         </button>
                     </div>
                 </form>
             </div>
         </div>

         <!-- Toast -->
         <div id="toast">
            
         </div>

         <!-- Start Content -->
         <div class="container py-5">
             <div class="row">

                 <div class="col-lg-3">
                     <div class="category"
                          style="width: auto; height: auto;  position: sticky; position: -webkit-sticky; top:1rem">
                         <h1 class="h2 pb-4">Categories</h1>
                         <ul class="list-unstyled templatemo-accordion">
                             <li class="pb-3">
                                 <a class="collapsed d-flex justify-content-between h3 text-decoration-none"
                                    href="#">
                                     Shop by Price
                                     <i
                                         class="fa fa-fw fa-chevron-circle-down mt-1"></i>
                                 </a>
                                 <ul class="collapse show list-unstyled pl-3">
                                     <form method="GET" action="MainController">

                                         <li><input type="radio"
                                                    class="text-decoration-none mx-2 form-check-input"
                                                    name="price" value="0-50"> Under
                                             50</li>
                                         <li><input type="radio"
                                                    class="text-decoration-none mx-2 form-check-input"
                                                    name="price"
                                                    value="50-100">50$-100$</li>
                                         <li><input type="radio"
                                                    class="text-decoration-none mx-2 form-check-input"
                                                    name="price"
                                                    value="100-200">100$-200$</li>
                                         <li><input type="radio"
                                                    class="text-decoration-none mx-2 form-check-input"
                                                    name="price"
                                                    value="200-300">More 200$</li>
                                         <li>
                                             <button type="submit"
                                                     class="btn btn-success mt-3"
                                                     name="action"
                                                     value="Search Price">
                                                 <span>Search</span>
                                                 <i class="fa fa-search"></i>
                                             </button>
                                         </li>

                                     </form>

                             </li>
                             <li class="pb-3">
                                 <a class="collapsed d-flex justify-content-between h3 text-decoration-none"
                                    href="#">
                                     Sale
                                     <i
                                         class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                                 </a>
                                 <% List<Category> listCate = new ArrayList<>();

                                     CategoryDAO Catedao = new CategoryDAO();
                                     listCate = Catedao.getCategoryName();

                                 %>
                                 <ul id="collapseTwo"
                                     class="collapse show list-unstyled pl-3">
                                     <% for (Category C : listCate) {%>
                                     <li><a class="text-decoration-none"
                                            href="MainController?CateID=<%=C.getCategoryID()%>&action=onSale">
                                             <%=C.getCateName()%>
                                         </a>

                                     </li>

                                     <% } %>
                                 </ul>
                             </li>
                             <li class="pb-3">
                                 <a class="collapse d-flex justify-content-between h3 text-decoration-none"
                                    href="#c">
                                     Product
                                     <i
                                         class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                                 </a>
                                 <ul id="collapseThree"
                                     class="collapse show list-unstyled pl-3">

                                     <% for (Category cate : listCate) {%>

                                     <li><a class="text-decoration-none"
                                            href="MainController?CateID=<%=cate.getCategoryID()%>&action=Category">
                                             <%= cate.getCateName()%>
                                         </a></li>

                                     <% } %>
                                 </ul>
                             </li>
                         </ul>
                     </div>
                 </div>

                 <div class="col-lg-9">
                     <div class="row">



                         <div class="col-md-6 pb-4">
                             <div class="d-flex w-100">
                                 <form method="GET" action="MainController"
                                       class="d-flex justify-content-center  align-items-center w-100">
                                     <select class="form-control" name="option"
                                             id="filter">
                                         <option value="featured">
                                             Featured
                                         </option>
                                         <option value="AtoZ">A to Z</option>
                                         <option value="ZtoA"> Z to A</option>

                                     </select>
                                     <button type="submit" name="action"
                                             value="filter" id="btn-fillter"
                                             class="btn btn-secondary">

                                         <i class="fa fa-filter"></i>
                                     </button>
                                 </form>
                             </div>
                         </div>
                     </div>
                     <div class="row" id="content">
                         <% ProductDAO dao = new ProductDAO();
                             List<Product> list
                                     = new ArrayList<>();
                             if (request.getAttribute("list") != null) {
                                 list = (List<Product>) request.getAttribute("list");

                             } else {
                                 list = dao.getLimitProduct(1);
                             }
                             Customer User = new  Customer();
                             if(session.getAttribute("loginUser") != null) {
                                User  = (Customer) session.getAttribute("loginUser");
                             }
                            
                         %>
                      
                         <% for (Product P : list) {%>
                         <!-- Card image  -->
                          
                         <div class="col-md-4 product">
                             <div class="card mb-4  product-wap rounded-0
                                  ">
                                 <div class="card rounded-0">

                                     <img class="card-img rounded-0 img-fluid"
                                          src="<%= P.getImage()%> "
                                          id="img">
                                     <div
                                         class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                         <ul
                                             class="list-unstyled">
                                             <li><a class="btn btn-success text-white addWishList"
                                                    href="" data-id="<%= P.getProductID() %>"><i
                                                         class="far fa-heart"></i></a>
                                             </li>
                                             <li><a class="btn btn-success text-white mt-2"
                                                    href="shop-single.html"><i
                                                         class="far fa-eye"></i></a>
                                             </li>
                                             <li><a class="btn btn-success text-white mt-2 addtocart"
                                                    href="#"  id="getP_ID" data-id="<%= P.getProductID()%> "><i
                                                         class="fas fa-cart-plus"></i></a>
                                             </li>
                                         </ul>
                                     </div>
                                     <!-- Badges  -->
                                     <% if (P.getDiscount() != 0) {%>
                                     <div
                                      
                                         class="badge-sale badge-top-left">
                                         <span> Sale off  <%= Math.round( P.getDiscount() * 100) %> %
                                                                                                           
                                         </span>
                                     </div>
                                     <% }%>
                                 </div>

                                 

                                 <!--  Card  body  -->
                                 <div class="card-body" id="card-body"> 
                                    <!-- Product ID -->
                                    <input type="text" id="P_ID" value="<%=P.getProductID() %>">
                                    <!-- Product Name -->
                                     <a href="MainController?ID=<%=P.getProductID()%>&action=SingleProduct"
                                        class="h3 text-decoration-none text-product text-truncate d-inline-block"
                                        style="max-width: 100%;"
                                        id="Name">
                                         <%= P.getProductName()%>
                                     </a>
                                     <ul
                                         class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                         <li></li>
                                         <li class="pt-2">
                                             <span
                                                 class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                             <span
                                                 class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                             <span
                                                 class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                             <span
                                                 class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                             <span
                                                 class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                         </li>
                                     </ul>
                                     <ul
                                         class="list-unstyled d-flex justify-content-center mb-1">
                                         <li>
                                             <i
                                                 class="text-warning fa fa-star"></i>
                                             <i
                                                 class="text-warning fa fa-star"></i>
                                             <i
                                                 class="text-warning fa fa-star"></i>
                                             <i
                                                 class="text-muted fa fa-star"></i>
                                             <i
                                                 class="text-muted fa fa-star"></i>
                                         </li>
                                     </ul>

                                     <% if (P.getDiscount() != 0) {%>
                                     <div
                                         class="Price d-flex align-items-center justify-content-around">
                                         <p
                                             class=" current-price text-decoration-line-through">
                                             <%= P.getPrice()%> $
                                         </p>

                                         <p
                                             class=" new-price text-danger">
                                             <%=P.getNewPrice()%>
                                             $
                                         </p>


                                     </div>
                                     <% } else {%>
                                     <p
                                         class="text-center mt-2 mb-2 current-price">
                                         <%= P.getPrice()%> $
                                     </p>
                                     <% } %>
                                 </div>
                             </div>
                         </div>
                         <% } %>




                     </div>
                         
                         <!-- Load more -->
                     <c:set var="action" value="${requestScope.action}"/>
                     <c:set var="option_Category" value="${requestScope.option}"/>
                    
                     <c:if test="${option_Category == 'Category'}"> 
                       
                     <input id="price1" name="price1" value="${price1}" hidden>
                     <input id="price2" type="" name="price2" value="${price2}"
                            hidden>
                     <input  id="CateID"  value="${CateID}" hidden>
                     <input  id="action_CateID"  value="${requestScope.action}" hidden >
                     <c:choose>
                         <c:when  test="${CateID == null}">
                              <button class="btn btn-primary" onclick="loadMore()"> Load
                             More </button> 
                         </c:when>
                         <c:when test="${CateID != null}">
                                <button class="btn btn-outline-danger" onclick="loadMoreCategory_Product()"> Load
                                More </button>
                         </c:when>  
                     </c:choose>
                     
                     </c:if>
                     
                     <c:if test="${action == 'filter'}">
                         <input id="action" value="${requestScope.action}" hidden >
                         <input id="option" value="${sessionScope.option}" hidden >
                         <button class="btn btn-secondary" onclick="loadMoreFill()"> Load
                             More </button>  
                     </c:if>
                     
                 </div>
                 <!-- Pagination  -->
                 <% int count = dao.count();
                     int endPage = 0;
                     if (count > 6) {
                         endPage = count / 6;
                         if (count % 6 != 0) {
                             endPage++;
                         }
                     }
                 %>

                 <div div="row">
                     <ul
                         class="pagination  pagination-lg justify-content-end">
                         <% String option = "";
                             if (session.getAttribute("option") != null) {
                                 option = (String) session.getAttribute("option");
                             }
                              %>


                         <c:set var="index" value="${tabindex}" />
                         <c:forEach begin="1" end="<%= endPage%>"
                                    var="i">

                             <li class="page-item">
                                 <a class="page-link ${index==i?"active":""} "rounded-0 mr-3 shadow-sm
                                    border-top-0 border-left-0"
                                    href="shop?tagIndex=${i}&option=<%= option%>">${i}</a>

                             </li>

                         </c:forEach>

                         
                             

                     </ul>

                 </div>
                 <!-- Pagination for search price  -->


             </div>

         </div>
     </div>
     <!-- End Content -->

     <!-- Start Brands -->
     <section class="bg-light py-5">
         <div class="container my-4">
             <div class="row text-center py-3">
                 <div class="col-lg-6 m-auto">
                     <h1 class="h1">Our Brands</h1>
                     <p>
                         Lorem ipsum dolor sit amet, consectetur adipisicing
                         elit,
                         sed do eiusmod
                         Lorem ipsum dolor sit amet.
                     </p>
                 </div>
                 <div class="col-lg-9 m-auto tempaltemo-carousel">
                     <div class="row d-flex flex-row">
                         <!--Controls-->
                         <div class="col-1 align-self-center">
                             <a class="h1" href="#multi-item-example"
                                role="button" data-bs-slide="prev">
                                 <i
                                     class="text-light fas fa-chevron-left"></i>
                             </a>
                         </div>
                         <!--End Controls-->

                         <!--Carousel Wrapper-->
                         <div class="col">
                             <div class="carousel slide carousel-multi-item pt-2 pt-md-0"
                                  id="multi-item-example"
                                  data-bs-ride="carousel">
                                 <!--Slides-->
                                 <div class="carousel-inner product-links-wap"
                                      role="listbox">

                                     <!--First slide-->
                                     <div class="carousel-item active">
                                         <div class="row">
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_01.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_02.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_03.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_04.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                         </div>
                                     </div>
                                     <!--End First slide-->

                                     <!--Second slide-->
                                     <div class="carousel-item">
                                         <div class="row">
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_01.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_02.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_03.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_04.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                         </div>
                                     </div>
                                     <!--End Second slide-->

                                     <!--Third slide-->
                                     <div class="carousel-item">
                                         <div class="row">
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_01.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_02.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_03.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                             <div class="col-3 p-md-5">
                                                 <a href="#"><img
                                                         class="img-fluid brand-img"
                                                         src="assets/img/brand_04.png"
                                                         alt="Brand Logo"></a>
                                             </div>
                                         </div>
                                     </div>
                                     <!--End Third slide-->

                                 </div>
                                 <!--End Slides-->
                             </div>
                         </div>
                         <!--End Carousel Wrapper-->

                         <!--Controls-->
                         <div class="col-1 align-self-center">
                             <a class="h1" href="#multi-item-example"
                                role="button" data-bs-slide="next">
                                 <i
                                     class="text-light fas fa-chevron-right"></i>
                             </a>
                         </div>
                         <!--End Controls-->
                     </div>
                 </div>
             </div>
         </div>
     </section>
     <!--End Brands-->


     <!-- Start Footer -->
     <footer class="bg-dark" id="tempaltemo_footer">
         <div class="container">
             <div class="row">

                 <div class="col-md-4 pt-5">
                     <h2
                         class="h2 text-success border-bottom pb-3 border-light logo">
                         Zay Shop</h2>
                     <ul class="list-unstyled text-light footer-link-list">
                         <li>
                             <i class="fas fa-map-marker-alt fa-fw"></i>
                             123 Consectetur at ligula 10660
                         </li>
                         <li>
                             <i class="fa fa-phone fa-fw"></i>
                             <a class="text-decoration-none"
                                href="tel:010-020-0340">010-020-0340</a>
                         </li>
                         <li>
                             <i class="fa fa-envelope fa-fw"></i>
                             <a class="text-decoration-none"
                                href="mailto:info@company.com">info@company.com</a>
                         </li>
                     </ul>
                 </div>

                 <div class="col-md-4 pt-5">
                     <h2
                         class="h2 text-light border-bottom pb-3 border-light">
                         Products</h2>
                     <ul class="list-unstyled text-light footer-link-list">
                         <li><a class="text-decoration-none"
                                href="#">Luxury</a></li>
                         <li><a class="text-decoration-none" href="#">Sport
                                 Wear</a>
                         </li>
                         <li><a class="text-decoration-none" href="#">Men's
                                 Shoes</a>
                         </li>
                         <li><a class="text-decoration-none" href="#">Women's
                                 Shoes</a></li>
                         <li><a class="text-decoration-none" href="#">Popular
                                 Dress</a></li>
                         <li><a class="text-decoration-none" href="#">Gym
                                 Accessories</a></li>
                         <li><a class="text-decoration-none" href="#">Sport
                                 Shoes</a>
                         </li>
                     </ul>
                 </div>

                 <div class="col-md-4 pt-5">
                     <h2
                         class="h2 text-light border-bottom pb-3 border-light">
                         Further Info</h2>
                     <ul class="list-unstyled text-light footer-link-list">
                         <li><a class="text-decoration-none"
                                href="#">Home</a></li>
                         <li><a class="text-decoration-none" href="#">About
                                 Us</a>
                         </li>
                         <li><a class="text-decoration-none" href="#">Shop
                                 Locations</a></li>
                         <li><a class="text-decoration-none"
                                href="#">FAQs</a></li>
                         <li><a class="text-decoration-none"
                                href="#">Contact</a>
                         </li>
                     </ul>
                 </div>

             </div>

             <div class="row text-light mb-4">
                 <div class="col-12 mb-3">
                     <div class="w-100 my-3 border-top border-light"></div>
                 </div>
                 <div class="col-auto me-auto">
                     <ul class="list-inline text-left footer-icons">
                         <li
                             class="list-inline-item border border-light rounded-circle text-center">
                             <a class="text-light text-decoration-none"
                                target="_blank"
                                href="http://facebook.com/"><i
                                     class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                         </li>
                         <li
                             class="list-inline-item border border-light rounded-circle text-center">
                             <a class="text-light text-decoration-none"
                                target="_blank"
                                href="https://www.instagram.com/"><i
                                     class="fab fa-instagram fa-lg fa-fw"></i></a>
                         </li>
                         <li
                             class="list-inline-item border border-light rounded-circle text-center">
                             <a class="text-light text-decoration-none"
                                target="_blank"
                                href="https://twitter.com/"><i
                                     class="fab fa-twitter fa-lg fa-fw"></i></a>
                         </li>
                         <li
                             class="list-inline-item border border-light rounded-circle text-center">
                             <a class="text-light text-decoration-none"
                                target="_blank"
                                href="https://www.linkedin.com/"><i
                                     class="fab fa-linkedin fa-lg fa-fw"></i></a>
                         </li>
                     </ul>
                 </div>
                 <div class="col-auto">
                     <label class="sr-only" for="subscribeEmail">Email
                         address</label>
                     <div class="input-group mb-2">
                         <input type="text"
                                class="form-control bg-dark border-light"
                                id="subscribeEmail" placeholder="Email address">
                         <div
                             class="input-group-text btn-success text-light">
                             Subscribe</div>
                     </div>
                 </div>
             </div>
         </div>

         <div class="w-100 bg-black py-3">
             <div class="container">
                 <div class="row pt-2">
                     <div class="col-12">
                         <p class="text-left text-light">
                             Copyright &copy; 2021 Company Name
                             | Designed by <a rel="sponsored"
                                              href="https://templatemo.com"
                                              target="_blank">TemplateMo</a>
                         </p>
                     </div>
                 </div>
             </div>
         </div>

     </footer>
     <!-- End Footer -->

     <!-- Start Script -->
     <script src="assets/js/jquery-1.11.0.min.js"></script>
     <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
     <script src="assets/js/bootstrap.bundle.min.js"></script>
     <script src="assets/js/templatemo.js"></script>
     <script src="assets/js/custom.js"></script>
     <script
     src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
     <!-- End Script -->
     <script> 
           var btnDropDown = document.getElementById("btn-user-dropdown")
            var Menu = document.getElementById("dropdown-menu")
            btnDropDown.addEventListener('click', () => {
                if (Menu.classList.contains('show')) {
                    Menu.classList.remove('show')
                } else {
                    Menu.classList.toggle('show')
                }
            })
      </script>
 </body>

</html>