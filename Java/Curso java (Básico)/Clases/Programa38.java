import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Programa38 extends JFrame implements ChangeListener, ActionListener{

    private JCheckBox checkbox_usdt, checkbox_btc, checkbox_eth, checkbox_xrp;
    private JLabel label_crypto_question, label_crypto_used;
    
    private JMenuBar menubar;
    private JMenu menu_screen;
    private JMenuItem menu_screen_size1, menu_screen_size2, menu_screen_size3;

    public Programa38(){
        setLayout(null);
        setTitle("Cyptocurrencies forum");

        //JCheckBox
        checkbox_usdt = new JCheckBox("US Tether - (USDT)");
        checkbox_usdt.setBounds(10,50,200,30);
        checkbox_usdt.addChangeListener(this);
        add(checkbox_usdt);

        checkbox_btc = new JCheckBox("Bitcoin - (BTC)");
        checkbox_btc.setBounds(10,90,200,30);
        checkbox_btc.addChangeListener(this);
        add(checkbox_btc);

        checkbox_eth = new JCheckBox("Ethereum - (ETH)");
        checkbox_eth.setBounds(10,130,200,30);
        checkbox_eth.addChangeListener(this);
        add(checkbox_eth);

        checkbox_xrp = new JCheckBox("Ripple - (XRP)");
        checkbox_xrp.setBounds(10,170,200,30);
        checkbox_xrp.addChangeListener(this);
        add(checkbox_xrp);
        //JLabel
        label_crypto_question = new JLabel("Which cyptocurrencies do you use (can choose more that one)");
        label_crypto_question.setBounds(10,20,500,30);
        add(label_crypto_question);

        label_crypto_used = new JLabel("");
        label_crypto_used.setBounds(10,250,500,30);
        add(label_crypto_used);

        //JMenuBar
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        //JMenu
        menu_screen = new JMenu("Screen size");
        menu_screen.addActionListener(this);
        menubar.add(menu_screen);
        //JMenuItems (Items into menu_screen)
        menu_screen_size1 = new JMenuItem("380x280");
        menu_screen_size1.addActionListener(this);
        menu_screen.add(menu_screen_size1);

        menu_screen_size2 = new JMenuItem("600x400");
        menu_screen_size2.addActionListener(this);
        menu_screen.add(menu_screen_size2);

        menu_screen_size3 = new JMenuItem("800x600");
        menu_screen_size3.addActionListener(this);
        menu_screen.add(menu_screen_size3);

    }

    public void stateChanged(ChangeEvent event){
        String crypto = "";
        if(checkbox_usdt.isSelected() == true){crypto = crypto + "  USDT   ";}
        if(checkbox_btc.isSelected() == true){crypto = crypto + "   BTC   ";}
        if(checkbox_eth.isSelected() == true){crypto = crypto + "   ETH   ";}
        if(checkbox_xrp.isSelected() == true){crypto = crypto + "   XRP   ";}
        label_crypto_used.setText("You use: " + crypto);
    }

    public void actionPerformed (ActionEvent event){
        if(event.getSource() == menu_screen_size1){setSize(380,280);}
        if(event.getSource() == menu_screen_size2){setSize(600,400);}
        if(event.getSource() == menu_screen_size3){setSize(800,600);}
    }
    
    public static void main(String args[]){
        Programa38 i = new Programa38();
        
        i.setBounds(0,0,600,400);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
        i.setResizable(false);
    }
    
}
