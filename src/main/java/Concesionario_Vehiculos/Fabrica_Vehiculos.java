package Concesionario_Vehiculos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author diego vargas
 */
public class Fabrica_Vehiculos 
{
    private String nombre; 
    private ArrayList<Concesionario> concesionarios;

public  Fabrica_Vehiculos(String nombre)
{
    this.nombre=nombre;
}
public Fabrica_Vehiculos()
{
this.concesionarios =new ArrayList<Concesionario>();
}
public void cargar_Concesionario(int cantidad_concesionario)
{
    Scanner ingreso_datos=new Scanner(System.in);
    int contador=1;
    
    while(contador<= cantidad_concesionario)
    {
        Concesionario c= new Concesionario();
        System.out.println("Ingrese el nombre del concesionario");
        c.setNombre(ingreso_datos.nextLine());
        concesionarios.add(c);
        contador++;
    }
}

public void mostrar_Concesionarios()
{
    
    for(Concesionario c: concesionarios)
   {
       System.out.println("El siguiente concesionario se encuentra ingresado en nuesto sistema:" + c);
       
   }
       System.out.println("Los concesionarios con los que trabaja la fabrica de vehiculos son:" + concesionarios.size());
}

public boolean CargarVehiculo_x_Concesionario( String nombre)
{
    Scanner ingreso_datos=new Scanner(System.in);
    int cantidad= 0;
    boolean vehiculo_ingresado= false;   
      
    for(Concesionario c: concesionarios)
    {
           if((nombre.equalsIgnoreCase("vargas s.a.") || (nombre.equalsIgnoreCase("giulia s.a."))) && (c.getNombre().equalsIgnoreCase(nombre)))
           {
           System.out.println("\n El concesionario en el que desea realizar la carga de vehiculos, se encuentra en nuestro sistema");
           System.out.println("\n Ingrese la cantidad de vehiculos que va a cargar en el concesionario elegido");
           cantidad=ingreso_datos.nextInt();
           ingreso_datos.nextLine();
           c.almacenarVehiculo(cantidad);     
           vehiculo_ingresado= true;
           }
    }       
    return vehiculo_ingresado;
}      

public boolean mostrar_Vehiculos_X_Concesionario(String nombre_concesionario)
{
    boolean concesionario_valido=false;
    
    for(Concesionario c: concesionarios)
    {
        if(c.getNombre().equalsIgnoreCase(nombre_concesionario))
        {
         System.out.println("El concesionario" + " " + c.getNombre() + " " + "tiene los siguientes vehiculos en stock:");
         c.mostrar_Autos();
         concesionario_valido=true;
         return concesionario_valido;
        }
    }
   return concesionario_valido; 
}
public boolean buscar_VehiculoXConcesionario(String nombre)
  {
    String patente="";  
    Scanner ingreso_datos= new Scanner (System.in);
    boolean concesionario_buscado= false;
   
        for(Concesionario c: concesionarios)
        {
          if(nombre.equalsIgnoreCase("vargas s.a.")&& c.getNombre().equalsIgnoreCase(nombre))
          {
            System.out.println("ingrese la patente del vehiculo que desea buscar");
            patente=ingreso_datos.next();
            c.busqueda_x_Patente(patente);
                    
            if(c.busqueda_x_Patente(patente)==true)
            {
                System.out.println("El vehiculo con patente:" + " " + patente + " " + "se encuentra ingresado en nuestro sistema");
                
            }
            else
            {
                System.out.println("El vehiculo con patente:"+ " " + patente + " " + " no se encuentra ingresado en nuestro sistema");

            }    
          }   
      }  
    return concesionario_buscado;
  }
public boolean modificar_VehiculoXConcesionario(String nombre_concesionario)
{
        Scanner ingreso_datos = new Scanner(System.in);
        String patente_buscada = null;
        boolean modificado = false;
        
        for(Concesionario c: concesionarios)
        {
            if ((nombre_concesionario.equalsIgnoreCase("vargas s.a.")) && (c.getNombre().equalsIgnoreCase(nombre_concesionario))) 
            {
              System.out.println("Va a modificar un vehiculo de la concesionaria vargas s.a., para continuar con el procedimiento debe ingresar la patente del vehiculo...");
              patente_buscada = ingreso_datos.next();

            if (c.modificar_Vehiculo(patente_buscada) == null) 
            {
                System.out.println("El vehiculo con patente" + " " + patente_buscada + " " + "no se ha modificado/debe ingresar una patente valida");
                modificado = false;
            } else 
              {
                System.out.println(" Se ha modificado el vehiculo con patente" + " " +  patente_buscada + " " + "satisfactoriamente");
                modificado = true;
              }
           }
        }
   return modificado; 
}

public boolean eliminar_VehiculoXConcesionaria(String nombre_concesionario)
{
   Scanner ingreso_datos= new Scanner(System.in);
   String patente_buscada=null;  
   boolean auto_eliminado= false; 
    
     for(Concesionario c: concesionarios)
     {     
       if((nombre_concesionario.equalsIgnoreCase("giulia s.a.")) && (c.getNombre().equalsIgnoreCase(nombre_concesionario)))
       {
          System.out.println("Ingrese una patente valida para poder eliminar un vehiculo del listado de la concesionaria Giulia s.a.");  
          patente_buscada=ingreso_datos.next();
      
        if(c.eliminar_Auto(patente_buscada)== false)
        {
          System.out.println("El vehiculo con patente" + " " + patente_buscada + " " + " no se ha podido eliminar");
        }  
         else
         {
          System.out.println("Se ha quitado el vehiculo con patente" + " " + patente_buscada + " " + "del listado, de la concesionaria Giulia s.a.");
          auto_eliminado=true;  
         } 
       }
     }
   return auto_eliminado;
}
public boolean precio_VehiculoXConcesionario(String nombre_concesionario)
  {
    Scanner ingreso_datos= new Scanner(System.in);
    String patente_buscada= null;
    boolean concesionario_buscado= false;
        
        for(Concesionario c: concesionarios)
        {
            if((nombre_concesionario.equalsIgnoreCase("vargas s.a.")) && (c.getNombre().equalsIgnoreCase(nombre_concesionario)))
            {
                System.out.println("A continuación debe ingresar la patente del vehiculo que desea conocer su precio final");
                patente_buscada=ingreso_datos.next();
                c.calcular_Precio_X_Vehiculo(c,patente_buscada);
            }
        }
    return concesionario_buscado;   
  }

}