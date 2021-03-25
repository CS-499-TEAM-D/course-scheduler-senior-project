/**
 * @author(s) juwuanturnerhoward
 */

package coursescheduler.managers;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Default {@link PanelManager} object for the Course Scheduler application.
 */
public final class BasePanelManger extends PanelManager<JFrame, JPanel>
        implements PanelController<JPanel> {

    public BasePanelManger() {
        super();
    }

    @Override
    public void update(JPanel page) {
        return;
    }
}
