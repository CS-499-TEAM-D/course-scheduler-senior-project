package coursescheduler.views.pages.containers;

import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.IRolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.StandardSchedulerPage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;

import javax.swing.JTabbedPane;
import java.io.IOException;
import java.security.GeneralSecurityException;


/**
 * Example Role page.
 */
public class StandardSchedulerContainer extends JTabbedPane implements IRolePage {
    public StandardSchedulerContainer() {
        super();
        init();
    }

    @Override
    public void init() {

        StandardSchedulerPage standardSchedulerPage = new StandardSchedulerPage();
        addTab("View Courses", null, standardSchedulerPage, "View Courses");

        SaveLoadFilePage saveLoadFilePage = new SaveLoadFilePage();
        addTab("Save/Load File", null, saveLoadFilePage, "Save/Load File");

        GenerateSchedulePage generateSchedulePage = new GenerateSchedulePage();
        addTab("Generate Schedule", null, generateSchedulePage, "Generate Schedule");

    }
}
