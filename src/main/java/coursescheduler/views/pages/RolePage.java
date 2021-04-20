package coursescheduler.views.pages;

import javax.swing.JComponent;

import coursescheduler.User;

/** Interfacing functionality for role pages. */
public interface RolePage extends Page {
  /**
   * Allows the page to initialize itself.
   *
   * <p>This is where an object that extends a Swing component can initialize itself.
   *
   * <p>Similar to Swing's initComponents method.
   */
  JComponent init(User user);
}
