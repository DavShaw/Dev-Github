package org.davshaw.Gui.Admin.User;



import java.util.List;
import org.davshaw.Controller.UserController;
import org.davshaw.Service.Debt.GetDebtReportAsText;


public class ViewDebtsPage extends javax.swing.JFrame {

  /**
   * Creates new form ViewDebtsPage
   */
  public ViewDebtsPage() {
    initComponents();
    this.executePostStart();
  }

  public void setUserDni(int userDni) {
    this.userDni = userDni;
  }

  public void executePostStart() {
    List<Integer> logIdList = UserController
      .getLogIdReport(this.userDni)
      .getResult();
    String m = GetDebtReportAsText.getText(logIdList);
    debtsTextArea.setText(m);
    debtsTextArea.setEditable(false);
  }

  
  private void initComponents() {
    jScrollPane1 = new javax.swing.JScrollPane();
    debtsTextArea = new javax.swing.JTextArea();
    backButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    debtsTextArea.setColumns(20);
    debtsTextArea.setRows(5);
    jScrollPane1.setViewportView(debtsTextArea);

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
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(
                      jScrollPane1,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      467,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addGap(283, 283, 283)
                    .addComponent(backButton)
                )
            )
            .addContainerGap(100, Short.MAX_VALUE)
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
              jScrollPane1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              448,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              70,
              Short.MAX_VALUE
            )
            .addComponent(backButton)
            .addGap(55, 55, 55)
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_backButtonActionPerformed
    UserPage frame = new UserPage();
    frame.setVisible(true);
    this.dispose();
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
        .getLogger(ViewDebtsPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(ViewDebtsPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(ViewDebtsPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(ViewDebtsPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new ViewDebtsPage().setVisible(true);
        }
      }
    );
  }

  private int userDni;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton backButton;
  private javax.swing.JTextArea debtsTextArea;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables
}
