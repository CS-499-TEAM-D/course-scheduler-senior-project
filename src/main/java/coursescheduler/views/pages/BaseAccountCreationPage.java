package coursescheduler.views.pages;

import coursescheduler.client.daos.UserDao;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import java.awt.Color;
import java.util.Arrays;

import coursescheduler.Role;
import coursescheduler.User;
import coursescheduler.managers.PanelController;

/** TODO: Fill JavaDoc. */
public class BaseAccountCreationPage extends javax.swing.JPanel implements Page {
  private final PanelController controller;
  private final AbstractPageFactory pageFactory;
  private final UserDao userDao;

  private static final String[] DEPARTMENTS = {
    "Accounting",
    "Ancient and Medieval Studies",
    "Art, Art History, and Design",
    "Atmospheric Science",
    "Biological Sciences",
    "Chemical and Environmental Engineering",
    "Chemical and Materials Engineering",
    "Chemistry",
    "Communication Arts",
    "Computer Science",
    "Curriculum and Instruction",
    "Earth System Science",
    "Economics",
    "Electrical and Computer Engineering",
    "Engineering Clusters",
    "English",
    "Finance",
    "Global Studies",
    "Health and Physical Education",
    "History",
    "Industrial and Systems Engineering and Engineering Management",
    "Information Systems",
    "Kinesiology",
    "Management",
    "Marketing",
    "Mathematical Sciences",
    "Mechanical and Aerospace Engineering",
    "Music",
    "Nursing",
    "Philosophy",
    "Physics and Astronomy",
    "Political Science",
    "Professional Studies",
    "Psychology",
    "Sociology",
    "Theatre",
    "World Languages and Cultures"
  };

  private static final String[] ROLES = {Role.MANAGER, Role.COORDINATOR};

  /** Creates new form AccountCreationPage */
  public BaseAccountCreationPage(
      PanelController controller, AbstractPageFactory pageFactory, UserDao userDao) {
    this.controller = controller;
    this.pageFactory = pageFactory;
    this.userDao = userDao;
    initComponents();
  }

  @Override
  public JComponent init() {
    return this;
  }

  /** @return */
  private boolean validateInput() {
    boolean emailValid = !emailTextField.getText().isBlank(); // TODO: Validate email format.
    boolean passwordValid = passwordField.getPassword().length != 0;
    boolean passwordsMatch =
        Arrays.equals(passwordField.getPassword(), passwordConfirmationPasswordField.getPassword());

    emailLabel.setForeground(emailValid ? Color.BLACK : Color.RED);
    passwordLabel.setForeground(passwordValid ? Color.BLACK : Color.RED);
    passwordConfirmationPasswordFieldLabel.setForeground(passwordsMatch ? Color.BLACK : Color.RED);

    return emailValid && passwordValid && passwordsMatch;
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    accountCreationInnerPanel = new javax.swing.JPanel();
    departmentLabel = new javax.swing.JLabel();
    departmentComboBox = new javax.swing.JComboBox<>();
    emailLabel = new javax.swing.JLabel();
    passwordLabel = new javax.swing.JLabel();
    passwordConfirmationPasswordFieldLabel = new javax.swing.JLabel();
    emailTextField = new javax.swing.JTextField();
    passwordField = new javax.swing.JPasswordField();
    passwordConfirmationPasswordField = new javax.swing.JPasswordField();
    cancelButton = new javax.swing.JButton();
    submitButton = new javax.swing.JButton();
    roleLabel = new javax.swing.JLabel();
    roleComboBox = new javax.swing.JComboBox<>();

    accountCreationInnerPanel.setBorder(BorderFactory.createTitledBorder("Create an Account"));

    departmentLabel.setText("department:");

    departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(DEPARTMENTS));
    departmentComboBox.setSelectedItem(DEPARTMENTS[0]);

    emailLabel.setText("email:");

    passwordLabel.setText("password:");

    passwordConfirmationPasswordFieldLabel.setText("re-type password:");

    emailTextField.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            emailTextFieldMouseClicked(evt);
          }

          public void mousePressed(java.awt.event.MouseEvent evt) {
            emailTextFieldMousePressed(evt);
          }
        });

    passwordField.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            passwordFieldMouseClicked(evt);
          }

          public void mousePressed(java.awt.event.MouseEvent evt) {
            passwordFieldMousePressed(evt);
          }
        });

    passwordConfirmationPasswordField.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            passwordConfirmationPasswordFieldMouseClicked(evt);
          }
        });
    passwordConfirmationPasswordField.addKeyListener(
        new java.awt.event.KeyAdapter() {
          public void keyReleased(java.awt.event.KeyEvent evt) {
            passwordConfirmationPasswordFieldKeyReleased(evt);
          }
        });

    cancelButton.setText("Back");
    cancelButton.setActionCommand("back");
    cancelButton.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mousePressed(java.awt.event.MouseEvent evt) {
            backButtonMousePressed(evt);
          }
        });

    submitButton.setText("Submit");
    submitButton.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            submitButtonMouseClicked(evt);
          }
        });

    roleLabel.setText("role:");

    roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(ROLES));
    roleComboBox.setSelectedItem(ROLES[0]);

    javax.swing.GroupLayout accountCreationInnerPanelLayout =
        new javax.swing.GroupLayout(accountCreationInnerPanel);
    accountCreationInnerPanel.setLayout(accountCreationInnerPanelLayout);
    accountCreationInnerPanelLayout.setHorizontalGroup(
        accountCreationInnerPanelLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                accountCreationInnerPanelLayout
                    .createSequentialGroup()
                    .addGroup(
                        accountCreationInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                accountCreationInnerPanelLayout
                                    .createSequentialGroup()
                                    .addComponent(passwordLabel)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        passwordField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        345,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                accountCreationInnerPanelLayout
                                    .createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(
                                        accountCreationInnerPanelLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(passwordConfirmationPasswordFieldLabel)
                                            .addComponent(emailLabel)
                                            .addComponent(departmentLabel)
                                            .addComponent(roleLabel))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        accountCreationInnerPanelLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(
                                                departmentComboBox, 0, 345, Short.MAX_VALUE)
                                            .addComponent(
                                                passwordConfirmationPasswordField,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                345,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                emailTextField,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                345,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                roleComboBox,
                                                0,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(
                                accountCreationInnerPanelLayout
                                    .createSequentialGroup()
                                    .addComponent(cancelButton)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(submitButton)))
                    .addContainerGap()));
    accountCreationInnerPanelLayout.setVerticalGroup(
        accountCreationInnerPanelLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                accountCreationInnerPanelLayout
                    .createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(
                        accountCreationInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                departmentComboBox,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(departmentLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        accountCreationInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roleLabel)
                            .addComponent(
                                roleComboBox,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        accountCreationInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(
                                emailTextField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        accountCreationInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(
                                passwordField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        accountCreationInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordConfirmationPasswordFieldLabel)
                            .addComponent(
                                passwordConfirmationPasswordField,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(
                        accountCreationInnerPanelLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(submitButton))
                    .addGap(60, 60, 60)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap(124, Short.MAX_VALUE)
                    .addComponent(
                        accountCreationInnerPanel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap(36, Short.MAX_VALUE)
                    .addComponent(
                        accountCreationInnerPanel,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)));
  } // </editor-fold>//GEN-END:initComponents

  private void emailTextFieldMousePressed(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_emailTextFieldMousePressed
    emailTextField.setForeground(Color.BLACK);
  } // GEN-LAST:event_emailTextFieldMousePressed

  private void passwordFieldMousePressed(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_passwordFieldMousePressed
    passwordField.setForeground(Color.BLACK);
  } // GEN-LAST:event_passwordFieldMousePressed

  private void emailTextFieldMouseClicked(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_emailTextFieldMouseClicked
    emailTextField.setForeground(Color.BLACK);
  } // GEN-LAST:event_emailTextFieldMouseClicked

  private void passwordFieldMouseClicked(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_passwordFieldMouseClicked
    passwordField.setForeground(Color.BLACK);
  } // GEN-LAST:event_passwordFieldMouseClicked

  private void passwordConfirmationPasswordFieldMouseClicked(
      java.awt.event.MouseEvent
          evt) { // GEN-FIRST:event_passwordConfirmationPasswordFieldMouseClicked
    passwordConfirmationPasswordField.setForeground(Color.BLACK);
  } // GEN-LAST:event_passwordConfirmationPasswordFieldMouseClicked

  private void submitButtonMouseClicked(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_submitButtonMouseClicked
    if (!validateInput()) {
      return;
    }
    User user =
        new User(
            emailTextField.getText(),
            roleComboBox.getSelectedItem().toString(),
            departmentComboBox.getSelectedItem().toString());
    userDao.addUser(user);
    controller.updatePage(pageFactory.buildLoginPage());
  } // GEN-LAST:event_submitButtonMouseClicked

  private void passwordConfirmationPasswordFieldKeyReleased(
      java.awt.event.KeyEvent evt) { // GEN-FIRST:event_passwordConfirmationPasswordFieldKeyReleased
    boolean match =
        Arrays.equals(passwordField.getPassword(), passwordConfirmationPasswordField.getPassword());
    Color confirmationColor = match ? Color.GREEN : Color.RED;
    passwordConfirmationPasswordField.setForeground(confirmationColor);
  } // GEN-LAST:event_passwordConfirmationPasswordFieldKeyReleased

  private void backButtonMousePressed(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_backButtonMousePressed
    controller.updatePage(pageFactory.buildLoginPage());
  } // GEN-LAST:event_backButtonMousePressed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel accountCreationInnerPanel;
  private javax.swing.JButton cancelButton;
  private javax.swing.JComboBox<String> departmentComboBox;
  private javax.swing.JLabel departmentLabel;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JTextField emailTextField;
  private javax.swing.JPasswordField passwordConfirmationPasswordField;
  private javax.swing.JLabel passwordConfirmationPasswordFieldLabel;
  private javax.swing.JPasswordField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JComboBox<String> roleComboBox;
  private javax.swing.JLabel roleLabel;
  private javax.swing.JButton submitButton;
  // End of variables declaration//GEN-END:variables
}
