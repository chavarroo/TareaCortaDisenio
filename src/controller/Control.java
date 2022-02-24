/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.DAO.DAOSedesImpl;
import model.Carrera;
import model.Sede;
import model.TGrado;

/**
 *
 * @author ersolano
 */
public class Control {

    //atributo autorreferenciado para el manejo del Singleton
    private static Control singletonControl;

    //Atributo DTO Utilitario para la transferencia de datos asociados a la entidad Carrera
    private DTOCarrera dto;

    //atributos de acceso controlado 
    private GestorCarreras gCarreras;

    public static Control getInstance() {
        if (singletonControl == null) {
            singletonControl = new Control();
        }
        return singletonControl;
    }

    private Control() {
        dto = new DTOCarrera();
        gCarreras = new GestorCarreras();  // se habilita un gestor con carreras precreadas    
    }

    public DTOCarrera getDto() {
        return dto;
    }

    public boolean crearCarrera(DTOCarrera dto) {
        // Paso 1: localizar todos los datos que están relacionados a la carrera 
        TGrado elGrado = TGrado.valueOf(dto.getGrado());
        Sede laSede = (Sede) DAOSedesImpl.getInstance().get(dto.getCodigoSede());

        //crea una instancia de acuerdo al modelo propuesto de una carrera
        Carrera unaCarrera = new Carrera(dto.getCodigo(), dto.getNombre(),
                dto.getPuntajeMaximo(), dto.getMaximoAdmitidos(),
                elGrado, laSede);
        // se solicita al gestor el registro de la carrera
        return gCarreras.agregarCarrera(unaCarrera);
    }

    public void mostrarCarreras() {
        // el gestor obtiene lo solicitado y lo deja en el dto.
        dto.setLasCarreras(gCarreras.buscarCarreras());
    }

    public void mostrarCarreras(String codigoSede) {
        dto.setLasCarreras(gCarreras.buscarCarreras(codigoSede));
    }

    public void consultarCarrera(String codSede, String codCarrera) {
        Carrera laCarrera = gCarreras.buscarCarrera(codSede, codCarrera);
        if (laCarrera != null) {
            dto.setCodigo(laCarrera.getCodigo());
            dto.setNombre(laCarrera.getNombre());
            dto.setGrado(laCarrera.getGrado().name());
            dto.setMaximoAdmitidos(laCarrera.getCapacidadMax());
            dto.setPuntajeMaximo(laCarrera.getPuntajeAdmision());
            dto.setCodigoSede(laCarrera.getLaSede().getCodigo());
        }
    }

    public boolean editarCarrera(DTOCarrera elDTO) {
        Carrera laCarrera = gCarreras.buscarCarrera(elDTO.getCodigoSede(), elDTO.getCodigoSede());
        if (laCarrera != null) {
            laCarrera.setPuntajeAdmision(elDTO.getPuntajeMaximo());
            laCarrera.setCapacidadMax(elDTO.getMaximoAdmitidos());
            return gCarreras.modificarCarrera(laCarrera);
        }
        return false;
    }
}
