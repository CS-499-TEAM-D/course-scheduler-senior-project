/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;

import javax.swing.table.DefaultTableModel;
import coursescheduler.managers.PanelController;
import coursescheduler.managers.PopupController;
import java.awt.Font;

/**
 *
 * @author evilc
 */
public class EditCoursePage extends javax.swing.JPanel {
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
    PopupController popupController;
    int textSize = 12;
    
    public void setPopupController(PopupController input)
    {
        popupController = input;
    }
  
    public void setTextSize(int input)
    {
        textSize = input;
    }
    
    public int getTextSize()
    {
        return textSize;
    }

    public void updateTextSize()
    {
        this.setTextSize(textSize);
        int size1 = jLabel1.getFont().getSize();
        int difference1 = size1 - textSize;
        Font newFont1 = new Font("Tahoma", Font.PLAIN,  textSize);
        Font newFont2 = new Font("Tahoma", Font.PLAIN,  (textSize + difference1));
        jLabel1.setFont(newFont2); //Edit Course
        jLabel2.setFont(newFont1); //College:
        jLabel3.setFont(newFont1); //ID:
        jLabel4.setFont(newFont1); //Professor:
        jLabel5.setFont(newFont1); //Room:
        jLabel6.setFont(newFont1); //Times:
        jLabel7.setFont(newFont1); //Days:
        jLabel8.setFont(newFont1); //Course:
        jLabel9.setFont(newFont1); //Seats:
        jLabel11.setFont(newFont1); //Name:
        selectCourseComboBox.setFont(newFont1);
        selectCollegeComboBox.setFont(newFont1);
        selectRoomComboBox.setFont(newFont1);
        selectTimesComboBox.setFont(newFont1);
        selectDaysComboBox.setFont(newFont1);
        idInput.setFont(newFont1);
        professorInput.setFont(newFont1);
        nameInput.setFont(newFont1);
        seatsInput.setFont(newFont1);
        submitButton.setFont(newFont1);
    }
    
    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    public EditCoursePage() {
        initComponents();
        editor = new inputSingleCourseDataTable();
    }
    
    public DefaultTableModel getModel()
    {
        return (DefaultTableModel) courseInfoTable.getModel();
    }
    
    public void setTable(Object[] input)
    {
        courseInfoTable.setModel(editor.setTableData(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
    public void setCollege(String input)
    {
        courseInfoTable.setModel(editor.setCollege(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
    public void setID(int input)
    {
        courseInfoTable.setModel(editor.setID(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
    public void setName(String input)
    {
        courseInfoTable.setModel(editor.setName(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
    public void setProfessor(String input)
    {
        courseInfoTable.setModel(editor.setProfessor(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
    public void setRoom(String input)
    {
        courseInfoTable.setModel(editor.setRoom(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
    public void setTimes(String input)
    {
        courseInfoTable.setModel(editor.setTimes(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
    public void setDays(String input)
    {
        courseInfoTable.setModel(editor.setDays(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
    public void setSeats(int input)
    {
        courseInfoTable.setModel(editor.setSeats(input, (DefaultTableModel) courseInfoTable.getModel()));
    }
    
     public void checkSeats()
    {
        String Seats_string = seatsInput.getText();
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
        String Room = (String) selectRoomComboBox.getSelectedItem();
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
        String Times = (String) selectTimesComboBox.getSelectedItem();
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
        String Days = (String) selectDaysComboBox.getSelectedItem();
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
        String College = (String) selectCollegeComboBox.getSelectedItem();
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
        String Name = nameInput.getText();
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
        String ID_string = idInput.getText();
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
        String Professor = professorInput.getText();
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
             String Seats_string = seatsInput.getText();
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
             String ID_string = seatsInput.getText();
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
            college = (String) selectCollegeComboBox.getSelectedItem();
        }
        return college;
    }
    
    public String getRoom()
    {
        String room = "INCORRECT_VALUE_SELECTED";
        checkRoom();
        if (validRoom)
        {
            room = (String) selectRoomComboBox.getSelectedItem();
        }
        return room;
    }
    
    public String getTimes()
    {
        String times = "INCORRECT_VALUE_SELECTED";
        checkTimes();
        if (validTimes)
        {
            times = (String) selectTimesComboBox.getSelectedItem();
        }
        return times;
    }
    
    public String getDays()
    {
        String days= "INCORRECT_VALUE_SELECTED";
        checkDays();
        if (validDays)
        {
            days = (String) selectDaysComboBox.getSelectedItem();
        }
        return days;
    }
    
    public String getProfessor()
    {
       String professor = "INCORRECT_INPUT";
       checkProfessor();
       if(validProfessor)
       {
           professor = professorInput.getText();
       }
       return professor;
    }
    
    public String getName()
    {
       String name = "INCORRECT_INPUT";
       checkName();
       if(validName)
       {
           name = nameInput.getText();
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
        courseInfoTable = new javax.swing.JTable();
        submitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        professorInput = new javax.swing.JTextField();
        idInput = new javax.swing.JTextField();
        selectTimesComboBox = new javax.swing.JComboBox<>();
        selectDaysComboBox = new javax.swing.JComboBox<>();
        selectCollegeComboBox = new javax.swing.JComboBox<>();
        addCourseErrorDisplay1 = new javax.swing.JLabel();
        selectCourseComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        seatsInput = new javax.swing.JTextField();
        editCourseError_Course = new javax.swing.JLabel();
        editCourseError_College = new javax.swing.JLabel();
        editCourseError_Professor = new javax.swing.JLabel();
        editCourseError_ID = new javax.swing.JLabel();
        editCourseError_Room = new javax.swing.JLabel();
        editCourseError_Times = new javax.swing.JLabel();
        editCourseError_Days = new javax.swing.JLabel();
        editCourseError_Seats = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        editCourseError_Name = new javax.swing.JLabel();
        selectRoomComboBox = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Edit Course");

        courseInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"College:", null},
                {"ID:", null},
                {"Name:", null},
                {"Professor:", null},
                {"Room:", null},
                {"Times:", null},
                {"Days:", null},
                {"Seats:", null}
            },
            new String [] {
                "Course Info", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(courseInfoTable);

        submitButton.setText("Submit");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("College:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Professor:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Room:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Times:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Days:");

        professorInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        idInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        selectTimesComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectTimesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Times" }));

        selectDaysComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectDaysComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Days" }));

        selectCollegeComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectCollegeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select College" }));

        selectCourseComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Course:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Seats:");

        seatsInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        editCourseError_Course.setForeground(java.awt.Color.red);

        editCourseError_College.setForeground(java.awt.Color.red);

        editCourseError_Professor.setForeground(java.awt.Color.red);

        editCourseError_ID.setForeground(java.awt.Color.red);

        editCourseError_Room.setForeground(java.awt.Color.red);

        editCourseError_Times.setForeground(java.awt.Color.red);

        editCourseError_Days.setForeground(java.awt.Color.red);

        editCourseError_Seats.setForeground(java.awt.Color.red);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Name:");

        nameInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        editCourseError_Name.setForeground(java.awt.Color.red);

        selectRoomComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectRoomComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(seatsInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectCourseComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 176, Short.MAX_VALUE)
                            .addComponent(selectDaysComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectTimesComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 176, Short.MAX_VALUE)
                            .addComponent(idInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(nameInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(professorInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectCollegeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectRoomComboBox, 0, 176, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(editCourseError_Course, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(selectCollegeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(editCourseError_College, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Professor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(professorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Room, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(selectRoomComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Times, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTimesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Days, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectDaysComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editCourseError_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCourseErrorDisplay1;
    private javax.swing.JTable courseInfoTable;
    private javax.swing.JLabel editCourseError_College;
    private javax.swing.JLabel editCourseError_Course;
    private javax.swing.JLabel editCourseError_Days;
    private javax.swing.JLabel editCourseError_ID;
    private javax.swing.JLabel editCourseError_Name;
    private javax.swing.JLabel editCourseError_Professor;
    private javax.swing.JLabel editCourseError_Room;
    private javax.swing.JLabel editCourseError_Seats;
    private javax.swing.JLabel editCourseError_Times;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField professorInput;
    private javax.swing.JTextField seatsInput;
    private javax.swing.JComboBox<String> selectCollegeComboBox;
    private javax.swing.JComboBox<String> selectCourseComboBox;
    private javax.swing.JComboBox<String> selectDaysComboBox;
    private javax.swing.JComboBox<String> selectRoomComboBox;
    private javax.swing.JComboBox<String> selectTimesComboBox;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
