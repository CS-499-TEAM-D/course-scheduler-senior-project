package coursescheduler;

import javax.swing.JPanel;

import coursescheduler.infrastructure.database.DatabaseClient;
import coursescheduler.managers.PanelController;

import java.io.IOException;
import java.security.GeneralSecurityException;

/** Sets up and starts the CourseScheduler application. */
final class CourseScheduler implements App {
  private final PanelController controller;
  private final JPanel loginPage;

  CourseScheduler(PanelController controller, JPanel loginPage) throws IOException, GeneralSecurityException {
    this.controller = controller;
    this.loginPage = loginPage;;
  }

  @Override
  public void run() {
    controller.init(loginPage); // start course scheduler application with loginPage
  }
}
