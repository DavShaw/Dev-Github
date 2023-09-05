package classes;

import java.util.ArrayList;
import java.util.List;

import errors.HabitacionNoExistente;
import errors.PersonaNoExiste;
import supportclasses.Color;
import supportclasses.supportclasses;

public class Casa
{

    @SuppressWarnings("unused")
    private Persona dueno;
    private List<Persona> personas = new ArrayList<>();
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<List<Habitacion>> plano = new ArrayList<>();

    public Casa(Persona dueno)
    {
        this.agregarNuevaFilaHabitaciones();
        this.dueno = dueno;
    }

    public void addHabitacop(Habitacion hab)
    {
        /*
         * El método por defecto añade la habitación en la fila número 0
        */
        this.addHabitacop(hab, 0);
    }

    public void addHabitacop(Habitacion hab, int Fila)
    {

        /*
         * El método recibe un objeto de tipo habitación y un entero el cuál será la fila de la habitación y lo 
         * añade a la lista de habitaciones y al plano en la fila especificada
        */
        this.habitaciones.add(hab);
        this.plano.get(Fila).add(hab);
    }

    public Persona obtenerPersona(String nombre)
    {
        /*
         * El método retorna un objeto de tipo persona SI y solo SI existe dentro de la casa
         * una persona con dicho nombre, caso contrario, genera una exception, la controla y retorna null
        */
        try
        {
            for (Persona persona : this.personas)
            {
                if (persona.obtenerNombre().equals(nombre))
                {
                    return persona;
                }
            }
            throw new PersonaNoExiste("La persona no existe.");
        }
        
        catch (PersonaNoExiste error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        
        return null;
        
    }


    public void verPlanos()
    {
        /*
         * Método el cual no retona nada, pero imprime en consola el plano de la casa
         * cada nueva linea representa el eje de las X y cada columna el eje de las Y
        */
        for (List<Habitacion> filaHabitaciones : this.plano)
        {
            System.out.println(filaHabitaciones);
        }

    }

    /*
    ! METODO ELIMINADO POR DAVID (Motivo: tal parece nunca lo usamos)

    public Integer obtenerMaxElementoFilaNoNulo(List<Habitacion> filaHab)
    {
        for (int i = 0; i < filaHab.size(); i++)
        {
            if (filaHab.get(i) == null)
            {
                return i-1;
            }
        }
        return 0;
    }
     */


    private Integer obtenerFilaHabitacion(Habitacion habitacion)
    {
        for (int i = 0; i < this.plano.size(); i++)
        {
            if (this.plano.get(i).contains(habitacion))
            {
                return i;
            }
        }
        return null;
    }

    public Integer obtenerMetrosHabitacion(Habitacion habitacion)
    {
        int indexLista = this.obtenerFilaHabitacion(habitacion);
        //Obtener lista que contiene hab
        List<Habitacion> listaHabitaciones = this.plano.get(indexLista);
        //Contar cuantos metros tiene la maldita habitacion
        int metros = 0;
        for (Habitacion hab : listaHabitaciones)
        {
            if (hab == habitacion)
            {
                metros++;
            }
        }
        return metros;
    }

    private int obtenerMaximaFila()
    {
        /*
         * Retorna la fila de mayor longitud del plano
        */
        return supportclasses.getLongerList(this.plano);
    }

    public void rellenarFilas()
    {
        /*
         * Itera sobre el plano y va rellenando de nulls todas las filas 
         * para que tengan la misma longitud de la fila más larga
         */

        int maximaFila = this.obtenerMaximaFila();

        for (List<Habitacion> filaHabitaciones : this.plano)
        {
            while (filaHabitaciones.size() < maximaFila)
            {
                filaHabitaciones.add(null);
            }
        }
    }

    public void eliminarNull()
    {
        /*
         * Itera sobre el plano y elimina todos los objetos de tipo null
         */
        int maximaFila = this.obtenerMaximaFila();

        for (List<Habitacion> filaHabitaciones : this.plano)
        {
            while (filaHabitaciones.size() >= maximaFila)
            {
                filaHabitaciones.remove(null);
            }
        }
    }

    public void anadirPersona(Persona persona)
    {
        /*
         * Agrega una persona a la lista de personas de la casa
         */
        this.personas.add(persona);
    }

    public void agregarNuevaFilaHabitaciones()
    {
        /*
         * Agrega una nueva fila de habitaciones al plano
         */
        this.plano.add(new ArrayList<Habitacion>());
    }


    public List<Habitacion> obtenerHabitaciones()
    {
        /*
         * Retorna la lista de habitaciones de la casa
         */
        return this.habitaciones;
    }

    public List<List<Habitacion>> obtenerPlano()
    {
        /*
         * Retorna el plano de la casa
         */
        return this.plano;
    }

    public List<Persona> obtenerPersonas()
    {
        /*
         * Retorna la lista de personas de la casa
         */
        return this.personas;
    }



    public void agregarNuevaHabitacion(Habitacion habitacion, int numeroDeFila)
    {
        /*
         * Agrega una nueva habitación al plano en la fila especificada
        */
        try
        {
            List<Habitacion> fila = this.plano.get(numeroDeFila);
            fila.add(habitacion);
            this.habitaciones.add(habitacion);
        }

        catch (IndexOutOfBoundsException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        
    }

    public Integer obtenerIndiceDeNullEnFila(List<Habitacion> listaHabitaciones)
    {
        /*
         * Honestamente, tenemos tantos métodos auxiliares que no sé que hacen...
         * No sé que hace
         */

        try
        {
            for (Habitacion habitacion : listaHabitaciones)
            {
                if (habitacion == null)
                {
                    return listaHabitaciones.indexOf(habitacion);
                }
            }
            return null;
        }

        catch (NullPointerException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        return null;

        
    }


    public void agregarNuevaHabitacion(Habitacion habitacion, Integer indiceNullEnFila)
    {
        /*
         * Añade una nueva habitación 
         */
        try
        {
            //Si esta variable NO es null significa que existe al menos un null en la fila (obtenemos el indice)
            //y reemplazamos el null por la habitación
            if (indiceNullEnFila != null)
            {
                List<Habitacion> fila = this.plano.get(0);
                fila.add(indiceNullEnFila, habitacion);
                this.habitaciones.add(habitacion);
            }
            else
            {
                List<Habitacion> fila = this.plano.get(0);
                fila.add(habitacion);
                this.habitaciones.add(habitacion);  
            }
        }

        catch (IndexOutOfBoundsException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        
    }



    /*
    ! Método eliminado por David (Motivo: nunca  se ha usado)

    public void eliminarNulosFila(List<Habitacion> filaHabitacion)
    {
        try
        {
            for (Habitacion habitacion : filaHabitacion)
            {
                if (habitacion == null)
                {
                    filaHabitacion.remove(habitacion);
                }
            }
        }

        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
    }
     */






    public void agregarNuevaHabitacion(Habitacion habitacion, int numeroDeFila, Integer indiceNullEnFila)
    {
        /*
         * Tenemos como 6 "AgregaNuevaHabitación" de buena que no sé que hace
         */
        try
        {
            //Si esto es NO es null, significa que existe al menos un null en la fila (obtenemos el indice)
            //y reemplazamos el null por la habitación
            if (indiceNullEnFila != null)
            {
                List<Habitacion> fila = this.plano.get(numeroDeFila);
                fila.set(indiceNullEnFila, habitacion);
                this.habitaciones.add(habitacion);
            }
            else
            {
                List<Habitacion> fila = this.plano.get(numeroDeFila);
                fila.add(habitacion);
                this.habitaciones.add(habitacion);  
            }
        }

        catch (IndexOutOfBoundsException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        
    }

    public Habitacion obtenerHabitacion(String nombre)
    {
        /*
         * Retorna un objeto de tipo habitación si y solo si existe una habitación con dicho nombre
         */
        try
        {
            for (Habitacion habitacion : this.habitaciones)
            {
                if (habitacion.obtenerNombre().equals(nombre))
                {
                    return habitacion;
                }
            }
            throw new HabitacionNoExistente("La habitación no existe.");
        }

        catch (HabitacionNoExistente error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch(NullPointerException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();  
        }
        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        return null;
    }

    public Integer obtenerNumeroDeFilaDeHabitacion(Habitacion habitacion)
    {
        /*
         * Parece ser un método auxiliar.
         * Retorna el indice de la fila en la cual se encuentra una habitación
         */
        try
        {
            for (List<Habitacion> fila : this.plano)
            {
                if (fila.contains(habitacion))
                {
                    return this.plano.indexOf(fila);
                }
            }
            throw new HabitacionNoExistente("La habitación no existe.");
        }

        catch (HabitacionNoExistente error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        return null;
    }

    public Integer obtenerIndiceDeHabitacionEnFila(Habitacion habitacion, List<Habitacion> fila)
    {
        /*
         * Dado una fila y una habitación intenta retonar el indice de esa habitación en la fila
         */
        try {
            for (Habitacion habitacionEnFila : fila) {
                if (habitacionEnFila == habitacion) {
                    return fila.indexOf(habitacionEnFila);
                }
            }
            throw new HabitacionNoExistente("La habitación no existe.");
        }
        
        catch (HabitacionNoExistente error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }


        return null;
    }
    

    public void agregarPersona(Persona persona)
    {
        /*
        * Agrega una persona a la lista de personas de la casa
        */ 
        personas.add(persona);  
    }

    public void eliminarPersona(Persona persona) { 
        /*
         * Elimina una persona de la lista de personas de la casa
        */
        personas.remove(persona);
    }

    public boolean hayPersonasEnListaHabitaciones(List<Habitacion> listaHabitaciones)
    {
        /*
         * Retorna true si y solo si hay al menos una persona en la lista de habitaciones
         */
        for (Habitacion habitacion : listaHabitaciones)
        {
            if (habitacion != null)
            {
                if (habitacion.obtenerPersonas().size() > 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Habitacion> validarAdyacencia(Habitacion habitacion)
    {
        /*
         * Retorna una lista de habitaciones adyacentes a la habitación dada
         */
        List<Habitacion> adyacentes = new ArrayList<>();
    
        Integer numeroDeFila = obtenerNumeroDeFilaDeHabitacion(habitacion);
        if (numeroDeFila == null) {
            return adyacentes;
        }
    
        List<Habitacion> filaActual = plano.get(numeroDeFila);
    
        Integer indiceHabitacion = obtenerIndiceDeHabitacionEnFila(habitacion, filaActual);
        if (indiceHabitacion == null) {
            return adyacentes;
        }
    
        // Verificar habitaciones adyacentes en la misma fila
        if (indiceHabitacion > 0) {
            adyacentes.add(filaActual.get(indiceHabitacion - 1));
        }
        
        if (indiceHabitacion < filaActual.size() - 1) {
            adyacentes.add(filaActual.get(indiceHabitacion + 1));
        }
    
        // Verificar habitaciones adyacentes en la fila anterior
        if (numeroDeFila > 0) {
            List<Habitacion> filaAnterior = plano.get(numeroDeFila - 1);
            if (indiceHabitacion < filaAnterior.size()) {
                adyacentes.add(filaAnterior.get(indiceHabitacion));
            }
        }
    
        // Verificar habitaciones adyacentes en la fila posterior
        if (numeroDeFila < plano.size() - 1) {
            List<Habitacion> filaPosterior = plano.get(numeroDeFila + 1);
            if (indiceHabitacion < filaPosterior.size()) {
                adyacentes.add(filaPosterior.get(indiceHabitacion));
            }
        }
    
        return adyacentes;
    }
    
    
    
}
    
    

