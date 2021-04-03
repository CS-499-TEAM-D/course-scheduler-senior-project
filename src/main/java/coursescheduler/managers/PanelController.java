package coursescheduler.managers;

import coursescheduler.infrastructure.database.DatabaseClient;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Handles management of shown pages.
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

  /**
   * Provides access to the database client
   */
  DatabaseClient getDatabaseClient();
}
