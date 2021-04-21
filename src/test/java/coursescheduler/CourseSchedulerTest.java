package coursescheduler;

import coursescheduler.client.daos.BaseUserDao;
import coursescheduler.client.daos.UserDao;
import org.junit.Test;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.security.BaseCredentialsVerifier;
import coursescheduler.security.CredentialsVerifier;
import coursescheduler.views.pages.AbstractPageFactory;
import coursescheduler.views.pages.BaseAbstractPageFactory;
import coursescheduler.views.pages.BaseLoginPage;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CourseSchedulerTest {
  private final CourseSchedulerFrame courseSchedulerFrame = new CourseSchedulerFrame();
  private final PanelController controller = new BaseFrameManager(courseSchedulerFrame);
  private final UserDao userDao = new BaseUserDao();
  private final CredentialsVerifier verifier = new BaseCredentialsVerifier(userDao);
  private final AbstractPageFactory factory = new BaseAbstractPageFactory(controller, verifier, userDao);
  private final BaseLoginPage loginPage = new BaseLoginPage(controller, verifier, factory, userDao);
  private final CourseScheduler courseScheduler = new BaseCourseScheduler(controller, loginPage);

  public CourseSchedulerTest() throws IOException, GeneralSecurityException {
  }

  @Test
  public void main_defaultState_shouldNotFail() {
    courseScheduler.run();
  }
}
