/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO.DAO;

import MODELO.NEGOCIO.Chocolate;
import SERVICIOS.DB.ConexionMySql;
import SERVICIOS.Servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class ChocolateDAO implements PojoDAO
{
    Chocolate ch;
    
    public ChocolateDAO(Chocolate c)
    {
        this.ch = c;
    }

    @Override
    public void create()  throws Exception {
        PreparedStatement ps = null;
        
        
        try {
            String query = "insert into chocolate(codigo, nombre, descripcion, precioventa, cantidad, tipocolor, tiposabor, marca, azucar) values (?,?,?,?,?,?,?,?,?)";
            Connection c = Servicios.getInstancia().DB().getConection();
            ps = c.prepareStatement(query);
            
            ps.setInt(1, ch.getCodigo());
            ps.setString(2, ch.getNombre());
            ps.setString(3, ch.getDescripcion());
            ps.setInt(4, ch.getPrecioventa());
            ps.setInt(5, ch.getCantidad());
            ps.setString(6, ch.getTipocolor());
            ps.setString(7, ch.getTiposabor());
            ps.setString(8, ch.getMarca());
            ps.setBoolean(9, ch.isAzucar());

            System.out.println("void ChocolateDAO.create()");
            System.out.println("---------------------------");

            System.out.println(ps.toString());
            
            if (c.getAutoCommit())
            {
                System.out.println("AuoCommit = true");
            }
            else
            {
                System.out.println("AuoCommit = false");
            }
            ps.executeUpdate();
            
            
            
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
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public void update() throws Exception
    {
        PreparedStatement ps = null;
        
        
        try {
            String query = "update chocolate set nombre = ? , descripcion = ? , azucar = ? where rut = ?";
            Connection c = Servicios.getInstancia().DB().getConection();
            ps = c.prepareStatement(query);
            
            ps.setString(1, ch.getNombre());
            ps.setString(2, ch.getDescripcion());
            ps.setBoolean(3, ch.isAzucar());
            ps.setInt(4, ch.getCodigo());
            
            

            System.out.println("void ChocolateDAO.update()");
            System.out.println("---------------------------");

            System.out.println(ps.toString());
            
            if (c.getAutoCommit())
            {
                System.out.println("AuoCommit = true");
            }
            else
            {
                System.out.println("AuoCommit = false");
            }
            ps.executeUpdate();
            
            
            
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
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void delete() throws Exception {
        PreparedStatement ps = null;
        
        
        try {
            String query = "delete from chocolate where codigo = ?";
            Connection c = Servicios.getInstancia().DB().getConection();
            ps = c.prepareStatement(query);
            
            ps.setInt(1, ch.getCodigo());
            

            System.out.println("void ChocolateDAO.delete()");
            System.out.println("---------------------------");

            System.out.println(ps.toString());
            
            if (c.getAutoCommit())
            {
                System.out.println("AuoCommit = true");
            }
            else
            {
                System.out.println("AuoCommit = false");
            }
            ps.executeUpdate();
            
            
            
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
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
    }
    
    
    @Override
    public ArrayList read() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
