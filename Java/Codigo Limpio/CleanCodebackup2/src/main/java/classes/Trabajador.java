
package classes;

public class Trabajador extends Persona implements Empresa

    {
    
    public Trabajador(String nombre)
    {
        super(nombre);
    }
    
    @Override
    public void anadirHabitacion(Casa casa, String nombreHabitacion, boolean crearNuevaFila)
    {
        System.out.println("Implementar como utilizaria el meotdo");
    }

    @Override
    public void ampliarArea()
    {
        System.out.println("Implementar como utilizaria el meotdo");
    }

    @Override
    public void decorarHabitacion()
    {
        System.out.println("Implementar como utilizaria el meotdo");
    }

    @Override
    public void arreglarDaño()
    {
        System.out.println("Implementar como utilizaria el meotdo");
    }
    
    
}

    
