package MAM;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
public class Login extends JFrame implements ActionListener{

    private JLabel label_logo, label_nombre, label_clave, label_derechos, label_fecha, label_hora;
    private JTextField tf_nombre;
	private JTextArea pf_clave_ver;
    private JPasswordField pf_clave;
    private JButton button_sesion, button_ver, button_no_ver;


    //Funcion en la que cree un bucle para refrescar el reloj
    public void refresh_time (){
        Thread refresh_time = new Thread(){
            public void run(){
                try{
                    for(;;)
                    {
                    Date DATE = new Date();
                    SimpleDateFormat fecha_formato = new SimpleDateFormat("dd/MM/yy");
                    String fecha = fecha_formato.format(DATE);
                    DateFormat hora_formato = new SimpleDateFormat("hh:mm:ss");
                    String hora = hora_formato.format(new Date());
                    label_fecha.setText("Fecha: " + fecha);
                    label_hora.setText("Hora: " + hora);
                    sleep(1000);
					}
                }
				catch(InterruptedException e){e.printStackTrace();}

            }
        };
        refresh_time.start();
    }

    public Login(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("David Project");

        //Icono del titulo
        ImageIcon img_icon_logo = new ImageIcon("img/terminal.png");
        setIconImage(img_icon_logo.getImage());
        //Fondo del frame
		ImageIcon fondo = new ImageIcon("img/icons/icon-fondo.jpg");
        try{setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img/icons/icon-fondo.jpg")))));}
		catch(IOException exception){exception.printStackTrace();}


        ImageIcon img_logo = new ImageIcon("img/icons/icon-logo.png");
        label_logo = new JLabel(img_logo);
        label_logo.setBounds(65,50,300,100);
        add(label_logo);

        label_nombre = new JLabel("Nombre:");
        label_nombre.setBounds(186,225,100,30);
        label_nombre.setFont(new Font("Times New Roman",1,18));
        add(label_nombre);

        tf_nombre = new JTextField("");
        tf_nombre.setBounds(145,260,150,25);
        tf_nombre.setFont(new Font("Times New Roman",0,12));
        add(tf_nombre);

        label_clave = new JLabel("Contraseña:");
        label_clave.setBounds(176,325,100,30);
        label_clave.setFont(new Font("Times New Roman",1,18));
        add(label_clave);

        pf_clave = new JPasswordField();
        pf_clave.setBounds(145,360,150,25);
        pf_clave.setFont(new Font("Times New Roman",1,15));
        add(pf_clave);

		pf_clave_ver = new JTextArea();
		pf_clave_ver.setBounds(146,390,148,20);
		pf_clave_ver.setFont(new Font("Times New Roman",1,15));
		pf_clave_ver.setEditable(false);
		add(pf_clave_ver);
		pf_clave_ver.setVisible(false);




		ImageIcon img_button_ver = new ImageIcon("img/ojos/si-ver.jpg");
		button_ver = new JButton(img_button_ver);
		button_ver.setBounds(300,361,23,23);
		button_ver.addActionListener(this);
		add(button_ver);

		ImageIcon img_button_no_ver = new ImageIcon("img/ojos/no-ver.jpg");
		button_no_ver = new JButton(img_button_no_ver);
		button_no_ver.setBounds(330,361,23,23);
		button_no_ver.addActionListener(this);
		add(button_no_ver);





        ImageIcon img_check = new ImageIcon("img/icons/icon-check.png");
        button_sesion = new JButton(img_check);
        button_sesion.setBounds(200,430,35,35);
		button_sesion.setBackground(new Color(255,255,255));
        button_sesion.setEnabled(true);
        button_sesion.addActionListener(this);
        add(button_sesion);

        label_derechos = new JLabel("Derechos reservados (2019-2022)");//("© Multiadornos Maicao (2019-2022)");
        label_derechos.setBounds(135,500,350,30);
        label_derechos.setFont(new Font("Times New Roman",1,12));
        label_derechos.setForeground(new Color(0,0,0));
        add(label_derechos);

        refresh_time();
        label_fecha = new JLabel();
        label_fecha.setBounds(5,5,150,30);
        label_fecha.setFont(new Font("Times New Roman",1,12));
        label_fecha.setForeground(new Color(0,0,0));
        add(label_fecha);

        label_hora = new JLabel();
        label_hora.setBounds(5,25,150,30);
        label_hora.setFont(new Font("Times New Roman",1,12));
        label_hora.setForeground(new Color(0,0,0));
        add(label_hora);

        Date DATE = new Date();
        SimpleDateFormat fecha_formato = new SimpleDateFormat("dd/MM/yy");
        String fecha_estatica = fecha_formato.format(DATE);
        DateFormat hora_formato = new SimpleDateFormat("hh:mm:ss");
        String hora_estatica = hora_formato.format(new Date());

        System.out.println("\n\n========================");
        System.out.println("Información del programa");
        System.out.println("========================\n");
        System.out.println("Creado por: David Torres");
        System.out.println("Diseñado para: Multiadornos Maicao");
        System.out.println("Protección: Copyright");
        System.out.println("El programa fue ejecutado: \n" + fecha_estatica + "    " + "Hora: " + hora_estatica);
    }
    //Base de datos (Nombres)

    String db_nombre01 = "Gloria Torres";
    String db_nombre02 = "David Torres";
    String db_nombre03 = "Admin Admin";

    //Base de datos (Claves)

    String db_clave01 = "01_gerente_gt_0511";
    String db_clave02 = "02_admin_dt_0246";
    String db_clave03 = "03_admin_admin_0000";



    public static void main(String args[]){
        Login i = new Login();
        i.setBounds(0,0,450,570);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
        i.setResizable(false);
		}



	public void actionPerformed(ActionEvent a_e){

        if(a_e.getSource() == button_sesion){
            //Pasando nombres y contraseñas ingresadas en la interfaz a string para ser procesado
            String get_nombre = tf_nombre.getText().trim();
            String get_clave = new String(pf_clave.getPassword());

            if(get_nombre.equals("") || get_clave.equals("")){JOptionPane.showMessageDialog(null, "Hace falta ingresar nombre y/o clave");}
            else if(get_nombre.equals(db_nombre01) && get_clave.equals(db_clave01)){JOptionPane.showMessageDialog(null, "Gerente Gloria, bienvenida");}
            else if(get_nombre.equals(db_nombre02) && get_clave.equals(db_clave02)){JOptionPane.showMessageDialog(null, "Administrador David, bienvenido");}
            else if(get_nombre.equals(db_nombre03) && get_clave.equals(db_clave03)){JOptionPane.showMessageDialog(null, "Administrador SISTEMA, bienvenido");}
            else{JOptionPane.showMessageDialog(null, "Nombre y/o contraseña incorrecto"); tf_nombre.setText(""); pf_clave.setText("");}
			}



		if(a_e.getSource() == button_ver){
			String get_clave = new String(pf_clave.getPassword());
			pf_clave_ver.setText(get_clave);

			add(pf_clave_ver);
			pf_clave_ver.setVisible(true);




		}

		if(a_e.getSource() == button_no_ver){
			remove(pf_clave_ver);
			pf_clave_ver.setVisible(false);

		}


    }






}
