/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler.views.pages.subpages;

import javax.swing.table.DefaultTableModel;
import coursescheduler.managers.PanelController;
import coursescheduler.managers.PopupController;
import coursescheduler.views.pages.containers.PageControl;
import coursescheduler.views.pages.containers.dummyRoom;
import coursescheduler.views.pages.containers.dummyUser;
import java.awt.Font;

/**
 *
 * @author evilc
 */
public class EditRoomPage extends javax.swing.JPanel {
    PageControl control;
    String page = "EDIT_ROOM";
    PanelController controller;
    boolean validBuilding = false;
    boolean validProfessor = false;
    boolean validRoom = false;
    boolean validTimes = false;
    boolean validDays = false;
    boolean validSeats = false;
    boolean allInputsValid = false;
    inputSingleCourseDataTable editor;
    PopupController popupController;
    int textSize = 12;
    
    public void setPageSettingsControl(PageControl input)
    {
        control = input;
    }
    
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
        jLabel1.setFont(newFont2); //Edit Course
        jLabel2.setFont(newFont1); //College:
        jLabel8.setFont(newFont1); //Course:
        jLabel9.setFont(newFont1); //Seats:
        selectRoomComboBox.setFont(newFont1);
        selectBuildingComboBox.setFont(newFont1);
        selectRoomComboBox.setFont(newFont1);
        seatsInput.setFont(newFont1);
        submitButton.setFont(newFont1);
    }
    
    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    public EditRoomPage() {
        initComponents();
        editor = new inputSingleCourseDataTable();
    }
    
    
    public void addComboBoxRoom(dummyRoom input)
    {
        selectRoomComboBox.addItem(input.getNumber());
        
    }
    
    public void removeComboBoxRoom(String input)
    {
        selectRoomComboBox.removeItem(input);
    }
    
    
     public void checkSeats()
    {
        String Seats_string = seatsInput.getText();
        int seats;
        if (!Seats_string.equals(""))
        {
             try
            {
                seats = Integer.parseInt(Seats_string.trim());
                editRoomError_Seats.setText("");
                validSeats = true;
            }
            catch (NumberFormatException nfe)
            {
                editRoomError_Seats.setText("*");
                validSeats = false;
            }  
        }
        else
        {
            editRoomError_Seats.setText("*");
            validSeats = false;
        }
    }
    

    

    
    public void checkBuilding()
    {
        String College = (String) selectBuildingComboBox.getSelectedItem();
        if ((College.equals("") || (College.equals("Select Building"))))
        {
            editRoomError_Building.setText("*");
            validBuilding = false;
        }
        else
        {
            validBuilding = true;
            editRoomError_Building.setText("");
        }
    }
    

  
    public void checkAllInputs()
    {   
       checkBuilding();
       checkSeats();
       
       if (validBuilding && validSeats)
       {
           allInputsValid = true;
       }
       else
       {
           allInputsValid = false;
           
       }
    }

    public int getSeats()
    {
        int seats = -1;
        checkSeats();
        if (validSeats)
        {
             String Seats_string = seatsInput.getText();
             seats = Integer.parseInt(Seats_string.trim());
        }
        return seats;
    }
    

    
    

    
    public dummyRoom getRoom()
    {
        checkAllInputs();
        dummyRoom temp = null;
        String number = (String) selectRoomComboBox.getSelectedItem();
        if (!number.equals("Select Course") && allInputsValid)
        {
             temp = control.returnDummyRoomByNumber(number);
             temp.setBuilding((String) selectBuildingComboBox.getSelectedItem());
             temp.setNumber((String) selectRoomComboBox.getSelectedItem());
             temp.setSeats(Integer.valueOf(seatsInput.getText()));
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

        jLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        selectBuildingComboBox = new javax.swing.JComboBox<>();
        addCourseErrorDisplay1 = new javax.swing.JLabel();
        selectRoomComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        seatsInput = new javax.swing.JTextField();
        editRoomError_Room = new javax.swing.JLabel();
        editRoomError_Building = new javax.swing.JLabel();
        editRoomError_Seats = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Edit Room");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Building:");

        selectBuildingComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectBuildingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building" }));

        selectRoomComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectRoomComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));
        selectRoomComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRoomComboBoxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Room:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Seats:");

        seatsInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        editRoomError_Room.setForeground(java.awt.Color.red);

        editRoomError_Building.setForeground(java.awt.Color.red);

        editRoomError_Seats.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(submitButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(seatsInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectRoomComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 176, Short.MAX_VALUE)
                            .addComponent(selectBuildingComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCourseErrorDisplay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editRoomError_Room, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editRoomError_Building, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editRoomError_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(selectRoomComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(editRoomError_Room, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(selectBuildingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(editRoomError_Building, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addCourseErrorDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editRoomError_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(22, 22, 22)
                .addComponent(submitButton)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        //Submit button:
       dummyRoom temp = getRoom();
       if (temp != null && allInputsValid)
       {
           control.editRoom(temp);
           selectRoomComboBox.setSelectedItem("Select Room");
           selectBuildingComboBox.setSelectedItem("Select Building");
           seatsInput.setText("");
       }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void selectRoomComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRoomComboBoxActionPerformed
        // TODO add your handling code here:
        dummyRoom temp = null;
        String number = (String) selectRoomComboBox.getSelectedItem();
        if (!number.equals("Select Room"))
        {
            temp = control.returnDummyRoomByNumber(number);
            selectBuildingComboBox.setSelectedItem(temp.getBuilding());
            selectRoomComboBox.setSelectedItem(temp.getNumber());
            seatsInput.setText(String.valueOf(temp.getSeats()));
        }
        
    }//GEN-LAST:event_selectRoomComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCourseErrorDisplay1;
    private javax.swing.JLabel editRoomError_Building;
    private javax.swing.JLabel editRoomError_Room;
    private javax.swing.JLabel editRoomError_Seats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField seatsInput;
    private javax.swing.JComboBox<String> selectBuildingComboBox;
    private javax.swing.JComboBox<String> selectRoomComboBox;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
