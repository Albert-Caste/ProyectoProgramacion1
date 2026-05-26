package mipack.model;

public class Moto extends Vehiculo{
    private Cilindraje cilindraje;

    public Moto(String placa, String nombreConductor, String identificacionConductor, String espacioAsignado, Cilindraje cilindraje){
        super(placa, TipoVehiculo.CARRO, nombreConductor, identificacionConductor, espacioAsignado);
        this.cilindraje=cilindraje;
    }

    public Cilindraje getCilindraje() { return cilindraje;}

    public void setCilindraje(Cilindraje cilindraje) { this.cilindraje = cilindraje; }
}
