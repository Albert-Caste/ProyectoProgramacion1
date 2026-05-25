package co.edu.uniquindio.parquederojfx.controller;


import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.model.*;

import javax.swing.*;
import java.util.List;


public class AccesoController {


    private Administrador administrador;
    private Operador operador;

    /**
     * Esta variable es para intanciar de un solo
     */
    private App atributosApp;



    public AccesoController() {
        atributosApp = new App();

    }



    public boolean validarAcceso(String nombre, String documento, String codigo) {
        boolean bandera = false;


        try{
            operador = atributosApp.getParqueaderoUQ().buscarOperador(documento);
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"No esta registrado ");

        }


        if(operador!= null){
            if (nombre.equals(operador.getNombre()) && codigo.equals(operador.getCodigoEmpleado())){
                bandera = true;
            }
        }else {
            bandera = false;
        }





        return bandera;
    }
}