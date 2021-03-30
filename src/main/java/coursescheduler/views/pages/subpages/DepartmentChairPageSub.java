/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.managers.PanelController;
import coursescheduler.managers.PopupController;
import coursescheduler.views.pages.SubPage;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author evilc
 */
public class DepartmentChairPageSub extends javax.swing.JPanel implements SubPage<JPanel> {
    String page = "DEPARTMENT_CHAIR";
    PopupController popupController;
    InputMultipleCoursesTable tableController;
    AddCourseDepartmentChairPage addCourse;
    RemoveCoursePage removeCourse;
    EditCoursePage editCourse;

    int textSize = 12;

    @Override
    public JPanel init() {
        initComponents();
        return this;
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
        editCourse.setTextSize(textSize);
        editCourse.updateTextSize();
        removeCourse.setTextSize(textSize);
        removeCourse.updateTextSize();
    }

    
    public String returnPage()
    {
        return page;
    }
    
    public DepartmentChairPageSub() {
        initComponents();   
        popupController = new PopupController();
        tableController = new InputMultipleCoursesTable();
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "College", "ID", "Name", "Professor", "Room", "Times", "Days", "Seats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(currentCoursesTable);
		addCourse = new AddCourseDepartmentChairPage();
        removeCourse = new RemoveCoursePage();
        editCourse = new EditCoursePage();
        courseManagementTabbedPane.addTab("Add Course", null, addCourse, "Add Course");
        courseManagementTabbedPane.addTab("Edit Course", null, editCourse, "Edit Course");
        courseManagementTabbedPane.addTab("Remove Course", null, removeCourse, "Remove Course");

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
                            .addComponent(backButton)
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
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseManagementTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //Back button clicked
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTabbedPane courseManagementTabbedPane;
    private javax.swing.JTable currentCoursesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
