/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursescheduler;
import coursescheduler.managers.PanelController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
/**
 *
 * @author evilc
 */
public class debuggerFrame extends javax.swing.JFrame {
    List<JPanel> allPages = new ArrayList<>();
    List<String> allPages_Names = new ArrayList<>();
    /**
     * Creates new form debuggerFrame
     */
    
    public debuggerFrame() {
        initComponents();
    }
    
    public void addPage(JPanel pageInput, String input)
    {
        allPages.add(pageInput);
        allPages_Names.add(input);
        //allPagesComboBox.addItem(input);
        this.add(pageInput);
        /*
        for (int i = 0; i < allPagesComboBox.getItemCount(); i ++)
        {
            hidePage(getPage(allPagesComboBox.getItemAt(i)));
        }
        */
    }
    
    
    
    public JPanel getPage(String nameInput)
    {
        int index = 0;
        if (!allPages.isEmpty())
        {
            for (int i = 0; i < allPages.size(); i++)
            {
                if (allPages_Names.get(i).equals(nameInput))
                {
                    index = i;
                    break;
                }
            }
            return allPages.get(index);
        }
        else
        {
            JPanel emptyPage = new JPanel();
            return emptyPage;
        }
    }
    
    public void showPage(JPanel pageInput)
    {
        pageInput.setVisible(true);
    }
    
    public void hidePage(JPanel pageInput)
    {
        pageInput.setVisible(false);
    }
    
    public void showCurrentPage()
    {
        //displayPanel.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(debuggerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(debuggerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(debuggerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(debuggerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //also new debuggerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
