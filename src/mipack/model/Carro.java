package mipack.model;

public class Carro extends Vehiculo {
    private TipoCarro tipoCarro;

    public Carro(String placa, String nombreConductor, String identificacionConductor, String espacioAsignado, TipoCarro tipoCarro) {
        super(placa, TipoVehiculo.CARRO, nombreConductor, identificacionConductor, espacioAsignado);
        this.tipoCarro = tipoCarro;
    }
    public TipoCarro getTipoCarro() { return tipoCarro; }
    public void setTipoCarro(TipoCarro tipoCarro) { this.tipoCarro = tipoCarro; }
}
