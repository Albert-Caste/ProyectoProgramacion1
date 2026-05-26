package mipack.model;

public abstract class Espacio {
    private String codigo;
    private String estado;
    private Vehiculo vehiculoAsignado;

    public Espacio (String codigo, String estado, Vehiculo vehiculoAsignado){
        this.codigo=codigo;
        this.estado=estado;
        this.vehiculoAsignado=null;
    }

    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

    public Vehiculo getVehiculoAsignado() {return vehiculoAsignado;}
    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) {this.vehiculoAsignado = vehiculoAsignado;}
}
