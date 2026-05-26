package co.edu.uniquindio.parquederojfx.controller;

import co.edu.uniquindio.parquederojfx.model.Parqueadero;
import co.edu.uniquindio.parquederojfx.model.Servicio;

import java.util.List;

public class ParqueaderoController {

    private Parqueadero parqueadero;

    public ParqueaderoController() {

        parqueadero = new Parqueadero(
                "ParquederoUQ",
                "123456"
        );
    }

    public List<Servicio> obtenerServicios(){

        return parqueadero.getListServicios();
    }

    public void iniciarServicio(String idCliente,
                                String placaVehiculo){

        System.out.println(
                "Servicio iniciado"
        );

        // AQUÍ luego agregarás:
        // crear servicio
        // agregar servicio a listServicios
    }
}