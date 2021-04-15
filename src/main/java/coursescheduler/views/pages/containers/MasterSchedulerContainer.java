package coursescheduler.views.pages.containers;

import coursescheduler.views.pages.IRolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.MasterSchedulerPage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;
import javax.swing.JTabbedPane;
import java.io.IOException;
import java.security.GeneralSecurityException;


/** Example Role page. */
public class MasterSchedulerContainer extends JTabbedPane implements IRolePage {
 
    
    public MasterSchedulerContainer() throws IOException, GeneralSecurityException {
    super();
    init();
  }

  @Override
  public void init() throws IOException, GeneralSecurityException {
        PageControl control = new PageControl();
        control.setDebugAllCourses();
        control.setType("MASTER");

        MasterSchedulerPage subPageZero = new MasterSchedulerPage();
        subPageZero.setPageSettingsControl(control);
        addTab("View Courses", null, subPageZero, "View Courses");
        control.setType("MASTER");
        control.setMasterPage(subPageZero);
        
        SaveLoadFilePage subPageTwo = new SaveLoadFilePage();
        subPageTwo.setPageSettingsControl(control);
        subPageTwo.setUserType("MASTER");
        addTab("Save/Load File", null, subPageTwo, "Save/Load File");
        
      
        GenerateSchedulePage subPageOne = new GenerateSchedulePage();
        subPageOne.setPageSettingsControl(control);
        addTab("Generate Schedule", null, subPageOne, "Generate Schedule");

        
  }
}
