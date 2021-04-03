package coursescheduler;

import coursescheduler.infrastructure.database.DatabaseClient;
import org.junit.Before;
import org.junit.Test;

import javax.swing.JFrame;
import javax.swing.JPanel;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CourseSchedulerTest {
  private CourseScheduler courseScheduler;
  private PanelController panelController;
  private DatabaseClient databaseClient;
  private JPanel startPage;
  private JFrame mainFrame;

  @Before
  public void setUp() throws IOException, GeneralSecurityException {
    panelController = new BaseFrameManager(mainFrame, databaseClient);
    courseScheduler = new CourseScheduler(panelController, startPage);
  }

  @Test
  public void main_defaultState_shouldNotFail() {
    courseScheduler.run();
  }
}
