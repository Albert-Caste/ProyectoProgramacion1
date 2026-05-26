package mipack.model;

public class Tarifa {
    private double horaCarro;
    private double horaMoto;
    private double horaBicicleta;
    private double diaCarro;
    private double diaMoto;
    private double nocheCarro;
    private double nocheMoto;
    private double mesCarro;
    private double mesMoto;

    // Constructor completo para configurar todos los precios del parqueadero
    public Tarifa(double horaCarro, double horaMoto, double horaBicicleta,
                  double diaCarro, double diaMoto,
                  double nocheCarro, double nocheMoto,
                  double mesCarro, double mesMoto) {
        this.horaCarro = horaCarro;
        this.horaMoto = horaMoto;
        this.horaBicicleta = horaBicicleta;
        this.diaCarro = diaCarro;
        this.diaMoto = diaMoto;
        this.nocheCarro = nocheCarro;
        this.nocheMoto = nocheMoto;
        this.mesCarro = mesCarro;
        this.mesMoto = mesMoto;
    }

    public double getHoraCarro() { return horaCarro; }
    public void setHoraCarro(double horaCarro) { this.horaCarro = horaCarro; }

    public double getHoraMoto() { return horaMoto; }
    public void setHoraMoto(double horaMoto) { this.horaMoto = horaMoto; } // Ojo con mantener el orden

    public double getHoraBicicleta() { return horaBicicleta; }
    public void setHoraBicicleta(double horaBicicleta) { this.horaBicicleta = horaBicicleta; }

    public double getDiaCarro() { return diaCarro; }
    public void setDiaCarro(double diaCarro) { this.diaCarro = diaCarro; }

    public double getDiaMoto() { return diaMoto; }
    public void setDiaMoto(double diaMoto) { this.diaMoto = diaMoto; }

    public double getNocheCarro() { return nocheCarro; }
    public void setNocheCarro(double nocheCarro) { this.nocheCarro = nocheCarro; }

    public double getNocheMoto() { return nocheMoto; }
    public void setNocheMoto(double nocheMoto) { this.nocheMoto = nocheMoto; }

    public double getMesCarro() { return mesCarro; }
    public void setMesCarro(double mesCarro) { this.mesCarro = mesCarro; }

    public double getMesMoto() { return mesMoto; }
    public void setMesMoto(double mesMoto) { this.mesMoto = mesMoto; }
}