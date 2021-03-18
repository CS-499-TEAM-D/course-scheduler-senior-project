/**
 * @author(s) juwuanturnerhoward
 */

package coursescheduler.managers;

import javax.swing.JComponent;

/**
 * Updates container with page element.
 *
 * @param <P> element to show as page.
 */
public interface PanelController<P extends JComponent> {
    /**
     * @param page element to display.
     */
    void update(P page);
}
