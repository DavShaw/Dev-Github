import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Programa36 extends JFrame implements ActionListener{

    private JMenuBar menu_bar;
    private JMenu menu_colors, menu_admin;
    private JMenuItem menu_colors_y, menu_colors_b, menu_colors_r;
    private JMenuItem menu_admin_reset, menu_admin_close;

    public Programa36(){
        setLayout(null);

        // JMenuBar
        menu_bar = new JMenuBar();
        setJMenuBar(menu_bar);

        // JMenu
        menu_colors = new JMenu("Colors");
        menu_colors.addActionListener(this);
        menu_bar.add(menu_colors);

        menu_admin = new JMenu("Admin");
        menu_admin.addActionListener(this);
        menu_bar.add(menu_admin); 

        // JMenuItem (menu_colors)
        menu_colors_y = new JMenuItem("Yellow");
        menu_colors_y.addActionListener(this);
        menu_colors.add(menu_colors_y);

        menu_colors_b = new JMenuItem("Blue");
        menu_colors_b.addActionListener(this);
        menu_colors.add(menu_colors_b);

        menu_colors_r = new JMenuItem("Red");
        menu_colors_r.addActionListener(this);
        menu_colors.add(menu_colors_r);

        // JMenuItem (menu admin)
        menu_admin_reset = new JMenuItem("Reset");
        menu_admin_reset.addActionListener(this);
        menu_admin.add(menu_admin_reset);

        menu_admin_close = new JMenuItem("Close");
        menu_admin_close.addActionListener(this);
        menu_admin.add(menu_admin_close);
    }

    public void actionPerformed (ActionEvent event){

        Container bg = this.getContentPane();

        // config for: conditions to menu colors (and its items into menu)
        if(event.getSource() == menu_colors_y){
            bg.setBackground(new Color(255,255,0));
        }

        if(event.getSource() == menu_colors_b){
            bg.setBackground(new Color(0,0,255));
        }

        if(event.getSource() == menu_colors_r){
            bg.setBackground(new Color(255,0,0));
        }

        // config for: conditions to menu colors (and its items into menu)
        if(event.getSource() == menu_admin_close){
            System.exit(0);
        }
        
        if(event.getSource() == menu_admin_reset){
            bg.setBackground(new Color(255,255,255));
        }
    }

    public static void main(String args[]){
        Programa36 i = new Programa36();

        i.setBounds(0,0,350,200);
        i.setVisible(true);
        i.setResizable(false);
        i.setLocationRelativeTo(null);


    }


}