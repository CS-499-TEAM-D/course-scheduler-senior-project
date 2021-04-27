package coursescheduler.views.pages;

import javax.swing.BorderFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

import coursescheduler.Role;
import coursescheduler.client.daos.BaseUserDao;
import coursescheduler.client.daos.UserDao;
import coursescheduler.managers.PanelController;
import coursescheduler.security.BaseCredentialsVerifier;
import coursescheduler.views.pages.containers.MasterSchedulerContainer;
import coursescheduler.views.pages.containers.StandardSchedulerContainer;


/**
 * Presents to and allows the user to login provided with success email and password credentials.
 */
public final class LoginPage extends javax.swing.JPanel {


  private PanelController controller;


  public LoginPage(PanelController controller) {
    this.controller = controller;
    initComponents();
  }

  String chosenType = "MASTER";

  

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginInnerPanel = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();

        loginInnerPanel.setBorder(BorderFactory.createTitledBorder("Login"));

        emailLabel.setText("email");

        passwordLabel.setText("password");

        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailFieldEnterKeyPressed(evt);
            }
        });

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldEnterPressed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginInnerPanelLayout = new javax.swing.GroupLayout(loginInnerPanel);
        loginInnerPanel.setLayout(loginInnerPanelLayout);
        loginInnerPanelLayout.setHorizontalGroup(
            loginInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginInnerPanelLayout.createSequentialGroup()
                .addGroup(loginInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitButton)
                    .addGroup(loginInnerPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(loginInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel)
                            .addComponent(emailLabel))
                        .addGap(12, 12, 12)
                        .addGroup(loginInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(emailField))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        loginInnerPanelLayout.setVerticalGroup(
            loginInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginInnerPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(loginInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(loginInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(loginInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        login(emailField.getText(), passwordField.getPassword());
    }//GEN-LAST:event_submitButtonActionPerformed

  private void emailFieldEnterKeyPressed(
      java.awt.event.KeyEvent evt) { // GEN-FIRST:event_emailFieldEnterKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // TODO: Use credentials service to retrieve user.
      // TODO: Use factory to generate user's page.
        login(emailField.getText(), passwordField.getPassword());
    }
  } // GEN-LAST:event_emailFieldEnterKeyPressed

  private void passwordFieldEnterPressed(
      java.awt.event.KeyEvent evt) { // GEN-FIRST:event_passwordFieldEnterPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // TODO: Use credentials service to retrieve user.
      // TODO: Use factory to generate user's role page.
      login(emailField.getText(), passwordField.getPassword());
    }
  } // GEN-LAST:event_passwordFieldEnterPressed

    private void login(String email, char[] password){
      BaseCredentialsVerifier verifier = new BaseCredentialsVerifier();
      UserDao userDao = new BaseUserDao();
      if(verifier.validUserCredentials(email, password)){
          if(userDao.getUserByEmail(email).getRole().equals(Role.MANAGER)){
              controller.updatePage(new MasterSchedulerContainer());
          }
          controller.updatePage(new StandardSchedulerContainer());
      }
      System.out.println("Wrong password");
      loginInnerPanel.setForeground(Color.RED);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel loginInnerPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

}
