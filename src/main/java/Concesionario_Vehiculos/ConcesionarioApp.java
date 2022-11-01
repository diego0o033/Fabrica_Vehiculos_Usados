
package Concesionario_Vehiculos;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author diego vargas
 */
public class ConcesionarioApp 
{
    public static void main(String[] args) 
    {
        Scanner ingreso_datos= new Scanner(System.in);
        Concesionario concesionario= new Concesionario();
        Fabrica_Vehiculos fv= new Fabrica_Vehiculos();
        int opcion_menu=0;
        int opcion_menu_usuario=0;
        
        System.out.println("\n Bienvenido al sistema de la Fabrica de vehiculos S.A.");
        System.out.println("\n Si desea comenzar a operar con el menú principal del sistema, debe ingresar 1, de lo contrario ingrese 0");
        opcion_menu=ingreso_datos.nextInt();
        System.out.println("****************************************************************************************************");
        
        do
        {
            if(opcion_menu==1)
            {
                menuPrincipal();
                System.out.println("Digite una opcion del menú principal:");
                opcion_menu_usuario=ingreso_datos.nextInt();
                ingreso_datos.nextLine();//
            }   
            else
            {
                System.out.println("gracias por utilizar el sistema de la Fabrica de vehiculos  S.A.");
                salirMenu();
            } 
            switch(opcion_menu_usuario)
             {
                case 1:
                    int cantidad_concesionarios= 0;
                    System.out.println("Ingrese la cantidad de concesionarios que va a cargar en el sistema");
                    cantidad_concesionarios=ingreso_datos.nextInt();
                    fv.cargar_Concesionario(cantidad_concesionarios);
                    break;
                case 2:
                    fv.mostrar_Concesionarios();
                    break;
                case 3:    
                    String nombre_concesionario=null; 
                    System.out.println("Ingrese el nombre del concesionario en el que desea cargar nuevos vehiculos");
                    nombre_concesionario=ingreso_datos.nextLine();
                    if(fv.CargarVehiculo_x_Concesionario(nombre_concesionario)== false)
                    {
                        System.out.println(" Lo siento, debe ingresar el nombre de un concesionario válido," + " " + "el concesionario" + " " + nombre_concesionario + " " + " no es válido");
                    }    
                    break;
                case 4:
                    int cantidad=0;
                    System.out.println("Ingrese la cantidad de vehiculos para almacenar");
                    cantidad=ingreso_datos.nextInt();
                    concesionario.almacenarVehiculo(cantidad);
                    break;
                case 5:
                    System.out.println(" A continuación se van a mostrar en el sistema, los vehiculos que no sé encuentran cargados en ninguna concesionaria");
                    concesionario.mostrar_Autos();
                    break;
                case 6:
                    String consulta_concesionario="";
                    System.out.println("Ingrese el nombre del concesionario por el cual desea consultar los vehiculos que tiene en stock");
                    consulta_concesionario= ingreso_datos.nextLine();
                    if(fv.mostrar_Vehiculos_X_Concesionario(consulta_concesionario)== false)
                    {
                        System.out.println("Lo siento, debe ingresar el nombre de un concesionario válido," + " " + "el concesionario" + " " + consulta_concesionario + " " + " no es válido");
                    }
                    break;
                case 7:
                    String buscar_concesionario="";
                    System.out.println("Ingrese el nombre del concesionario, por el cual, quiere conocer los vehiculos con los que cuenta o que no se encuentran en dicho concesionario");
                    buscar_concesionario=ingreso_datos.nextLine();
                    if(fv.buscar_VehiculoXConcesionario(buscar_concesionario)== false)
                    {
                         System.out.println("Lo siento, debe ingresar el nombre de un concesionario válido," + " " + "el concesionario" + " " + buscar_concesionario + " " + " no es válido");
                    }
                    break;
                case 8:
                    System.out.println("A continuación se va a mostrar el vehiculo con mayor stock de la fabrica de vehiculos S.A.:");
                    concesionario.mostrar_Auto_StockMayor();
                    break;
                case 9:
                    System.out.println("A continuación se va a mostrar el vehiculo con menor stock de la fabrica de vehiculos S.A.:");
                    concesionario.mostrar_Auto_MenorStock();
                    break;    
                case 10:
                    System.out.println(" Se muestra a continuacion un listado de vehiculos ordenados por kilometraje, de mayor a menor, de la fabrica de vehiculos S.A.:");
                    concesionario.mostrar_Ordenado_MayorKms();
                    break;
                case 11:
                    System.out.println(" Se muestra a continuacion un listado de vehiculos ordenados por kilometraje, de menor a mayor, de la fabrica de vehiculos S.A.:");
                    concesionario.mostrar_Ordenado_MenorKms();
                    break;
                case 12:
                    String concesionario_buscado=null;
                    System.out.println("Ingrese el nombre del concesionario donde se encuentra el vehiculo que desea conocer su precio final/al publico");
                    concesionario_buscado=ingreso_datos.nextLine();
                    if(fv.precio_VehiculoXConcesionario(concesionario_buscado))
                    {
                        System.out.println("Lo siento, debe ingresar el nombre de un concesionario válido," + " " + "el concesionario" + " " + concesionario_buscado + " " + " no es válido");
                    }
                    break;
                case 13:
                    concesionario_buscado=null;
                    System.out.println("Ingrese el nombre del concesionario en el que se va a modificar un vehiculo");
                    concesionario_buscado=ingreso_datos.nextLine();
                    if(fv.modificar_VehiculoXConcesionario(concesionario_buscado)== false)
                    {
                        System.out.println("No se ha modificado el vehiculo, debe ingresar una patente/concesionario valido");
                    }
                      else
                      {
                            System.out.println("El vehiculo que pertenece a la concesionaria" + " " + concesionario_buscado + " " +  "se modifico correctamente");
                      }
                    break;
                case 14:
                    concesionario_buscado=null;
                    System.out.println("Ingrese el nombre del concesionario, al que se le va a quitar un vehiculo de su listado");
                    concesionario_buscado=ingreso_datos.nextLine();
                    if(fv.eliminar_VehiculoXConcesionaria(concesionario_buscado)==false)
                     {
                         System.out.println("El vehiculo de la concesionaria"+ " " + concesionario_buscado + " " + "no se ha podido remover ");
                     }
                     else
                     {
                         System.out.println("Un vehiculo de la concesionaria" + " " + concesionario_buscado + " " + "se ha eliminado");
                     }
                    break;
                case 15:
                    salirMenu();
                    break;
            }
            
        }
            while(opcion_menu_usuario >=1 || opcion_menu_usuario <=15);  
    }
    public static void menuPrincipal()
    {
        System.out.println("\n Bienvenidos/as al menu principal del sistema de gestion de la fabrica de vehiculos S.A., a continuación, va a poder visualizar en el menu, una serie de opciones para realizar diversas tareas");
        System.out.println("***********************************************************************************************");
        System.out.println("Ingrese el digito de la opcion deseada, recuerde que debe ingresar entre los valores ofrecidos en pantalla");
        System.out.println("1. Cargar nuevos concesionarios");
        System.out.println("2. Mostrar los concesionarios con los que trabaja la fabrica");
        System.out.println("3. Cargar nuevos vehiculos, en las concesionarias que trabajan con la fabrica de vehiculos");
        System.out.println("4. Cargar vehiculos a la fabrica de vehiculos");
        System.out.println("5. Mostrar los vehiculos ingresados al sistema de la fabrica, y, que no sé encuentren ingresados en ninguna concesionaria ");
        System.out.println("6. Mostrar los vehiculos de las concesionarias Vargas s.a.");
        System.out.println("7. Buscar un vehiculo por patente,el vehiculo a buscar debe pertenecer a la concesionaria Vargas s.a. ");
        System.out.println("8. Consultar los vehiculos que tengan mayor stock de la fabrica de vehiculos");
        System.out.println("9. Consultar los vehiculos que tengan menor stock de la fabrica de vehiculos");
        System.out.println("10. Consultar los vehiculos de acuerdo a sus kms (los que se encuentran en la fabrica), ordenados de mayor kilometraje a menor");
        System.out.println("11.Consultar los vehiculos de acuerdo a sus kms (los que se encuentran en la fabrica), ordenados de menor kilometraje a mayor");
        System.out.println("12. Mostrar el valor final de un vehiculo de la concesionaria Vargas s.a., para venta al publico en general");
        System.out.println("13. Modificar un vehiculo que se encuentre cargado en la concesionaria Vargas s.a.");
        System.out.println("14. Dar de baja un vehiculo(por patente) de la concesionaria Giulia s.a.");
        System.out.println("15. Salir del sistema");
    }
    private static void salirMenu()
    {
        System.out.println("\n hasta pronto!!!!");
        System.exit(0);
    }
}
