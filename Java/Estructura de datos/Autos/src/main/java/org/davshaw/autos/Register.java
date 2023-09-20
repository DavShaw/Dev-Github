package org.davshaw.autos;

import java.time.LocalDate;

import org.davshaw.external.Color;

public class Register
{
    //!Class variables
    private static int registerCounter = 0;

    //? Instance variables
    private int id;
    private User user;
    private Car car;
    private LocalDate rentedAt;
    private LocalDate returnedAt;

    public Register(User user, Car car)
    {
        this.user = user;
        this.car = car;
        this.rentedAt = LocalDate.now();
        this.id = (++registerCounter);
    }

    public void carReturned()
    {
        this.returnedAt = LocalDate.now();
    }

    public boolean hasBeenReturned()
    {
        return this.returnedAt != null;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getRentedAt() {
        return this.rentedAt;
    }

    public void setRentedAt(LocalDate rentedAt) {
        this.rentedAt = rentedAt;
    }

    public LocalDate getReturnedAt() {
        return this.returnedAt;
    }

    public void setReturnedAt(LocalDate returnedAt) {
        this.returnedAt = returnedAt;
    }

    @Override
    public String toString(){
        return String.format("(%s) [%s] - %s",Color.color("RED", this.id), Color.color("YELLOW", this.user.getName()), Color.color("CYAN", this.rentedAt.toString()));
    }



    
}
