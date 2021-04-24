package coursescheduler;

import com.mongodb.client.MongoDatabase;
import org.junit.Test;

import coursescheduler.client.MongoDbClient;
import coursescheduler.client.daos.BaseUserDao;
import coursescheduler.client.daos.UserDao;
import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.security.BaseCredentialsVerifier;
import coursescheduler.security.CredentialsVerifier;
import coursescheduler.views.pages.AbstractPageFactory;
import coursescheduler.views.pages.BaseAbstractPageFactory;
import coursescheduler.views.pages.BaseLoginPage;
import coursescheduler.views.pages.Page;

public class CourseSchedulerApplicationTest {
  private final CourseSchedulerFrame courseSchedulerFrame = new CourseSchedulerFrame();
  private final PanelController controller = new BaseFrameManager(courseSchedulerFrame);
  private final CredentialsVerifier verifier = new BaseCredentialsVerifier();
  private final MongoDatabase database = MongoDbClient.getInstance().getDatabase("test");
  private final UserDao userDao = new BaseUserDao(database);
  private final AbstractPageFactory factory =
      new BaseAbstractPageFactory(controller, verifier, userDao);
  private final Page loginPage = new BaseLoginPage(controller, verifier, factory, userDao);
  private final CourseSchedulerApplication courseSchedulerApplication =
      new CourseScheduler(controller, loginPage);

  @Test
  public void main_defaultState_shouldNotFail() {
    courseSchedulerApplication.run();
  }
}
