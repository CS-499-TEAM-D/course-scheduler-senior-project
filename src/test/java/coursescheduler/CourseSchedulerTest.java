package coursescheduler;


import com.google.api.services.sheets.v4.Sheets;
import coursescheduler.infrastructure.database.SheetsServiceUtil;
import org.junit.Test;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;

import coursescheduler.views.pages.LoginPage;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static coursescheduler.DatabaseSheetIDs.TEST;


public class CourseSchedulerTest {
  private final CourseSchedulerFrame courseSchedulerFrame = new CourseSchedulerFrame();
  private final PanelController controller = new BaseFrameManager(courseSchedulerFrame);
  private final Sheets service = SheetsServiceUtil.getSheetsService();
  private final LoginPage loginPage = new LoginPage(controller);
  private final CourseScheduler courseScheduler = new CourseScheduler(controller, loginPage, service, TEST);

  public CourseSchedulerTest() throws IOException, GeneralSecurityException {
  }


  @Test
  public void main_defaultState_shouldNotFail() {
    courseScheduler.run();
  }
}
