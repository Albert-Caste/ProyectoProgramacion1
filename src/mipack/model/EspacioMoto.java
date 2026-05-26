package mipack.model;

public class EspacioMoto extends Espacio{
    private String zona;
    public EspacioMoto(String codigo, String estado, Vehiculo vehiculoAsignado, String zona){
        super(codigo,estado,vehiculoAsignado);
        this.zona=zona;
    }
    public String getZona(){return zona;}
    public void setZona(String zona) {
        this.zona = zona;
    }
}
