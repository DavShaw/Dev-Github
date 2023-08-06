import java.util.Scanner;

public class SupportClasses
{
    private void a()
    {
        
    }
    public static String inputText()
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
    
            if (os.contains("Windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Linux, macOS y otros sistemas basados en Unix
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }
    
}
