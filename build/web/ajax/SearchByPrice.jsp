<%-- Document : SearchByPrice Created on : Jun 19, 2024, 3:49:34 PM Author : ADMIN --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Zay Shop - Product Listing Page</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
            <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

            <link rel="stylesheet" href="assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="assets/css/templatemo.css">
            <link rel="stylesheet" href="assets/css/custom.css">

            <!-- Load fonts style after rendering the layout styles -->
            <link rel="stylesheet"
                href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
            <link rel="stylesheet" href="assets/css/fontawesome.min.css">

            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
                integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
                crossorigin="anonymous" referrerpolicy="no-referrer" />


        </head>

        <body>
            <div class="row" id="content">

                <!-- Card image  -->

                <div class="col-md-4 product">
                    <div class="card mb-4  product-wap rounded-0
                                      ">
                        <div class="card rounded-0">

                            <img class="card-img rounded-0 img-fluid" src="<%= P.getImage()%> " id="img">
                            <div
                                class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                <ul class="list-unstyled">
                                    <li><a class="btn btn-success text-white" href=""><i class="far fa-heart"></i></a>
                                    </li>
                                    <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i
                                                class="far fa-eye"></i></a>
                                    </li>
                                    <li><a class="btn btn-success text-white mt-2" href="shop-single.html"><i
                                                class="fas fa-cart-plus"></i></a>
                                    </li>
                                </ul>
                            </div>
                            <!-- Badges  -->
                            <% if (P.getDiscount() !=0) {%>
                                <div class="badge-sale badge-top-left">
                                    <span> Sale off <%=P.getDiscount() * 100%> %
                                    </span>
                                </div>
                                <% }%>
                        </div>

                        <!--  Card  body  -->
                        <div class="card-body">
                            <a href="MainController?ID=<%=P.getProductID()%>&action=SingleProduct"
                                class="h3 text-decoration-none text-product text-truncate d-inline-block"
                                style="max-width: 100%;" id="Name">
                                <%= P.getProductName()%>
                            </a>
                            <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                <li></li>
                                <li class="pt-2">
                                    <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
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
                            <ul class="list-unstyled d-flex justify-content-center mb-1">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                            </ul>

                            <% if (P.getDiscount() !=0) {%>
                                <div class="Price d-flex align-items-center justify-content-around">
                                    <p class=" current-price">
                                        <%= P.getPrice()%> $
                                    </p>

                                    <p class=" new-price text-danger">
                                        <%=P.getNewPrice()%>
                                            $
                                    </p>


                                </div>
                                <% } else {%>
                                    <p class="text-center mt-2 mb-2 current-price">
                                        <%= P.getPrice()%> $
                                    </p>
                                    <% } %>
                        </div>
                    </div>
                </div>
                <% } %>




            </div>

            <!-- Start Script -->
            <script src="assets/js/jquery-1.11.0.min.js"></script>
            <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
            <script src="assets/js/bootstrap.bundle.min.js"></script>
            <script src="assets/js/templatemo.js"></script>
            <script src="assets/js/custom.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        </body>

        </html>