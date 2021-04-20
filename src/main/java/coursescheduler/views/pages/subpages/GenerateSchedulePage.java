/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.containers.PageControl;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import coursescheduler.views.pages.containers.dummyCourse;
import coursescheduler.views.pages.containers.dummyUser;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author evilc
 */
public class GenerateSchedulePage extends javax.swing.JPanel {
    PageControl control;
    String page = "GENERATE_SCHEDULE";
    PanelController controller;
    boolean validChoice = false;
    boolean validNameSave = false;
    boolean validFileSave = false;
    List<String> scheduleNames = new ArrayList<>();
    //List<data type for a full schedule> schedules = new ArrayList<>();
    //TODO: Implement backend "connections" and connect to InputMultipleCoursesPreview class
    int textSize = 12;
  
    public void setPageSettingsControl(PageControl input)
    {
    
        control = input;
        saveButton.setEnabled(false);
    }
    
    public void debugTable()
    {
        //DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        //addValueString("9:30 am - 11:00am", 0, 0);
        //addValueString("12:00 pm - 1:30pm", 1, 0);
        //addValueString("2:30pm - 4:00pm", 2, 0);
        for (int i = 0; i < control.getAllCourses().size(); i++)
        {

           addToSchedule(control.getAllCourses().get(i));
  
        }
    }
    
    public void addToSchedule(dummyCourse courseInput)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        String days = courseInput.getDays();
        String times = courseInput.getTimes();
        String name = courseInput.getName();
        int section = courseInput.getSection();
        String room = courseInput.getRoom();
        Object[] temp = new Object[]
        {
            name,
            section, 
            days,
            times,
            room
        };
        //System.out.println(name);
        model.addRow(temp);
        
    }
    
    //=================================================================
    //Save functions:
     public void checkNameSave()
    {
        String[] invalidCharacters = {"#", "%", "&", "{", "}", "\\" , "<", ">", "*", "?", "/", " ", "$", "!", "'", ":", "@", "+", "`", "|", "=", " \"" };
        String temp = fileName_input.getText();
        if (!temp.equals(""))
        {
            for (int j = 0; j < 22; j++)
            {
                if (temp.contains(invalidCharacters[j]))
                {
                    fileName_error.setText("*");
                    validNameSave = false;
                    break;
                }
            }
            fileName_error.setText("");
            validNameSave = true;
        }
    }
    
    public String getFileNameSave()
    {
        checkNameSave();
        if(validNameSave)
        {
            return fileName_input.getText();
        }
        else
        {
            return "INVALID_FILE_NAME_ENTERED";
        }
        
    }
    
    public String getFilePathAsStringSave()
    {
        checkFilePathSave();
        checkNameSave();
        if (validFileSave && validNameSave)
        {
            String temp1 = savePath_input.getText() + "\\";
            String temp2 = fileName_input.getText() + ".csv";
            return (temp1 + temp2);
        }
        else
        {
            return "INVALID_FILE_PATH";
        }
    }
    
    public Path getFilePathAsPathSave()
    {
        checkFilePathSave();
        checkNameSave();
        Path p1;
        if (validFileSave && validNameSave)
        {
            String temp1 = savePath_input.getText() + "\\";
            String temp2 = fileName_input.getText() + ".csv";
            String temp3 = temp1 + temp2;
            p1 = Paths.get(temp3);
        }
        else
        {
            String temp1 = "INVALID_FILE_PATH";
            p1 = Paths.get(temp1);
        }
        return p1;
    }
    
    public void checkFilePathSave()
    {
        File csvFile = new File(savePath_input.getText());
        if (csvFile.exists())
        {
            savePath_error.setText("");
            validFileSave = true;
        }
        else
        {
            savePath_error.setText("*");
            validFileSave = false;
        }
    }
    
    
    //=================================================================
    
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
        int size2 = jLabel2.getFont().getSize();
        int difference2 = size2 - textSize;
        Font newFont1 = new Font("Tahoma", Font.PLAIN,  textSize);
        Font newFont2 = new Font("Tahoma", Font.PLAIN,  (textSize + difference1));
        Font newFont3 = new Font("Tahoma", Font.PLAIN,  (textSize + difference2));
        jLabel1.setFont(newFont2); //Schedule Generator
        jLabel2.setFont(newFont3); //Schedules Generated
        jLabel3.setFont(newFont1);
        numberOfSchedulesGeneratedTextField.setFont(newFont1);
        selectScheduleComboBox.setFont(newFont1);
        clearButton.setFont(newFont1);
        generateScheduleButton.setFont(newFont1);
    }

    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    
    public GenerateSchedulePage() {
        initComponents();
    }
       
    public void clearScheduleNames()
    {
        scheduleNames.clear();
    }
    
    public DefaultTableModel getTableModel()
    {
        return (DefaultTableModel) currentCoursesTable.getModel();
    }
    
    public void setTableModel(DefaultTableModel input)
    {
        currentCoursesTable.setModel(input);
    }
    
    //=================================================================
    //Table functions:
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            for (int j = 0; j < model.getColumnCount(); j++)
            {
                model.removeRow(i);
            }
        }
        model.fireTableDataChanged();
    }
    
    public void addColumn(String input)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        model.addColumn(input);
        model.fireTableDataChanged();
    }
    
    public void removeLastColumn()
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        if (model.getColumnCount() > 0)
        {
            model.setColumnCount(model.getColumnCount() - 1);
            model.fireTableDataChanged();
        }
    }
    
    public void addRow()
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        if (model.getColumnCount() > 0)
        {
            Object[] temp = new Object[]
            {
                ""
            };
            model.addRow(temp);
            model.fireTableDataChanged();
        }
        
    }
    
    public void removeRow(int index)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        if (model.getRowCount() > 0)
        {
            model.removeRow(index);
            model.fireTableDataChanged();
        }
    }
    

    public void addValueString(String input, int row, int column)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        if (row <= model.getRowCount())
        {
            if (column <= model.getColumnCount())
            {
                model.setValueAt(input, row, column);
            }
        }
        
    }
    
    public void addValueInt(int input, int row, int column)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        if (row <= model.getRowCount())
        {
            if (column <= model.getColumnCount())
            {
                model.setValueAt(input, row, column);
            }
        }
    }
    
    //=================================================================
    
    public void setNumberOfSchdulesGenerated(int input)
    {
        numberOfSchedulesGeneratedTextField.setText(String.valueOf(input));
    }
    
    public int getNumberOfSchedulesGenerated()
    {
        return Integer.parseInt(numberOfSchedulesGeneratedTextField.getText());
    }
    
    public void addToComboBox_VIEW(String input)
    {
        selectScheduleComboBox.addItem(input);
    }
    
    public void addToComboBox_SAVE(String input)
    {
        selectScheduleSaveComboBox.addItem(input);
    }
    
    public String getSeletionFromComboBox()
    {
        return (String) selectScheduleComboBox.getSelectedItem();
    }
    
    
    public void clearComboBox_VIEW()
    {
        for (int i = 0; i < selectScheduleComboBox.getItemCount(); i ++)
        {
            selectScheduleComboBox.remove(i);
        }
         selectScheduleComboBox.addItem("Select Schedule");
    }
    
    public void clearComboBox_SAVE()
    {
        for (int i = 0; i < selectScheduleSaveComboBox.getItemCount(); i ++)
        {
            selectScheduleSaveComboBox.remove(i);
        }
         selectScheduleSaveComboBox.addItem("Select Schedule");
    }
    
    public void checkChoice()
    {
        String temp = (String) selectScheduleComboBox.getSelectedItem();
        if (temp.equals("Select Schedule"))
        {
            validChoice = false;
        }
        else
        {
            validChoice = true;
        }
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
        jLabel2 = new javax.swing.JLabel();
        generateScheduleButton = new javax.swing.JButton();
        selectScheduleComboBox = new javax.swing.JComboBox<>();
        errorBox = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        numberOfSchedulesGeneratedTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        selectScheduleSaveComboBox = new javax.swing.JComboBox<>();
        savePath_input = new javax.swing.JTextField();
        savePath_error = new javax.swing.JLabel();
        fileName_error = new javax.swing.JLabel();
        fileName_input = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selectScheduleSave_error = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentCoursesTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Schedule Generator");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Schedule Generated:");

        generateScheduleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        generateScheduleButton.setText("Generate Schedule");
        generateScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateScheduleButtonActionPerformed(evt);
            }
        });

        selectScheduleComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectScheduleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Schedule" }));

        errorBox.setForeground(java.awt.Color.red);

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Number of Schedules Generated:");

        numberOfSchedulesGeneratedTextField.setEditable(false);
        numberOfSchedulesGeneratedTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        selectScheduleSaveComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectScheduleSaveComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Schedule" }));
        selectScheduleSaveComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectScheduleSaveComboBoxActionPerformed(evt);
            }
        });

        savePath_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePath_inputActionPerformed(evt);
            }
        });

        fileName_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileName_inputActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("File Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Save Path:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Save Schedule as Spreadsheet");

        jButton1.setText("Debug");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        currentCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Section", "Days", "Times", "Room", "Conflict"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(currentCoursesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(generateScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(errorBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberOfSchedulesGeneratedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectScheduleComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(savePath_input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fileName_input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectScheduleSaveComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fileName_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(savePath_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selectScheduleSave_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectScheduleSaveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectScheduleSave_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileName_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(savePath_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generateScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectScheduleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(numberOfSchedulesGeneratedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generateScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateScheduleButtonActionPerformed
        //Generate schedule button pressed
    }//GEN-LAST:event_generateScheduleButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        //Clear button pressed
        //clearComboBox_VIEW();
        //clearComboBox_SAVE();
        clearTable();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Save button pressed
        selectScheduleSaveComboBox.setSelectedItem("Select Schedule");
    }//GEN-LAST:event_saveButtonActionPerformed

    private void selectScheduleSaveComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectScheduleSaveComboBoxActionPerformed
        if (!selectScheduleSaveComboBox.getSelectedItem().equals("Select Schedule"))
        {
            saveButton.setEnabled(true);
        }
        else
        {
            saveButton.setEnabled(false);
        }
    }//GEN-LAST:event_selectScheduleSaveComboBoxActionPerformed

    private void savePath_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePath_inputActionPerformed
        //Activates when the user inputs something for the save path
    }//GEN-LAST:event_savePath_inputActionPerformed

    private void fileName_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileName_inputActionPerformed
        //Activates when the user inputs something for the file name
    }//GEN-LAST:event_fileName_inputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //control.setDebugAllCourses();
        debugTable();
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTable currentCoursesTable;
    private javax.swing.JLabel errorBox;
    private javax.swing.JLabel fileName_error;
    private javax.swing.JTextField fileName_input;
    private javax.swing.JButton generateScheduleButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numberOfSchedulesGeneratedTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel savePath_error;
    private javax.swing.JTextField savePath_input;
    private javax.swing.JComboBox<String> selectScheduleComboBox;
    private javax.swing.JComboBox<String> selectScheduleSaveComboBox;
    private javax.swing.JLabel selectScheduleSave_error;
    // End of variables declaration//GEN-END:variables
}
