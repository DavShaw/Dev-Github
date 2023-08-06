import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//jar cvfm David Air LLC.jar manifest.mf Welcome.class T_C.class Vacation.class images/original.png images/dark.png images/light.png images/title_icon.png
public class Welcome extends JFrame implements ActionListener{
    
    private JLabel label_welcome_logo_original, label_welcome_msg1, label_welcome_msg2,label_welcome_msg3,label_welcome_msg4;
    private JTextField textfield_name;
    private JTextField passfield;
    private JButton button_login;
    

    public Welcome(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Welcome to David Air LLC");
        getContentPane().setBackground(new Color(54,90,212));
        setIconImage(new ImageIcon(getClass().getResource("images/title_icon.png")).getImage());

        ImageIcon img_original = new ImageIcon("images/original.png");
        label_welcome_logo_original = new JLabel(img_original);
        label_welcome_logo_original.setBounds(22,0,300,150);
        add(label_welcome_logo_original);

        label_welcome_msg1 = new JLabel("Vacation control system");
        label_welcome_msg1.setBounds(60,135,300,30);
        label_welcome_msg1.setFont(new Font("Courier",3,18));
        label_welcome_msg1.setForeground(new Color(255,255,255));
        add(label_welcome_msg1);

        label_welcome_msg2 = new JLabel("Enter name");
        label_welcome_msg2.setBounds(130,212,200,30);
        label_welcome_msg2.setFont(new Font("Courier",1,13));
        label_welcome_msg2.setForeground(new Color(255,255,255));
        add(label_welcome_msg2);

        label_welcome_msg3 = new JLabel("Enter pass");
        label_welcome_msg3.setBounds(130,260,200,30);
        label_welcome_msg3.setFont(new Font("Courier",1,13));
        label_welcome_msg3.setForeground(new Color(255,255,255));
        add(label_welcome_msg3);

        label_welcome_msg4 = new JLabel("© 2002 - 2022 David Air LLC");
        label_welcome_msg4.setBounds(185,390,300,30);
        label_welcome_msg4.setFont(new Font("Courier",2,10));
        label_welcome_msg4.setForeground(new Color(255,255,255));
        add(label_welcome_msg4);

        textfield_name = new JTextField();
        textfield_name.setBounds(78,240,180,25);
        textfield_name.setBackground(new Color(250,250,250));
        textfield_name.setForeground(new Color(54,90,212));
        textfield_name.setFont(new Font("Courier",3,10));
        add(textfield_name);

        passfield = new JTextField();
        passfield.setBounds(78,288,180,25);
        passfield.setBackground(new Color(250,250,250));
        passfield.setForeground(new Color(54,90,212));
        passfield.setFont(new Font("Courier",3,10));
        add(passfield);

        button_login = new JButton("Login");
        button_login.setBounds(118,350,100,30);
        button_login.setBackground(new Color(250,250,250));
        button_login.setForeground(new Color(54,90,212));
        button_login.setFont(new Font("Courier",3,12));
        button_login.addActionListener(this);
        add(button_login);   
    }
    public void actionPerformed(ActionEvent a_e){
            String input_name;
            String input_pass;
            String login_name1 = "KingXRP";
            String login_pass1 = "admin";
            String login_name2 = "Nico1998";
            String login_pass2 = "admin";
			String login_name3 = "jose";
            String login_pass3 = "cangrejo";
            input_name = textfield_name.getText();
            input_pass = passfield.getText();
        if(a_e.getSource() == button_login){
            if(input_name.equals("") || input_pass.equals("")){
                    JOptionPane.showMessageDialog(null, "You must enter your name and pass");} 

            else if(!input_name.equals("") && !input_pass.equals("")){ 
                if(input_name.equals(login_name1) && input_pass.equals(login_pass1) || input_name.equals(login_name2) && input_pass.equals(login_pass2) || input_name.equals(login_name3) && input_pass.equals(login_pass3)){
                    this.setVisible(false);
                    T_C i_t_c = new T_C();
                    i_t_c.setBounds(0,0,800,500);
                    i_t_c.setVisible(true);
                    i_t_c.setLocationRelativeTo(null);
                    i_t_c.setResizable(false);
                }
                    else {
                        JOptionPane.showMessageDialog(null, "Wrong name/pass");
                    }
                }
        }        
    }
    public static void main(String args[]){
        Welcome i_welcome = new Welcome();
        i_welcome.setBounds(0,0,350,460);
        i_welcome.setLocationRelativeTo(null);
        i_welcome.setResizable(false);
        i_welcome.setVisible(true);
    }
}