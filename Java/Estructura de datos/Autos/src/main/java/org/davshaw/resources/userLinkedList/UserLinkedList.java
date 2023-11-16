package org.davshaw.resources.userLinkedList;

import org.davshaw.autos.User;

public class UserLinkedList
{
    protected UserNode head;
    protected UserNode tail;

    public UserLinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    public UserNode getHead()
    {
        return this.head;
    }

    public UserNode getTail()
    {
        return this.tail;
    }

    public void addNodeAtTail(User user)
    {
        if (this.head == null)
        {
            //Instanciar nodo
            UserNode nuevoHead = new UserNode(user);
            //Establecerlo como head
            this.head = nuevoHead;
            //Establecer nuevo nodo añadido
            this.tail = nuevoHead;
        }

        else
        {
            //Si el head no es null, implica que hay otro nodo
            //Instanciar nodo
            UserNode nuevoNodo = new UserNode(user);
            this.tail.setNext(nuevoNodo);
            nuevoNodo.setPrev(this.tail);
            this.tail = nuevoNodo;
        }
    }

    public void addNodeAt(int index, User user)
    {
        try
        {
            // Obtener el nodo en la posición index - 1
            UserNode A = this.getNodeAt(index - 1);
            
            // Crear un nuevo nodo con el valor deseado
            UserNode B = new UserNode(user);

            // Obtener el nodo en la posición index
            UserNode C = this.getNodeAt(index);
    
            // Actualizar las referencias
            A.setNext(B);
            C.setPrev(B);
            B.setNext(C);
            B.setPrev(A);

        }
        
        catch (IndexOutOfBoundsException error)
        {
            error.printStackTrace();
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
            UserNode currentNode = this.head;
            
            while (currentNode != null)
            {
                System.out.println(currentNode);
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
            UserNode currentNode = this.head;
            
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
        UserNode currentNode = this.head;
        while (currentNode != null)
        {
            counter++;
            currentNode = currentNode.Next();
        }
        return counter;
    }

    public UserNode getNodeAt(int index)
    {
        UserNode currentNode = this.head;
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
            UserNode B = this.getNodeAt(index);
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
                UserNode prevNode = this.tail.Prev();
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
                UserNode nextNode = this.head.Next();
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
    
    public UserNode Head()
    {
        return this.head;
    }

    public UserNode Tail()
    {
        return this.tail;
    }

}
