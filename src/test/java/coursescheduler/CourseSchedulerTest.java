package coursescheduler;

import org.junit.Before;
import org.junit.Test;

import javax.swing.JFrame;
import javax.swing.JPanel;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;

public class CourseSchedulerTest {
  private CourseScheduler courseScheduler;
  private PanelController panelController;
  private JPanel startPage;
  private JFrame mainFrame;

  @Before
  public void setUp() {
    panelController = new BaseFrameManager(mainFrame);
    courseScheduler = new CourseScheduler(panelController, startPage);
  }

  @Test
  public void main_defaultState_shouldNotFail() {
    courseScheduler.run();
  }
}
