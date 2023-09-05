package classes;

import java.util.ArrayList;
import java.util.List;

import errors.CasaNoDefinida;
import errors.CasaSinHabitaciones;
import errors.HabitacionNoExistente;
import errors.PersonaNoExiste;
import errors.PersonaYaExiste;
import supportclasses.Color;

public abstract class Persona
{
    private static List<Persona> personasInstanciadas = new ArrayList<Persona>();

    private String nombre;
    private Casa casaActual;
    private Habitacion habitacionActual;

    public Persona(String nombre)
    {
        try
        {
            if (!verificarValidez(nombre))
            {
                throw new PersonaYaExiste("Ya existe una persona con este nombre." + Color.color("CYAN", nombre));
            }
            this.nombre = nombre;
            personasInstanciadas.add(this);
        }
        catch(PersonaYaExiste error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        } 
    }

    private Boolean verificarValidez(String nombre)
    {
        /*
        * Verifica que no exista una persona con ese mismo nombre 
        */
        for (Persona persona : personasInstanciadas)
        {
            if (persona.obtenerNombre().equals(nombre))
            {
                return false;
            }
        }
        return true;
    }


    public static List<Persona> obtenerPersonasInstanciadas()
    {
        return personasInstanciadas;
    }


    public static Persona obtenerPersonaPorNombre(String nombre)
    {
        try
        {
            for (Persona persona : personasInstanciadas)
            {
                if (persona.obtenerNombre().equals(nombre))
                {
                    return persona;
                }
            }
            throw new PersonaNoExiste("No existe una persona con este nombre");
        }

        catch(PersonaNoExiste error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        return null; 

    }


    public void moverse(String nombreHabitacion) //Metodo para moverse a otra habitacion , tiene excepciones.
   {
    try
    {
        if (casaActual == null)
        {
            if (casaActual == null)
            {
                throw new CasaNoDefinida("La persona no está dentro de una casa.");
            }

            this.habitacionActual.eliminarPersona(this);

            Habitacion nuevaHabitacion = casaActual.obtenerHabitacion(nombreHabitacion);
            this.habitacionActual = nuevaHabitacion;
            this.habitacionActual.agregarPersona(this);
        }

        Habitacion nuevaHabitacion = casaActual.obtenerHabitacion(nombreHabitacion);

        if (nuevaHabitacion == null)
        {
            throw new HabitacionNoExistente("La habitación no existe.");
        }

        if (habitacionActual != null)
        {
            habitacionActual.eliminarPersona(this);
        }
        nuevaHabitacion.agregarPersona(this);
        
        this.habitacionActual = nuevaHabitacion;
    }
    catch (Exception error)
    {
        System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
        error.printStackTrace();
    }
}

  

    public Casa obtenerCasaActual()
    {
        try
        {
            if(this.casaActual == null)
            {
                throw new CasaNoDefinida("La persona no está dentro de una casa.");
            }
            return this.casaActual;
        }
        catch (CasaNoDefinida error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
            return null;
        }
        
    }




    public String obtenerNombre()
    {
        return this.nombre;
    }





    @Override
    public String toString()
    {
        return this.nombre;
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
                casaActual.anadirPersona(this);
                this.habitacionActual = CASA.obtenerHabitaciones().get(0);
            }
        }

        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
    }

    public Habitacion obtenerHabitacionActual()
    {
        return this.habitacionActual;
    }

    public void establecerCasaActual(Casa casa)
    {
        this.casaActual = casa;
    }

    public void salirDeCasa()
    {
        this.casaActual = null;
    }


}
