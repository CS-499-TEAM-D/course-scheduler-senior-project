/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author evilc
 */
public class dummyCourse 
{
    List<dummyCourse> preReqs = new ArrayList<>();
    String college;
    int ID;
    String name;
    String professor;
    String room;
    String times;
    String days;
    int seats;
    
    public dummyCourse()
    {
        college = "Science";
        ID = 1230981; //Random number for now
        name = "Senior Project";
        professor = "Dr. Delugach";
        room = "Online";
        times = "9:40am - 11:00am";
        days = "T, TH";
        seats = 30;
    }
    
    public void addPreReq(dummyCourse input)
    {
        preReqs.add(input);
    }
    
    public void removePreReq(dummyCourse input)
    {
        preReqs.remove(input);
    }
    
    public void clearPreReqs()
    {
        preReqs.clear();
    }
    
    public dummyCourse getPreReqByID(int ID_input)
    {
        dummyCourse temp = new dummyCourse();
        temp.setID(0);
        temp.setCollege("NULL");
        temp.setName("NULL");
        temp.setProfessor("NULL");
        temp.setRoom("NULL");
        temp.setDays("NULL");
        temp.setTimes("NULL");
        temp.setSeats(0);
        
        if (!preReqs.isEmpty())
        {
            for (int i = 0; i < preReqs.size(); i++)
            {
                if (preReqs.get(i).getID() == ID_input)
                {
                    temp = preReqs.get(i);
                    break;
                }
            }
        }
        return temp;  
    }
    
    public dummyCourse getPreReqByName(String input)
    {
        dummyCourse temp = new dummyCourse();
        temp.setID(0);
        temp.setCollege("NULL");
        temp.setName("NULL");
        temp.setProfessor("NULL");
        temp.setRoom("NULL");
        temp.setDays("NULL");
        temp.setTimes("NULL");
        temp.setSeats(0);
        
        if (!preReqs.isEmpty())
        {
            for (int i = 0; i < preReqs.size(); i++)
            {
                if (preReqs.get(i).getName().equals(input))
                {
                    temp = preReqs.get(i);
                    break;
                }
            }
        }
        return temp;  
    }
    
    public String getCollege()
    {
        return college;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getProfessor()
    {
        return professor;
    }
    
    public String getRoom()
    {
        return room;
    }
    
    public String getTimes()
    {
        return times;
    }
    
    public String getDays()
    {
        return days;
    }
    
    public int getSeats()
    {
        return seats;
    }
    
    public void setCollege(String input)
    {
        college = input;
    }
    
    public void setID(int input)
    {
        ID = input;
    }
    
    public void setName(String input)
    {
        name= input;
    }
    
    public void setProfessor(String input)
    {
        professor = input;
    }
  
    public void setRoom(String input)
    {
        room = input;
    }
    
    public void setTimes(String input)
    {
        times = input;
    }
    
    public void setDays(String input)
    {
        days = input;
    }
    
    public void setSeats(int input)
    {
        seats = input;
    }
}
