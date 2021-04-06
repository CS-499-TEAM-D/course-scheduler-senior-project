/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.managers.PanelController;
import coursescheduler.views.pages.containers.PageControl;
import java.awt.Font;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import coursescheduler.views.pages.containers.dummyCourse;
import coursescheduler.views.pages.containers.dummyUser;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author evilc
 */
public class SaveLoadFilePage extends javax.swing.JPanel {
    PageControl control;
    String page = "SAVE_LOAD_FILE";
    PanelController controller;
    boolean validNameSave = false;
    boolean validChoice = false;
    boolean validFileSave = false;
    boolean validFileLoad = false;
    
    String userType;
    
    String saveType;
    String loadType;
    String viewType;
    
    String fileNameSave;
    String filePathSave;
    String filePathLoad;
    int textSize = 12;
    
    public String getUserType()
    {
        return userType;
    }
    
    public void setUserType(String input) //MASTER, STANDARD
    {
        userType = input;
        if (userType.equals("MASTER"))
        {
            loadTypeComboBox.addItem("All Course Periods");
        }
    }
    
    public String getSaveType()
    {
        return saveType;
    }
    
    public String getLoadType()
    {
        return loadType;
    }
    
    public void setSaveType(String input) //FACULTY_PREFERENCE, COURSE_LISTING, ROOM_LISTNING, COURSE_PERIODS
    {
        saveType = input;
    }
    
    public void setLoadType(String input) //FACULTY_PREFERENCE, COURSE_LISTING, ROOM_LISTNING, COURSE_PERIODS
    {
        loadType = input;
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
        Font newFont1 = new Font("Tahoma", Font.PLAIN,  textSize);
        Font newFont2 = new Font("Tahoma", Font.PLAIN,  (textSize + difference1));
        jLabel1.setFont(newFont2); //Load CSV File
        jLabel4.setFont(newFont1); //Enter the full path to the file you wish to open (a .CSV file):
        loadButton.setFont(newFont1);
    }

    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    
    public SaveLoadFilePage() {
        initComponents();

        loadButton.setEnabled(false);
    }
    
    //=================================================================
    //Load functions:
    public String getFilePathAsStringLoad()
    {
        checkFilePathLoad();
        if (validFileLoad)
        {
            return loadPath_input.getText();
        }
        else
        {
            return "INVALID_FILE_PATH";
        }
        
    }
    
    public Path getFilePathAsPathLoad()
    {
        checkFilePathLoad();
        Path p1;
        if (validFileLoad)
        {
            String temp1 = loadPath_input.getText();
            p1 = Paths.get(temp1);
        }
        else
        {
            String temp1 = "INVALID_FILE_PATH";
            p1 = Paths.get(temp1);
        }
        return p1;
    }
    
    public void checkFilePathLoad()
    {
        File csvFile = new File(loadPath_input.getText());
        if (csvFile.exists())
        {
            loadSchedule_error.setText("");
            validFileLoad = true;
        }
        else
        {
            loadSchedule_error.setText("*");
            validFileLoad = false;
        }
    }

    //=================================================================
    //Table functions:
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) filePreviewTable.getModel();
        if (model.getRowCount() > 0)
        {
            model.setRowCount(0);
        }

        if (model.getColumnCount() > 0)
        {
            model.setColumnCount(0);          
        }
        model.fireTableDataChanged();
    }
    
    public void addColumn(String input)
    {
        DefaultTableModel model = (DefaultTableModel) filePreviewTable.getModel();
        model.addColumn(input);
        model.fireTableDataChanged();
    }
    
    public void removeLastColumn()
    {
        DefaultTableModel model = (DefaultTableModel) filePreviewTable.getModel();
        if (model.getColumnCount() > 0)
        {
            model.setColumnCount(model.getColumnCount() - 1);
            model.fireTableDataChanged();
        }
    }
    
    public void addRow()
    {
        DefaultTableModel model = (DefaultTableModel) filePreviewTable.getModel();
        if (model.getColumnCount() > 0)
        {
            Object[] temp = new Object[]
            {
                ""
            };
            model.addRow(temp);
            model.fireTableDataChanged();
        }
        
    }
    
    public void removeRow(int index)
    {
        DefaultTableModel model = (DefaultTableModel) filePreviewTable.getModel();
        if (model.getRowCount() > 0)
        {
            model.removeRow(index);
            model.fireTableDataChanged();
        }
    }
    
    public void addValueString(String input, int row, int column)
    {
        DefaultTableModel model = (DefaultTableModel) filePreviewTable.getModel();
        if (model.getRowCount() <= row)
        {
            if (model.getRowCount() <= column)
            {
                model.setValueAt(input, row, column);
            }
        }
    }
    
    public void addValueInt(int input, int row, int column)
    {
        DefaultTableModel model = (DefaultTableModel) filePreviewTable.getModel();
        if (model.getRowCount() <= row)
        {
            if (model.getRowCount() <= column)
            {
                model.setValueAt(input, row, column);
            }
        }
    }
    
    //=================================================================
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadButton = new javax.swing.JButton();
        loadPath_input = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loadSchedule_error = new javax.swing.JLabel();
        savePath_error = new javax.swing.JLabel();
        fileName_error = new javax.swing.JLabel();
        loadTypeComboBox = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        filePreviewTable = new javax.swing.JTable();
        selectFileComboBox = new javax.swing.JComboBox<>();

        loadButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        loadPath_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPath_inputActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Enter the full path to the file you wish to open (a .CSV file):");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Load Spreadsheet");

        loadTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loadTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Faculty Preferences", "Course Listing", "Room Listing" }));
        loadTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTypeComboBoxActionPerformed(evt);
            }
        });

        filePreviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(filePreviewTable);

        selectFileComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectFileComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select File to View" }));
        selectFileComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileName_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(savePath_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(loadTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(loadButton)
                                            .addComponent(loadPath_input, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(loadPath_input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(loadButton)))))
                .addGap(64, 64, 64)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(selectFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        //Load button clicked
        loadTypeComboBox.setSelectedItem("Select Type");
    }//GEN-LAST:event_loadButtonActionPerformed

    private void loadPath_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPath_inputActionPerformed
        //Activates when the user inputs something for the load file path
    }//GEN-LAST:event_loadPath_inputActionPerformed

    
    public String getTypeFromCombo(JComboBox input)
    {
        if (input.getSelectedItem().equals("Faculty Preferences"))
        {
            return "FACULTY_PREFERENCES";
        }
        else if (input.getSelectedItem().equals("Course Listing"))
        {
            return "COURSE_LISTING";
        }
        else if (input.getSelectedItem().equals("Room Listing"))
        {
            return "ROOM_LISTING";
        }
        else if (input.getSelectedItem().equals("All Course Periods"))
        {
            return "COURSE_PERIODS";
        }
        return "INVALID_CHOICE";
    }
    
    private void selectFileComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileComboBoxActionPerformed
        if (!selectFileComboBox.getSelectedItem().equals("Select File to View"))       
        {
            clearTable();
            //Set the table using the table functions and CSV parsers (making the CSV file parser is not my job)
        }
        
    }//GEN-LAST:event_selectFileComboBoxActionPerformed

    private void loadTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTypeComboBoxActionPerformed
        if (!loadTypeComboBox.getSelectedItem().equals("Select Type"))       
        {
            loadButton.setEnabled(true);
            loadType = getTypeFromCombo(loadTypeComboBox);
        }
        else
        {
            loadButton.setEnabled(false);
        }
    }//GEN-LAST:event_loadTypeComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fileName_error;
    private javax.swing.JTable filePreviewTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField loadPath_input;
    private javax.swing.JLabel loadSchedule_error;
    private javax.swing.JComboBox<String> loadTypeComboBox;
    private javax.swing.JLabel savePath_error;
    private javax.swing.JComboBox<String> selectFileComboBox;
    // End of variables declaration//GEN-END:variables
}
