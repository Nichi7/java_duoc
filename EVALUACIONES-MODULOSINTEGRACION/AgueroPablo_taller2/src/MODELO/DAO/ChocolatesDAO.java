/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO.DAO;

import MODELO.NEGOCIO.Chocolate;
import java.util.ArrayList;
import SERVICIOS.DB.Conexion;
import SERVICIOS.DB.ConexionMySql;
import SERVICIOS.Servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class ChocolatesDAO implements PojoDAO {

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList read() throws Exception {
        ArrayList rows = new ArrayList();
        PreparedStatement ps = null;
        
        
        try {
            String query = "select codigo, nombre, descripcion, precioventa, cantidad, tipocolor, tiposabor, marca, azucar from chocolate";
            Connection c = Servicios.getInstancia().DB().getConection();
            ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            System.out.println("ArrayList ChocolatesDAO.read()");
            System.out.println("---------------------------");
            
            while (rs.next())
            {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getNString("nombre");
                String descripcion = rs.getString("descripcion");
                int precioventa = rs.getInt("precioventa");
                int cantidad = rs.getInt("cantidad");
                String tipocolor = rs.getString("tipocolor");
                String tiposabor = rs.getString("tiposabor");
                String marca = rs.getString("marca");
                boolean azucar = rs.getBoolean("azucar");
                
                
                
                Chocolate ch = new Chocolate();
                ch.setCodigo(codigo);
                ch.setNombre(nombre);
                ch.setDescripcion(descripcion);
                ch.setPrecioventa(precioventa);
                ch.setCantidad(cantidad);
                ch.setTipocolor(tipocolor);
                ch.setTiposabor(tiposabor);
                ch.setMarca(marca);
                ch.setAzucar(azucar);
                
             
                rows.add(ch);
                
                
                
                //System.out.println("'"+rut + "' , '" + nombre + "' , " + edad + ", " + estudia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
           if (ps != null)
           {
               try {
                   ps.close();
               } catch (SQLException ex) {
                   Logger.getLogger(ConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }        
        return rows;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
