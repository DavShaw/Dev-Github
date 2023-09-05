package interfaces;


public interface Empresa
{
    public void anadirHabitacion(String nombreHabitacion);
    public void anadirHabitacion(String nombreHabitacion, int numeroDeFila);
    public void ampliarHabitacion(String nombreHabitacion, int metrosCuadrados);
    public void anadirFilaHabitaciones();
    public void decorarHabitacion(String nombreResidente);
    public void arreglarDaño(String nombreResidente);
}
