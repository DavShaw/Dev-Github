package DoubleLinkedList;


public class LinkedList
{
    private Node head;
    private Node tail;

    public LinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    public void add_node_at_tail(int value)
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
