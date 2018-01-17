<%-- 
    Document   : admin.jsp
    Created on : 17-01-2018, 15:58:03
    Author     : daniela
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    HttpSession sesion = request.getSession();//recupera sesiones activas
   
    if(session.getAttribute("nivel")==null){
        response.sendRedirect("../index.jsp");
    }else {
        String nivel= session.getAttribute("nivel").toString();
        if(!nivel.equals("1")){
            response.sendRedirect("../index.jsp");
        }
    }
    %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
    </head>
    <body>
        <div align="right">
            Bienvenido Sr. <%= session.getAttribute("nombre")%>
            <a href="../index.jsp?cerrar=true">Cerrar Sesion</a>
        </div>
        <h1>Entro como Administrador</h1>
        
    </body>
</html>
