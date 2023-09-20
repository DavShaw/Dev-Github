package org.davshaw.resources.CarLinkedList;
import java.text.MessageFormat;

import org.davshaw.autos.Car;

public class CarNode
{
    private Car car;
    private CarNode next;
    private CarNode prev;

    public CarNode(Car car)
    {
        this.car = car;
        this.next = null;
        this.prev = null;
    }

    public CarNode Next()
    {
        return this.next;
    }

    public void setNext(CarNode next)
    {
        this.next = next;
    }

    public CarNode Prev()
    {
        return this.prev;
    }

    public void setPrev(CarNode prev)
    {
        this.prev = prev;
    }

    public Car Value()
    {
        return this.car;
    }

    public void setValue(Car car)
    {
        this.car = car;
    }

    @Override
    public String toString()
    {
        if (this.next != null)
        {
            return MessageFormat.format("{0} ->", this.car);
        }
        return MessageFormat.format("{0}", this.car);
    }

}