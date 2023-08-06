import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Programa35 extends JFrame implements ActionListener{

    private JLabel red, green, blue;
    private JButton button_set, button_reset, button_color;
    private JComboBox combo_red, combo_green, combo_blue;

    public Programa35(){
        setLayout(null);

        // Jlabel
        red = new JLabel("Red");
        red.setBounds(20, 20, 100, 30);
        add(red);

        green = new JLabel("Green");
        green.setBounds(20, 60, 100, 30);
        add(green);

        blue = new JLabel("Blue");
        blue.setBounds(20, 100, 100, 30);   
        add(blue);

        // JcomboBox
        combo_red = new JComboBox<>();
        combo_red.setBounds(100,20,80,30);
        add(combo_red);
        for(int repiter = 0; repiter <=255 ; repiter+=1){
            combo_red.addItem(String.valueOf(repiter));
        }

        combo_green = new JComboBox<>();
        combo_green.setBounds(100,60,80,30);
        add(combo_green);
        for(int repiter = 0; repiter <=255 ; repiter+=1){
            combo_green.addItem(String.valueOf(repiter));
        }

        combo_blue = new JComboBox<>();
        combo_blue.setBounds(100,100,80,30);
        add(combo_blue);
        for(int repiter = 0; repiter <=255 ; repiter+=1){
            combo_blue.addItem(String.valueOf(repiter));
        }

        //
        button_set = new JButton("Set");
        button_set.setBounds(10,325,80,30);
        button_set.addActionListener(this);
        add(button_set);

        button_reset = new JButton("Reset");
        button_reset.setBounds(145,325,80,30);
        button_reset.addActionListener(this);
        add(button_reset);

        button_color = new JButton("I love this color");
        button_color.setBounds(0,200,250,45);
        add(button_color);
    }
    
    public void actionPerformed (ActionEvent JButton){
        
        if(JButton.getSource() == button_reset){

            Color color_reseted = new Color(255,255,255);
            button_color.setBackground(color_reseted);

        } else if (JButton.getSource() == button_set){

            String set1 = combo_red.getSelectedItem().toString(); 
            String set2 = combo_green.getSelectedItem().toString();
            String set3 = combo_blue.getSelectedItem().toString();

            int red = Integer.parseInt(set1);
            int green = Integer.parseInt(set2);
            int blue = Integer.parseInt(set3);

            Color color1 = new Color(red,green,blue);
            button_color.setBackground(color1);
        }
    }
    public static void main(String args[]){
        Programa35 i = new Programa35();
        
        i.setBounds(0,0,250,400);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
        i.setResizable(false);
    }
}
