/**
 * @author(s) juwuanturnerhoward
 */

package coursescheduler.managers;

import javax.swing.JComponent;

/**
 * Handles the updating the page inside of a container and state of main container.
 *
 * @param <C> element to display the page.
 * @param <P> element to show as page.
 */
abstract class PanelManager<C, P extends JComponent> implements PanelController<P> {}
