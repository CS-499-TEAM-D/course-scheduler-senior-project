/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler;
import coursescheduler.managers.PanelController;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author evilc
 */
public class AddCourseDepartmentChair extends javax.swing.JPanel {
    String page = "ADD_COURSE_DEPARTMENT_CHAIR";
    PanelController controller;
    inputSingleCourseDataTable editor;
    addCourse_checkInputs check;
    boolean validCollege = false;
    boolean validID = false;
    boolean validName = false;
    boolean validProfessor = false;
    boolean validRoom = false;
    boolean validTimes = false;
    boolean validDays = false;
    boolean validSeats = false;
    boolean allInputsValid = false;
    

    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    
    public AddCourseDepartmentChair() 
    {
        initComponents();
        editor = new inputSingleCourseDataTable();
        check = new addCourse_checkInputs();
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
        addCourseProfessorInput = new javax.swing.JTextField();
        addCourseIDInput = new javax.swing.JTextField();
        addCourseTimesCombo = new javax.swing.JComboBox<>();
        addCourseDaysCombo = new javax.swing.JComboBox<>();
        addCourseRoomsCombo = new javax.swing.JComboBox<>();
        addCourseErrorDisplay1 = new javax.swing.JLabel();
        addCourseError_College = new javax.swing.JLabel();
        addCourseError_Professor = new javax.swing.JLabel();
        addCourseError_ID = new javax.swing.JLabel();
        addCourseError_Name = new javax.swing.JLabel();
        addCourseError_Days = new javax.swing.JLabel();
        addCourseError_Room = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addCourseSeatsInput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        addCourseNameInput = new javax.swing.JTextField();
        addCourseError_Seats = new javax.swing.JLabel();
        addCourseError_Times = new javax.swing.JLabel();
        addCourseCollegeCombo = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Add Course");

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table1);

        addCourseSubmitButton.setText("Submit");
        addCourseSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseSubmitButtonActionPerformed(evt);
            }
        });

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

        addCourseProfessorInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseProfessorInputActionPerformed(evt);
            }
        });

        addCourseIDInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseIDInputActionPerformed(evt);
            }
        });

        addCourseTimesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Times" }));
        addCourseTimesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseTimesComboActionPerformed(evt);
            }
        });

        addCourseDaysCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Days" }));
        addCourseDaysCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseDaysComboActionPerformed(evt);
            }
        });

        addCourseRoomsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));
        addCourseRoomsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseRoomsComboActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Seats:");

        addCourseSeatsInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseSeatsInputActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Name:");

        addCourseNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseNameInputActionPerformed(evt);
            }
        });

        addCourseCollegeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select College" }));
        addCourseCollegeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseCollegeComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addCourseCancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCourseSubmitButton)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addCourseNameInput)
                                            .addComponent(addCourseProfessorInput)
                                            .addComponent(addCourseIDInput)
                                            .addComponent(addCourseTimesCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addCourseDaysCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addCourseRoomsCombo, 0, 178, Short.MAX_VALUE)
                                            .addComponent(addCourseErrorDisplay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addCourseSeatsInput)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(addCourseCollegeCombo, 0, 176, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addCourseError_College, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addCourseError_Professor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addCourseError_ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addCourseError_Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addCourseError_Room, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addCourseError_Days, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseError_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseError_Times, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(addCourseErrorDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addCourseError_College, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCourseCollegeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addCourseError_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCourseIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addCourseError_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCourseNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addCourseError_Professor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCourseProfessorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addCourseRoomsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCourseError_Room, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addCourseSubmitButton)
                            .addComponent(addCourseCancelButton))
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(addCourseError_Times, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseTimesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(addCourseError_Days, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseDaysCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(addCourseError_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseSeatsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addCourseSeatsInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseSeatsInputActionPerformed
        // Seats text input
    }//GEN-LAST:event_addCourseSeatsInputActionPerformed

    
    private void addCourseRoomsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseRoomsComboActionPerformed
        // Combo box for selecting the room
    }//GEN-LAST:event_addCourseRoomsComboActionPerformed

    
    private void addCourseSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseSubmitButtonActionPerformed
        // Submit button
        
    }//GEN-LAST:event_addCourseSubmitButtonActionPerformed

    private void addCourseCollegeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseCollegeComboActionPerformed
        // College combo box selection
        
    }//GEN-LAST:event_addCourseCollegeComboActionPerformed

    
    private void addCourseIDInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseIDInputActionPerformed
        //ID text input
 
    }//GEN-LAST:event_addCourseIDInputActionPerformed

    private void addCourseNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseNameInputActionPerformed
        //Name text input
    }//GEN-LAST:event_addCourseNameInputActionPerformed

    private void addCourseProfessorInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseProfessorInputActionPerformed
        //Professor text input
    }//GEN-LAST:event_addCourseProfessorInputActionPerformed

    private void addCourseTimesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseTimesComboActionPerformed
        //Combo box for selecting the time
    }//GEN-LAST:event_addCourseTimesComboActionPerformed

    private void addCourseDaysComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseDaysComboActionPerformed
        //Combo box for selecting the room
    }//GEN-LAST:event_addCourseDaysComboActionPerformed
    
    public void checkSeats()
    {
        String Seats_string = addCourseSeatsInput.getText();
        int Seats;
        if (!Seats_string.equals(""))
        {
            try
            {
                Seats = Integer.parseInt(Seats_string.trim());
                addCourseError_Seats.setText("");
                if(Seats > -1)
                {
                    validID = true;
                }
                else
                {
                    addCourseError_Seats.setText("*");
                    validID = false;
                }
            }
            catch (NumberFormatException nfe)
            {
                addCourseError_Seats.setText("*");
                validID = false;
            }
        }
        else
        {
            addCourseError_Seats.setText("*");
            validID = false;
        }
    }
    
    public void checkRoom()
    {
        String Room = (String) addCourseRoomsCombo.getSelectedItem();
        if (!(Room.equals("")) && !(Room.equals("Select Room")))
        {
            validRoom = true;
            addCourseError_Room.setText("");
        }
        else
        {
            addCourseError_Room.setText("*");
            validRoom = false;
        }
    }
    
    public void checkTimes()
    {
        String Times = (String) addCourseTimesCombo.getSelectedItem();
        if (!(Times.equals("")) && !(Times.equals("Select Time")))
        {
            validTimes = true;
            addCourseError_Times.setText("");
        }
        else
        {
            addCourseError_Times.setText("*");
            validTimes = false;
        }
    }
    
    public void checkDays()
    {
        String Days = (String) addCourseDaysCombo.getSelectedItem();
        if (!(Days.equals("")) && !(Days.equals("Select Days")))
        {
            validDays = true;
            addCourseError_Days.setText("");
        }
        else
        {
            addCourseError_Days.setText("*");
            validDays = false;
        }
    }
    
    public void checkCollege()
    {
        String College = (String) addCourseCollegeCombo.getSelectedItem();
        if (!(College.equals("") && !(College.equals("Select College"))))
        {
            addCourseError_College.setText("");
            validCollege = true;
        }
        else
        {
            validCollege = false;
            addCourseError_College.setText("*");
        }
    }
    
    public void checkName()
    {
        String Name = addCourseNameInput.getText();
        if (!(Name.equals("")))
        {
            validName = true;
            addCourseError_Name.setText("");
        }
        else
        {
            validName = false;
            addCourseError_Name.setText("*");
        }
    }
    
    public void checkID()
    {
        String ID_string = addCourseIDInput.getText();
        int ID;
        if (!ID_string.equals(""))
        {
             try
            {
                ID = Integer.parseInt(ID_string.trim());
                addCourseError_ID.setText("");
                validID = true;
            }
            catch (NumberFormatException nfe)
            {
                addCourseError_ID.setText("*");
                validID = false;
            }  
        }
        else
        {
            addCourseError_ID.setText("*");
            validID = false;
        }
    }
    
    public void checkProfessor()
    {
        String Professor = addCourseProfessorInput.getText();
        if (!(Professor.equals("")))
        {
            validProfessor = true;
            addCourseError_Professor.setText("");
        }
        else
        {
            validProfessor = false;
            addCourseError_Professor.setText("*");
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
             String Seats_string = addCourseSeatsInput.getText();
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
             String ID_string = addCourseSeatsInput.getText();
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
            college = (String) addCourseCollegeCombo.getSelectedItem();
        }
        return college;
    }
    
    public String getRoom()
    {
        String room = "INCORRECT_VALUE_SELECTED";
        checkRoom();
        if (validRoom)
        {
            room = (String) addCourseRoomsCombo.getSelectedItem();
        }
        return room;
    }
    
    public String getTimes()
    {
        String times = "INCORRECT_VALUE_SELECTED";
        checkTimes();
        if (validTimes)
        {
            times = (String) addCourseTimesCombo.getSelectedItem();
        }
        return times;
    }
    
    public String getDays()
    {
        String days= "INCORRECT_VALUE_SELECTED";
        checkDays();
        if (validDays)
        {
            days = (String) addCourseDaysCombo.getSelectedItem();
        }
        return days;
    }
    
    public String getProfessor()
    {
       String professor = "INCORRECT_INPUT";
       checkProfessor();
       if(validProfessor)
       {
           professor = addCourseProfessorInput.getText();
       }
       return professor;
    }
    
    public String getName()
    {
       String name = "INCORRECT_INPUT";
       checkName();
       if(validName)
       {
           name = addCourseNameInput.getText();
       }
       return name;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton addCourseCancelButton;
    private javax.swing.JComboBox<String> addCourseCollegeCombo;
    private javax.swing.JComboBox<String> addCourseDaysCombo;
    private javax.swing.JLabel addCourseErrorDisplay1;
    private javax.swing.JLabel addCourseError_College;
    private javax.swing.JLabel addCourseError_Days;
    private javax.swing.JLabel addCourseError_ID;
    private javax.swing.JLabel addCourseError_Name;
    private javax.swing.JLabel addCourseError_Professor;
    private javax.swing.JLabel addCourseError_Room;
    private javax.swing.JLabel addCourseError_Seats;
    private javax.swing.JLabel addCourseError_Times;
    private javax.swing.JTextField addCourseIDInput;
    private javax.swing.JTextField addCourseNameInput;
    private javax.swing.JTextField addCourseProfessorInput;
    private javax.swing.JComboBox<String> addCourseRoomsCombo;
    private javax.swing.JTextField addCourseSeatsInput;
    private javax.swing.JButton addCourseSubmitButton;
    private javax.swing.JComboBox<String> addCourseTimesCombo;
    private javax.swing.JLabel jLabel1;
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
