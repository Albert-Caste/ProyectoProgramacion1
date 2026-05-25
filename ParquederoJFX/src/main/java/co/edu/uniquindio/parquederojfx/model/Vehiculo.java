package co.edu.uniquindio.parquederojfx.model;

public abstract class Vehiculo {

    private String placa;
    private String color;


    public Vehiculo(String placa, String color) {
        this.placa = placa;
        this.color = color;

    }


    public abstract double calcularServicioHoras(Parqueadero parqueadero, int horas, Vehiculo vehiculo, Cliente cliente);

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


}
