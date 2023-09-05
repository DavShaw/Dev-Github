package supportclasses;

import classes.Casa;
import classes.Jefe;
import classes.Persona;
import classes.Residente;
import classes.Trabajador;

public class MenuAlternativo
{
    
    /*
    ! Opciones del menú
    * 1. Agregar un nuevo trabajador
    * 2. Agregar un nuevo residente
    * 3. Entrar casa (OJO)
    * 4. Mover residente (OJO)
    * 5. Asignar habitación favorita
    */

    

    public static void imprimirMenu()
    {
        Console.spaces(2);
        System.out.println("1. Agregar un nuevo trabajador");
        System.out.println("2. Agregar un nuevo residente");
        System.out.println("3. Entrar casa");
        System.out.println("4. Mover residente");
        System.out.println("5. Asignar habitación favorita"); 
        System.out.println("6. Ver personas instanciadas"); 
        System.out.println(Color.color("Magenta","0. VOLVER MENÚ JEFE"));
        Console.spaces(2);
    }

    public static void menu(Jefe jefe)
    {
        Casa casa = jefe.obtenerCasaActual();
        
        do
        {
            imprimirMenu();
            System.out.println("\n\n");
            System.out.print("Ingrese una opción: ");
            int respuesta = supportclasses.input().nextInt();
            
            switch (respuesta)
            {
                
                case 0:
                    jefe.menu();
                    break;

                case 1:
                    menuAlternativoOpcion1(jefe);
                    break;
                
                case 2:
                    menuAlternativoOpcion2();
                    break;

                case 3:
                    menuAlternativoOpcion3(casa);
                    break;

                case 4:
                    menuAlternativoOpcion4(casa);
                    break;

                case 5:
                    menuAlternativoOpcion5(casa);
                    break;
                case 6:
                    menuAlternativoOpcion6();
                    break;
                
                default:
                    break;
            }
        }
        
        while (true);
    }




    public static void menuAlternativoOpcion1(Jefe jefe)
    {
        Console.clear();
        /*
         * Éste método estático se encarga de agregar un nuevo trabajador al equipo del jefe
         */

         try
         {
            /*
             * Instanciar un nuevo trabajador
             */
            System.out.print("Ingrese el nombre del trabajador: ");
            String nombreTrabajdor = supportclasses.input().nextLine();

            Trabajador trabajador = new Trabajador(nombreTrabajdor);
            jefe.asignarEquipo(trabajador);
         }

         catch(NullPointerException error)
         {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
         }

    }



    public static void menuAlternativoOpcion2()
    {
        Console.clear();
        /*
        * Éste método estático se encarga de agregar un nuevo residente
        */   

        try
         {
            /*
             * Instanciar un nuevo residente
             */

            System.out.print("Ingrese el nombre del residente: ");
            String nombreResidente = supportclasses.input().nextLine();

             Residente residente = new Residente(nombreResidente);
         }

         catch(NullPointerException error)
         {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
         }
    }

    public static void menuAlternativoOpcion3(Casa casa)
    {
        Console.clear();
        try
        {
            System.out.print("Ingrese el nombre del residente: ");
            String nombreResidente = supportclasses.input().nextLine();
            Residente residente = (Residente) Persona.obtenerPersonaPorNombre(nombreResidente);
            residente.entrarEnCasa(casa);
        }

        catch(NullPointerException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
    }

    public static void menuAlternativoOpcion4(Casa casa)
    {
        Console.clear();
        try
        {

            System.out.print("Ingrese el nombre del residente: ");
            String nombreResidente = supportclasses.input().nextLine();

            System.out.print("Ingrese el nombre de la habitación: ");
            String nombreHabitacion = supportclasses.input().nextLine();

            Residente residente = (Residente) Persona.obtenerPersonaPorNombre(nombreResidente);
            residente.moverse(nombreHabitacion);
        }
        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
    }

    public static void menuAlternativoOpcion5(Casa casa)
    {
        Console.clear();
        try
        {

            System.out.print("Ingrese el nombre del residente: ");
            String nombreResidente = supportclasses.input().nextLine();

            System.out.print("Ingrese el nombre de la habitación: ");
            String nombreHabitacion = supportclasses.input().nextLine();

            Residente residente = (Residente) Persona.obtenerPersonaPorNombre(nombreResidente);
            residente.EstablecerHabitacionFavorita(nombreHabitacion);
        }
        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
    }

    public static void menuAlternativoOpcion6()
    {
        Console.clear();
        try
        {
            System.out.println(Persona.obtenerPersonasInstanciadas());
           
        }
        catch (Exception error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
    }
    
    
}
