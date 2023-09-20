package org.davshaw.main;

import org.davshaw.autos.Car;
import org.davshaw.autos.Register;
import org.davshaw.autos.User;
import org.davshaw.resources.CarLinkedList.CarLinkedList;
import org.davshaw.resources.RegisterLinkedList.RegisterLinkedList;
import org.davshaw.resources.userLinkedList.UserLinkedList;

public class Main {
    public static void main(String[] args)
    {

        //Crear listas enlazadas
        UserLinkedList users = new UserLinkedList();
        CarLinkedList cars = new CarLinkedList();
        RegisterLinkedList registers = new RegisterLinkedList();

        //Crear usuarios y añadirlos a una lista enlazada (users)
        User u1 = new User("John Doe", "john.doe@example.com", 123456, 987654);
        User u2 = new User("Alice Smith", "alice.smith@example.com", 789012, 345678);
        User u3 = new User("Bob Johnson", "bob.johnson@example.com", 456789, 987654);
        User u4 = new User("Mary Brown", "mary.brown@example.com", 987654, 123456);
        User u5 = new User("Michael Davis", "michael.davis@example.com", 345678, 876543);
        User u6 = new User("Sophia Lee", "sophia.lee@example.com", 654321, 234567);
        User u7 = new User("David Wang", "david.wang@example.com", 567890, 765432);
        User u8 = new User("Emma Johnson", "emma.johnson@example.com", 876543, 654321);
        User u9 = new User("Daniel Kim", "daniel.kim@example.com", 210987, 789012);
        User u10 = new User("Olivia Taylor", "olivia.taylor@example.com", 543210, 345678);

        users.addNodeAtTail(u1);
        users.addNodeAtTail(u2);
        users.addNodeAtTail(u3);
        users.addNodeAtTail(u4);
        users.addNodeAtTail(u5);
        users.addNodeAtTail(u6);
        users.addNodeAtTail(u7);
        users.addNodeAtTail(u8);
        users.addNodeAtTail(u9);
        users.addNodeAtTail(u10);

        //Crear carros y añadirlos a una lista enlazada (cars)
        Car c1 = new Car("Mazda", "6", 2000, 30.0);
        Car c2 = new Car("Toyota", "Corolla", 2020, 50.0);
        Car c3 = new Car("Honda", "Civic", 2019, 55.0);
        Car c4 = new Car("Ford", "Mustang", 2018, 70.0);
        Car c5 = new Car("Chevrolet", "Camaro", 2017, 65.0);
        Car c6 = new Car("BMW", "X5", 2019, 80.0);
        Car c7 = new Car("Audi", "A4", 2021, 60.0);
        Car c8 = new Car("Nissan", "Altima", 2019, 55.0);
        Car c9 = new Car("Kia", "Sportage", 2020, 45.0);
        Car c10 = new Car("Hyundai", "Elantra", 2022, 40.0);

        cars.addNodeAtTail(c1);
        cars.addNodeAtTail(c2);
        cars.addNodeAtTail(c3);
        cars.addNodeAtTail(c4);
        cars.addNodeAtTail(c5);
        cars.addNodeAtTail(c6);
        cars.addNodeAtTail(c7);
        cars.addNodeAtTail(c8);
        cars.addNodeAtTail(c9);
        cars.addNodeAtTail(c10);

        //Crear registros y añadirlos a una lista enlazada (registers)
        Register r1 = new Register(u1, c1);
        Register r2 = new Register(u2, c2);
        Register r3 = new Register(u3, c3);
        Register r4 = new Register(u4, c4);
        Register r5 = new Register(u5, c5);
        Register r6 = new Register(u6, c6);
        Register r7 = new Register(u7, c7);
        Register r8 = new Register(u8, c8);
        Register r9 = new Register(u9, c9);
        Register r10 = new Register(u10, c10);

        registers.addNodeAtTail(r1);
        registers.addNodeAtTail(r2);
        registers.addNodeAtTail(r3);
        registers.addNodeAtTail(r4);
        registers.addNodeAtTail(r5);
        registers.addNodeAtTail(r6);
        registers.addNodeAtTail(r7);
        registers.addNodeAtTail(r8);
        registers.addNodeAtTail(r9);
        registers.addNodeAtTail(r10);

        users.traverse();
        System.out.println("\n\n\n");
        cars.traverse();
        System.out.println("\n\n\n");
        registers.traverse();
        System.out.println("\n\n\n");







        
    }
}