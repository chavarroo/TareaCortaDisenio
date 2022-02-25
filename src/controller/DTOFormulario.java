package controller;

public class DTOFormulario {

    private String nombre;
    private String correo;
    private String direccion;
    private String codigoSede;
    private int identificacion;
    private int numeroTelefono;

    public DTOFormulario(String nombre, String correo, String direccion, String codigoSede, int identificacion, int numeroTelefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.codigoSede = codigoSede;
        this.identificacion = identificacion;
        this.numeroTelefono = numeroTelefono;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
