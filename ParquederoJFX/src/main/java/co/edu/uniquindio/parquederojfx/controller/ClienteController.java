package co.edu.uniquindio.parquederojfx.controller;

import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.model.Cliente;
import co.edu.uniquindio.parquederojfx.model.Parqueadero;
import co.edu.uniquindio.parquederojfx.model.Persona;
import co.edu.uniquindio.parquederojfx.model.Usuario;
import javafx.scene.control.ComboBox;

import java.nio.channels.ClosedByInterruptException;
import java.util.List;

public class ClienteController {

    Parqueadero atrubutosApp = App.getParqueadero();



    public ClienteController() {

    }




    public boolean crearCliente(String nombre, String documento, String apellido, String telefono, Usuario tipoUsuario) {
        System.out.println("Cliente registrado");
        return atrubutosApp.agregarCliente(nombre, documento, apellido, telefono, tipoUsuario);


    }

    public boolean crearClienteSinAtributos(Cliente cliente){
        return atrubutosApp.agregarClienteSinAtributos(cliente);



    }

    public List<Persona> obtenerListaClientes() {
        return atrubutosApp.getListPersonas();
    }

    public boolean eliminarCliente(String cedula) {
        System.out.println("Cliente Eliminado");
        return atrubutosApp.eliminarCliente(cedula);
    }

    public boolean actualizarCliente(String cedula, Cliente nuevoCliente) {
        System.out.println("Cliente Eliminado");
        return atrubutosApp.eliminarCliente(cedula);
    }

    public void registrarCliente(){

        System.out.println(
                "Cliente registrado"
        );
    }



}