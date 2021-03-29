package coursescheduler.views.pages.subpages;

import javax.swing.*;

import coursescheduler.views.pages.SubPage;

/** TODO: Javadoc. */
public class FacultyCourseManagementTabbedPane extends JTabbedPane implements SubPage {

  public FacultyCourseManagementTabbedPane() {
    super();
  }

  private <C extends JComponent> JScrollPane scrollPaneOf(C component) {
      return new JScrollPane(component,
              ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  }

  @Override
  public JTabbedPane init() {
    JScrollPane addCourseFacultyPage = scrollPaneOf(new AddCourseFacultyPage());
    addTab("Add Course", null, addCourseFacultyPage, "Tab 1 tooltip");

    JScrollPane removeCoursePage = scrollPaneOf(new RemoveCoursePage());
    addTab("Remove Course", null, removeCoursePage, "Tab 1 tooltip");

    return this;
  }
}
