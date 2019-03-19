<%@ page import="facadeLayer.KundeFacade" %>
<%@ page import="facadeLayer.OrdrelinieFacade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ModelLayer.*" %><%--
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
        ArrayList<Login> bruger = (ArrayList<Login>) session.getAttribute("login");
        ArrayList<OrdreView> ordreViewList = facadeLayer.OrdreViewFacade.getOrdreViewList(bruger.get(0).getKunde_id());

        // lav et carthashmap der indeholder bottomid og navn for at vise det fra cart arraylisten til cart.jsp

    %>
    <h2>Ordreliste</h2>

    <form action="/FrontController" method="post">
        <input type="hidden" name="source" value="gotoorder"/>
    <%--<% out.print(KundeFacade.getKunderList().get(1).getEmail()); %>--%>
    <table class="table">

        <tr>
            <th>Ordrenummer</th><th>Dato</th><th>Pris</th>
        </tr>

        <%
            for (int i = 0; i < ordreViewList.size(); i++) {

        %>

        <tr>
            <td><%=ordreViewList.get(i).getOrdre_id()%></td><td><%=ordreViewList.get(i).getDato()%></td>
            <td><%=ordreViewList.get(i).getIalt()%>,-</td><td>

            <button type="submit" name="ordre" class="btn btn-success float-right form-control" value="<%=ordreViewList.get(i).getOrdre_id()%>">Åbn</button></td>

        </tr>

        <%}%>





    </table>
</div>



<%@ include file = "include/footer.jsp" %>
