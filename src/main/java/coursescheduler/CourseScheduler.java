package coursescheduler;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

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
    controller.init(loginPage); // start course scheduler application with loginPage
  }
}
