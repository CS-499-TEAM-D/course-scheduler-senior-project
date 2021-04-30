/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.containers;
import coursescheduler.client.importer.ImportedData;
import coursescheduler.views.pages.subpages.GenerateSchedulePage;
import coursescheduler.views.pages.subpages.MasterSchedulerPage;
import coursescheduler.views.pages.subpages.SaveLoadFilePage;
import coursescheduler.views.pages.subpages.StandardSchedulerPage;
import coursescheduler.client.objects.Course;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author evilc
 */
public class PageControl 
{
    GenerateSchedulePage generateSchedule;
    MasterSchedulerPage master;
    SaveLoadFilePage saveLoadFile;
    StandardSchedulerPage standard;
    List<dummyCourse> allCoursesDummy = new ArrayList<>();
    List<dummyCourse> loadedCoursesDummy = new ArrayList<>();
    String type;
    List<Course> listOfAllCourses = new ArrayList<>();
    ImportedData importedData;
    //FOR CHRIS:
    //Database data;
    
    public PageControl()
    {


    }
    
    public void setCourses (ImportedData input, String type)
    {
        if (input.getCoursesOffered().size() > 0)
        {
            for (int i = 0; i < input.getCoursesOffered().size(); i++)
            {
                listOfAllCourses.add(input.getCoursesOffered().get(i));
            }
            if (type.equals("MASTER"))
            {
                for (int i = 0; i < listOfAllCourses.size(); i++)
                {
                    master.addCourse(listOfAllCourses.get(i));
                }
            }
            else if (type.equals("STANDARD"))
            {
                for (int i = 0; i < listOfAllCourses.size(); i++)
                {
                    standard.addCourse(listOfAllCourses.get(i));
                }
            }
        }
        
    }
    
    
    
    public void setDebugAllCourses() //DUMMY
    {
        String college = "Science";
        int ID = 1230981; //Random number for now
        String name = "CS 499";
        String professor = "Dr. Delugach";
        String room = "3C";
        String times = "8:00am - 9:30am";
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
        name = "ART 201";
        professor = "Dr. History";
        room = "1A";
        times = "9:40am - 11:00am";
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
        name = "ENG 301";
        professor = "Dr. Engineer";
        room = "2B";
        times = "9:40am - 11:00am";
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
        name = "HIST 102";
        professor = "Dr. History";
        room = "1A";
        times = "9:40am - 11:00am";
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
        name = "CS 100";
        professor = "Dr. Science";
        room = "1A";
        times = "3:00pm - 4:20pm";
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
        name = "CS 101";
        professor = "Dr. Science";
        room = "2B";
        times = "5:00pm - 6:20pm";
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
    

  
    public List<dummyCourse> getAllCourses() //DUMMY
    {
        return allCoursesDummy;
    }
    
    public void setType(String input) //REQUIRED (options are "MASTER" and "STANDARD")
    {
        type = input;
    }
    
    public void removeCourse(int ID) //DUMMY
    {
        if (type.equals("MASTER"))
        {
            master.removeCourse_DUMMY(ID);
        }
        else if (type.equals("STANDARD"))
        {
            standard.removeCourse_DUMMY(ID);
        }
    }


    
    /*
    //FOR CHRIS:
    public void removeCourse(int ID) //Remove a course from the table from the "view courses" page (REQUIRED)
    {
        if (type.equals("MASTER"))
        {
            master.removeCourse(ID);
        }
        else if (type.equals("STANDARD"))
        {
            standard.removeCourse(ID);
        }
    }
    */
    
    
    /*
    //FOR CHIRS:
    public void setDatabase(Database input)
    {
        data = input;
    }
    */
   
    /*
    //FOR CHRIS:
    public void addCourse(Course input) //Add a course to the table from the "view courses" page (RQUIRED)
    {
        if (type.equals("MASTER"))
        {
            master.addCourse(input);
        }
        else if (type.equals("STANDARD"))
        {
            standard.addCourse(ID);
        }
    }
    
    FOR CHRIS:
    public Object[] returnObjectFromCourse(Course input)
    {
        Object[] temp = new Object[] 
        { 
            input.getID(), 
            input.getSection(),
            input.getProfessor(), 
            input.getRoom(),
            input.getTimes(), 
            input.getOnlyOne() //True or false boolean
        };
        return temp;
    }
    */
    
    public void setMainPages(GenerateSchedulePage generateScheduleInput, SaveLoadFilePage saveLoadFileInput) //REQUIRED
    {
        generateSchedule = generateScheduleInput;
        generateSchedule.setPageSettingsControl(this);
        
        saveLoadFile = saveLoadFileInput;
        saveLoadFile.setPageSettingsControl(this);
    }
    
    public void setMasterPage(MasterSchedulerPage input) //REQUIRED
    {
        master = input;
        master.setPageSettingsControl(this);
    }
    
    public void setStandardPage(StandardSchedulerPage input) //REQUIRED
    {
        standard = input;
        standard.setPageSettingsControl(this);
    }
    

    
    public void updateTextSizeMain(int size) //WILL ONLY BE USED IF WE RE-ADD THE SETTINGS PAGE
    {
        generateSchedule.setTextSize(size);
        generateSchedule.updateTextSize();
        
        
        saveLoadFile.setTextSize(size);
        saveLoadFile.updateTextSize();
        
        
        if (master != null)
        {
            master.setTextSize(size);
            master.updateTextSize();
        }
        
        if (standard != null)
        {
            standard.setTextSize(size);
            standard.updateTextSize();
        }

    }  
}
