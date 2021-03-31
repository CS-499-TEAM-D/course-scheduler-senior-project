/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.views.pages.containers.dummyCourse;
import coursescheduler.views.pages.containers.dummyUser;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author evilc
 */
public class inputSingleCourseDataTable 
{
    public inputSingleCourseDataTable()
    {
        
    }
    /*
    Object[] represents the data, which can consists of multiple different types (like strings and ints), that
    will form a single row in the table.
    
    Example:
    //First define everything you want to go into the object; this is not representive of what we will use; this is just an example:
    String college = "Science"; 
    int courseID = 499;
    String courseName = "Senior Project: Team Design";
    String courseProfessor = "Dr. Harry S. Delugach";
    String courseBuilding = "Building 1";
    String courseRoom = "1A";
    String courseTimes = "9:30 to 10:40";
    String courseDays = "Monday, Wednesday";
    int courseSeats = 30;

    //Then create the object using what you want to put in it, preferably keeping the order the same:
    Object[] test = new Object[] 
    { 
            college, 
            courseID, 
            courseName,
            courseProfessor, 
            courseBuilding,
            courseRoom,
            courseTimes,
            courseDays,
            courseSeats,
    }  
    */
    public DefaultTableModel setTableData(Object[] input, DefaultTableModel model)
    {
        model.setValueAt(input[0], 0, 1); //College
        model.setValueAt(input[1], 1, 1); //ID
        model.setValueAt(input[2], 2, 1); //Name
        model.setValueAt(input[3], 3, 1); //Professor
        model.setValueAt(input[4], 4, 1); //Room
        model.setValueAt(input[5], 5, 1); //Times
        model.setValueAt(input[6], 6, 1); //Days
        model.setValueAt(input[7], 7, 1); //Seats
        return model;
    }
    
    public DefaultTableModel setCollege(String input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input, 0, 1); //College
        return model;
    }
    
    public DefaultTableModel setID(int input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input, 1, 1); //ID
        return model;
    }
    
    public DefaultTableModel setName(String input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input, 2, 1); //Name
        return model;
    }
    
    public DefaultTableModel setProfessor(String input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input, 3, 1); //Professor
        return model;
    }
    
    public DefaultTableModel setRoom(String input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input, 4, 1); //Room
        return model;
    }
    
    public DefaultTableModel setTimes(String input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input, 5, 1); //Time
        return model;
    }
    
    public DefaultTableModel setDays(String input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input, 6, 1); //Days
        return model;
    }
    
    public DefaultTableModel setSeats(int input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input, 7, 1); //Seats
        return model;
    }
    
    public DefaultTableModel clearTable(DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt("", 0, 1);
        model.setValueAt("", 1, 1);
        model.setValueAt("", 2, 1);
        model.setValueAt("", 3, 1);
        model.setValueAt("", 4, 1);
        model.setValueAt("", 5, 1);
        model.setValueAt("", 6, 1);
        model.setValueAt("", 7, 1);
        return model;
    }
}
