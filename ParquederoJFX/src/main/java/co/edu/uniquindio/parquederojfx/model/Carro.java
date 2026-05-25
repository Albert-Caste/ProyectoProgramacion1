package co.edu.uniquindio.parquederojfx.model;

public class Carro extends Vehiculo implements IServicioMensual {

    public final double AUMENTO_CARRO_CARGA = 0.2;
    public final double AUMENTO_CARRO_CAMIONETA = 0.1;



    private TipoCarro tipoCarro;

    public Carro (String placa, String color, TipoCarro tipoCarro) {
        super(placa,color);
        this.tipoCarro = tipoCarro;

    }


    /**
     * Metodo para calcular servicio por horas
     * @param parqueadero
     * @param horas
     * @param carroServicio
     * @param cliente
     * @return retorna el valor total del servicio incluyendo descuentos y aumentos
     */
    @Override
    public double calcularServicioHoras(Parqueadero parqueadero, int horas, Vehiculo carroServicio, Cliente cliente){
        double totalHoras = 0;
        Carro carro = (Carro) carroServicio;


        double tarifaHoras = parqueadero.getTheTarifa().getHoraMoto();

        if (carro.getTipoCarro() == TipoCarro.CARGA) {
            totalHoras = horas * tarifaHoras*(1+AUMENTO_CARRO_CARGA);

        } else if(carro.getTipoCarro() == TipoCarro.CAMIONETA){
            totalHoras = horas * tarifaHoras*(1+AUMENTO_CARRO_CAMIONETA);
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


    @Override
    public double calcularCostoTotalMensual(Parqueadero parqueadero, int meses, Vehiculo carroServicio, Cliente cliente){
        double totalMensual = 0;
        double tarifaMes = parqueadero.getTheTarifa().getMesMoto();
        Carro carro = (Carro) carroServicio;

        if (carro.getTipoCarro() == TipoCarro.CARGA) {
            totalMensual = meses * tarifaMes*(1+AUMENTO_CARRO_CARGA);

        } else if(carro.getTipoCarro() == TipoCarro.CAMIONETA){
            totalMensual = meses * tarifaMes*(1+AUMENTO_CARRO_CAMIONETA);
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





    //getter y setters



    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(TipoCarro tipoCarro) {
        this.tipoCarro = tipoCarro;
    }
}
