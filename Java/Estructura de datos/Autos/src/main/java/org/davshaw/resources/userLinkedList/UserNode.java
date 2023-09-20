package org.davshaw.resources.userLinkedList;
import java.text.MessageFormat;

import org.davshaw.autos.User;

public class UserNode
{
    private User user;
    private UserNode next;
    private UserNode prev;

    public UserNode(User user)
    {
        this.user = user;
        this.next = null;
        this.prev = null;
    }

    public UserNode Next()
    {
        return this.next;
    }

    public void setNext(UserNode next)
    {
        this.next = next;
    }

    public UserNode Prev()
    {
        return this.prev;
    }

    public void setPrev(UserNode prev)
    {
        this.prev = prev;
    }

    public User Value()
    {
        return this.user;
    }

    public void setValue(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        if (this.next != null)
        {
            return MessageFormat.format("{0} ->", this.user);
        }
        return MessageFormat.format("{0}", this.user);
    }

}