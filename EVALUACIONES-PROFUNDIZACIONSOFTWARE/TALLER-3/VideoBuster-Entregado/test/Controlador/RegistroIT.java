/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Pelicula;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author daniela
 */
public class RegistroIT {

    public RegistroIT() {
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

    
    @Test
    @Ignore
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Registro instance = new Registro();
        ArrayList<Categoria> expResult = null;
        ArrayList<Categoria> result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    @Ignore
    public void testAgregar() {
        System.out.println("agregar");
        Pelicula p = null;
        Registro instance = new Registro();
        String expResult = "";
        String result = instance.agregar(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAgregar1() throws Exception {
        System.out.println("Comienza testeo agregar un registro a la tabla película");
        Pelicula instance = new Pelicula();
        Registro r = new Registro();
        instance.setCodigo(70000);
        instance.setPrecio(5000);
        instance.setCategoria(3);
        instance.setFormato4k("S");
        instance.setNombre("soldador ryan");
        r.agregar(instance);
        System.out.println("Teste realizado correctamente");
    }

    @Test
    public void testAgregar2() throws Exception {
        System.out.println("Comienza testeo agregar un registro a la tabla categoria");
        Categoria instance = new Categoria();
        Registro r = new Registro();
        instance.setCodigo(10);
        instance.setDescrip("Futuro");
        r.agregar1(instance);
        System.out.println("Teste realizado correctamente");
    }

   
    @Test
    @Ignore
    public void testBuscar() {
        System.out.println("buscar");
        int codigo = 0;
        Registro instance = new Registro();
        Pelicula expResult = null;
        Pelicula result = instance.buscar(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    @Ignore
    public void testEliminar() {
        System.out.println("eliminar");
        int codigo = 0;
        Registro instance = new Registro();
        instance.eliminar(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    @Ignore
    public void testActualizar() {
        System.out.println("actualizar");
        Pelicula p = null;
        Registro instance = new Registro();
        String expResult = "";
        String result = instance.actualizar(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testbuscar1() throws Exception {
        System.out.println("Comienza testeo buscar una pelicula cuyo nombre tenga un texto determinado");
        Pelicula instance = new Pelicula();
        Registro r = new Registro();
        instance.setCodigo(70000);
        instance.setPrecio(5000);
        instance.setCategoria(3);
        instance.setFormato4k("S");
        instance.setNombre("soldador ryan");
        r.buscar1(instance.getNombre());
        System.out.println("Teste realizado correctamente");
       
    }

}
