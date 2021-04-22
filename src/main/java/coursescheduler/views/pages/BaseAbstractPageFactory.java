package coursescheduler.views.pages;

import javax.swing.JComponent;

import coursescheduler.Role;
import coursescheduler.User;
import coursescheduler.client.daos.UserDao;
import coursescheduler.managers.PanelController;
import coursescheduler.security.CredentialsVerifier;


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
    System.out.println("we are getting here      "+role+" == "+Role.MANAGER);
    switch (role) {

      case Role.MANAGER:
        // TODO: return main manager page.
        System.out.println("Switching to master page");
        break;
      case Role.COORDINATOR:
        System.out.println("Switching to standard page");
        // TODO: return coordinator page.

        break;
      default:
        throw new RuntimeException("No page found for user's role.");
    }
    return null;
  }
}
