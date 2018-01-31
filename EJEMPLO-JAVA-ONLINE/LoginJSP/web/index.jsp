<%-- 
    Document   : index
    Created on : 17-01-2018, 14:53:23
    Author     : daniela
--%>
<%@page  session="true" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <div align="center">
        <h1>Formulario de Logeo</h1>
        <hr>
        <form action="SERVLOGIN" method="POST">
            <input type="text" name="txtusuario" placeholder="Ingrese su nombre de usuario"><br>
            <input type="password" name="txtcontra" placeholder="Contraseña"><br>
            <br>
            <input type="submit" name="btniniciar" value="Iniciar Sesion"><br/>    
            
        </form>
        </div>
        <%
            HttpSession sesion = request.getSession();//recupera sesiones activas
            int nivel =0;
            //valida nivel del server
            if(request.getAttribute("nivel")!=null){
                nivel =(Integer)request.getAttribute("nivel");
                if(nivel == 1){//crea sesion
                    sesion.setAttribute("nombre", request.getAttribute("nombre"));
                    sesion.setAttribute("nivel", nivel);
                    response.sendRedirect("Admin/admin.jsp");
                }
            }
            if(request.getParameter("cerrar")!=null){
                session.invalidate();//de jsp a jsp es get parameter
                
            }
            %>
        
        
    </body>
</html>
