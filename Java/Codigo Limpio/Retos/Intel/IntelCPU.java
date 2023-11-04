package Intel;

import General.CPU;

public class IntelCPU implements CPU {

    private String brand;

    public IntelCPU(String brand, String model) {
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
    public IntelCPU prototype() {
        return new IntelCPU(this.brand, this.model);
    }
    
}
