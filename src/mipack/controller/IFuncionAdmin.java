package mipack.controller;
import mipack.model.*;
public interface IFuncionAdmin {
    public void agregarEspacioParqueadero(Parqueadero parqueadero, Espacio nuevoEspacio);
    void agregarEspacioCarro(Parqueadero parqueadero,String codigoEspacio, int piso);

    void agregarEspacioMoto(Parqueadero parqueadero, String codigoEspacio, String zona);

    void agregarEspacioBicicleta(Parqueadero parqueadero, String codigoEspacio, int numParrilla);

    void modificarTarifas(Parqueadero parqueadero, Tarifa nuevaTarifa);
}

