<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <title>Zay Shop eCommerce HTML CSS Template</title>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">

                <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
                <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

                <link rel="stylesheet" href="assets/css/bootstrap.min.css">
                <link rel="stylesheet" href="assets/css/templatemo.css">
                <link rel="stylesheet" href="assets/css/custom.css">
                <link rel="stylesheet" href="./assets/css/cart.css">

                <!-- Load fonts style after rendering the layout styles -->
                <link rel="stylesheet"
                    href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
                <link rel="stylesheet" href="assets/css/fontawesome.min.css">
                <!--

TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

        -->
            </head>

            <body>
                <!-- Start Top Nav -->
                <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
                    <div class="container-fluid text-light">
                        <div class="w-100 d-flex justify-content-between">
                            <div>
                                <i class="fa fa-envelope mx-2"></i>
                                <a class="navbar-sm-brand text-light text-decoration-none"
                                    href="mailto:info@company.com">ShoeStore@company.com</a>
                                <i class="fa fa-phone mx-2"></i>
                                <a class="navbar-sm-brand text-light text-decoration-none"
                                    href="tel:010-020-0340">010-020-0340</a>
                            </div>
                            <div>
                                <a class="text-light" href="https://fb.com/templatemo" target="_blank"
                                    rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                                <a class="text-light" href="https://www.instagram.com/" target="_blank"><i
                                        class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                                <a class="text-light" href="https://twitter.com/" target="_blank"><i
                                        class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                                <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i
                                        class="fab fa-linkedin fa-sm fa-fw"></i></a>
                            </div>
                        </div>
                    </div>
                </nav>
                <!-- Close Top Nav -->


                <!-- Header -->
                <nav class="navbar navbar-expand-lg navbar-light shadow">
                    <div class="container d-flex justify-content-between align-items-center">

                        <a class="navbar-brand text-success logo h1 align-self-center" href="index.jsp">
                            ShoesStore
                        </a>

                        <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse"
                            data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between"
                            id="templatemo_main_nav">
                            <div class="flex-fill">
                                <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                                    <li class="nav-item">
                                        <a class="nav-link" href="index.html">Home</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="about.html">About</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="shop.jsp">Shop</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="contact.html">Contact</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="navbar align-self-center d-flex">
                                <div
                                    class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3 justify-content-center align-content-center">
                                    <div class="input-group">
                                        <input type="text" class="form-control" id="inputMobileSearch"
                                            placeholder="Search ...">
                                        <div class="input-group-text">
                                            <i class="fa fa-fw fa-search"></i>
                                        </div>
                                    </div>
                                </div>
                                <c:set var="User" value="${sessionScope.loginUser}" />

                                <c:if test="${User != null}">
                                    <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal"
                                        data-bs-target="#templatemo_search">
                                        <i class="fa fa-fw fa-search text-dark mr-2"></i>
                                    </a>
                                    <a class="nav-icon position-relative text-decoration-none" href="#">
                                        <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                                        <span
                                            class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">${countCart}</span>
                                    </a>

                                    <a class=" nav-icon position-relative text-decoration-none" href="#"
                                        id="btn-user-dropdown">
                                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                                        <span
                                            class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>

                                    </a>

                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="dropdown-menu">
                                        <a class="dropdown-item" href="OrderHistory">Orders History</a>

                                    </div>

                                </c:if>
                                <c:if test="${User == null}">
                                    <a href="login.jsp"
                                        class="btn btn-success mx-3 text-light text-decoration-none text"
                                        style="width:100px ; height: auto; font-weight: 900;">
                                        <span>Login</span>
                                    </a>
                                </c:if>
                            </div>
                        </div>

                    </div>
                </nav>
                <!-- Close Header -->

                <!-- Modal -->
                <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog"
                    aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="w-100 pt-1 mb-5 text-right">
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form action="" method="get" class="modal-content modal-body border-0 p-0">
                            <div class="input-group mb-2">
                                <input type="text" class="form-control" id="inputModalSearch" name="q"
                                    placeholder="Search ...">
                                <button type="submit" class="input-group-text bg-success text-light">
                                    <i class="fa fa-fw fa-search text-white"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>


                <div class="container">
                    <div class="content">
                        <h1 class="page-header mb-5" id="UserGetID" value="${User.getID()}"> ${User.getFirstName()} Cart
                        </h1>
                        <data class="page-content">
                            <div class="row">
                                <!-- show Cart -->
                                <div class="boxCart leftCart col-md-8 col-sm-12 col-xs-12 ">
                                    <div class="cart_header_labels hidden-xs clearfix">
                                        <div class="row" id="TH">
                                            <div class="label_item col-sm-2 ">
                                                <div class="cart_product first_item ">
                                                    Product
                                                </div>
                                            </div>
                                            <div class="label_item col-sm-3 ">
                                                <div class="cart_description item">
                                                    Name
                                                </div>
                                            </div>
                                            <div class="label_item col-sm-2">
                                                <div class="cart_price item  ">
                                                    Price
                                                </div>
                                            </div>
                                            <div class="label_item col-sm-1">
                                                <div class="cart_delete last_item">
                                                    Delete
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="ajax_content_cart">
                                        <c:forEach var="P" items="${listCart}">
                                            <div class="line-item list_product_cart clearfix" data-handle="" data-id="">
                                                <div class="row d-flex align-items-center my-2" id="TD">
                                                    <!-- image Cart -->
                                                    <div class="cpro_item image col-md-2">


                                                        <div class="cpro_item_inner">
                                                            <a href="" class="cart__image">
                                                                <img class="img-responsive" src="${P.getImage()}"
                                                                    alt="${P.getProductName()}">
                                                            </a>
                                                        </div>

                                                    </div>
                                                    <!-- product Name -->
                                                    <div class="cpro_item text-left title col-md-3">
                                                        <div class="cpro_item_inner">
                                                            <a href="#" class="product_name">
                                                                ${P.getProductName()}
                                                            </a>

                                                        </div>
                                                    </div>
                                                    <!-- price aftter Discount  -->
                                                    <c:set var="newPrice" value="${P.getNewPrice()}" />
                                                    <c:set var="discount" value="${P.getDiscount()}" />
                                                    <c:if test="${discount > 0}">
                                                        <div class="cpro_item price col-md-2">
                                                            <div class="cpro_item_inner">
                                                                <span class="price product-price PriceNotChange">
                                                                    <span class="money" id="money"
                                                                        data-id="${P.getProductID()}">${newPrice}</span>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <!-- Old Price -->
                                                    <c:if test="${discount == 0}">
                                                        <div class="cpro_item price col-md-2">
                                                            <div class="cpro_item_inner">
                                                                <span class="price product-price PriceNotChange">
                                                                    <span class="money" id="money"
                                                                        data-id="${P.getProductID()}">${P.getPrice()}</span>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </c:if>

                                                    <!-- quantity -->
                                                    <div class="cpro_item qty text-center col-xs-6 col-sm-2 col-md-2">
                                                        <div class="cpro_item_inner">
                                                            <div class="ajaxcart__qty quantity-partent">
                                                                <input type="number"
                                                                    class="ajaxcart__qty-num line-item-qty"
                                                                    data-title="${P.getProductName()}" min="1"
                                                                    value="${P.getQuantity()}" aria-label="quantity"
                                                                    pattern="[0-9]*" data-buyone="True" data-max="35"
                                                                    id="Add_Quantity" data-id="${P.getProductID()}">
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <!-- total price-->

                                                    <!-- price After Discount  -->
                                                    <c:if test="${discount > 0}">
                                                        <c:set var="Price_Discount"
                                                            value="${newPrice *P.getQuantity() }" />
                                                        <div
                                                            class="cpro_item line-price col-xs-12 col-sm-2 col-md-2 hidden-xs">
                                                            <div class="cpro_item_inner">
                                                                <span class="price product-price money_line"><span
                                                                        class="moneyOfProduct"
                                                                        data-value="${Price_Discount}">
                                                                        ${Price_Discount}
                                                                    </span></span>
                                                                <input type="hidden" value="" data-id="1093666684"
                                                                    class="line_money_temp">
                                                            </div>
                                                        </div>
                                                    </c:if>

                                                    <c:if test="${discount ==  0}">
                                                        <c:set var="Price_Not_Discount"
                                                            value=" ${P.getPrice() * P.getQuantity()}" />
                                                        <div
                                                            class="cpro_item line-price col-xs-12 col-sm-2 col-md-2 hidden-xs">
                                                            <div class="cpro_item_inner">
                                                                <span class="price product-price money_line">
                                                                    <span class="moneyOfProduct" id="moneyOfProduct"
                                                                        data-value="${Price_Not_Discount}">
                                                                        ${Price_Not_Discount}
                                                                    </span>
                                                                </span>
                                                                <input type="hidden" value="" data-id="1093666684"
                                                                    class="line_money_temp">
                                                            </div>
                                                        </div>
                                                    </c:if>

                                                    <!-- delete -->
                                                    <div class="cpro_item remove col-xs-2 col-sm-1 col-md-1">
                                                        <div class="cpro_item_inner" id="listBtnRemove">
                                                            <button class="btn btn-light"
                                                                class="cart__remove ajaxcart__remove" id="removeCart"
                                                                value="${P.getProductID()}"
                                                                data-product-id="${P.getProductID()}">
                                                                <i class="fa fa-trash-alt" aria-hidden="true"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>

                                        </c:forEach>
                                    </div>

                                </div>


                                <!-- Total Cart -->
                                <div class="boxCart rightCart col-md-4 col-sm-12 col-xs-12 ">
                                    <div class="list_button_cart clearfix">
                                        <div class="actionCart clearfix text-right">
                                            <p class="d-flex justify-content-between align-content-center">
                                                <span class="cart__subtotal-title pull-left">Total</span>
                                                <span class="h3 cart__subtotal pull-right">
                                                    <span class="money text-danger " id="totalCart">

                                                    </span>
                                                    <span class="text-danger"> $</span>
                                                </span>
                                            </p>
                                            <!--<p><em>ÄÃ£ bao gá»m thuáº¿ vÃ  phÃ­ Shipping</em></p>-->
                                            <form method="" action="">
                                                <div class="row mb-4">
                                                    <div class="col-6" style="padding-left: 0;">
                                                        <a class="btn con-ajax-cart btn-outline " href="/"
                                                            title="Tiáº¿p Tá»¥c Mua Sáº¯m">
                                                            Contiune Shopping
                                                        </a>
                                                    </div>

                                                    <input type="submit" id="checkout-cart" name="checkout"
                                                        class="btn btn-outline checkout btn-style-2  col-6 w-50"
                                                        value="Buy">

                                                </div>
                                                <div class="row my-5">
                                                    <label for="" class="order-from-label">Name</label>
                                                    <div class="col-6">
                                                        <input type="text" class="form-control "
                                                            placeholder="First Name" id="orders-input" required>
                                                    </div>
                                                    <div class="col-6">
                                                        <input type="text" class="form-control" placeholder="Last Name"
                                                            required>
                                                    </div>
                                                </div>

                                                <div class="row mt-3 mb-2">
                                                    <div class="col-12 mb-3">
                                                        <label class="order-form-label font-monospace">Address</label>
                                                    </div>
                                                    <div class="col-12 mb-3">
                                                        <div data-mdb-input-init class="form-outline">
                                                            <label class="form-label" for="form5">Street Address</label>
                                                            <input type="text" class="form-control order-form-input"
                                                                placeholder="Street Address" id="orders-input"
                                                                required />

                                                        </div>
                                                    </div>

                                                    <div class="col-sm-6 mt-2 pe-sm-2">
                                                        <div data-mdb-input-init class="form-outline">
                                                            <label class="form-label" for="form7">City</label>
                                                            <input type="text" class="form-control order-form-input"
                                                                placeholder="City" id="orders-input" required />

                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6 mt-2 ps-sm-0">
                                                        <div data-mdb-input-init class="form-outline">
                                                            <label class="form-label" for="form8">Region</label>
                                                            <input type="text" class="form-control order-form-input"
                                                                placeholder="Region" id="orders-input" />

                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6 mt-5 pe-sm-2">
                                                        <div data-mdb-input-init class="form-outline">
                                                            <label class="form-label" for="form9">Postal / Zip
                                                                Code</label>
                                                            <input type="text" class="form-control order-form-input"
                                                                placeholder="Postal / Zip Code" id="orders-input" />

                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6 mt-5">
                                                        <div data-mdb-input-init class="form-outline">
                                                            <label class="form-label" for="form10">Country</label>
                                                            <input type="text" class="form-control order-form-input"
                                                                placeholder="Country" id="orders-input" />

                                                        </div>
                                                    </div>
                                                </div>

                                        </div>
                                        <div class="note_item mt-5">
                                            <div class="note_cart">
                                                <label class="control-label" for="CartSpecialInstructions">Notes</label>
                                                <textarea name="note" class="form-control"
                                                    placeholder="Do You Want Take Some Notes ..... "
                                                    id="CartSpecialInstructions"></textarea>
                                            </div>
                                        </div>
                                        </form>



                                    </div>
                                </div>
                            </div>
                        </data>
                    </div>
                </div>



                <!-- Start Footer -->
                <footer class="bg-dark" id="tempaltemo_footer">
                    <div class="container">
                        <div class="row">

                            <div class="col-md-4 pt-5">
                                <h2 class="h2 text-success border-bottom pb-3 border-light logo">ShoesStore Shop</h2>
                                <ul class="list-unstyled text-light footer-link-list">
                                    <li>
                                        <i class="fas fa-map-marker-alt fa-fw"></i>
                                        TP.Thủ Đức ,TP.Hồ Chí Minh
                                    </li>
                                    <li>
                                        <i class="fa fa-phone fa-fw"></i>
                                        <a class="text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                                    </li>
                                    <li>
                                        <i class="fa fa-envelope fa-fw"></i>
                                        <a class="text-decoration-none"
                                            href="mailto:info@company.com">ShoesStore@company.com</a>
                                    </li>
                                </ul>
                            </div>

                            <div class="col-md-4 pt-5">
                                <h2 class="h2 text-light border-bottom pb-3 border-light">Products</h2>
                                <ul class="list-unstyled text-light footer-link-list">
                                    <li><a class="text-decoration-none" href="#">Sneaker</a></li>
                                    <li><a class="text-decoration-none" href="#">Football</a></li>
                                    <li><a class="text-decoration-none" href="#">Running</a></li>

                            </div>

                            <div class="col-md-4 pt-5">
                                <h2 class="h2 text-light border-bottom pb-3 border-light">Further Info</h2>
                                <ul class="list-unstyled text-light footer-link-list">
                                    <li><a class="text-decoration-none" href="#">Home</a></li>
                                    <li><a class="text-decoration-none" href="#">About Us</a></li>
                                    <li><a class="text-decoration-none" href="#">Shop Locations</a></li>
                                    <li><a class="text-decoration-none" href="#">FAQs</a></li>
                                    <li><a class="text-decoration-none" href="#">Contact</a></li>
                                </ul>
                            </div>

                        </div>

                        <div class="row text-light">
                            <div class="col-12 mb-3">
                                <div class="w-100 my-3 border-top border-light"></div>
                            </div>
                            <div class="col-auto me-auto">
                                <ul class="list-inline text-left footer-icons">
                                    <li class="list-inline-item border border-light rounded-circle text-center">
                                        <a class="text-light text-decoration-none" target="_blank"
                                            href="http://facebook.com/"><i
                                                class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                                    </li>
                                    <li class="list-inline-item border border-light rounded-circle text-center">
                                        <a class="text-light text-decoration-none" target="_blank"
                                            href="https://www.instagram.com/"><i
                                                class="fab fa-instagram fa-lg fa-fw"></i></a>
                                    </li>
                                    <li class="list-inline-item border border-light rounded-circle text-center">
                                        <a class="text-light text-decoration-none" target="_blank"
                                            href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                                    </li>
                                    <li class="list-inline-item border border-light rounded-circle text-center">
                                        <a class="text-light text-decoration-none" target="_blank"
                                            href="https://www.linkedin.com/"><i
                                                class="fab fa-linkedin fa-lg fa-fw"></i></a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-auto">
                                <label class="sr-only" for="subscribeEmail">Email address</label>
                                <div class="input-group mb-2">
                                    <input type="text" class="form-control bg-dark border-light" id="subscribeEmail"
                                        placeholder="Email address">
                                    <div class="input-group-text btn-success text-light">Subscribe</div>
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