package coursescheduler.views.pages.containers;

import coursescheduler.views.pages.RolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.MasterSchedulerPage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;
import javax.swing.JTabbedPane;


/** Example Role page. */
public class MasterSchedulerContainer extends JTabbedPane implements RolePage {
 
    
    public MasterSchedulerContainer() {
    super();
    init();
  }

  @Override
  public void init() {
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
