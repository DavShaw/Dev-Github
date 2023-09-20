package org.davshaw.challenges;

import java.util.ArrayList;
import java.util.List;

import org.davshaw.classes.doublelinkedlist.Node;
import org.davshaw.classes.megalinkedlist.MegaLinkedList;

public class C2
{

    //Escriba una función que tome dos listas enlazadas y sume sus nodos
    public static void result(MegaLinkedList l1, MegaLinkedList l2)
    {
        try
        {
            //Si alguno es nulo
            if (l1 == null || l2 == null)
            {
                throw new IllegalArgumentException("Listas nulas");
            }

            //Si no tienen la misma longitud
            if (l1.size() != l2.size())
            {
                throw new IllegalArgumentException("Listas de diferentes dimensiones");
            }

            //Código:
            else
            {
                //Lista enlazada para guardar nodos resultantes
                MegaLinkedList l3 = new MegaLinkedList();
                //Iterar en ambas listas
                for (int i = 0; i < l1.size(); i++)
                {
                    int valorNodo1 = Integer.valueOf(l1.getNodeAt(i).Value());
                    int valorNodo2 = Integer.valueOf(l2.getNodeAt(i).Value());

                    l3.addNodeAtTail(valorNodo1+valorNodo2);
                }
                System.out.println(l3);
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
