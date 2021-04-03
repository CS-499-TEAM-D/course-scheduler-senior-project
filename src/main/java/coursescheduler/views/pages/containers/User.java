/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.containers;

/**
 *
 * @author evilc
 *
 * @author chris password field was removed, we should not be storing the password on the machine when we do not need to,
 */
public class User
{
    String department;
    String email;
    public User()
    {
        department = "master";  //Types are "master", or the department prefix
        email = "temp_username";
    }

    public User(String department, String email){
        this.department = department;
        this.email = email;

    }


    public void setType(String input) //Types are "master", or the department prefix
    {
        department = input;
    }
    
    public void setUsername(String input)
    {
        email = input;
    }

    public String getType()
    {
        return department;
    }
    
    public String getUsername()
    {
        return email;
    }

}
