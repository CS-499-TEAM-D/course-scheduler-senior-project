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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
    JFileChooser fc;
    
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
        //jLabel4.setFont(newFont1); //Enter the full path to the file you wish to open (a .CSV file):
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
        fc = new JFileChooser();
        loadButton.setEnabled(false);
        removeFileButton.setEnabled(false);
    }
    
    //=================================================================
    //Load functions:
    /*
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
    */
    //=================================================================
    //Table functions:
    
    public void clearTable() //Needs testing!
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

        popupMenu = new javax.swing.JPopupMenu();
        fileChooser = new javax.swing.JFileChooser();
        loadButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        loadSchedule_error = new javax.swing.JLabel();
        savePath_error = new javax.swing.JLabel();
        fileName_error = new javax.swing.JLabel();
        loadTypeComboBox = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        filePreviewTable = new javax.swing.JTable();
        selectFileComboBox = new javax.swing.JComboBox<>();
        removeFileButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        debugText = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();

        fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\evilc\\Desktop"));
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        loadButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

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

        removeFileButton.setText("Remove File");
        removeFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFileButtonActionPerformed(evt);
            }
        });

        debugText.setColumns(20);
        debugText.setRows(5);
        debugText.setText("Test");
        jScrollPane2.setViewportView(debugText);

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(loadTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loadButton))
                        .addGap(178, 178, 178)
                        .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeFileButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loadTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(loadButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeFileButton)
                    .addComponent(saveButton))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        //Load button clicked
        loadTypeComboBox.setSelectedItem("Select Type");
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            String text;
            try 
            {
                File file = fc.getSelectedFile();
                BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                debugText.read(input, "READING FILE :-)");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_loadButtonActionPerformed

    
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
            removeFileButton.setEnabled(true);
            //Set the table using the table functions and CSV parsers (making the CSV file parser is not my job)
        }
        else
        {
            removeFileButton.setEnabled(false);
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

    private void removeFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFileButtonActionPerformed
        // TODO add your handling code here:
        clearTable();
    }//GEN-LAST:event_removeFileButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        int returnVal = fc.showSaveDialog(this);
        String fullPath = "";
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            try 
            {
                File file = fc.getSelectedFile();
                fullPath = file.getPath();      
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            try 
            {
                File myObj = new File(fullPath);
                if (myObj.createNewFile()) 
                {
                  FileWriter myWriter = new FileWriter(myObj);
                  myWriter.write(debugText.getText());
                  myWriter.close();
                } 
                else 
                {
                  System.out.println("File already exists.");
                }
           } 
           catch (IOException e) 
           {
            System.out.println("An error occurred.");
            e.printStackTrace();
           }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_fileChooserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea debugText;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel fileName_error;
    private javax.swing.JTable filePreviewTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loadButton;
    private javax.swing.JLabel loadSchedule_error;
    private javax.swing.JComboBox<String> loadTypeComboBox;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JButton removeFileButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel savePath_error;
    private javax.swing.JComboBox<String> selectFileComboBox;
    // End of variables declaration//GEN-END:variables
}
