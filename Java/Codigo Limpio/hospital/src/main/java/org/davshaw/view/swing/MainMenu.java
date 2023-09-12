package org.davshaw.view.swing;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.davshaw.classes.Hospital;
import org.davshaw.external.TestCase;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class MainMenu extends javax.swing.JFrame
{

    /**
     * Creates new form MainMenu
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public MainMenu() throws IOException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        /*
         !Obligado a poner throws IOException, ClassNotFoundException... Puede corromper el NetBeans
         */
        
        this.hospital = new Hospital(10000);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        newRequest = new javax.swing.JButton();
        assistNextRequest = new javax.swing.JButton();
        viewRequests = new javax.swing.JButton();
        changePriority = new javax.swing.JButton();
        testCaseNo2 = new javax.swing.JButton();
        toExit = new javax.swing.JButton();
        deleteData = new javax.swing.JButton();
        testCaseNo1 = new javax.swing.JButton();
        testCaseNo3 = new javax.swing.JButton();
        madeBy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        

        logoLabel.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/davshaw/resources/DavNet Logo.png"))); // NOI18N

        newRequest.setBackground(new java.awt.Color(204, 255, 204));
        newRequest.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        newRequest.setText("Nueva solicitud");
        newRequest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                try {
                    newRequestAction(evt);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        
        assistNextRequest.setBackground(new java.awt.Color(204, 255, 255));
        assistNextRequest.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        assistNextRequest.setText("Atender solicitud");
        assistNextRequest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                assistNextRequestAction(evt);
            }
        });

        viewRequests.setBackground(new java.awt.Color(255, 255, 153));
        viewRequests.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        viewRequests.setText("Ver solicitudes");
        viewRequests.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                viewRequestsAction(evt);
            }
        });

        changePriority.setBackground(new java.awt.Color(102, 204, 255));
        changePriority.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        changePriority.setText("Cambiar prioridad");
        changePriority.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                changePriorityAction(evt);
            }
        });


        deleteData.setBackground(new java.awt.Color(255, 204, 204));
        deleteData.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        deleteData.setText("Borrar datos");
        deleteData.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteDataAction(evt);
            }
        });

        testCaseNo1.setBackground(new java.awt.Color(0, 204, 204));
        testCaseNo1.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        testCaseNo1.setText("No. 1");
        testCaseNo1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                testCaseNo1Action(evt);
            }
        });

        testCaseNo2.setBackground(new java.awt.Color(0, 204, 204));
        testCaseNo2.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        testCaseNo2.setText("No. 2");
        testCaseNo2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                testCaseNo2Action(evt);
            }
        });
        
        testCaseNo3.setBackground(new java.awt.Color(0, 204, 204));
        testCaseNo3.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        testCaseNo3.setText("No. 3");
        testCaseNo3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                testCaseNo3Action(evt);
            }
        });

        toExit.setBackground(new java.awt.Color(255, 51, 51));
        toExit.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        toExit.setText("SALIR");
        toExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                toExistAction(evt);
            }
        });


        madeBy.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        madeBy.setText("By: DavShaw");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(logoLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(madeBy))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changePriority, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewRequests, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(assistNextRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(testCaseNo3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(testCaseNo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(testCaseNo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(assistNextRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewRequests)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changePriority)
                .addGap(18, 18, 18)
                .addComponent(deleteData)
                .addGap(37, 37, 37)
                .addComponent(toExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(testCaseNo1)
                .addGap(18, 18, 18)
                .addComponent(testCaseNo2)
                .addGap(18, 18, 18)
                .addComponent(testCaseNo3)
                .addGap(22, 22, 22)
                .addComponent(madeBy)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainMenu().setVisible(true);
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    /*
    ? Acciones de botones 
    */

    private void newRequestAction(java.awt.event.ActionEvent evt) throws IOException
    {
        String nombre = JOptionPane.showInputDialog(this, "Nombre:", "Nueva solicitud", JOptionPane.INFORMATION_MESSAGE);
        String descripcion = JOptionPane.showInputDialog(this, "Descripción:", "Nueva solicitud", JOptionPane.INFORMATION_MESSAGE);
        String edadStr = JOptionPane.showInputDialog(this, "Edad:", "Nueva solicitud", JOptionPane.INFORMATION_MESSAGE);
                
                // Manejo de la entrada para la edad (conversión a int)
                int edad = 0;
                try
                {
                    edad = Integer.parseInt(edadStr);
                    this.hospital.agregarSolicitudes(nombre, descripcion, edad);
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(this, "Edad no válida. Intenta nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                }
    }

    private void assistNextRequestAction(java.awt.event.ActionEvent evt)
    {


        String detalleSolicitud = "";
        //Obtener detalles de la solicitud atendida
        try
        {
            //El this.hospital.atenderSolicitud PUEDE generar una excepción
            detalleSolicitud = this.hospital.atenderSolicitud();
            // Crear Frame emergente
            JFrame ventanaEmergente = new JFrame("Atender siguiente solicitud");
            ventanaEmergente.setSize(300, 200);
            // Crear un TextArea
            JTextArea textArea = new JTextArea(detalleSolicitud);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEnabled(false);
            // Agregar el TextArea a un ScrollPane
            JScrollPane scrollPane = new JScrollPane(textArea);
            // Agregar el ScrollPane a la ventana emergente
            ventanaEmergente.getContentPane().add(scrollPane);
            ventanaEmergente.setLocationRelativeTo(null);
            ventanaEmergente.setVisible(true);
        }

        catch(Exception error)
        {
            JOptionPane.showMessageDialog(this, "No hay solicitudes que atender", "Sin solicitudes", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewRequestsAction(java.awt.event.ActionEvent evt)
    {
        // Crear Frame emergente
        JFrame ventanaEmergente = new JFrame("Solicitudes");
        ventanaEmergente.setSize(300, 200);
        // Crear un TextArea
        JTextArea textArea = new JTextArea(this.hospital.visualizarSolicitudes());
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEnabled(false);
        // Agregar el TextArea a un ScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        // Agregar el ScrollPane a la ventana emergente
        ventanaEmergente.getContentPane().add(scrollPane);
        ventanaEmergente.setLocationRelativeTo(null);
        ventanaEmergente.setVisible(true);  
    }

    private void changePriorityAction(java.awt.event.ActionEvent evt)
    {
        String idStr = JOptionPane.showInputDialog(this, "ID:", "Cambiar prioridad", JOptionPane.INFORMATION_MESSAGE);
        String newPriorityStr = JOptionPane.showInputDialog(this, "Nueva prioridad:", "Cambiar prioridad", JOptionPane.INFORMATION_MESSAGE);
                
        // Manejo de la entrada para el ID 
        int id = 0;
        int newPriority = 0;
        try
        {
            id = Integer.parseInt(idStr);
            newPriority = Integer.parseInt(newPriorityStr);
            //verificar que exista el ID
            try
            {
                this.hospital.cambiarPrioridad(id, newPriority);
            }

            catch(Exception error)
            {
                JOptionPane.showMessageDialog(this, "El ID no se ha encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Ingresa un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteDataAction(java.awt.event.ActionEvent evt)
    {
        this.hospital.deleteData();
        JOptionPane.showMessageDialog(this, "¡Todas las solicitudes han sido borradas!", "Datos", JOptionPane.WARNING_MESSAGE);
    }

    private void toExistAction(java.awt.event.ActionEvent evt)
    {
        System.exit(0);
    }

    private void testCaseNo1Action(java.awt.event.ActionEvent evt)
    {
        TestCase.testData(this.hospital, 10);
    }

    private void testCaseNo2Action(java.awt.event.ActionEvent evt)
    {
        TestCase.testData(this.hospital, 100);
    }

    private void testCaseNo3Action(java.awt.event.ActionEvent evt)
    {
        TestCase.testData(this.hospital, 10000);
    }

    private Hospital hospital;
    // Variables declaration - do not modify                     
    private javax.swing.JButton assistNextRequest;
    private javax.swing.JButton changePriority;
    private javax.swing.JButton deleteData;
    private javax.swing.JLabel madeBy;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton newRequest;
    private javax.swing.JButton testCaseNo1;
    private javax.swing.JButton testCaseNo2;
    private javax.swing.JButton testCaseNo3;
    private javax.swing.JButton toExit;
    private javax.swing.JButton viewRequests;
    // End of variables declaration                   
}
