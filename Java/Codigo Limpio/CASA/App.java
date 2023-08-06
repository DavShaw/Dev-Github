public class App
{
public static void main(String code[])
{

    //Crear personas
    Person DAVID = new Person("David");
    Person JUAN = new Person("Juan");
    Person PEDRO = new Person("Pedro");
    Person SOFIA = new Person("Sofia");

    //Crear casas
    House casa = new House(DAVID,5);
    House casa2 = new House(JUAN,5);

    System.out.println("David está en: " + DAVID.getCurrentRoom());
    casa.showPlans();
    DAVID.setCurrentRoom(casa.getRoomByName("Kitchen"));
    System.out.println("David está en: " + DAVID.getCurrentRoom());
    System.out.println("xd");

}

private void a()
    {
        
    }
}