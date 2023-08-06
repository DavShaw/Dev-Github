import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Programa39 extends JFrame implements ActionListener, ItemListener, ChangeListener{

    private JLabel label1;
    private JCheckBox checkbox_tc;
    private JComboBox combobox1;
    private JButton button_agree;
    

    public Programa39(){
        setLayout(null);
        setTitle("T&C doesn't agreed");

        //JLabel
        label1 = new JLabel("Do you agree term and conditions of NPD LLC?");
        label1.setBounds(15,15,400,30);
        add(label1);
        //JCheckBox
        checkbox_tc = new JCheckBox("Yes, I do");
        checkbox_tc.setBounds(15,80,80,30);
        checkbox_tc.addChangeListener(this);
        add(checkbox_tc);
        //JComboBox
        combobox1 = new JComboBox<>();
        combobox1.setBounds(150,80,80,30);
        combobox1.addItemListener(this);
        combobox1.addItem("White");
        combobox1.addItem("Yellow");
        combobox1.addItem("Light green");
        combobox1.addItem("Red");
        add(combobox1);
        //JButton
        button_agree = new JButton("Next page");
        button_agree.setBounds(180,200,100,30);
        button_agree.setEnabled(false);
        button_agree.addActionListener(this);
        add(button_agree);


    }
    public void actionPerformed(ActionEvent a_e){
        if(a_e.getSource() == button_agree){}
        setTitle("T&C agreed");
    }

    public void stateChanged(ChangeEvent c_e){
        if(checkbox_tc.isSelected() == true){
            button_agree.setEnabled(true);
        }

        if(checkbox_tc.isSelected() == false){
            button_agree.setEnabled(false);
            setTitle("T&C doesn't agreed");
        }
    }

    public void itemStateChanged(ItemEvent i_e){
        Container bg = this.getContentPane();

        if(i_e.getSource() == combobox1){
            String color_taken = combobox1.getSelectedItem().toString();

            if(color_taken.equals("White")){
                Color White = new Color(255,255,255);
                bg.setBackground(White);
            }

            if(color_taken.equals("Yellow")){
                Color Yellow = new Color(255,255,0);
                bg.setBackground(Yellow);
            }

            if(color_taken.equals("Light green")){
                Color Light_green = new Color(0,128,0);
                bg.setBackground(Light_green);
            }

            if(color_taken.equals("Red")){
                Color Red = new Color(255,76,76);
                bg.setBackground(Red);
            }
        }

    }

    public static void main(String args[]){
        Programa39 i = new Programa39();

        i.setBounds(0,0,500,300);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
        i.setResizable(false);
    }
}
