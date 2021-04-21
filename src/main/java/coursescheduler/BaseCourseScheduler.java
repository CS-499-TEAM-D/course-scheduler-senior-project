package coursescheduler;

import coursescheduler.client.daos.BaseUserDao;
import coursescheduler.client.daos.UserDao;

import javax.swing.JComponent;
import javax.swing.JFrame;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.security.BaseCredentialsVerifier;
import coursescheduler.security.CredentialsVerifier;
import coursescheduler.views.pages.AbstractPageFactory;
import coursescheduler.views.pages.BaseAbstractPageFactory;
import coursescheduler.views.pages.BaseLoginPage;
import coursescheduler.views.pages.Page;

import java.io.IOException;
import java.security.GeneralSecurityException;

/** Sets up and starts the CourseScheduler application. */
final class BaseCourseScheduler implements CourseScheduler {
  private final PanelController controller;
  private final JComponent loginPage;

  BaseCourseScheduler(PanelController controller, Page loginPage) {
    this.controller = controller;
    this.loginPage = loginPage.init();
  }

  @Override
  public void run() {
    controller.initializeStartPage(loginPage);
  }

  public static void main(String... args) throws IOException, GeneralSecurityException {
    JFrame mainFrame = new CourseSchedulerFrame();
    PanelController panelController = new BaseFrameManager(mainFrame);

    UserDao userDao = new BaseUserDao();

    CredentialsVerifier credentialsVerifier = new BaseCredentialsVerifier(userDao);

    AbstractPageFactory factory = new BaseAbstractPageFactory(panelController, credentialsVerifier, userDao);

    Page loginPage = new BaseLoginPage(panelController, credentialsVerifier, factory, userDao);

    CourseScheduler app = new BaseCourseScheduler(panelController, loginPage);
    app.run();
  }
}
