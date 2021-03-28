package coursescheduler.managers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Optional;
import javax.swing.JPanel;

import coursescheduler.views.pages.AddCourseDepartmentChairPage;
import coursescheduler.views.pages.AddCourseFacultyPage;
import coursescheduler.views.pages.RemoveCoursePage;
import coursescheduler.views.pages.EditCoursePage;
import coursescheduler.views.pages.PreliminaryCoursesPage;

/**
 * Handles the updating the page inside of a container and state of main container.
 *
 * @param <C> element to display the page.
 * @param <P> element to show as page.
 */
abstract class FrameManager<C extends Container, P extends JPanel> implements PanelController<P> {

  protected C container;
  protected P page;
  private final JPanel panelWrapper; // helps non-programmatic pages show up
  String type1 = "DEPARTMENT_CHAIR";
  String type2 = "FACULTY";
  String type3 = "REGISTRAR";
  String chosenType = type1;
  AddCourseDepartmentChairPage addCourseDepartmentChair;
  AddCourseFacultyPage addCourseFaculty;
  RemoveCoursePage removeCourse;
  EditCoursePage editCourse;
  PreliminaryCoursesPage preliminaryCourses;
  PopupFrame popupFrame;
  
  
  public FrameManager(C container) {
    this.container = container;
    this.panelWrapper = new JPanel();
  }

  @Override
  public PanelController<P> init(P page) 
  {
    Dimension parentSize = container.getSize();
    panelWrapper.setSize(parentSize);
    panelWrapper.setPreferredSize(parentSize);
    panelWrapper.setMaximumSize(parentSize);
    panelWrapper.setLayout(new BorderLayout());
    panelWrapper.add(page, BorderLayout.CENTER);
    container.setLayout(new BorderLayout());
    container.add(panelWrapper, BorderLayout.CENTER);
    container.setVisible(true);
    
    
    addCourseDepartmentChair = new AddCourseDepartmentChairPage();
    addCourseFaculty = new AddCourseFacultyPage();
    removeCourse = new RemoveCoursePage();
    editCourse = new EditCoursePage();
    preliminaryCourses = new PreliminaryCoursesPage();
    popupFrame = new PopupFrame();
    popupFrame.add(addCourseDepartmentChair);
    popupFrame.add(addCourseFaculty);
    popupFrame.add(removeCourse);
    popupFrame.add(editCourse);
    popupFrame.add(preliminaryCourses);
      
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
  
  public void removePopup()
  {
      popupFrame.setVisible(false);
  }
  
  public void createPopup(String pageName)
  {
      if (pageName.equals("ADD_COURSE_DEPARTMENT_CHAIR"))
      {
        popupFrame.add(addCourseDepartmentChair);
        popupFrame.remove(addCourseFaculty);
        popupFrame.remove(removeCourse);
        popupFrame.remove(editCourse);
        popupFrame.remove(preliminaryCourses);
      }
      else if (pageName.equals("ADD_COURSE_FACULTY"))
      {
        popupFrame.remove(addCourseDepartmentChair);
        popupFrame.add(addCourseFaculty);
        popupFrame.remove(removeCourse);
        popupFrame.remove(editCourse);
        popupFrame.remove(preliminaryCourses);
      }
      else if (pageName.equals("REMOVE_COURSE"))
      {
        popupFrame.remove(addCourseDepartmentChair);
        popupFrame.remove(addCourseFaculty);
        popupFrame.add(removeCourse);
        popupFrame.remove(editCourse);
        popupFrame.remove(preliminaryCourses);
      }
      else if (pageName.equals("EDIT_COURSE"))
      {
        popupFrame.remove(addCourseDepartmentChair);
        popupFrame.remove(addCourseFaculty);
        popupFrame.remove(removeCourse);
        popupFrame.add(editCourse);
        popupFrame.remove(preliminaryCourses);
      }
      else if (pageName.equals("PRELIMINARY_COURSES"))
      {
        popupFrame.remove(addCourseDepartmentChair);
        popupFrame.remove(addCourseFaculty);
        popupFrame.remove(removeCourse);
        popupFrame.remove(editCourse);
        popupFrame.add(preliminaryCourses);
      }
      popupFrame.setVisible(true);
  }
}
