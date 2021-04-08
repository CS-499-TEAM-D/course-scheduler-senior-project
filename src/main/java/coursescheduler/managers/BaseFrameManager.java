package coursescheduler.managers;

import javax.swing.JComponent;
import javax.swing.JFrame;

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
