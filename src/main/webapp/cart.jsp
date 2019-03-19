<%@ page import="facadeLayer.KundeFacade" %>
<%@ page import="facadeLayer.OrdrelinieFacade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ModelLayer.Ordrelinie" %>
<%@ page import="ModelLayer.Toppings" %>
<%@ page import="ModelLayer.Bottom" %>
<%@ page import="ModelLayer.Cart" %><%--
  Created by IntelliJ IDEA.
  User: jelle
  Date: 14-03-2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ include file = "include/header.jsp" %>


<div class="jumbotron">

    <%

//        ArrayList<Ordrelinie> ordrelinieList = facadeLayer.OrdrelinieFacade.getOrdrelinieList();
        ArrayList<Toppings> topList = facadeLayer.TopFacade.getTopList();
        ArrayList<Bottom> bottomList = facadeLayer.BottomFacade.getBottomList();

        int i = 0;

        ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");



//        ArrayList<Kunder> kunder = (ArrayList<Kunder>) session.getAttribute("kunde");
//
//        for (Kunder k: kunder) {
//            out.println(k.getNavn() + "   ");
//
//        }

//        ArrayList<Login> login = (ArrayList<Login>) session.getAttribute("login");

//        for (Login l: login) {
//            out.println(l.getNavn());
//
//        }

//        for (Cart c: cart) {
//            out.println(c.getBottom() + "  ");
//
//        }

//        int bottomId = 0;
//        int topId = 0;
//        int antal = 0;
//        int pris = 0;

        // lav et carthashmap der indeholder bottomid og navn for at vise det fra cart arraylisten til cart.jsp



//        for (int i = 0; i <ordrelinieList.size() ; i++) {
//
//            bottomId = ordrelinieList.get(i).getBottom_id();
//            topId = ordrelinieList.get(i).getTopping_id();
//            antal = ordrelinieList.get(i).getAntal();
//            pris = ordrelinieList.get(i).getPris();
//        }

    %>
    <h2>Indkøbskurv</h2>

    <%--<% out.print(KundeFacade.getKunderList().get(1).getEmail()); %>--%>
<table class="table">

    <tr>
        <th></th><th>Bund</th><th>Top</th><th>Antal</th><th>Pris</th>
    </tr>

<%
    for (Cart c: cart) {

        i = i+1;

//    for (int i = 0; i < ordrelinieList.size(); i++) {
//
//    bottomId = ordrelinieList.get(i).getBottom_id();
//    topId = ordrelinieList.get(i).getTopping_id();
//    antal = ordrelinieList.get(i).getAntal();
//    pris = ordrelinieList.get(i).getPris();


%>
    <tr>
        <td><%=i%></td><td><%=bottomList.get(c.getBottom()-1).getSmag()%></td><td><%=topList.get(c.getTop()-1).getSmag()%></td><td><%=c.getAntal()%></td><td><%=c.getPris()%></td><td><button type="button" class="btn btn-danger">Slet</button></td>
    </tr>

    <%}%>





</table>
    <form action="/FrontController" method="post">
        <input type="hidden" name="source" value="completeorder"/>

        <input type="submit" style="width: 25%" name="completeknap" value="Fuldfør ordre" class="btn btn-success float-right form-control"/>

    </form>




</div>



<%@ include file = "include/footer.jsp" %>
