<%-- Document : login Created on : Jun 19, 2024, 10:47:43 PM Author : ADMIN --%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!doctype html>
        <html lang="en">

        <head>
            <title>Title</title>
            <!-- Required meta tags -->
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

            <!-- Bootstrap CSS v5.2.1 -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                crossorigin="anonymous" />
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
                integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
                crossorigin="anonymous" referrerpolicy="no-referrer" />
            <!-- Link Css -->
            <link
                href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
                rel="stylesheet">
            <link rel="stylesheet" href="assets/css/Style.css">
        </head>

        <body>
            <header>
                <!-- place navbar here -->
            </header>
            <main>
                <div class="container-fluid">
                    <div class="row vh-100">
                        <!--  Content -->
                        <div class="col-6" id="content-login">
                            <div class="content">
                                <!--back to login -->
                                <div class="backLogin">
                                    <p>
                                        <a href="index.jsp">
                                            Back To HomePage
                                        </a>
                                    </p>
                                </div>
                                <!-- title -->
                                <div class="title">
                                    <h1 class="text-center text-capitalize">Login</h1>
                                </div>
                                <!-- form  -->
                                <form action="MainController" method="post">

                                    <div class="mb-5">
                                        <label for="" class="form-label">UserName</label>
                                        <span class="text-danger">*</span>
                                        <input type="text" name="UserName" id="" class="form-control"
                                            placeholder="UserName" aria-describedby="helpId" required />

                                    </div>

                                    <div class="mb-5" id="input-icons">

                                        <label for="" class="form-label">Password</label>
                                        <span class="text-danger">*</span>
                                        <input type="password" name="password" id="password" class="form-control pass"
                                            placeholder="Password" aria-describedby="helpId" required />

                                        <i class="fa-solid  fa-eye-showPass fa-eye-slash" id="icons-showPass"></i>
                                        <small id="helpId"
                                            class="text-muted text-danger">${requestScope.message}</small>
                                    </div>
                                           
                                    <div class="mb-3 w-100">
                                        <input type="submit" class="btn btn-primary w-100 button-login" name="action"
                                            value="login">
                                    </div>
                                    <!-- Register -->
                                    <p class=" text-center mt-15 text-register">
                                        Not a memeber ? <a href="register.jsp">Register Here</a>
                                    </p>


                                </form>



                            </div>
                        </div>
                        <!--  image -->
                        <div class="col-6">
                            <img src="./assets/img/loginImage.jpg" alt="" class="w-100 vh-100">
                        </div>
                    </div>
                </div>

            </main>
            <footer>
                <!-- place footer here -->
            </footer>
            <!-- Bootstrap JavaScript Libraries -->
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                crossorigin="anonymous"></script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                crossorigin="anonymous"></script>

            <script>
                document.getElementById("icons-showPass").addEventListener('click', () => {
                    let x = document.getElementById("password")
                    let icons = document.getElementById("icons-showPass")
                    if (x.type === "password") {
                        x.type = "text";
                        icons.classList.remove("fa-eye-slash");
                        icons.classList.add("fa-eye");
                    } else {
                        x.type = "password";
                        icons.classList.remove("fa-eye");
                        icons.classList.add("fa-eye-slash");
                    }
                })
                // window.addEventListener("KeyDown", function (event) {
                //     let key = event.key;
                //     console.log(key);
                //     if (key === 'F5') {

                //     }
                // })


                window.addEventListener("keydown", function (event) {
                    // Check if the F5 key (keyCode 116) is pressed
                    if (event.key === 'F5') {
                        console.log(event.key);
                        // Prevent the default action of the F5 key (usually refresh)
                        event.preventDefault();

                        // Redirect to another page when F5 is pressed
                        window.location.href = "/Shoes_Store/login.jsp"; // Replace with your desired URL
                    }
                });



            </script>
        </body>

        </html>