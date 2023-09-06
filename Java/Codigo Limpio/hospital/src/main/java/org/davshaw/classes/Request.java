package org.davshaw.classes;

import java.text.MessageFormat;

import org.davshaw.external.Color;

public class Request implements Comparable<Request>
{
    private static int IDCounter = 1;
    private Integer ID;
    private String name;
    private String requestDescription;
    private Integer age;
    private Integer priority = 25;

    public Request(String name, String requestDescription, Integer age)
    {
        try
        {
            this.ID = IDCounter;
            IDCounter++;
            this.name = name;
            this.requestDescription = requestDescription;
            this.age = age;
            this.setPriority();
        }
        
        catch (Exception exception)
        {
            System.out.println(Color.color("RED", "SE HA GENERADO UNA EXCEPCIÓN: ") + Color.color("CYAN", exception.getMessage()));
            exception.printStackTrace();
        }
    }

    public Integer getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String getRequestDescription()
    {
        return this.requestDescription;
    }

    public void setRequestDescription(String requestDescription)
    {
        this.requestDescription = requestDescription;
    }

    public Integer getAge()
    {
        return this.age;
    }

    @Override
    public String toString()
    {
        return MessageFormat.format("{0} ({1})", this.getName(), this.getPriority());
    }

    @Override
    public boolean equals(Object otherObject)
    {
        try
        {
            //Castear el otherObject a Request
            Request otherRequest = (Request) otherObject;
            //Comparar los atributos de ambos objetos
            boolean checkName = this.name.equals(otherRequest.getName());
            boolean checkRequestDescription = this.requestDescription.equals(otherRequest.getRequestDescription());
            boolean checkAge = this.age.equals(otherRequest.getAge());
            boolean checkID = this.ID.equals(otherRequest.getID());
            
            //Retornar true o false
            if (checkName && checkRequestDescription && checkAge && checkID)
            {
                return true;
            }
            return false;
        }

        catch(Exception exception)
        {
            System.out.println(Color.color("RED", "SE HA GENERADO UNA EXCEPCIÓN: ") + Color.color("CYAN", exception.getMessage()));
            exception.printStackTrace();
        }
        return false;
    }
    


    @Override
    public int compareTo(Request otherRequest)
    {
        //Get this age
        int thisPriority = this.getPriority();
        //Get the other age
        int otherPriority = otherRequest.getPriority();

        return thisPriority - otherPriority;
    }

    private void setPriority()
    {
        if (this.getAge() >= 0 && this.getAge() <= 120)
        {
            this.priority = (25 - this.getAge() / 5);
        }
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

}
