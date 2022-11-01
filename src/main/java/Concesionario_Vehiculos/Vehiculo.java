
package Concesionario_Vehiculos;


public class Vehiculo 
{
private String patente;
private String marca;
private String modelo;

public Vehiculo(String patente, String marca, String modelo)
{
    this.patente=patente;
    this.marca=marca;
    this.modelo=modelo;
}
public Vehiculo(){}
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + '}';
    }

    public void consultar_Modelo(String modelo)
    {
        System.out.println("El siguiente modelo consultado es un vehiculo....");
    }

    
}
