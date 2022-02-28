/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.DAO.DAOFormulariosImpl;
import java.util.Collections;
import java.util.List;
import model.Formulario;

/**
 *
 * @author Jhonny Picado Vega
 */
public class GestorFormularios {
    
    
    public boolean agregarFormulario(Formulario unFormulario) {
        return DAOFormulariosImpl.getInstance().create(unFormulario);
    }
    
    public List buscarFormularios(){
        DTOFormulario unDTO = new DTOFormulario();
        return DAOFormulariosImpl.getInstance().getAll();
    } 
    
    public List getSolicitudesXNombre(String tEstado, String codCarrera){
        
        List<Formulario> forms = DAOFormulariosImpl.getInstance().getAll(tEstado, codCarrera);
        Collections.sort(forms, (o1, o2) -> {
            return o1.getNombre().compareTo(o2.getNombre()); //To change body of generated lambdas, choose Tools | Templates.
        });
        return forms;
    }
    
    public List getSolicitudesXPuntaje(String tEstado, String codCarrera){
        
        List<Formulario> forms = DAOFormulariosImpl.getInstance().getAll(tEstado, codCarrera);
        Collections.sort(forms, (o1, o2) -> {
            return o1.getPuntajeObtenido()- o2.getPuntajeObtenido(); //To change body of generated lambdas, choose Tools | Templates.
        });
        
        return forms;
    }
    
    public Formulario getFormularioDetalle(int numFormulario){
        
        return (Formulario) DAOFormulariosImpl.getInstance().get(numFormulario);
        
    }
    
    //Método punto 7
    public void simularPrueba(){
        
        List<Formulario> forms = DAOFormulariosImpl.getInstance().getAll();
        
        for (int i = 0;i< forms.size(); i++) {
            
            int puntaje = (int) Math.floor(Math.random()*(800-0+1)+0);
            
            forms.get(i).setPuntajeObtenido(puntaje);
        }
        
    }
    
}
