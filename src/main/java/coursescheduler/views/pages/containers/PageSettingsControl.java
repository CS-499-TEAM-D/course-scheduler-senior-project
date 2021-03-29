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
import javax.swing.JPanel;


/**
 *
 * @author evilc
 */
public class PageSettingsControl 
{
    GenerateSchedulePage generateSchedule;
    DepartmentChairPageSub departmentChair;
    SaveLoadCSVFilePage saveLoadCSVFile;
    SaveLoadSchedulePage saveLoadSchedule;
    RegistrarPageSub registrar;
    FacultyPageSub faculty;
    
    public PageSettingsControl()
    {
        
    }
    
    public void setMainPages(GenerateSchedulePage generateScheduleInput, SaveLoadCSVFilePage saveLoadCSVFileInput, SaveLoadSchedulePage saveLoadScheduleInput)
    {
        generateSchedule = generateScheduleInput;
        saveLoadCSVFile = saveLoadCSVFileInput;
        saveLoadSchedule = saveLoadScheduleInput;
    }
    
    public void setDepartmentChairPage(DepartmentChairPageSub input)
    {
        departmentChair = input;
    }
    
    public void setFacultyPage(FacultyPageSub input)
    {
        faculty = input;
    }
    
    public void setRegistrarPage(RegistrarPageSub input)
    {
        registrar = input;
    }
    
    public void updateTextSize(int size)
    {
        generateSchedule.setTextSize(size);
        generateSchedule.updateTextSize();
        
        departmentChair.setTextSize(size);
        departmentChair.updateTextSize();
        
        saveLoadCSVFile.setTextSize(size);
        saveLoadCSVFile.updateTextSize();
        
        saveLoadSchedule.setTextSize(size);
        saveLoadSchedule.updateTextSize();
        
        //registrar.setTextSize(size);
        //registrar.updateTextSize();
        
        //faculty.setTextSize(size);
        //faculty.updateTextSize();
    }

    
}
