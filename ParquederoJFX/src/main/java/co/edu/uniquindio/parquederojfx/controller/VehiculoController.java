package co.edu.uniquindio.parquederojfx.controller;

import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.model.Carro;
import co.edu.uniquindio.parquederojfx.model.Parqueadero;
import co.edu.uniquindio.parquederojfx.model.Vehiculo;

import java.util.List;

public class VehiculoController {

    Parqueadero parqueadero =
            App.getParqueadero();

    public boolean crearVehiculo(
            Carro carro
    ){

        parqueadero.agregarCarro(
                carro.getPlaca(),
                carro.getColor(),
                carro.getTipoCarro()
        );

        return true;
    }

    public List<Vehiculo> obtenerVehiculos(){

        return parqueadero.getListVehiculos();
    }

    public boolean eliminarVehiculo(
            String placa
    ){

        Vehiculo vehiculoEliminar =
                null;

        for(Vehiculo vehiculo :
                parqueadero.getListVehiculos()){

            if(vehiculo.getPlaca()
                    .equals(placa)){

                vehiculoEliminar =
                        vehiculo;

                break;
            }
        }

        if(vehiculoEliminar != null){

            parqueadero
                    .getListVehiculos()
                    .remove(vehiculoEliminar);

            return true;
        }

        return false;
    }
}
