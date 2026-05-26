package mipack.model;

public class Empleado extends Persona{
    private String usuario;
    private String contrasena;

    public Empleado(String nombre, String cedula, String telefono,String usuario, String contrasena){
        super(nombre, cedula, telefono);
        this.usuario=usuario;
        this.contrasena=contrasena;
    }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}
