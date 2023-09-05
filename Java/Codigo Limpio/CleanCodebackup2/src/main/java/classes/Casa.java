package classes;

import java.util.ArrayList;
import java.util.List;

import Errores.HabitacionNoExistente;
import supportClasses.supportclasses;

public class Casa
{
    @SuppressWarnings("unused")
    private Persona dueno;
    private List<Persona> personas;
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<List<Habitacion>> plano = new ArrayList<>();

    public Casa(Persona dueno)
    {
        this.agregarNuevaFilaHabitaciones();
        this.dueno = dueno;
    }

    public void addHabitacop(Habitacion hab)
    {
        //Por defecto lo añade a la fila #0
        this.habitaciones.add(hab);
        this.plano.get(0).add(hab);
    }

    public void addHabitacop(Habitacion hab, int Fila)
    {

        //Lo añade en la fila especificada
        this.habitaciones.add(hab);
        this.plano.get(Fila).add(hab);
    }

    public void verPlanos()
    {
        for (List<Habitacion> filaHabitaciones : this.plano)
        {
            System.out.println(filaHabitaciones);
        }

    }

    private int obtenerMaximaFila()
    {
        return supportclasses.getLongerList(this.plano);
    }

    private void rellenarFilas()
    {
        int maximaFila = this.obtenerMaximaFila();

        for (List<Habitacion> filaHabitaciones : this.plano)
        {
            while (filaHabitaciones.size() < maximaFila)
            {
                filaHabitaciones.add(null);
            }
        }
    }

    public void agregarNuevaFilaHabitaciones()
    {
        this.plano.add(new ArrayList<Habitacion>());
        this.rellenarFilas();
    }

    public Habitacion obtenerHabitacion(String nombreHabitacion)
    {

        try
        {
            // Intentar obtener la habitacion por su nombre
            for (Habitacion habitacion : habitaciones)
            {
                if (habitacion.obtenerNombre().equals(nombreHabitacion))
                {
                    return habitacion;
                }    
            }
    
            // Si no se encuentra la habitacion, lanzar la excepción
            throw new HabitacionNoExistente("La habitación no existe.");

        }

        catch (Exception error)
        {
            System.err.println("Ocurrió un error: " + error.getMessage());
            error.printStackTrace();
            return null;
        }
    }


    
    

    public List<Habitacion> obtenerHabitaciones()
    {
        return this.habitaciones;
    }

    public List<Persona> obtenerPersonas()
    {
        return this.personas;
    }
}
