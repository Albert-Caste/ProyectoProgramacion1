package mipack.model;

import mipack.controller.IFuncionOperador;
import mipack.controller.Parqueadero;
import java.time.LocalDateTime;

public class Operador extends Empleado implements IFuncionOperador {
    public Operador(String nombre, String cedula, String telefono, String usuario, String contrasenia) {
        super(nombre,cedula,telefono,usuario, contrasenia);
    }

    @Override
    public void registrarIngresoVehiculo(Parqueadero parqueadero, String placa, String idEspacio, Cliente elCliente, Vehiculo elVehiculo) {
        boolean espacioEncontrado = false;

        for (Espacio ep : parqueadero.getListEspacios()) {
            if (ep.getCodigo().equals(idEspacio)) {
                espacioEncontrado = true;

                if (ep.getEstado().equals("DISPONIBLE")) {
                    ep.setVehiculoAsignado(elVehiculo);
                    ep.setEstado("OCUPADO");
                    System.out.println("Vehículo con placa " + elVehiculo.getPlaca() +
                            " ingresado con éxito en el espacio " + idEspacio + ".");
                    return;
                } else {
                    System.out.println("El espacio " + idEspacio + " ya se encuentra OCUPADO.");
                    return;
                }
            }
        }
        if (espacioEncontrado== false) {
            System.out.println("El espacio " + idEspacio + " no existe en el parqueadero.");
        }
    }

    @Override
    public void registrarSalidaVehiculo(Parqueadero parqueadero, String placa, LocalDateTime horaSalida) {

        for (Espacio ep : parqueadero.getListEspacios()) {
            if (ep.getEstado().equals("OCUPADO") && ep.getVehiculoAsignado() != null) {

                if (ep.getVehiculoAsignado().getPlaca().equals(placa)) {
                    Vehiculo v = ep.getVehiculoAsignado();

                    java.time.Duration duracion = java.time.Duration.between(v.getHoraIngreso(), horaSalida);

                    long horas = duracion.toHours();

                    if (horas == 0) {
                        horas = 1;
                    }
                    double precioPorHora = 0;

                    Tarifa tarifaActual = parqueadero.getTheTarifa();

                    if (ep instanceof EspacioCarro) {
                        precioPorHora = tarifaActual.getHoraCarro();
                    } else if (ep instanceof EspacioMoto) {
                        precioPorHora = tarifaActual.getHoraMoto();
                    } else if (ep instanceof EspacioBicicleta) {
                        precioPorHora = tarifaActual.getHoraBicicleta();
                    }
                    double valorAPagar = horas * precioPorHora;
                        ep.setVehiculoAsignado(null);
                        ep.setEstado("DISPONIBLE");

                    // Muestra informacion
                    System.out.println("\nFACTURA DE SALIDA");
                    System.out.println("Placa: " + placa);
                    System.out.println("Tiempo estacionado: " + horas + " hora(s)");
                    System.out.println("Total a pagar: $" + valorAPagar);
                    System.out.println("El espacio " + ep.getCodigo() + " ahora está DISPONIBLE.");
                    return;
                }
            }
        }
        System.out.println("No se encontró ningún vehículo con la placa '" + placa + "' en el sistema.");
    }

    @Override
    public void consultarEspaciosDisponibles(Parqueadero parqueadero) {
        System.out.println("\nESPACIOS DISPONIBLES");
        boolean espacioLibre= false;
        for (Espacio ep : parqueadero.getListEspacios()) {
            if (ep.getEstado().equals("DISPONIBLE")) {
                System.out.println("Espacio ID: " + ep.getCodigo());
                espacioLibre= true;
            }
        }
        if (espacioLibre== false) {
            System.out.println("No hay espacios libres en este momento.");
        }
    }

}

