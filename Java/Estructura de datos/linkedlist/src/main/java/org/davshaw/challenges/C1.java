package org.davshaw.challenges;

import org.davshaw.classes.megalinkedlist.MegaLinkedList;
import org.davshaw.classes.doublelinkedlist.Node;
import java.util.ArrayList;
import java.util.List;

public class C1
{
    
    /*
     E1. Cree una función que reciba una lista enlazada simple de enteros y que devuelva la sumatoria de sus
    números siguiendo estas restricciones:

    En algunos nodos, no habrá un entero sino el símbolo "*"
    Sólo sume los números que estén antes o después del "*"
    Por ejemplo

    Ej1: 3->10->2->*->0->8->*->1->*->9->
    Ej2: 3->*->2->*->*->8->6->1->9->*->

    */
    MegaLinkedList l  = new MegaLinkedList();
    public int result(MegaLinkedList l)
    {
        //Lista de nodos válidos (Aquellos que su valor sea *)
        List<Node> validNodes = new ArrayList<Node>();
        //Variable de la sumatoria
        int total = 0;


        //Iterar para obtener los nodos a evaluar
        for (int i = 0; i < l.size(); i++)
        {
            //Probando glidex xd
            Node current = l.getNodeAt(i);
            if (current.Value().equalsIgnoreCase("*"))
            {
                validNodes.add(current);
            }
        }

        //Iterar sobre cada nodo para obtener prev y next y sumarlos (si y solo si son digitos)
        for (Node node : validNodes)
        {
            Node next = node.Next();
            Node prev = node.Prev();
            //Verificar si no son null
            //! Verificar next
            if(next != null)
            {
                //Verificar que su valor sea un dígito
                boolean validDigit = Character.isDigit(next.Value().charAt(0));
                if(validDigit)
                {
                    total += Integer.parseInt(next.Value());
                }
            }

            if (prev != null)
            {
                //Verificar que su valor sea un dígito
                boolean validDigit = Character.isDigit(prev.Value().charAt(0));
                if(validDigit)
                {
                    total += Integer.parseInt(prev.Value());
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        MegaLinkedList l = new MegaLinkedList();
        l.addNodesAsSplitedString("3,10,2,*,0,8,*,1,*,9");
        //2+8+1+9+1
        //21

        C1 c1 = new C1();
        int result = c1.result(l);

        System.out.println(result);
    }
}


