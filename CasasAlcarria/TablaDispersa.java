package CasasAlcarria;
public class TablaDispersa
{
    //Atributos de la calse Tabla dispersa
    static final int TAMTABLA = 67; //cambie el tamaño porque no hacia falta una tabla tan grande 
    private int numElementos;
    private double factorCarga;
    private CasaRural [] tabla;

//constructor de la clase
public TablaDispersa()
{   tabla = new CasaRural[TAMTABLA];
    for(int j = 0; j < TAMTABLA ; j++)
        tabla[j] = null;
    numElementos = 0;
    factorCarga = 0.0;
    }

public int direccion(String clave) //creo que se podria hacer privada este metodo
{
    int i = 0, p;
    long d;
    d = transformaCadena(clave);
    // aplica aritmética modular para obtener dirección base 
    p = (int)(d % TAMTABLA);
    // bucle de exploración  
    
    //aplica el metodo de la exploracion cuadratica en caso de colisiones
    
    /*es importante destacar la segunda parte de al expresion logica ya que es la que 
    le permite a la funcion devolver la posicion del objeto que posehe la clave que 
    le dimos como argumento al metodo*/
    
    while (tabla[p]!= null && !tabla[p].getCodigo().equals(clave))
    {
        i++;
        p = p + i*i;
        p = p % TAMTABLA; /*considera el array como circular de esta forma 
                            aplica la teoria de restos para calular la posicion*/  
    }
    return p;
}

public long transformaCadena(String c)/* tranforma la clave de no mas de 10 caracteres en un numero*/
{
    long d;
    d = 0;
    for (int j = 0; j < Math.min(10,c.length()); j++)
    {
        d = d * 27 + (int)c.charAt(j);
    }
    if (d < 0) d = -d;
    return d;
}

/* este procedimiento inserta el objeto casarural en la tabla para hacer esto calcula la direccion con el 
metodo direccion y luego simplemete agrega el objeto al arreglo (tabla hash) utilizando como subindice 
la posicion calculada anteriormente, esto es loque nos permite acortar el timpeo de buqueda, porque 
podemos saber el subindice (ubicacion) del elemtento en cuestion sin tener que pasar por ningun otro. Luego de
terminada esta accion actualiza los campos de factor de carga y numero de elementos de la tabla */
public void insertar(CasaRural casaRural)
{
    int posicion;
    posicion = direccion(casaRural.getCodigo());
    tabla[posicion] = casaRural;
    numElementos++;
    factorCarga = (double)(numElementos)/TAMTABLA;
    if (factorCarga > 0.5)
        System.out.println("\n!! Factor de carga supera el 50%.!!"
        + " Conviene aumentar el tamaño." );
}
/* busca el objeto casa rural al calcular la clave basandonos en la clave 
que usamos para generar el subindice (table hash index) y retorna dicho objeto
ademas en caso de que el objeto buscado no esta dado de alta (esta eliminado) devuelve null*/
public CasaRural buscar(String clave)
{
    CasaRural pr;
    int posicion;
    posicion = direccion(clave);
    pr = tabla[posicion];
    if (pr != null)
        if (! pr.esAlta) pr = null; 
    return pr;
}
/* utiliza la misma dinamica que buscar con la diferencia que cuando encuentra el objeto lo elimina 
esto significa cambiar el valor de su variable es alta a falso*/
public void eliminar(String clave)
{
    int posicion;
    posicion = direccion(clave);
    if (tabla[posicion] != null)
        tabla[posicion].esAlta = false;
}
}