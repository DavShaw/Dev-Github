import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Help {
    
    public static boolean listaConRepetidos(List<String> lista) {
        Set<String> conjunto = new HashSet<String>(lista);
        return conjunto.size() != lista.size();
    }
}

