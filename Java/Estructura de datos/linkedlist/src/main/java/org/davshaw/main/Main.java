package org.davshaw.main;

import org.davshaw.classes.doublelinkedlist.DoubleLinkedList;
public class Main
{
    public static void main(String[] args)
    {
        DoubleLinkedList l = new DoubleLinkedList();
        l.addNodeAtTailAsList("A|B|C");
        l.addNodeAtIndexAsList(1, "1|2|3");
        l.print();
    }


}