package coursescheduler.views.pages;

import coursescheduler.client.daos.UserDao;

import javax.swing.JComponent;

import coursescheduler.Role;
import coursescheduler.User;
import coursescheduler.managers.PanelController;
import coursescheduler.security.CredentialsVerifier;

/** Factory for retrieving instances of pages. */
public class BaseAbstractPageFactory implements AbstractPageFactory {

  private final PanelController panelController;
  private final CredentialsVerifier credentialsVerifier;
  private final UserDao userDao;

  public BaseAbstractPageFactory(
      PanelController panelController, CredentialsVerifier credentialsVerifier, UserDao userDao) {
    this.panelController = panelController;
    this.credentialsVerifier = credentialsVerifier;
    this.userDao = userDao;
  }

  @Override
  public JComponent buildLoginPage() {
    return new BaseLoginPage(panelController, credentialsVerifier, this, userDao);
  }

  @Override
  public JComponent buildAccountCreationPage() {
    return new BaseAccountCreationPage(panelController, this, userDao);
  }

  @Override
  public JComponent buildUserPage(User user) {
    String role = user.getRole();
    switch (role) {
      case Role.DEAN:
        // TODO: return Dean page.
        break;
      case Role.COORDINATOR:
        // TODO: return Coordinator page.
        break;
      default:
        throw new RuntimeException("No page found for user's role.");
    }
    return null;
  }
}
