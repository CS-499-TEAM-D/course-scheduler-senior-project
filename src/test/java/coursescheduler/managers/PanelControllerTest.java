package coursescheduler.managers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import javax.swing.JFrame;

public class PanelControllerTest {
  @Mock JFrame jFrame = new JFrame();

  PanelController baseFrameManager = new BaseFrameManager(jFrame);

  @Before
  public void setUp() {}

  @Test
  public void updatePage_valid() {

  }
}
