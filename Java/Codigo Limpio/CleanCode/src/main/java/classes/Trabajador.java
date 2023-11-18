
package classes;

import interfaces.Empresa;
import java.time.LocalTime;

public class Trabajador extends Persona implements Empresa
{

    private boolean disponible;
    private LocalTime ocupadoHasta;
    private String nombre;
    public Trabajador(String nombre)
    {
        super(nombre);
        this.nombre = nombre;
        this.ocupadoHasta = LocalTime.now();
        this.disponible = true;
    }

    @Override
    public void decorarHabitacion(String nombreResidente) {
        System.out.println("Implementar como utilizaria el meotdo");
    }

    @Override
    public void arreglarDaño(String nombreResidente) {
        System.out.println("Implementar como utilizaria el meotdo");
    }

    @Override
    public void anadirHabitacion(String nombreHabitacion, int numeroDeFila) {
        System.out.println("Implementar como utilizaria el meotdo");
    }

    @Override
    public void anadirHabitacion(String nombreHabitacion) {
        System.out.println("Implementar como utilizaria el meotdo");
    }

    @Override
    public void anadirFilaHabitaciones() {
        System.out.println("Implementar como utilizaria el meotdo");
    }

    @Override
    public void ampliarHabitacion(String nombreHabitacion, int metrosCuadrados)
    {
        throw new UnsupportedOperationException("Unimplemented method 'ampliarHabitacion'");
    }

    public void ocupar(Integer tiempo)
    {
        LocalTime horaActual = LocalTime.now();
        this.ocupadoHasta = horaActual.plusSeconds(tiempo);
    }

    public LocalTime obtenerHoraDeDisponibilidad()
    {
        return this.ocupadoHasta;
    }

    public boolean disponible()
    {
        LocalTime ahora = LocalTime.now();
        if (this.ocupadoHasta.isBefore(ahora))
        {
            this.disponible = true;
            return this.disponible;
        }
        this.disponible = false;
        return this.disponible;
    }

    @Override
    public String toString()
    {
        return this.nombre;
    }

}
