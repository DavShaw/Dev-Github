package classes;

import Errores.CasaNoDefinida;
import Errores.CasaSinHabitaciones;

public abstract class Persona
{
    @SuppressWarnings("unused")
    private String nombre;
    private Casa casaActual;
    private Habitacion habitacionActual;

    public Persona(String nombre)
    {
        this.nombre = nombre;
    }

    public void moverse(String nombreHabitacion)
    {
        try
        {
            if (casaActual == null)
            {
                throw new CasaNoDefinida("La persona no está dentro de una casa.");
            }

            Habitacion nuevaHabitacion = casaActual.obtenerHabitacion(nombreHabitacion);
            this.habitacionActual = nuevaHabitacion;

        } catch (Exception error)
        {
            System.err.println("Ocurrió un error: " + error.getMessage());
            error.printStackTrace();
        }
    }
    

    public Casa obtenerCasaActual()
    {
        return this.casaActual;
    }




















    public void entrarEnCasa(Casa CASA)
    {
        try
        {
            if (CASA.obtenerHabitaciones().isEmpty())
            {
                throw new CasaSinHabitaciones("La casa no tiene habitaciones.");
            }

            else
            {
                this.casaActual = CASA;
                this.habitacionActual = CASA.obtenerHabitaciones().get(0);
            }
        }

        catch (Exception error)
        {
            System.err.println("Ocurrió un error: " + error.getMessage());
            error.printStackTrace();
        }
    }

























    public Habitacion obtenerHabitacionActual()
    {
        return this.habitacionActual;
    }

    public void salirDeCasa()
    {
        this.casaActual = null;
    } 

}
