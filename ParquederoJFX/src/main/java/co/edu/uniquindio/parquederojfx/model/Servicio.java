package co.edu.uniquindio.parquederojfx.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Servicio {
    private Cliente theCliente;
    private Vehiculo theVehiculo;
    private LocalDate fecha;

    private LocalDateTime horaEntrada;
    private LocalDateTime horSalida;
    private double totalServicio;
    private Facturacion theFacturacion;


    public Servicio(Cliente theCliente, Vehiculo theVehiculo, LocalDate fecha, LocalDateTime horaEntrada) {
        this.theCliente = theCliente;
        this.theVehiculo = theVehiculo;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
    }




    public Cliente getTheCliente() {
        return theCliente;
    }

    public void setTheCliente(Cliente theCliente) {
        this.theCliente = theCliente;
    }

    public Vehiculo getTheVehiculo() {
        return theVehiculo;
    }

    public void setTheVehiculo(Vehiculo theVehiculo) {
        this.theVehiculo = theVehiculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHorSalida() {
        return horSalida;
    }

    public void setHorSalida(LocalDateTime horSalida) {
        this.horSalida = horSalida;
    }

    public double getTotalServicio() {
        return totalServicio;
    }

    public void setTotalServicio(double totalServicio) {
        this.totalServicio = totalServicio;
    }

    public Facturacion getTheFacturacion() {
        return theFacturacion;
    }

    public void setTheFacturacion(Facturacion theFacturacion) {
        this.theFacturacion = theFacturacion;
    }
}
