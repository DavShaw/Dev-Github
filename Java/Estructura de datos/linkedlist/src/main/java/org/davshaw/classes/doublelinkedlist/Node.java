package org.davshaw.classes.doublelinkedlist;
import java.text.MessageFormat;

public class Node
{
    private int value;
    private Node next;
    private Node prev;

    public Node(int value)
    {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Node Next()
    {
        return this.next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public Node Prev()
    {
        return this.prev;
    }

    public void setPrev(Node prev)
    {
        this.prev = prev;
    }

    public int Value()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        if (this.next != null)
        {
            return MessageFormat.format("{0} ->", this.value);
        }
        return MessageFormat.format("{0}", this.value);
    }

}