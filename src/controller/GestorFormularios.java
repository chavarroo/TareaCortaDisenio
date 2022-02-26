/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.DAO.DAOFormulariosImpl;
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
}
