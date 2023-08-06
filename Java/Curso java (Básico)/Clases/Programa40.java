import javax.swing.*;
import javax.swing.event.*;

public class Programa40 extends JFrame implements ChangeListener{

    private JLabel label_choose_size, label_choose_title;
    // Privates to choose_size
    private JRadioButton choose_size_1, choose_size_2, choose_size_3, choose_size_none;
    private ButtonGroup choose_size;
    // Private sto choose_title
    private JRadioButton choose_title_1, choose_title_2, choose_title_3, choose_title_none;
    private ButtonGroup choose_title;

    public Programa40(){
        setLayout(null);

        //JLabel
        label_choose_size = new JLabel("Choose screen size");
        label_choose_size.setBounds(20,20,200,30);
        add(label_choose_size);

        label_choose_title = new JLabel("Choose screen title");
        label_choose_title.setBounds(330,20,200,30);
        add(label_choose_title);
        //ButtonGroup
        choose_size = new ButtonGroup();
        choose_title = new ButtonGroup();
        //JRadioButton
        choose_size_1 = new JRadioButton("550x350");
        choose_size_1.setBounds(20,70,150,30);
        choose_size_1.addChangeListener(this);
        choose_size.add(choose_size_1);
        add(choose_size_1);

        choose_size_2 = new JRadioButton("750x500");
        choose_size_2.setBounds(20,110,150,30);
        choose_size_2.addChangeListener(this);
        choose_size.add(choose_size_2);
        add(choose_size_2);

        choose_size_3 = new JRadioButton("960x650");
        choose_size_3.setBounds(20,150,150,30);
        choose_size_3.addChangeListener(this);
        choose_size.add(choose_size_3);
        add(choose_size_3);

        choose_size_none = new JRadioButton("Default size");
        choose_size_none.setBounds(20,190,150,30);
        choose_size_none.addChangeListener(this);
        choose_size.add(choose_size_none);
        add(choose_size_none);

        choose_title_1 = new JRadioButton("I hate java");
        choose_title_1.setBounds(330,70,200,30);
        choose_title_1.addChangeListener(this);
        choose_title.add(choose_title_1);
        add(choose_title_1);

        choose_title_2 = new JRadioButton("I like java");
        choose_title_2.setBounds(330,110,200,30);
        choose_title_2.addChangeListener(this);
        choose_title.add(choose_title_2);
        add(choose_title_2);

        choose_title_3 = new JRadioButton("I love java");
        choose_title_3.setBounds(330,150,200,30);
        choose_title_3.addChangeListener(this);
        choose_title.add(choose_title_3);
        add(choose_title_3);

        choose_title_none = new JRadioButton("I don't feel anything");
        choose_title_none.setBounds(330,190,200,30);
        choose_title_none.addChangeListener(this);
        choose_title.add(choose_title_none);
        add(choose_title_none);
    }

    public void stateChanged(ChangeEvent c_e){
        // Config to choose_size
        if(choose_size_1.isSelected()){setSize(550,350);}

        if(choose_size_2.isSelected()){setSize(750,500);}

        if(choose_size_3.isSelected()){setSize(960,650);}

        if(choose_size_none.isSelected()){setSize(500,300);}

        // Config to choose_title
        if(choose_title_1.isSelected()){setTitle("I HATE java");}

        if(choose_title_2.isSelected()){setTitle("I LIKE java");}

        if(choose_title_3.isSelected()){setTitle("I LOVE java");}

        if(choose_title_none.isSelected()){setTitle("");}
    }
    
    public static void main(String args[]){
        Programa40 i = new Programa40();

        i.setBounds(0,0,500,300);
        i.setVisible(true);
        i.setResizable(false);
        i.setLocationRelativeTo(null);

    }
}
