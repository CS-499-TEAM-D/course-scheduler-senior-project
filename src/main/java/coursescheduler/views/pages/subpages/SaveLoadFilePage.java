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
            saveTypeComboBox.addItem("All Course Periods");
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
        jLabel3.setFont(newFont2); //Save CSV File
        jLabel6.setFont(newFont1); //File Name:
        jLabel7.setFont(newFont1); //Save Path:
        saveButton.setFont(newFont1);
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

        saveButton.setEnabled(false);
        loadButton.setEnabled(false);
    }
    
    //=================================================================
    //Save functions:
     public void checkNameSave()
    {
        String[] invalidCharacters = {"#", "%", "&", "{", "}", "\\" , "<", ">", "*", "?", "/", " ", "$", "!", "'", ":", "@", "+", "`", "|", "=", " \"" };
        String temp = fileName_input.getText();
        if (!temp.equals(""))
        {
            for (int j = 0; j < 22; j++)
            {
                if (temp.contains(invalidCharacters[j]))
                {
                    fileName_error.setText("*");
                    validNameSave = false;
                    break;
                }
            }
            fileName_error.setText("");
            validNameSave = true;
        }
    }
    
    public String getFileNameSave()
    {
        checkNameSave();
        if(validNameSave)
        {
            return fileName_input.getText();
        }
        else
        {
            return "INVALID_FILE_NAME_ENTERED";
        }
        
    }
    
    public String getFilePathAsStringSave()
    {
        checkFilePathSave();
        checkNameSave();
        if (validFileSave && validNameSave)
        {
            String temp1 = savePath_input.getText() + "\\";
            String temp2 = fileName_input.getText() + ".csv";
            return (temp1 + temp2);
        }
        else
        {
            return "INVALID_FILE_PATH";
        }
    }
    
    public Path getFilePathAsPathSave()
    {
        checkFilePathSave();
        checkNameSave();
        Path p1;
        if (validFileSave && validNameSave)
        {
            String temp1 = savePath_input.getText() + "\\";
            String temp2 = fileName_input.getText() + ".csv";
            String temp3 = temp1 + temp2;
            p1 = Paths.get(temp3);
        }
        else
        {
            String temp1 = "INVALID_FILE_PATH";
            p1 = Paths.get(temp1);
        }
        return p1;
    }
    
    public void checkFilePathSave()
    {
        File csvFile = new File(savePath_input.getText());
        if (csvFile.exists())
        {
            savePath_error.setText("");
            validFileSave = true;
        }
        else
        {
            savePath_error.setText("*");
            validFileSave = false;
        }
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

        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        savePath_input = new javax.swing.JTextField();
        fileName_input = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        loadPath_input = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        loadSchedule_error = new javax.swing.JLabel();
        savePath_error = new javax.swing.JLabel();
        fileName_error = new javax.swing.JLabel();
        saveTypeComboBox = new javax.swing.JComboBox<>();
        loadTypeComboBox = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        filePreviewTable = new javax.swing.JTable();
        selectFileComboBox = new javax.swing.JComboBox<>();

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Save Spreadsheet");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("File Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Save Path:");

        savePath_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePath_inputActionPerformed(evt);
            }
        });

        fileName_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileName_inputActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        saveTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saveTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Faculty Preferences", "Course Listing", "Room Listing" }));
        saveTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTypeComboBoxActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(fileName_input, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(saveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(30, 30, 30)
                                    .addComponent(savePath_input, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileName_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(savePath_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loadTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loadButton)
                            .addComponent(loadPath_input, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fileName_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(savePath_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(loadPath_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loadTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(loadButton))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(selectFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void savePath_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePath_inputActionPerformed
        //Activates when the user inputs something for the save path
    }//GEN-LAST:event_savePath_inputActionPerformed

    private void fileName_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileName_inputActionPerformed
        //Activates when the user inputs something for the file name
    }//GEN-LAST:event_fileName_inputActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Save button pressed
        saveTypeComboBox.setSelectedItem("Select Type");
    }//GEN-LAST:event_saveButtonActionPerformed

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

    private void saveTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTypeComboBoxActionPerformed
        if (!saveTypeComboBox.getSelectedItem().equals("Select Type"))       
        {
            saveButton.setEnabled(true);
            saveType = getTypeFromCombo(saveTypeComboBox);
        }
        else
        {
            saveButton.setEnabled(false);
        }
    }//GEN-LAST:event_saveTypeComboBoxActionPerformed

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
    private javax.swing.JTextField fileName_input;
    private javax.swing.JTable filePreviewTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField loadPath_input;
    private javax.swing.JLabel loadSchedule_error;
    private javax.swing.JComboBox<String> loadTypeComboBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel savePath_error;
    private javax.swing.JTextField savePath_input;
    private javax.swing.JComboBox<String> saveTypeComboBox;
    private javax.swing.JComboBox<String> selectFileComboBox;
    // End of variables declaration//GEN-END:variables
}
