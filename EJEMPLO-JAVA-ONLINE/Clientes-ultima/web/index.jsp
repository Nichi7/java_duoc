
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Inicio Sesión</h1>
        
        <form action="Validar.do" method="post">
            <input type="email" name="txtMail" placeholder="E-mail" required="required"/><br/>
            <input type="password" name="txtPass" placeholder="Contraseña" required="required"/><br/>
            <input type="submit" value="Iniciar Sesión"/>  
        </form>
        
       
    </body>
</html>
