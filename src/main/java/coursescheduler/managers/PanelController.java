/**
 * @author(s) juwuanturnerhoward
 */

package coursescheduler.managers;

import javax.swing.JComponent;

/**
 * Updates container with page element.
 *
 * @param <P> will be shown as contained page.
 */
public interface PanelController<P extends JComponent> {
    /**
     * @param page element to display.
     */
    void update(P page);
}
