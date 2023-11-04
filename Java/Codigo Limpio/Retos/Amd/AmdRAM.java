package Amd;

import General.RAM;

public class AmdRAM implements RAM{

    private String brand;
    private String model;


    public AmdRAM(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }


    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public AmdRAM prototype() {
        return new AmdRAM(this.brand, this.model);
    }
    
}
