package OOP.Vehicles;

import java.util.Arrays;
import java.util.List;

public class Main
{

    public static void Jump(int jumps)
    {
        for(int i = 0; i < jumps; i++)
        {
            System.out.println("");
        }
    }

    public static void main(String[] args)
    {

        //1. Let's make vehicles
        Vehicle v1 = new Vehicle("Audi", "AC1", 45500);
        Vehicle v2 = new Vehicle("Toyota", "TM15s", 12000);
        Vehicle v3 = new Vehicle("Chevrolet", "CE51", 9600);

        //2. Insert vehicles into the list
        List<Vehicle> VehicleList = Arrays.asList(v1,v2,v3);

        //3. Tryin to find the cheapest vehicle
            //3.1. Controler
            Vehicle MCV = VehicleList.get(0);
        for (Vehicle car : VehicleList)
        {
            if (car.getPrice() < MCV.getPrice())
            {
                MCV = car;
            }
        }

        //4. Print most cheap car vehicle
        System.out.println(MCV.toString());

    }

}
