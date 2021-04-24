package coursescheduler.views.pages.containers;

import javax.swing.JTabbedPane;

import coursescheduler.views.pages.RolePage;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;
import coursescheduler.views.pages.subpages.StandardSchedulerPage;

/** Tabbed page for a Course Scheduler Coordinator. */
public class CoordinatorTabbedPane extends JTabbedPane implements RolePage {

  public CoordinatorTabbedPane() {
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
