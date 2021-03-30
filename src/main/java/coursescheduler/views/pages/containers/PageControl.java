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
    
    public PageControl()
    {
        //System.out.println("TEST");
        dummyCourse temp = new dummyCourse();
        for (int i = 0; i < 10; i++)
        {
            /*
            temp.setCollege("Science");
            temp.setID(i);
            temp.setDays("M, W");
            temp.setSeats(30);
            temp.setRoom("3C");
            temp.setProfessor("Temp Professor");
            temp.setName("Temp");
            temp.setTimes("9:30am - 11:00am");
            allCoursesDummy.add(temp);
            */
        }
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
        departmentChair.removeCourse(returnDummyCourseByName(name).getID());
        for(int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getName().equals(name))
            {
                allCoursesDummy.remove(allCoursesDummy.get(i));
                break;
            }
        }
        
    }
    
    public void addCourseDepartmentChair(dummyCourse input)
    {
        allCoursesDummy.add(input);
        departmentChair.addCourse(input);
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
