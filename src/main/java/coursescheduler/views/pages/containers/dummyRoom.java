/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.containers;

/**
 *
 * @author evilc
 */
public class dummyRoom 
{
    String building;
    String number;
    int seats;
    
    public dummyRoom()
    {
        
    }
    
    public void setBuilding(String input)
    {
        building = input;
    }
    
    public void setNumber(String input)
    {
        number = input;
    }
    
    public void setSeats(int input)
    {
        seats = input;
    }
    
    public String getBuilding()
    {
        return building;
    }
    
    public String getNumber()
    {
        return number;
    }
    
    public int getSeats()
    {
        return seats;
    }
}
