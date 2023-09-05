package org.davshaw.classes;

public class CarItem implements Comparable<CarItem>
{
    private Product producto;
    private int cantidadProdcto;

    public CarItem(Product producto, int cantidadProdcto)
    {
        this.cantidadProdcto = cantidadProdcto;
        this.producto = producto;
    }

    public int getQuantity()
    {
        return cantidadProdcto;
    }

    public void setQuantity(int cantidadProdcto)
    {
        this.cantidadProdcto = cantidadProdcto;
    }

    public Product getProducto()
    {
        return producto;
    }

    public void addAmount(int amount)
    {
        this.cantidadProdcto += amount;
    }

    @Override
    public int compareTo(CarItem otherProduct)
    {
        // Comparar por cantidad de mayor a menor
        return otherProduct.getQuantity() - this.getQuantity();
    }

}
