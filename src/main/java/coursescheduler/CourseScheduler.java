package coursescheduler;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.LoginPage;

/** Sets up and starts the CourseScheduler application. */
final class CourseScheduler {
    private final PanelController controller;
    private final JComponent startPage;

    CourseScheduler(PanelController controller, JComponent startPage) {
        this.controller = controller;
        this.startPage = startPage;
    }

    public void run() {
        controller.initializeStartPage(startPage);
    }

    public static void main(String... args) {
        JFrame mainFrame = new CourseSchedulerFrame();
        PanelController panelController = new BaseFrameManager(mainFrame);
        JPanel loginPage = new LoginPage(panelController);
        CourseScheduler app = new CourseScheduler(panelController, loginPage);
        app.run();
    }
}