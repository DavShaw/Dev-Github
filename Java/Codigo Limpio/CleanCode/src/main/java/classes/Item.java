package classes;
import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class Item {
     private Boolean EstadoObjeto;
     private Map<String,Integer> ListaDeReparaciones;
    
     public void randomizar_Estado() {
        int random = (int) (Math.random() * 2); 
        if (random == 0) {
            this.EstadoObjeto = true; //Objeto bueno
        } else {
            this.EstadoObjeto = false; //Objeto Malo
      }
     }
    
    public Item(Boolean estadoObjeto, Map<String, Integer> listaDeReparaciones) {
        EstadoObjeto = estadoObjeto;
        ListaDeReparaciones = listaDeReparaciones;
        ListaDeReparaciones= new HashMap<String,Integer>();
        ListaDeReparaciones.put("Mesa", 14);
        ListaDeReparaciones.put("Cuadro", 2);
        ListaDeReparaciones.put("Adorno", 5);
        ListaDeReparaciones.put("Television", 40);
        ListaDeReparaciones.put("Sofa", 20);
        ListaDeReparaciones.put("Libro", 4);
        ListaDeReparaciones.put("Juguete", 7);
        ListaDeReparaciones.put("Silla", 10);
        ListaDeReparaciones.put("Cojin", 2);
        ListaDeReparaciones.put("Archivador", 9);
        
        //En principio queria que solamente recibiera la clave de el diccionario ListaObjetosAdquiribles y 
        //el valor del mismo diccionario y le sacara el 20% y ese fuera la reparacion.
        //Pero no pude porque esta en la clase Habitacion que abstracta y no me permite hacer eso
    }

    public Boolean ObtenerEstadoObjeto() {
        return EstadoObjeto;
    }

    public void EstablecerEstadoObjeto(Boolean estadoObjeto) {
        EstadoObjeto = estadoObjeto;
    }

}

