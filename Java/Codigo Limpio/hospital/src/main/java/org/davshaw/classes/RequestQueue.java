package org.davshaw.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.davshaw.external.Color;

//Reimplementar con listas!!!!

public class RequestQueue extends Queue
{
    private List<Request> queue = new ArrayList<Request>();
    private int size;
    private int nextIndex;

    public RequestQueue(int size)
    {
        this.size = size;
        this.nextIndex = 0;

        //Llenar la lista con null
        for (int i = 0; i < size; i++)
        {
            this.queue.add(null);
        }
    }

    

    public void enqueue(Request request) throws ArrayIndexOutOfBoundsException
    {
        try
        {
            if(this.isFull())
            {
                throw new ArrayIndexOutOfBoundsException("La cola está llena");
            }
    
            else
            {
                this.queue.set(this.nextIndex, request);
                this.nextIndex++;
                this.sort();
            }
        }

        catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println(Color.color("RED", "SE HA GENERADO UNA EXCEPCIÓN: ") + Color.color("CYAN", exception.getMessage()));
            exception.printStackTrace();
        }
    }

    public Request first()
    {

        try
        {
            if(this.isEmpty())
            {
                throw new ArrayIndexOutOfBoundsException("La cola está vacía");
            }
            
            else
            {
                return this.queue.get(0);
            }
        }

        catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println(Color.color("RED", "SE HA GENERADO UNA EXCEPCIÓN: ") + Color.color("CYAN", exception.getMessage()));
        exception.printStackTrace();
        }
        return null;
    }

    @Override
    protected void sort()
    {
            Collections.sort(this.queue, new Comparator<Request>()
            {
                @Override
                public int compare(Request request1, Request request2)
                {
                    // Manejar el caso de elementos null
                    if (request1 == null && request2 == null)
                    {
                        return 0; // Ambos son null, son iguales
                    }

                    else if (request1 == null)
                    {
                        return 0; // request1 es null, request2 no lo es, request1 debe estar al final
                    }

                    else if (request2 == null)
                    {
                        return 0; // request2 es null, request1 no lo es, request2 debe estar al final
                    }
                    
                    // Comparar los elementos no nulos
                    return request1.compareTo(request2);
                }
            }
            );
        }

    public Request dequeue()
    {
        try
        {
            if(this.isEmpty())
            {
                throw new ArrayIndexOutOfBoundsException("La cola está vacía");
            }
        
            else
            {
                //Retornar y eliminar el primer elemento (el first)
                Request request = this.queue.remove(0);
                //Rellenar el espacio vacío
                this.queue.add(null);
                //Reducir el nextIndex
                this.nextIndex--;
                return request;
            }
        }

        catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println(Color.color("RED", "SE HA GENERADO UNA EXCEPCIÓN: ") + Color.color("CYAN", exception.getMessage()));
            exception.printStackTrace();
        }
        return null;
        
    }

    @Override
    public Boolean isEmpty()
    {
        if (this.nextIndex == 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean isFull()
    {
        if (this.nextIndex == this.size)
        {
            return true;
        }
        return false;
    }

    @Override
    public Integer size()
    {
        return this.size();
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < this.size; i++)
        {
            queue.set(i, null);
        }
    }
    

    @Override
    public String toString()
    {
        return this.queue.toString();
    }

}
