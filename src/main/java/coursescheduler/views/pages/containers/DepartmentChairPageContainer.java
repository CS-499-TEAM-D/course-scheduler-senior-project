package coursescheduler.views.pages.containers;

import coursescheduler.views.pages.RolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.DepartmentCoordinatorPage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;
import coursescheduler.views.pages.subpages.SettingsPage;
import coursescheduler.views.pages.subpages.CampusViewPage;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/** Example Role page. */
public class DepartmentChairPageContainer extends JTabbedPane implements RolePage {
 
    
    public DepartmentChairPageContainer() {
    super();
    init();
  }

  @Override
  public void init() {
        PageControl control = new PageControl();
        control.setDebugAllCourses();
        control.setType("DEPARTMENT_COORDINATOR");

        DepartmentCoordinatorPage subPageZero = new DepartmentCoordinatorPage();
        subPageZero.setPageSettingsControl(control);
        addTab("Course Management", null, subPageZero, "Course Management");
        control.setDepartmentCoordinatorPage(subPageZero);
        
        SaveLoadFilePage subPageTwo = new SaveLoadFilePage();
        subPageTwo.setUserType("MASTER");
        subPageTwo.setPageSettingsControl(control);
        addTab("Save/Load File", null, subPageTwo, "Save/Load File");
        
        CampusViewPage campusView = new CampusViewPage();
        campusView.setPageSettingsControl(control);
        addTab("Campus View", null, campusView, "Campus View");
        
        GenerateSchedulePage subPageOne = new GenerateSchedulePage();
        subPageOne.setPageSettingsControl(control);
        addTab("Generate Schedule", null, subPageOne, "Generate Schedule");

        SettingsPage subPageFour = new SettingsPage();
        addTab("Settings", null, subPageFour, "Settings");  

        
  }
}
