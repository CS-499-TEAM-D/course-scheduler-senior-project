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
    List<dummyCourse> loadedCoursesDummy = new ArrayList<>();
    String type;
    
    public PageControl()
    {


    }
    
    
    public void setDebugAllCourses()
    {
        String college = "Science";
        int ID = 1230981; //Random number for now
        String name = "Senior Project";
        String professor = "Dr. Delugach";
        String room = "3C";
        String times = "9:30am - 11:00am";
        String days = "T, TH";
        int seats = 30;
        dummyCourse course1 = new dummyCourse();
        course1.setCollege(college);
        course1.setID(ID);
        course1.setName(name);
        course1.setProfessor(professor);
        course1.setRoom(room);
        course1.setTimes(times);
        course1.setDays(days);
        course1.setSeats(seats);
        course1.setSection(1);
        allCoursesDummy.add(course1);
        loadedCoursesDummy.add(course1);
        
        
        college = "Art";
        ID = 1342343; //Random number for now
        name = "Art 101";
        professor = "Dr. History";
        room = "1A";
        times = "9:30am - 11:00am";
        days = "T, TH";
        seats = 30;
        dummyCourse course2 = new dummyCourse();
        course2.setCollege(college);
        course2.setID(ID);
        course2.setName(name);
        course2.setProfessor(professor);
        course2.setRoom(room);
        course2.setTimes(times);
        course2.setDays(days);
        course2.setSeats(seats);
        course2.setSection(2);
        allCoursesDummy.add(course2);
        loadedCoursesDummy.add(course2);
        
        college = "Engineering";
        ID = 4564564; //Random number for now
        name = "Engineering 101";
        professor = "Dr. Engineer";
        room = "2B";
        times = "9:30am - 11:00am";
        days = "M, W, F";
        seats = 30;
        dummyCourse course3 = new dummyCourse();
        course3.setCollege(college);
        course3.setID(ID);
        course3.setName(name);
        course3.setProfessor(professor);
        course3.setRoom(room);
        course3.setTimes(times);
        course3.setDays(days);
        course3.setSeats(seats);
        course3.setSection(3);
        allCoursesDummy.add(course3);
        loadedCoursesDummy.add(course3);
        
        college = "History";
        ID = 67867867; //Random number for now
        name = "History 1900";
        professor = "Dr. History";
        room = "1A";
        times = "9:30am - 11:00am";
        days = "M, W, F";
        seats = 30;
        dummyCourse course4 = new dummyCourse();
        course4.setCollege(college);
        course4.setID(ID);
        course4.setName(name);
        course4.setProfessor(professor);
        course4.setRoom(room);
        course4.setTimes(times);
        course4.setDays(days);
        course4.setSeats(seats);
        course4.setSection(1);
        allCoursesDummy.add(course4);
        loadedCoursesDummy.add(course4);
        
        college = "Science";
        ID = 32423421; //Random number for now
        name = "Computer Science 101";
        professor = "Dr. Science";
        room = "1A";
        times = "9:30am - 11:00am";
        days = "M, W, F";
        seats = 30;
        dummyCourse course5 = new dummyCourse();
        course5.setCollege(college);
        course5.setID(ID);
        course5.setName(name);
        course5.setProfessor(professor);
        course5.setRoom(room);
        course5.setTimes(times);
        course5.setDays(days);
        course5.setSeats(seats);
        course5.setSection(2);
        allCoursesDummy.add(course5);
        loadedCoursesDummy.add(course5);
        
        college = "Science";
        ID = 17309328; //Random number for now
        name = "Intro to C++";
        professor = "Dr. Science";
        room = "2B";
        times = "9:30am - 11:00am";
        days = "M, W, F";
        seats = 30;
        dummyCourse course6 = new dummyCourse();
        course6.setCollege(college);
        course6.setID(ID);
        course6.setName(name);
        course6.setProfessor(professor);
        course6.setRoom(room);
        course6.setTimes(times);
        course6.setDays(days);
        course6.setSeats(seats);
        course6.setSection(2);
        allCoursesDummy.add(course6);
        loadedCoursesDummy.add(course6);
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
    
    public dummyCourse returnDummyCourseByNameAll(String name)
    {
        if (!allCoursesDummy.isEmpty())
        {
            for (int i = 0; i < allCoursesDummy.size(); i++)
            {
                if (allCoursesDummy.get(i).getName().equals(name))
                {
                    return allCoursesDummy.get(i);

                }
            }
        }
        
        return null;      
    }
    
    
    public dummyCourse returnDummyCourseByNameLoaded(String name)
    {
        if (!loadedCoursesDummy.isEmpty())
        {
            for (int i = 0; i < loadedCoursesDummy.size(); i++)
            {
                if (loadedCoursesDummy.get(i).getName().equals(name))
                {
                    return loadedCoursesDummy.get(i);

                }
            }
        }
        
        return null;      
    }
    
    public dummyCourse returnDummyCourseByName_PreReq(String courseName, String preName)
    {
        int j = 0;
        for (int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getName().equals(courseName))
            {
                j = i;
                break;
            }
        }
        
        
        if (!allCoursesDummy.get(j).returnPreReqs().isEmpty())
        {
            for (int i = 0; i < allCoursesDummy.get(j).returnPreReqs().size(); i++)
            {
                if (allCoursesDummy.get(j).returnPreReqs().get(i).getName().equals(preName))
                {
                    return allCoursesDummy.get(j).returnPreReqs().get(i);
                }
            }
        
        }
        
        return null;      
    }
    
    
  
    
    public boolean checkSameName(String name)
    {
        for (int i = 0; i < loadedCoursesDummy.size(); i++)
        {
            if (loadedCoursesDummy.get(i).getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkSameName_PreReq(String courseName, String preName)
    {
        if (!returnDummyCourseByNameAll(courseName).returnPreReqs().isEmpty())
        {
            for (int i = 0; i < returnDummyCourseByNameAll(courseName).returnPreReqs().size(); i++)
            {
                if (returnDummyCourseByNameAll(courseName).returnPreReqs().get(i).getName().equals(preName))
                {  
                    if (returnDummyCourseByNameAll(courseName).returnPreReqs().get(i).getName().equals(courseName))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        
        return false;
        
    }
    
    public boolean checkSameID_PreReq(int courseID, int preID)
    {
        if (!returnDummyCourseByID(courseID).returnPreReqs().isEmpty())
        {
            for (int i = 0; i < returnDummyCourseByID(courseID).returnPreReqs().size(); i++)
            {
                if (returnDummyCourseByID(courseID).returnPreReqs().get(i).getID() == preID)
                {  
                    if (returnDummyCourseByID(courseID).returnPreReqs().get(i).getID() == preID)
                    {
                        return true;
                    }
                }
            }
            return false;
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
    
    public void addPreReq(String courseName, String preName)
    {
        dummyCourse preCourse = new dummyCourse();
        preCourse = returnDummyCourseByNameAll(preName);
        int index = getIndexByName(courseName);
        if (index != -1)
        {
            allCoursesDummy.get(index).addPreReq(preCourse);
        }
        
        
    }
    
    public void printPreReqs(String courseName)
    {
        dummyCourse temp = new dummyCourse();
        temp = returnDummyCourseByNameAll(courseName);
        System.out.println(courseName);
        if (!temp.returnPreReqs().isEmpty())
        {
            for (int i = 0; i < temp.returnPreReqs().size(); i++)
            {
                System.out.println(temp.returnPreReqs().get(i).getName());
            }
        }
        else
        {
            System.out.println("No pre-reqs.");
        }
        System.out.println("---------------");
    }
    
    public void removePreReq(String courseName, String preName)
    {
        dummyCourse preCourse = new dummyCourse();
        preCourse = returnDummyCourseByName_PreReq(courseName, preName);
        int index = getIndexByName(courseName);
        if (index != -1)
        {
            allCoursesDummy.get(index).removePreReq(preCourse);
        }
        
        
    }
    
    public int getIndexByName(String name)
    {
        int index = -1;
        for (int i = 0; i < allCoursesDummy.size(); i++)
        {
            if (allCoursesDummy.get(i).getName().equals(name))
            {
                index = i;
                return index;
            }
        }
        return index;
    }

    
    public void removeCourseByName(String name)
    {
        if (type.equals("DEPARTMENT_CHAIR"))
        {
            departmentChair.removeCourse(returnDummyCourseByNameLoaded(name).getID(), name);
        }
        else if (type.equals("FACULTY"))
        {
            faculty.removeCourse(returnDummyCourseByNameLoaded(name).getID(), name);
        }

        for(int i = 0; i < loadedCoursesDummy.size(); i++)
        {
            if (loadedCoursesDummy.get(i).getName().equals(name))
            {
                loadedCoursesDummy.remove(loadedCoursesDummy.get(i));
                break;
            }
        }
        
    }
    
    public void editCourse(dummyCourse input)
    {
        for (int i = 0; i < loadedCoursesDummy.size(); i++)
        {
            if (loadedCoursesDummy.get(i).getID() == input.getID())
            {
                loadedCoursesDummy.get(i).setCollege(input.getCollege());
                loadedCoursesDummy.get(i).setID(input.getID());
                loadedCoursesDummy.get(i).setName(input.getName());
                loadedCoursesDummy.get(i).setProfessor(input.getProfessor());
                loadedCoursesDummy.get(i).setRoom(input.getRoom());
                loadedCoursesDummy.get(i).setTimes(input.getTimes());
                loadedCoursesDummy.get(i).setDays(input.getDays());
                loadedCoursesDummy.get(i).setSeats(input.getSeats());
                break;
            }
        }
        
        departmentChair.updateCourse(input);
        
    }
    
    public void addCourseDepartmentChair(dummyCourse input)
    {
        loadedCoursesDummy.add(input);
        departmentChair.addCourse(input);
    }
    
    public void addCourseFaculty(dummyCourse input)
    {
        loadedCoursesDummy.add(input);
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
