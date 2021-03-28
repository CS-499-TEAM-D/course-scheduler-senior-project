/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler;

import javax.swing.table.DefaultTableModel;
import coursescheduler.managers.PanelController;
import java.awt.Font;

/**
 *
 * @author evilc
 */
public class RegistrarPage extends javax.swing.JPanel {
    String page = "REGISTRAR";
    PanelController controller;
    //TODO: add in control for resizing the window, like if it can be resized or not
    int textSize = 12; //Doesn't impact the text in tables; may change this in the future
    
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
        int size2 = jLabel2.getFont().getSize();
        int difference2 = size2 - textSize;
        Font newFont1 = new Font("Tahoma", Font.PLAIN,  textSize);
        Font newFont2 = new Font("Tahoma", Font.PLAIN,  (textSize + difference1));
        Font newFont3 = new Font("Tahoma", Font.PLAIN,  (textSize + difference2));
        prelimCoursesButton.setFont(newFont1);
        backButton.setFont(newFont1);
        jLabel1.setFont(newFont2); //Registrar
        jLabel2.setFont(newFont3); //Current Courses Loaded
    }

    public void setController(PanelController input)
    {
        controller = input;
    }
    
    public String returnPage()
    {
        return page;
    }
    
    public DefaultTableModel getModel()
    {
        return (DefaultTableModel) currentCoursesTable.getModel();
    }
    
    public void setModel(DefaultTableModel input)
    {
        currentCoursesTable.setModel(input);
    }
    /**
     * Creates new form RegistrarPage
     */
    public RegistrarPage() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        currentCoursesTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        prelimCoursesButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registrar");

        currentCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "College", "ID", "Name", "Professor", "Room", "Times", "Days", "Seats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(currentCoursesTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Current Courses Loaded:");

        prelimCoursesButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        prelimCoursesButton.setText("Prelimnary Courses");
        prelimCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prelimCoursesButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("Back to Login");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prelimCoursesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prelimCoursesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void prelimCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prelimCoursesButtonActionPerformed
        //Prelimanary courses button pressed
    }//GEN-LAST:event_prelimCoursesButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //Back button pressed
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable currentCoursesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton prelimCoursesButton;
    // End of variables declaration//GEN-END:variables
}
