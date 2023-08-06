import javax.swing.*;

public class Programa25 extends JFrame{
    
    private JLabel text_1;
    private JLabel dev;

    public Programa25(){
        setLayout(null);

        text_1 = new JLabel("Graphic interface");
        text_1.setBounds(45, 20, 999, 20);
        add(text_1);

        String developer = "David Torres";

        dev = new JLabel("Dev. By: " + developer);
        dev.setBounds(75, 400, 999, 400);
        add(dev);
    }

    public static void main(String args[]){

        Programa25 interfaz = new Programa25();

        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);
        interfaz.setBounds(0, 0, 300, 800);
        interfaz.setResizable(false);



    }
}
