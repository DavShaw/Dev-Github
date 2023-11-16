package org.davshaw.classes.megalinkedlist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.davshaw.classes.doublelinkedlist.DoubleLinkedList;
import org.davshaw.classes.doublelinkedlist.Node;

public class MegaLinkedList extends DoubleLinkedList
{
    private MegaLinkedList nextLinkedList = null;

    //Clase que extiende métodos de DoubleLinkedList
    public void changeNodesToFrom(int index1, int index2)
    {
        try
        {
            //Obtener nodo en el index1 e index2
            Node node1 = this.getNodeAt(index1);
            Node node2 = this.getNodeAt(index2);

            //Obtener el value del nodo 1 y nodo 2
            String node1Value = node1.getValue();

            String node2Value = node2.getValue();

            //Cambiar sus datos
            // ! Cambiando datos del nodo 1
            node1.setValue(node2Value);
            // ! Cambiando datos del nodo 2
            node2.setValue(node1Value);
        }
        
        catch (Exception e)
        {
            System.out.println("Profe, algun error raro paso xd (ID: 1)");
        }
    }


    public MegaLinkedList getNextLinkedList()
    {
        return this.nextLinkedList;
    }

    public void setNextLinkedList(MegaLinkedList nextLinkedList)
    {
        this.nextLinkedList = nextLinkedList;
    }


    public void addNodesAsString(String txt)
    {
        char[] elements = txt.toCharArray();
        List<String> chars = new ArrayList<String>();
        for (char element : elements)
        {
            String temp = String.valueOf(element);
            chars.add(temp);
        }

        for (String stringuwu : chars)
        {
            this.addNodeAtTail(stringuwu);
        }
    }

    public void addNodesAsSplitedString(String txt)
    {
        String[] elements = txt.split(",");
        for (String element : elements)
        {
            String trimmedElement = element.trim();
            this.addNodeAtTail(trimmedElement);
        }
    }

    public void setHead(Node node)
    {
        this.head = node;
    }

    public void setTail(Node node)
    {
        this.tail = node;
    }
    public void sort2()
    {
        Map<String, Integer> vowelsCounter = new HashMap<>();
        List<String> vowels = new ArrayList<String>(Arrays.asList("a", "e", "i", "o", "u"));
        //Lo que haremos sera recorrer la lista enlazada y contar cuantas vocales hay xd
        for (int i = 0; i < this.size(); i++)
        {
            //Nodo en posicion i
            Node currentNode = this.getNodeAt(i);
            //Verificar que sea vocal
            if(vowels.contains(currentNode.getValue()))
            {
                //Verificar que este en el diccionario, sino, se añade
                if(vowelsCounter.containsKey(currentNode.getValue()))
                {
                    vowelsCounter.put(currentNode.getValue(), vowelsCounter.get(currentNode.getValue()) +1);
                }
                else
                {
                    vowelsCounter.put(currentNode.getValue(), 1);
                }
            }

        }
        //Ya que lo tenemos, ahora solo queda instanciar otra megalinkedlist
        MegaLinkedList aux = new MegaLinkedList();
        //Controlar letras ya usadas:
        List<String> usedVowels = new ArrayList<String>();

        //Iterar en la lista actual para llenar la nueva
        for (int j = 0; j < this.size() ; j++)
        {
            //Obtener nodo actual
            Node current = this.getNodeAt(j);
            //Valor del nodo
            String value = current.getValue();

            //Verificar si esta en el diccionario, se añade n veces, sino, solo se añade
            if(vowelsCounter.containsKey(value) && !usedVowels.contains(value))
            {
                usedVowels.add(value);
                //Cantidad de veces a añadir
                int n = vowelsCounter.get(value);
                for (int k = 0; k < n; k++)
                {
                    aux.addNodeAtTail(value);
                }
            }

            else
            {
                if(!usedVowels.contains(value))
                {
                    aux.addNodeAtTail(value);
                }
            }
        }
        //Solo queda cambiar el head de esta lista por el de la aux
        this.setHead(aux.getHead());
    }

    public void sort()
    {
        List<String> vowels = new ArrayList<String>(Arrays.asList("a", "e", "i", "o", "u"));
        List<String> foundedVowels = new ArrayList<String>();
        
        for (int i = 0; i < this.size(); i++)
        {
            //h a o l o a h
            Node current = this.getNodeAt(i);
            //Si el valor del nodo actual es una vocal y no ha sido analizada antes, hagamoslo uwu
            if (vowels.contains(current.getValue()) && !foundedVowels.contains(current.getValue()))
            {
                for (int j = i+1; j < this.size(); j++)
                {
                    Node current2 = this.getNodeAt(j);
                    //Obtener el siguiente nodo el cual su valor sea igual al valor de current
                    if(current2.getValue() == current.getValue())
                    {
                        //Insertar este nodo en la posición de current + 1 y posteriormente borrarlo
                        this.addNodeAt(i+1, current2.getValue());

                        this.deleteAt(j);
                         //h o N l o a h
                    }  
                }
                foundedVowels.add(current.getValue());
            }
        }
    }
}
