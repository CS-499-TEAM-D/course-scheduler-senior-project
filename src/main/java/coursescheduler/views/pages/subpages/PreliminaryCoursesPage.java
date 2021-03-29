package coursescheduler.views.pages.subpages;
import coursescheduler.managers.PanelController;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author evilc
 */
public class PreliminaryCoursesPage extends javax.swing.JPanel {
    String page = "PRELIMINARY_COURSES";
    PanelController controller;
    inputSingleCourseDataTable editor;
    int textSize = 12; //Doesn't impact the text in tables; may change this in the future
    //TODO: will need access to the course object and its backend
    //TODO: add in control for resizing the window, like if it can be resized or not
    
    public JComboBox addToComboBox(JComboBox inputCombo, String inputString)
    {
        JComboBox temp = new JComboBox();
        temp = inputCombo;
        temp.addItem(inputString);
        return temp;
    }
    
    public JComboBox removeFromComboBox(JComboBox inputCombo, String inputString)
    {
        JComboBox temp = new JComboBox();
        temp = inputCombo;
        temp.removeItem(inputString);
        return temp;
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
        backButton.setFont(newFont1);
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
    
    
    public boolean checkIfPrelimTableIsFull()
    {
        int numFull = 0;
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if (!model.getValueAt(i, 1).equals(""))
            {
                numFull++;
            }
        }
        
        if (numFull == model.getRowCount())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void addPrelminCourseToTable(int ID, String name)
    {
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        if (checkIfPrelimTableIsFull())
        {
            Object[] temp = new Object[] 
            { 
                ID, 
                name, 
            }; 
            model.addRow(temp);
        }
        else
        {
            int index = returnNextEmptyIndex();
            model.setValueAt(ID, index, 0);
            model.setValueAt(name, index, 1);
        }
    }
   
    public void removePrelminCourseToTable(int ID)
    {
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        int index = returnIndexOfID(ID);
        if (index != -1)
        {
            if (model.getRowCount() > 5)
            {
                model.removeRow(index);
            }
            else
            {
                model.setValueAt("", index, 0);
            }
        }
        
    }
    
    public int returnNextEmptyIndex()
    {
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        int index = -1;
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if (model.getValueAt(i, 0).equals(""))
            {
                return index;
            }
        }
        return index;
    }
    
    public int returnIndexOfID(int ID)
    {
        int index = -1;
        DefaultTableModel model = (DefaultTableModel) prelimCoursesTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            if ((int)model.getValueAt(i, 0) == ID)
            {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public boolean checkSelection(JComboBox input)
    {
        String course = (String) input.getSelectedItem();
        if (!(course.equals("") && !(course.equals("Select Course"))))
        {
            return true;
        }
        else
        {
            return false;
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

        selectCourseComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
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

        selectCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        selectCourseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCourseComboBoxActionPerformed(evt);
            }
        });

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

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Add/Remove Preliminary Courses");

        prelimCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectCourseRemoveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(selectCourseAddComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(removeButton)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                            .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCourseAddComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCourseRemoveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addGap(4, 4, 4))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectCourseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseComboBoxActionPerformed
        // Combo box (when the user selects something from the combo box)
        //TODO: Change everything (where applicable) to the course the user selects
    }//GEN-LAST:event_selectCourseComboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // Back button
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void selectCourseAddComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseAddComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectCourseAddComboBoxActionPerformed

    private void selectCourseRemoveComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseRemoveComboBoxActionPerformed
        
    }//GEN-LAST:event_selectCourseRemoveComboBoxActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (checkSelection(selectCourseAddComboBox))
        {
            //Add prelminary course to both the course object and the preliminary courses table
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (checkSelection(selectCourseRemoveComboBox))
        {
            //Remove prelminary course for both the course object and the preliminary courses table
        }
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
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
    private javax.swing.JComboBox<String> selectCourseAddComboBox;
    private javax.swing.JComboBox<String> selectCourseComboBox;
    private javax.swing.JComboBox<String> selectCourseRemoveComboBox;
    // End of variables declaration//GEN-END:variables
}
