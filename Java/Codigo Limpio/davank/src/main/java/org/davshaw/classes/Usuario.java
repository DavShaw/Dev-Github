package org.davshaw.classes;

import java.rmi.NoSuchObjectException;
import java.util.List;

public class Usuario
{

    private Davank banco;
    
    private List<Grupo> grupos;

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreCompleto;

    private int dni;

    private String contraseña;

    private double dinero;
    private Cuenta cuenta;

    public Usuario(Davank banco, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int dni, String contraseña)
    {
        this.banco = banco;

        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompleto = String.format("%s %s %s %s", this.primerNombre, this.segundoNombre, this.primerApellido, this.segundoApellido);
    
        this.dni = dni;

        this.contraseña = contraseña;

        //? Crear cuenta
        this.cuenta = new Cuenta(this);

    }

    public String nombre()
    {
        return this.nombreCompleto;
    }

    public void cambiarNombre(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido)
    {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompleto = String.format("%s %s %s %s", this.primerNombre, this.segundoNombre, this.primerApellido, this.segundoApellido);
        
    }

    public int dni()
    {
        return this.dni;
    }

    public void cambiarContraseña(String contraseña)
    {
        try
        {
            //Si la contraseña no es correcta
            if(!(this.contraseñaCorrecta(contraseña)))
            {
                throw new IllegalArgumentException("Las credentiales ingresadas no son válidas.");
            }
            else
            {
                this.contraseña = contraseña;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void depositarEnCuenta(double monto)
    {
        this.cuenta.depositar(monto);
    }

    public void retirarEnCuenta(double monto)
    {
        this.cuenta.retirar(monto);
    }

    public void depositarEnBolsillo(double monto)
    {
        this.dinero += monto;
    }

    public void retirarEnBolsillo(double monto)
    {
        try
        {
            if(this.suficienteDineroPara(monto))
            {
                this.dinero -= monto;
            }
            else
            {
                throw new IllegalArgumentException("El monto supera el saldo actual.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void depositarEnGrupo(Grupo grupo, double monto)
    {
        try
        {
            //Si la persona no pertenece a ese grupo
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public double dinero()
    {
        return this.dinero;
    }

    public Cuenta cuenta()
    {
        return this.cuenta;
    }

    public void cambiarCuenta(Cuenta cuenta)
    {
        this.cuenta = cuenta;
    }

    public void entrarGrupo(Grupo grupo)
    {
        try
        {
            if (this.grupos.size() < 3)
            {
                this.grupos.add(grupo);
            }
            else
            {
                throw new IndexOutOfBoundsException("Ya estás en la cantidad máxima de grupos permitidos.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void salirGrupo(Grupo grupo)
    {
        try
        {
            if (this.grupos.contains(grupo))
            {
                this.grupos.remove(grupo);
            }
            else
            {
                throw new NoSuchObjectException("No estás en este grupo.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean suficienteDineroPara(double monto)
    {
        return this.dinero >= monto;
    }

    private boolean perteneceAlGrupo(String nombreGrupo)
    {
        return false;
    }

    private boolean contraseñaCorrecta(String contraseña)
    {
        return contraseña.equals(this.contraseña);
    }
    
}
