import java.util.ArrayList;
import java.util.List;

public abstract class Room
{
    private String name;
    private House house;
    private Integer x;
    private Integer y;
    private List<Person> peopleInRoom = new ArrayList<>();

    public Room(String name)
    {
        this.name = name;
    }

    public Room(String name, House house)
    {
        this.name = name;
        this.house = house;
    }
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void addPerson(Person person)
    {
        peopleInRoom.add(person);
    }

    public void removePerson(Person person)
    {
        peopleInRoom.remove(person);
    }

    public List<Person> peopleInTheRoom()
    {
        return this.peopleInRoom;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setX(Integer x)
    {
        this.x = x;
    }

    public void setY(Integer y)
    {
        this.y = y;
    }

    public String toString()
    {
        return this.name;
    }

    public House getHouse()
    {
        return this.house;
    }

    public void setHouse(House house)
    {
        this.house = house;
    }

    private void a()
    {
        
    }
    protected void removeAllPersons()
    {
        for (Person person : peopleInRoom)
        {
            person.setCurrentRoom(null);
        }
        this.peopleInTheRoom().clear();
    }


}