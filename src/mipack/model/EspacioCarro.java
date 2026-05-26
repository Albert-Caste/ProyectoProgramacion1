package mipack.model;

public class EspacioCarro extends Espacio{
    private int piso;

    public EspacioCarro(String codigo, String estado, Vehiculo vehiculoAsignado, int piso){
        super(codigo,estado,vehiculoAsignado);
        this.piso=piso;
    }

    public int getPiso() { return piso; }

    public void setPiso(int piso) {this.piso = piso;}
}
