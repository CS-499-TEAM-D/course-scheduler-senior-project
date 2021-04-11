package coursescheduler;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.Test;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.security.BaseCredentialsVerifier;
import coursescheduler.security.CredentialsVerifier;
import coursescheduler.views.pages.BaseLoginPage;

public class CourseSchedulerTest {
  private final Injector injector = Guice.createInjector(new CourseSchedulerModule());
  private final CourseScheduler courseScheduler = injector.getInstance(CourseScheduler.class);

//  private final CourseSchedulerFrame courseSchedulerFrame = new CourseSchedulerFrame();
//  private final PanelController controller = new BaseFrameManager(courseSchedulerFrame);
//  private final CredentialsVerifier verifier = new BaseCredentialsVerifier();
//  private final BaseLoginPage loginPage = new BaseLoginPage(controller, verifier);
//  private final CourseScheduler courseScheduler = new CourseScheduler(controller, loginPage);

  @Test
  public void main_defaultState_shouldNotFail() {
    courseScheduler.run();
  }
}
