/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author evilc
 */
public class debuggerControl 
{
    debuggerFrame frame;
    String type1 = "DEPARTMENT_CHAIR";
    String type2 = "FACULTY";
    String type3 = "REGISTRAR";
    String chosenType = type1;
    public debuggerControl()
    {
        frame = new debuggerFrame();
        JPanel page1 = new JPanel();
        if (chosenType.equals("DEPARTMENT_CHAIR"))
        {
            DepartmentChairPage temp = new DepartmentChairPage();
            page1 = temp;
        }
        else if (chosenType.equals("FACULTY"))
        {
            FacultyPage temp = new FacultyPage();
            page1 = temp;
        }
        else if (chosenType.equals("REGISTRAR"))
        {
            RegistrarPage temp = new RegistrarPage();
            page1 = temp;
        }
        
        
        
        
        
        
        GenerateSchedulePage page2 = new GenerateSchedulePage();
        SettingsPage page3 = new SettingsPage();
        
        
        //frame.addPage(page1, "LOAD_SCHEDULE");
        //frame.addPage(page2, "SAVE_SCHEDULE");
        
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = new ImageIcon("Icons\\viewCoursesIcon.png");
        //JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("View Courses", icon, page1, "");
        


        tabbedPane.addTab("Schedule Generator", icon, page2, "");
        
        //JComponent panel2 = makeTextPanel("Panel #2");

        //tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        
        tabbedPane.addTab("Settings", icon, page3, "");
        
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        frame.add(tabbedPane, BorderLayout.CENTER);
        //window.setSize(400,250);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    

    


}
