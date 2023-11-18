package errors;

public class PersonaNoExiste extends Exception
{
    public PersonaNoExiste(String mensaje)
    {
        super(mensaje);
    }
}
