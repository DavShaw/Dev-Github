package classes;

public class Residente extends Persona
{
    Habitacion HabitacionFavorita;

    public Residente(String nombre)
    {
        super(nombre);
    }

    public Habitacion ObtenerHabitacionFavorita()
    {
        return HabitacionFavorita;
    }

    public void EstablecerHabitacionFavorita(Habitacion habitacionFavorita)
    {
        HabitacionFavorita = habitacionFavorita;
    }

 
}
