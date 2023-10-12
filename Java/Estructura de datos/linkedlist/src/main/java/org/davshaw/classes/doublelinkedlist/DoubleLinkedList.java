package org.davshaw.classes.doublelinkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoubleLinkedList
{
    protected Node head;
    protected Node tail;

    public void addNodeAtTail(int value)
    {
        String valString = String.valueOf(value);
        this.addNodeAtTail(valString);
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

    public void addNodeAtTailAsList(String values) {
        String[] value = values.split("\\|");
        for (String str : value) {
            this.addNodeAtTail(str);
        }
    }
    
    public void addNodeAtIndexAsList(int index, String values) {
        String[] value = values.split("\\|");
        for (String str : value) {
            this.addNodeAt(index, str);
        }
    }

    public int size()
    {
        int counter = 0;
        Node currentNode = this.head;
        while (currentNode != null)
        {
            counter++;
            currentNode = currentNode.getNext();
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
            currentNode = currentNode.getNext();
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
            this.getNodeAt(index-1).setNext(B.getNext());
            //Haremos que el prev de C sea el prev de B
            this.getNodeAt(index+1).setPrev(B.getPrev());
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
                Node prevNode = this.tail.getPrev();
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
                Node nextNode = this.head.getNext();
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

    private void print(Node head) {
        Node current = head;
        
        if (current == null) {
        }
        
        else {
            System.out.print("->" + current.getValue().toString());
            current = current.getNext();
            print(current);
        }
    }

    public void print() {
        print(this.getHead());
    }

    public DoubleLinkedList test1(DoubleLinkedList l) {
        for (int i = 0; i < l.size(); i++) {
            if(l.getNodeAt(i).getValue().equalsIgnoreCase("*")) {
                l.deleteAt(i);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        DoubleLinkedList examen = new DoubleLinkedList();
        examen.addNodeAtTailAsList("1|3|*|2|*|5|0|*|5|*|2|*|852|0|*");
        examen.print();
        examen.test1(examen);
        System.out.println("Editada");
        examen.print();
    }
}
