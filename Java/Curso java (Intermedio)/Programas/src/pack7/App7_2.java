package pack7;

public class App7_2
{
    private int base, height, area;

    public App7_2(int base, int height, int area){
        this.base = base;
        this.height = height;
        this.area = area;
    }

    public void Operation(){
        area = base * height;
        System.out.println("The area of base " + base + " and height " + height + " is: " + area);
    }
    
}
