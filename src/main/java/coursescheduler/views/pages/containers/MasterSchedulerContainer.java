package coursescheduler.views.pages.containers;

import coursescheduler.views.pages.IRolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.MasterSchedulerPage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;

import javax.swing.JTabbedPane;
import java.io.IOException;
import java.security.GeneralSecurityException;


/**
 * Example Role page.
 */
public class MasterSchedulerContainer extends JTabbedPane implements IRolePage {


    public MasterSchedulerContainer() {
        super();
        init();
    }

    @Override
    public void init() {

        MasterSchedulerPage masterSchedulerPage = new MasterSchedulerPage();
        addTab("View Courses", null, masterSchedulerPage, "View Courses");

        SaveLoadFilePage saveLoadFilePage = new SaveLoadFilePage();
        addTab("Save/Load File", null, saveLoadFilePage, "Save/Load File");


        GenerateSchedulePage generateSchedulePage = new GenerateSchedulePage();
        addTab("Generate Schedule", null, generateSchedulePage, "Generate Schedule");


    }
}
