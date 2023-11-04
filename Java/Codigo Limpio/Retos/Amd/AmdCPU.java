package Amd;

import General.CPU;

public class AmdCPU implements CPU {

    private String brand;

    public AmdCPU(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    private String model;

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
    public AmdCPU prototype() {
        return new AmdCPU(this.brand, this.model);
    }
    
}
