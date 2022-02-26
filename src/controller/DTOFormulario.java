package controller;

import java.util.Date;
import java.util.List;
import model.Formulario;

public class DTOFormulario {

    
    
    private String estado;
    private String codCarrera;
    //private int puntajeObtenido;  **No necesario creo
    private int identificacion;
    private String nombre;
    private String fechaNacimiento;
    private String correo;
    private int numeroTelefono;
    private String direccion;
    private String institucion;
    private List<Formulario> losFormularios;
    
    public DTOFormulario(){
    }
    
    
    //Contructor de la clase
    public DTOFormulario(String estado, String codCarrera, int identificacion, String nombre, String fechaNacimiento, String correo, int numeroTelefono, String direccion, String institucion) {
        this.estado = estado;
        this.codCarrera = codCarrera;
        //this.puntajeObtenido = puntajeObtenido;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.institucion = institucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    /*
    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }*/

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public List<Formulario> getLosFormularios() {
        return losFormularios;
    }

    public void setLosFormularios(List<Formulario> losFormularios) {
        this.losFormularios = losFormularios;
    }

}
