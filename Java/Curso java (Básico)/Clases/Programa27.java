import javax.swing.*;
import java.awt.event.*;

public class Programa27 extends JFrame implements ActionListener{

    JButton button_close;
    
    public Programa27(){
     setLayout(null);

     button_close = new JButton("Close");
     button_close.setBounds(300,250,100,30);
     add(button_close);
     button_close.addActionListener(this);
    }  

    public void actionPerformed(ActionEvent button_close_variable){

        if(button_close_variable.getSource() == button_close){
            System.exit(0);
        }
    }

        public static void main(String args[]){

            Programa27 interfaz = new Programa27();
            
            interfaz.setBounds(0,0,450,350);
            interfaz.setVisible(true);
            interfaz.setLocationRelativeTo(null);
    }
}