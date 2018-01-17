<%@page import='modelado.DAOPersona'%>
<%@page import='java.util.*'%>
<%@page import='uml.Persona'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Persona</title>
        <script lang="JavaScript">
            function cargar(id, nombres, apellidos, edad){
                document.formPersona.txtId.value=id;
                document.formPersona.txtNombres.value=nombres;
                document.formPersona.txtApellidos.value=apellidos;
                document.formPersona.txtEdad.value=edad;
            }
            
        </script>
    </head>
    
    <!--inserto codigo JAVA-->
            <%
               DAOPersona dao = new DAOPersona();
               List<Persona> datos = new ArrayList(); //la lista debe estar vacio
                %>
    <body>
        <form name="formPersona" method="POST" action ="SERVPersona">
            <pre>Id de persona :<input type="text" name="txtId"></pre><br/>
            <pre>Nombres       :<input type="text" name="txtNombres"></pre><br/>
            <pre>Apellidos     :<input type="text" name="txtApellidos"></pre><br/>
            <pre>Edad          :<input type="number" name="txtEdad"></pre><br/>
            <input type="submit" name="btnInsertar" value="Insertar">
            <input type="submit" name="btnModificar" value="Modificar">
            <input type="submit" name="btnEliminar" value="Eliminar"><br/><br/>
            Buscar: <input type="text" name="txtCriterio">
            En base a : <input type="text" name="txtCampo">
            <input type="submit" name="btnFiltrar" value="Filtrar">
            <input type="submit" name="btnReiniciar" value="Reiniciar">
        </form>
        <!--crear formulario principalmente html-->
    <hr><center>
        <table border="1px">
            <tr>
                <!--encabezado tabla de datos persona-->
                <td>ID</td>
                <td>NOMBRES</td>
                <td>APELLIDOS</td>
                <td>EDAD</td>
                <td>ACCION</td>
            </tr>
            <%
                //hacer un recorrido por sobre el resultado de la consulta y mostrar datos
                if(request.getAttribute("filtro")!=null)
                {
                    datos = (List<Persona>)request.getAttribute("filtro");
                    
                }else if(request.getAttribute("reinicio")!=null){
                    datos = dao.consultar();
                }else{
                    datos = dao.consultar();
                }
                
                for(Persona p:datos){
                    %>
                    <tr>
                        <td><%= p.getId()    %></td>
                        <td><%= p.getNombres()   %></td>
                        <td><%= p.getApellidos()  %></td>
                        <td><%= p.getEdad()   %></td> 
                        <td><a href="JavaScript:cargar(id, nombres, apellidos, edad);">cargar</a></td> 
                    </tr>
                    
                    <%
                }
                %>
                <tr>
                    
                </tr>
             
        </table>
    </center>      
       
    </body>
</html>
