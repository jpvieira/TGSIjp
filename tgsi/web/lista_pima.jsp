<%-- 
    Document   : index
    Created on : 12/08/2015, 23:38:51
    Author     : jp
--%>
<%@page import="controle.Listapima"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Diabete_pima" %>
<jsp:useBean id="listapima" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <%@include file="WEB-INF/jspf/jscss.jspf" %>
     <title>LISTA pima</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/top.jspf" %>
        <div>
            <table class="table table-bordered">
                <tr>
                    <tr>Id</tr>
                    <tr>age</tr>
                    <tr>body_mass</tr>
                    <tr>classe</tr>
                    <tr>diabetes</tr>
                    <tr>diastolic</tr>
                    <tr>nb_pregnant</tr>
                    <tr>serum insulin</tr>
                    <tr>triceps skin</tr>
                </tr>
                <% for(int i=0;i<listapima.size();i++){
                    Diabete_pima listapimaa= new Diabete_pima();
                    listapimaa=(Diabete_pima)listapima.get(i);
                %>
                <tr>
                    <td> <%=listapimaa.getId_pima() %></td>
                    <td><%=listapimaa.getAge() %></td>
                    <td><%=listapimaa.getBody_mass() %></td>
                    <td><%=listapimaa.getClasse() %></td>
                    <td><%=listapimaa.getDiabetes() %></td>
                    <td><%=listapimaa.getDiastolic() %></td>
                    <td><%=listapimaa.getNb_pregnant() %></td>
                    <td><%=listapimaa.getSerum_insulin() %></td>
                    <td><%=listapimaa.getTriceps_skin() %></td>                 
                </tr>
                <% } %>
            </table>    
        </div>
        <%@include file="WEB-INF/jspf/bootom.jspf" %>

    </body>
</html>
