import javax.swing.*;

public class Programa26 extends JFrame{

    private JLabel text1;
    private JLabel text2;

    public Programa26(){
        setLayout(null);

        text1 = new JLabel("Interfaz gráfica");
        text1.setBounds(150,20,999,20);
        add(text1);

        text2 = new JLabel("v: 26.02");
        text2.setBounds(150,80,999,80);
        add(text2);
    }

    public static void main(String args[]){

        Programa26 interfaz = new Programa26();
        
        interfaz.setBounds(0,0,500,300);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);




    }
}
