/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.client.algorithm.PreferenceSolver;
import coursescheduler.client.daos.BasePeriodDao;
import coursescheduler.client.daos.PeriodDao;
import coursescheduler.client.importer.ExcelService;
import coursescheduler.client.objects.CourseEvent;
import coursescheduler.managers.PanelController;
import coursescheduler.security.utilties.SheetsService;
import coursescheduler.views.pages.containers.PageControl;
import java.awt.Font;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import coursescheduler.views.pages.containers.dummyCourse;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import static coursescheduler.client.algorithm.SchedulerConstants.*;
import static coursescheduler.security.utilties.SheetsConstants.*;

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
    boolean tableIsEditable = true;
    List<String> scheduleNames = new ArrayList<>();  
    JFileChooser fc;
    int textSize = 12;
    List<CourseEvent> currentSchedule;

    public ArrayList<ArrayList<String>> getDataFromTable()
    {
        ArrayList<ArrayList<String>> tableData = new ArrayList<ArrayList<String>>();
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        if (model.getRowCount() > 0)
        {
            for (int i = 0; i < model.getRowCount(); i++)
            {
                ArrayList<String> temp = new ArrayList<>();
                for (int j = 0; j < (model.getColumnCount() - 1); j++)
                {
                    temp.add(String.valueOf(model.getValueAt(i, j)));
                }
                tableData.add(temp);
            }
        }
        return tableData;
    }
    
    public void markConflictByRow(int index, boolean conflict)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        if (conflict)
        {
            model.setValueAt("*", index, 5);
        }
        else
        {
            model.setValueAt("", index, 5);
        }
    }
    
    public void updateConflictDisplay(boolean conflict, int numOfConflicts)
    {
        if (conflict)
        {
            courseConflictsTitle.setText("Course conflicts: " + String.valueOf(numOfConflicts));
            String setOne = "The following courses generated conflicts: ";
            String setTwo = "";
            for (int i = 0; i < control.getAllCourses().size(); i++)
            {
                //Each iteration in the for loop adds a new line of text that, using backend data, lists a course that has a conflict.
                setTwo += "text here for a course with a conflict\n";
            }
            setOne += setTwo;
            conflictDisplay.setText(setOne);

        }
        else
        {
            courseConflictsTitle.setText("Course conflicts: none");
            conflictDisplay.setText("");
        }
    }
    
    public void setTableEditable(boolean input)
    {
        tableIsEditable = input;
        if (tableIsEditable)
        {
            currentCoursesTable.setEnabled(true);
        }
        else
        {
            currentCoursesTable.setEnabled(false);
        }
    }
  
    public void setPageSettingsControl(PageControl input)
    {
        control = input;
        //saveButton.setEnabled(false);
        setTableEditable(true);
        courseConflictsTitle.setText("Course conflicts: none");
        fc = new JFileChooser();
        setUpFC();
    }
    
    public void debugTable()
    {
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
    /*
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
    */
    
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
        Font newFont1 = new Font("Tahoma", Font.PLAIN,  textSize);
        Font newFont2 = new Font("Tahoma", Font.PLAIN,  (textSize + difference1));
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
        if (model.getRowCount() > 0)
        {
            int rowCount = model.getRowCount();
            int index = (rowCount - 1);
            while (index != -1)
            {
               model.removeRow(index);
               index--;
            }
            model.fireTableDataChanged();
        }
        
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
    
    public void addRow(CourseEvent courseEvent)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        if (model.getColumnCount() > 0)
        {
            Object[] temp = new Object[]
            {
                courseEvent.getFacultyEmail(),
                courseEvent.getCourseUUID(),
                courseEvent.getPeriod().getDaySection(),
                courseEvent.getPeriod().getTimeSection(),
                courseEvent.getRoom().getRoomId().toUpperCase()
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        generateScheduleButton = new javax.swing.JButton();
        errorBox = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        savePath_error = new javax.swing.JLabel();
        fileName_error = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selectScheduleSave_error = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentCoursesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        conflictDisplay = new javax.swing.JTextPane();
        courseConflictsTitle = new javax.swing.JTextField();
        saveRemotelyButton = new javax.swing.JButton();
        exportAsSheetButton = new javax.swing.JButton();

        fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\evilc\\Desktop"));
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Schedule Generator");

        generateScheduleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        generateScheduleButton.setText("Generate Schedule");
        generateScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateScheduleButtonActionPerformed(evt);
            }
        });

        errorBox.setForeground(java.awt.Color.red);

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        savePath_error.setForeground(java.awt.Color.red);

        fileName_error.setForeground(java.awt.Color.red);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Save Schedule as Spreadsheet");

        selectScheduleSave_error.setForeground(java.awt.Color.red);

        currentCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Section", "Days", "Times", "Room"
            }
        ));
        currentCoursesTable.setShowGrid(true);
        currentCoursesTable.setSurrendersFocusOnKeystroke(true);
        currentCoursesTable.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(currentCoursesTable);

        conflictDisplay.setEditable(false);
        conflictDisplay.setForeground(java.awt.Color.red);
        jScrollPane2.setViewportView(conflictDisplay);

        courseConflictsTitle.setEditable(false);
        courseConflictsTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseConflictsTitleActionPerformed(evt);
            }
        });

        saveRemotelyButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saveRemotelyButton.setText("Save Remotely");
        saveRemotelyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRemotelyButtonActionPerformed(evt);
            }
        });

        exportAsSheetButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        exportAsSheetButton.setText("Export as Sheet");
        exportAsSheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsSheetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveRemotelyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exportAsSheetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(courseConflictsTitle))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fileName_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(savePath_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selectScheduleSave_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(generateScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(errorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectScheduleSave_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(courseConflictsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generateScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveRemotelyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exportAsSheetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generateScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateScheduleButtonActionPerformed
        //Generate schedule button pressed
        try {
            PeriodDao periodDao = new BasePeriodDao(SheetsService.getSheetsService(), TIME_PERIODS_SPREADSHEET);
            PreferenceSolver departmentScheduler = new PreferenceSolver(periodDao);
            int schedulerCode = departmentScheduler.generateSchedule();
            System.out.print(schedulerCode);
            switch(schedulerCode){
                case SUCCESSFUL_SCHEDULE_GENERATED:
                    courseConflictsTitle.setText("Conflict Free!");
                    conflictDisplay.setText("");
                    this.currentSchedule = departmentScheduler.getGeneratedSchedule();
                    departmentScheduler.printScheduleToConsole();
                    for(CourseEvent courseEvent: currentSchedule){
                        addRow(courseEvent);
                    }
                    break;
                case NOT_ENOUGH_ROOMS:
                    courseConflictsTitle.setText(NOT_ENOUGH_ROOMS_TITLE);
                    conflictDisplay.setText(NOT_ENOUGH_ROOMS_WARNING);
                    break;
                case COURSE_NOT_AVAILABLE:
                    courseConflictsTitle.setText(COURSE_NOT_AVAILABLE_TITLE);
                    conflictDisplay.setText(COURSE_NOT_AVAILABLE_WARNING+departmentScheduler.getCurrentFacultyPreferenceRow());
                    break;
                case INVALID_ROOM_IN_PREFERENCE:
                    courseConflictsTitle.setText(INVALID_ROOM_IN_PREFERENCE_TITLE);
                    conflictDisplay.setText(INVALID_ROOM_IN_PREFERENCE_WARNING+departmentScheduler.getCurrentFacultyPreferenceRow());
                    break;
                case INVALID_PERIOD_IN_PREFERENCE:
                    courseConflictsTitle.setText(INVALID_PERIOD_IN_PREFERENCE_TITLE);
                    conflictDisplay.setText(INVALID_PERIOD_IN_PREFERENCE_WARNING+departmentScheduler.getCurrentFacultyPreferenceRow());
                    break;
                case INVALID_COURSE_IN_PREFERENCE:
                    courseConflictsTitle.setText(INVALID_COURSE_IN_PREFERENCE_TITLE);
                    conflictDisplay.setText(INVALID_COURSE_IN_PREFERENCE_WARNING+departmentScheduler.getCurrentFacultyPreferenceRow());
                    break;
            }
        } catch (IOException | GeneralSecurityException e) {
            courseConflictsTitle.setText(BAD_DATA_TITLE);
            conflictDisplay.setText(BAD_DATA_WARNING);
        }



    }//GEN-LAST:event_generateScheduleButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearTable();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fileChooserActionPerformed

    private void courseConflictsTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseConflictsTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseConflictsTitleActionPerformed

    private void saveRemotelyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRemotelyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveRemotelyButtonActionPerformed

    private void exportAsSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsSheetButtonActionPerformed
        ExcelService.getService().saveScheduleToNewSheet(this.currentSchedule);
    }//GEN-LAST:event_exportAsSheetButtonActionPerformed

    public void setUpFC()
    {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "xlxs");
        fc.addChoosableFileFilter(filter);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTextPane conflictDisplay;
    private javax.swing.JTextField courseConflictsTitle;
    private javax.swing.JTable currentCoursesTable;
    private javax.swing.JLabel errorBox;
    private javax.swing.JButton exportAsSheetButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel fileName_error;
    private javax.swing.JButton generateScheduleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JLabel savePath_error;
    private javax.swing.JButton saveRemotelyButton;
    private javax.swing.JLabel selectScheduleSave_error;
    // End of variables declaration//GEN-END:variables
}
