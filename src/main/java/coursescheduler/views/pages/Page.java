package coursescheduler.views.pages;


import javax.swing.JComponent;

/**
 * Consistent initializer method for Course Scheduler pages.
 *
 * <p>This allows for the extension or foregoing of Swing's initComponents method, helping to remove
 * logic from constructors.

 */
public interface Page {
  JComponent init();
}
