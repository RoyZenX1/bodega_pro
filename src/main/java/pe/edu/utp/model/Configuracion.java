package pe.edu.utp.model;

public class Configuracion {
    private String nombreBodega = "BodegaPro";
    private String moneda = "PEN";
    private String tema = "claro";

    public String getNombreBodega(){return nombreBodega;} public void setNombreBodega(String nombreBodega){this.nombreBodega=nombreBodega;}
    public String getMoneda(){return moneda;} public void setMoneda(String moneda){this.moneda=moneda;}
    public String getTema(){return tema;} public void setTema(String tema){this.tema=tema;}
}