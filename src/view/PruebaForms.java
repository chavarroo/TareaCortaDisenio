/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Control;
import controller.DTOCarrera;
import controller.DTOFormulario;
import java.text.ParseException;

/**
 *
 * @author Jhonny Picado Vega
 */
public class PruebaForms {
    
    static DTOCarrera elDTO;    
    static DTOFormulario dtoForm;
    
    public static void main (String args[]) throws ParseException{
        
        // se activa el DTO que provee el control
        elDTO = Control.getInstance().getDto();
        dtoForm = Control.getInstance().getDtoForm();
        
        
        //Carga las carreras para tener unas de prueba
        Control.getInstance().mostrarCarreras();
        System.out.println("Todas las carreras\n" + elDTO.getLasCarreras());
        
        System.out.println("********************************************************************************************\n");
        
        
        dtoForm.setEstado("SOLICITANTE");
        dtoForm.setCodCarrera("IC");
        dtoForm.setIdentificacion(305350640);
        dtoForm.setNombre("Jhonny Picado");
        dtoForm.setFechaNacimiento("14/11/2001");
        dtoForm.setCorreo("jhonnypv14@gmail.com");
        dtoForm.setNumeroTelefono(62321437);
        dtoForm.setDireccion("Corralillo, Cartago");
        dtoForm.setInstitucion("CTP San Juan Sur");

        Control.getInstance().crearFormulario(dtoForm);
        
        dtoForm.setEstado("SOLICITANTE");
        dtoForm.setCodCarrera("AE");
        dtoForm.setIdentificacion(109080652);
        dtoForm.setNombre("Juan Vargas");
        dtoForm.setFechaNacimiento("23/05/1998");
        dtoForm.setCorreo("jvargas@outlook.com");
        dtoForm.setNumeroTelefono(65434578);
        dtoForm.setDireccion("Pavas, San José");
        dtoForm.setInstitucion("Liceo Costa Rica");

        Control.getInstance().crearFormulario(dtoForm);
        
        
        Control.getInstance().mostrarFormularios();
        System.out.println("Solicitudes: \n" + dtoForm.getLosFormularios());
        
    }
    
}
