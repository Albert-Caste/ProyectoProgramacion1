package mipack.model;
import mipack.controller.IFuncionAdmin;
import mipack.controller.IFuncionOperador;
import mipack.controller.Parqueadero;

import java.time.LocalDateTime;

public class Admin extends Empleado implements IFuncionAdmin, IFuncionOperador {
    public Admin(String nombre, String cedula, String telefono,String usuario, String contrasena){
        super(nombre, cedula, telefono, usuario, contrasena);
    }

    @Override
    public void agregarEspacioParqueadero(Parqueadero parqueadero, Espacio nuevoEspacio) {
        // El Admin toma la lista del parqueadero y le añade el nuevo espacio (sea el hijo que sea)
        parqueadero.getListEspacios().add(nuevoEspacio);
        System.out.println("Se ha creado el spacio " + nuevoEspacio.getCodigo());
    }
    @Override
    public void agregarEspacioCarro(Parqueadero parqueadero,String codigoEspacio, int piso){
        EspacioCarro nuevoEspacio = new EspacioCarro(codigoEspacio, "DISPONIBLE", null,piso);
        parqueadero.getListEspacios().add(nuevoEspacio);
        System.out.println("Espacio de carro " + codigoEspacio + " agregado con éxito en el piso " + piso + ".");
    }
    @Override
    public void agregarEspacioMoto(Parqueadero parqueadero, String codigoEspacio, String zona) {
        EspacioMoto nuevoEspacio = new EspacioMoto(codigoEspacio, "DISPONIBLE",null, zona);
        parqueadero.getListEspacios().add(nuevoEspacio);
        System.out.println("Espacio de moto " + codigoEspacio + " agregado con éxito en la " + zona + ".");
    }
    @Override
    public void agregarEspacioBicicleta(Parqueadero parqueadero, String codigoEspacio, int numParrilla) {
        EspacioBicicleta nuevoEspacio = new EspacioBicicleta(codigoEspacio, "DISPONIBLE",null, numParrilla);
        parqueadero.getListEspacios().add(nuevoEspacio);
        System.out.println("Espacio de bicicleta " + codigoEspacio + " agregado con el número de parrilla " + numParrilla + ".");}
    @Override
    public void modificarTarifas(Parqueadero parqueadero, Tarifa nuevaTarifa) {
        parqueadero.setTheTarifa(nuevaTarifa);
        System.out.println("La tarifa del parqueadero ha sido actualizada correctamente.");
    }
    public boolean validarEspacio(Parqueadero parqueadero, String idEspacio) {
        boolean valida = false;
        for (Espacio ep : parqueadero.getListEspacios()) {
            if (ep.getCodigo().equals(idEspacio)) {
                valida = true;
                break;
            }
        }
        return valida;
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
