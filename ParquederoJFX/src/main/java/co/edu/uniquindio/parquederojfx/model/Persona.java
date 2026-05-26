package co.edu.uniquindio.parquederojfx.model;

public class Persona {
    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;

    public Persona(String nombre, String documento, String apellido, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void serDo() {

    }
}
