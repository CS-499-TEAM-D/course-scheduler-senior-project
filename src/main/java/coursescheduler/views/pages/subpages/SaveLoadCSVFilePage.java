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
/**
 *
 * @author evilc
 */
public class SaveLoadCSVFilePage extends javax.swing.JPanel {
    PageControl control;
    String page = "SAVE_LOAD_CSV_FILE";
    PanelController controller;
    boolean validNameSave = false;
    boolean validChoice = false;
    boolean validFileSave = false;
    boolean validFileLoad = false;
    String fileNameSave;
    String filePathSave;
    String filePathLoad;
    int textSize = 12;
  
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
    public SaveLoadCSVFilePage() {
        initComponents();
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
        errorDisplayLoad = new javax.swing.JLabel();
        errorDisplaySave = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        loadSchedule_error = new javax.swing.JLabel();
        savePath_error = new javax.swing.JLabel();
        fileName_error = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Save CSV File");

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
        jLabel1.setText("Load CSV File");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(errorDisplaySave, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fileName_input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(savePath_input, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(loadPath_input)
                            .addComponent(loadButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorDisplayLoad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadSchedule_error, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(loadPath_input)
                    .addComponent(fileName_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(fileName_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadSchedule_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(savePath_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(savePath_error, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorDisplaySave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loadButton)))
                    .addComponent(errorDisplayLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(303, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void savePath_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePath_inputActionPerformed
        //Activates when the user inputs something for the save path
    }//GEN-LAST:event_savePath_inputActionPerformed

    private void fileName_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileName_inputActionPerformed
        //Activates when the user inputs something for the file name
    }//GEN-LAST:event_fileName_inputActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //Load schedule button pressed
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        //Load button clicked
    }//GEN-LAST:event_loadButtonActionPerformed

    private void loadPath_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPath_inputActionPerformed
        //Activates when the user inputs something for the load file path
    }//GEN-LAST:event_loadPath_inputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorDisplayLoad;
    private javax.swing.JLabel errorDisplaySave;
    private javax.swing.JLabel fileName_error;
    private javax.swing.JTextField fileName_input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField loadPath_input;
    private javax.swing.JLabel loadSchedule_error;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel savePath_error;
    private javax.swing.JTextField savePath_input;
    // End of variables declaration//GEN-END:variables
}
