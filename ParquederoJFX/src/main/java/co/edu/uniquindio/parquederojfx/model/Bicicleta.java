package co.edu.uniquindio.parquederojfx.model;

public class Bicicleta extends Vehiculo {
    public final double DESCUENTO_ESTUDIANTE = 0.5;
    public final double DESCUENTO_DOCENTE = 0.4;
    public final double DESCUENTO_ADMINISTRATIVO = 0.3;




    public Bicicleta (String placa, String color) {
        super(placa, color);


    }

    @Override
    public double calcularServicioHoras(Parqueadero parqueadero, int horas, Vehiculo bici, Cliente cliente){
        double totalServicioHoras = 0;



        double tarifaHoras = parqueadero.getTheTarifa().getHoraBicicleta();

        totalServicioHoras = tarifaHoras * horas;



        if (cliente.getTipoUsuario() == Usuario.ESTUDIANTE){
            totalServicioHoras = totalServicioHoras*(1-DESCUENTO_ESTUDIANTE);
        }

        if (cliente.getTipoUsuario() == Usuario.DOCENTE){
            totalServicioHoras = totalServicioHoras*(1-DESCUENTO_DOCENTE);
        }

        if (cliente.getTipoUsuario() == Usuario.ADMINISTRATIVO){
            totalServicioHoras = totalServicioHoras*(1-DESCUENTO_ADMINISTRATIVO);
        }

        return totalServicioHoras;

    }




}
