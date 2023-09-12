package DoubleLinkedList;

public class Main
{
    public static void main(String[] args)
    {
        //crear lista enlazada
        LinkedList lista = new LinkedList();
        lista.add_node_at_tail(5);
        lista.add_node_at_tail(1);
        lista.add_node_at_tail(9);
        lista.add_node_at_tail(8);
        lista.add_node_at_tail(6);
        lista.add_node_at_tail(91);
        lista.traverse();
        lista.deleteAt(2);
        lista.traverse();

    }
}
