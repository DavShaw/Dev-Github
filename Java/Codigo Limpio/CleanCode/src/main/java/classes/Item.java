package classes;
import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class Item {
     private Boolean EstadoObjeto;
     //private Map<String,Integer> ListaDeReparaciones;
     //private Map<String, Integer> ListaDePrecios;
     private Map<String, Map<String, Integer>> Listado;
     
     public void randomizar_Estado()
     {
        int random = (int) (Math.random() * 2); 
        if (random == 0) {
            this.EstadoObjeto = true; //Objeto bueno
        } else {
            this.EstadoObjeto = false; //Objeto Malo
      }
     }
    
    public Item(Boolean estadoObjeto) {
        
        EstadoObjeto = estadoObjeto;
        Listado = new HashMap<String, Map<String, Integer>>();
        
        Map<String, Integer> listaDePrecios = new HashMap<>();
        listaDePrecios.put("Mesa", 28);
        listaDePrecios.put("Cuadro", 4);
        listaDePrecios.put("Adorno", 10);
        listaDePrecios.put("Television", 80);
        listaDePrecios.put("Sofa", 40);
        listaDePrecios.put("Libro", 8);
        listaDePrecios.put("Juguete", 14);
        listaDePrecios.put("Silla", 20);
        listaDePrecios.put("Cojin", 4);
        listaDePrecios.put("Archivador", 18);
        
        Map<String, Integer> listaDeReparaciones = new HashMap<>();
        listaDeReparaciones.put("Mesa", Math.floorDiv(listaDePrecios.get("Mesa"), 2));
        listaDeReparaciones.put("Cuadro", Math.floorDiv(listaDePrecios.get("Cuadro"), 2));
        listaDeReparaciones.put("Adorno", Math.floorDiv(listaDePrecios.get("Adorno"), 2));
        listaDeReparaciones.put("Television", Math.floorDiv(listaDePrecios.get("Television"), 2));
        listaDeReparaciones.put("Sofa", Math.floorDiv(listaDePrecios.get("Sofa"), 2));
        listaDeReparaciones.put("Libro", Math.floorDiv(listaDePrecios.get("Libro"), 2));
        listaDeReparaciones.put("Juguete", Math.floorDiv(listaDePrecios.get("Juguete"), 2));
        listaDeReparaciones.put("Silla", Math.floorDiv(listaDePrecios.get("Silla"), 2));
        listaDeReparaciones.put("Cojin", Math.floorDiv(listaDePrecios.get("Cojin"), 2));
        listaDeReparaciones.put("Archivador", Math.floorDiv(listaDePrecios.get("Archivador"), 2));
        
        Listado.put("ListaDeReparaciones", listaDeReparaciones);
        Listado.put("ListaDePrecios", listaDePrecios);
        //En principio queria que solamente recibiera la clave de el diccionario ListaObjetosAdquiribles y 
        //el valor del mismo diccionario y le sacara el 20% y ese fuera la reparacion.
        //Pero no pude porque esta en la clase Habitacion que abstracta y no me permite hacer eso
    }
       
    public Boolean ObtenerEstadoObjeto()
    {
        return EstadoObjeto;
    }

    public void EstablecerEstadoObjeto(Boolean estadoObjeto)
    {
        EstadoObjeto = estadoObjeto;
    }
    
    public void mostrarListaDePrecios()
    {
        
        System.out.println("Lista de Precios:");
        Map<String, Integer> listaDePrecios = Listado.get("ListaDePrecios");
        int contador = 1;
        
        for (Map.Entry<String, Integer> entry : listaDePrecios.entrySet()) {
            String item = entry.getKey();
            int precio = entry.getValue();
            
            System.out.println(contador + ". " + item + ": $" + precio);
            contador ++;
        }
    }
    public void mostrarListaReparaciones()
    {

        System.out.println("Lista de Reparaciones:");
        Map<String, Integer> listaDeReparaciones = Listado.get("ListaDeReparaciones");
        int contador = 1;

        for (Map.Entry<String, Integer> entry : listaDeReparaciones.entrySet()) {
            String item = entry.getKey();
            int precio = entry.getValue();

            System.out.println(contador + ". " + item + ": $" + precio);
            contador ++;
        }
    }
    
    //Getter y Setters
    public void setEstadoObjeto(Boolean EstadoObjeto)
    {
        this.EstadoObjeto = EstadoObjeto;
    }

    public Map<String, Map<String, Integer>> getListado()
    {
        return Listado;
    }

    public void setListado(Map<String, Map<String, Integer>> Listado)
    {
        this.Listado = Listado;
    }
    
    public Map<String, Integer> getListaDePrecios()
    {
        return Listado.get("ListaDePrecios");
    }

    public Map<String, Integer> getListaDeReparaciones()
    {
        return Listado.get("ListaDeReparaciones");
    }

    
}
