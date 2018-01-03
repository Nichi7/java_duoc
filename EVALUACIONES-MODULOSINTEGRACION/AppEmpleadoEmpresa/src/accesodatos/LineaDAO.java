/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.SQLException;
import negocio.Linea;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author Jazna
 */
public class LineaDAO {
    private Linea linea;

    public LineaDAO() {
    }

    public LineaDAO(Linea linea) {
        this.linea = linea;
    }
    
    /**
     * Permite insertar/actulizar un registro en la tabla
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void grabar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();

        cdb.un_sql = "SELECT ln_id FROM linea WHERE ln_id = " + linea.getId()  + "";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null){
            if (cdb.resultado.next()){
                cdb.un_sql = "UPDATE linea SET ln_nombre ='" + 
                        linea.getNombre() + "' WHERE ln_id =" +  
                        linea.getId() + ";";
                cdb.un_st.executeUpdate(cdb.un_sql);
            }
            else{
                cdb.un_sql = "INSERT INTO linea(ln_id, ln_nombre) VALUES (" + 
                        linea.getId() + ",'" + linea.getNombre() + "')";
                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        }
        else{
            cdb.un_sql = "INSERT INTO linea(ln_id, ln_nombre) VALUES (" + 
                        linea.getId() + ",'" + linea.getNombre() + "')";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }        
    }
}
