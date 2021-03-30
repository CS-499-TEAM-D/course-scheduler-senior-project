package coursescheduler.views.pages.subpages;
import coursescheduler.managers.PanelController;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import coursescheduler.managers.PopupController;

/**
 *
 * @author evilc
 */
public class RemoveCoursePage extends javax.swing.JPanel {
    String page = "REMOVE_COURSE";
    PanelController controller;
    PopupController popupController;
    inputSingleCourseDataTable editor;
    boolean validSelection = false;
    int textSize = 12;
    
    public void setPopupController(PopupController input)
    {
        popupController = input;
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
        jLabel1.setFont(newFont2); //Remove Course
        selectCourseComboBox.setFont(newFont1);
        removeButton.setFont(newFont1);
    }
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) courseInfoTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            model.setValueAt("", i, 0);
            model.setValueAt("", i, 1);
        }
    }

    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    public RemoveCoursePage() {
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
    
    void checkSelection()
    {
        String course = (String) selectCourseComboBox.getSelectedItem();
        if (!(course.equals("") && !(course.equals("Select Course"))))
        {
            validSelection = true;
        }
        else
        {
            validSelection = false;
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
        courseInfoTable = new javax.swing.JTable();
        removeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        selectCourseError = new javax.swing.JLabel();

        selectCourseComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                {"Room:", null},
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

        removeButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Remove Course");

        selectCourseError.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectCourseError, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectCourseError, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeButton)
                .addGap(4, 4, 4))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectCourseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseComboBoxActionPerformed
        // Combo box (when the user selects something from the combo box)
        
    }//GEN-LAST:event_selectCourseComboBoxActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // Remove button
        
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable courseInfoTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JComboBox<String> selectCourseComboBox;
    private javax.swing.JLabel selectCourseError;
    // End of variables declaration//GEN-END:variables
}
