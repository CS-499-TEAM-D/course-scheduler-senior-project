package coursescheduler;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.WindowConstants;

/** Main {@link Container} for Course Scheduler application. */
class CourseSchedulerFrame extends javax.swing.JFrame {

  public CourseSchedulerFrame() {
    super(/*title=*/"Course Scheduler");
    initComponents();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // closes on exit
    setLocationRelativeTo(null); // centers on open
    setLayout(new BorderLayout()); // layout for centering content
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
