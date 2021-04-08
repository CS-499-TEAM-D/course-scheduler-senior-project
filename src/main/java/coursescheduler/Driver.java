/** @author(s) Juwuan Turner-Howard */
package coursescheduler;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.LoginPage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Application entry point. */
public class Driver {
  public static void main(String... args) {
    JFrame mainFrame = new CourseSchedulerFrame();
    PanelController panelController = new BaseFrameManager(mainFrame);
    JPanel loginPage = new LoginPage();
    App app = new CourseScheduler(panelController, loginPage);
    app.run();
  }
}
