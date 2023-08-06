import javax.swing.*;

public class Programa24 extends JFrame{

    private JLabel system_message_1;
    private JLabel system_message_2;
    private JLabel year;
    
    public Programa24(){
    setLayout(null); 

    system_message_1 = new JLabel("Graphy System");
    system_message_1.setBounds(200, 20, 999, 20);
    add(system_message_1);

    system_message_2 = new JLabel("Dev by: David Torres");
    system_message_2.setBounds(185, 80, 999, 80);
    add(system_message_2);

    year = new JLabel("Copyright: 2018 - 2022");
    year.setBounds(350, 200, 999, 200);
    add(year);
    }

    public static void main(String args[]){
        Programa24 interfaz_1 = new Programa24();

        interfaz_1.setBounds(0,0,500,350);
        interfaz_1.setVisible(true);
        interfaz_1.setLocationRelativeTo(null);




    }
}