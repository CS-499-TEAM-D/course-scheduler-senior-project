/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;
import coursescheduler.managers.PanelController;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author evilc
 */
public class SettingsPage extends javax.swing.JPanel {
    String page = "SETTINGS";
    PanelController controller;
    String currentUsername;
    String currentPassword;
    String newPassword;
    boolean validUsername = false;
    boolean usernameNotBlank = false;
    boolean validPassword = false;
    boolean validPasswordMatch = false;
    boolean resizableWindows = true;
    boolean passwordNotBlank = false;
    int textSize = 12;
    int maxSchedules = 30;
    //List<data type for a full schedule> schedules = new ArrayList<>();
    //TODO: Implement backend "connections" and connect to InputMultipleCoursesPreview class

    public void updateTextSize()
    {
        this.setTextSize(textSize);
        int size1 = jLabel1.getFont().getSize();
        int difference1 = size1 - textSize;
        Font newFont1 = new Font("Tahoma", Font.PLAIN,  textSize);
        Font newFont2 = new Font("Tahoma", Font.PLAIN,  (textSize + difference1));
        jLabel1.setFont(newFont2); //Settings
        jLabel2.setFont(newFont1); //General Settings
        jLabel3.setFont(newFont1); //Generator Settings
        jLabel4.setFont(newFont1); //Text Size
        jLabel5.setFont(newFont1); //Maximum Number of
        jLabel6.setFont(newFont1); //Schedules to Generate
        jLabel7.setFont(newFont1); //Username
        jLabel8.setFont(newFont1); //Chnage Password
        jLabel9.setFont(newFont1); //Enter Current
        jLabel10.setFont(newFont1); //Change Username
        jLabel11.setFont(newFont1); //Password
        jLabel12.setFont(newFont1); //New Password
        jLabel13.setFont(newFont1); //Resizable Windows
        jLabel16.setFont(newFont1); //Retype New Password    
        submitTextSize.setFont(newFont1);
        submitUsername.setFont(newFont1);
        submitPassword.setFont(newFont1);
        submitNumberOfSchedulesToGenerate.setFont(newFont1);
        resizableWindowsSubmit.setFont(newFont1);
    }
    
    public void setCurrentUsername(String input)
    {
        currentUsername = input;
    }
    
    public String getCurrentUsername()
    {
        return currentUsername;
    }
    
    public void setCurrentPassword(String input)
    {
        currentPassword = input;
    }
    
    public String getCurrentPassword()
    {
        return currentPassword;
    }
    
    public void setNewPassword(String input)
    {
        newPassword = input;
    }
    
    public String getNewPassword()
    {
        return newPassword;
    }
    
    public void setMaxSchedules(int input)
    {
        maxSchedules = input;
    }
    
    public int getMaxSchedules()
    {
        return maxSchedules;
    }
    
    public void setTextSize(int input)
    {
        textSize = input;
    }
    
    public int returnTextSize()
    {
        return textSize;
    }
    
    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    
    public SettingsPage() {
        initComponents();
        textSizeDisplay.setText(String.valueOf(textSize));
        numberOfSchedulesToGenerateDisplay.setText(String.valueOf(maxSchedules));
        this.setPreferredSize(new Dimension(692, 407));
        this.setMaximumSize(new Dimension(30, 30));
        this.setMinimumSize(new Dimension(4096, 4096));
    }
    
    public void checkPassword()
    {
        String tempCurrentPassword = currentPasswordInput.getText();
        String tempNewPassword = newPasswordInput.getText();
        String tempRetypeNewPassword = retypeNewPasswordInput.getText();
        //TODO: Check if the current password matches the one in backend/storage
        if (!tempNewPassword.equals(""))
        {
            passwordNotBlank = true;
            newPasswordError.setText("");
            if(tempNewPassword.equals(tempRetypeNewPassword))
            {
                validPasswordMatch = true;
                newPasswordError.setText("");
                retypeNewPasswordError.setText("");
            }
            else
            {
                validPasswordMatch = false;
                newPasswordError.setText("*");
                retypeNewPasswordError.setText("*");
            }
        }
        else
        {
            newPasswordError.setText("*");
            passwordNotBlank = false;
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
        textSizeSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        textSizeDisplay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numberOfSchedulesToGenerateSlider = new javax.swing.JSlider();
        numberOfSchedulesToGenerateDisplay = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        submitUsername = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        submitPassword = new javax.swing.JButton();
        usernameError = new javax.swing.JLabel();
        passwordError = new javax.swing.JLabel();
        newPasswordError = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        retypeNewPasswordError = new javax.swing.JLabel();
        submitNumberOfSchedulesToGenerate = new javax.swing.JButton();
        currentPasswordInput = new javax.swing.JPasswordField();
        newPasswordInput = new javax.swing.JPasswordField();
        retypeNewPasswordInput = new javax.swing.JPasswordField();
        errorDisplay = new javax.swing.JLabel();
        submitTextSize = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        resizableWindowsCheckbox = new javax.swing.JCheckBox();
        resizableWindowsSubmit = new javax.swing.JButton();
        resultDisplay = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Settings");

        textSizeSlider.setMaximum(20);
        textSizeSlider.setMinimum(1);
        textSizeSlider.setValue(12);
        textSizeSlider.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                textSizeSliderAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Text Size:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("General Settings");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Generator Settings");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        textSizeDisplay.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Maximum Number of ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Schedules to Generate:");

        numberOfSchedulesToGenerateSlider.setMaximum(30);
        numberOfSchedulesToGenerateSlider.setMinimum(1);
        numberOfSchedulesToGenerateSlider.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                numberOfSchedulesToGenerateSliderAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        numberOfSchedulesToGenerateDisplay.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Username:");

        usernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameInputActionPerformed(evt);
            }
        });

        submitUsername.setText("Submit");
        submitUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitUsernameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Change Password:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Enter Current");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Change Username:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Password:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("New Password:");

        submitPassword.setText("Submit");
        submitPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPasswordActionPerformed(evt);
            }
        });

        usernameError.setForeground(java.awt.Color.red);

        passwordError.setForeground(java.awt.Color.red);

        newPasswordError.setForeground(java.awt.Color.red);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Retype New Password:");

        retypeNewPasswordError.setForeground(java.awt.Color.red);

        submitNumberOfSchedulesToGenerate.setText("Submit");
        submitNumberOfSchedulesToGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitNumberOfSchedulesToGenerateActionPerformed(evt);
            }
        });

        currentPasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentPasswordInputActionPerformed(evt);
            }
        });

        newPasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordInputActionPerformed(evt);
            }
        });

        retypeNewPasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retypeNewPasswordInputActionPerformed(evt);
            }
        });

        errorDisplay.setForeground(java.awt.Color.red);

        submitTextSize.setText("Submit");
        submitTextSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTextSizeActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Resizable Windows:");

        resizableWindowsCheckbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resizableWindowsCheckbox.setSelected(true);

        resizableWindowsSubmit.setText("Submit");
        resizableWindowsSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resizableWindowsSubmitActionPerformed(evt);
            }
        });

        resultDisplay.setForeground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textSizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textSizeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(resultDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(16, 16, 16)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(newPasswordInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                .addComponent(submitPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(currentPasswordInput, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(usernameInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(submitTextSize, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(submitUsername))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                        .addComponent(retypeNewPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(retypeNewPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(submitNumberOfSchedulesToGenerate)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(numberOfSchedulesToGenerateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numberOfSchedulesToGenerateDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resizableWindowsCheckbox)))))
                    .addComponent(resizableWindowsSubmit))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(errorDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(numberOfSchedulesToGenerateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(numberOfSchedulesToGenerateDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textSizeSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(textSizeDisplay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(submitTextSize, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitNumberOfSchedulesToGenerate))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(usernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(passwordError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(currentPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(newPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(resizableWindowsCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resizableWindowsSubmit)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(retypeNewPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(retypeNewPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(submitPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resultDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator3))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textSizeSliderAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_textSizeSliderAncestorMoved
        int sliderValue = textSizeSlider.getValue();
        textSizeDisplay.setText(String.valueOf(sliderValue));
        
    }//GEN-LAST:event_textSizeSliderAncestorMoved

    private void submitTextSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitTextSizeActionPerformed
        int sliderValue = textSizeSlider.getValue();
        textSize = sliderValue;
        this.setTextSize(textSize);
    }//GEN-LAST:event_submitTextSizeActionPerformed

    private void numberOfSchedulesToGenerateSliderAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_numberOfSchedulesToGenerateSliderAncestorMoved
        int sliderValue = numberOfSchedulesToGenerateSlider.getValue();
        numberOfSchedulesToGenerateDisplay.setText(String.valueOf(sliderValue));
    }//GEN-LAST:event_numberOfSchedulesToGenerateSliderAncestorMoved

    private void submitNumberOfSchedulesToGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitNumberOfSchedulesToGenerateActionPerformed
        int sliderValue = numberOfSchedulesToGenerateSlider.getValue();
        maxSchedules = sliderValue;
    }//GEN-LAST:event_submitNumberOfSchedulesToGenerateActionPerformed

    private void resizableWindowsSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resizableWindowsSubmitActionPerformed
        resizableWindows = resizableWindowsCheckbox.isSelected();
        if (resizableWindows)
        {
            this.setPreferredSize(new Dimension(692, 407));
            this.setMaximumSize(new Dimension(692, 407));
            this.setMinimumSize(new Dimension(692, 407));
        }
        else
        {
            this.setPreferredSize(new Dimension(692, 407));
            this.setMaximumSize(new Dimension(30, 30));
            this.setMinimumSize(new Dimension(4096, 4096));
        }
    }//GEN-LAST:event_resizableWindowsSubmitActionPerformed

    private void submitPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPasswordActionPerformed
        checkPassword();
        if (validPasswordMatch && validPassword && passwordNotBlank)
        {
            passwordError.setText("");
            newPasswordError.setText("");
            retypeNewPasswordError.setText("");
            currentPassword = newPasswordInput.getText();
            currentPasswordInput.setText("");
            newPasswordInput.setText("");
            retypeNewPasswordInput.setText("");
            resultDisplay.setText("Password successfully changed.");
        }
    }//GEN-LAST:event_submitPasswordActionPerformed

    private void currentPasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentPasswordInputActionPerformed
        resultDisplay.setText("");
    }//GEN-LAST:event_currentPasswordInputActionPerformed

    private void newPasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordInputActionPerformed
        resultDisplay.setText("");
    }//GEN-LAST:event_newPasswordInputActionPerformed

    private void retypeNewPasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retypeNewPasswordInputActionPerformed
        resultDisplay.setText("");
    }//GEN-LAST:event_retypeNewPasswordInputActionPerformed

    private void submitUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitUsernameActionPerformed
        //TODO: Check that the current username is not equal to the one already in backend/storage
        if (!currentUsername.equals(""))
        {
            usernameNotBlank = true;
            usernameError.setText("");
            currentUsername = usernameInput.getText();
            resultDisplay.setText("Username successfully changed.");
        }
        else
        {
            usernameNotBlank = false;
            usernameError.setText("*");
            
        }
        
    }//GEN-LAST:event_submitUsernameActionPerformed

    private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed
        resultDisplay.setText("");
    }//GEN-LAST:event_usernameInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField currentPasswordInput;
    private javax.swing.JLabel errorDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel newPasswordError;
    private javax.swing.JPasswordField newPasswordInput;
    private javax.swing.JTextField numberOfSchedulesToGenerateDisplay;
    private javax.swing.JSlider numberOfSchedulesToGenerateSlider;
    private javax.swing.JLabel passwordError;
    private javax.swing.JCheckBox resizableWindowsCheckbox;
    private javax.swing.JButton resizableWindowsSubmit;
    private javax.swing.JLabel resultDisplay;
    private javax.swing.JLabel retypeNewPasswordError;
    private javax.swing.JPasswordField retypeNewPasswordInput;
    private javax.swing.JButton submitNumberOfSchedulesToGenerate;
    private javax.swing.JButton submitPassword;
    private javax.swing.JButton submitTextSize;
    private javax.swing.JButton submitUsername;
    private javax.swing.JTextField textSizeDisplay;
    private javax.swing.JSlider textSizeSlider;
    private javax.swing.JLabel usernameError;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
