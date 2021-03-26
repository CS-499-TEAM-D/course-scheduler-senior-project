/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler;
import coursescheduler.managers.PanelController;
import java.awt.Font;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author evilc
 */
public class SaveSchedulePage extends javax.swing.JPanel {
    String page = "SAVE_SCHEDULE";
    PanelController controller;
    boolean validName = false;
    boolean validChoice = false;
    boolean validFile = false;
    String fileName;
    String filePath;
    List<String> scheduleNames = new ArrayList<>();
    //List<data type for a full schedule> schedules = new ArrayList<>();
    //TODO: connect to CSV file parser and connect to GenerateSchedulePage
    int textSize = 12;
  
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
    
    public SaveSchedulePage() {
        initComponents();
    }
    
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
    
    public void checkName()
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
                    validName = false;
                    break;
                }
            }
            fileName_error.setText("");
            validName = true;
        }
    }
    
    public String getFileName()
    {
        checkName();
        if(validName)
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
        checkFilePath();
        checkName();
        if (validFile && validName)
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
    
    public Path getFilePathAsPath()
    {
        checkFilePath();
        checkName();
        Path p1;
        if (validFile && validName)
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
    
    public void checkFilePath()
    {
        File csvFile = new File(savePathInput.getText());
        if (csvFile.exists())
        {
            savePath_error.setText("");
            validFile = true;
        }
        else
        {
            savePath_error.setText("*");
            validFile = false;
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
        saveButton = new javax.swing.JButton();
        selectScheduleComboBox = new javax.swing.JComboBox<>();
        savePathInput = new javax.swing.JTextField();
        fileNameInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        savePath_error = new javax.swing.JLabel();
        fileName_error = new javax.swing.JLabel();
        errorDisplay = new javax.swing.JLabel();
        selectSchedule_error = new javax.swing.JLabel();

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Save Schedule");

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        selectScheduleComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectScheduleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Schedule" }));

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("File Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Save Path:");

        savePath_error.setForeground(java.awt.Color.red);

        fileName_error.setForeground(java.awt.Color.red);

        errorDisplay.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(backButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(errorDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectScheduleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(fileNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(savePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Load schedule button pressed
    }//GEN-LAST:event_saveButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //Back button clicked
    }//GEN-LAST:event_backButtonActionPerformed

    private void savePathInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePathInputActionPerformed
        //Activates when the user inputs something for the save path
    }//GEN-LAST:event_savePathInputActionPerformed

    private void fileNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNameInputActionPerformed
        //Activates when the user inputs something for the file name
    }//GEN-LAST:event_fileNameInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel errorDisplay;
    private javax.swing.JTextField fileNameInput;
    private javax.swing.JLabel fileName_error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField savePathInput;
    private javax.swing.JLabel savePath_error;
    private javax.swing.JComboBox<String> selectScheduleComboBox;
    private javax.swing.JLabel selectSchedule_error;
    // End of variables declaration//GEN-END:variables
}
