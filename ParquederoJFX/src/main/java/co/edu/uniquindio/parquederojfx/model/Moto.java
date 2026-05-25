package co.edu.uniquindio.parquederojfx.model;

public class Moto extends Vehiculo implements  IServicioMensual{
    public final double AUMENTOALTOCILIDRAJE = 0.05;


    private Cilindraje cilindraje;

    public Moto (String placa, String color, Cilindraje cilindraje){
        super(placa,color);
        this.cilindraje = cilindraje;
    }

    /**
     * Metodo para hallar el costo total de un servicio
     * @param parqueadero para incluir las tarifas del parqueadero
     * @param meses meses que se presta el servicio
     * @param motoServicio para conocer el tipo de cilidraje
     * @param cliente extraer el tipo de cliente
     * @return retorna el costo total de
     */


    @Override
    public double calcularCostoTotalMensual(Parqueadero parqueadero, int meses, Vehiculo motoServicio, Cliente cliente){
        double totalMensual = 0;
        double tarifaMes = parqueadero.getTheTarifa().getMesMoto();
        Moto moto = (Moto) motoServicio;

        if (moto.getCilindraje() == Cilindraje.ALTO){
            totalMensual = meses * tarifaMes*(1+AUMENTOALTOCILIDRAJE);

        } else {
            totalMensual = meses * tarifaMes;
        }

        if (cliente.getTipoUsuario() == Usuario.ESTUDIANTE){
            totalMensual = totalMensual*(1-DESCUENTO_ESTUDIANTE);
        }

        if (cliente.getTipoUsuario() == Usuario.DOCENTE){
            totalMensual = totalMensual*(1-DESCUENTO_DOCENTE);
        }

        if (cliente.getTipoUsuario() == Usuario.ADMINISTRATIVO){
            totalMensual = totalMensual*(1-DESCUENTO_ADMINISTRATIVO);
        }


        return totalMensual;
    }

    /**
     * Metodo para calcula el servicio por horas de una moto
     * @param parqueadero
     * @param horas
     * @param moto
     * @param cliente
     * @return retorna el costo del servicio por un numero de horas
     *
     */
    @Override
    public double calcularServicioHoras(Parqueadero parqueadero, int horas, Vehiculo moto, Cliente cliente){
        double totalHoras = 0;
        Moto motoServicio = (Moto) moto;


        double tarifaHoras = parqueadero.getTheTarifa().getHoraMoto();

        if (motoServicio.getCilindraje() == Cilindraje.ALTO){
            totalHoras = horas * tarifaHoras*(1+AUMENTOALTOCILIDRAJE);

        } else {
            totalHoras = horas * tarifaHoras;
        }

        if (cliente.getTipoUsuario() == Usuario.ESTUDIANTE){
            totalHoras = totalHoras*(1-DESCUENTO_ESTUDIANTE);
        }

        if (cliente.getTipoUsuario() == Usuario.DOCENTE){
            totalHoras = totalHoras*(1-DESCUENTO_DOCENTE);
        }

        if (cliente.getTipoUsuario() == Usuario.ADMINISTRATIVO){
            totalHoras = totalHoras*(1-DESCUENTO_ADMINISTRATIVO);
        }

        return totalHoras;

    }


    //getters and setters


    public Cilindraje getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Cilindraje cilindraje) {
        this.cilindraje = cilindraje;
    }
}
