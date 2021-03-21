/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler;

import javax.swing.table.DefaultTableModel;
import coursescheduler.managers.PanelController;

/**
 *
 * @author evilc
 */
public class EditCourse extends javax.swing.JPanel {
    String page = "EDIT_COURSE";
    PanelController controller;
    boolean validCollege = false;
    boolean validID = false;
    boolean validName = false;
    boolean validProfessor = false;
    boolean validRoom = false;
    boolean validTimes = false;
    boolean validDays = false;
    boolean validSeats = false;
    boolean allInputsValid = false;
    inputSingleCourseDataTable editor;

    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    public EditCourse() {
        initComponents();
        editor = new inputSingleCourseDataTable();
    }
    
    public DefaultTableModel getModel()
    {
        return (DefaultTableModel) Table1.getModel();
    }
    
    public void setTable(Object[] input)
    {
        Table1.setModel(editor.setTableData(input, (DefaultTableModel) Table1.getModel()));
    }
    
    public void setCollege(String input)
    {
        Table1.setModel(editor.setCollege(input, (DefaultTableModel) Table1.getModel()));
    }
    
    public void setID(int input)
    {
        Table1.setModel(editor.setID(input, (DefaultTableModel) Table1.getModel()));
    }
    
    public void setName(String input)
    {
        Table1.setModel(editor.setName(input, (DefaultTableModel) Table1.getModel()));
    }
    
    public void setProfessor(String input)
    {
        Table1.setModel(editor.setProfessor(input, (DefaultTableModel) Table1.getModel()));
    }
    
    public void setRoom(String input)
    {
        Table1.setModel(editor.setRoom(input, (DefaultTableModel) Table1.getModel()));
    }
    
    public void setTimes(String input)
    {
        Table1.setModel(editor.setTimes(input, (DefaultTableModel) Table1.getModel()));
    }
    
    public void setDays(String input)
    {
        Table1.setModel(editor.setDays(input, (DefaultTableModel) Table1.getModel()));
    }
    
    public void setSeats(int input)
    {
        Table1.setModel(editor.setSeats(input, (DefaultTableModel) Table1.getModel()));
    }
    
     public void checkSeats()
    {
        String Seats_string = editCourseSeatsInput.getText();
        int Seats;
        if (!Seats_string.equals(""))
        {
            try
            {
                Seats = Integer.parseInt(Seats_string.trim());
                editCourseError_Seats.setText("");
                if(Seats > -1)
                {
                    validID = true;
                }
                else
                {
                    editCourseError_Seats.setText("*");
                    validID = false;
                }
            }
            catch (NumberFormatException nfe)
            {
                editCourseError_Seats.setText("*");
                validID = false;
            }
        }
        else
        {
            editCourseError_Seats.setText("*");
            validID = false;
        }
    }
    
    public void checkRoom()
    {
        String Room = (String) editCourseRoomsCombo.getSelectedItem();
        if (!(Room.equals("")) && !(Room.equals("Select Room")))
        {
            validRoom = true;
            editCourseError_Room.setText("");
        }
        else
        {
            editCourseError_Room.setText("*");
            validRoom = false;
        }
    }
    
    public void checkTimes()
    {
        String Times = (String) editCourseTimesCombo.getSelectedItem();
        if (!(Times.equals("")) && !(Times.equals("Select Time")))
        {
            validTimes = true;
            editCourseError_Times.setText("");
        }
        else
        {
            editCourseError_Times.setText("*");
            validTimes = false;
        }
    }
    
    public void checkDays()
    {
        String Days = (String) editCourseDaysCombo.getSelectedItem();
        if (!(Days.equals("")) && !(Days.equals("Select Days")))
        {
            validDays = true;
            editCourseError_Days.setText("");
        }
        else
        {
            editCourseError_Days.setText("*");
            validDays = false;
        }
    }
    
    public void checkCollege()
    {
        String College = (String) editCourseCollegeCombo.getSelectedItem();
        if (!(College.equals("") && !(College.equals("Select College"))))
        {
            editCourseError_College.setText("");
            validCollege = true;
        }
        else
        {
            validCollege = false;
            editCourseError_College.setText("*");
        }
    }
    
    public void checkName()
    {
        String Name = editCourseNameInput.getText();
        if (!(Name.equals("")))
        {
            validName = true;
            editCourseError_Name.setText("");
        }
        else
        {
            validName = false;
            editCourseError_Name.setText("*");
        }
    }
    
    public void checkID()
    {
        String ID_string = editCourseIDInput.getText();
        int ID;
        if (!ID_string.equals(""))
        {
             try
            {
                ID = Integer.parseInt(ID_string.trim());
                editCourseError_ID.setText("");
                validID = true;
            }
            catch (NumberFormatException nfe)
            {
                editCourseError_ID.setText("*");
                validID = false;
            }  
        }
        else
        {
            editCourseError_ID.setText("*");
            validID = false;
        }
    }
    
    public void checkProfessor()
    {
        String Professor = editCourseProfessorInput.getText();
        if (!(Professor.equals("")))
        {
            validProfessor = true;
            editCourseError_Professor.setText("");
        }
        else
        {
            validProfessor = false;
            editCourseError_Professor.setText("*");
        }
    }
  
    public void checkAllInputs()
    {   
       checkCollege();
       checkID();
       checkName();
       checkProfessor();
       checkTimes();
       checkDays();
       checkSeats();
       
       if (validCollege && validID && validName && validProfessor && validTimes && validDays && validSeats)
       {
           allInputsValid = true;
       }
       else
       {
           allInputsValid = false;
       }
    }

    public int getSeats()
    {
        int seats = -1;
        checkSeats();
        if (validSeats)
        {
             String Seats_string = editCourseSeatsInput.getText();
             seats = Integer.parseInt(Seats_string.trim());
        }
        return seats;
    }
    
    public int getID()
    {
        int ID = -1;
        checkID();
        if (validID)
        {
             String ID_string = editCourseSeatsInput.getText();
             ID = Integer.parseInt(ID_string.trim());
        }
        return ID;
    }
    
    public String getCollege()
    {
        String college = "INCORRECT_VALUE_SELECTED";
        checkCollege();
        if (validCollege)
        {
            college = (String) editCourseCollegeCombo.getSelectedItem();
        }
        return college;
    }
    
    public String getRoom()
    {
        String room = "INCORRECT_VALUE_SELECTED";
        checkRoom();
        if (validRoom)
        {
            room = (String) editCourseRoomsCombo.getSelectedItem();
        }
        return room;
    }
    
    public String getTimes()
    {
        String times = "INCORRECT_VALUE_SELECTED";
        checkTimes();
        if (validTimes)
        {
            times = (String) editCourseTimesCombo.getSelectedItem();
        }
        return times;
    }
    
    public String getDays()
    {
        String days= "INCORRECT_VALUE_SELECTED";
        checkDays();
        if (validDays)
        {
            days = (String) editCourseDaysCombo.getSelectedItem();
        }
        return days;
    }
    
    public String getProfessor()
    {
       String professor = "INCORRECT_INPUT";
       checkProfessor();
       if(validProfessor)
       {
           professor = editCourseProfessorInput.getText();
       }
       return professor;
    }
    
    public String getName()
    {
       String name = "INCORRECT_INPUT";
       checkName();
       if(validName)
       {
           name = editCourseNameInput.getText();
       }
       return name;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        addCourseSubmitButton = new javax.swing.JButton();
        addCourseCancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editCourseProfessorInput = new javax.swing.JTextField();
        editCourseIDInput = new javax.swing.JTextField();
        editCourseTimesCombo = new javax.swing.JComboBox<>();
        editCourseDaysCombo = new javax.swing.JComboBox<>();
        editCourseCollegeCombo = new javax.swing.JComboBox<>();
        addCourseErrorDisplay1 = new javax.swing.JLabel();
        editCourseCollegeCombo1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        editCourseSeatsInput = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        editCourseError_Course = new javax.swing.JLabel();
        editCourseError_College = new javax.swing.JLabel();
        editCourseError_Professor = new javax.swing.JLabel();
        editCourseError_ID = new javax.swing.JLabel();
        editCourseError_Room = new javax.swing.JLabel();
        editCourseError_Times = new javax.swing.JLabel();
        editCourseError_Days = new javax.swing.JLabel();
        editCourseError_Seats = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        editCourseNameInput = new javax.swing.JTextField();
        editCourseError_Name = new javax.swing.JLabel();
        editCourseRoomsCombo = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Edit Course");

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"College:", null},
                {"ID:", null},
                {"Name:", null},
                {"Professor:", null},
                {"Room(s):", null},
                {"Times:", null},
                {"Days:", null},
                {"Seats:", null}
            },
            new String [] {
                "Course Info", ""
            }
        ));
        jScrollPane1.setViewportView(Table1);

        addCourseSubmitButton.setText("Submit");

        addCourseCancelButton.setText("Cancel");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("College:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Professor:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Room(s):");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Times:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Days:");

        editCourseTimesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Times" }));

        editCourseDaysCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Days" }));

        editCourseCollegeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select College" }));

        editCourseCollegeCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Course:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Seats:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Name:");

        editCourseRoomsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Times" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(addCourseCancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCourseSubmitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editCourseSeatsInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editCourseCollegeCombo1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 176, Short.MAX_VALUE)
                                    .addComponent(editCourseDaysCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editCourseTimesCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 176, Short.MAX_VALUE)
                                    .addComponent(editCourseIDInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(editCourseNameInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editCourseProfessorInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editCourseCollegeCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editCourseRoomsCombo, 0, 176, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addCourseErrorDisplay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Course, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseError_College, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseError_Professor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseError_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseError_Room, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseError_Times, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseError_Days, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseError_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseError_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(422, 422, 422))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(editCourseCollegeCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(editCourseError_Course, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(editCourseCollegeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(editCourseError_College, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(editCourseIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(editCourseError_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addCourseErrorDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(editCourseError_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editCourseNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Professor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseProfessorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Room, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(editCourseRoomsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Times, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseTimesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Days, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseDaysCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseSeatsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCourseSubmitButton)
                    .addComponent(addCourseCancelButton))
                .addGap(4, 4, 4))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton addCourseCancelButton;
    private javax.swing.JLabel addCourseErrorDisplay1;
    private javax.swing.JButton addCourseSubmitButton;
    private javax.swing.JComboBox<String> editCourseCollegeCombo;
    private javax.swing.JComboBox<String> editCourseCollegeCombo1;
    private javax.swing.JComboBox<String> editCourseDaysCombo;
    private javax.swing.JLabel editCourseError_College;
    private javax.swing.JLabel editCourseError_Course;
    private javax.swing.JLabel editCourseError_Days;
    private javax.swing.JLabel editCourseError_ID;
    private javax.swing.JLabel editCourseError_Name;
    private javax.swing.JLabel editCourseError_Professor;
    private javax.swing.JLabel editCourseError_Room;
    private javax.swing.JLabel editCourseError_Seats;
    private javax.swing.JLabel editCourseError_Times;
    private javax.swing.JTextField editCourseIDInput;
    private javax.swing.JTextField editCourseNameInput;
    private javax.swing.JTextField editCourseProfessorInput;
    private javax.swing.JComboBox<String> editCourseRoomsCombo;
    private javax.swing.JTextField editCourseSeatsInput;
    private javax.swing.JComboBox<String> editCourseTimesCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
