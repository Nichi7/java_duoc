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
public class BusIT {
    
    public BusIT() {
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
     * Test of getPatente method, of class Bus.
     */
    @Test
    @Ignore
    public void testGetPatente() {
        System.out.println("getPatente");
        Bus instance = new Bus();
        String expResult = "";
        String result = instance.getPatente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPatente method, of class Bus.
     */
    @Test
    @Ignore
    public void testSetPatente() {
        System.out.println("setPatente");
        String patente = "";
        Bus instance = new Bus();
        instance.setPatente(patente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLinea method, of class Bus.
     */
    @Test
    @Ignore
    public void testGetLinea() {
        System.out.println("getLinea");
        Bus instance = new Bus();
        Linea expResult = null;
        Linea result = instance.getLinea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLinea method, of class Bus.
     */
    @Test
    @Ignore
    public void testSetLinea() {
        System.out.println("setLinea");
        Linea linea = null;
        Bus instance = new Bus();
        instance.setLinea(linea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grabar method, of class Bus.
     */
    @Test
    public void testGrabar() throws Exception {
        System.out.println("grabar");
        Linea l = new Linea();
        l.setId(40);
        l.setNombre("VIA COSTA");
        l.grabar();
        Bus instance = new Bus();
        instance.setLinea(l);
        instance.setPatente("fXDCFV");
        instance.grabar();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
