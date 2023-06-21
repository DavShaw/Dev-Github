package OOP.Triangulo;

import java.util.List;
import java.util.Arrays;


/*
 * @Author David Torres
 * @License @DavShaw
 * Custom Packget Prácticas de Java, Object Oriented Programming 
*/

public class Triangle
{
    //Creación de atributos
    private float sideOne;
    private float sideTwo;
    private float sideThree;
    private float base;
    private float height;

    

    //Creación del inicializador
    public Triangle(float sideOne, float sideTwo, float sideThree, float base, float height)
    {
        List<Float> sidesList = Arrays.asList(this.sideOne, this.sideTwo, this.sideThree);

        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
        this.base = base;
        this.height = base;

    }

    //Métodos de instancia de clase

    public float calcArea(boolean HeronMethod)
    {
        if (HeronMethod)
        {
            float s = this.calcPerimeter()/2;
            float a = this.sideOne;
            float b = this.sideTwo;
            float c = this.sideThree;
            return (float) Math.sqrt((s*(s-a)*(s-b)*(s-c)));
        }

        else
        {
            return (this.base * this.height)/2;    
        }
        
    }


    public float calcPerimeter()
    {
        return this.sideOne + this.sideTwo + this.sideThree;
    }

    public String toString()
    {
        String sidesInfo = "This triangle has these sides measures: %s %s %s for its sides".formatted(this.sideOne, this.sideTwo, this.sideThree);
        String baseInfo = "This triangle has this base measure: %s".formatted(this.base);
        String heightInfo = "This triangle has this height measure: %s".formatted(this.height);
        return "* %s \n* %s \n* %s".formatted(sidesInfo, baseInfo, heightInfo);
    }



    //Métodos de set y get

    public float getSideOne()
    {
        return this.sideOne;
    }

    public void setSideOne(float sideOne)
    {
        this.sideOne = sideOne;
    }

    public float getSideTwo() {
        return this.sideTwo;
    }

    public void setSideTwo(float sideTwo)
    {
        this.sideTwo = sideTwo;
    }

    public float getSideThree() {
        return this.sideThree;
    }

    public void setSideThree(float sideThree)
    {
        this.sideThree = sideThree;
    }

    public float getBase()
    {
        return this.base;
    }

    public void setBase(float base)
    {
        this.base = base;
    }

    public float getHeight()
    {
        return this.height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }


    



}