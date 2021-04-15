package coursescheduler.views.pages.containers;

import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.IRolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.StandardSchedulerPage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;
import javax.swing.JTabbedPane;
import java.io.IOException;
import java.security.GeneralSecurityException;


/** Example Role page. */
public class StandardSchedulerContainer extends JTabbedPane implements IRolePage {
  PageControl control;
    
    public StandardSchedulerContainer() throws IOException, GeneralSecurityException {
    super();
    init();
  }

  @Override
  public void init() throws IOException, GeneralSecurityException {
        PageControl control = new PageControl();
        control.setDebugAllCourses();
        control.setType("STANDARD");

        StandardSchedulerPage subPageZero = new StandardSchedulerPage();
        subPageZero.setPageSettingsControl(control);
        addTab("View Courses", null, subPageZero, "View Courses");
        control.setType("STANDARD");
        control.setStandardPage(subPageZero);
        
        SaveLoadFilePage subPageTwo = new SaveLoadFilePage();
        subPageTwo.setPageSettingsControl(control);
        subPageTwo.setUserType("STANDARD");
        addTab("Save/Load File", null, subPageTwo, "Save/Load File");
      
        GenerateSchedulePage subPageOne = new GenerateSchedulePage();
        subPageOne.setPageSettingsControl(control);
        addTab("Generate Schedule", null, subPageOne, "Generate Schedule");

  }
}
