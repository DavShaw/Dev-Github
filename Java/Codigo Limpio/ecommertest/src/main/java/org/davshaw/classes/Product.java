package org.davshaw.classes;

public class Product
{
    private String nombreProducto;
    private double precio;

    public Product(String nombreProducto, double precio)
    {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    public double getPrice()
    {
        return this.precio;
    }

    public String getName()
    {
        return this.nombreProducto;
    }




}
