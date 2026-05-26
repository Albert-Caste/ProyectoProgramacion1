package mipack.controller;
import mipack.model.*;
import java.time.LocalDateTime;

public interface IFuncionOperador {

    void registrarIngresoVehiculo(Parqueadero parqueadero, String placa, String idEspacio, Cliente elCliente, Vehiculo elVehiculo);
    void registrarSalidaVehiculo(Parqueadero parqueadero,String placa, LocalDateTime horaSalida);
    void consultarEspaciosDisponibles(Parqueadero parqueadero);
}
