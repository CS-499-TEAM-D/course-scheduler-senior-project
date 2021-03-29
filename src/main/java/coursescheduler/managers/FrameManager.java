package coursescheduler.managers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Optional;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Handles the updating the page inside of a container and state of main container.
 *
 * @param <C> element to display the page.
 * @param <P> element to show as page.
 */
abstract class FrameManager<C extends Container, P extends JComponent> implements PanelController<P> {

  protected C container;
  protected P page;
  private final JPanel panelWrapper; // helps non-programmatic pages show up

  public FrameManager(C container) {
    this.container = container;
    this.panelWrapper = new JPanel();
  }

  @Override
  public PanelController<P> init(P page) {
    Dimension parentSize = container.getSize();
    panelWrapper.setSize(parentSize);
    panelWrapper.setPreferredSize(parentSize);
    panelWrapper.setMaximumSize(parentSize);
    panelWrapper.setLayout(new BorderLayout());
    panelWrapper.add(page, BorderLayout.CENTER);
    container.setLayout(new BorderLayout());
    container.add(panelWrapper, BorderLayout.CENTER);
    container.setVisible(true);

    this.page = page;

    return this;
  }

  @Override
  public void updatePage(P newPage) {
    panelWrapper.add(newPage);
    page.setVisible(false);
    Optional.ofNullable(page).ifPresent(panelWrapper::remove);
    page = newPage;
  }
}
