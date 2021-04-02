/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.managers.PopupController;
import coursescheduler.views.pages.SubPage;
import coursescheduler.views.pages.containers.PageControl;
import coursescheduler.views.pages.containers.dummyCourse;
import coursescheduler.views.pages.containers.dummyUser;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author evilc
 */
public class DepartmentChairPageSub extends javax.swing.JPanel implements SubPage<JPanel> {
    PageControl control;
    InputMultipleCoursesTable tableControl;
    String page = "DEPARTMENT_CHAIR";
    PopupController popupController;
    InputMultipleCoursesTable tableController;
    AddCourseDepartmentChairPage addCourseFull;
    AddCourseFacultyPage addCourse;
    RemoveCoursePage removeCourse;
    EditCoursePage editCourse;
    PreliminaryCoursesPage preCourse;
    

    int textSize = 12;

    @Override
    public JPanel init() {
        initComponents();
		
        return this;
    }
    
    public void initTable()
    {
        
        for (int i = 0; i < control.getAllCourses().size(); i++)
        {
            addCourse(control.getAllCourses().get(i));
            //editCourse.addComboBoxCourse(control.getAllCourses().get(i));
            //removeCourse.addComboBoxCourse(control.getAllCourses().get(i));
        }
    }
    
    public void setPageSettingsControl(PageControl input)
    {
        control = input;
        addCourse.setPageSettingsControl(control);
        removeCourse.setPageSettingsControl(control);
        editCourse.setPageSettingsControl(control);
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
        jLabel1.setFont(newFont2); //Add Course
        jLabel2.setFont(newFont3); //College:
        backButton.setFont(newFont1);
        
        addCourse.setTextSize(textSize);
        addCourse.updateTextSize();
        addCourseFull.setTextSize(textSize);
        addCourseFull.updateTextSize();
        editCourse.setTextSize(textSize);
        editCourse.updateTextSize();
        removeCourse.setTextSize(textSize);
        removeCourse.updateTextSize();
        preCourse.setTextSize(textSize);
        preCourse.updateTextSize();
    }

    
    public String returnPage()
    {
        return page;
    }
    
    public DepartmentChairPageSub() {
        addCourseFull = new AddCourseDepartmentChairPage();
        addCourse = new AddCourseFacultyPage();
        preCourse = new PreliminaryCoursesPage();
        editCourse = new EditCoursePage();
        removeCourse = new RemoveCoursePage();
        initComponents();
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            model.setValueAt("", i, 0);
        }
        
    }
    

    
    public AddCourseDepartmentChairPage getAddCourse()
    {
        return addCourseFull;
    }
    
    public RemoveCoursePage getRemoveCourse()
    {
        return removeCourse;
    }
    
    public EditCoursePage getEditCourse()
    {
        return editCourse;
    }
    
    public void updateCourse(dummyCourse input)
    {
        
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        Object[] temp = new Object[] 
        { 
            input.getCollege(),
            input.getID(), 
            input.getName(),
            input.getSection(),
            input.getProfessor(), 
            input.getRoom(),
            input.getTimes(),
            input.getDays(),
            input.getSeats()   
        };
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if (model.getValueAt(i, 2).equals(input.getName()))
            {
                model.setValueAt(temp[0], i, 0);
                model.setValueAt(temp[1], i, 1);
                model.setValueAt(temp[2], i, 2);
                model.setValueAt(temp[3], i, 3);
                model.setValueAt(temp[4], i, 4);
                model.setValueAt(temp[5], i, 5);
                model.setValueAt(temp[6], i, 6);
                model.setValueAt(temp[7], i, 7);
                model.setValueAt(temp[8], i, 8);
                break;
            }
        }
        model.fireTableDataChanged();
    }
    
    public void addCourse(dummyCourse input)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        Object[] temp = new Object[] 
        { 
            input.getCollege(),
            input.getID(), 
            input.getName(),
            input.getSection(),
            input.getProfessor(), 
            input.getRoom(),
            input.getTimes(),
            input.getDays(),
            input.getSeats()   
        };
        
        model.addRow(temp);
        removeCourse.addComboBoxCourse(input);
        editCourse.addComboBoxCourse(input);
        model.fireTableDataChanged();
    }
    
    public void removeCourse(int IDInput, String name)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if (model.getValueAt(i, 1).equals(IDInput))
            {
                model.removeRow(i);
                break;
            }
        }
        editCourse.removeComboBoxCourse(name);
        model.fireTableDataChanged();
    }
    
    public DefaultTableModel getTableModel()
    {
        return (DefaultTableModel) currentCoursesTable.getModel();
    }
    
    public void setTableModel(DefaultTableModel input)
    {
        currentCoursesTable.setModel(input);
    }
    
    public void disableButtons()
    {
//        addCourseButton.setEnabled(false);
//        editCourseButton.setEnabled(false);
//        removeCourseButton.setEnabled(false);
        backButton.setEnabled(false);
    }
    
    public void enableButtons()
    {
//        addCourseButton.setEnabled(true);
//        editCourseButton.setEnabled(true);
//        removeCourseButton.setEnabled(true);
        backButton.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentCoursesTable = new javax.swing.JTable();
        courseManagementTabbedPane = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("Back to Login");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Department Chair");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Current Courses Loaded:");

        currentCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "College", "ID", "Name", "Section", "Professor", "Room", "Times", "Days", "Seats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(currentCoursesTable);

        jButton1.setText("DEBUG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

		courseManagementTabbedPane.addTab("New Course", null, addCourseFull, "New Course");
		courseManagementTabbedPane.addTab("Add Course", null, addCourse, "Add Course");
        courseManagementTabbedPane.addTab("Edit Course", null, editCourse, "Edit Course");
        courseManagementTabbedPane.addTab("Remove Course", null, removeCourse, "Remove Course");
		courseManagementTabbedPane.addTab("Preliminary Courses", null, preCourse, "Preliminary Courses");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(courseManagementTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backButton)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseManagementTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //Back button clicked
    }//GEN-LAST:event_backButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        initTable();
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTabbedPane courseManagementTabbedPane;
    private javax.swing.JTable currentCoursesTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
