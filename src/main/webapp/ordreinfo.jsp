<%@ page import="facadeLayer.KundeFacade" %>
<%@ page import="facadeLayer.OrdrelinieFacade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ModelLayer.*" %>
<%@ page import="ModelLayer.Toppings" %>
<%@ page import="ModelLayer.Bottom" %>

<%--
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

        int ordre_id = (int) request.getAttribute("ordre_id");

        ArrayList<Login> bruger = (ArrayList<Login>) session.getAttribute("login");
        ArrayList<OrdreView> ordreViewList = facadeLayer.OrdreViewFacade.getOrdreViewListByOrdre(ordre_id);
        ArrayList<Toppings> topList = facadeLayer.TopFacade.getTopList();
        ArrayList<Bottom> bottomList = facadeLayer.BottomFacade.getBottomList();

        ArrayList<Ordrelinie> ordrelinieList = facadeLayer.OrdrelinieFacade.getOrdrelinieList(ordre_id);

        int bottomId = 0;
        int topId = 0;
        int antal = 0;
        int pris = 0;



        // lav et carthashmap der indeholder bottomid og navn for at vise det fra cart arraylisten til cart.jsp

    %>
    <h2 style="display:inline-block;">Ordrenummer: <%out.println(ordre_id);%></h2>

        <table class="table">

            <tr>
                <th></th><th>Bund</th><th>Top</th><th>Antal</th><th>Pris</th>
            </tr>
<%


                for (int i = 0; i < ordrelinieList.size(); i++) {

                bottomId = ordrelinieList.get(i).getBottom_id();
                topId = ordrelinieList.get(i).getTopping_id();
                antal = ordrelinieList.get(i).getAntal();
                pris = ordrelinieList.get(i).getPris();


            %>
            <tr>
                <td><%=i+1%></td><td><%=bottomList.get(bottomId-1).getSmag()%></td><td><%=topList.get(topId-1).getSmag()%></td><td><%=antal%></td><td><%=pris%></td><td>
            </tr>

            <%}%>

            <tr>
                <th></th><th></th><th></th><th>Dato</th><th>Pris ialt</th>
            </tr>

            <tr>
                <td></td><td></td><td></td><td><%=ordreViewList.get(0).getDato()%></td>
                <td><%=ordreViewList.get(0).getIalt()%>,-</td>

            </tr>


        </table>






</div>



<%@ include file = "include/footer.jsp" %>
