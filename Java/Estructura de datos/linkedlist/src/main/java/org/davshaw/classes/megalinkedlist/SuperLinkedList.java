package org.davshaw.classes.megalinkedlist;

import java.util.ArrayList;
import java.util.List;

public class SuperLinkedList
{
    private MegaLinkedList head;
    
    public void add(MegaLinkedList value)
    {
        if (this.head == null)
        {
            this.head = value;
        }

        else
        {
            MegaLinkedList current = this.head;
            //Obtener el último nodo que tiene su next como null
            while (true)
            {
                if (current.getNextLinkedList() == null)
                {
                    current.setNextLinkedList(value);
                    break;
                }
                current = current.getNextLinkedList();
            }
        }
    }

    public void traverse()
    {
        //Crear lista para almacenar los nodos
        List<MegaLinkedList> nodes = new ArrayList<MegaLinkedList>();

        MegaLinkedList current = this.head;
        
        while (true)
        {
            if (current == null)
            {
                break;
            }
            nodes.add(current);
            current = current.getNextLinkedList();
        }
    
        for (MegaLinkedList megaLinkedList : nodes)
        {
            System.out.println(megaLinkedList);   
        }
    }

    public int size()
    {
        int counter = 0;
        MegaLinkedList current = this.head;
        
        while(true)
        {
            if(current == null)
            {
                return counter;
            }

            current = current.getNextLinkedList();
            counter++;
        }
    }


    public MegaLinkedList getHead()
    {
        return this.head;
    }

    public MegaLinkedList getLinkedListAt(int index)
    {

        if(index >= this.size())
        {
            return null;
        }

        else
        {
            MegaLinkedList current = this.head;
            for (int i = 0; i < index; i++)
            {
                current = current.getNextLinkedList();
            }
            return current;
        }
    }


}
