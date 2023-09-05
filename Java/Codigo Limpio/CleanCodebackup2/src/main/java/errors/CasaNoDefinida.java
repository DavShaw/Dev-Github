package Errores;

public class CasaNoDefinida extends Exception
{
    public CasaNoDefinida(String mensaje)
    {
        super(mensaje);
    }
}