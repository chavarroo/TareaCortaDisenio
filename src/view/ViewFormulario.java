package view;

import controller.Control;
import controller.DTOFormulario;

import java.text.ParseException;

public class ViewFormulario extends View {

    //6
    public void registrarFormulario() {
        System.out.println("----------------Registrar un formulario----------------");

        String carrera = requestInputString("Ingrese la carrera: ");
        int identificacion = requestInputInt("Ingrese la identificacion: ");
        String nombre = requestInputString("Ingrese la nombre: ");
        String fechaNacimiento = requestInputString("Ingrese la fechaNacimiento: ");
        String correo = requestInputString("Ingrese la correo: ");
        int numeroTelefono = requestInputInt("Ingrese la numeroTelefono: ");
        String direccion = requestInputString("Ingrese la direccion: ");
        String institucion = requestInputString("Ingrese la institucion: ");

        DTOFormulario f = new DTOFormulario();
        f.setCodCarrera(carrera);
        f.setIdentificacion(identificacion);
        f.setNombre(nombre);
        f.setFechaNacimiento(fechaNacimiento);
        f.setCorreo(correo);
        f.setNumeroTelefono(numeroTelefono);
        f.setDireccion(direccion);
        f.setInstitucion(institucion);

        try {
            c.crearFormulario(f);
            System.out.println(f);
            System.out.println("Formulario creado con exito!");
        } catch (ParseException e) {
            System.out.println("Error al crear el formulario, Intente de nuevo");
            registrarFormulario();
        }
    }

    public void listarSoliciudes() {
        System.out.println("----------------Listar solicitudes----------------");
        c.mostrarFormularios();
        System.out.println(c.getDtoForm().getLosFormularios());
    }


    public void detallesFormulario() {
        System.out.println("----------------Detalles de un formulario----------------");

        int n = requestInputInt("Ingrese el número de formulario");
        c.verFormularioDetalle(n);
        System.out.println("Formulario Detalle: \n" + c.getDtoForm().getDetalleFormulario());
    }

    private void verFormulariosFiltro(boolean porNombre) {
        String tEstado = requestInputString("Inserte el estado");
        String codCarrera = requestInputString("inserte el código de la carrera");

        c.verFormulariosFiltro(tEstado, porNombre, codCarrera);
        System.out.println("Formulario Detalle: \n" + c.getDtoForm().getDetalleFormulario());
    }

    public void verFormulariosFiltroPorNombre(){
        System.out.println("----------------Ver formulario por nombre----------------");
        verFormulariosFiltro(true);
    }

    public void verFormulariosFiltroPorPuntaje(){
        System.out.println("----------------Ver formulario por puntaje----------------");
        verFormulariosFiltro(false);
    }

    public void verCarrerasSedePorEstado() {
        System.out.println("----------------Ver carreras y sedes segun Estado----------------");
        String tEstado = requestInputString("Inserte el estado");
        c.verCantXEstado(tEstado);
        System.out.println(c.getDtoForm().getMap());
    }

    // 7
    public void verSimularPruebas() {
        System.out.println("----------------Simulando pruebas----------------");
        c.simularPrueba();
        System.out.println("Resultados de la simulacion: ");
        System.out.println(c.getDtoForm().getLosFormularios());
    }
}
