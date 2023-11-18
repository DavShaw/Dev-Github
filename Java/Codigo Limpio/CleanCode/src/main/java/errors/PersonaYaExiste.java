package errors;

public class PersonaYaExiste extends Exception
{
    public PersonaYaExiste(String mensaje)
    {
        super(mensaje);
    }
}
