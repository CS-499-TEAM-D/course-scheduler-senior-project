package coursescheduler.views.pages;

import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.DepartmentChairPageSub;
import coursescheduler.views.pages.subpages.InputMultipleCoursesTable;
import coursescheduler.views.pages.subpages.SaveLoadCSVFilePage;
import coursescheduler.views.pages.subpages.SaveLoadSchedulePage;
import coursescheduler.views.pages.subpages.EditCoursePage;
import coursescheduler.views.pages.subpages.AddCourseDepartmentChairPage;
import coursescheduler.views.pages.subpages.RemoveCoursePage;
import coursescheduler.views.pages.subpages.SettingsPage;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/** Example Role page. */
public class DepartmentChairPage extends JTabbedPane implements RolePage {
  DepartmentChairPage() {
    super();
    init();
  }

  @Override
  public void init() {
        JPanel subPageZero = new DepartmentChairPageSub();
        addTab("Generate Schedule", null, subPageZero, "Tab 1 tooltip");
      
        
        
        JPanel subPageAdd = new AddCourseDepartmentChairPage();
        addTab("Add Course", null, subPageAdd, "Tab 1 tooltip");
      
        JPanel subPageEdit = new EditCoursePage();
        addTab("Edit Course", null, subPageEdit, "Tab 1 tooltip");
        
        JPanel subPageRemove = new RemoveCoursePage();
        addTab("Remove Course", null, subPageRemove, "Tab 1 tooltip");
        
        JPanel subPageOne = new GenerateSchedulePage();
        addTab("Generate Schedule", null, subPageOne, "Tab 1 tooltip");

        JPanel subPageTwo = new SaveLoadCSVFilePage();
        addTab("Save/Load CSV File", null, subPageTwo, "Tab 2 tooltip");

        JPanel subPageThree = new SaveLoadSchedulePage();
        addTab("Save/Load Schedule", null, subPageThree, "Tab 3 tooltip");
        
        JPanel subPageFour = new SettingsPage();
        addTab("Settings", null, subPageFour, "Tab 3 tooltip");  
  }
}
