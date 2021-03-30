/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.containers;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.DepartmentChairPageSub;
import coursescheduler.views.pages.subpages.SaveLoadCSVFilePage;
import coursescheduler.views.pages.subpages.SaveLoadSchedulePage;
import coursescheduler.views.pages.subpages.RegistrarPageSub;
import coursescheduler.views.pages.subpages.FacultyPageSub;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author evilc
 */
public class PageControl 
{
    GenerateSchedulePage generateSchedule;
    DepartmentChairPageSub departmentChair;
    SaveLoadCSVFilePage saveLoadCSVFile;
    SaveLoadSchedulePage saveLoadSchedule;
    RegistrarPageSub registrar;
    FacultyPageSub faculty;
    List<dummyCourse> allCoursesDummy = new ArrayList<>();
    String type;
    
    public PageControl()
    {


    }
    
    public void setType(String input)
    {
        type = input;
    }
    
    public List<dummyCourse> getAllCourses()
    {
        return allCoursesDummy;
    }
    
    public dummyCourse returnDummyCourseByID(int ID)
    {
        dummyCourse temp = null;
        for (int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getID() == ID)
            {
                temp = allCoursesDummy.get(i);
                break;
            }
        }
        return temp;      
    }
    
    public dummyCourse returnDummyCourseByName(String name)
    {
        int j = 0;
        for (int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getName().equals(name))
            {
                j = i;
                break;
            }
        }
        if (!allCoursesDummy.isEmpty())
        {
            return allCoursesDummy.get(j); 
        }
        
        return null;      
    }
    
    public boolean checkSameName(String name)
    {
        for (int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkSameID(int ID)
    {
        for (int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getID() == ID)
            {
                return true;
            }
        }
        return false;
    }

    
    public void removeCourseByName(String name)
    {
        if (type.equals("DEPARTMENT_CHAIR"))
        {
            departmentChair.removeCourse(returnDummyCourseByName(name).getID());
        }
        else if (type.equals("FACULTY"))
        {
            faculty.removeCourse(returnDummyCourseByName(name).getID());
        }

        for(int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getName().equals(name))
            {
                allCoursesDummy.remove(allCoursesDummy.get(i));
                break;
            }
        }
        
    }
    
    public void editCourse(dummyCourse input)
    {
        for (int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getID() == input.getID())
            {
                allCoursesDummy.get(i).setCollege(input.getCollege());
                allCoursesDummy.get(i).setID(input.getID());
                allCoursesDummy.get(i).setName(input.getName());
                allCoursesDummy.get(i).setProfessor(input.getProfessor());
                allCoursesDummy.get(i).setRoom(input.getRoom());
                allCoursesDummy.get(i).setTimes(input.getTimes());
                allCoursesDummy.get(i).setDays(input.getDays());
                allCoursesDummy.get(i).setSeats(input.getSeats());
                break;
            }
        }
        
        departmentChair.updateCourse(input);
        
    }
    
    public void addCourseDepartmentChair(dummyCourse input)
    {
        allCoursesDummy.add(input);
        departmentChair.addCourse(input);
    }
    
    public void addCourseDepartmentFaculty(dummyCourse input)
    {
        allCoursesDummy.add(input);
        faculty.addCourse(input);
    }
    
    public void setMainPages(GenerateSchedulePage generateScheduleInput, SaveLoadCSVFilePage saveLoadCSVFileInput, SaveLoadSchedulePage saveLoadScheduleInput)
    {
        generateSchedule = generateScheduleInput;
        generateSchedule.setPageSettingsControl(this);
        
        saveLoadCSVFile = saveLoadCSVFileInput;
        saveLoadCSVFile.setPageSettingsControl(this);
          
        saveLoadSchedule = saveLoadScheduleInput;
        saveLoadSchedule.setPageSettingsControl(this);
    }
    
    public void setDepartmentChairPage(DepartmentChairPageSub input)
    {
        departmentChair = input;
        departmentChair.setPageSettingsControl(this);
    }
    
    public void setFacultyPage(FacultyPageSub input)
    {
        faculty = input;
        faculty.setPageSettingsControl(this);
    }
    
    public void setRegistrarPage(RegistrarPageSub input)
    {
        registrar = input;
        registrar.setPageSettingsControl(this);
    }
    
    public void updateTextSizeMain(int size)
    {
        generateSchedule.setTextSize(size);
        generateSchedule.updateTextSize();
        
        
        saveLoadCSVFile.setTextSize(size);
        saveLoadCSVFile.updateTextSize();
        
        saveLoadSchedule.setTextSize(size);
        saveLoadSchedule.updateTextSize();
        
        if (departmentChair != null)
        {
            departmentChair.setTextSize(size);
            departmentChair.updateTextSize();
        }
        
        if (faculty != null)
        {
            faculty.setTextSize(size);
            faculty.updateTextSize();
        }
        
        if (registrar != null)
        {
            registrar.setTextSize(size);
            registrar.updateTextSize();
        }
    }
    
    public void updateTextSizeDepartmentChair(int size)
    {
        departmentChair.setTextSize(size);
        departmentChair.updateTextSize();
    }
    
    public void updateTextSizeFaculty(int size)
    {
        faculty.setTextSize(size);
        faculty.updateTextSize();
    }
    
    public void udpateTextSizeRegistrar(int size)
    {
        registrar.setTextSize(size);
        registrar.updateTextSize();
    }

    
}
