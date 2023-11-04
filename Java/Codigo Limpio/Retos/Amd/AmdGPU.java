package Amd;

import General.GPU;

public class AmdGPU implements GPU{

    private String brand;
    private String model;

    public AmdGPU(String brand, String model) {
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
    public AmdGPU prototype() {
        return new AmdGPU(this.brand, this.model);
    }
    
}
