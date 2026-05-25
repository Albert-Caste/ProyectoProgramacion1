package co.edu.uniquindio.parquederojfx.controller;


import co.edu.uniquindio.parquederojfx.model.Administrador;
import co.edu.uniquindio.parquederojfx.model.Cilindraje;
import co.edu.uniquindio.parquederojfx.model.Operador;


public class AccesoController {

    private Administrador administrador;
    private Operador operador;

    public AccesoController() {

        administrador = new Administrador("Daniel","000", "Ocampo", "321456", "123"   );
        operador = new Operador("Albert", "1111", "Castellanos", "65321", "321");
    }

    public boolean validarAcceso(String nombre, String codigo) {
        boolean bandera = false;
        if (nombre.equals(administrador.getNombre()) &&
                codigo.equals(administrador.getCodigoAdministrador())){
            bandera = true;
        }

        if (nombre.equals(operador.getNombre()) && codigo.equals(operador.getCodigoEmpleado())){
            bandera = true;
        }

        return bandera;
    }
}