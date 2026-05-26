package mipack.controller;
import java.util.List;
import java.util.ArrayList;
import mipack.model.*;

public class Parqueadero {
    private String nombre;
    private String nit;
    private Tarifa theTarifa;
    private List<Vehiculo> listVehiculos;
    private List<Espacio> listEspacios;
    private List<Persona> listPersonas;
    private List<Servicio> listServicios;
    private List<Facturacion> listFacturaciones;

    public Parqueadero(String nombre, String nit, Tarifa theTarifa) {
        this.nombre = nombre;
        this.nit = nit;
        this.theTarifa = theTarifa;
        this.listVehiculos = new ArrayList<>();
        this.listEspacios = new ArrayList<>();
        this.listPersonas = new ArrayList<>();
        this.listServicios = new ArrayList<>();
        this.listFacturaciones = new ArrayList<>();}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public Tarifa getTheTarifa() { return theTarifa; }
    public void setTheTarifa(Tarifa theTarifa) { this.theTarifa = theTarifa; }

    public List<Vehiculo> getListVehiculos() { return listVehiculos; }
    public void setListVehiculos(List<Vehiculo> listVehiculos) { this.listVehiculos = listVehiculos; }

    public List<Espacio> getListEspacios() { return listEspacios; }
    public void setListEspacios(List<Espacio> listEspacios) { this.listEspacios = listEspacios; }

    public List<Persona> getListPersonas() { return listPersonas; }
    public void setListPersonas(List<Persona> listPersonas) { this.listPersonas = listPersonas; }

    public List<Servicio> getListServicios() { return listServicios; }
    public void setListServicios(List<Servicio> listServicios) { this.listServicios = listServicios; }

    public List<Facturacion> getListFacturaciones() { return listFacturaciones; }
    public void setListFacturaciones(List<Facturacion> listFacturaciones) { this.listFacturaciones = listFacturaciones; }

}
