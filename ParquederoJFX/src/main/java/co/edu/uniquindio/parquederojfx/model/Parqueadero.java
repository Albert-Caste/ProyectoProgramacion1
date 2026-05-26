package co.edu.uniquindio.parquederojfx.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

    private String nombre;
    private String nit;
    private Tarifa theTarifa;


    private List<Vehiculo> listVehiculos;
    private List<Espacio> listEspacios;
    private List<Persona> listPersonas;
    private List<Servicio> listServicios;
    private List<Facturacion> listFacturaciones;


    public Parqueadero(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;


        this.listVehiculos = new ArrayList<>();
        this.listEspacios = new ArrayList<>();
        this.listPersonas = new ArrayList<>();
        this.listServicios = new ArrayList<>();
        this.listFacturaciones = new ArrayList<>();

    }

//CRUD  Persona

    /**
     * Metodo para buscar persona por tipo de documentto y validar su existencia
     * @param idPersona
     * @return boolean
     */

    public boolean validarPersona(String idPersona) {
        boolean bandera = false;

        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(idPersona)) {
                bandera = true;
                break;
            }

        }
        return  bandera;
    }

    /**
     * Metodo para buscar una persona en la lista de persona dado el documento
     * @param id
     * @return
     */

    public Persona buscarPersona(String id) {
        Persona personaBuscada = null;
        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(id)) {
                personaBuscada =  ps;
                break;
            }
        }

        if (personaBuscada == null) {
            JOptionPane.showMessageDialog(null, " no existe en el sistema.");
        }
        return personaBuscada;
    }


    /**
     * CRUD CLIENTE
     */


    /**
     * Metodo mara buscar cliente y validar su existencia
     * @param idCliente
     * @return boolean
     */

    public boolean validarCliente(String idCliente) {
        boolean bandera = false;

        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(idCliente) && ps instanceof Cliente ) {
                bandera = true;
                break;

            }
        }
        return bandera;
    }


    /**
     * Metodo para buscar un objeto tipo cliente
     * @param idCliente
     * @return un objeto cliente
     */

    public Cliente buscarCliente(String idCliente) {
        Cliente clienteBuscado = null;
        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(idCliente) && ps instanceof Cliente ) {
                clienteBuscado = (Cliente) ps;
                break;
            }
        }

        if (clienteBuscado == null) {
            JOptionPane.showMessageDialog(null, " no existe en el sistema.");
        }
        return clienteBuscado;
    }

    /**
     * Metodo para agregar persona a la lista de clientes
     *
     * @param nombre      del cliente
     * @param documento   del cliente
     * @param apellido    del cliente
     * @param telefono    del cliente
     * @param tipoUsuario del cliente
     * @return
     */

    public boolean agregarCliente(String nombre, String documento, String apellido, String telefono, Usuario tipoUsuario) {
        Cliente nuevoCliente = null;
        List <Vehiculo> listVehiculosCliente = new ArrayList<>();

        if(validarCliente(documento)) {
            JOptionPane.showMessageDialog(null, "El cliente existe en el sistema.");

        } else {
            nuevoCliente = new Cliente(nombre, documento, apellido, telefono, tipoUsuario);
            listPersonas.add(nuevoCliente);

            JOptionPane.showMessageDialog(null, "Se registró " + nombre);
            return true;
        }

        return false;
    }

    public boolean agregarClienteSinAtributos(Cliente cliente) {

        listPersonas.add(cliente);
        return true;

    }


    public boolean actualizarCliente(String documento, Cliente clienteActualizado){
        boolean bandera = false;
        Cliente clienteViejo = null;
        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(documento)) {
                clienteViejo = (Cliente) ps;

                clienteViejo.setNombre(clienteActualizado.getNombre());
                clienteViejo.setApellido(clienteActualizado.getApellido());
                clienteViejo.setApellido(clienteActualizado.getApellido());
                clienteViejo.setTelefono(clienteActualizado.getTelefono());
                clienteViejo.setTipoUsuario(clienteActualizado.getTipoUsuario());
                bandera =true;
                System.out.println("Cliente Actualizado");
                break;


            }

        }
        return bandera;
    }

    /**
     * Metodo para eliminar Cliente
     *
     * @param documento
     * @return
     */


    public boolean eliminarCliente(String documento) {

        if(!validarCliente(documento)) {

            JOptionPane.showMessageDialog(
                    null,
                    "El cliente no existe en el sistema."
            );

        } else {

            Cliente clienteABorrar =
                    buscarCliente(documento);

            listPersonas.remove(clienteABorrar);

            JOptionPane.showMessageDialog(
                    null,
                    "Se eliminó " + clienteABorrar.getNombre()
            );

            return true;
        }

        return false;
    }

    /**
     * Metodo para validar la existencia de un operador en la lista de Personas
     * @param idOperador
     * @return
     */
    public boolean validarOperador(String idOperador) {
        boolean bandera = false;

        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(idOperador) && ps instanceof Operador ) {
                bandera = true;
                break;

            }
        }
        return bandera;
    }


    /**
     * Metodo para validar la existencia de una Administrador en la lista de personas
     * @param idAdministrador
     * @return
     */
    public boolean validarAdministrador(String idAdministrador) {
        boolean bandera = false;

        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(idAdministrador) && ps instanceof Administrador ) {
                bandera = true;
                break;

            }
        }
        return bandera;
    }

    /**
     * Metodo para agragar un nuevo operador al parqueadero
     * @param nombre
     * @param documento
     * @param apellido
     * @param telefono
     * @param codigoEmpleado
     */


    public void agregarOperador(String nombre, String documento, String apellido, String telefono, String codigoEmpleado) {
        Operador nuevoOperador= null;

        if(validarCliente(documento)) {
            JOptionPane.showMessageDialog(null, "El Operador existe en el sistema.");
        } else {
            nuevoOperador = new Operador (nombre, documento, apellido, telefono, codigoEmpleado);
            listPersonas.add(nuevoOperador);

            JOptionPane.showMessageDialog(null, "Se registró " + nombre);
        }

    }


    /**
     * Metodo para agregar un nuevo administrador a parquedero
     * @param nombre
     * @param documento
     * @param apellido
     * @param telefono
     * @param codigoEmpleado
     */

    public void agregarAdministrador(String nombre, String documento, String apellido, String telefono, String codigoEmpleado) {
        Administrador nuevoAdministrador= null;

        if(validarAdministrador(documento)) {
            JOptionPane.showMessageDialog(null, "El Operador existe en el sistema.");
        } else {
            nuevoAdministrador = new Administrador (nombre, documento, apellido, telefono, codigoEmpleado);
            listPersonas.add(nuevoAdministrador);

            JOptionPane.showMessageDialog(null, "Se registró " + nombre);
        }

    }

    /**
     * Metodo para buscar Operador en la lista de personas dado su documento
     * @param idTrabajador
     * @return
     */
    public Operador buscarOperador(String idTrabajador) {
        Operador operadorBuscado = null;
        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(idTrabajador) && ps instanceof Operador ) {
                operadorBuscado = (Operador) ps;
                break;
            }
        }

        if (operadorBuscado == null) {
            JOptionPane.showMessageDialog(null, " no existe en el sistema.");
        }
        return operadorBuscado;
    }

    /**
     * Metodo para buscar administrador en la lista de personas, dado su documento
     * @param idAdmin documento del administrador
     * @return
     */

    public Administrador buscarAdministrador(String idAdmin) {
        Administrador adminBuscado = null;
        for (Persona ps : listPersonas) {
            if (ps.getDocumento().equals(idAdmin) && ps instanceof Administrador ) {
                adminBuscado = (Administrador) ps;
                break;
            }
        }

        if (adminBuscado == null) {
            JOptionPane.showMessageDialog(null, " no existe en el sistema.");
        }
        return adminBuscado;
    }


    /**
     * CRUD VEHICULO

     /**
     * Metodo para validar existencia de moto usando su placa
     * @param placa
     * @return booleano
     */

    public boolean validarMoto(String placa) {
        boolean bandera = false;
        for(Vehiculo v : listVehiculos) {
            if(v.getPlaca().equals(placa) && v instanceof Moto) {
                bandera = true;
            }
        }
        return bandera;
    }

    /**
     * Metodo para validar existencia de carro usando su placa
     * @param placa
     * @return booleano
     */

    public boolean validarCarro(String placa) {
        boolean bandera = false;
        for(Vehiculo v : listVehiculos) {
            if(v.getPlaca().equals(placa) && v instanceof Carro) {
                bandera = true;
            }
        }
        return bandera;
    }

    /**
     * Metodo para validar existencia de bicicleta usando su placa
     * @param placa
     * @return booleano
     */

    public boolean validarBicicleta(String placa) {
        boolean bandera = false;
        for(Vehiculo v : listVehiculos) {
            if(v.getPlaca().equals(placa) && v instanceof Bicicleta ) {
                bandera = true;
            }
        }

        return bandera;
    }

    /**
     * Metodo para buscar moto por su placa
     * @param placa
     * @return
     */

    public Moto buscarMoto(String placa) {
        Moto motoBuscada = null;
        for (Vehiculo mt : listVehiculos) {
            if (mt.getPlaca().equals(placa) && mt instanceof Moto ) {
                motoBuscada  = (Moto) mt;
                break;
            }
        }

        if (motoBuscada == null) {
            JOptionPane.showMessageDialog(null, "la moto no existe en el sistema.");
        }

        return motoBuscada;
    }

    /**
     * Metodo para busacar carro usando la placa
     * @param placa
     * @return objeto carro
     */

    public Carro buscarCarro(String placa) {
        Carro carroBuscada = null;

        for (Vehiculo cr : listVehiculos) {
            if (cr.getPlaca().equals(placa) && cr instanceof Carro ) {
                carroBuscada = (Carro) cr;
                break;
            }
        }

        if (carroBuscada == null) {

            JOptionPane.showMessageDialog(null, "el carro no existe en el sistema.");
        }

        return carroBuscada;
    }

    /**
     * Metodo para busacar bicicleta usando la placa
     * @param placa
     * @return objeto carro
     */

    public Bicicleta buscarBicicleta(String placa) {
        Bicicleta biciBuscada = null;

        for (Vehiculo bc : listVehiculos) {
            if (bc.getPlaca().equals(placa) && bc instanceof Bicicleta ) {
                biciBuscada = (Bicicleta) bc;
                break;
            }
        }

        if (biciBuscada == null) {

            JOptionPane.showMessageDialog(null, "la bicicleta  no existe en el sistema.");
        }

        return biciBuscada;
    }

    /**
     * Metodo para agregar moto al la lista de vehiculos
     * @param placa
     * @param color
     * @param tipoCarro
     */


    public void agregarCarro(String placa, String color,TipoCarro tipoCarro) {
        Carro  nuevoCarro = null;


        if(validarCarro(placa)) {
            JOptionPane.showMessageDialog(null, "El Carro ya existe en el sistema.");
        } else {
            nuevoCarro = new Carro(nombre, color, tipoCarro);
            listVehiculos.add(nuevoCarro);

            JOptionPane.showMessageDialog(null, "Se registró " + placa);
        }

    }

    /**
     * Metodo para agregar moto al la lista de vehiculos
     * @param placa
     * @param color
     * @param cilindraje
     */


    public void agregarMoto(String placa, String color,Cilindraje cilindraje) {
        Moto  nuevaMoto = null;


        if(validarCarro(placa)) {
            JOptionPane.showMessageDialog(null, "La Moto  ya existe en el sistema.");
        } else {
            nuevaMoto = new Moto(nombre, color, cilindraje);
            listVehiculos.add(nuevaMoto);

            JOptionPane.showMessageDialog(null, "Se registró " + placa);
        }

    }

    /**
     * Programa para agregar una bicicleta a la lista de vehiculos
     * @param placa
     * @param color
     */


    public void agregarBicicleta(String placa, String color){
        Bicicleta nuevaBicicleta = null;

        if (validarBicicleta(placa)){
            JOptionPane.showMessageDialog(null, "La Bicicleta ya exixte en el sistema. ");
        } else {
            nuevaBicicleta = new Bicicleta(placa, color);
            listVehiculos.add(nuevaBicicleta);
            JOptionPane.showMessageDialog(null, "Se registró bicicleta " + color + " De serial " + placa);
        }
    }





    /**
     * Metodo para agregar espacios a una lista, se in
     * @param nuevoEspacio
     */
    public void agregarEspacios(Espacio nuevoEspacio){
        listEspacios.add(nuevoEspacio);
    }





    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(List<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }

    public List<Espacio> getListEspacios() {
        return listEspacios;
    }

    public void setListEspacios(List<Espacio> listEspacios) {
        this.listEspacios = listEspacios;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Servicio> getListServicios() {
        return listServicios;
    }

    public void setListServicios(List<Servicio> listServicios) {
        this.listServicios = listServicios;
    }

    public List<Facturacion> getListFacturaciones() {
        return listFacturaciones;
    }

    public void setListFacturaciones(List<Facturacion> listFacturaciones) {
        this.listFacturaciones = listFacturaciones;
    }

    public Tarifa getTheTarifa() {
        return theTarifa;
    }

    public void setTheTarifa(Tarifa theTarifa) {
        this.theTarifa = theTarifa;
    }


}