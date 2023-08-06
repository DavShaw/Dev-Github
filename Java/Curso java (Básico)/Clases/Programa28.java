import javax.swing.*;
import java.awt.event.*;

public class Programa28 extends JFrame implements ActionListener{

    private JButton button1, button2, button3, button4;
    private JLabel text1;

    public Programa28(){
        setLayout(null);

        text1 = new JLabel("¡Pulsa un botón!");
        text1.setBounds(10,10,300,30);
        add(text1);

        //

        button1 = new JButton("#1");
        button1.setBounds(20,100,90,30);
        add(button1);
        button1.addActionListener(this);

        button2 = new JButton("#2");
        button2.setBounds(120,100,90,30);
        add(button2);
        button2.addActionListener(this);

        button3 = new JButton("#3");
        button3.setBounds(220,100,90,30);
        add(button3);
        button3.addActionListener(this);

        button4 = new JButton("Salir");
        button4.setBounds(220,10,100,30);
        add(button4);
        button4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent button123_variable){

        if(button123_variable.getSource() == button1){
            text1.setText("Has selecionado SUMA");

        } else if(button123_variable.getSource() == button2){
            text1.setText("Has selecionado RESTA");

        } else if(button123_variable.getSource() == button3){
            text1.setText("Has selecionado MULTIPLICACIÓN");
        } else if(button123_variable.getSource() == button4){
            System.exit(0);
        }
    } 
    
    public static void main(String args[]){

        Programa28 i = new Programa28();

        i.setBounds(0,0,350,200);
        i.setVisible(true);
        i.setResizable(false);
        i.setLocationRelativeTo(null);



    }
}
