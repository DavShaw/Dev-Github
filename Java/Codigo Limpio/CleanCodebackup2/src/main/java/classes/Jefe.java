package classes;

import java.util.List;
import classes.Habitacion;
public class Jefe extends Persona implements Empresa
{
    
    
    public Jefe(String nombre)
    {
        super(nombre);
    }
    
    @Override
    public void anadirHabitacion(Casa casa, String nombreHabitacion, boolean crearNuevaFila)
    {

    if (casa != null && nombreHabitacion != null)
    {
        // Crear una nueva habitación con el nombre proporcionado
        Habitacion nuevaHabitacion = new Habitacion(nombreHabitacion);

        // Agregar la nueva habitación al plano de la casa
        casa.agregarNuevaHabitacion(nuevaHabitacion, crearNuevaFila);

        System.out.println("Se ha añadido una nueva habitación: " + nombreHabitacion);
    }
    
    else
    {
        System.out.println("No se pudo añadir la habitación. Datos inválidos.");
    }
}


                
    @Override
    public void decorarHabitacion()
    {
        System.out.println("Implementar :c");
    }
    
    @Override
    public void arreglarDaño()
    {
        System.out.println("Implementar uwu");
    }

    @Override
    public void ampliarArea()
    {
        System.out.println("Implementar :c");
    }
    
    public void asignarEquipo()
    {
        System.out.println("Implementar uwu");
    }
    
}