package org.davshaw.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.davshaw.classes.megalinkedlist.SuperLinkedList;
import org.davshaw.classes.megalinkedlist.MegaLinkedList;

public class C3
{
    //Escriba una función que reciba una lista enlazada de listas enlazadas (matriz enlazada)
    //y que devuelva cuál de las filas enlazadas tiene más números pares. (0.3)

    public void result(SuperLinkedList sl)
    {
        //Ya tenemos la SuperLinkedList, solo debemos iterar sobre cada uno de sus nodos (MegaLinkedList)

        //Almacenar cada fila en una lista
        List<MegaLinkedList> slFilas = new ArrayList<>();
        for (int i = 0; i < sl.size(); i++)
        {
            slFilas.add(sl.getLinkedListAt(i));
        }

        //Crear diccionario
        HashMap<MegaLinkedList,Integer> dic = new HashMap<>();

        //NOTA: La posicion en la lsita de cada fila implica su posicion en la lista enlazada de listas enlazadas
        //! Iniciar el conteo
        for (MegaLinkedList currentfila : slFilas)
        {
            int oddCounter = 0;
            for (int i = 0; i < currentfila.size(); i++)
            {
                //Añadir lista a diccionario
                dic.put(currentfila, 0);
                //Sabemos que todos su nodos son numeros, por ende son casteables (NOTA: casteables != parseables, preguntar a jonathangod)
                int n = Integer.valueOf(currentfila.getNodeAt(i).Value());
                if(n%2 == 0)
                {
                    oddCounter++;
                }
                //Actualizar valor xd
                dic.put(currentfila, oddCounter);
            }
        }
        //Obtener la lista de mayor valor xd
        MegaLinkedList mayor = this.buscarClaveMaxima(dic);
        System.out.println("La lista enlazada con mayores numero de numeros pares es " + mayor);
    }

    private MegaLinkedList buscarClaveMaxima(Map<MegaLinkedList, Integer> diccionario) {
        MegaLinkedList claveMaxima = null;
        int valorMaximo = Integer.MIN_VALUE;

        for (Map.Entry<MegaLinkedList, Integer> entry : diccionario.entrySet()) {
            MegaLinkedList clave = entry.getKey();
            int valor = entry.getValue();

            if (valor > valorMaximo) {
                valorMaximo = valor;
                claveMaxima = clave;
            }
        }

        return claveMaxima;
    }


}
