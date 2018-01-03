/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.SQLException;
import negocio.Bus;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author Jazna
 */
public class BusDAO {
    private Bus bus;

    public BusDAO() {
    }

    public BusDAO(Bus bus) {
        this.bus = bus;
    }
    
    /**
     * Permite insertar/actualizar un registro en la tabla
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void grabar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();

        cdb.un_sql = "SELECT bs_patente FROM bus WHERE bs_patente = '" + bus.getPatente()  + "'";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        if (cdb.resultado != null){
            if (cdb.resultado.next()){
                cdb.un_sql = "UPDATE bus SET linea_ln_id =" + 
                        bus.getLinea().getId() + " WHERE bs_patente ='" +  
                        bus.getPatente() + "';";
                cdb.un_st.executeUpdate(cdb.un_sql);
            }
            else{
                cdb.un_sql = "INSERT INTO bus(bs_patente, linea_ln_id) VALUES ('" + 
                        bus.getPatente() + "'," + bus.getLinea().getId() + ")";
                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        }
        else{
            cdb.un_sql = "INSERT INTO bus(bs_patente, linea_ln_id) VALUES ('" + 
                        bus.getPatente() + "'," + bus.getLinea().getId() + ")";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }           
    }
}
