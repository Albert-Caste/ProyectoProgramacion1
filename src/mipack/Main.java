package mipack;
import mipack.model.*;
import mipack.controller.*;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Tarifa tarifaInicial = new Tarifa(3500, 2000, 1000, 60000, 40000, 40000, 20, 90000, 60000);
        Parqueadero parqueadero = new Parqueadero("Parqueo La UQ", "900123456", tarifaInicial);

        parqueadero.getListEspacios().add(new EspacioCarro("C1", "DISPONIBLE", null, 1));
        parqueadero.getListEspacios().add(new EspacioMoto("M1", "DISPONIBLE", null, "A"));
        parqueadero.getListEspacios().add(new EspacioBicicleta("B1", "DISPONIBLE", null, 1));

        Admin admin = new Admin("Alberto", "123456", "7412345", "AlbertUQ", "micontra");
        Operador operador = new Operador("Luis", "213456", "7424567", "LuisUQ", "hola");

        String[] opciones = {"ADMINISTRADOR", "OPERADOR", "SALIR"};
        int selecOpcion = 0;
        do {
            selecOpcion = JOptionPane.showOptionDialog(
                    null,
                    "Bienvenido a " + parqueadero.getNombre() + "\n Favor seleccione una opcion:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (selecOpcion) {
                case 0: // Pulsó ADMINISTRADOR
                    menuAdmin(parqueadero, admin);
                    break;
                case 1: // Pulsó OPERADOR
                    menuOperador(parqueadero, operador);
                    break;
                case 2:
                case -1:
                    JOptionPane.showMessageDialog(null, "Saliendo...", "Cerrando...", JOptionPane.INFORMATION_MESSAGE);
                    selecOpcion = 2;
                    break;
            }
        } while (selecOpcion != 2);
    }

    private static void menuAdmin(Parqueadero parqueadero, Admin admin) {
        String[] opcionesAdmin = {"Modificar Tarifas", "Agregar Espacio", "Volver"};
        int seleccion;

        do {
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Favor selecione una opcion",
                    "ADMINISTRACION",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcionesAdmin,
                    opcionesAdmin[0]

            );
            switch (seleccion) {
                case 0: // Modificar Tarifas
                    try {
                        double vCarro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese NUEVA tarifa / hora para CARROS:"));
                        double vMoto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese NUEVA tarifa / hora para MOTOS:"));
                        double vBici = Double.parseDouble(JOptionPane.showInputDialog("Ingrese NUEVA tarifa / hora para BICICLETAS:"));

                        // Creamos el objeto Tarifa con tus 9 parámetros usando proporciones lógicas
                        Tarifa nueva = new Tarifa(
                                vCarro, vMoto, vBici,
                                vCarro * 10, vMoto * 10,  // Estimado día
                                vCarro * 6, vMoto * 6,    // Estimado noche
                                vCarro * 30, vMoto * 30   // Estimado mes
                        );

                        admin.modificarTarifas(parqueadero, nueva);
                        JOptionPane.showMessageDialog(null, "Tarifas actualizadas!.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese valores válidos.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 1: // Agregar Espacio
                    String[] tipos = {"Carro", "Moto", "Bicicleta"};
                    int t = JOptionPane.showOptionDialog(null, "Seleccione el tipo de espacio:", "Nuevo Espacio", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

                    if (t != -1) {
                        String codigo = JOptionPane.showInputDialog("Ingrese el código único de la celda (Ej: C3, M2):");
                        if (codigo != null && !codigo.trim().isEmpty()) {
                            Espacio nuevoEspacio = null;

                            if (t == 0) { // Creación de Carro pide Piso
                                try {
                                    int piso = Integer.parseInt(JOptionPane.showInputDialog("¿En qué piso estará ubicado el carro?"));
                                    nuevoEspacio = new EspacioCarro(codigo, "DISPONIBLE", null, piso);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Piso inválido. Asignado piso 1 por defecto.");
                                    nuevoEspacio = new EspacioCarro(codigo, "DISPONIBLE", null, 1);
                                }
                            } else if (t == 1) { // Creación de Moto pide Zona
                                String zona = JOptionPane.showInputDialog("¿A qué ZONA pertenece esta celda de moto? (Ej: A, B):");
                                if (zona == null || zona.trim().isEmpty()) zona = "A";
                                nuevoEspacio = new EspacioMoto(codigo, "DISPONIBLE", null, zona);
                            } else if (t == 2) {
                                nuevoEspacio = new EspacioBicicleta(codigo, "DISPONIBLE", null, 1);
                            }

                            if (nuevoEspacio != null) {
                                admin.agregarEspacioParqueadero(parqueadero, nuevoEspacio);
                                JOptionPane.showMessageDialog(null, "✅ Celda [" + codigo + "] agregada con éxito.");
                            }
                        }
                    }
                    break;
            }
        } while (seleccion != 2 && seleccion != -1);
    }

    private static void menuOperador(Parqueadero parqueadero, Operador operador) {
        String[] opcionesOperador = {"Registrar Ingreso", "Registrar Salida", "Consultar Espacios", "Volver"};
        int seleccion;

        do {
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Menú: OPERADOR\n¿Qué acción desea realizar?",
                    "OPERADOR",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcionesOperador,
                    opcionesOperador[0]
            );
            switch (seleccion) {
                case 0: // Registrar Ingreso
                    String placaIngreso = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
                    if (placaIngreso != null && !placaIngreso.trim().isEmpty()) {

                        String nombreConductor = JOptionPane.showInputDialog("Ingrese el NOMBRE del conductor:");
                        String cedulaConductor = JOptionPane.showInputDialog("Ingrese la CÉDULA del conductor:");
                        String espacioAsignado = JOptionPane.showInputDialog("Ingrese el código de la CELDA asignada (Ej: C1, M1):");

                        String[] tipoV = {"Carro", "Moto", "Bicicleta"};
                        int selTipo = JOptionPane.showOptionDialog(null, "Seleccione tipo de vehículo:", "Ingreso",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipoV, tipoV[0]);

                        Vehiculo v = null;

                        if (selTipo == 0) {
                            v = new Carro(placaIngreso, nombreConductor, cedulaConductor, espacioAsignado, TipoCarro.SEDAN);
                        }
                        else if (selTipo == 1) {

                            v = new Moto(placaIngreso, nombreConductor, cedulaConductor, espacioAsignado, Cilindraje.BAJO);
                        }
                        else if (selTipo == 2) {

                            v = new Bicicleta(placaIngreso, nombreConductor, cedulaConductor, espacioAsignado);
                        }

                        if (v != null) {
                            Cliente elCliente = new Cliente(cedulaConductor, nombreConductor, "", TipoUsuario.ESTUDIANTE);
                            operador.registrarIngresoVehiculo(parqueadero, placaIngreso, espacioAsignado, elCliente,v );
                            JOptionPane.showMessageDialog(null, "✅ Proceso de ingreso ejecutado. Revisa la consola inferior.");
                        }
                    }
                    break;
                case 1: // Registrar Salida
                    String placaSalida = JOptionPane.showInputDialog("Ingrese la placa del vehículo que sale:");
                    if (placaSalida != null && !placaSalida.trim().isEmpty()) {
                        operador.registrarSalidaVehiculo(parqueadero, placaSalida, LocalDateTime.now());
                        JOptionPane.showMessageDialog(null, "Proceso de salida ejecutado. Cobro impreso en consola.");
                    }
                    break;

                case 2: // Consultar Espacios
                    operador.consultarEspaciosDisponibles(parqueadero);
                    JOptionPane.showMessageDialog(null, "📋 Estado impreso en la consola inferior.");
                    break;
            }
        } while (seleccion != 3 && seleccion != -1);
    }
}

