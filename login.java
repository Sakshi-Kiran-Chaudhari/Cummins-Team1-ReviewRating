/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysql.cj.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author SHWETA
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
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

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        label1 = new java.awt.Label();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 300, 73));

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("<html>\n<h4  style='background-color:#5cb85c;padding:20px 60px 20px 40px;font-family:Copperplate;font-size:14px'>\n<b>\nLogin\n</b>\n</h4>\n<html>\n");
        jButton1.setActionCommand("");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 160, 80));

        jLabel1.setText("<html><p style=' padding-left:120px;font-size:18px;'><b>**Welcome to A-Z Store **</b></p></html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 660, 120));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html>\n<h4 style=\"background-color:black;padding:20px;font-family:Copperplate;font-size:14px\">\n<b>\nEnter Username (email)\n</b>\n</h4>\n<html>\n\n\n");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 200, 73));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html>\n<h4 style=\"background-color:black;padding:20px;font-family:Copperplate;font-size:14px\">\n<b>\nEnter Password\n</b>\n</h4>\n<html>\n\n\n");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 200, 76));

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 300, 76));

        label1.setBackground(new java.awt.Color(0, 102, 255));
        label1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText(" Sign Up");
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 630, 60, 40));

        jLabel5.setText("<html><h2>Don't have an account ??</html></h2>");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 630, 230, 40));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    String constring = "jdbc:mysql://localhost:3306/ecommerce?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username="root"; 
    String password ="";
    
    /*8888888888888888888888888888888888888888888888  Query 1*/
    String sql="SELECT * FROM customer WHERE email='"+jTextField1.getText()+"' and password='"+jPasswordField1.getText()+"' and email!='' and password!=''  ";
    try{
         Connection con= (Connection) DriverManager.getConnection(constring,username, password);
            Statement s= (Statement) con.prepareStatement(sql);
            ResultSet rs= s.executeQuery(sql);
            
            
    if(rs.next()){        
    dispose();
    Statement s2= (Statement) con.prepareStatement("select * from product");
            ResultSet rs2= s2.executeQuery("select * from product");
     new viewFriends(rs2,rs.getString("cust_id")).setVisible(true);
       
    }
    else{
      JOptionPane.showMessageDialog(this,"Invalid Credentials.","Alert",JOptionPane.WARNING_MESSAGE);   
    }con.close();}
    catch(Exception e){System.out.println(e);}
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        // TODO add your handling code here:
    dispose();
    new signup().setVisible(true);  
    }//GEN-LAST:event_label1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}