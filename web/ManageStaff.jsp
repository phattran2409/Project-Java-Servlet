<%@page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>
        <%@page import="model.Product.CategoryDAO" %>
            <%@page import="model.Product.Category" %>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <!DOCTYPE html>
                    <html lang="en">

                    <head>

                        <meta charset="utf-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                        <meta name="description" content="">
                        <meta name="author" content="">

                        <title>SB Admin 2 - Dashboard</title>

                        <!-- Custom fonts for this template-->
                        <link href="./assets/fontawsome-free/all.css" rel="stylesheet" type="text/css">
                        <link rel="stylesheet"
                            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
                            integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
                            crossorigin="anonymous" referrerpolicy="no-referrer" />
                        <link
                            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                            rel="stylesheet">
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                            crossorigin="anonymous">

                        <!-- Custom styles for this template-->
                        <link href="./assets/css/sb-admin-2.css" rel="stylesheet">
                        <link rel="stylesheet" href="./assets/css/AdminDashboard.css">
                        <style>
                            body {
                                background-color: #fbfbfb;
                            }

                            @media (min-width: 991.98px) {
                                main {
                                    padding-left: 240px;
                                }
                            }


                            /* Sidebar */
                            .sidebar {
                                position: fixed;
                                top: 0;
                                bottom: 0;
                                left: 0;
                                padding: 58px 0 0;
                                /* Height of navbar */
                                box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
                                width: 250px;
                                z-index: 600;
                                transition: all 0.3s ease-in;
                                -webkit-transition: all 0.25s;
                            }

                            @media (max-width: 991.98px) {
                                .sidebar {
                                    width: 100%;
                                }
                            }

                            .sidebar .active {
                                border-radius: 5px;
                                box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
                            }

                            .sidebar-sticky {
                                position: relative;
                                top: 0;
                                height: calc(100vh - 48px);
                                padding-top: 0.5rem;
                                overflow-x: hidden;
                                overflow-y: auto;
                                /* Scrollable contents if viewport is shorter than content. */
                            }

                            .show {
                                display: block;

                            }

                            .hide {
                                display: none;
                            }

                            .avatar-admin {
                                width: 50px;
                                height: 50px;
                            }

                            .fixed-bottom {
                                width: 225px;
                                display: flex;
                                flex-direction: column;
                                align-items: center;
                                padding-bottom: 2rem;
                                grid-auto-rows: 10px;
                            }
                        </style>

                    </head>

                    <body>

                        <!--Main Navigation-->
                        <header>
                            <!-- Sidebar -->
                            <nav id="sidebarMenu" class="collapse  sidebar  bg-white hide">
                                <div class="position-sticky">
                                    <div class="list-group list-group-flush mx-3 mt-4">
                                        <a href="LoadProduct" class="list-group-item list-group-item-action  ripple"
                                            aria-current="true">
                                            <i class="fas fa-tachometer-alt " style="margin-right: 8px;"></i><span
                                                class="text-truncate ">Manager
                                                Product</span>
                                        </a>
                                        <a href="#"
                                            class="list-group-item list-group-item-action py-2 ripple bg-gradient-primary rounded-pill"
                                            aria-current="true" style="color: #fbfbfb;">
                                            <i class="fa fa-layer-group fa-fw me-3"></i><span >Manager Staff</span>
                                        </a>

                                    </div>
                                </div>
                                <c:set var="Admin" value="${sessionScope.loginAdmin}" />
                                <c:if test="${Admin != null}">
                                    <div class="fixed-bottom">
                                        <img src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
                                            class="rounded-circle avatar-admin" alt="Avatar" />
                                        <span class="Ad-Name">${Admin.getAd_Name()}</span>
                                        <a class="btn btn-outline-danger mt-3 mb-3" href="Logout">
                                            <i class="fa fa-power-off"></i>
                                            <span> Log Out</span>
                                        </a>

                                    </div>
                                </c:if>
                                <c:if test="${Admin == null}">
                                    <div class="fixed-bottom">
                                        <a class="btn btn-outline-success mt-3 mb-3" href="LoginAdmin.jsp">
                                            <i class="fa fa-right-to-bracket"></i>
                                            <span> Log in</span>
                                        </a>
                                    </div>
                                </c:if>
                            </nav>
                            <!-- Sidebar -->

                            <!-- Navbar -->
                            <nav id="main-navbar" class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
                                <!-- Container wrapper -->
                                <div class="container-fluid">
                                    <!-- Toggle button -->
                                    <button id="toggle-navbar" class="btn  btn-outline-primary mr-auto ">
                                        <i class="fas fa-bars"></i>
                                    </button>

                                    <!-- Brand -->
                                    <a class="navbar-brand ml-auto" href="#">
                                        <img src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
                                            height="25" alt="MDB Logo" loading="lazy" />
                                    </a>
                                    <!-- Search form -->
                                    <!-- <form class="d-none d-md-flex input-group w-auto my-auto">
        <input autocomplete="off" type="search" class="form-control rounded"
            placeholder='Search (ctrl + "/" to focus)' style="min-width: 225px;" />
        <span class="input-group-text border-0"><i class="fas fa-search"></i></span>
    </form> -->


                                </div>
                                <!-- Container wrapper -->
                            </nav>
                            <!-- Navbar -->
                        </header>
                        <!--Main Navigation-->

                        <!--Main layout-->
                        <main style="margin-top: 58px;">
                            <div class="container pt-4"></div>
                        </main>
                        <!--Main layout-->
                        <div class="container-fluid">
                            <!-- Insert New Product -->
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#exampleModal">
                                Create A New Staff
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog ">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Create A New Staff
                                            </h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close">

                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="MainController" method="post">
                                                <div class="form-insert">

                                                    <div class="row mt-4">
                                                        <div class="col-6 d-flex flex-column">
                                                            <label class="label-input-insert" for="">Staff ID</label>
                                                            <input type="text" name="S_ID" id=""
                                                                class="form-control rounded-pill">
                                                            <p class="text-danger">${DuplicateMessage}</p>
                                                        </div>
                                                        <div class="col-6 d-flex flex-column">
                                                            <label class="label-input-insert" for="">Staff
                                                                Name</label>
                                                            <input type="text" name="S_Name" id=""
                                                                class="form-control rounded-pill">
                                                        </div>

                                                    </div>
                                                    <div class="row mt-4">
                                                        <div class="col-6">
                                                            <label class="label-input-insert" for="">Password</label>
                                                            <input type="password" name="pass" id=""
                                                                class="form-control rounded-pill">
                                                        </div>
                                                        <div class="col-6">
                                                            <label class="label-input-insert" for="">Set Role</label>
                                                            <input type="number" name="role" id=""
                                                                class="form-control rounded-pill">
                                                        </div>
                                                    </div>

                                                </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                close
                                            </button>
                                            <button type="submit" class="btn btn-primary" name="action"
                                                value="Insert New Staff">Saves
                                                Change</button>
                                        </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <!-- Search Staff -->
                            <form method="GET" action="MainController"
                                class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                <select name="SearchOption" class="form-select" aria-label="Default select example">
                                    <option value="Name">
                                        Search Staff Name
                                    </option>
                                    <option value="ID">
                                        Searrch Staff ID
                                    </option>
                                </select>
                                <div class="input-group">

                                    <input type="text" class="form-control bg-light border-0 small"
                                        placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2"
                                        name="search">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="submit" name="action"
                                            value="Search Staff">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                            <a href="LoadStaff" class="btn btn-outline-danger ml-3">
                                Reset
                            </a>
                        </div>


                        <!-- Begin Page Content -->
                        <!-- Product -->
                        <div class="container-fluid">

                            <div class="message">
                                <h3 class="text-success">${message}</h3>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-primary">
                                    <thead>
                                        <tr>
                                            <th scope="col">Staff ID</th>
                                            <th scope="col">Staff Name </th>
                                            <th scope="col">Staff Password </th>
                                            <th scope="col">Role</th>
                                            <th scope="col">Change</th>
                                            <th scope="col">Remove</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <h1>${NotFound}</h1>
                                        <c:forEach var="Staff" items="${list}">

                                            <tr class="product">
                                                <form method="POST" action="MainController">
                                                    <td scope="row">
                                                        <input type="text" name="S_ID" value="${Staff.getAd_ID()}"
                                                            readonly>
                                                    </td>
                                                    <td>
                                                        <input type="text" name="S_Name" value="${Staff.getAd_Name()}">
                                                    </td>

                                                    <td>
                                                        <input type="text" name="Pass" value="***">
                                                    </td>
                                                    <td>
                                                        <input type="number" name="role" id=""
                                                            value="${Staff.getRole()}">
                                                    </td>


                                                    <td>
                                                        <button type="submit" name="action" value="update Staff"
                                                            class="btn btn-outline-primary">
                                                            <i class="fa fa-pencil-alt "></i>
                                                        </button>
                                                    </td>
                                                    <td>
                                                        <input type="text" id="mesDelete" value="${MessageDel}" hidden>
                                                        <button type="submit" name="action" id="btn-remove"
                                                            value="remove Staff"
                                                            class="btn btn-outline-danger btn-del-staff">
                                                            <i class="fa fa-trash "></i>
                                                        </button>
                                                    </td>
                                                </form>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>

                        <!-- /.container-fluid -->

                        </div>








                        <!-- Footer -->

                        <!-- End of Footer -->

                        </div>
                        <!-- End of Content Wrapper -->


                        </div>


                        <!-- End of Page Wrapper -->

                        <!-- Scroll to Top Button-->



                    </body>

                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                        crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

                    <script>
                        var navbartoggle = document.getElementById("toggle-navbar");
                        var accordion = document.getElementById("sidebarMenu");
                        console.log(navbartoggle);
                        navbartoggle.addEventListener('click', () => {
                            if (accordion.classList.contains('show')) {
                                accordion.classList.remove('show')
                                accordion.classList.add('hide')

                            } else if (accordion.classList.contains('hide')) {
                                accordion.classList.remove('hide')
                                accordion.classList.add('show')
                            }
                        })

                        document.querySelectorAll('.btn-del-staff').forEach(button => {
                            button.addEventListener('click', function (event) {
                                event.preventDefault();
                                const url = this.href;
                                Swal.fire({
                                    title: "Are you sure?",
                                    text: "You won't be able to revert this!",
                                    icon: "warning",
                                    showCancelButton: true,
                                    confirmButtonColor: "#3085d6",
                                    cancelButtonColor: "#d33",
                                    confirmButtonText: "Yes, delete it!"
                                }).then((result) => {
                                    window.location.href = url;
                                    if (result.isConfirmed) {
                                        Swal.fire({
                                            title: "Deleted!",
                                            text: "Your Product has been deleted.",
                                            icon: "success"

                                        });
                                    } else {
                                        window.location.href = "LoadStaff";
                                    }
                                });
                            });
                        });
                    </script>

                    </html>