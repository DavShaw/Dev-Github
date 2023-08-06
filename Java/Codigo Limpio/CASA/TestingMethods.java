import java.util.List;

public class TestingMethods
{
    // Create people
    static Person david = new Person("David");
    // Create house
    static House house = new House(david,4);
    static Room a = house.getRoomByName("BedRoom");
    static Room b = house.getRoomByName("Kitchen");
    static Room c = house.getRoomByName("LivingRoom");
    static BedRoom d = new BedRoom("D");
    static BedRoom e = new BedRoom("E");
    static BedRoom f = new BedRoom("F");
    static BedRoom g = new BedRoom("G");
    static BedRoom h = new BedRoom("H");
    static BedRoom i = new BedRoom("I");
    static BedRoom j = new BedRoom("J");
    static BedRoom k = new BedRoom("K");
    static BedRoom l = new BedRoom("L");
    static BedRoom m = new BedRoom("M");
    static BedRoom n = new BedRoom("N");
    static BedRoom o = new BedRoom("O");
    static BedRoom p = new BedRoom("P");
    static BedRoom q = new BedRoom("Q");
    static BedRoom r = new BedRoom("R");
    static BedRoom s = new BedRoom("S");



    private void a()
    {
        
    }


    public static boolean validateAdjacency(Room room1, Room room2)
    {
        List<List<Room>> plan = house.getPlans();
        
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










    public static void main(String[] args)
    {

        a.setName("A");
        b.setName("B");
        c.setName("C");

        house.addRoom(0, 3, d);
        house.addRoom(1,0, e);
        house.addRoom(1, 1, f);
        house.addRoom(1, 2, g);
        house.addRoom(1, 3, h);
        house.addRoom(2, 0, i);
        house.addRoom(2, 1, j);
        house.addRoom(2, 2, k);
        house.addRoom(2, 3, l);
        house.addRoom(3, 0, m);
        house.addRoom(3, 1, n);
        house.addRoom(3, 2, o);
        house.addRoom(3, 3, p);


        SupportClasses.clearConsole();
        house.showPlans();
        System.out.println("1" +validateAdjacency(a,b));
        System.out.println("2" +validateAdjacency(b,a));
        System.out.println("3" +validateAdjacency(b,c));
        System.out.println("4" +validateAdjacency(c,b));
        System.out.println("5" +validateAdjacency(c,d));
        System.out.println("6" +validateAdjacency(d,c));
        System.out.println("7" +validateAdjacency(a,e));
        System.out.println("8" +validateAdjacency(e,a));
        System.out.println("9" +validateAdjacency(b,f));
        System.out.println("10" +validateAdjacency(f,b));
        System.out.println("11" +validateAdjacency(c,g));
        System.out.println("12" +validateAdjacency(g,c));
        System.out.println("13" +validateAdjacency(d,h));
        System.out.println("14" +validateAdjacency(h,d));
        System.out.println("15" +validateAdjacency(m,n));
        System.out.println("16" +validateAdjacency(n,m));
        System.out.println("17" +validateAdjacency(n,o));
        System.out.println("18" +validateAdjacency(o,n));
        System.out.println("19" +validateAdjacency(o,p));
        System.out.println("20" +validateAdjacency(p,o));
        System.out.println("21" +validateAdjacency(n,j));
        System.out.println("22" +validateAdjacency(j,n));
        System.out.println("23" +validateAdjacency(o,k));
        System.out.println("24" +validateAdjacency(k,o));
        System.out.println("25" +validateAdjacency(l,p));
        System.out.println("26" +validateAdjacency(p,l));
        System.out.println("27" +validateAdjacency(k,g));
        System.out.println("28" +validateAdjacency(k,j));
        System.out.println("29" +validateAdjacency(k,o));
        System.out.println("30" +validateAdjacency(k,l));
    }

}
