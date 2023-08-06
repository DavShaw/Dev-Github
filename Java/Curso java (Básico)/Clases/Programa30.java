import javax.swing.*;
import java.awt.event.*;
public class Programa30 extends JFrame implements ActionListener{

    private JLabel label1, label2, label3;
    private JTextField textfield1, textfield2;
    private JTextArea textarea1;
    private JButton button1, button2, button3;
    private JScrollPane scroll1;


    public Programa30(){
        setLayout(null);


        // JLabel
        label1 = new JLabel("Message System");
        label1.setBounds(0,0,0,0);
        add(label1);

        label2 = new JLabel("From (+57)");
        label2.setBounds(200,10,100,30);
        add(label2);

        label3 = new JLabel("To (+54)");
        label3.setBounds(200,50,100,30);
        add(label3);

        // JTextField
        textfield1 = new JTextField("3107053966");
        textfield1.setBounds(270,10,100,30);
        add(textfield1);

        textfield2 = new JTextField("93875293605");
        textfield2.setBounds(270,50,100,30);
        add(textfield2);

        // JTextArea
        textarea1 = new JTextArea("""
                Este mensaje es una prueba

                Pulsa 'Send'
                """);
        //textarea1.setBounds(48,100,500,280);
        //add(textarea1);

        // JScrollPane
        scroll1 = new JScrollPane(textarea1);
        scroll1.setBounds(48,100,500,280);
        add(scroll1);


        // JButton
        button1 = new JButton("Close");
        button1.setBounds(5,0,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Clear");
        button2.setBounds(478,0,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Send");
        button3.setBounds(250,400,100,30);
        button3.addActionListener(this);
        add(button3);
    }

    public void actionPerformed (ActionEvent v_button){
        
        if(v_button.getSource()  == button1){
            System.exit(0);

        } else if(v_button.getSource()  == button2){
            textfield1.setText("");
            textfield2.setText("");
            textarea1.setText("");
        } else if(v_button.getSource()  == button3){
            String msg_sent_from = textfield1.getText();
            String msg_sent_to = textfield2.getText();
            textarea1.setText("Mensaje enviado a: " + msg_sent_to + " desde: " + msg_sent_from);
        }

    }
    

    public static void main(String args[]){

        Programa30 i = new Programa30();

        i.setBounds(0,0,600,500);
        i.setLocationRelativeTo(null);
        i.setVisible(true);
        i.setResizable(false);


    }
}
