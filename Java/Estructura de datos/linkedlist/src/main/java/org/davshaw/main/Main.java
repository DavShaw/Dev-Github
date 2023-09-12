package org.davshaw.main;

import org.davshaw.classes.megalinkedlist.MegaLinkedList;

public class Main
{
    public static void main(String[] args)
    {
        
        //Crear instancia de mega linked list
        MegaLinkedList l = new MegaLinkedList();
        l.addNodesAsString("holasoypapauwumequieres");
        l.traverse();
        l.sort2();
        l.traverse();
        
    
        
        
    }


}