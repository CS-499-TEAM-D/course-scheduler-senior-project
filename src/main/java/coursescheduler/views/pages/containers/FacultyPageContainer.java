package coursescheduler.views.pages.containers;

import coursescheduler.views.pages.RolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.FacultyPageSub;
import coursescheduler.views.pages.subpages.SaveLoadCSVFilePage;
import coursescheduler.views.pages.subpages.SaveLoadSchedulePage;
import coursescheduler.views.pages.subpages.SettingsPage;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/** Example Role page. */
public class FacultyPageContainer extends JTabbedPane implements RolePage {
  PageControl control;
    
    public FacultyPageContainer() {
    super();
    init();
  }

  @Override
  public void init() {
        control = new PageControl();
      
        FacultyPageSub subPageZero = new FacultyPageSub();
        addTab("Course Management", null, subPageZero, "Tab 1 tooltip");
        control.setFacultyPage(subPageZero);
      
        GenerateSchedulePage subPageOne = new GenerateSchedulePage();
        addTab("Generate Schedule", null, subPageOne, "Tab 1 tooltip");

        SaveLoadCSVFilePage subPageTwo = new SaveLoadCSVFilePage();
        addTab("Save/Load CSV File", null, subPageTwo, "Tab 2 tooltip");

        SaveLoadSchedulePage subPageThree = new SaveLoadSchedulePage();
        addTab("Save/Load Schedule", null, subPageThree, "Tab 3 tooltip");
        control.setMainPages(subPageOne, subPageTwo, subPageThree);
        
        SettingsPage subPageFour = new SettingsPage();
        addTab("Settings", null, subPageFour, "Tab 3 tooltip");  
        subPageFour.setControl(control);
  }
}
