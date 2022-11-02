
package Concesionario_Vehiculos;



public class Auto extends Vehiculo implements Comparable<Auto>
{
    private double cilindrada;
    private boolean ac;
    private int puertas;
    private int cantidad_auto;
    private double cantidad_kms;
    private double precio;
    public Auto(String patente,String marca,String modelo,double cilindrada, boolean ac, int puertas, int cantidad_auto, double cantidad_kms,double precio)
    {
        super( patente, marca, modelo);
        this.cilindrada=cilindrada;
        this.ac=ac;
        this.puertas=puertas;
        this.cantidad_auto=cantidad_auto;
        this.cantidad_kms=cantidad_kms;
        this.precio=precio;
    }
    public Auto()
    {
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public boolean isAc() {
        return ac;
    }

    public int getPuertas() {
        return puertas;
    }
    
    public int getCantidad_Auto(){
        return cantidad_auto;
    }
    public double getCantidad_Kms(){
        return cantidad_kms;    
    }
    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public void setCantidad_Auto(int cantidad_auto)
    {
        this.cantidad_auto=cantidad_auto;
    }
    public void setCantidad_kms(double cantidad_kms) {
        this.cantidad_kms = cantidad_kms;
    }
    public void setPrecio(double precio){
    this.precio=precio;
    }
    
    @Override
    public String toString() 
    {
      String mostrar=null;
        if(ac=true)
        {
            mostrar="si";
        }
        else 
        {
            mostrar= "no";
        }
        return "Auto{" + ", patente=" + super.getPatente() + ", marca=" + super.getMarca() + ", modelo=" + super.getModelo() + ", cilindrada=" + cilindrada + ", ac=" + mostrar + ", puertas=" + puertas + ", cantidad/stock="+ cantidad_auto + ",cantidad de kilometros="+ cantidad_kms + ", precio del vehiculo al valor fabrica= " + precio + '}';
    }
    
    @Override
    public int compareTo(Auto a) 
    {
        Double total_kms= new Double(cantidad_kms);   
        return total_kms.compareTo(a.cantidad_kms);
    }
    
    public double conocer_Precio_Final(float iva)
    {
        double valor_total=0;
               valor_total= (precio * iva /100) + precio;
               return valor_total;
    }
    

}
