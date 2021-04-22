package coursescheduler;

import com.google.api.services.sheets.v4.Sheets;
import coursescheduler.client.daos.BaseUserDao;
import coursescheduler.client.daos.UserDao;
import coursescheduler.infrastructure.database.SheetsServiceUtil;
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

import static coursescheduler.DatabaseSheetIDs.TEST;

public class CourseSchedulerApplicationTest {
  private final CourseSchedulerFrame courseSchedulerFrame = new CourseSchedulerFrame();
  private final PanelController controller = new BaseFrameManager(courseSchedulerFrame);
  private Sheets service = SheetsServiceUtil.getSheetsService();
  private final UserDao userDao = new BaseUserDao(service, TEST);
  private final CredentialsVerifier verifier = new BaseCredentialsVerifier(userDao, service, TEST);
  private final AbstractPageFactory factory = new BaseAbstractPageFactory(controller, verifier, userDao);
  private final BaseLoginPage loginPage = new BaseLoginPage(controller, verifier, factory, userDao);
  private final CourseSchedulerApplication courseSchedulerApplication = new CourseScheduler(controller, loginPage, service, TEST);

  public CourseSchedulerApplicationTest() throws IOException, GeneralSecurityException {
  }

  @Test
  public void main_defaultState_shouldNotFail() {
    courseSchedulerApplication.run();
  }
}
