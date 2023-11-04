package General;
public interface CPU {
    
    public void setBrand(String brand);
    public void setModel(String model);
    public String getBrand();
    public String getModel();
    public <Generic> Generic prototype();
    
}
