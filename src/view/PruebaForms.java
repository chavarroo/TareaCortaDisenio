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
        
        cargarForms();
                
/*
        //Punto 7
        for (int i = 0;i<dtoForm.getLosFormularios().size();i++){
            int puntaje = (int) Math.floor(Math.random()*(800-0+1)+0);
            Control.getInstance().verFormularioDetalle(i);
            dtoForm.getDetalleFormulario().setPuntajeObtenido(puntaje);
            System.out.print(dtoForm.getDetalleFormulario());
        }
        
        Control.getInstance().actualizarEstado();*/
       
        //Punto 9
        Control.getInstance().mostrarFormularios();
        System.out.println("Solicitudes: \n" + dtoForm.getLosFormularios());
        
        //Punto 10
        Control.getInstance().verFormulariosFiltro("EN_ESPERA", true, "IC");
        System.out.println("Solicitudes con filtro: \n" + dtoForm.getLosFormularios());
        
        //Punto 11
        Control.getInstance().verCantXEstado("EN_ESPERA");
        System.out.println("Punto 11: \n" + dtoForm.getMap());
        
        //Punto 12
        Control.getInstance().verFormularioDetalle(0);
        System.out.println("Formulario Detalle: \n" + dtoForm.getDetalleFormulario());
    }
    
    
    //Datos de prueba
    public static void cargarForms() throws ParseException{
        dtoForm.setEstado("EN_ESPERA");
        dtoForm.setCodCarrera("IC");
        dtoForm.setCodSede("SJ");
        dtoForm.setIdentificacion(305350640);
        dtoForm.setNombre("Jhonny Picado");
        dtoForm.setFechaNacimiento("14/11/2001");
        dtoForm.setCorreo("jhonnypv14@gmail.com");
        dtoForm.setNumeroTelefono(62321437);
        dtoForm.setDireccion("Corralillo, Cartago");
        dtoForm.setInstitucion("CTP San Juan Sur");
        //dtoForm.setPuntajeObtenido(97);

        Control.getInstance().crearFormulario(dtoForm);
        
        dtoForm.setEstado("EN_ESPERA");
        dtoForm.setCodCarrera("IC");
        dtoForm.setCodSede("SJ");
        dtoForm.setIdentificacion(109080652);
        dtoForm.setNombre("Juan Vargas");
        dtoForm.setFechaNacimiento("23/05/1998");
        dtoForm.setCorreo("jvargas@outlook.com");
        dtoForm.setNumeroTelefono(65434578);
        dtoForm.setDireccion("Pavas, San José");
        dtoForm.setInstitucion("Liceo Costa Rica");
        //dtoForm.setPuntajeObtenido(40);
        
        Control.getInstance().crearFormulario(dtoForm);
        
        dtoForm.setEstado("RECHAZADO");
        dtoForm.setCodCarrera("IC");
        dtoForm.setCodSede("CA");
        dtoForm.setIdentificacion(101110111);
        dtoForm.setNombre("Michael Lopez");
        dtoForm.setFechaNacimiento("24/12/2003");
        dtoForm.setCorreo("jmlopez@gmail.com");
        dtoForm.setNumeroTelefono(65439009);
        dtoForm.setDireccion("Paraíso, Cartago");
        dtoForm.setInstitucion("CTP José Figueres Ferrer");
        //dtoForm.setPuntajeObtenido(100);
        
        Control.getInstance().crearFormulario(dtoForm);
        
        dtoForm.setEstado("RECHAZADO");
        dtoForm.setCodCarrera("IC");
        dtoForm.setCodSede("SJ");
        dtoForm.setIdentificacion(609870543);
        dtoForm.setNombre("Milena Rodríguez");
        dtoForm.setFechaNacimiento("01/01/1999");
        dtoForm.setCorreo("rodm1999@outlook.com");
        dtoForm.setNumeroTelefono(89095432);
        dtoForm.setDireccion("Jacó, Puntarenas");
        dtoForm.setInstitucion("Liceo Jacó");
        //dtoForm.setPuntajeObtenido(85);
        
        Control.getInstance().crearFormulario(dtoForm);
        
        dtoForm.setEstado("EN_ESPERA");
        dtoForm.setCodCarrera("IC");
        dtoForm.setCodSede("CA");
        dtoForm.setIdentificacion(203450768);
        dtoForm.setNombre("Fabiola Muñoz");
        dtoForm.setFechaNacimiento("29/06/2000");
        dtoForm.setCorreo("fabs29@gmail.com");
        dtoForm.setNumeroTelefono(72980345);
        dtoForm.setDireccion("Sarchí, Alajuela");
        dtoForm.setInstitucion("CTP San Juan Sur");
        //dtoForm.setPuntajeObtenido(56);
        
        Control.getInstance().crearFormulario(dtoForm);
    }
}
