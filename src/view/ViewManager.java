package view;

import controller.Control;
import controller.DTOFormulario;

import java.text.ParseException;
import java.util.Scanner;

public class ViewManager extends View {

    public void mainMenu() {

        int op = -1;
        s = new Scanner(System.in);
        ViewFormulario viewFormulario = new ViewFormulario();
        ViewCarreras viewCarreras = new ViewCarreras();

        while (op != 0 ) {

            System.out.println("########################");
            System.out.println("\tMenu principal");
            System.out.println("########################");

            System.out.println("0. salir");
            System.out.println("1. Crear Formulario"); // 6
            System.out.println("2. Simular aplicación de prueba"); // 7
            System.out.println("3. Proceso de cambio de estado"); // 8
            System.out.println("4. Listar solicitudes recibidas"); // 9
            System.out.println("5. Mostrar los detalles de un formulario"); // 12
            System.out.println("6. Formularios por nombre"); // 10.a
            System.out.println("7. Formularios por puntaje"); // 10.b
            System.out.println("8. Mostrar cantidad de solicitudes por carrera y por sede segun, segun estado"); // 11

            // de la profe
            System.out.println("9. Mostrar las carrearas de una sede");
            System.out.println("10. Mostrar las carrearas especificas de una sede");
            System.out.println("11. Crear una nueva carrera");


            op = requestInputInt("Inserte la opción");
            switch (op) {
                case 0 -> System.exit(0);
                case 1 -> viewFormulario.registrarFormulario(); // 6
                case 2 -> viewFormulario.verSimularPruebas(); // 7
                case 3 -> viewFormulario.verSimularPruebas(); // 8
                case 4 -> viewFormulario.listarSoliciudes(); // 9
                case 5 -> viewFormulario.detallesFormulario(); // 12
                case 6 -> viewFormulario.verFormulariosFiltroPorNombre(); // 10.a
                case 7 -> viewFormulario.verFormulariosFiltroPorPuntaje(); // 10.b
                case 8 -> viewFormulario.verCarrerasSedePorEstado(); // 11
                case 9 -> viewCarreras.mostarCarrerasDeSede();
                case 10 -> viewCarreras.mostarCarrerasEspecDeSede();
                case 11 -> viewCarreras.crearUnaCarrera();
                default -> System.out.println("Opción invalida, intente de nuevo");
            }
        }

        s.close();


    }

    //Datos de prueba
    public static void cargarForms() throws ParseException {

        Control c = Control.getInstance();
        DTOFormulario dtoForm = c.getDtoForm();

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
        c.crearFormulario(dtoForm);

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

        c.crearFormulario(dtoForm);

        dtoForm.setEstado("RECHAZADO");
        dtoForm.setCodCarrera("IC");
        dtoForm.setCodSede("CA");
        dtoForm.setIdentificacion(101110111);
        dtoForm.setNombre("Michael Lopez");
        dtoForm.setFechaNacimiento("24/12/2003");
        dtoForm.setCorreo("jmlopez@gmail.com");
        dtoForm.setNumeroTelefono(65439009);
        dtoForm.setDireccion("Paraíso, Cartago");
        dtoForm.setInstitucion("CTP José Figueres Ferre");
        //dtoForm.setPuntajeObtenido(100);

        c.crearFormulario(dtoForm);

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

        c.crearFormulario(dtoForm);

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

        c.crearFormulario(dtoForm);
    }

    public static void main(String[] args) {
        // load datos
        try {
            cargarForms();
        } catch (ParseException e) {
            System.err.println("error cargando los datos ");
            System.exit(1);
        }

        //start program
        new ViewManager().mainMenu();
    }

}

//
//// se activa el DTO que provee el control
//        elDTO = Control.getInstance().getDto();
//                dtoForm = Control.getInstance().getDtoForm();
//
//
//                //Carga las carreras para tener unas de prueba
//                Control.getInstance().mostrarCarreras();
//                System.out.println("Todas las carreras\n" + elDTO.getLasCarreras());
//
//                System.out.println("********************************************************************************************\n");
//
//                cargarForms();
//
//                //Punto 7
//                Control.getInstance().simularPrueba();
//                //Control.getInstance().actualizarEstado();*/
//
//                //Punto 9
//                Control.getInstance().mostrarFormularios();
//                System.out.println("Solicitudes: \n" + dtoForm.getLosFormularios());
//
//                //Punto 10
//                Control.getInstance().verFormulariosFiltro("EN_ESPERA", true, "IC");
//                System.out.println("Solicitudes con filtro: \n" + dtoForm.getLosFormularios());
//
//                //Punto 11
//                Control.getInstance().verCantXEstado("EN_ESPERA");
//                System.out.println("Punto 11: \n" + dtoForm.getMap());
//
//                //Punto 12
//                Control.getInstance().verFormularioDetalle(0);
//                System.out.println("Formulario Detalle: \n" + dtoForm.getDetalleFormulario());