package classes;

public class Propietario extends Persona
{
    
    private Habitacion habitacionFavorita;
    private float dinero;
    public Propietario(String nombre, float dinero)
    {
        super(nombre);
        this.dinero = dinero;
    }

    public Habitacion obtenerHabitacionFavorita()
    {
        return this.habitacionFavorita;
    }

    public void establecerHabitacionFavorita(Habitacion habitacionFavorita)
    {
        this.habitacionFavorita = habitacionFavorita;
    }

    public float obtenerDinero()
    {
        return this.dinero;
    }

    public void establecerDinero(float dinero)
    {
        this.dinero = dinero;
    }

}