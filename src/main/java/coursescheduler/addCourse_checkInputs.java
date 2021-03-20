/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler;

/**
 *
 * @author evilc
 */
public class addCourse_checkInputs 
{
    public addCourse_checkInputs()
    {
        
    }
    
    boolean compareTwoStrings(String input1, String input2)
    {
        if (input1.equals(input2))
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }
    
    boolean compareTwoInts(int input1, int input2)
    {
        if (input1 == input2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
        
}
