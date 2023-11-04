package General;
public interface RAM {

    public void setBrand(String brand);
    public void setModel(String model);
    public String getBrand();
    public String getModel();
    public <Generic> Generic prototype();
    
}