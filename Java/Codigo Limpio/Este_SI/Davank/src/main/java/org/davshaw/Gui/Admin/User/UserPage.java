package org.davshaw.Gui.Admin.User;

import javax.swing.JOptionPane;
import org.davshaw.Controller.UserController;
import org.davshaw.External.Checker;
import org.davshaw.External.ResultPack;
import org.davshaw.Gui.Admin.Admin.AdminPage;
import org.davshaw.Model.pureentities.User;



public class UserPage extends javax.swing.JFrame {

  /**
   * Creates new form UserPage
   */
  public UserPage() {
    initComponents();
  }

  
  private void initComponents() {
    jButton1 = new javax.swing.JButton();
    createUserButton = new javax.swing.JButton();
    backButton = new javax.swing.JButton();
    deleteUserButton = new javax.swing.JButton();
    editUserButton = new javax.swing.JButton();
    viewLoansButton = new javax.swing.JButton();
    viewTeamsButton = new javax.swing.JButton();
    viewDebtsButton = new javax.swing.JButton();

    jButton1.setText("jButton1");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    createUserButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    createUserButton.setText("Create User");
    createUserButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          createUserButtonActionPerformed(evt);
        }
      }
    );

    backButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    backButton.setText("Back");
    backButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          backButtonActionPerformed(evt);
        }
      }
    );

    deleteUserButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    deleteUserButton.setText("Delete User");
    deleteUserButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          deleteUserButtonActionPerformed(evt);
        }
      }
    );

    editUserButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    editUserButton.setText("Edit User");
    editUserButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          editUserButtonActionPerformed(evt);
        }
      }
    );

    viewLoansButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    viewLoansButton.setText("View Loans");
    viewLoansButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          viewLoansButtonActionPerformed(evt);
        }
      }
    );

    viewTeamsButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    viewTeamsButton.setText("View Teams");
    viewTeamsButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          viewTeamsButtonActionPerformed(evt);
        }
      }
    );

    viewDebtsButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    viewDebtsButton.setText("View Debts");
    viewDebtsButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          viewDebtsButtonActionPerformed(evt);
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
            .addGap(100, 100, 100)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(
                  deleteUserButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  createUserButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  editUserButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(
                  viewLoansButton,
                  javax.swing.GroupLayout.Alignment.TRAILING,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  viewTeamsButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  viewDebtsButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(100, 100, 100)
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(285, 285, 285)
            .addComponent(
              backButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              150,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(285, Short.MAX_VALUE)
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(60, 60, 60)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  createUserButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  60,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  viewLoansButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  60,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(60, 60, 60)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  deleteUserButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  60,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  viewTeamsButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  60,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(60, 60, 60)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  editUserButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  60,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  viewDebtsButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  60,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              101,
              Short.MAX_VALUE
            )
            .addComponent(
              backButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(62, 62, 62)
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void createUserButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_createUserButtonActionPerformed
    CreateUserPage newFrame = new CreateUserPage();
    newFrame.setVisible(true);
    dispose();
  } //GEN-LAST:event_createUserButtonActionPerformed

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_backButtonActionPerformed
    AdminPage frame = new AdminPage();
    frame.setVisible(true);

    this.dispose();
  } //GEN-LAST:event_backButtonActionPerformed

  private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_deleteUserButtonActionPerformed
    //Enter dni
    String dniString = JOptionPane.showInputDialog(
      this,
      "User DNI:",
      "Delete User",
      JOptionPane.INFORMATION_MESSAGE
    );

    if (dniString != null) {
      if (Checker.isDigit(dniString)) {
        int dni = Integer.parseInt(dniString);
        ResultPack<Boolean> result2 = UserController.userExist(dni);
        if (result2.getResult()) {
          ResultPack<Boolean> result = UserController.deleteUser(dni);
          String message = String.format(
            "User deleted successfully: %s\nServer return: %s\nMessage: %s",
            result.getOkay(),
            result.getResult(),
            result.getMessage()
          );
          JOptionPane.showMessageDialog(
            this,
            message,
            "Delete User",
            JOptionPane.INFORMATION_MESSAGE
          );
        } else {
          JOptionPane.showMessageDialog(
            this,
            result2.getMessage(),
            "Delete User",
            JOptionPane.ERROR_MESSAGE
          );
        }
      } else {
        JOptionPane.showMessageDialog(
          this,
          "Invalid Dni",
          "Delete User",
          JOptionPane.INFORMATION_MESSAGE
        );
      }
    }
  } //GEN-LAST:event_deleteUserButtonActionPerformed

  private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_editUserButtonActionPerformed
    String dniString = JOptionPane.showInputDialog(
      this,
      "User DNI:",
      "Delete User",
      JOptionPane.INFORMATION_MESSAGE
    );
    if (dniString != null) {
      if (Checker.isDigit(dniString)) {
        int dni = Integer.parseInt(dniString);
        //Check if exists
        ResultPack<Boolean> result = UserController.userExist(dni);
        if (result.getResult()) {
          ResultPack<User> getUserResult = UserController.getUser(dni);

          EditUserPage frame = new EditUserPage();
          frame.setUserDni(dni);
          frame.setUser(getUserResult.getResult());
          frame.setVisible(true);
          dispose();
        } else {
          JOptionPane.showMessageDialog(
            this,
            result.getMessage(),
            "Edit User",
            JOptionPane.ERROR_MESSAGE
          );
        }
      } else {
        JOptionPane.showMessageDialog(
          this,
          "Invalid Dni",
          "Delete User",
          JOptionPane.INFORMATION_MESSAGE
        );
      }
    }
  } //GEN-LAST:event_editUserButtonActionPerformed

  private void viewLoansButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_viewLoansButtonActionPerformed
    String dniStr = JOptionPane.showInputDialog(
      this,
      "Enter user Dni: ",
      "View Loans",
      JOptionPane.PLAIN_MESSAGE
    );
    if (dniStr != null) {
      if (Checker.isDigit(dniStr)) {
        int dni = Integer.parseInt(dniStr);
        ResultPack<Boolean> r1 = UserController.userExist(dni);
        if (r1.getResult()) {
          SeeLoansPage frame = new SeeLoansPage();

          frame.setUserDni(dni);
          frame.executePostStart();
          frame.setVisible(true);

          this.dispose();
        } else {
          JOptionPane.showMessageDialog(
            this,
            r1.getMessage(),
            "View Loans",
            JOptionPane.ERROR_MESSAGE
          );
        }
      } else {
        JOptionPane.showMessageDialog(
          this,
          "Invalid Dni.",
          "View Loans",
          JOptionPane.ERROR_MESSAGE
        );
      }
    }
  } //GEN-LAST:event_viewLoansButtonActionPerformed

  private void viewTeamsButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_viewTeamsButtonActionPerformed
    String dniStr = JOptionPane.showInputDialog(
      this,
      "Enter user Dni: ",
      "View Teams",
      JOptionPane.PLAIN_MESSAGE
    );
    if (dniStr != null) {
      if (Checker.isDigit(dniStr)) {
        int dni = Integer.parseInt(dniStr);
        ResultPack<Boolean> r1 = UserController.userExist(dni);
        if (r1.getResult()) {
          ViewTeamsPage frame = new ViewTeamsPage();
          frame.setUserDni(dni);
          frame.executePostStart();
          frame.setVisible(true);

          this.dispose();
        } else {
          JOptionPane.showMessageDialog(
            this,
            r1.getMessage(),
            "View Teams",
            JOptionPane.ERROR_MESSAGE
          );
        }
      } else {
        JOptionPane.showMessageDialog(
          this,
          "Invalid Dni.",
          "View Teams",
          JOptionPane.ERROR_MESSAGE
        );
      }
    } else {}
  } //GEN-LAST:event_viewTeamsButtonActionPerformed

  private void viewDebtsButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_viewDebtsButtonActionPerformed
    String dniStr = JOptionPane.showInputDialog(
      this,
      "Enter user Dni: ",
      "View Debts",
      JOptionPane.PLAIN_MESSAGE
    );
    if (dniStr != null) {
      if (Checker.isDigit(dniStr)) {
        int dni = Integer.parseInt(dniStr);
        ResultPack<Boolean> r1 = UserController.userExist(dni);
        if (r1.getResult()) {
          ViewDebtsPage frame = new ViewDebtsPage();
          frame.setUserDni(dni);
          frame.executePostStart();
          frame.setVisible(true);

          this.dispose();
        } else {
          JOptionPane.showMessageDialog(
            this,
            r1.getMessage(),
            "View Debts",
            JOptionPane.ERROR_MESSAGE
          );
        }
      } else {
        JOptionPane.showMessageDialog(
          this,
          "Invalid Dni.",
          "View Debts",
          JOptionPane.ERROR_MESSAGE
        );
      }
    } else {}
  } //GEN-LAST:event_viewDebtsButtonActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger
        .getLogger(UserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(UserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(UserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(UserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new UserPage().setVisible(true);
        }
      }
    );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton backButton;
  private javax.swing.JButton createUserButton;
  private javax.swing.JButton deleteUserButton;
  private javax.swing.JButton editUserButton;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton viewDebtsButton;
  private javax.swing.JButton viewLoansButton;
  private javax.swing.JButton viewTeamsButton;
  // End of variables declaration//GEN-END:variables
}
