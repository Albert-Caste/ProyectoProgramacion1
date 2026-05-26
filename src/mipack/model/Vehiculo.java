package mipack.model;
import java.time.LocalDateTime;

public abstract class Vehiculo {
    private String placa;
    private TipoVehiculo tipoVehiculo;
    private String nombreConductor;
    private String cedulaConductor;
    private LocalDateTime horaIngreso;
    private String espacioAsignado;
    private String estado;


    public Vehiculo(String placa, TipoVehiculo tipoVehiculo, String nombreConductor, String cedulaConductor, String espacioAsignado) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.nombreConductor = nombreConductor;
        this.cedulaConductor = cedulaConductor;
        this.espacioAsignado = espacioAsignado;
        this.estado = "Dentro";
    }

    public String getPlaca(){return placa;}
    public void setPlaca(String placa){this.placa=placa;}

    public TipoVehiculo getTipoVehiculo() {return tipoVehiculo;}
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {this.tipoVehiculo = tipoVehiculo;}

    public String getNombreConductor() {return nombreConductor;}
    public void setNombreConductor(String nombreConductor) {this.nombreConductor = nombreConductor;}

    public String getCedulaConductor() {return cedulaConductor;}
    public void setCedulaConductor(String cedulaConductor) {this.cedulaConductor = cedulaConductor;}

    public LocalDateTime getHoraIngreso() {return horaIngreso; }

    public String getEspacioAsignado() {return espacioAsignado;}
    public void setEspacioAsignado(String espacioAsignado) {this.espacioAsignado = espacioAsignado;}

    public String getEstado() {return estado;}
    public void setEstado(String estado) { this.estado = estado;}
}