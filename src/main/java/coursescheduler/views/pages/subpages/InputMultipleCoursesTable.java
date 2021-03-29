/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;

import javax.swing.table.DefaultTableModel;

 /*
    Object[] represents the data, which can consists of multiple different types (like strings and ints), that
    will form a single row in the table.
    
    Example:
    //First define everything you want to go into the object; this is not representive of what we will use; this is just an example:
    String college = "Science"; 
    int courseID = 499;
    String courseName = "Senior Project: Team Design";
    String courseProfessor = "Dr. Harry S. Delugach";
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
            courseRoom,
            courseTimes,
            courseDays,
            courseSeats,
    }  
*/
//This is for the large table that can hold multiple courses and their respective data.
public class InputMultipleCoursesTable 
{
    public InputMultipleCoursesTable () {}
    
    public DefaultTableModel removeRow(int IDInput, DefaultTableModel modelInput) //NEEDS TESTING!
    {
        //Remove the indicated row (based on the course ID) from the table and shift the rest of the rows up (if applicable)
        DefaultTableModel model = modelInput;
        int index = -1;
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if (model.getValueAt(i, 0).equals(IDInput))
            {
                index = i;
                break;
            }
        }
        
        //Move the rest of the rows that fall under the removed row up by 1
        if (index != -1)
        {
            model.removeRow(index);
            if (index != model.getRowCount())
            {
                model.moveRow((index+1), (model.getRowCount() - 1), 1); //NEEDS TESTING!
            }
            
        }
        return model;
    }
    
    public DefaultTableModel addRow(Object[] input, DefaultTableModel modelInput)
    {
        DefaultTableModel model = modelInput;
        int index;
        if(!checkIfFull(model)) //If the table is not full
        {
            index = returnNextEmptyIndex(model);
            if (index != -1)
            {
                model.setValueAt(input[0], index, 0);
                model.setValueAt(input[1], index, 1);
                model.setValueAt(input[2], index, 2);
                model.setValueAt(input[3], index, 3);
                model.setValueAt(input[4], index, 4);
                model.setValueAt(input[5], index, 5);
                model.setValueAt(input[6], index, 6);
                model.setValueAt(input[7], index, 7);
            }
        }
        else
        {
            model.addRow(input);
        }
        return model;
    }
    
    public DefaultTableModel updateRow(Object[] input, DefaultTableModel modelInput, int row)
    {
        DefaultTableModel model = modelInput;
        model.setValueAt(input[0], row, 0);
        model.setValueAt(input[1], row, 1);
        model.setValueAt(input[2], row, 2);
        model.setValueAt(input[3], row, 3);
        model.setValueAt(input[4], row, 4);
        model.setValueAt(input[5], row, 5);
        model.setValueAt(input[6], row, 6);
        model.setValueAt(input[7], row, 7);
        return model;
    }
   
    public boolean checkIfFull(DefaultTableModel modelInput)
    {
        int numFull = 0;
        for (int i = 0; i < modelInput.getRowCount(); i++)
        {
            if (!modelInput.getValueAt(i, 0).equals(""))
            {
                numFull++;
            }
        }
        
        if (numFull < modelInput.getRowCount())
        {
            return false;
        }
        else
        {
            return true;
        }
        
    }

    public int returnNextEmptyIndex(DefaultTableModel modelInput)
    {
        int index = -1;
        for (int i = 0; i < modelInput.getRowCount(); i++)
        {
            if (modelInput.getValueAt(i, 0).equals(""))
            {
                return index;
            }
        }
        return index;
    }

    Object[] createObject(String collegeInput, int IDInput, String nameInput, String professorInput, String roomInput, String timesInput, String daysInput, int seatsInput)
    {
        Object[] temp = new Object[] 
        { 
            collegeInput, 
            IDInput, 
            nameInput,
            professorInput, 
            roomInput,
            timesInput,
            daysInput,
            seatsInput    
        };  
        return temp;
    }

    Object[] getObjectFromRow(DefaultTableModel modelInput, int row)
    {
        DefaultTableModel model = modelInput;
        Object[] temp = new Object[] 
        { 
            model.getValueAt(row, 0), 
            model.getValueAt(row, 1), 
            model.getValueAt(row, 2),
            model.getValueAt(row, 3), 
            model.getValueAt(row, 4),
            model.getValueAt(row, 5),
            model.getValueAt(row, 6),
            model.getValueAt(row, 7)    
        }; 
        return temp;
    }

}
