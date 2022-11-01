
package Concesionario_Vehiculos;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;


public class Concesionario 
{
    private String nombre;
    private ArrayList<Auto> autos;
    
    //private ArrayList<Motocicleta> motos;

    public Concesionario(String nombre)
    {
        this.nombre=nombre;
        
        //his.motos=new ArrayList<Motocicleta>();
    }

    public Concesionario()
    {
        this.autos=new ArrayList<Auto>();
    }   
      
   @Override
    
    public String toString() 
    {
        return "Concesionario{" + "nombre=" + nombre  + '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() 
    {
        return nombre;
    }
    public void almacenarVehiculo(int cantidad)
        {
           
            Scanner ingreso_datos= new Scanner(System.in);
            int i= 1;
            
            while(i<=cantidad)
            {
                Auto a=new Auto();
                
                System.out.println("Ingrese una patente valida");
                a.setPatente(ingreso_datos.next());
                System.out.println("Ingrese una marca para el auto");
                a.setMarca(ingreso_datos.next());
                System.out.println("Ingrese un modelo para el auto");
                a.setModelo(ingreso_datos.next());
                System.out.println("Ingrese el tamaño de cilindrada del motor del auto ");
                a.setCilindrada(ingreso_datos.nextFloat());
                System.out.println("El vehiculo cuenta con aire acondicionado si/no");
                String aire_ac=ingreso_datos.next();
                a.setAc(false);
                
                    if(aire_ac.equalsIgnoreCase("si"))
                    {
                    a.setAc(true);
                    }
                System.out.println("Indique si el vehiculo tiene 3/4/5 puertas");
                a.setPuertas(ingreso_datos.nextInt());    
                System.out.println("Indique la cantidad de vehiculos disponibles/fabricados para dicho modelo");
                a.setCantidad_Auto(ingreso_datos.nextInt());
                System.out.println("Ingrese la cantidad de kilometros con la que cuenta el vehiculo");
                a.setCantidad_kms(ingreso_datos.nextDouble());
                System.out.println("Ingrese el precio/costo del vehiculo");
                a.setPrecio(ingreso_datos.nextDouble());
                this.autos.add(a);
                System.out.println("El vehiculo se ingreso correctamente");
                i++;           
                System.out.println("/n*************************************************************************************************************************");
            }
            System.out.println("Finalizaste la carga de vehiculos");
        }    
    public void mostrar_Autos()
    {
        for(Auto a: autos)
        {
            System.out.println("Los autos almacenados son los siguientes:" + " " + a );
        }
    }
    
    public boolean busqueda_x_Patente(String patente)
    {
       boolean patente_buscada=false;
        
        for(Auto a: autos)
        {
           if(a.getPatente().equalsIgnoreCase(patente))
            {
                patente_buscada=true;
                break;
            }  
        }
     return patente_buscada;   
    }

    public int buscar_Auto_MayorStock()
    {
        int mayor_stock=0;
      
        for(Auto a: autos)
        {
            if(a.getCantidad_Auto()>mayor_stock)
            {
                mayor_stock=a.getCantidad_Auto();               
            }
        }
    
     return mayor_stock;               
    }
    public void mostrar_Auto_StockMayor()
    {
        for(Auto a: autos)
        {
         if(a.getCantidad_Auto()>=this.buscar_Auto_MayorStock())   
            {
                System.out.println("El auto con mayor stock es:" + a.getMarca()+ " " + a.getModelo() + " " + this.buscar_Auto_MayorStock());
            }
        }
    }
    public int auto_MenorStock()
    {
        int auto_menorcantidad=1000;
        
        for(Auto a: autos)
        {
            if(a.getCantidad_Auto()< auto_menorcantidad)
            {
                auto_menorcantidad= a.getCantidad_Auto();
            }
        }
      return auto_menorcantidad;  
    }
    public void mostrar_Auto_MenorStock()
    {
        for(Auto a:autos)
        {
            if(a.getCantidad_Auto()<= this.auto_MenorStock())
            {
                System.out.println("El auto con menor stock es:" + " " + a.getMarca() + " " + a.getModelo()+ " " + this.auto_MenorStock());
            }
        }
    }
        
    public Auto modificar_Vehiculo(String patente)
    {
        Scanner ingreso_datos=new Scanner(System.in);
        int opcion=0;
        for(Auto a:autos)
        {
            if(a.getPatente().equalsIgnoreCase(patente))
            {
                System.out.println("El vehiculo se encuentra ingresado en nuestro sistema," + " " + "el vehiculo que desea modificar es el siguiente:" + " " + patente  );
                System.out.println("Si desea realizar algun cambio en los datos ingresados del vehiculo,ingrese 1 de lo contrario 0");
                opcion=ingreso_datos.nextInt();
              if(opcion==1)
              {
                    System.out.println("A continuacion se muestran los datos del vehiculo, para que pueda realizar los cambios deseados");
                    System.out.print("**********************************************************************");
                    System.out.println("Ingrese la nueva patente para el vehiculo");
                    a.setPatente(ingreso_datos.next());
                    System.out.println("Ingrese la nueva marca para el vehiculo");
                    a.setMarca(ingreso_datos.next());
                    System.out.println("Ingrese el nuevo modelo del vehiculo");
                    a.setModelo(ingreso_datos.next());
                    System.out.println("Ingrese la nueva motorizacion del vehiculo");
                    a.setCilindrada(ingreso_datos.nextDouble());
                    System.out.println("Tiene aire acondicionado? si/no");
                    String opcion_seleccionada=ingreso_datos.next();
                  if(opcion_seleccionada.equalsIgnoreCase("si"))
                    {
                        a.setAc(true);
                    }
                    else
                    {
                        a.setAc(false);
                    }    
                    System.out.println("Ingrese la cantidad de puertas para el vehiculo");
                    a.setPuertas(ingreso_datos.nextInt());
                    System.out.println("Ingrese la cantidad/stock de dicho vehiculo");
                    a.setCantidad_Auto(ingreso_datos.nextInt());
                    System.out.println("Ingrese los el kilometraje que tiene el vehiculo");
                    a.setCantidad_kms(ingreso_datos.nextDouble());
                    System.out.println("Ingrese el valor/ precio de fabrica para el vehiculo");
                    a.setPrecio(ingreso_datos.nextDouble());
                    return a;
                }
                else
                {
                    System.out.println("Saliendo de la opcion de modificar vehiculo");
                    return null;
                }
            }
            
        }     
        return null;
    } 

public boolean eliminar_Auto(String patente)
{
   boolean remover_auto=false;
    
   for(Auto a:autos)
    {
        if(a.getPatente().equalsIgnoreCase(patente))
        {
            System.out.println("A continuación se procede a quitar del listado de vehiculos, al vehiculo con patente:" + " " + a.getPatente()); 
            autos.remove(a);
            remover_auto=true;
            return remover_auto;
        }
    }
    return remover_auto;
}

public void mostrar_Ordenado_MenorKms()
{
    Collections.sort(autos);
    for(Auto a: autos)
    {
        System.out.println("A continuación se muestran los autos ordenados por menor kilometraje a mayor" + a);
    }

}
public void mostrar_Ordenado_MayorKms()
{
    Collections.sort(autos,Collections.reverseOrder());
    for(Auto a : autos )
    {
        System.out.println(" A continuacion se muestran los autos ordenados por mayor kilometraje a menor" + a);
    }
}
public void calcular_Precio_X_Vehiculo(Concesionario c,String busqueda_patente)
{
  Scanner ingreso_datos= new Scanner (System.in);
  float iva=0;      
      
      for(Auto a : autos)
        {
           if(a.getPatente().equalsIgnoreCase(busqueda_patente))
           {
               System.out.println("El vehiculo con patente"+ " " + busqueda_patente + " " + "se encuentra en el concesionario"+ " " + c.getNombre() + " debe ingresar el iva, para conocer el precio final del vehiculo");
               iva= ingreso_datos.nextFloat();
               System.out.println("El vehiculo de marca" + " " + a.getMarca() + " " + "modelo" + " " + a.getModelo() + " " + "tiene un precio final para el público de:"+ " " + a.conocer_Precio_Final(iva));
           } 
        }

}

}
