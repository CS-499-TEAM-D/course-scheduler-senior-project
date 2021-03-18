/**
 * @author(s) juwuanturnerhoward
 */
package coursescheduler.managers;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Default {@link FrameManager} object for the Course Scheduler application.
 *
 * <p>Manages pages within the main frame of the Course Scheduler application.
 */
public final class BaseFrameManager extends FrameManager<JFrame, JPanel>
        implements PanelController<JPanel> {
    public BaseFrameManager(JFrame container) {
        super(container);
    }
}
