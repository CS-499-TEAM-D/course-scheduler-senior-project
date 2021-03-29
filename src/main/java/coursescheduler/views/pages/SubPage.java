package coursescheduler.views.pages;

import javax.swing.JComponent;

public interface  SubPage<S extends JComponent> {
    /**
     * Allows the page to initialize itself.
     *
     * <p>This is where an object that extends a Swing component can initialize itself.
     *
     * <p>Similar to Swing's initComponents method.
     */
    S init();
}
