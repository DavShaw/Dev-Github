import java.util.ArrayList;
import java.util.List;

public class LinkedList
{
    private Node head;

    public LinkedList()
    {
        this.head = null;
    }

    public void add_node_at_tail(int value)
    {
        if (this.head == null)
        {
            //Instanciar nodo
            Node nuevoHead = new Node(value);
            //Establecerlo como head 
            this.head = nuevoHead;
        }

        else
        {
            Node current = this.head;
            //Obtener el último nodo que tiene su next como null
            while (true)
            {
                if (current.getNext() == null)
                {
                    //Instanciar nuevo nodo
                    Node nextNode = new Node(value);
                    current.setNext(nextNode);
                    break;
                }
                current = current.getNext();
            }
        }
    }

    public void traverse()
    {
        //Crear lista para almacenar los nodos
        List<Node> nodes = new ArrayList<Node>();

        Node currentNode = this.head;
        
        while (true)
        {
            if (currentNode == null)
            {
                break;
            }
            nodes.add(currentNode);
            currentNode = currentNode.getNext();
        }
    
        System.out.println(nodes);
    }
    
    public Node getHead()
    {
        return this.head;
    }

}
