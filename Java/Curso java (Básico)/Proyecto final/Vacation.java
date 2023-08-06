import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Vacation extends JFrame implements ActionListener,ItemListener{

    private JMenuBar menubar;
    private JMenu menu_logout_main,menu_clear_main,menu_screen_main,menu_about_main;
    private JMenuItem menu_logout_logout,menu_logout_logout2,menu_clear_clear,menu_screen_dark,menu_screen_light,menu_screen_default,menu_about_about;
    private JLabel label_name,label_lastname,label_departament,label_servicetime,label_logo,label_copyright;
    private JTextField textfield_name, textfield_lastname;
    private JComboBox combobox_departament,combobox_servicetime;
    private JTextArea textarea_result;
    private JButton button_knowit;

    public Vacation(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(54,90,212));
        setIconImage(new ImageIcon(getClass().getResource("images/title_icon.png")).getImage());
        setTitle("David Air System");

        //JMenuBar
        menubar = new JMenuBar();
        menubar.setBackground(new Color(54,90,212));
        setJMenuBar(menubar);
        //JMenu
        menu_logout_main = new JMenu("Logout");
        menu_logout_main.addActionListener(this);
        menu_logout_main.setForeground(new Color(0,0,0));
        menubar.add(menu_logout_main);

        menu_clear_main = new JMenu("Clear");
        menu_clear_main.addActionListener(this);
        menu_clear_main.setForeground(new Color(0,0,0));
        menubar.add(menu_clear_main);

        menu_screen_main = new JMenu("Screen");
        menu_screen_main.addActionListener(this);
        menu_screen_main.setForeground(new Color(0,0,0));
        menubar.add(menu_screen_main);

        menu_about_main = new JMenu("About");
        menu_about_main.addActionListener(this);
        menu_about_main.setForeground(new Color(0,0,0));
        menubar.add(menu_about_main);
        //JMenuItem
        menu_logout_logout = new JMenuItem("Main menu");
        menu_logout_logout.addActionListener(this);
        menu_logout_main.add(menu_logout_logout);

        menu_logout_logout2 = new JMenuItem("Exit");
        menu_logout_logout2.addActionListener(this);
        menu_logout_main.add(menu_logout_logout2);

        menu_clear_clear = new JMenuItem("Clear fields");
        menu_clear_clear.addActionListener(this);
        menu_clear_main.add(menu_clear_clear);

        menu_screen_dark = new JMenuItem("Dark mode");
        menu_screen_dark.addActionListener(this);
        menu_screen_main.add(menu_screen_dark);

        menu_screen_light = new JMenuItem("Light mode");
        menu_screen_light.addActionListener(this);
        menu_screen_main.add(menu_screen_light);

        menu_screen_default = new JMenuItem("Default mode");
        menu_screen_default.addActionListener(this);
        menu_screen_main.add(menu_screen_default);

        menu_about_about = new JMenuItem("Who we are");
        menu_about_about.addActionListener(this);
        menu_about_main.add(menu_about_about);
        //JLabel
        label_name = new JLabel("Name");
        label_name.setBounds(15,25,100,30);
        label_name.setForeground(new Color(0,0,0));
        add(label_name);
        label_lastname = new JLabel("Last name");
        label_lastname.setBounds(15,75,100,30);
        label_lastname.setForeground(new Color(0,0,0));
        add(label_lastname);
        label_departament = new JLabel("Departament");
        label_departament.setBounds(15,130,100,30);
        label_departament.setForeground(new Color(0,0,0));
        add(label_departament);
        label_servicetime = new JLabel("Service time");
        label_servicetime.setBounds(15,180,100,30);
        label_servicetime.setForeground(new Color(0,0,0));
        add(label_servicetime);
        ImageIcon image_label_logo = new ImageIcon("images/dark.png");
        label_logo = new JLabel(image_label_logo);
        label_logo.setBounds(15,290,250,50);
        add(label_logo);
        label_copyright = new JLabel("© 2002 - 2022 David Air LLC");
        label_copyright.setBounds(0,0,0,0);
        add(label_copyright);
        //JTextField
        textfield_name = new JTextField();//Name field
        textfield_name.setBounds(100,30,100,20);
        add(textfield_name);
        textfield_lastname = new JTextField();//Lastname field
        textfield_lastname.setBounds(100,80,100,20);
        add(textfield_lastname);
        //JComboBox
        combobox_departament = new JComboBox<>();
        combobox_departament.setBounds(100,135,140,20);
        combobox_departament.addItem("");
        combobox_departament.addItem("Customer support");
        combobox_departament.addItem("Logistics");
        combobox_departament.addItem("Management");
        combobox_departament.addItemListener(this);

        add(combobox_departament);
        combobox_servicetime = new JComboBox<>();
        combobox_servicetime.setBounds(100,185,140,20);
        combobox_servicetime.addItem("");
        combobox_servicetime.addItem("1 year");
        combobox_servicetime.addItem("Between 2 and 6 years");
        combobox_servicetime.addItem("7 years (or more)");
        combobox_servicetime.addItemListener(this);
        add(combobox_servicetime);
        //JTextArea
        textarea_result = new JTextArea("\n\n                                           Vacation system" +
        "\n\n\n           If you want to know the vacation days to which you"+
        "\n           are entitled, please, fill in the blanks that are" +
        "\n           at your left side.");
        textarea_result.setBounds(400,30,360,220);
        textarea_result.setEditable(false);
        add(textarea_result);
        //JButton
        button_knowit = new JButton("Let's know it");
        button_knowit.addActionListener(this);
        button_knowit.setBounds(480,305,200,30);
        add(button_knowit);
    }
    public void actionPerformed(ActionEvent a_e){
        //Config de system
        String text1 = textfield_name.getText();
        String text2 = textfield_lastname.getText();
        String box1 = combobox_departament.getSelectedItem().toString();
        String box2 = combobox_servicetime.getSelectedItem().toString();
        if(a_e.getSource() == button_knowit){
            if(text1.equals("") || text2.equals("") || box1.equals("") || box2.equals("")){
                JOptionPane.showMessageDialog(null, "You must fill in all blanks");}

            //Customer support (Dpt 1)
            if(box1.equals("Customer support")){
                if(box2.equals("1 year")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 6 days of vacation");}

                else if(box2.equals("Between 2 and 6 years")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 14 days of vacation");}

                else if(box2.equals("7 years (or more)")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 20 days of vacation");}}

            //Logistics
            if(box1.equals("Logistics")){
                if(box2.equals("1 year")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 7 days of vacation");}

                else if(box2.equals("Between 2 and 6 years")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 15 days of vacation");}

                else if(box2.equals("7 years (or more)")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 22 days of vacation");}}

            //Management
            if(box1.equals("Management")){
                if(box2.equals("1 year")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 10 days of vacation");}

                else if(box2.equals("Between 2 and 6 years")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 20 days of vacation");}

                else if(box2.equals("7 years (or more)")){
                    textarea_result.setText("\n\n                                           Vacation system\n\n"+
                    "\n\n\n           "+text1+", you're working in " +box1 +
                    "\n           and you are entitled to 30 days of vacation");}}
            
        }

        //Config de JMenu y variados
        if(a_e.getSource() == menu_screen_light){
            getContentPane().setBackground(new Color(255,255,255));
            menubar.setBackground(new Color(255,255,255));
            label_logo.setText("images/dark.png");}

        if(a_e.getSource() == menu_screen_dark){
            getContentPane().setBackground(new Color(205,205,205));
            menubar.setBackground(new Color(205,205,205));
            label_logo.setText("images/dark.png");}

        if(a_e.getSource() == menu_screen_default){
            getContentPane().setBackground(new Color(54,90,212));
            menubar.setBackground(new Color(54,90,212));
            label_logo.setText("images/dark.png");
            label_name.setForeground(new Color(0,0,0));
            label_lastname.setForeground(new Color(0,0,0));
            label_departament.setForeground(new Color(0,0,0));
            label_servicetime.setForeground(new Color(0,0,0));
            menu_logout_main.setForeground(new Color(0,0,0));
            menu_clear_main.setForeground(new Color(0,0,0));
            menu_screen_main.setForeground(new Color(0,0,0));
            menu_about_main.setForeground(new Color(0,0,0));}

        if(a_e.getSource() == menu_clear_clear){
            textfield_name.setText("");
            textfield_lastname.setText("");
            textarea_result.setText("\n\n                                           Vacation system" +
            "\n\n\n           If you want to know the vacation days to which you"+
            "\n           are entitled, please, fill in the blanks that are" +
            "\n           at your left side.");
            combobox_departament.setSelectedItem("");
            combobox_servicetime.setSelectedItem("");}
        if(a_e.getSource() == menu_about_about){
            JOptionPane.showMessageDialog(null, "\n\n"+"David Air is a Colombian company founded in 2002."+"\nOur mision is to bring drugs to all corners of the world"+"\n\n               Software by: David Torres");
        }
        if(a_e.getSource() == menu_logout_logout2){System.exit(0);}

        if(a_e.getSource() == menu_logout_logout){
            this.setVisible(false);
            Welcome i_welcome = new Welcome();
            i_welcome.setBounds(0,0,350,450);
            i_welcome.setLocationRelativeTo(null);
            i_welcome.setResizable(false);
            i_welcome.setVisible(true);
        }
    }
    public void itemStateChanged(ItemEvent i_e){}
    
    public static void main(String args[]){
        Vacation i_vacation = new Vacation();
        i_vacation.setBounds(0,0,850,430);
        i_vacation.setVisible(true);
        i_vacation.setResizable(false);
        i_vacation.setLocationRelativeTo(null);
    }
    
}