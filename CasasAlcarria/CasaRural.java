package CasasAlcarria;
import java.io.*;
public class CasaRural
{
//atributos de clase
    private String codigo;
    private String poblacion;
    private String direccion;
    private int numHabitacion = 0;
    private double precio = 0.0;
    boolean esAlta;
//constructor
public CasaRural() 
{ 
    esAlta = true;
    this.codigo=null;
    this.poblacion=null;
    this.direccion=null;
    this.numHabitacion=0;
    this.precio=0.0;
}
public CasaRural(boolean verdad) 
{ 
    esAlta = true;
    asigna();
}
//metodo que le permite al usuario asignar los valores de los atributos de clase
public void asigna()
{
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    try {
        System.out.print("\n Codigo (10 caracteres): ");
        codigo = entrada.readLine(); 
        System.out.print("\n Población: ");
        poblacion = entrada.readLine(); 
        System.out.print("\n Dirección: ");
        direccion = entrada.readLine(); 
        System.out.print("\n Número de habitaciones: ");
        numHabitacion = Integer.parseInt(entrada.readLine()); 
        System.out.print("\n Precio por día de estancia: ");
        precio = Double.parseDouble(entrada.readLine()); 
    }
    catch (IOException e)
    {
        System.out.println(" Excepcion en la entrada de datos " + 
        e.getMessage()+ " . No se da de alta");
        esAlta = false;
    }
}

//devuelve el codigo de la casa
public String getCodigo()
{
    return codigo;
}

//muestra por pantalla los atributos de la clase 
public void muestra()
{
    System.out.println("\n Casa Rural " + codigo);
    System.out.println("Población: " + poblacion);
    System.out.println("Dirección: " + direccion);
    System.out.println("Precio por día: " + precio);
    System.out.println("Numero de habitaciones: " + numHabitacion);
}
}

