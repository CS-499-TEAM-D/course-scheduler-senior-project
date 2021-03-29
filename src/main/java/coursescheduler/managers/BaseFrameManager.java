package coursescheduler.managers;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Default {@link FrameManager} object for the Course Scheduler application.
 *
 * Manages pages within the main frame of the Course Scheduler application.
 */
public final class BaseFrameManager extends FrameManager<JFrame, JComponent>
    implements PanelController<JComponent> {

  public BaseFrameManager(JFrame container) {
    super(container);
  }
}
