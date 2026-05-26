package mipack.model;

public class Bicicleta extends Vehiculo{
    public Bicicleta(String placa, String nombreConductor, String identificacionConductor, String espacioAsignado) {
        super(placa, TipoVehiculo.BICICLETA, nombreConductor, identificacionConductor, espacioAsignado);
    }
}
