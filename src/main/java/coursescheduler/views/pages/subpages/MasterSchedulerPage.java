/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.views.pages.SubPage;
import coursescheduler.views.pages.containers.PageControl;
import coursescheduler.views.pages.containers.dummyCourse;
import coursescheduler.views.pages.containers.dummyUser;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author evilc
 */
public class MasterSchedulerPage extends javax.swing.JPanel implements SubPage<JPanel> {
    PageControl control;
    String page = "MASTER";
    int textSize = 12;
    boolean tableIsEditable = true;

    @Override
    public JPanel init() {
        initComponents();
        return this;
    }
    
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
    
    
    public boolean getUpdateSelection_byRow(int row)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        String temp = String.valueOf(model.getValueAt(row, 5));
        if (temp.equals("true"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean getUpdateSelection_byCourse(String course)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        int index = -1;
        if (model.getRowCount() > 0)
        {
            for (int i = 0; i < model.getRowCount(); i++)
            {
                String tempName = (String) model.getValueAt(i, 0);
                if (tempName.equals(course))
                {
                    index = i;
                    break;
                }
            }
        }
        
        if (index != -1)
        {
            String temp = String.valueOf(model.getValueAt(index, 5));
            if (temp.equals("true"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        return false;
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
    
    public void initTable() //DUMMY
    {
        
        for (int i = 0; i < control.getAllCourses().size(); i++)
        {
            addCourse_DUMMY(control.getAllCourses().get(i));
        }
    }
    
    public void setPageSettingsControl(PageControl input) //REQUIRED
    {
        control = input;
    }

    public void setTextSize(int input) //SETTINGS ONLY
    {
        textSize = input;
    }
    
    public int getTextSize() //SETTINGS ONLY
    {
        return textSize;
    }

    public void updateTextSize() //SETTINGS ONLY
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
    
    public MasterSchedulerPage() 
    {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            model.setValueAt("", i, 0);
        }
        setTableEditable(true);
        
    }
    
    /*
    //FOR CHRIS:
    public void addCourse(Course input)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        Object[] temp = new Object[] 
        { 
            input.getID(), 
            input.getSection(),
            input.getProfessor(), 
            input.getRoom(),
            input.getTimes(), 
            input.getOnlyOne() //True or false boolean
        };
        
        model.addRow(temp);
        model.fireTableDataChanged();
    }
    */
    
    /*
    //FOR CHRIS:
    public void removeCourse(int ID)
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if (model.getValueAt(i, 1).equals(ID))
            {
                model.removeRow(i);
                break;
            }
        }  
        model.fireTableDataChanged();
    }
    */
    
    
    public void addCourse_DUMMY(dummyCourse input) //DUMMY
    {
        DefaultTableModel model = (DefaultTableModel) currentCoursesTable.getModel();
        Object[] temp = new Object[] 
        { 
            input.getID(), 
            input.getSection(),
            input.getProfessor(), 
            input.getRoom(),
            input.getTimes(),
            true
        };
        
        model.addRow(temp);
        model.fireTableDataChanged();
    }
    
    
    public void removeCourse_DUMMY(int IDInput) //DUMMY
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
    
    public DefaultTableModel getTableModel() //UNUSED
    {
        return (DefaultTableModel) currentCoursesTable.getModel();
    }
    
    public void setTableModel(DefaultTableModel input) //UNUSED
    {
        currentCoursesTable.setModel(input);
    }
    
    public void disableButtons() //UNUSED
    {
        backButton.setEnabled(false);
    }
    
    public void enableButtons() //UNUSED
    {
        backButton.setEnabled(true);
    }
    
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
        clearTable = new javax.swing.JButton();

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
                "Course", "Section", "Professor", "Preferred Room", "Preferred Times", "Update Selection"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(currentCoursesTable);

        jButton1.setText("DEBUG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        clearTable.setText("Clear");
        clearTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableActionPerformed(evt);
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
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(backButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearTable))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(jButton1)
                    .addComponent(clearTable))
                .addGap(14, 14, 14))
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

    private void clearTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableActionPerformed
        clearTable();
    }//GEN-LAST:event_clearTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearTable;
    private javax.swing.JTable currentCoursesTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
