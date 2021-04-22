/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.client.daos.BasePeriodDao;
import coursescheduler.infrastructure.algorithm.PreferenceSolver;
import coursescheduler.infrastructure.database.SheetsServiceUtil;
import coursescheduler.infrastructure.database.models.CourseEvent;
import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.containers.PageControl;
import java.awt.Font;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import static coursescheduler.DatabaseSheetIDs.TEST;

/**
 *
 * @author evilc
 */
public class GenerateSchedulePage extends javax.swing.JPanel {
    PageControl control;
    String page = "GENERATE_SCHEDULE";
    PanelController controller;
    boolean validChoice = false;
    List<String> scheduleNames = new ArrayList<>();
    //List<data type for a full schedule> schedules = new ArrayList<>();
    //TODO: Implement backend "connections" and connect to InputMultipleCoursesPreview class
    int textSize = 12;

    private final PreferenceSolver scheduler = new PreferenceSolver(new BasePeriodDao(SheetsServiceUtil.getSheetsService(), TEST));

    public void setPageSettingsControl(PageControl input)
    {
        control = input;
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
    
    public GenerateSchedulePage() throws IOException, GeneralSecurityException {
        initComponents();
    }
    
    public void addScheduleName(String input)
    {
        int i = scheduleNames.size();
        String temp = "Schedule " + String.valueOf(i + 1);
        scheduleNames.add(temp);
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
    
    public void setDataAtCell(String input, int row, int column)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        model.setValueAt(input, row, column);
    }
    
    public String getDataAtCell(int row, int column)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        return (String) model.getValueAt(row, column);
    }
    
    public void setNumberOfSchdulesGenerated(int input)
    {
        numberOfSchedulesGeneratedTextField.setText(String.valueOf(input));
    }
    
    public int getNumberOfSchedulesGenerated()
    {
        return Integer.parseInt(numberOfSchedulesGeneratedTextField.getText());
    }
    
    public void addToComboBox(String input)
    {
        selectScheduleComboBox.addItem(input);
    }
    
    public String getSeletionFromComboBox()
    {
        return (String) selectScheduleComboBox.getSelectedItem();
    }
    
    public void fillComboBox()
    {
        if (!scheduleNames.isEmpty())
        {
            for (int i = 0; i < scheduleNames.size(); i++)
            {
                selectScheduleComboBox.addItem(scheduleNames.get(i));
            }
        }
    }
    
    public void clearComboBox()
    {
        for (int i = 0; i < selectScheduleComboBox.getItemCount(); i ++)
        {
            selectScheduleComboBox.remove(i);
        }
         selectScheduleComboBox.addItem("Select Schedule");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        currentCoursesTable = new javax.swing.JTable();
        generateScheduleButton = new javax.swing.JButton();
        selectScheduleComboBox = new javax.swing.JComboBox<>();
        errorBox = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        numberOfSchedulesGeneratedTextField = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Schedule Generator");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Schedule Generated:");

        currentCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(currentCoursesTable);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generateScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(errorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(numberOfSchedulesGeneratedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13)
                            .addComponent(selectScheduleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectScheduleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(numberOfSchedulesGeneratedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generateScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateScheduleButtonActionPerformed
        //Generate schedule button pressed

        int schedulerCode = scheduler.generateSchedule();
        List<CourseEvent> theSchedule = scheduler.getGeneratedSchedule();


    }//GEN-LAST:event_generateScheduleButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        //Clear button pressed
        clearComboBox();
        clearScheduleNames();
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            for (int j = 0; j < model.getColumnCount(); j++)
            {
                model.setValueAt("", i, j);
            } 
        }
    }//GEN-LAST:event_clearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTable currentCoursesTable;
    private javax.swing.JLabel errorBox;
    private javax.swing.JButton generateScheduleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numberOfSchedulesGeneratedTextField;
    private javax.swing.JComboBox<String> selectScheduleComboBox;
    // End of variables declaration//GEN-END:variables
}
