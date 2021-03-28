/** @author(s) Juwuan Turner-Howard */
package coursescheduler;

import coursescheduler.views.pages.RegistrarPage;
import coursescheduler.views.pages.SaveLoadCSVFilePage;
import coursescheduler.views.pages.FacultyPage;
import coursescheduler.views.pages.SaveLoadSchedulePage;
import coursescheduler.views.pages.SettingsPage;
import coursescheduler.views.pages.GenerateSchedulePage;
import coursescheduler.views.pages.DepartmentChairPage;
import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.LoginPage;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/** Application entry point. */
public class Driver {
  public static void main(String... args) {
    JFrame mainFrame = new CourseSchedulerFrame();
    PanelController panelController = new BaseFrameManager(mainFrame);
    //JPanel loginPage = new LoginPage();
    JPanel DepartmentChair = new DepartmentChairPage();
    
    String type1 = "DEPARTMENT_CHAIR";
    String type2 = "FACULTY";
    String type3 = "REGISTRAR";
    String chosenType = type1;
    JPanel page1 = new JPanel();
    if (chosenType.equals("DEPARTMENT_CHAIR"))
    {
        DepartmentChairPage temp = new DepartmentChairPage();
        page1 = temp;
    }
    else if (chosenType.equals("FACULTY"))
    {
        FacultyPage temp = new FacultyPage();
        page1 = temp;
    }
    else if (chosenType.equals("REGISTRAR"))
    {
        RegistrarPage temp = new RegistrarPage();
        page1 = temp;
    }


    GenerateSchedulePage page2 = new GenerateSchedulePage();
    SettingsPage page3 = new SettingsPage();
    SaveLoadCSVFilePage page4 = new SaveLoadCSVFilePage();
    SaveLoadSchedulePage page5 = new SaveLoadSchedulePage();
    

    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon icon = new ImageIcon("Icons\\viewCoursesIcon.png");

    tabbedPane.addTab("View Courses", icon, page1, "");
    tabbedPane.addTab("Schedule Generator", icon, page2, "");
    tabbedPane.addTab("Save/Load CSV File", icon, page4, "");
    tabbedPane.addTab("Save/Load Schedule", icon, page5, "");
    tabbedPane.addTab("Settings", icon, page3, "");

    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

    mainFrame.add(tabbedPane, BorderLayout.CENTER);
    mainFrame.pack();
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setVisible(true);
    
    
    App app = new CourseScheduler(panelController, DepartmentChair);
    app.run();
  }
}
