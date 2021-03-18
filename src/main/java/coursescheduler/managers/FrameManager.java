/**
 * @author(s) juwuanturnerhoward
 */
package coursescheduler.managers;

import javax.swing.JComponent;
import javax.swing.text.html.Option;
import java.awt.Container;
import java.util.Optional;

/**
 * Handles the updating the page inside of a container and state of main container.
 *
 * @param <C> element to display the page.
 * @param <P> element to show as page.
 */
abstract class FrameManager<C extends Container, P extends JComponent>
        implements PanelController<P> {

    protected C container;
    protected P page;

    public FrameManager(C container) {
        this.container =
                container; // TODO(jth): see if container needs to have CardLayout for this to work.
    }

    @Override
    public void updatePage(P newPage) {
        newPage.setVisible(true);
        container.add(newPage);
        Optional.ofNullable(page).ifPresent(container::remove);
        page = newPage;
        container.setVisible(true);
    }
}
