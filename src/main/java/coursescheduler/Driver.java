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
    mainFrame.setSize(851, 633);
    mainFrame.setResizable(true);
    PanelController panelController = new BaseFrameManager(mainFrame);
    JPanel loginPage = new LoginPage(panelController);
    App app = new CourseScheduler(panelController, loginPage);
    app.run();
  }
  /*
    public static void main(String... args) {
        JFrame mainFrame = new CourseSchedulerFrame();
        mainFrame.setSize(851, 633);
        mainFrame.setResizable(true);
        PanelController panelController = new BaseFrameManager(mainFrame);
        BaseCredentialsVerifier baseCredentialsVerifier = new BaseCredentialsVerifier();
        UserDao userDao = new BaseUserDao();
        BaseAbstractPageFactory baseAbstractPageFactory = new BaseAbstractPageFactory(panelController, baseCredentialsVerifier, userDao);
        JPanel loginPage = new BaseLoginPage(panelController, baseCredentialsVerifier, baseAbstractPageFactory, userDao);
        App app = new CourseScheduler(panelController, loginPage);
        app.run();
    }
     */
}
