
package Concesionario_Vehiculos;


public class Motocicleta extends Vehiculo
{
    private float cilindrada;
    private int cantidad_ruedas;

    public Motocicleta( String patente, String marca, String modelo, float cilindrada, int cantidad_ruedas )
    {
        super(patente, marca, modelo);
        this.cilindrada=cilindrada;
        this.cantidad_ruedas=cantidad_ruedas;
    }
    
    public Motocicleta(){}

    @Override
    public void consultar_Modelo(String modelo)
    {
        if(modelo.equalsIgnoreCase("z16"))
        {
        System.out.println("El siguiente modelo consultado es una moto....");
        }
        else
        {
            System.out.println("Lo siento, no ha ingresado un modelo valido de una  moto");
        }
    }
}
