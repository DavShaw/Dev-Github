package org.davshaw.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart
{
    private List<CarItem> listaProductos = new ArrayList<>();
    private double total = 0;

    public void addItem(Product producto, int cantidadProducto) throws IllegalArgumentException, NullPointerException
    {
        if(!(producto instanceof Product))
        {
            throw new NullPointerException("El objeto no puede ser null o de una clase distinta");
        }

        if (cantidadProducto <= 0)
        {
            throw new IllegalArgumentException("No puedes añadir está cantidad de productos");
        }

        //Si el producto ya existe, se añade + productos
        else if(this.productAdded(producto))
        {
            //Iterar sobre la lista y obtener CarItem
            for (CarItem carItem : listaProductos)
            {
                if(carItem.getProducto().equals(producto))
                {
                    carItem.addAmount(cantidadProducto);   
                }
            }

        }
        else
        {
            //Instanciar un objeto de tipo CarItem
            CarItem carritoProducto = new CarItem(producto, cantidadProducto);
            //Añadir el objeto CarItem a la lista
            this.listaProductos.add(carritoProducto);
        }
    }

    public void sortItems()
    {
        Collections.sort(this.listaProductos);
    }



    private boolean productAdded(Product Producto)
    {
        for (CarItem carItem : listaProductos)
        {
            if(carItem.getProducto().equals(Producto))
            {
                return true;
            }

        }
        return false;
    }

    public int getItemCount()
    {
        return this.listaProductos.size();
    }

    public List<CarItem> getItems()
    {
        return this.listaProductos;
    }

    public void removeItem(Product producto)
    {
        //Debemos iterar sobre la lista de CarItem y ver si el producto es igual al producto de CarItem
        for (CarItem carItem : listaProductos)
        {
            if(carItem.getProducto().equals(producto))
            {
                //Si el objeto es el mismo, lo sacamos de la lista
                this.listaProductos.remove(carItem);
                break;
                
            }   
        }
        System.out.println("asd");
    }

    public double calculateTotal(Boolean aplicaDescuento)
    {
        if (aplicaDescuento)
        {
            //Iterar sobre la lista de productos
            for (CarItem carItem : listaProductos)
            {
                double precioProducto = carItem.getProducto().getPrice();
                precioProducto -= precioProducto*0.20;
                int cantidadProducto = carItem.getQuantity();
                double precioSubTotal = precioProducto*cantidadProducto;
                total += precioSubTotal;
            }
        }

        else
        {
            //Iterar sobre la lista de productos
            for (CarItem carItem : listaProductos)
            {
                double precioProducto = carItem.getProducto().getPrice();
                int cantidadProducto = carItem.getQuantity();
                double precioSubTotal = precioProducto*cantidadProducto;
                total += precioSubTotal;
            }
        }

        return total;
    }

    public double calculateTotal()
    {
        //Iterar sobre la lista de productos
        for (CarItem carItem : listaProductos)
        {
            double precioProducto = carItem.getProducto().getPrice();
            int cantidadProducto = carItem.getQuantity();
            double precioSubTotal = precioProducto*cantidadProducto;
            total += precioSubTotal;
        }
        return this.total;
    }

}
