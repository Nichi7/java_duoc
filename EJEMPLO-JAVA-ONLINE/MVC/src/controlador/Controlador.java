/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author daniela
 */
//heredera los metodos de la clase actionlistener para escuchar los eventos de algun  boton
public class Controlador implements ActionListener{
    //declara objetos tipo clase   
    private Vista view;
    private Modelo model;

    public Controlador(Vista view, Modelo model) 
    {
        this.view = view;
        this.model = model;
        //vamos a atraer una accion del boton
        this.view.btnmultiplicar.addActionListener(this);
    }
    //crear metodo del tipo voy que iniciara mi vista
    public void iniciar() 
    {
        //coloca titulo a la ventana
        view.setTitle("MVC Multiplicar");
        //centraliza la ventana
        view.setLocationRelativeTo(null);
        
    }
   //crear la funcion que realizara el boton
    public void actionPerformed(ActionEvent e){
        
        model.setNumerouno(Integer.parseInt(view.txtnumero1.getText()));
        model.setNumerodos(Integer.parseInt(view.txtnumero2.getText()));
        model.multiplicar();//primero se llama al metodo multiplica 
        //luego se ingresa el resultado al txtresultado
        view.txtresultado.setText(String.valueOf(model.getResultado()));
    }
    
    
    
    
}
