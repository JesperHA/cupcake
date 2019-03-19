<%-- Header: User: jobe Date: 2019-03-05 Time: 16:45 --%>

<%@ page import="ModelLayer.Login" %>
<%@ page import="control.FrontController" %>
<%@ page import="ModelLayer.Kunder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="facadeLayer.OrdreFacade" %>
<%@ page import="facadeLayer.KundeFacade" %>
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Olsker Cupcake Webshop</title>
    <link href="../css/cupcake.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Optional JavaScript: jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>

    <%

    ArrayList<Login> login = (ArrayList<Login>) session.getAttribute("login");

    ArrayList<Kunder> kundeList = null;


    if(login != null){

        if(login.size() > 0){

    kundeList = KundeFacade.getKunderListById(login.get(0).getKunde_id());
    }
    }




//    String nySaldo=null;
//
//    if(login != null){
//        nySaldo = (String) request.getAttribute("nySaldo");
//    }

//     int saldo = 0;
//
//     if(login != null){
//
//    for(int i = 0; i < kundeList.size(); i++) {
//        if(kundeList.get(i).getKunde_id() == login.get(0).getKunde_id()){
//            saldo = kundeList.get(i).getSaldo();
//        }
//
//    }
//    }




%>

<%--<body>--%>


<div class="container">

    <img src="img/olskercupcakes.png" alt="Logo" class="img-fluid"/>


    <nav class="navbar navbar-expand-lg navbar-light " style="background-color:#e9ecef;">
        <a class="navbar-brand" href="index.jsp">
            <img src="img/cupcake.svg" width="30" height="30" class="d-inline-block align-top" alt="logo">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <%--<form action="/FrontController" method="post">--%>
        <%--<div class="form-group">--%>
        <%--<input type="hidden" name="source" value="gotocart">--%>


        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="#">Shop</a>--%>
                <%--</li>--%>
                <li class="nav-item">
                    <a class="nav-link" href="#">Kunder</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="orders.jsp">Ordrer</a>
                </li>

            </ul>

            <%if(login != null){%>
            <%--<form action="/FrontController" method="post">--%>
                <%--<input type="hidden" name="source" value="logout"/>--%>
            <ul class="navbar-nav">

                <li class="nav-item">
                    <a class="nav-link" style="color: blue" href="FrontController?source=logout">Log ud

                       <%--<%session.removeAttribute("login");%>--%>

                    </a>

                </li>
            </ul>

            <%}%>



            <ul class="navbar-nav">

                <%if (login == null) {%>
                <li>
    <span style="margin-right: 10px;">
                <a href="#" data-toggle="modal" data-target="#at-login">Log ind
                </a>
        </span>
                </li>
                <%}%>

                <% if (login != null) {%>





                <li>
                    <span style="margin-right:10px;">Logget på som:</span>
                </li>
                <li>
                    <span style="margin-right:10px;"><%=login.get(0).getNavn()%></span>
                </li>


                <li>
                    <span style="margin-right:10px;">(Saldo:</span>
                </li>
                <li>
                    <span style="margin-right:20px;"><%=kundeList.get(0).getSaldo()%>,-)</span>
                </li>
                <%}%>
            </ul>
            <ul class="navbar-nav">
                <li>

                    <a class="nav-link" href="cart.jsp">
                        <%--<button type="hidden" name="source" value="gotocart">--%>

                        <img src="img/shopping-basket.svg" width="30" height="30" class="d-inline-block align-top"
                             alt="logo">
                        <%--</button>--%>

                    </a>

                </li>
            </ul>
        </div>
        <%--</div>--%>
        <%--</form>--%>
    </nav>


    <section class="at-logout-form">
        <form action="/FrontController" method="post">
            <input type="hidden" name="source" value="login"/>
        </form>

    </section>


    <section class="at-login-form">
        <!-- MODAL LOGIN -->
        <form action="/FrontController" method="post">
            <input type="hidden" name="source" value="login"/>
            <div class="modal fade" id="at-login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">x</span></button>
                        </div>
                        <div class="modal-body">
                            <div class="signup-or-separator">
                                <span class="h6 signup-or-separator--text">Login</span>
                                <hr>
                            </div>
                            <form>
                                <div class="form-group">
                                    <input type="email" class="form-control" name="email" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password">
                                </div>
                                <button type="submit" class="btn-lgin">Login</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </form>

