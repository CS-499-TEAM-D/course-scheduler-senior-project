package coursescheduler.views.pages.containers;

import coursescheduler.views.pages.RolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.DepartmentChairPageSub;
import coursescheduler.views.pages.subpages.SaveLoadCSVFilePage;
import coursescheduler.views.pages.subpages.SaveLoadSchedulePage;
import coursescheduler.views.pages.subpages.SettingsPage;
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
        control.setType("DEPARTMENT_CHAIR");

        DepartmentChairPageSub subPageZero = new DepartmentChairPageSub();
        subPageZero.setPageSettingsControl(control);
        addTab("Course Management", null, subPageZero, "Tab 1 tooltip");
        control.setDepartmentChairPage(subPageZero);

      
        GenerateSchedulePage subPageOne = new GenerateSchedulePage();
        subPageOne.setPageSettingsControl(control);
        addTab("Generate Schedule", null, subPageOne, "Tab 1 tooltip");


        SaveLoadCSVFilePage subPageTwo = new SaveLoadCSVFilePage();
        subPageTwo.setPageSettingsControl(control);
        addTab("Save/Load CSV File", null, subPageTwo, "Tab 2 tooltip");


        SaveLoadSchedulePage subPageThree = new SaveLoadSchedulePage();
        subPageThree.setPageSettingsControl(control);
        addTab("Save/Load Schedule", null, subPageThree, "Tab 3 tooltip");
        control.setMainPages(subPageOne, subPageTwo, subPageThree);

        
        SettingsPage subPageFour = new SettingsPage();
        addTab("Settings", null, subPageFour, "Tab 3 tooltip");  

        
  }
}
