package co.edu.uniquindio.parquederojfx.model;

public interface IServicioMensual {
    public final double DESCUENTO_ESTUDIANTE = 0.5;
    public final double DESCUENTO_DOCENTE = 0.4;
    public final double DESCUENTO_ADMINISTRATIVO = 0.3;


    public double calcularCostoTotalMensual(Parqueadero parqueadero, int horas, Vehiculo vehiculo, Cliente cliente);
}
