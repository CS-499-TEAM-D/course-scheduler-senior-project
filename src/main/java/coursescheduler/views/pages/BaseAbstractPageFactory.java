package coursescheduler.views.pages;

import javax.swing.JComponent;

import coursescheduler.Role;
import coursescheduler.client.daos.UserDao;
import coursescheduler.client.models.User;
import coursescheduler.managers.PanelController;
import coursescheduler.security.CredentialsVerifier;
import coursescheduler.views.pages.containers.CoordinatorTabbedPane;
import coursescheduler.views.pages.containers.ManagerTabbedPane;


/** Factory for retrieving instances of pages for the Course Scheduler application. */
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
      case Role.MANAGER:

        // TODO: return main manager page.
        break;
      case Role.COORDINATOR:
        // TODO: return coordinator page.
        break;
      default:
        throw new RuntimeException("No page found for user's role.");
    }
    return null;
  }
}
