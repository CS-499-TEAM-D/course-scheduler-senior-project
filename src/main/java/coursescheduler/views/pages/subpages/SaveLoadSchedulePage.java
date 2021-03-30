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
import java.util.ArrayList;
import java.util.List;
import coursescheduler.views.pages.containers.dummyCourse;
import coursescheduler.views.pages.containers.dummyUser;

/**
 *
 * @author evilc
 */
public class SaveLoadSchedulePage extends javax.swing.JPanel {
    PageControl control;
    String page = "DEPARTMENT_CHAIR";
    PanelController controller;
    int textSize = 12;
    
    boolean validNameSave = false;
    boolean validChoice = false;
    boolean validFileSave = false;
    String fileNameSave;
    String filePathSave;
    List<String> scheduleNames = new ArrayList<>();
    boolean validFileLoad = false;
    
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
        jLabel1.setFont(newFont2); //Save Schedule
        jLabel6.setFont(newFont1); //File Name:
        jLabel7.setFont(newFont1); //Save Path:
        selectScheduleComboBox.setFont(newFont1);
        savePathInput.setFont(newFont1);
        fileNameInput.setFont(newFont1);
        saveButton.setFont(newFont1);  
        jLabel3.setFont(newFont2); //Load Schedule
        jLabel4.setFont(newFont1); //Enter the full path to the file you wish to open (a .CSV file):
        loadPathInput.setFont(newFont1);
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
    public SaveLoadSchedulePage() {
        initComponents();
    }
    
    //=======================================================================
    //Save functions:
   public void addScheduleName(String input)
    {
        int i = scheduleNames.size();
        String temp = "Schedule " + String.valueOf(i + 1);
        scheduleNames.add(temp);
    }
    
    public void clearScheduleNames()
    {
        scheduleNames.clear();
    }
    
    
    public void addToComboBox(String input)
    {
        selectScheduleComboBox.addItem(input);
    }
    
    public String getSeletionFromComboBox()
    {
        return (String) selectScheduleComboBox.getSelectedItem();
    }
    
    public void fillComboBox()
    {
        if (!scheduleNames.isEmpty())
        {
            for (int i = 0; i < scheduleNames.size(); i++)
            {
                selectScheduleComboBox.addItem(scheduleNames.get(i));
            }
        }
    }
    
    public void clearComboBox()
    {
        for (int i = 0; i < selectScheduleComboBox.getItemCount(); i ++)
        {
            selectScheduleComboBox.remove(i);
        }
         selectScheduleComboBox.addItem("Select Schedule");
    }
    
    public void checkChoice()
    {
        String temp = (String) selectScheduleComboBox.getSelectedItem();
        if (temp.equals("Select Schedule"))
        {
            validChoice = false;
        }
        else
        {
            validChoice = true;
        }
    }
    
    public void checkNameSave()
    {
        String[] invalidCharacters = {"#", "%", "&", "{", "}", "\\" , "<", ">", "*", "?", "/", " ", "$", "!", "'", ":", "@", "+", "`", "|", "=", " \"" };
        String temp = fileNameInput.getText();
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
            return fileNameInput.getText();
        }
        else
        {
            return "INVALID_FILE_NAME_ENTERED";
        }
        
    }
    
    public String getFilePathAsString()
    {
        checkFilePathSave();
        checkNameSave();
        if (validFileSave && validNameSave)
        {
            String temp1 = savePathInput.getText() + "\\";
            String temp2 = fileNameInput.getText() + ".csv";
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
            String temp1 = savePathInput.getText() + "\\";
            String temp2 = fileNameInput.getText() + ".csv";
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
        File csvFile = new File(savePathInput.getText());
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
    
    //=======================================================================
    //Load functions:
    public String getFilePathAsStringLoad()
    {
        checkFilePathLoad();
        if (validFileLoad)
        {
            return loadPathInput.getText();
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
            String temp1 = loadPathInput.getText();
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
        File csvFile = new File(loadPathInput.getText());
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        savePath_error = new javax.swing.JLabel();
        fileName_error = new javax.swing.JLabel();
        errorDisplaySave = new javax.swing.JLabel();
        savePathInput = new javax.swing.JTextField();
        fileNameInput = new javax.swing.JTextField();
        selectScheduleComboBox = new javax.swing.JComboBox<>();
        selectSchedule_error = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loadPathInput = new javax.swing.JTextField();
        loadSchedule_error = new javax.swing.JLabel();
        loadButton = new javax.swing.JButton();
        errorDisplayLoad = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Save Schedule");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("File Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Save Path:");

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        savePath_error.setForeground(java.awt.Color.red);

        fileName_error.setForeground(java.awt.Color.red);

        errorDisplaySave.setForeground(java.awt.Color.red);

        savePathInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        savePathInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePathInputActionPerformed(evt);
            }
        });

        fileNameInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fileNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNameInputActionPerformed(evt);
            }
        });

        selectScheduleComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectScheduleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Schedule" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Load Schedule");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Enter the full path to the file you wish to open (a .CSV file):");

        loadPathInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loadPathInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPathInputActionPerformed(evt);
            }
        });

        loadSchedule_error.setForeground(java.awt.Color.red);

        loadButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        errorDisplayLoad.setForeground(java.awt.Color.red);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(selectScheduleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fileNameInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(savePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(errorDisplaySave, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(selectSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(loadPathInput)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(loadButton))
                            .addComponent(errorDisplayLoad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(selectScheduleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(loadPathInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(savePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(errorDisplaySave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorDisplayLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(selectSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addComponent(jSeparator1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Load schedule button pressed
    }//GEN-LAST:event_saveButtonActionPerformed

    private void savePathInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePathInputActionPerformed
        //Activates when the user inputs something for the save path
    }//GEN-LAST:event_savePathInputActionPerformed

    private void fileNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNameInputActionPerformed
        //Activates when the user inputs something for the file name
    }//GEN-LAST:event_fileNameInputActionPerformed

    private void loadPathInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPathInputActionPerformed
        //Activates when the user inputs something for the load file path
    }//GEN-LAST:event_loadPathInputActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        //Load button clicked
    }//GEN-LAST:event_loadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorDisplayLoad;
    private javax.swing.JLabel errorDisplaySave;
    private javax.swing.JTextField fileNameInput;
    private javax.swing.JLabel fileName_error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField loadPathInput;
    private javax.swing.JLabel loadSchedule_error;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField savePathInput;
    private javax.swing.JLabel savePath_error;
    private javax.swing.JComboBox<String> selectScheduleComboBox;
    private javax.swing.JLabel selectSchedule_error;
    // End of variables declaration//GEN-END:variables
}
