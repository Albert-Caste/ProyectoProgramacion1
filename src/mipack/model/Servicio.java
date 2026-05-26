package mipack.model;

import java.time.LocalDateTime;

public class Servicio {
    private Cliente theCliente;
    private Vehiculo theVehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private double totalServicio;
    private Facturacion theFacturacion;

    public Servicio(Cliente theCliente, Vehiculo theVehiculo, LocalDateTime horaEntrada) {
        this.theCliente = theCliente;
        this.theVehiculo = theVehiculo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = null;
        this.totalServicio = 0.0;
        this.theFacturacion = null;
    }

    public Cliente getTheCliente() { return theCliente; }
    public void setTheCliente(Cliente theCliente) { this.theCliente = theCliente; }

    public Vehiculo getTheVehiculo() { return theVehiculo; }
    public void setTheVehiculo(Vehiculo theVehiculo) { this.theVehiculo = theVehiculo; }

    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalDateTime horaEntrada) { this.horaEntrada = horaEntrada; }

    public LocalDateTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalDateTime horaSalida) { this.horaSalida = horaSalida; }

    public double getTotalServicio() { return totalServicio; }
    public void setTotalServicio(double totalServicio) { this.totalServicio = totalServicio; }

    public Facturacion getTheFacturacion() { return theFacturacion; }
    public void setTheFacturacion(Facturacion theFacturacion) { this.theFacturacion = theFacturacion; }
}
