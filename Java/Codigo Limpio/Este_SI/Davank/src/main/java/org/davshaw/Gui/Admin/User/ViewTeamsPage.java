package org.davshaw.Gui.Admin.User;



import org.davshaw.Service.Team.GetTeamReportAsText;


public class ViewTeamsPage extends javax.swing.JFrame {

  /**
   * Creates new form viewTeamsPage
   */
  public ViewTeamsPage() {
    initComponents();
  }

  public void executePostStart() {
    String msg = GetTeamReportAsText.getText(this.userDni);

    teamsTextArea.setText(msg);
    teamsTextArea.setEditable(false);
  }

  public void setUserDni(int userDni) {
    this.userDni = userDni;
  }

  
  private void initComponents() {
    jScrollPane1 = new javax.swing.JScrollPane();
    teamsTextArea = new javax.swing.JTextArea();
    backButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    teamsTextArea.setColumns(20);
    teamsTextArea.setRows(5);
    jScrollPane1.setViewportView(teamsTextArea);

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
                    .addGap(143, 143, 143)
                    .addComponent(
                      jScrollPane1,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      548,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addGap(392, 392, 392)
                    .addComponent(backButton)
                )
            )
            .addContainerGap(213, Short.MAX_VALUE)
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(68, 68, 68)
            .addComponent(
              jScrollPane1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              482,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              92,
              Short.MAX_VALUE
            )
            .addComponent(backButton)
            .addGap(53, 53, 53)
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
        .getLogger(ViewTeamsPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(ViewTeamsPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(ViewTeamsPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(ViewTeamsPage.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new ViewTeamsPage().setVisible(true);
        }
      }
    );
  }

  private int userDni;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton backButton;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea teamsTextArea;
  // End of variables declaration//GEN-END:variables
}
