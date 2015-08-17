<%-- 
    Document   : index
    Created on : 12/08/2015, 23:38:51
    Author     : jp
--%>


<%@page import="controle.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Diabete_pima" %>
<jsp:useBean id="list" scope="session" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <%@include file="../WEB-INF/jspf/jscss.jspf" %>
     <title>LISTA pima</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/top.jspf" %>
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
                <% for(int i=0;i<list.size();i++){
                    Categoria listapima= new Categoria();
                  listapima = (Categoria)list.get(i);
                %>
                <tr>
                    <td> <%=listapima.get %></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>                 
                </tr>
                <% } %>
            </table>    
        </div>
        <%@include file="../WEB-INF/jspf/bootom.jspf" %>

    </body>
</html>
