/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.infrastructure.database.models.CourseEvent;
import coursescheduler.views.pages.ISubPage;
import coursescheduler.views.pages.containers.PageControl;
import coursescheduler.views.pages.containers.dummyCourse;

import java.awt.Font;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author evilc
 */
public class MasterSchedulerPage extends javax.swing.JPanel implements ISubPage<JPanel> {
    PageControl control;
    String page = "MASTER";
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
        
    }

    
    public String returnPage()
    {
        return page;
    }
    
    public MasterSchedulerPage() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            model.setValueAt("", i, 0);
        }
        
    }
    
    
    public void addCourse(dummyCourse input)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        Object[] temp = new Object[] 
        { 
            input.getID(), 
            input.getSection(),
            input.getProfessor(), 
            input.getRoom(),
            input.getTimes(), 
        };
        
        model.addRow(temp);
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
        jButton1 = new javax.swing.JButton();

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("Back to Login");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Master");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Current Courses Loaded:");

        currentCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Section", "Professor", "Room", "Times", "Only One"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(jButton1))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add back button functionality, possibly inject controller and use controller.update(LoginPage)

    }//GEN-LAST:event_backButtonActionPerformed

    // DEBUG BUTTON
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        // debug print test code for the excel utility
        Vector<CourseEvent> fpv = control.eiu.getFacultyPreferenceDataTable();
        for (CourseEvent ce : fpv){
            System.out.println(ce.professorEmail + ce.coursePreferenceId + ce.roomId + ce.periodId);
        }

        //initTable();
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable currentCoursesTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
