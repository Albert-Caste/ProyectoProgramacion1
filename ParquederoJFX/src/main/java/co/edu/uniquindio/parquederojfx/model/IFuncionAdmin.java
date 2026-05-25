package co.edu.uniquindio.parquederojfx.model;

public interface IFuncionAdmin {

    public void agregarEspacioCarro(String codigoEspacio, int piso);

    public void agregarEspacioMoto(String codigoEspacio, String zona);

    public void agregarEspacioBicicleta(String codigoEspacio, int  numParrilla);

    public void modificarTarifas(Parqueadero parqueadero, double horaCarro, double horaMoto, double horaBicicleta, double diaCarro, double diaMoto, double nocheCarro, double nocheMoto, double mesCarro, double mesMoto);
}
