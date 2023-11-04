package Intel;

import General.GPU;

public class IntelGPU implements GPU {

    private String brand;
    private String model;

    public IntelGPU(String brand, String model) {
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
    public IntelGPU prototype() {
        return new IntelGPU(this.brand, this.model);
    }
    
}
