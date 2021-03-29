/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.managers;
import coursescheduler.views.pages.subpages.AddCourseDepartmentChairPage;
import coursescheduler.views.pages.subpages.AddCourseFacultyPage;
import coursescheduler.views.pages.subpages.EditCoursePage;
import coursescheduler.views.pages.subpages.RemoveCoursePage;
import coursescheduler.views.pages.subpages.PreliminaryCoursesPage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author evilc
 */
public class PopupController 
{
    AddCourseDepartmentChairPage addCourseDepartmentChair;
    AddCourseFacultyPage addCourseFaculty;
    EditCoursePage editCourse;
    RemoveCoursePage removeCourse;
    PreliminaryCoursesPage preliminaryCourses;
    PopupFrame frame;
    
    public PopupController()
    {
        addCourseDepartmentChair = new AddCourseDepartmentChairPage();
        addCourseDepartmentChair.setPopupController(this);
        
        addCourseFaculty = new AddCourseFacultyPage();
        addCourseFaculty.setPopupController(this);
        
        removeCourse = new RemoveCoursePage();
        removeCourse.setPopupController(this);
        
        editCourse = new EditCoursePage();
        editCourse.setPopupController(this);
        
        preliminaryCourses = new PreliminaryCoursesPage();
        preliminaryCourses.setPopupController(this);
        
        frame = new PopupFrame();
        frame.add(addCourseDepartmentChair);
        frame.add(addCourseFaculty);
        frame.add(removeCourse);
        frame.add(editCourse);
        frame.add(preliminaryCourses);
        addCourseDepartmentChair.hide();
        addCourseFaculty.hide();
        removeCourse.hide();
        editCourse.hide();
        preliminaryCourses.hide();
        frame.setDefaultCloseOperation(WindowConstants. DO_NOTHING_ON_CLOSE);
    }
    
    public void disableTabs(JFrame input)
    {
        input.disable();
    }
    
    public void displayAddCourseDepartmentChair()
    {
        
        frame.setSize(370, 530);
        if (frame.isVisible())
        {
            addCourseDepartmentChair.show();
            addCourseFaculty.hide();
            removeCourse.hide();
            editCourse.hide();
            preliminaryCourses.hide();
        }
        else
        {
            frame.setVisible(true);
            addCourseDepartmentChair.show();
        }
    }
    
    public void hideAddCourseDepartmentChair()
    {
        addCourseDepartmentChair.hide();
        frame.setVisible(false);
    }
    
    public void displayAddCourseFaculty()
    {
        frame.setSize(370, 530);
        if (frame.isVisible())
        {
            addCourseDepartmentChair.hide();
            addCourseFaculty.show();
            removeCourse.hide();
            editCourse.hide();
            preliminaryCourses.hide();
        }
        else
        {
            frame.setVisible(true);
            addCourseFaculty.show();
        }
    }
    
    public void hideAddCourseFaculty()
    {
        addCourseFaculty.hide();
        frame.setVisible(false);
    }
    
    
    public void displayRemoveCourse()
    {
        frame.setSize(370, 530);
        if (frame.isVisible())
        {
            addCourseDepartmentChair.hide();
            addCourseFaculty.hide();
            removeCourse.show();
            editCourse.hide();
            preliminaryCourses.hide();
        }
        else
        {
            frame.setVisible(true);
            removeCourse.show();
        }
    }
    
    public void hideRemoveCourse()
    {
        removeCourse.hide();
        frame.setVisible(false);
    }
    
    public void displayEditCourse()
    {
        frame.setSize(410, 560);
        if (frame.isVisible())
        {
            addCourseDepartmentChair.hide();
            addCourseFaculty.hide();
            removeCourse.hide();
            editCourse.show();
            preliminaryCourses.hide();
        }
        else
        {
            frame.setVisible(true);
            editCourse.show();
        }
    }
    
    public void hideEditCourse()
    {
        editCourse.hide();
        frame.setVisible(false);
    }
    
    public void displayPreliminaryCourses()
    {
        frame.setSize(370, 530);
        if (frame.isVisible())
        {
            addCourseDepartmentChair.hide();
            addCourseFaculty.hide();
            removeCourse.hide();
            editCourse.hide();
            preliminaryCourses.show();
        }
        else
        {
            frame.setVisible(true);
            preliminaryCourses.show();
        }
    }
    
    public void hidePreliminaryCourses()
    {
        preliminaryCourses.hide();
        frame.setVisible(false);
    }
    
    
    
}
