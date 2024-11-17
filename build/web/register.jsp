<%-- Document : register Created on : Jun 19, 2024, 11:00:23 PM Author : ADMIN --%>

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

            <link rel="stylesheet" href="./assets/css/register.css">
        </head>

        <body>
            <header>
                <!-- place navbar here -->
            </header>
            <main>
                <div class="container-fluid">
                    <div class="row vh-100">
                        <div class="col-6" id="content-login">
                            <div class="content">
                                <!--back to login -->
                                <div class="backLogin">
                                    <p>
                                        <a href="login.jsp">
                                            <i class="fa-solid fa-arrow-left"></i>
                                        </a>
                                    </p>
                                </div>
                                <!-- title -->
                                <div class="title">
                                    <h1 class="text-center text-capitalize">Register</h1>
                                </div>
                                <!-- form  -->
                                <form action="MainController" method="post">

                                    <!-- Ten  -->
                                    <div class="mb-5">
                                        <label for="" class="form-label">Fisrt Name</label>
                                        <span class="text-danger">*</span>
                                        <input type="text" name="Fname" id="" class="form-control"
                                            placeholder="First Name" aria-describedby="helpId" />

                                    </div>
                                    <!-- Ho -->
                                    <div class="mb-5">
                                        <label for="" class="form-label">Last Name</label>
                                        <span class="text-danger">*</span>
                                        <input type="text" name="Lname" id="" class="form-control"
                                            placeholder="Last Name" aria-describedby="helpId" />

                                    </div>
                                    <!-- UserName -->
                                    <div class="mb-5">
                                        <label for="" class="form-label">UserName</label>
                                        <span class="text-danger">*</span>
                                        <input type="text" name="UserName" id="" class="form-control"
                                            placeholder="User Name" aria-describedby="helpId" />

                                    </div>
                                    <!--passWord  -->
                                    <div class="mb-5" id="input-icons">

                                        <label for="" class="form-label">Password</label>
                                        <span class="text-danger">*</span>
                                        <input type="password" name="password" id="password" class="form-control pass"
                                            placeholder="Password" aria-describedby="helpId" />

                                        <i class="fa-solid  fa-eye-showPass fa-eye-slash" id="icons-showPass"></i>

                                    </div>
                                    <!-- repeat PassWord -->
                                    <div class="mb-5" id="input-icons">

                                        <label for="" class="form-label">Repeat Password</label>
                                        <span class="text-danger">*</span>
                                        <input type="password" name="Rpassword" id="repeat-password"
                                            class="form-control pass" placeholder="Repeat Password"
                                            aria-describedby="helpId" />

                                        <i class="fa-solid  fa-eye-showPass fa-eye-slash"
                                            id="icons-showPass-repeat"></i>

                                    </div>
                                     <span class="text-danger">${messageErr_Pass}</span>
                                    <div class="mb-3 w-100">
                                        <input type="submit" class="btn btn-primary w-100 button-login" name="action"
                                            value="register">
                                    </div>
                                    <!-- Term And Privacy -->
                                    <p class=" text-center mt-15 text-register">
                                        By creating an account you agree to our<a href="#">Terms & Privacy</a>
                                    </p>


                                </form>



                            </div>
                        </div>
                        <div class="col-6 vh-100">
                            <img src="./assets/img/Register.jpg" alt="" class="w-100 vh-100">
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
            <!-- icons show password -->
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

                document.getElementById("icons-showPass-repeat").addEventListener('click', () => {
                    let x = document.getElementById("repeat-password")
                    let icons = document.getElementById("icons-showPass-repeat")
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

                document.getElementById('password-form').addEventListener('submit', function (event) {
                    event.preventDefault(); // Prevent form submission

                    const password = document.getElementById('password').value;
                    const repeatPassword = document.getElementById('repeat-password').value;
                    const errorMessage = document.getElementById('error-message');

                    if (password !== repeatPassword) {
                        errorMessage.textContent = 'Passwords do not match.';
                    } else {
                        errorMessage.textContent = '';
                        // Submit the form or perform further actions
                        alert('Passwords match!');
                        // For demonstration, we alert. In a real-world scenario, you might want to submit the form here.
                    }
                });






            </script>
        </body>

        </html>