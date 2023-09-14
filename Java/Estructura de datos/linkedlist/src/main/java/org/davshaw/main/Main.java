package org.davshaw.main;

import org.davshaw.challenges.C2;
import org.davshaw.classes.megalinkedlist.MegaLinkedList;
import org.davshaw.classes.megalinkedlist.SuperLinkedList;

public class Main
{
    public static void main(String[] args)
    {
        //Crear instancia de super linked list
        SuperLinkedList sl = new SuperLinkedList();
        
        //Crear instancia de mega linked list
        MegaLinkedList l1 = new MegaLinkedList();
        MegaLinkedList l2 = new MegaLinkedList();
        MegaLinkedList l3 = new MegaLinkedList();
        MegaLinkedList l4 = new MegaLinkedList();

        //Añadir valores
        l1.addNodesAsSplitedString("2,4,1,1,9,7"); // 2 pares
        l2.addNodesAsSplitedString("8,6,2,2,0,0"); // 5 pares
        l3.addNodesAsSplitedString("9,5,5,1,3,9"); //0 pares
        l4.addNodesAsSplitedString("2,7,1,3,9,7"); // 1 par

        //Añadir a sl 
        sl.add(l1);
        sl.add(l2);
        sl.add(l3);
        sl.add(l4);

        C2 c2 = new C2();
        System.out.println();
        c2.result(sl);
        
    
        
        
    }


}