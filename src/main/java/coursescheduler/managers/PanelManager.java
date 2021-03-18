/**
 * @author(s) juwuanturnerhoward
 */

package coursescheduler.managers;

import javax.swing.JComponent;

/**
 * Handles the updating of the page inside of a container.
 *
 * @param <C> Container to display the page type.
 * @param <P> extends JComponent and will that will be shown as contained page.
 */
abstract class PanelManager<C, P extends JComponent> implements PanelController<P> {
    @Override
    public void update(P page) {
        // TODO(jth): Implement.
    }
}
