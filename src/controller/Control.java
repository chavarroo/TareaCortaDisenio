/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.DAO.DAOSedesImpl;
import controller.DAO.DAOCarrerasImpl;
import controller.DAO.DAOFormulariosImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import model.Carrera;
import model.Formulario;
import model.Sede;
import model.TEstado;
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
    
    //Atributo DTO Utilitario para la transferencia de datos asociados a la entidad Formulario
    private DTOFormulario dtoForm;
    
    //atributos de acceso controlado 
    private GestorCarreras gCarreras;
    private GestorFormularios gForms;
    
    
    public static Control getInstance() {
        if (singletonControl == null) {
            singletonControl = new Control();
        }
        return singletonControl;
    }

    private Control() {
        dto = new DTOCarrera();
        gCarreras = new GestorCarreras();  // se habilita un gestor con carreras precreadas    
        
        dtoForm = new DTOFormulario();
        dtoForm.setLosFormularios(new ArrayList<>());
        
        gForms = new GestorFormularios();
    }

    //Retorna el objeto dtoCarrera del controlador
    public DTOCarrera getDto() {
        return dto;
    }
    
    //Retorna el objeto dtoForm del controlador
    public DTOFormulario getDtoForm(){
        return dtoForm;
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
    
    
    //Sección del controlador para crear forms
    public boolean crearFormulario(DTOFormulario dto) throws ParseException {

        // Paso 1: localizar todos los datos que están relacionados con el formulario
        Carrera carrera = (Carrera) DAOCarrerasImpl.getInstance().get(dto.getCodSede(), dto.getCodCarrera());
        TEstado elEstado = TEstado.valueOf(dto.getEstado());
        int id = DAOFormulariosImpl.getInstance().newID();
        
        //Setea la fecha correctamente 
        Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(dto.getFechaNacimiento());

        
        //crea una instancia de acuerdo al modelo propuesto de un formulario
        Formulario formulario = new Formulario(id, elEstado, carrera, 0, dto.getIdentificacion(),
                                                dto.getNombre(), fecha, dto.getCorreo(), 
                                                dto.getNumeroTelefono(), dto.getDireccion(), dto.getInstitucion());

       // se solicita al gestor el registro de la solicitud
       
        return gForms.agregarFormulario(formulario);
    }

    public void mostrarCarreras() {
        // el gestor obtiene lo solicitado y lo deja en el dto.
        dto.setLasCarreras(gCarreras.buscarCarreras());
    }
    
    
    //Retorna todos los formularios
    public void mostrarFormularios() {
        // el gestor obtiene lo solicitado y lo deja en el dto.
        dtoForm.setLosFormularios(gForms.buscarFormularios());
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
    
    //Método 7
    public void simularPrueba() {
        
        //Metodo que simula la prueba
        gForms.simularPrueba();
        
        //Recarga los forms en el DTO
        dtoForm.setLosFormularios(gForms.buscarFormularios());
    }
    
    //Método punto 8
    public void actualizarEstado() {
        
        //Request de listas
        List<Carrera> carreras = gCarreras.buscarCarreras();
        List<Formulario> forms = gForms.buscarFormularios();
        
       for(int i = 0; i<carreras.size();i++){
           int cupo = 0;
           int puntajeMinimo = carreras.get(i).getPuntajeAdmision();
           int capacidad = carreras.get(i).getCapacidadMax();
           
           for(int j = 0; j < forms.size(); j++) {
               
               
               if(forms.get(j).getCarrera() == carreras.get(i)){
                    
                    int puntaje = forms.get(j).getPuntajeObtenido();
                    
                    if(puntaje < puntajeMinimo){
                        forms.get(j).setEstado(TEstado.RECHAZADO);
                    }
                    else if(cupo < capacidad){
                        forms.get(j).setEstado(TEstado.ACEPTADO);
                        cupo += 1;
                    }
                    else {
                        forms.get(j).setEstado(TEstado.EN_ESPERA);
                    }
                }
           }
       }
    }
    
    
    //Método punto 10
    public void verFormulariosFiltro(String tEstado, boolean porNombre, String codCarrera){
        
        if (porNombre) dtoForm.setLosFormularios(gForms.getSolicitudesXNombre(tEstado, codCarrera));
        else dtoForm.setLosFormularios(gForms.getSolicitudesXPuntaje(tEstado, codCarrera));
    }
    
    
    //Método punto 11
    public void verCantXEstado(String tEstado){
        
        //Request de listas
        List<Carrera> carreras = gCarreras.buscarCarreras();
        List<Formulario> forms = gForms.buscarFormularios();
        
        //Variables temps
        Map<Carrera, Integer> map = new HashMap<Carrera, Integer>();
        TEstado estado = TEstado.valueOf(tEstado);
        
        //Carreras primero
        for (int i = 0; i<carreras.size(); i++){
            
            int count = 0;
            
            //Recorre forms
            for (int j=0; j<forms.size(); j++){
                
                //Aumenta la cantidad según coincidencia
                if (carreras.get(i) == forms.get(j).getCarrera() && 
                        forms.get(j).getEstado() == estado){
                    
                    count++;      
                }
            }
            //Add to hashmap
            map.put(carreras.get(i), count);
        }
        
        dtoForm.setMap(map);
    }
    
    //Método punto 12
    public void verFormularioDetalle(int numFormulario){
        dtoForm.setDetalleFormulario(gForms.getFormularioDetalle(numFormulario));
    }
}
