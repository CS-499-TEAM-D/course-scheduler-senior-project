package coursescheduler.managers;

import javax.swing.JPanel;

/**
 * Handles management of shown pages.
 *
 * @param <P> element to show as page.
 */
public interface PanelController<P extends JPanel> {
  /**
   * Initializes {@link PanelController}, showing the first page.
   *
   * @return
   */
  PanelController initializeStartPage(P page);

  /**
   * Updates the current displayed page.
   *
   * @param page element to display.
   */
  void updatePage(P page);
}
