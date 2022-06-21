package CasasAlcarria;
//import CasasAlcarria.CasaRural;
//import CasasAlcarria.TablaDispersa;
import java.util.Scanner;

public class App {
    
    private static Scanner input = new Scanner(System.in);
    private static int rta=0,condicion=99;
    private static String clave;
    private static TablaDispersa tablaHash = new TablaDispersa();
    
    public static void main(String[] args){
             
        do{
            System.out.print("[1] Insertar una Casa Rural \n");
            System.out.print("[2] Eliminar una Casa Rural \n");
            System.out.print("[3] Buscar una Elemento \n");
            System.out.print("[0] Salir del programa \n");
            rta=input.nextInt();
            input.nextLine();
            
            switch(rta){
                case 1:
                    CasaRural casaInsertar = new CasaRural();
                    tablaHash.insertar(casaInsertar);
                    break;
                case 2:
                    System.out.print("Ingrese la clave de la casa que desea Eliminar \n");
                    clave=input.nextLine();
                    tablaHash.eliminar(clave);
                    break;
                case 3:
                    CasaRural casaMostrar = new CasaRural();
                    System.out.print("Ingrese la clave de la casa que desea Buscar \n");
                    clave=input.nextLine();
                    casaMostrar = tablaHash.buscar(clave);
                    casaMostrar.muestra();
                    break;
                case 0 :
                    condicion = 0;
                    break;
                default:
                    System.out.print("La opcion ingresada no es valida\n");
                    break;

            }

        }while(condicion!= 0);
        System.out.print("Ejecucion Terminada \n");

    }
    
    
}
