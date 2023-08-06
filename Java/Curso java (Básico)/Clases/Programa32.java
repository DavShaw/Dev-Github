import javax.swing.*; // extends JFrame
import java.awt.event.*; // implements ActionListener

public class Programa32 extends JFrame implements ActionListener{

    private JButton button_close, button_reset, button_add;
    private JTextField textfield1;
    private JTextArea textarea1;
    private JScrollPane scroll;
    String text = "";

    public Programa32(){
        setLayout(null);

        //JButton
        button_close = new JButton("Close");
        button_close.setBounds(450,25,100,20);
        button_close.addActionListener(this);
        add(button_close);

        button_reset = new JButton("Reset");
        button_reset.setBounds(350,25,100,20);
        button_reset.addActionListener(this);
        add(button_reset);

        button_add = new JButton("Add");
        button_add.setBounds(250,25,100,20);
        button_add.addActionListener(this);
        add(button_add);

        //JTextField
        textfield1 = new JTextField();
        textfield1.setBounds(10,25,200,30);
        add(textfield1);

        //JTextArea
        textarea1 = new JTextArea();
        //textarea1.setBounds(20,250,600,350);
        //add(textarea1);

        //JScrollPane
        scroll = new JScrollPane(textarea1);
        scroll.setBounds(40,150,500,450);
        add(scroll);
    }

    public void actionPerformed (ActionEvent v_button){

        if(v_button.getSource() == button_close){
            System.exit(0);

        } else if(v_button.getSource() == button_reset){
            textfield1.setText("");
            textarea1.setText("");

        } else if(v_button.getSource() == button_add){
            text = text + textfield1.getText() + "\n";
            textarea1.setText(text);
            textfield1.setText("");


        }
    }
    
    public static void main(String args[]){

        Programa32 i = new Programa32();

        i.setBounds(0,0,600,700);
        i.setLocationRelativeTo(null);
        i.setResizable(true);
        i.setVisible(true);

    }
    
}
