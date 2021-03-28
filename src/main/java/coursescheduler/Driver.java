/** @author(s) Juwuan Turner-Howard */
package coursescheduler;
import coursescheduler.managers.PanelController;

/** Application entry point. */
public class Driver {
  public static void main(String... args) 
  {
    DepartmentChairPage page1 = new DepartmentChairPage();
    PanelController controller = null;
    new CourseScheduler(controller, page1).run();
  }
}
