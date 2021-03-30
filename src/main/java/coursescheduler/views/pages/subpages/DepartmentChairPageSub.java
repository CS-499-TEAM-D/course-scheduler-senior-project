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
    AddCourseDepartmentChairPage addCourse;
    RemoveCoursePage removeCourse;
    EditCoursePage editCourse;

    int textSize = 12;

    @Override
    public JPanel init() {
        initComponents();
        return this;
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
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            model.setValueAt("", i, 0);
        }
        
    }
    

    
    public AddCourseDepartmentChairPage getAddCourse()
    {
        return addCourse;
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
            input.getProfessor(), 
            input.getRoom(),
            input.getTimes(),
            input.getDays(),
            input.getSeats()   
        };
        
        int j = 0;
        for (int i = 0; i < model.getRowCount(); i++)
        {
            j = i;
            if (model.getValueAt(i, 0).equals(""))
            {
                model.setValueAt(temp[0], i, 0);
                model.setValueAt(temp[1], i, 1);
                model.setValueAt(temp[2], i, 2);
                model.setValueAt(temp[3], i, 3);
                model.setValueAt(temp[4], i, 4);
                model.setValueAt(temp[5], i, 5);
                model.setValueAt(temp[6], i, 6);
                model.setValueAt(temp[7], i, 7);
                break;
            }
        }
        
        
        
        if ((j + 1) == model.getRowCount())
        {
            
            model.addRow(temp);
        }
        
        editCourse.addComboBoxCourse(input);
        removeCourse.addComboBoxCourse(input);
        model.fireTableDataChanged();
    }
    
    public void removeCourse(int IDInput)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        int index = -1;
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if (model.getValueAt(i, 1).equals(IDInput))
            {
                //System.out.println("TEST");
                index = i;
                /*
                model.setValueAt("", i, 0);
                model.setValueAt("", i, 1);
                model.setValueAt("", i, 2);
                model.setValueAt("", i, 3);
                model.setValueAt("", i, 4);
                model.setValueAt("", i, 5);
                model.setValueAt("", i, 6);
                model.setValueAt("", i, 7);
                */
                model.removeRow(i);
                break;
            }
        }
        
        if ((index + 1) != model.getRowCount())
        {
            String one = "";
            String two = "";
            String three = "";
            String four = "";
            String five = "";
            String six = "";
            String seven = "";
            Object[] temp = new Object[] 
            {
                one,
                two,
                three,
                four,
                five,
                six,
                seven
            };
   
           model.addRow(temp);
        }
        
        //Move the rest of the rows that fall under the removed row up by 1
        if (index != -1)
        {
            model.moveRow((index + 1), (model.getRowCount() - 1), 1);
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
