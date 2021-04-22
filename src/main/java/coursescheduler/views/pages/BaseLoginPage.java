package coursescheduler.views.pages;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.event.KeyEvent;

import coursescheduler.User;
import coursescheduler.client.daos.UserDao;
import coursescheduler.managers.PanelController;
import coursescheduler.security.CredentialsVerifier;

/**
 * Presents to and allows the user to login provided with success email and password credentials.
 */
public final class BaseLoginPage extends javax.swing.JPanel implements Page {
  private final PanelController controller;
  private final CredentialsVerifier verifier;
  private final AbstractPageFactory pageFactory;
  private final UserDao userDao;

  public BaseLoginPage(
      PanelController controller,
      CredentialsVerifier verifier,
      AbstractPageFactory pageFactory,
      UserDao userDao) {
    this.controller = controller;
    this.verifier = verifier;
    this.pageFactory = pageFactory;
    this.userDao = userDao;
    initComponents();
  }

  @Override
  public JComponent init() {
    return this;
  }

  private void login(String email, char[] password) {
    if (!verifier.validUserCredentials(email, password)) {
      passwordLabel.setForeground(Color.RED);
      emailLabel.setForeground(Color.RED);
      return;
    }

    passwordLabel.setForeground(Color.BLACK);
    emailLabel.setForeground(Color.BLACK);

    User user = userDao.getUserByEmail(email);
    controller.updatePage(pageFactory.buildUserPage(user));
  }

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
    createAnAccountLabel = new javax.swing.JLabel();

    loginInnerPanel.setBorder(BorderFactory.createTitledBorder("Login"));

    emailLabel.setText("email");

    passwordLabel.setText("password");

    emailField.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mousePressed(java.awt.event.MouseEvent evt) {
            emailFieldMousePressed(evt);
          }
        });
    emailField.addKeyListener(
        new java.awt.event.KeyAdapter() {
          public void keyPressed(java.awt.event.KeyEvent evt) {
            emailFieldEnterKeyPressed(evt);
          }
        });

    passwordField.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mousePressed(java.awt.event.MouseEvent evt) {
            passwordFieldMousePressed(evt);
          }
        });
    passwordField.addKeyListener(
        new java.awt.event.KeyAdapter() {
          public void keyPressed(java.awt.event.KeyEvent evt) {
            passwordFieldEnterKeyPressed(evt);
          }
        });

    createAnAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    createAnAccountLabel.setText("Create an Account");
    createAnAccountLabel.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mousePressed(java.awt.event.MouseEvent evt) {
            createAnAccountLabelMousePressed(evt);
          }
        });

    javax.swing.GroupLayout loginInnerPanelLayout = new javax.swing.GroupLayout(loginInnerPanel);
    loginInnerPanel.setLayout(loginInnerPanelLayout);
    loginInnerPanelLayout.setHorizontalGroup(
        loginInnerPanelLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                loginInnerPanelLayout
                    .createSequentialGroup()
                    .addGroup(
                        loginInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                loginInnerPanelLayout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(
                                        createAnAccountLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        204,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                loginInnerPanelLayout
                                    .createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addGroup(
                                        loginInnerPanelLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(passwordLabel)
                                            .addComponent(emailLabel))
                                    .addGap(12, 12, 12)
                                    .addGroup(
                                        loginInnerPanelLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(
                                                passwordField,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                132,
                                                Short.MAX_VALUE)
                                            .addComponent(emailField))))
                    .addContainerGap(49, Short.MAX_VALUE)));
    loginInnerPanelLayout.setVerticalGroup(
        loginInnerPanelLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                loginInnerPanelLayout
                    .createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(
                        loginInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(
                                emailField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        loginInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(
                                passwordField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(createAnAccountLabel)
                    .addContainerGap(33, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap(184, Short.MAX_VALUE)
                    .addComponent(
                        loginInnerPanel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(173, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(
                        loginInnerPanel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE)));

    getAccessibleContext().setAccessibleName("");
  } // </editor-fold>//GEN-END:initComponents

  private void emailFieldMousePressed(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_emailFieldMousePressed
    emailField.setForeground(Color.BLACK);
  } // GEN-LAST:event_emailFieldMousePressed

  private void passwordFieldMousePressed(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_passwordFieldMousePressed
    passwordField.setForeground(Color.BLACK);
  } // GEN-LAST:event_passwordFieldMousePressed

  private void emailFieldEnterKeyPressed(
      java.awt.event.KeyEvent evt) { // GEN-FIRST:event_emailFieldKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      login(emailField.getText(), passwordField.getPassword());
    }
  } // GEN-LAST:event_emailFieldKeyPressed

  private void passwordFieldEnterKeyPressed(
      java.awt.event.KeyEvent evt) { // GEN-FIRST:event_passwordFieldEnterKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      login(emailField.getText(), passwordField.getPassword());
    }
  } // GEN-LAST:event_passwordFieldEnterKeyPressed

  private void createAnAccountLabelMousePressed(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_createAnAccountLabelMousePressed
    controller.updatePage(pageFactory.buildAccountCreationPage());
  } // GEN-LAST:event_createAnAccountLabelMousePressed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel createAnAccountLabel;
  private javax.swing.JTextField emailField;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JPanel loginInnerPanel;
  private javax.swing.JPasswordField passwordField;
  private javax.swing.JLabel passwordLabel;
  // End of variables declaration//GEN-END:variables
}
