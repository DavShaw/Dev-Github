package org.davshaw.Gui.Admin.Admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import org.davshaw.Gui.Admin.Account.AccountPage;
import org.davshaw.Gui.Admin.User.UserPage;

/**
 *
 * @author Asus
 */
public class AdminPage extends javax.swing.JFrame {

  /**
   * Creates new form AdminPage
   */
  public AdminPage() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    userManagerButton = new javax.swing.JButton();
    accountManagerButton = new javax.swing.JButton();
    exitButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    userManagerButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    userManagerButton.setText("User Manager");
    userManagerButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          userManagerButtonActionPerformed(evt);
        }
      }
    );

    accountManagerButton.setFont(
      new java.awt.Font("Microsoft Yi Baiti", 1, 20)
    ); // NOI18N
    accountManagerButton.setText("Account Manager");
    accountManagerButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          accountManagerButtonActionPerformed(evt);
        }
      }
    );

    exitButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    exitButton.setText("Exit");
    exitButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          exitButtonActionPerformed(evt);
        }
      }
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(180, 180, 180)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(
                  accountManagerButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  180,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  userManagerButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  180,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.TRAILING,
                  layout
                    .createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(
                      exitButton,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      150,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(14, 14, 14)
                )
            )
            .addContainerGap(188, Short.MAX_VALUE)
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(100, 100, 100)
            .addComponent(
              userManagerButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(56, 56, 56)
            .addComponent(
              accountManagerButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              40,
              Short.MAX_VALUE
            )
            .addComponent(
              exitButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(100, 100, 100)
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_exitButtonActionPerformed
    System.exit(0);
  } //GEN-LAST:event_exitButtonActionPerformed

  private void userManagerButtonActionPerformed(
    java.awt.event.ActionEvent evt
  ) { //GEN-FIRST:event_userManagerButtonActionPerformed
    UserPage frame = new UserPage();
    frame.setVisible(true);
    this.dispose();
  } //GEN-LAST:event_userManagerButtonActionPerformed

  private void accountManagerButtonActionPerformed(
    java.awt.event.ActionEvent evt
  ) { //GEN-FIRST:event_accountManagerButtonActionPerformed
    AccountPage frame = new AccountPage();
    frame.setVisible(true);
    this.dispose();
  } //GEN-LAST:event_accountManagerButtonActionPerformed

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
      java.util.logging.Logger
        .getLogger(AdminPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(AdminPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(AdminPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(AdminPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new AdminPage().setVisible(true);
        }
      }
    );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton accountManagerButton;
  private javax.swing.JButton exitButton;
  private javax.swing.JButton userManagerButton;
  // End of variables declaration//GEN-END:variables
}
