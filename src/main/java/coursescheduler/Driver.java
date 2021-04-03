/** @author(s) Juwuan Turner-Howard */
package coursescheduler;

import coursescheduler.infrastructure.database.DatabaseClient;
import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.LoginPage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import java.security.GeneralSecurityException;

/** Application entry point. */
public class Driver {
    public static void main(String... args) throws IOException, GeneralSecurityException {

    DatabaseClient databaseClient = DatabaseClient.getInstance(10);
    JFrame mainFrame = new CourseSchedulerFrame();
    mainFrame.setSize(1150, 700);
    mainFrame.setResizable(false);
    PanelController panelController = new BaseFrameManager(mainFrame, databaseClient);
    JPanel loginPage = new LoginPage(panelController);
    App app = new CourseScheduler(panelController, loginPage);
    app.run();
  }
}
