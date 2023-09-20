package org.davshaw.autos;

import org.davshaw.external.Color;

public class Car
{

    //! Variables de clases
    private static int idCounter = 0;

    //? Variables de instancia
    private int id;
    private String brand;
    private String model;
    private int fabricationYear;
    private double costPerDay;

    public Car
                (String brand,
                String model,
                int fabricationYear,
                double costPerDay)
    {
        this.id = (++idCounter);
        this.brand = brand;
        this.model = model;
        this.fabricationYear = fabricationYear;
        this.costPerDay = costPerDay;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFabricationYear() {
        return this.fabricationYear;
    }

    public void setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public double getCostPerDay() {
        return this.costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    @Override
    public String toString()
    {
        return String.format("(%s) %s: %s [>%s<]", Color.color("RED", this.id), Color.color("YELLOW",this.brand), Color.color("CYAN", this.model), Color.color("MAGENTA",this.fabricationYear));
    }

    public String getView()
    {
        String view = "";
        view += "=-=-=-=-=-=-=-=\n";
        view += this.brand + "\n";
        view += this.model + "\n";
        view += this.fabricationYear + "\n";
        view += this.costPerDay + "\n";
        view += "=-=-=-=-=-=-=-=";
        return view;
    }
}
