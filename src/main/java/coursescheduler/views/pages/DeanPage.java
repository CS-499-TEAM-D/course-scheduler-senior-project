package coursescheduler.views.pages;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import coursescheduler.views.pages.subpages.SubPageOne;
import coursescheduler.views.pages.subpages.SubPageThree;
import coursescheduler.views.pages.subpages.SubPageTwo;

/** Example Role page. */
public class DeanPage extends JTabbedPane implements RolePage {
  DeanPage() {
    super();
    init();
  }

  @Override
  public void init() {
    JPanel subPageOne = new SubPageOne();
    addTab("Sub Page 1", null, subPageOne, "Tab 1 tooltip");

    JPanel subPageTwo = new SubPageTwo();
    addTab("Sub Page 2", null, subPageTwo, "Tab 2 tooltip");

    JPanel subPageThree = new SubPageThree();
    addTab("Sub Page 3", null, subPageThree, "Tab 3 tooltip");
  }
}
