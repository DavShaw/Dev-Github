package main;


import classes.Casa;
import classes.Jefe;
import classes.Persona;
import classes.Propietario;
import classes.Residente;
import classes.Trabajador;
import supportclasses.MenuAlternativo;

public class App
{
    public static void main(String[] args)
    {
        Trabajador alfonso = new Trabajador("Alfonso");
        Trabajador beto = new Trabajador("Beto");
        Trabajador carlos = new Trabajador("Carlos");
        Trabajador diana = new Trabajador("Diana");
        Trabajador eduardo = new Trabajador("Eduardo");
        Trabajador fernanda = new Trabajador("Fernanda");
        Trabajador gerardo = new Trabajador("Gerardo");
        Trabajador hilda = new Trabajador("Hilda");
        Trabajador irene = new Trabajador("Irene");
        Trabajador juan = new Trabajador("Juan");
        Trabajador a = new Trabajador("a");
        Trabajador b = new Trabajador("b");
        Trabajador c = new Trabajador("c");
        Trabajador d = new Trabajador("d");
        @SuppressWarnings("unused")
        Trabajador pepito = new Trabajador("pepito");
        
        //Creando Item
        Propietario andres = new Propietario("Andres", 2.0f);

        Residente cardenas = new Residente("Cardenas");
        @SuppressWarnings("unused")
        Residente magola = new Residente("Magola");
        @SuppressWarnings("unused")
        Residente david = new Residente("David");

        Casa ksa = new Casa(andres);
        Jefe boss = new Jefe("Pepe");

        boss.asignarEquipo
        (alfonso,
        beto,
        fernanda,
        diana,
        gerardo,
        juan,
        carlos,
        hilda,
        eduardo,
        a,
        b,
        c,
        d,
        irene);

        boss.entrarEnCasa(ksa);
        boss.anadirHabitacion("Cine");
        boss.anadirHabitacion("Pool");
        boss.anadirHabitacion("Cocina");


        david.entrarEnCasa(ksa);
        magola.entrarEnCasa(ksa);
        cardenas.entrarEnCasa(ksa);

        david.moverse("Cine");
        magola.moverse("Cocina");
        cardenas.EstablecerHabitacionFavorita("Cine");
        cardenas.moverse("Cine");

        boss.menu();



    }
    
}