package coursescheduler.views.pages.subpages;
import coursescheduler.managers.PanelController;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import coursescheduler.managers.PopupController;
import coursescheduler.views.pages.containers.PageControl;
import coursescheduler.views.pages.containers.dummyCourse;
import coursescheduler.views.pages.containers.dummyUser;

/**
 *
 * @author evilc
 */
public class PreliminaryCoursesPage extends javax.swing.JPanel {
    PageControl control;
    String page = "PRELIMINARY_COURSES";
    PanelController controller;
    inputSingleCourseDataTable editor;
    PopupController popupController;
    int textSize = 12; //Doesn't impact the text in tables; may change this in the future
    //TODO: will need access to the course object and its backend
    //TODO: add in control for resizing the window, like if it can be resized or not
    
    public void setPageSettingsControl(PageControl input)
    {
        control = input;
    }
    
    
    public void setPopupController(PopupController input)
    {
        popupController = input;
    }
    
    
    public void addToComboBox_AddPreReq(String input)
    {
        selectCourseAddComboBox.addItem(input); 
    }
    
    public void addToComboBox_RemovePreReq(String input)
    {
        selectCourseRemoveComboBox.addItem(input); 
    }
    
    public void removeFromComboBox_AddPreReq(String input)
    {
        selectCourseAddComboBox.removeItem(input); 
    }
    
    public void removeFromComboBox_RemovePreReq(String input)
    {
        selectCourseRemoveComboBox.removeItem(input); 
    }
    
    
    public void addToComboBox_Course(String input)
    {
        selectCourseComboBox.addItem(input); 
    }
    
    public void removeFromComboBox_Course(String input)
    {
        selectCourseComboBox.removeItem(input); 
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
        jLabel1.setFont(newFont2); //Add/Remove Preliminary Courses
        jLabel2.setFont(newFont1); //Preliminary Courses
        jLabel3.setFont(newFont1); //Add Course
        jLabel4.setFont(newFont1); //Remove Course
        selectCourseComboBox.setFont(newFont1);
        selectCourseAddComboBox.setFont(newFont1);
        selectCourseRemoveComboBox.setFont(newFont1);
        addButton.setFont(newFont1);
        removeButton.setFont(newFont1);
    }
    
    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    
    public PreliminaryCoursesPage() {
        initComponents();
        editor = new inputSingleCourseDataTable();
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
    
    
  
    
    public void addPrelminCourseToTable(String preName)
    {
        //System.out.println(preName);
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        dummyCourse tempCourse = control.returnDummyCourseByNameAll(preName);
        
        
        
        int j = 0;
        Object[] temp = new Object[]
        {
            tempCourse.getID(),
            tempCourse.getName()
        };
        model.addRow(temp);

    }
    
    
    public void fillPreTable(String courseName)
    {
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        dummyCourse tempCourse = control.returnDummyCourseByNameAll(courseName);  
        clearPreTable();
        if (!tempCourse.returnPreReqs().isEmpty())
        {
            for (int i = 0; i < tempCourse.returnPreReqs().size(); i ++)
            {
                Object[] temp = new Object[]
                {
                    tempCourse.returnPreReqs().get(i).getID(),
                    tempCourse.returnPreReqs().get(i).getName()
                };
                model.addRow(temp);
                
            }
            model.fireTableDataChanged();
        }
        
        
    }
   
    public void removePrelminCourseFromTable(String name)
    {
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if (model.getValueAt(i, 1).equals(name))
            {
                model.removeRow(i);
                break;
            }
        }
        
        model.fireTableDataChanged();
    }
    
    public void clearPreTable()
    {
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        int j = 0;
        
        if (model.getRowCount() > 0)
        {
            if (!model.getValueAt(0, 0).equals(""))
            {
                model.removeRow(0);
            }
        }
        
        
        if (model.getRowCount() > 0)
        {
            for (int i = 0; i < model.getRowCount(); i++)
            {
                model.removeRow(i);
            }

            model.fireTableDataChanged();
        }
        
    }
    
  
    
    public boolean checkSelectionAdd()
    {
        String name1 = (String) selectCourseComboBox.getSelectedItem();
        String name2 = (String) selectCourseAddComboBox.getSelectedItem();
        if (!name1.equals("Select Course") && !name2.equals("Select Course"))
        {
            dummyCourse temp = getCourse();
            if (!temp.returnPreReqs().isEmpty())
            {
                for (int i = 0; i < temp.returnPreReqs().size(); i++)
                {
                    if (temp.returnPreReqs().get(i).getName().equals(name1) || temp.returnPreReqs().get(i).getName().equals(name2))
                    {
                        return false;
                    }
                }
                return true;
            }
            else if (temp.returnPreReqs().isEmpty())
            {
                if (!name1.equals(name2))
                {
                    return true;
                }
            }
        }  
        return false;
    }
    
    public dummyCourse getCourse()
    {
        dummyCourse temp = null;
        String tempName = (String) selectCourseComboBox.getSelectedItem();
        if (!tempName.equals("Select Course"))
        {
            temp = new dummyCourse();
            temp = control.returnDummyCourseByNameLoaded(tempName);
        }
        return temp;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectCourseComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseInfoTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prelimCoursesTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        selectCourseAddComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        selectCourseRemoveComboBox = new javax.swing.JComboBox<>();
        removeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        errorDisplay = new javax.swing.JLabel();
        addCourse_error = new javax.swing.JLabel();
        removeCourse_error = new javax.swing.JLabel();

        selectCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        selectCourseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCourseComboBoxActionPerformed(evt);
            }
        });

        courseInfoTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(courseInfoTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Add/Remove Preliminary Courses");

        prelimCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(prelimCoursesTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Preliminary Courses:");

        selectCourseAddComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        selectCourseAddComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCourseAddComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Add Course:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        selectCourseRemoveComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        selectCourseRemoveComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCourseRemoveComboBoxActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Remove Course:");

        error1.setForeground(java.awt.Color.red);

        errorDisplay.setForeground(java.awt.Color.red);

        addCourse_error.setForeground(java.awt.Color.red);

        removeCourse_error.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(errorDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(selectCourseAddComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                                .addComponent(addCourse_error, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectCourseRemoveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeCourse_error, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectCourseRemoveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeCourse_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addCourse_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectCourseAddComboBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectCourseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseComboBoxActionPerformed
        // Combo box (when the user selects something from the combo box)
        
        clearPreTable();
        clearRemoveBox();
        dummyCourse temp1 = null;
        String name = (String) selectCourseComboBox.getSelectedItem();
        if (!name.equals("Select Course"))
        {
            control.printPreReqs(name);
            temp1 = control.returnDummyCourseByNameAll(name);
            setCollege(temp1.getCollege());
            setRoom(temp1.getRoom());
            setTimes(temp1.getTimes());
            setDays(temp1.getDays());
            setProfessor(temp1.getProfessor());
            setName(temp1.getName());
            setID(temp1.getID());
            setSeats(temp1.getSeats());
            DefaultTableModel model = (DefaultTableModel) courseInfoTable.getModel();   
            if (!temp1.returnPreReqs().isEmpty())
            {
                fillPreTable(temp1.getName());
                for (int i = 0; i < temp1.returnPreReqs().size(); i++)
                {
                    addToComboBox_RemovePreReq(temp1.returnPreReqs().get(i).getName());
                }
            }
            model.fireTableStructureChanged();
        }
    }//GEN-LAST:event_selectCourseComboBoxActionPerformed

    private void selectCourseAddComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseAddComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectCourseAddComboBoxActionPerformed

    private void selectCourseRemoveComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseRemoveComboBoxActionPerformed
        
    }//GEN-LAST:event_selectCourseRemoveComboBoxActionPerformed

    public void clearRemoveBox()
    {
        if (selectCourseRemoveComboBox.getItemCount() > 1)
        {
            for (int i = 1; i < selectCourseRemoveComboBox.getItemCount(); i++)
            {
            selectCourseRemoveComboBox.removeItemAt(i);
            }
        }
        
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name1 = (String) selectCourseComboBox.getSelectedItem();
        String name2 = (String) selectCourseAddComboBox.getSelectedItem();
        if (!name1.equals("Select Course") && !name2.equals("Select Course")) 
        {
            if (checkSelectionAdd())
            {
                addCourse_error.setText("");
                control.addPreReq(name1, name2);
                selectCourseRemoveComboBox.setSelectedItem("Select Course");
                selectCourseAddComboBox.setSelectedItem("Select Course");
                addToComboBox_RemovePreReq(name2);
                addPrelminCourseToTable(name2);
            }
            
        }
        else
        {
            addCourse_error.setText("*");
        }
            
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        String name1 = (String) selectCourseComboBox.getSelectedItem();
        String name2 = (String) selectCourseRemoveComboBox.getSelectedItem();
        if (!name1.equals("Select Course") && !name2.equals("Select Course"))
        {
            removePrelminCourseFromTable(name2);
            removeCourse_error.setText("");
            control.removePreReq(name1, name2);
            selectCourseRemoveComboBox.removeItem(name2);
            selectCourseRemoveComboBox.setSelectedItem("Select Course");
            selectCourseAddComboBox.setSelectedItem("Select Course");
            removeFromComboBox_RemovePreReq(name2);
        }
        else
        {
            removeCourse_error.setText("*");
        }
        
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addCourse_error;
    private javax.swing.JTable courseInfoTable;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel errorDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable prelimCoursesTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel removeCourse_error;
    private javax.swing.JComboBox<String> selectCourseAddComboBox;
    private javax.swing.JComboBox<String> selectCourseComboBox;
    private javax.swing.JComboBox<String> selectCourseRemoveComboBox;
    // End of variables declaration//GEN-END:variables
}
