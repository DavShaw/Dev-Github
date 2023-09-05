package classes;

import errors.DineroInsuficiente;
import supportclasses.Color;

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

    public void pagarFactura(Jefe jefe)
    {
        try
        {
            if (this.dinero < jefe.obtenerFacturaPendiente())
            {
                throw new DineroInsuficiente("No tienes suficiente dinero para pagar la factura");
            }

            else
            {
                double deudaTotal = jefe.obtenerFacturaPendiente();

                //Pagar
                jefe.establecerFacturaPendiente(0);

                //Retirar dinero al propietario
                this.dinero -= deudaTotal;
            }
        }

        catch(NullPointerException error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch(NoSuchMethodError error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }

        catch(DineroInsuficiente error)
        {
            System.err.println(Color.color("RED", "Ocurrió un error: ") + error.getMessage());
            error.printStackTrace();
        }
    }

    public void establecerDinero(float dinero)
    {
        this.dinero = dinero;
    }

}