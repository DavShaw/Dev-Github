package main;

import classes.Casa;
import classes.Jefe;
import classes.Propietario;

public class App
{
    public static void main(String[] args)
    {

       /* Propietario david = new Propietario("David", null);
        Casa casita = new Casa(david);

        casita.verPlanos(); */
        
                // Crear una instancia de Casa
        Propietario andres = new Propietario("Andres", null);
        Casa casa1 = new Casa(andres);
        
        Jefe jefe1 = new Jefe("Pepe");
        
        
        jefe1.anadirHabitacion(casa1, "cocina", true);

        //jefe1.anadirhabitacion(casa, cocina, fila: 1)

        jefe1.anadirHabitacion(casa1, "Sala", true);
        jefe1.anadirHabitacion(casa1, "sala2", false);
        casa1.verPlanos();

    }
}