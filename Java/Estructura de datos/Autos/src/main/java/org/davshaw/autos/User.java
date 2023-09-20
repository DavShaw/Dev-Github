package org.davshaw.autos;

import org.davshaw.external.Color;

public class User
{
    //?Instance variables
    private String name;
    private String email;
    private int number;
    private int dni;

    public User(String name, String email, int number, int dni)
    {

        try
        {
            this.name = name;
            this.email = email;
            this.number = number;
            this.dni = dni;
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getDni() {
        return this.dni;
    }

    @Override
    public String toString(){
        return String.format("(%s) %s",Color.color("RED", this.dni), Color.color("YELLOW", this.name));
    }

    public String getView()
    {
        String view = "";
        view += "=-=-=-=-=-=-=-=\n";
        view += this.name + "\n";
        view += this.email + "\n";
        view += this.number + "\n";
        view += this.dni + "\n";
        view += "=-=-=-=-=-=-=-=";
        return view;
    }
    
}
