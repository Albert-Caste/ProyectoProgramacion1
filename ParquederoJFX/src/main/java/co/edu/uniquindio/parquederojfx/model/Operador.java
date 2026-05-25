package co.edu.uniquindio.parquederojfx.model;

public class Operador extends Persona {

        private String codigoEmpleado;

        public Operador(String nombre, String documento, String apellido, String telefono, String codigoEmpleado) {
            super(nombre, documento, apellido, telefono);
            this.codigoEmpleado = codigoEmpleado;

        }


    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
}
