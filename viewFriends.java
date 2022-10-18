
import com.mysql.cj.*;
import java.sql.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHWETA
 */
public class viewFriends extends javax.swing.JFrame {

    /**
     * Creates new form viewFriends
     */
    ResultSet result1;
    Connection con;
    int cust_id=0;
    Image image ;
    public viewFriends(ResultSet result,String cust_id) throws SQLException {
        this.result1=result;
         this.cust_id=Integer.parseInt(cust_id);
         String constring = "jdbc:mysql://localhost:3306/ecommerce?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username="root";
            String pass ="";
            con=(Connection) DriverManager.getConnection(constring,username, pass);
            if(con!=null){System.out.print("Connection");}
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
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(749, 736));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html> <p style=\"background-color:black;padding:20px 150px 20px 137px;font-family:Copperplate;font-size:25px\"> <b>Product List        </b> </p> <html>   ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 590, 67));

        jToolBar1.setBackground(new java.awt.Color(255, 204, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        try{
            result1.last();
            javax.swing.JLabel jLabel[]=new javax.swing.JLabel[result1.getRow()];
            javax.swing.JLabel jLabel1[]=new javax.swing.JLabel[result1.getRow()];
            javax.swing.JLabel jLabel2[]=new javax.swing.JLabel[result1.getRow()];
            javax.swing.JLabel jLabel3[]=new javax.swing.JLabel[result1.getRow()];
            javax.swing.JButton jButton1[]=new javax.swing.JButton[result1.getRow()];
            javax.swing.JSeparator jSeparator1[]=new javax.swing.JSeparator[result1.getRow()];
            result1.beforeFirst();

            int i=0;
            while(result1.next()){

                jLabel[i]=new javax.swing.JLabel();
                jLabel1[i]=new javax.swing.JLabel();
                jLabel2[i]=new javax.swing.JLabel();
                jLabel3[i]=new javax.swing.JLabel();
                jButton1[i]=new javax.swing.JButton();
                jSeparator1[i]=new javax.swing.JSeparator();

                jLabel2[i].setText("<html><p style='font-size:13px;color:black;margin-top:3px;'>"+result1.getString("product_name")+" </p></html>");
                jLabel3[i].setText("<html><p style='font-size:13px;color:black;margin-top:6px;'>"+result1.getString("description")+" </p></html>");
                jLabel1[i].setText("<html><p style='font-size:13px;color:black;margin-top:9px;'>"+result1.getFloat("price")+" </p></html>");
                jButton1[i].setText("<html><p style='background-color:#4d94ff;color:white;padding:5px 8px 5px 8px;font-size:10px;margin-top:12px;'>Rate<p></html>");
                jButton1[i].setName(String.valueOf(result1.getInt("product_id")));
                jLabel[i].setPreferredSize(new Dimension(130,150));

                jToolBar1.add(jLabel[i]);
                jToolBar1.add(jLabel2[i]);
                jToolBar1.add(jLabel3[i]);
                jToolBar1.add(jLabel1[i]);
                jToolBar1.add(jButton1[i]);

                jToolBar1.add(jSeparator1[i]);

                BufferedImage bImage=null;
                try { bImage = ImageIO.read(result1.getBlob("Image_file").getBinaryStream());
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ImageIO.write(bImage, "jpg", bos );
                    byte [] data = bos.toByteArray();
                    ByteArrayInputStream bis = new ByteArrayInputStream(data);
                    BufferedImage bImage2 = ImageIO.read(bis);}
                catch (IOException ex) {}
                image = bImage.getScaledInstance(138,151,Image.SCALE_SMOOTH);;
                ImageIcon icon = new ImageIcon(image);
                jLabel[i].setIcon(icon);

                jButton1[i].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButtonActionPerformed(evt);
                    }
                });

                i++;     }

        }catch(Exception e){System.out.println(e);}
        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 633, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    public void jButtonActionPerformed(java.awt.event.ActionEvent e) {
            try{
            if (e.getSource() instanceof JButton) 
            {
            PreparedStatement s1=(PreparedStatement)con.prepareStatement("Insert into review(product_id,cust_id) values (?,?)");
               int prodid=Integer.parseInt(((JButton) e.getSource()).getName());
               s1.setInt(2,cust_id); 
               s1.setInt(1,Integer.parseInt(((JButton) e.getSource()).getName()));
            int rs1= s1.executeUpdate(); 
             new Rate(cust_id,prodid).setVisible(true);
             
            }
            }catch(Exception ee){System.out.println(ee);}}
    
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
            java.util.logging.Logger.getLogger(viewFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        
      
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
