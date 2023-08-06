import javax.swing.*;
import java.awt.event.*;

public class Programa29 extends JFrame implements ActionListener{

    private JLabel label_text1, label_text2;
    private JButton button1;
    private JTextField text1, text2;

    String saved_user_name1 = "cuchy_torres@hotmail.com";
    String saved_user_pass1 = "1022";


    public Programa29(){
        setLayout(null);


        //      JLabel
        label_text1 = new JLabel("Nombre:");
        label_text1.setBounds(10,10,100,30);
        add(label_text1);

        label_text2 = new JLabel("Contraseña:");
        label_text2.setBounds(10,60,100,30);
        add(label_text2);

        //          JTextField
        text1 = new JTextField();
        text1.setBounds(120,17,150,20);
        add(text1);

        text2 = new JTextField();
        text2.setBounds(120,67,150,20);
        add(text2);

        //          JButton
        button1 = new JButton("Iniciar sesión");
        button1.setBounds(70,120,150,30);
        add(button1);
        button1.addActionListener(this);
    }
        
        public void actionPerformed(ActionEvent button1_v){

            if(button1_v.getSource() == button1){
                String user_name = text1.getText();
                String user_pass = text2.getText();

                if(user_name.equals(saved_user_name1)&& user_pass.equals(saved_user_pass1)){

                    setTitle("Aceptado");
                } else {
                    setTitle("Denegado");
                }
            }
    }

    public static void main(String args[]){

        Programa29 i = new Programa29();

        i.setBounds(0,0,300,200);
        i.setLocationRelativeTo(null);
        i.setResizable(false);
        i.setVisible(true);


    }
}
