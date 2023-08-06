public class Person
{
    private void a()
    {
        
    }
    private String name;
    private BedRoom mainRoom;
    private Room currentRoom;
    private House currentHouse;
    private House itsOwnHouse;

    public Person(String name)
    {
        this.name = name;
    }

    public void joinHouse(House house)
    {
        this.currentHouse = house;
        this.setCurrentRoom(house.getRoomByName("LivingRoom"));
    }

    public Person(String name, House house)
    {
        this.name = name;
        this.currentHouse = house;
    }

    public House getItsOwnHouse()
    {
        return this.itsOwnHouse;
    }

    public void setItsOwnHouse(House house)
    {
        this.itsOwnHouse = house;
    }

    public House getCurrentHouse()
    {
        return this.currentHouse;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BedRoom getMainRoom()
    {
        return mainRoom;
    }

    public void setMainRoom(BedRoom room)
    {
        this.mainRoom = room;
    }

    public Room getCurrentRoom()
    {
        return this.currentRoom;
    }

    public String toString()
    {
        return this.name;
    }

    public House getHouse()
    {
        return this.currentHouse;
    }
    
    public void setCurrentRoom(Room room)
    {
        if (room == null)
        {
            this.currentRoom = null;
            this.currentHouse = null;
        }
        else if (this.currentRoom == null)
        {
            //Set person in current room
            this.currentRoom = room;

            //Set person in current house
            this.currentHouse = room.getHouse();
    
            //Add person to current room
            this.currentRoom.addPerson(this);
        }

        else
        {
            if (this.currentHouse.validateAdjacency(this.currentRoom, room))
            {
                //Delete person in current room
                this.currentRoom.removePerson(this);
                
                //Set person in current room
                this.currentRoom = room;
    
                //Set person in current house
                this.currentHouse = room.getHouse();
        
                //Add person to current room
                this.currentRoom.addPerson(this);
            }
            
            else
            {
                throw new IllegalArgumentException("The room is not adjacent to the current room");
            }
        }

    }
}