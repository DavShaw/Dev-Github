package org.davshaw.classes.doublelinkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.davshaw.classes.megalinkedlist.MegaLinkedList;

public class DoubleLinkedList
{
    protected Node head;
    protected Node tail;

    public DoubleLinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    public Node getHead()
    {
        return this.head;
    }

    public Node getTail()
    {
        return this.tail;
    }

    public void addNodeAtTail(int value)
    {
        String valString = String.valueOf(value);
        this.addNodeAtTail(valString);
    }

    public void addNodeDown(int level, String value)
    {
        //Buscar la lista en el nivel X
        MegaLinkedList lista = this.getListByLevel(level);
        lista.addNodeAtTail(value);
    }

    public void addNodeDown(int level, int value)
    {
        //Buscar la lista en el nivel X
        MegaLinkedList lista = this.getListByLevel(level);
        lista.addNodeAtTail(value);
    }

    private MegaLinkedList getListByLevel(int level)
    {
        Node current = this.getHead();

        // Itera hasta el nivel especificado
        for (int i = 0; i < level; i++)
        {
            if (current.Down() != null)
            {
                current = current.Down();  // Sigue el enlace "down"
            }

            else
            {
                throw new IllegalArgumentException("El número de niveles supera el nivel mas bajo de la lista.");
            }
        }

        MegaLinkedList list = new MegaLinkedList();
        list.setHead(current);

        return list;
    }


    public void addNodeAtTail(String value)
    {
        if (this.head == null)
        {
            //Instanciar nodo
            Node nuevoHead = new Node(value);
            //Establecerlo como head
            this.head = nuevoHead;
            //Establecer nuevo nodo añadido
            this.tail = nuevoHead;
        }

        else
        {
            //Si el head no es null, implica que hay otro nodo
            //Instanciar nodo
            Node nuevoNodo = new Node(value);
            this.tail.setNext(nuevoNodo);
            nuevoNodo.setPrev(this.tail);
            this.tail = nuevoNodo;
        }
    }

    public void addNodeAt(int index, int value)
    {
        String valueString = String.valueOf(value);
        this.addNodeAt(index, valueString);
    }

    public void addNodeAt(int index, String value)
    {
        try
        {
            // Obtener el nodo en la posición index - 1
            Node A = this.getNodeAt(index - 1);
            
            // Crear un nuevo nodo con el valor deseado
            Node B = new Node(value);

            // Obtener el nodo en la posición index
            Node C = this.getNodeAt(index);
    
            // Actualizar las referencias
            A.setNext(B);
            C.setPrev(B);
            B.setNext(C);
            B.setPrev(A);

        }
        
        catch (IndexOutOfBoundsException error)
        {
            System.out.println("Ocurrió un error xd (ID: 2)");
        }
    }
    

    public void traverse()
    {
        if(this.head == null)
        {
            System.out.println("Linkedlist is empty... Dude, there's nothing to traverse.");
        }

        else
        {
            Node currentNode = this.head;
            
            while (currentNode != null)
            {
                System.out.print(currentNode);
                currentNode = currentNode.Next();
            }
            System.out.println("");
        }
    }

    @Override
    public String toString()
    {
        String toReturn = "";
        if(this.head == null)
        {
            System.out.println("Linkedlist is empty... Dude, there's nothing to traverse.");
        }

        else
        {
            Node currentNode = this.head;
            
            while (currentNode != null)
            {
                toReturn += currentNode;
                currentNode = currentNode.Next();
            }
        }  
        return toReturn;
    }

    public int size()
    {
        int counter = 0;
        Node currentNode = this.head;
        while (currentNode != null)
        {
            counter++;
            currentNode = currentNode.Next();
        }
        return counter;
    }

    public Node getNodeAt(int index)
    {
        Node currentNode = this.head;
        for (int i = 0; i < this.size(); i++)
        {
            if (i == index)
            {
                return currentNode;
            }
            currentNode = currentNode.Next();
        }
        return currentNode;
    }


    public void deleteAt(int index)
    {
        if (index == 0) //Es la head, se borra la head xd
        {
            this.deleteHead();
        }

        else if (index == this.size() - 1) //Es la tail, se borra la tail xd
        {
            this.deleteTail();
        }

        else
        {
            //Sabemos que Sí o sí habrá un nodo entre el head y el tail (Porque no se cumplieron las anteriores)
            //Obtenemos el prev y el next de ese nodo
            Node B = this.getNodeAt(index);
            //[A, B, C]
            //Haremos que el next de A sea el next de B
            this.getNodeAt(index-1).setNext(B.Next());
            //Haremos que el prev de C sea el prev de B
            this.getNodeAt(index+1).setPrev(B.Prev());
        }
    }


    public void deleteTail() throws NullPointerException
    {
        try
        {
            if (this.tail == null)
            {
                throw new NullPointerException("Tail is null!");
            }

            else
            {

                if(this.head == this.tail)
                {
                    this.head = null;
                }

                //Si el tail tiene un prev nodo, guardaremos este para cambiar su "next"
                Node prevNode = this.tail.Prev();
                if (prevNode != null)
                {
                    prevNode.setNext(null);
                }
                this.tail = prevNode;
            }
        }
        
        catch (NullPointerException error)
        {
            System.out.println(error.getMessage());
        }
    }


    public void deleteHead() throws NullPointerException
    {

        try
        {
            if (this.head == null)
            {
                throw new NullPointerException("Head is null!");
            }

            else
            {
                //Si el head tiene un siguiente nodo, guardaremos este para cambiar su "prev"
                Node nextNode = this.head.Next();
                if (nextNode != null)
                {
                    nextNode.setPrev(null);
                }
                this.head = nextNode;
            }
        }
        
        catch (NullPointerException error)
        {
            System.out.println(error.getMessage());
        }

    }
    
    public Node Head()
    {
        return this.head;
    }

    public Node Tail()
    {
        return this.tail;
    }

}
