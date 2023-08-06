import java.util.ArrayList;
import java.util.List;


public class House
{
    private void a()
    {
        
    }

    private List<Room> rooms = new ArrayList<>();
    private List<List<Room>> plan = new ArrayList<>();
    @SuppressWarnings("unused")
    private int HouseSize;
    @SuppressWarnings("unused")
    private Person owner;

    public House(Person owner, int HouseSize)
    {
        this.owner = owner;
        owner.setItsOwnHouse(this);

        BedRoom bedroom = new BedRoom("BedRoom");
        Kitchen kitchen = new Kitchen("Kitchen");
        LivingRoom livingroom = new LivingRoom("LivingRoom");

        this.generatePlan(HouseSize);

        this.addRoom(0, 0, bedroom);
        this.addRoom(0,1,kitchen);
        this.addRoom(0,2,livingroom);

        owner.setMainRoom(bedroom);
        owner.setCurrentRoom(bedroom);

    }

    public House(int HouseSize)
    {
        BedRoom bedroom = new BedRoom("BedRoom");
        Kitchen kitchen = new Kitchen("Kitchen");
        LivingRoom livingroom = new LivingRoom("LivingRoom");

        this.generatePlan(HouseSize);

        this.addRoom(0, 0, bedroom);
        this.addRoom(0,1,kitchen);
        this.addRoom(0,2,livingroom);

    }

    public Person getOwner()
    {
        return this.owner;
    }

    public List<Room> getRooms()
    {
        return this.rooms;
    }

    public Room getRoomByName(String roomName)
    {
        for (Room room : this.rooms)
        {
            if(room.getName().equals(roomName))
            {
                return room;
            }
        }

        return null;
    }
    
    public void showPeopleInRoom()
    {
        System.out.println("#------------------------------#");
        for (Room room : this.rooms)
        {
            System.out.println(String.format("People in room %s", room.getName()));
            for (Person person : room.peopleInTheRoom())
            {
                System.out.println(String.format("    -> %s", person.getName()));
            }
        }
        System.out.println("#------------------------------#");
    }

    private void generatePlan(int size)
    {
        List<List<Room>> plan = new ArrayList<>();

        for (int i = 0; i < size; i++)
        {
            List<Room> rooms = new ArrayList<>();
            for (int j = 0; j < size; j++)
            {
                rooms.add(null);
            }
            plan.add(rooms);
        }
        this.plan = plan;
    }

    public void addRoom(int x, int y, Room room)
    {

        if (x >= this.plan.size() || y >= this.plan.size())
        {
            String error = String.format("Invalid coords for x or y. Out of the range (Max -> x: %s y: %s)",this.plan.size() - 1,this.plan.size() - 1);
            throw new IllegalArgumentException(error);
        }

        else
        {
            if (this.plan.get(x).get(y) != null)
            {
                String error = String.format("There is already a room in this coords (x: %s y: %s)",x,y);
                throw new IllegalArgumentException(error);
            }

            else
            {
                this.rooms.add(room);
                room.setHouse(this);
                room.setX(x);
                room.setY(y);
                this.plan.get(x).set(y,room);
            }
        }
            
    }


    public void removeRoom(int x, int y)
    {
        Room room = this.plan.get(x).get(y);
        if (this.rooms.contains(room))
        {
            room.setX(null);
            room.setY(null);
            room.setHouse(null);
            room.removeAllPersons();
            this.rooms.remove(room);
        }

        this.plan.get(x).set(y,null);
    }

    public void showPlans()
    {
        for (List<Room> list : this.plan)
        {
            System.out.println(list);
        }
    }

    public List<List<Room>> getPlans()
    {
        return this.plan;
    }

    public boolean validateAdjacency(Room room1, Room room2)
    {
        List<List<Room>> plan = this.getPlans();
        
        /*
        ! Checking edges for up left edge
        */
        if (room1.getX() == 0 && room1.getY() == 0)
        {
            //Checking down adjacency 
            if (room2.getX() == 1 && room2.getY() == 0)
            {
                return true;
            }

            //Check right adjacency
            else if (room2.getX() == 0 && room2.getY() == 1)
            {
                return true;
            }
        }

        /*
        ! Checking edges for up right edge
        */
        
        else if ((room1.getX() == 0) && (room1.getY() == plan.size() - 1))
        {
            //Checking down adjacency
            if (room2.getX() == 1 && room2.getY() == plan.size() - 1)
            {
                return true;
            }

            //Checking left adjacency
            else if (room2.getX() == 0 && room2.getY() == plan.size() - 2)
            {
                return true;
            }
        }

        /*
        ! Checking edges for down left edge
        */
        else if (room1.getX() == plan.size() - 1 && room1.getY() == 0)
        {
            //Checking up adjacency
            if (room2.getX() == plan.size() - 2 && room2.getY() == 0)
            {
                return true;
            }

            //Checking right adjacency
            else if (room2.getX() == plan.size() - 1 && room2.getY() == 1)
            {
                return true;
            }
        }

        /*
        ! Checking edges for down right edge
        */
        else if (room1.getX() == plan.size() - 1 && room1.getY() == plan.size() - 1)
        {
            //Checking up adjacency
            if (room2.getX() == plan.size() - 2 && room2.getY() == plan.size() - 1)
            {
                return true;
            }

            //Checking left adjacency
            else if (room2.getX() == plan.size() - 1 && room2.getY() == plan.size() - 2)
            {
                return true;
            }
        }

        /*
        ! Checking left vertically adjacent
        */
        else if (room1.getY() == 0)
        {
            //Checking up adjacency
            if (room2.getX() == room1.getX() - 1 && room2.getY() == 0)
            {
                return true;
            }

            //Checking right adjacency
            else if (room2.getX() == room1.getX() && room2.getY() == 1)
            {
                return true;
            }

            //Checking down adjacency
            else if (room2.getX() == room1.getX() + 1 && room2.getY() == 0)
            {
                return true;
            }
        }

        /*
        ! Checking right vertically adjacent
        */
        else if (room1.getY() == plan.size() - 1)
        {
            //Checking up adjacency
            if (room2.getX() == room1.getX() - 1 && room2.getY() == plan.size() - 1)
            {
                return true;
            }

            //Checking left adjacency
            else if (room2.getX() == room1.getX() && room2.getY() == plan.size() - 2)
            {
                return true;
            }

            //Checking down adjacency
            else if (room2.getX() == room1.getX() + 1 && room2.getY() == plan.size() - 1)
            {
                return true;
            }
        }

        /*
        ! Checking up horizontally adjacent
        */
        else if (room1.getX() == 0)
        {
            //Checking left adjacency
            if (room2.getX() == room1.getX() && room2.getY() == room1.getY() - 1)
            {
                return true;
            }

            //Checking right adjacency
            else if (room2.getX() == room1.getX() && room2.getY() == room1.getY() + 1)
            {
                return true;
            }

            //Checking down adjacency
            else if (room2.getX() == room1.getX() + 1 && room2.getY() == room1.getY())
            {
                return true;
            }
        }

        /*
        ! Check down horizontally adjacent
        */

        else if (room1.getX() == plan.size() -1)
        {
            //Checking left adjacency
            if (room2.getX() == room1.getX() && room2.getY() == room1.getY() - 1)
            {
                return true;
            }

            //Checking right adjacency
            else if (room2.getX() == room1.getX() && room2.getY() == room1.getY() + 1)
            {
                return true;
            }

            //Checking up adjacency
            else if (room2.getX() == room1.getX() - 1 && room2.getY() == room1.getY())
            {
                return true;
            }
        }

        else if (room1.getX() != 0 && room1.getX() != plan.size() -1 && room1.getY() != 0 && room1.getY() != plan.size() -1)
        {
            //Checking up adjacency
            if (room2.getX() == room1.getX() - 1 && room2.getY() == room1.getY())
            {
                return true;
            }

            //Checking left adjacency
            else if (room2.getX() == room1.getX() && room2.getY() == room1.getY() - 1)
            {
                return true;
            }

            //Checking right adjacency
            else if (room2.getX() == room1.getX() && room2.getY() == room1.getY() + 1)
            {
                return true;
            }

            //Checking down adjacency
            else if (room2.getX() == room1.getX() + 1 && room2.getY() == room1.getY())
            {
                return true;
            }
        }

        return false;
    }

}
