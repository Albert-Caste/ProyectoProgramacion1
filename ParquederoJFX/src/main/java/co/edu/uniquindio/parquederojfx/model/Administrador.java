package co.edu.uniquindio.parquederojfx.model;

import javax.swing.*;

public class Administrador extends Persona implements IFuncionAdmin {


    private String codigoAdministrador;

    public Administrador(String nombre, String documento, String apellido, String telefono, String codigoAdministrador) {
        super(nombre, documento, apellido, telefono);
        this.codigoAdministrador = codigoAdministrador;

    }

    Parqueadero parqueaderoU = new Parqueadero("UQ", "123");


    public boolean validarEspacio(String idEspacio) {
        boolean valida = false;
        for (Espacio ep : parqueaderoU.getListEspacios()){
            if(ep.getCodigoEspacio().equals(idEspacio)){
                valida = true;
                break;
            }
        }

        return valida;
    }


    /**
     * Metodo para agregar nuevo eespacio carro en el parquedero
     * @param codigoEspacio codigo alfa numerico C1, C2, ...
     * @param piso del parqueadero donde estar el nuevo espacio
     */

    @Override
    public void agregarEspacioCarro(String codigoEspacio, int piso)  {
        Espacio nuevoEspacioCarro = null;

        if(validarEspacio(codigoEspacio)) {
            JOptionPane.showMessageDialog(null, "El Espacio ya existe ");
        } else {
            nuevoEspacioCarro  = new EspacioCarro(codigoEspacio, piso);
            parqueaderoU.agregarEspacios(nuevoEspacioCarro);

            JOptionPane.showMessageDialog(null, "Se registró " + codigoEspacio);
        }

    }

    /**
     * Metodo para agregar nuevo espacio de moto al parqueader
     * @param codigoEspacio codigo alfa- numerico M1, M2, ...
     * @param zona zona techada o  exterior.
     */

    @Override
    public void agregarEspacioMoto(String codigoEspacio, String zona)  {
        Espacio nuevoEspacioCarro = null;

        if(validarEspacio(codigoEspacio)) {
            JOptionPane.showMessageDialog(null, "El Espacio ya existe ");
        } else {
            nuevoEspacioCarro  = new EspacioMoto(codigoEspacio, zona);
            parqueaderoU.agregarEspacios(nuevoEspacioCarro);

            JOptionPane.showMessageDialog(null, "Se registró " + codigoEspacio);
        }

    }

    /**
     * Metood para crear espacio de parqueadero
     * @param codigoEspacio patron alfa numerico B1, B2, ...
     * @param numParrilla
     */
    @Override
    public void agregarEspacioBicicleta(String codigoEspacio, int  numParrilla)  {
        Espacio nuevoEspacioCarro = null;

        if(validarEspacio(codigoEspacio)) {
            JOptionPane.showMessageDialog(null, "El Espacio ya existe ");
        } else {
            nuevoEspacioCarro  = new EspacioBicicleta(codigoEspacio, numParrilla);
            parqueaderoU.agregarEspacios(nuevoEspacioCarro);

            JOptionPane.showMessageDialog(null, "Se registró " + codigoEspacio);
        }

    }

    /**
     *
     * Metodo para modificar las tarifas del parqueadero
     * @param horaCarro
     * @param horaMoto
     * @param horaBicicleta
     * @param diaCarro
     * @param diaMoto
     * @param nocheCarro
     * @param nocheMoto
     * @param mesCarro
     * @param mesMoto
     */

    @Override
    public void modificarTarifas(Parqueadero parqueadero, double horaCarro, double horaMoto, double horaBicicleta, double diaCarro, double diaMoto, double nocheCarro, double nocheMoto, double mesCarro, double mesMoto){

        parqueadero.getTheTarifa().setHoraCarro(horaCarro);
        parqueadero.getTheTarifa().setHoraMoto(horaMoto);
        parqueadero.getTheTarifa().setHoraBicicleta(horaBicicleta);

        parqueadero.getTheTarifa().setDiaCarro(diaCarro);
        parqueadero.getTheTarifa().setDiaMoto(diaMoto);

        parqueadero.getTheTarifa().setNocheCarro(nocheCarro);
        parqueadero.getTheTarifa().setNocheMoto(nocheMoto);

        parqueadero.getTheTarifa().setMesCarro(mesCarro);
        parqueadero.getTheTarifa().setMesMoto(mesMoto);


        JOptionPane.showMessageDialog(null, "Tarifas Actualizadas ");



    }


    public boolean validarEspacio(Parqueadero parqueadero, String idEspacio) {
        boolean valida = false;
        for (Espacio ep : parqueadero.getListEspacios()) {
            if (ep.getCodigoEspacio().equals(idEspacio)) {
                valida = true;
                break;
            }
        }
        return valida;
    }









    public String getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(String codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }


}
