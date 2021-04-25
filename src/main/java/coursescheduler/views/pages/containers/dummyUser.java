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
public class dummyUser 
{
    String type;
    String username;
    String password;
    public dummyUser()
    {
        type = "DEPARTMENT_CHAIR"; //Types are "DEPARTMENT_CHAIR", "FACULTY", and "REGISTRAR"
        username = "temp_username";
        password = "temp_password";
    }
    
    public void setType(String input) //Types are "DEPARTMENT_CHAIR", "FACULTY", and "REGISTRAR"
    {
        type = input;
    }
    
    public void setUsername(String input)
    {
        username = input;
    }
    
    public void setPassword(String input)
    {
        password = input;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
}
