/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO.DAO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Leo
 */
public interface PojoDAO {
    
    //CRUD
    public void create() throws Exception;
    public ArrayList read() throws Exception;
    public void update() throws Exception;
    public void delete() throws Exception;
    
}
