package coursescheduler.managers;


import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Allows for the swapping of {@link JComponent} pages inside of a {@link JFrame} container.
 *
 * <p>Manages pages within the main frame of the Course Scheduler application. This allows for the
 * swapping of the {@linkplain JComponent pages}. Note that pages are assumed to be {@link
 * JComponent} objects for flexibility.
 */
public final class BaseFrameManager extends FrameManager<JFrame, JComponent>
    implements PanelController<JComponent> {

  public BaseFrameManager(JFrame container) {
    super(container);
  }
}
