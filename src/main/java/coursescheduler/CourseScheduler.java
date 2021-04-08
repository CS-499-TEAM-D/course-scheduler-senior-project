package coursescheduler;

import javax.swing.JPanel;

import coursescheduler.managers.PanelController;

/** Sets up and starts the CourseScheduler application. */
final class CourseScheduler implements App {
  private final PanelController controller;
  private final JPanel loginPage;

  CourseScheduler(PanelController controller, JPanel loginPage) {
    this.controller = controller;
    this.loginPage = loginPage;
  }

  @Override
  public void run() {
    controller.init(loginPage);
  }
}
