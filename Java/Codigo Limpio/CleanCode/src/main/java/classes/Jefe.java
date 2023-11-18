package classes;

import java.util.*;

import supportclasses.MenuAlternativo;
import errors.DimensionesInvalidas;
import errors.HabitacionFavoritaNoDefinida;
import errors.HabitacionNoExistente;
import errors.ItemFuncional;
import errors.PersonaNoExiste;
import errors.PersonasEnHabitacionesAdyacentes;
import errors.PersonasEnLaHabitacion;
import errors.TrabajadorNoDisponible;
import interfaces.Empresa;
import supportclasses.Color;
import supportclasses.Console;
import supportclasses.supportclasses;

public class Jefe extends Persona implements Empresa
{

    @SuppressWarnings("uncheck")
    private List<Trabajador> equipo = new ArrayList<Trabajador>();
    private List<Trabajador> trabajadoresOcupados = new ArrayList<Trabajador>();
    private List<Trabajador> trabajadoresDisponibles = new ArrayList<Trabajador>();


    private Map<String, Integer> itemsDecorativos = new HashMap<>();
    private Map<String, Integer> itemsArreglados = new HashMap<>();
    private Map<String, Integer> itemMalos = new HashMap<>();

    private long facturaPendiente = 0;

    public Jefe(String nombre)
    {
        super(nombre);
    }


    public void verFactura()
    {
        System.out.println("La factura está en: " + String.valueOf(this.obtenerFacturaPendiente()));
    }

    @Override
    public void anadirHabitacion(String nombreHabitacion, int numeroDeFila)
    {
        /*
         * Añadir una habitación no requiera mas que un trabajador, adicional a eso, debemos cálculuar
         * el costo total, esto implica dos cosas:
         * 
         * Calcular trabajadores requeridos
         * Calcular tiempo requerido
         * 
        */
        this.actualizarEstadoTrabajadores();
        int costoHoraTrabajador = 40000;
        int trabajadoresRequeridos = 1;
        float tiempoRequerido = 1.5f;
        double costoDelTrabajo = trabajadoresRequeridos * costoHoraTrabajador * (tiempoRequerido);

        try
        {

            //Validar si hay al menos un trabajador disponible
            if ((this.trabajadoresDisponibles.isEmpty()))
            {
                throw new TrabajadorNoDisponible("No hay trabajadores disponibles");
            }

            //Si existe al menos un trabajador disponible lo asignamos a esta labor
            Trabajador trabajador = this.trabajadoresDisponibles.get(0);
            trabajador.ocupar(10);

            //Añadir el costo de la labor 
            this.anadirCostosFactura(costoDelTrabajo);

            Casa casa = this.obtenerCasaActual();
            Integer indiceNull = casa.obtenerIndiceDeNullEnFila(casa.obtenerPlano().get(numeroDeFila));

            casa.agregarNuevaHabitacion(new Habitacion(nombreHabitacion), numeroDeFila, indiceNull);
            casa.rellenarFilas();
        }

        catch (NullPointerException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (IndexOutOfBoundsException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (TrabajadorNoDisponible error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

    }

    public List<Trabajador> obtenerEquipo()
    {
        return this.equipo;
    }

    public List<Trabajador> obtenerTrabajadoresDesocupado()
    {
        this.actualizarEstadoTrabajadores();
        return this.obtenerTrabajadoresDesocupado();
    }

    public List<Trabajador> obtenerTrabajadoresOcupado()
    {
        this.actualizarEstadoTrabajadores();
        return this.obtenerTrabajadoresOcupado();
    }

    private void actualizarEstadoTrabajadores()
    {
        this.trabajadoresDisponibles = new ArrayList<>();

        for (Trabajador trabajador : this.equipo)
        {
            //Esta disponible
            if (trabajador.disponible() == true)
            {
                this.trabajadoresDisponibles.add(trabajador);
                this.trabajadoresOcupados.remove(trabajador);
            }
            else
            {
                this.trabajadoresOcupados.add(trabajador);
                this.trabajadoresDisponibles.remove(trabajador);
            }
        }

    }

    private void anadirCostosFactura(double costo)
    {
        this.facturaPendiente += costo;
    }

    @Override
    public void anadirHabitacion(String nombreHabitacion)
    {
        this.anadirHabitacion(nombreHabitacion, 0);
    }

    @Override
    public void decorarHabitacion(String nombreResidente)
    {

        //Obtener a la persona
        Residente residente = (Residente) (this.obtenerCasaActual().obtenerPersona(nombreResidente));

        

        this.actualizarEstadoTrabajadores();
        @SuppressWarnings("unused")
        Integer trabajadoresRequeridos = 1;
        try {
            //Validar si hay al menos un trabajador disponible
            if ((this.trabajadoresDisponibles.isEmpty()))
            {
                throw new TrabajadorNoDisponible("No hay trabajadores disponibles");
            }

            //Validar que si haya un residente con dicho nombre
            if (residente == null)
            {
                throw new PersonaNoExiste("No existe un residente con dicho nombre");
            }
            //Obtener habitación de la persona
            Habitacion habitacion = residente.getHabitacionFavorita();

            //Validar que la habitación no sea nula
            if (habitacion == null)
            {
                throw new HabitacionFavoritaNoDefinida("La habitación favorita no está denifida.");
            }

            //Ocupar al trabajador
            Trabajador trabajador = this.trabajadoresDisponibles.get(0);
            trabajador.ocupar(10);
            //Añadir el valor de la operación a factura total
            this.anadirCostosFactura(40000 * 10);


            Item item = new Item(true);
            //Aqui se imprime el diccionario con los precios por si lo quieres quitar
            item.mostrarListaDePrecios();
            @SuppressWarnings("unused")
            Casa casa = this.obtenerCasaActual();
            @SuppressWarnings("unused")
            Habitacion habitacionFavorita = residente.getHabitacionFavorita();

            System.out.print("Selecciona ítems de la lista para decorar la habitación (escribe '0' para terminar): ");
            item.randomizar_Estado();

            String seleccion = supportclasses.input().nextLine();
            Map<String, Integer> listaDePrecios = item.getListaDePrecios();
            System.out.println("El estado del objeto " + item.ObtenerEstadoObjeto());

                if (seleccion.equalsIgnoreCase("0"))
                {
                    String msg = Color.color("MAGENTA", "Decoración cancelada");
                    System.out.println(msg);
                }


                else if (listaDePrecios.containsKey(seleccion) && item.ObtenerEstadoObjeto().equals(true))
                {
                    itemsDecorativos.put(seleccion, listaDePrecios.get(seleccion));
                    habitacion.agregarObjetoDecorativo(seleccion, listaDePrecios.get(seleccion)); // Agregar al diccionario de la habitación
                    System.out.println("Se ha agregado " + seleccion + " a la decoración de la habitación.");
                }
                
                else if (listaDePrecios.containsKey(seleccion) && item.ObtenerEstadoObjeto().equals(false))
                {
                    System.out.println("El item Seleccionado esta defectuoso-- revisar reparaciones");
                    itemMalos.put(seleccion, listaDePrecios.get(seleccion));
                    habitacion.agregarImtemDanados(seleccion, listaDePrecios.get(seleccion)); // Agregar al diccionario de la habitación

                } else
                {
                    System.out.println("El ítem seleccionado no está en la listag");
                }

        } catch (NullPointerException error) {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();

        } catch (TrabajadorNoDisponible error) {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        } catch (HabitacionFavoritaNoDefinida error) {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        } catch (PersonaNoExiste error) {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

    }

    @Override
    public void arreglarDaño(String nombreHabitación)

    {

        //Falta implementar que solo muestre los items que están malos para que seleccione el residente
        //O que solo le muestre otra lista/Diccionario con los items malos

        this.actualizarEstadoTrabajadores();
        @SuppressWarnings("unused")
        Integer trabajadoresRequeridos = 1;
        try {

            //Obtener habitación
            Habitacion habitacion = this.obtenerCasaActual().obtenerHabitacion(nombreHabitación);

            //Validar si hay al menos un trabajador disponible
            if ((this.trabajadoresDisponibles.isEmpty()))
            {
                throw new TrabajadorNoDisponible("No hay trabajadores disponibles");
            }

            //Validar que la habitación no sea nula
            if (habitacion == null)
            {
                throw new HabitacionNoExistente("La habitación no existe");
            }

            System.out.println(habitacion.getListaItemDanados());

            //Ocupar al trabajador
            Trabajador trabajador = this.trabajadoresDisponibles.get(0);
            trabajador.ocupar(10);
            //Añadir el valor de la operación a factura total
            this.anadirCostosFactura(40000 * 10);


            Item item = new Item(true);

            //Aqui se imprime el diccionario con las reparaciones
            item.mostrarListaReparaciones();
            @SuppressWarnings("unused")
            Casa casa = this.obtenerCasaActual();

            System.out.print("Selecciona ítems de la lista para decorar la habitación (escribe '0' para terminar): ");
            String seleccion = supportclasses.input().nextLine();
            Map<String, Integer> listaDeReparaciones = item.getListaDeReparaciones();

            if (seleccion.equalsIgnoreCase("0"))
            {
                String msg = Color.color("MAGENTA", "Decoración cancelada");
                System.out.println(msg);
            }

            else if (habitacion.getListaItemDanados().isEmpty())
            {
                throw new ItemFuncional("Los items de esta habitación funcionan perfectamente");
            }
            else if (!habitacion.getListaItemDanados().containsKey(seleccion))
            {
                throw new ItemFuncional("El item ingresado no está dañado en la habitación");
            }

            else if (listaDeReparaciones.containsKey(seleccion))
            {
                itemsArreglados.put(seleccion, listaDeReparaciones.get(seleccion));
                habitacion.agregarItemArreglar(seleccion, listaDeReparaciones.get(seleccion)); // Agregar al diccionario de la habitación
                System.out.println("Se ha agregado " + seleccion + " a los item arreglados");
                habitacion.getListaItemDanados().remove(seleccion);
            }

            else
            {
                System.out.println("El ítem seleccionado no está en la lista.");
            }

        } catch (NullPointerException error) {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();

        } catch (TrabajadorNoDisponible error) {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        } catch (HabitacionNoExistente error) {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
        catch (ItemFuncional error) {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

    }
    
    public void asignarEquipo(Trabajador... trabajador)
    {
        for (Trabajador trabajador2 : trabajador)
        {
            this.equipo.add(trabajador2);
        }
    }

    @Override
    public void anadirFilaHabitaciones()
    {
        try
        {
            Casa casa = this.obtenerCasaActual();
            casa.agregarNuevaFilaHabitaciones();
        }

        catch (NullPointerException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
    }

    @Override
    public void entrarEnCasa(Casa casa)
    {
        this.establecerCasaActual(casa);
    }

    private void ampliar(List<Habitacion> listaHabitaciones, int posicion, int numeroAmpliar)
    {
        try
        {
            if (posicion < 0 || posicion > listaHabitaciones.size())
            {
                throw new IndexOutOfBoundsException("El indice de la habitación no es válido");
            }

            Habitacion habitacionActual = listaHabitaciones.get(posicion);

            for (int i = 0; i < numeroAmpliar; i++)
            {
                listaHabitaciones.add(posicion, habitacionActual);
            }
        }

        catch (IndexOutOfBoundsException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

    }

    @Override
    public void ampliarHabitacion(String nombreHabitacion, int metrosCuadrados)
    {

        this.actualizarEstadoTrabajadores();
        int tiempoTotal = metrosCuadrados;
        int trabajadoresTotales = supportclasses.redondearTrabajadores(metrosCuadrados);
        double costoTotal = 40000 * trabajadoresTotales * tiempoTotal;
        Casa casa = this.obtenerCasaActual();
        Habitacion habitacion = casa.obtenerHabitacion(nombreHabitacion);
        List<Habitacion> habitacionesAdyacentes = casa.validarAdyacencia(habitacion);

        try
        {
            if (casa.hayPersonasEnListaHabitaciones(habitacionesAdyacentes))
            {
                throw new PersonasEnHabitacionesAdyacentes("Hay personas en las habitaciones adyacentes");
            }

            if (habitacion.obtenerPersonas().size() > 0)
            {
                throw new PersonasEnLaHabitacion("Hay personas en la habitación");
            }

            if (metrosCuadrados <= 0)
            {
                throw new IllegalArgumentException("El número de metros cuadrados no puede ser negativo ni 0");
            }

            if (this.trabajadoresDisponibles.size() < trabajadoresTotales)
            {
                throw new TrabajadorNoDisponible("No hay suficientes trabajadores disponibles");
            }

            // Ocupar a los trabajadores
            for(int i = 0; i < trabajadoresTotales; i++)
            {
                Trabajador trabajadorIterando = this.trabajadoresDisponibles.get(i);
                trabajadorIterando.ocupar(tiempoTotal);
            }

            // Obtener numero de fila de habitación
            Integer numeroFila = casa.obtenerNumeroDeFilaDeHabitacion(habitacion);

            // Obtener fila con el numero de fila
            List<Habitacion> fila = casa.obtenerPlano().get(numeroFila);

            // Obtener indice de habitación
            Integer indiceHabitacion = casa.obtenerIndiceDeHabitacionEnFila(habitacion, fila);

            if (indiceHabitacion == fila.size() - 1)
            {
                for (int i = 0; i < metrosCuadrados; i++)
                {
                    fila.add(habitacion);
                }
            }

            else
            {
                this.ampliar(fila, indiceHabitacion, metrosCuadrados);
            }
            casa.rellenarFilas();

            this.anadirCostosFactura(costoTotal);

        }

        catch (NullPointerException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (TrabajadorNoDisponible error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (IllegalArgumentException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (PersonasEnHabitacionesAdyacentes error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (PersonasEnLaHabitacion error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

    }

    public double obtenerFacturaPendiente()
    {
        return this.facturaPendiente;
    }

    public void establecerFacturaPendiente(double dinero)
    {
        this.facturaPendiente = (long) dinero;
    }

    public void reducirHabitacion(String nombreHabitacion, int metrosCuadrados)
    {


        this.actualizarEstadoTrabajadores();
        int tiempoTotal = metrosCuadrados;
        int trabajadoresTotales = supportclasses.redondearTrabajadores(metrosCuadrados);
        double costoTotal = 40000 * trabajadoresTotales * tiempoTotal;

        try
        {
            if (metrosCuadrados <= 0)
            {
                throw new DimensionesInvalidas("El número de metros cuadrados no puede ser negativo ni 0");
            }

            if (this.trabajadoresDisponibles.size() < trabajadoresTotales)
            {
                throw new TrabajadorNoDisponible("No hay suficientes trabajadores disponibles");
            }

            // Ocupar a los trabajadores
            for(int i = 0; i < trabajadoresTotales; i++)
            {
                Trabajador trabajadorIterando = this.trabajadoresDisponibles.get(i);
                trabajadorIterando.ocupar(tiempoTotal);
            }

            // Obtener casa
            Casa casa = this.obtenerCasaActual();

            // Obtener habitacion
            Habitacion habitacion = casa.obtenerHabitacion(nombreHabitacion);
            
            //Longitud de la hab 
            int longitudHabitacion = casa.obtenerMetrosHabitacion(habitacion);
            //2da condición dimensiones inválidas
            if (metrosCuadrados >= longitudHabitacion)
            {
                throw new DimensionesInvalidas("El número de metros cuadrados no puede ser mayor a la longitud de la habitación");
            }

            if (habitacion == null)
            {
                throw new HabitacionNoExistente("La habitación no existe");
            }
            // Obtener numero de fila de habitación
            Integer numeroFila = casa.obtenerNumeroDeFilaDeHabitacion(habitacion);

            // Obtener fila con el numero de fila
            List<Habitacion> fila = casa.obtenerPlano().get(numeroFila);

            //Reduce los metros cuadrados pedidos
            if (casa.obtenerIndiceDeHabitacionEnFila(habitacion, fila) != -1) {
                int cantidadActual = Collections.frequency(fila, habitacion);
                int cantidadAReducir = Math.min(metrosCuadrados, cantidadActual - 1);

                for (int i = 0; i < cantidadAReducir; i++) {
                    fila.remove(habitacion);
                    casa.eliminarNull();
                }
            }
            else
            {
                System.out.println("No se puede reducir al punto de eliminar la habitacion");
            }

            //Añade el costo aunque no se pueda reducir mas la habitacion solucionar
            this.anadirCostosFactura(costoTotal);

        }

        catch (NullPointerException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (TrabajadorNoDisponible error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (DimensionesInvalidas error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch (HabitacionNoExistente error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

    }

    private void imprimirMenu()
    {
        Console.spaces(2);
        System.out.println("1. Añadir habitación"); //Implementado
        System.out.println("2. Añadir fila habitacion"); //Implementado
        System.out.println("3. Ampliar habitación"); //Implementado
        System.out.println("4. Decorar habitación"); //Implementado
        System.out.println("5. Arreglar daño"); //No implementado
        System.out.println("6. Reducir habitacion"); //No implementado
        System.out.println("7. Ver factura"); //Implementado
        System.out.println("8. Ver plano"); //Implementado
        System.out.println("9. Ver equipo"); //Implementado
        System.out.println(Color.color("Magenta","99. MENÚ ALTERNATIVO"));
        System.out.println("0. Salir");
        Console.spaces(2);
    }

    private void menuOpcion1()
    {
        Console.clear();
        System.out.print("Ingrese el nombre de la habitación: ");
        String nombreHabitacion = supportclasses.input().nextLine();
        System.out.print("Ingrese el número de fila: ");
        int numeroFila = supportclasses.input().nextInt();
        this.anadirHabitacion(nombreHabitacion, numeroFila);
        String msg = Color.color("yellow", "Habitación añadida con éxito");
        System.out.println(msg);
    }

    private void menuOpcion2()
    {
        Console.clear();
        this.anadirFilaHabitaciones();
        String msg = Color.color("yellow", "Fila añadida con éxito");
        System.out.println(msg);
    }

    private void menuOpcion3()
    {
        Console.clear();
        System.out.print("Ingrese el nombre de la habitación: ");
        String nombreHabitacion = supportclasses.input().nextLine();
        System.out.print("Ingrese el número de metros cuadrados: ");
        int metrosCuadrados = supportclasses.input().nextInt();
        this.ampliarHabitacion(nombreHabitacion, metrosCuadrados);
        String msg = Color.color("yellow", "Habitación ampliada con éxito");
        System.out.println(msg);
    }

    private void menuOpcion4()
    {
        Console.clear();
        System.out.print("Ingrese el nombre del residente: ");
        String nombreResidente = supportclasses.input().nextLine();
        
        System.out.print("Ingrese la cantidad de objetos a añadir: ");
        int cantidadObjetos = supportclasses.input().nextInt();
        
        for (int i = 0; i < cantidadObjetos; i++)
        {
            this.decorarHabitacion(nombreResidente);
        }

        String msg = Color.color("yellow", "Habitación decorada con éxito");
        System.out.println(msg);
    }

    private void menuOpcion5()
    {
        Console.clear();
        System.out.print("Ingrese el nombre de la habitación: ");
        String nombreHabitacion = supportclasses.input().nextLine();
        this.arreglarDaño(nombreHabitacion);

    }

    public void menuOpcion6()
    {
        Console.clear();
        System.out.print("Ingrese el nombre de la habitación: ");
        String nombreHabitacion = supportclasses.input().nextLine();
        System.out.print("Ingrese el nombre de la habitación: ");
        int metros = supportclasses.input().nextInt();
        this.reducirHabitacion(nombreHabitacion, metros);
    }

    private void menuOpcion7()
    {
        Console.clear();
        System.out.println(Color.color("Yellow", "La factura tiene un valor total de: ") + Color.color("Green",String.valueOf(this.obtenerFacturaPendiente())));
    }

    private void menuOpcion8()
    {
        Console.clear();
        Casa casa = this.obtenerCasaActual();
        System.out.println(Color.color("cyan", "======================================="));
        Console.spaces(1);
        casa.rellenarFilas();
        casa.verPlanos();
        Console.spaces(1);
        System.out.println(Color.color("cyan", "======================================="));

    }

    private void menuOpcion9()
    {
        Console.clear();
        System.out.println(Color.color("cyan","El equipo de construcción es:"));
        for (Trabajador trabajador : this.equipo)
        {
            System.out.println(Color.color("red", "* ") + Color.color("green", trabajador.obtenerNombre()));
        }
    }

    public void menu()
    {
        
        do
        {
            this.imprimirMenu();
            System.out.println("\n\n");
            System.out.print("Ingrese una opción: ");
            int respuesta = supportclasses.input().nextInt();
            
            switch (respuesta)
            {
                
                case 0:
                    return;

                case 1:
                    this.menuOpcion1();
                    break;
                
                case 2:
                    this.menuOpcion2();
                    break;

                case 3:
                    this.menuOpcion3();
                    break;

                case 4:
                    this.menuOpcion4();
                    break;

                case 5:
                    this.menuOpcion5();
                    break;
                case 6:
                    this.menuOpcion6();
                    break;

                case 7:
                    this.menuOpcion7();
                    break;

                case 8:
                    this.menuOpcion8();
                    break;

                case 9:
                    this.menuOpcion9();
                    break;

                case 99:
                    MenuAlternativo.menu(this);
                    break;
                
                default:
                    break;
            }
        }
        
        while (true);
    }



    public Map<String, Integer> getItemsDecorativos() {
        return itemsDecorativos;
    }


 }