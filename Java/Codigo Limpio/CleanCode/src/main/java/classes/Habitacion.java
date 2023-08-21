package classes;
import java.util.Map;
import java.util.HashMap;

public class Habitacion
{
    private String nombre;
    private Map<String, Integer> ListaObjetosAdquiribles;

    public Habitacion(String nombre)
    {
        this.nombre = nombre;
        ListaObjetosAdquiribles = new HashMap<String, Integer>();
        ListaObjetosAdquiribles.put("Mesa", 70);
        ListaObjetosAdquiribles.put("Cuadro", 12);
        ListaObjetosAdquiribles.put("Adorno", 25);
        ListaObjetosAdquiribles.put("Television", 200);
        ListaObjetosAdquiribles.put("Sofa", 100);
        ListaObjetosAdquiribles.put("Libro", 20);
        ListaObjetosAdquiribles.put("Juguete", 35);
        ListaObjetosAdquiribles.put("Silla", 50);
        ListaObjetosAdquiribles.put("Cojin", 12);
        ListaObjetosAdquiribles.put("Archivador", 45);
    }


    @Override
    public String toString()
    {
        return this.nombre;
    }

    public String obtenerNombre()
    {
        return this.nombre;
    }

}
