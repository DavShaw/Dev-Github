package org.davshaw.resources.GenericLinkedList;
import java.text.MessageFormat;

import org.davshaw.autos.Car;

public class genericNode
{
    private Car car;
    private genericNode next;
    private genericNode prev;

    public genericNode(Car car)
    {
        this.car = car;
        this.next = null;
        this.prev = null;
    }

    public genericNode Next()
    {
        return this.next;
    }

    public void setNext(genericNode next)
    {
        this.next = next;
    }

    public genericNode Prev()
    {
        return this.prev;
    }

    public void setPrev(genericNode prev)
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