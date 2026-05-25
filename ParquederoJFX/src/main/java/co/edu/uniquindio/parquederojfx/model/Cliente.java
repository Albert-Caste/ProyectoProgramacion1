package co.edu.uniquindio.parquederojfx.model;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private Usuario tipoUsuario;
    private List<Vehiculo> listVehiculosCliente;

    public Cliente (String nombre, String documento, String apellido, String telefono, Usuario tipoUsuario, List<Vehiculo> listVehiculosCliente) {
        super(nombre, documento, apellido, telefono);
        this.tipoUsuario = tipoUsuario;
        this.listVehiculosCliente = new ArrayList<>();
    }

    public void agregarVehiculoACliente(Vehiculo vehiculo) {
        listVehiculosCliente.add(vehiculo);
    }


    public Usuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Usuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Vehiculo> getListVehiculosCliente() {
        return listVehiculosCliente;
    }

    public void setListVehiculosCliente(List<Vehiculo> listVehiculosCliente) {
        this.listVehiculosCliente = listVehiculosCliente;
    }
}
