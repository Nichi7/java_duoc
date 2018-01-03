/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Concepción
 */
public class LineaIT {
    
    public LineaIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Linea.
     */
    
    @Test
    @Ignore
    public void testGetId() {
        System.out.println("getId");
        Linea instance = new Linea();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Linea.
     */
    @Test
    @Ignore
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Linea instance = new Linea();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Linea.
     */
    @Test
    @Ignore
    public void testGetNombre() {
        System.out.println("getNombre");
        Linea instance = new Linea();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Linea.
     */
    @Test
    @Ignore
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Linea instance = new Linea();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grabar method, of class Linea.
     */
    @Test
    
    public void testGrabar() throws Exception {
        System.out.println("grabar");
        Linea instance = new Linea();
        instance.setId(1); instance.setNombre("LINEA AZUL");
        instance.grabar();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
  
}
