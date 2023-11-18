package classes;

public class Residente extends Persona
{
    private Habitacion HabitacionFavorita;

    public Residente(String nombre)
    {
        super(nombre);
    }

    public Residente(String nombre, Habitacion habitacionFavorita) {
        super(nombre);
        HabitacionFavorita = habitacionFavorita;
    }

    public Habitacion ObtenerHabitacionFavorita()
    {
        return HabitacionFavorita;
    }

    public void EstablecerHabitacionFavorita(String nombreHabitacion)
    {
        Casa casa = this.obtenerCasaActual();
        Habitacion habitacion = casa.obtenerHabitacion(nombreHabitacion);
        this.HabitacionFavorita = habitacion;
    }

    public Habitacion getHabitacionFavorita()
    {
        return HabitacionFavorita;
    }

    public Habitacion setHabitacionFavorita(Habitacion HabitacionFavorita)
    {
        this.HabitacionFavorita = HabitacionFavorita;
        return HabitacionFavorita;
    }


}
