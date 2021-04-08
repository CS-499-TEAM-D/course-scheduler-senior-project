package coursescheduler;

import org.junit.Test;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.LoginPage;

public class CourseSchedulerTest {
  private final CourseSchedulerFrame courseSchedulerFrame = new CourseSchedulerFrame();
  private final PanelController controller = new BaseFrameManager(courseSchedulerFrame);
  private final LoginPage loginPage = new LoginPage(controller);
  private final CourseScheduler courseScheduler = new CourseScheduler(controller, loginPage);

  @Test
  public void main_defaultState_shouldNotFail() {
    courseScheduler.run();
  }
}
