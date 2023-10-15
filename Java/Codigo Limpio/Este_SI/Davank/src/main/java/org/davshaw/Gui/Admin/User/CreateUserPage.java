package org.davshaw.Gui.Admin.User;

import javax.swing.JOptionPane;
import org.davshaw.Controller.UserController;
import org.davshaw.External.ResultPack;


public class CreateUserPage extends javax.swing.JFrame {

  /**
   * Creates new form CreateUser
   */
  public CreateUserPage() {
    initComponents();
  }

  
  private void initComponents() {
    firstNameField = new javax.swing.JTextField();
    middleNameField = new javax.swing.JTextField();
    firstLastnameField = new javax.swing.JTextField();
    middleLastnameField = new javax.swing.JTextField();
    dniField = new javax.swing.JTextField();
    passwordField = new javax.swing.JTextField();
    createUserButton = new javax.swing.JButton();
    backButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    firstNameField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    firstNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    firstNameField.setText("First Name");

    middleNameField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    middleNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    middleNameField.setText("Middle Name");

    firstLastnameField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    firstLastnameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    firstLastnameField.setText("First Lastname");

    middleLastnameField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    middleLastnameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    middleLastnameField.setText("Middle Lastname");

    dniField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    dniField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    dniField.setText("DNI");

    passwordField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    passwordField.setText("Password");

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
            .addGap(124, 124, 124)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(
                  backButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  middleNameField,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  firstNameField,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  firstLastnameField,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  middleLastnameField,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  dniField,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  passwordField,
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
            )
            .addContainerGap(124, Short.MAX_VALUE)
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(50, 50, 50)
            .addComponent(
              firstNameField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              35,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(40, 40, 40)
            .addComponent(
              middleNameField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              35,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              39,
              Short.MAX_VALUE
            )
            .addComponent(
              firstLastnameField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              35,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(36, 36, 36)
            .addComponent(
              middleLastnameField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              35,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(38, 38, 38)
            .addComponent(
              dniField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              35,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(29, 29, 29)
            .addComponent(
              passwordField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              35,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(81, 81, 81)
            .addComponent(
              createUserButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              45,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(18, 18, 18)
            .addComponent(
              backButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              45,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(46, 46, 46)
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void createUserButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_createUserButtonActionPerformed
    // Getting values from variables
    String name1 = firstNameField.getText();
    String name2 = middleNameField.getText();
    String lastname1 = firstLastnameField.getText();
    String lastname2 = middleLastnameField.getText();
    int dni = Integer.valueOf(dniField.getText());
    String password = passwordField.getText();

    //Creating user
    ResultPack<Boolean> result = UserController.createUser(
      dni,
      name1,
      name2,
      lastname1,
      lastname2,
      password
    );

    String message = String.format(
      "User created successfully: %s\nServer return: %s\nMessage: %s",
      result.getOkay(),
      result.getResult(),
      result.getMessage()
    );
    if (result.getOkay() == true) {
      JOptionPane.showMessageDialog(
        this,
        message,
        "Create User",
        JOptionPane.INFORMATION_MESSAGE
      );
    } else {
      JOptionPane.showMessageDialog(
        this,
        message,
        "Create User",
        JOptionPane.WARNING_MESSAGE
      );
    }
  } //GEN-LAST:event_createUserButtonActionPerformed

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_backButtonActionPerformed
    //Open previous frame (UserPage)
    UserPage frame = new UserPage();
    frame.setVisible(true);
    dispose();
  } //GEN-LAST:event_backButtonActionPerformed

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
        .getLogger(CreateUserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(CreateUserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(CreateUserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(CreateUserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new CreateUserPage().setVisible(true);
        }
      }
    );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton backButton;
  private javax.swing.JButton createUserButton;
  private javax.swing.JTextField dniField;
  private javax.swing.JTextField firstLastnameField;
  private javax.swing.JTextField firstNameField;
  private javax.swing.JTextField middleLastnameField;
  private javax.swing.JTextField middleNameField;
  private javax.swing.JTextField passwordField;
  // End of variables declaration//GEN-END:variables
}
