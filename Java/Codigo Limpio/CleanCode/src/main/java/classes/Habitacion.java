package classes;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Habitacion
{
    private String nombre;
    private Map<String, Integer> listaDeObjetosHabitacion = new HashMap<>();
    private List<Persona> personas = new ArrayList<>();
            
    private Map<String, Integer> listaDeItemMalos = new HashMap<>();
    private Map<String, Integer> listaItemDanados = new HashMap<>();


    public Habitacion(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return this.nombre;
    }


    public List<Persona> obtenerPersonas()
    {
        return this.personas;
    }


    public String obtenerNombre()
    {
        return this.nombre;
    }


    public void agregarPersona(Persona persona)
    {
        this.personas.add(persona);
    }

    public void eliminarPersona(Persona persona)
    {
        this.personas.remove(persona);
    }


    public Map<String, Integer> getListaDeObjetosHabitacion()
    {
        return listaDeObjetosHabitacion;
    }

    public void agregarObjetoDecorativo(String nombreItem, int precio)
    {
        listaDeObjetosHabitacion.put(nombreItem, precio);
    }
    public void agregarItemArreglar(String nombreItem, int precio)
    {
        listaDeItemMalos.put(nombreItem, precio);
    }
    public void setListaDeObjetosHabitacion(Map<String, Integer> listaDeObjetosHabitacion)
    {
        this.listaDeObjetosHabitacion = listaDeObjetosHabitacion;
    }

    public void agregarImtemDanados(String nombreItem, int precio)
    {
        listaItemDanados.put(nombreItem, precio);
    }

    //Getters y setter diccionario de arreglos
    public Map<String, Integer> getListaObjetosArreglados()
    {
        return listaDeItemMalos;
    }

    public void setListaObjetosArreglados(Map<String, Integer> listaObjetosArreglados)
    {
        this.listaDeItemMalos = listaObjetosArreglados;
    }

    public Map<String, Integer> getListaItemDanados() {
        return listaItemDanados;
    }


    public void setListaItemDanados(Map<String, Integer> listaItemDanados) {
        this.listaItemDanados = listaItemDanados;
    }


    public void ObtenerMalosBuenos()
    {
        //Llenar listas
    }
}

