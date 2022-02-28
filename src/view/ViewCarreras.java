package view;

import controller.Control;
import controller.DTOCarrera;

public class ViewCarreras extends View{
    
    public void mostarCarrerasDeSede() {
        
        String codigo = requestInputString("digite el código de la sede");
        c.mostrarCarreras(codigo);
        System.out.println("Las carreras de " + codigo + ":\n" + c.getDto().getLasCarreras());
        
    }


    public void mostarCarrerasEspecDeSede() {
        //mostrar las carreras específicas de una sede particular: SAN JOSE
        String sede = requestInputString("digite el código de la sede");
        String carrera = requestInputString("digite el código de carrera");

        Control.getInstance().consultarCarrera(sede, carrera);
        DTOCarrera elDTO = c.getDto();

        System.out.println("La carrera consultada es "+ elDTO.getCodigo()+ "-"+  elDTO.getNombre());
    }

    public void crearUnaCarrera() {

        //incorporando una nueva carrera al sistema
        System.out.println("Ingresando una nueva carrera");
        DTOCarrera elDTO = c.getDto();

        elDTO.setCodigo(requestInputString("Ingrese el código de la carrera"));
        elDTO.setNombre(requestInputString("Ingrese el nombre de la carrera"));
        elDTO.setGrado(requestInputString("Ingrese el Grado de la carrera"));
        elDTO.setMaximoAdmitidos(requestInputInt("Ingrese el máximo de admitidos"));
        elDTO.setPuntajeMaximo(requestInputInt("Ingrese el puntaje máximo"));
        elDTO.setCodigoSede(requestInputString("ngrese el código de la sede"));

        if(c.crearCarrera(elDTO)) {
            System.out.println(elDTO);
            System.out.println("La carrera se a creado con exito!");
        } else {
            System.err.println("Error al crear la carrera ");
        }
    }

}
