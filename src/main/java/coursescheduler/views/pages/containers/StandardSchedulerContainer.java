package coursescheduler.views.pages.containers;

import coursescheduler.views.pages.RolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.StandardSchedulerPage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;
import javax.swing.JTabbedPane;


/** Example Role page. */
public class StandardSchedulerContainer extends JTabbedPane implements RolePage {
  PageControl control;
    
    public StandardSchedulerContainer() {
    super();
    init();
  }

  @Override
  public void init() {
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
        addTab("Load File", null, subPageTwo, "Load File");
      
        GenerateSchedulePage subPageOne = new GenerateSchedulePage();
        subPageOne.setPageSettingsControl(control);
        addTab("Generate Schedule", null, subPageOne, "Generate Schedule");

  }
}
