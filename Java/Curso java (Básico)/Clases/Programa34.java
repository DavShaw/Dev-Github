import  javax.swing.*;
import java.awt.event.*;

public class Programa34 extends JFrame implements ItemListener, ActionListener{

    private JLabel label1, label2, label3;
    private JComboBox combo1, combo2;
    private JButton button1;
    String user_name = "", user_age = "";
    public Programa34(){
        setLayout(null);

        label1 = new JLabel("Choose your age");
        label1.setBounds(10,15,100,30);
        add(label1);

        label2 = new JLabel("Choose your name");
        label2.setBounds(10,50,130,30);
        add(label2);

        label3 = new JLabel("");
        label3.setBounds(10,85,999,30);
        add(label3);

        combo1 = new JComboBox<>();
        combo1.setBounds(150,15,160,30);
        combo1.addItem("What's your age?");
        combo1.addItem("you're 0 - 10 years old");
        combo1.addItem("you're 11 - 20 years old");
        combo1.addItem("you're 21 - 30 years old");
        combo1.addItem("you're 31 - 40 years old");
        combo1.addItem("you're 41 - 50 years old");
        combo1.addItem("you're 50 + years old");
        combo1.addItemListener(this);
        add(combo1);

        combo2 = new JComboBox<>();
        combo2.setBounds(150,50,160,30);
        combo2.addItem("What's your name?");
        combo2.addItem("David");
        combo2.addItem("Nicolás");
        combo2.addItemListener(this);
        add(combo2);

        button1 = new JButton("Add");
        button1.setBounds(15,150,80,30);
        button1.addActionListener(this);
        add(button1);
    }

    public void itemStateChanged(ItemEvent v_combo12){
        if(v_combo12.getSource() == combo1){
            user_age = combo1.getSelectedItem().toString();
        } else {
        }

        if(v_combo12.getSource() == combo2){
            user_name = combo2.getSelectedItem().toString();
        } else {
        }
    }
    public void actionPerformed(ActionEvent v_button1){
        if(v_button1.getSource() == button1){
            label3.setText("You're " + user_name + " and " + user_age);
        }

    }

    public static void main(String args[]){
        Programa34 i = new Programa34();

        i.setBounds(0,0,400,230);
        i.setVisible(true);
        i.setResizable(false);
        i.setLocationRelativeTo(null);

    }
}