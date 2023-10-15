package org.davshaw.Gui.Admin.User;

import javax.swing.JOptionPane;
import org.davshaw.Controller.UserController;
import org.davshaw.External.ResultPack;
import org.davshaw.Model.pureentities.User;


public class EditUserPage extends javax.swing.JFrame {

  /**
   * Creates new form EditUser
   */
  public EditUserPage() {
    initComponents();
  }

  public void setUserDni(int dni) {
    this.userDni = dni;
  }

  public void setUser(User user) {
    this.user = user;
    firstNameField.setText(this.user.getFirstName());
    middleNameField.setText(this.user.getMiddleName());
    firstLastnameField.setText(this.user.getFirstLastName());
    middleLastnameField.setText(this.user.getMiddleLastName());
  }

  
  private void initComponents() {
    firstNameField = new javax.swing.JTextField();
    firstLastnameField = new javax.swing.JTextField();
    middleNameField = new javax.swing.JTextField();
    middleLastnameField = new javax.swing.JTextField();
    updateButton = new javax.swing.JButton();
    backButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    firstNameField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    firstNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    firstNameField.setText("First Name");
    firstNameField.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          firstNameFieldActionPerformed(evt);
        }
      }
    );

    firstLastnameField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    firstLastnameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    firstLastnameField.setText("First Lastname");

    middleNameField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    middleNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    middleNameField.setText("Middle Name");

    middleLastnameField.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    middleLastnameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    middleLastnameField.setText("Middle Lastname");

    updateButton.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 20)); // NOI18N
    updateButton.setText("Update");
    updateButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          updateButtonActionPerformed(evt);
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
            .addGap(119, 119, 119)
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
                  middleLastnameField,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addGroup(
                  layout
                    .createParallelGroup(
                      javax.swing.GroupLayout.Alignment.LEADING
                    )
                    .addComponent(
                      middleNameField,
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
                      firstNameField,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      150,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
                .addComponent(
                  updateButton,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  150,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addContainerGap(110, Short.MAX_VALUE)
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
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(50, 50, 50)
            .addComponent(
              middleNameField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(50, 50, 50)
            .addComponent(
              firstLastnameField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(50, 50, 50)
            .addComponent(
              middleLastnameField,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              100,
              Short.MAX_VALUE
            )
            .addComponent(
              updateButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(28, 28, 28)
            .addComponent(
              backButton,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(50, 50, 50)
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_firstNameFieldActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_firstNameFieldActionPerformed

  private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_updateButtonActionPerformed
    String name1, name2, lastname1, lastname2;
    name1 = firstNameField.getText();
    name2 = middleNameField.getText();
    lastname1 = firstLastnameField.getText();
    lastname2 = middleLastnameField.getText();

    UserController.changeFirstName(userDni, name1);
    UserController.changeMiddleName(userDni, name2);
    UserController.changeFirstLastName(userDni, lastname1);
    ResultPack<Boolean> result = UserController.changeMiddleLastName(
      userDni,
      lastname2
    );

    String message = String.format(
      "User updated successfully: %s\nServer return: %s\nMessage: %s",
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
  } //GEN-LAST:event_updateButtonActionPerformed

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_backButtonActionPerformed
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
        .getLogger(EditUserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(EditUserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(EditUserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(EditUserPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new EditUserPage().setVisible(true);
        }
      }
    );
  }

  private int userDni;
  private User user;

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton backButton;
  private javax.swing.JTextField firstLastnameField;
  private javax.swing.JTextField firstNameField;
  private javax.swing.JTextField middleLastnameField;
  private javax.swing.JTextField middleNameField;
  private javax.swing.JButton updateButton;
  // End of variables declaration//GEN-END:variables
}
