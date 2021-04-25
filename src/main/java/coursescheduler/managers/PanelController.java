package coursescheduler.managers;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**

 * Logic for managing pages.
 *
 * <p>Allows for starting page initialization and page swapping.
 *
 * @param <P> element to show as page.
 */
public interface PanelController<P extends JComponent> {
  /**
   * Initializes {@link PanelController}, showing the first page.
   *
   * @return
   */
  PanelController init(P page);
  /**
   * Updates the current displayed page.
   *
   * @param page element to display.
   */
  void updatePage(P page);
}
