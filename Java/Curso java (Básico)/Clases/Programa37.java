import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Programa37 extends JFrame implements ActionListener{

    //Color
    Color yellow = new Color(255,255,0);
    Color blue = new Color(0,0,255);
    Color red = new Color(255,0,0);

    private JMenuBar menu_bar;
    private JMenu menu_options;

    private JMenuItem menu_options_size, menu_options_colors;
    //SubMenus
    private JMenuItem menu_options_size1, menu_options_size2, menu_options_size3;
    private JMenuItem menu_options_colors_y, menu_options_colors_b, menu_options_colors_r;

    public Programa37(){
        setLayout(null);

        //JMenuBar
        menu_bar = new JMenuBar();
        setJMenuBar(menu_bar);
        //JMenu
        menu_options = new JMenu("Options");
        menu_options.addActionListener(this);
        menu_bar.add(menu_options);
        //JMenu (Into menu_options)
        menu_options_size = new JMenu("Chage screen size");
        menu_options.add(menu_options_size);

        menu_options_colors = new JMenu("Print it with colors!");
        menu_options.add(menu_options_colors);
        //JMenuItem (Into menu_options_colors)
        menu_options_colors_y = new JMenuItem("Yellow");
        menu_options_colors_y.addActionListener(this);
        menu_options_colors.add(menu_options_colors_y);

        menu_options_colors_b = new JMenuItem("Blue");
        menu_options_colors_b.addActionListener(this);
        menu_options_colors.add(menu_options_colors_b);

        menu_options_colors_r = new JMenuItem("Red");
        menu_options_colors_r.addActionListener(this);
        menu_options_colors.add(menu_options_colors_r);

        //JMenuItem (Into menu_options_size)
        menu_options_size1 = new JMenuItem("800*600");
        menu_options_size1.addActionListener(this);
        menu_options_size.add(menu_options_size1);

        menu_options_size2 = new JMenuItem("1024*720");
        menu_options_size2.addActionListener(this);
        menu_options_size.add(menu_options_size2);

        menu_options_size3 = new JMenuItem("1366*966");
        menu_options_size3.addActionListener(this);
        menu_options_size.add(menu_options_size3);
    }
    public void actionPerformed (ActionEvent event){
        Container bg = this.getContentPane();
        
        //Background color
        if(event.getSource() == menu_options_colors_y){
            bg.setBackground(yellow);
        }

        if(event.getSource() == menu_options_colors_b){
            bg.setBackground(blue);
        }

        if(event.getSource() == menu_options_colors_r){
            bg.setBackground(red);
        }

        //Screen size
        if(event.getSource() == menu_options_size1){
            setSize(800,600);
        }

        if(event.getSource() == menu_options_size2){
            setSize(1024,720);
        }

        if(event.getSource() == menu_options_size3){
            setSize(1366,966);
        }
    }
    
    public static void main(String args[]){
        Programa37 i = new Programa37();

        i.setBounds(0,0,350,200);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
        i.setResizable(false);

    }



    



}
