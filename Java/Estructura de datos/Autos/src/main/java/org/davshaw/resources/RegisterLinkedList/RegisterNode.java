package org.davshaw.resources.RegisterLinkedList;
import java.text.MessageFormat;

import org.davshaw.autos.Register;

public class RegisterNode
{
    private Register register;
    private RegisterNode next;
    private RegisterNode prev;

    public RegisterNode(Register register)
    {
        this.register = register;
        this.next = null;
        this.prev = null;
    }

    public RegisterNode Next()
    {
        return this.next;
    }

    public void setNext(RegisterNode next)
    {
        this.next = next;
    }

    public RegisterNode Prev()
    {
        return this.prev;
    }

    public void setPrev(RegisterNode prev)
    {
        this.prev = prev;
    }

    public Register Value()
    {
        return this.register;
    }

    public void setValue(Register register)
    {
        this.register = register;
    }

    @Override
    public String toString()
    {
        if (this.next != null)
        {
            return MessageFormat.format("{0} ->", this.register);
        }
        return MessageFormat.format("{0}", this.register);
    }

}