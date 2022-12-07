import javax.swing.*;
import java.awt.event.*;

public class Programa33 extends JFrame implements ActionListener{
    private JLabel value1, value2, result;
    private JTextField textfield1, textfield2;
    private JButton button_plus, button_close;

    public Programa33(){
        setLayout(null);

        //JLabel
        value1 = new JLabel("Vaule 1:");
        value1.setBounds(50,5,100,30);
        add(value1);

        value2 = new JLabel("Vaule 2:");
        value2.setBounds(50,35,100,30);
        add(value2);

        result = new JLabel("Result: 0");
        result.setBounds(150,80,100,30);
        add(result);

        //JTextField
        textfield1 = new JTextField("");
        textfield1.setBounds(120,5,150,30);
        add(textfield1);

        textfield2 = new JTextField("");
        textfield2.setBounds(120,35,150,30);
        add(textfield2);

        //JButton
        button_plus = new JButton("Sumar");
        button_plus.setBounds(10,80,100,30);
        button_plus.addActionListener(this);
        add(button_plus);

        button_close = new JButton("Close");
        button_close.setBounds(0,0,0,0);
        button_close.addActionListener(this);
        add(button_close);
    }

    public void actionPerformed(ActionEvent v_button){
        if(v_button.getSource() == button_plus){
            int vaule1 = 0, vaule2, resultado = 0;
            vaule1 = Integer.parseInt(textfield1.getText());
            vaule2 = Integer.parseInt(textfield2.getText());
            resultado = vaule1 + vaule2;
            result.setText("Result: " + resultado);
        }     
    }

    public static void main(String args[]){

        Programa33 i = new Programa33();

        i.setBounds(0,0,300,150);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
    }
}
