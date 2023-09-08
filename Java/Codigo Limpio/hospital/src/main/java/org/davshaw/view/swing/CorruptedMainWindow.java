/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.davshaw.view.swing;

import org.davshaw.resources.TestCase;

public class CorruptedMainWindow extends javax.swing.JFrame
{

    public CorruptedMainWindow()
    {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        /*
        ? Inicio del código main de DAVID
        */
        this.tester = new TestCase();
        /*
        ? Fin del código main de DAVID
        */

    }

    //!initComponents
    private void initComponents()
    {

        mainContainer = new javax.swing.JPanel();
        enterNewRequest = new javax.swing.JButton();
        assistRequest = new javax.swing.JButton();
        viewRequest = new javax.swing.JButton();
        changeRequestPriority = new javax.swing.JButton();
        toExit = new javax.swing.JButton();
        labelTest = new javax.swing.JLabel();
        testNo1 = new javax.swing.JButton();
        testNo2 = new javax.swing.JButton();
        testNo3 = new javax.swing.JButton();
        deleteData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainContainer.setBackground(new java.awt.Color(102, 153, 255));

        enterNewRequest.setBackground(new java.awt.Color(153, 255, 102));
        enterNewRequest.setText("Agregar solicitud");
        enterNewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterNewRequestActionPerformed(evt);
            }
        });

        assistRequest.setBackground(new java.awt.Color(0, 204, 204));
        assistRequest.setText("Atender solicitud");
        assistRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assistRequestActionPerformed(evt);
            }
        });

        viewRequest.setBackground(new java.awt.Color(204, 204, 204));
        viewRequest.setText("Ver solicitudes");
        viewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestActionPerformed(evt);
            }
        });

        changeRequestPriority.setBackground(new java.awt.Color(255, 255, 51));
        changeRequestPriority.setText("Cambiar prioridad");
        changeRequestPriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeRequestPriorityActionPerformed(evt);
            }
        });

        toExit.setBackground(new java.awt.Color(255, 102, 102));
        toExit.setText("SALIR");
        toExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toExitActionPerformed(evt);
            }
        });

        labelTest.setText("   Ejecutar pruebas ➤");

        testNo1.setBackground(new java.awt.Color(204, 204, 255));
        testNo1.setText("Caso 1");
        testNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testNo1ActionPerformed(evt);
            }
        });

        testNo2.setBackground(new java.awt.Color(204, 204, 255));
        testNo2.setText("Caso 2");
        testNo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testNo2ActionPerformed(evt);
            }
        });

        testNo3.setBackground(new java.awt.Color(204, 204, 255));
        testNo3.setText("Caso 3");
        testNo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testNo3ActionPerformed(evt);
            }
        });

        deleteData.setBackground(new java.awt.Color(255, 204, 204));
        deleteData.setText("Borrar datos");
        deleteData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainContainerLayout = new javax.swing.GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assistRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enterNewRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeRequestPriority, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(testNo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(testNo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(testNo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        mainContainerLayout.setVerticalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(enterNewRequest)
                .addGap(32, 32, 32)
                .addComponent(assistRequest)
                .addGap(36, 36, 36)
                .addComponent(viewRequest)
                .addGap(36, 36, 36)
                .addComponent(changeRequestPriority)
                .addGap(30, 30, 30)
                .addComponent(deleteData)
                .addGap(43, 43, 43)
                .addComponent(toExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(labelTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(testNo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(testNo2)
                .addGap(14, 14, 14)
                .addComponent(testNo3)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE,
            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup
        (
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
            Short.MAX_VALUE)
        );

        pack();
    }//!initComponents

    private void enterNewRequestActionPerformed(java.awt.event.ActionEvent evt)
    {
        //!event_enterNewRequestActionPerformed
    }

    private void assistRequestActionPerformed(java.awt.event.ActionEvent evt)
    {
        //!event_assistRequestActionPerformed
    }

    private void viewRequestActionPerformed(java.awt.event.ActionEvent evt)
    {
        //!event_viewRequestActionPerformed
    }

    private void changeRequestPriorityActionPerformed(java.awt.event.ActionEvent evt)
    {
        //!event_changeRequestPriorityActionPerformed
    }

    private void toExitActionPerformed(java.awt.event.ActionEvent evt)
    {
        System.exit(0);
        //!event_toExitActionPerformed
    }

    private void testNo1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.tester.deleteData();
        this.tester.testCaseN1();
        //!event_testNo1ActionPerformed
    }

    private void testNo2ActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.tester.deleteData();
        this.tester.testCaseN2();
        //!event_testNo2ActionPerformed
    }

    private void deleteDataActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.tester.deleteData();
        //!event_deleteDataActionPerformed                                  
    }

    private void testNo3ActionPerformed(java.awt.event.ActionEvent evt)
    {                                        
        this.tester.deleteData();
        this.tester.testCaseN3();
        //!event_testNo3ActionPerformed
    }
    public static void main(String args[])
    {

        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(CorruptedMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CorruptedMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CorruptedMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CorruptedMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CorruptedMainWindow().setVisible(true);
            }
        });
    }

    
    // *INICIO* Declaración de variables
    private TestCase tester; 
    private javax.swing.JButton assistRequest;
    private javax.swing.JButton changeRequestPriority;
    private javax.swing.JButton deleteData;
    private javax.swing.JButton enterNewRequest;
    private javax.swing.JLabel labelTest;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JButton testNo1;
    private javax.swing.JButton testNo2;
    private javax.swing.JButton testNo3;
    private javax.swing.JButton toExit;
    private javax.swing.JButton viewRequest;
    // *FIN* Declaración de variables
}
