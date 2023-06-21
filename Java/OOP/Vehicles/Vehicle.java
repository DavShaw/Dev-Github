package OOP.Vehicles;

public class Vehicle
{

    private String brand;
    private String model;
    private float price;

    public Vehicle(String brand, String model, float price)
    {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String toString()
    {
        String representation = "";
        representation += "Vehicle made by %s, its model is %s and its cost is %s".formatted(this.brand, this.model, this.price);
        return representation;
    }

    //Set methods
    public void setBrand(String newBrand)
    {
        this.brand = newBrand;
    }

    public void setModel(String newModel)
    {
        this.model = newModel;
    }

    public void setPrice(float newPrice)
    {
        this.price = newPrice;
    }


    //Get methods
    public String getBrand()
    {
        return this.brand;
    }

    public String getModel()
    {
        return this.model;
    }

    public float getPrice()
    {
        return this.price;
    }
    
}
