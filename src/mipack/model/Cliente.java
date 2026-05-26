package mipack.model;

public class Cliente extends Persona{
    private TipoUsuario tipoUsuario;
    public Cliente(String nombre, String cedula, String telefono, TipoUsuario tipoUsuario){
        super(nombre, cedula, telefono);
        this.tipoUsuario=tipoUsuario;
    }
    public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}
