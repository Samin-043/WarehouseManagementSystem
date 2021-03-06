/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ameer
 */
public class CustomerView extends javax.swing.JFrame {

    /**
     * Creates new form CustomerView
     */
    public CustomerView() {
        initComponents();
        show_customer();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    public ArrayList<CustomerFrame> customersList(){
        ArrayList<CustomerFrame> customersList = new ArrayList<>();
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=WarehouseManagementSystem;selectMethod=cursor", "sa", "123467");
             String query1 = "Select * from customer";
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query1);
             
             CustomerFrame customerframe;
             while(rs.next()){
                 customerframe = new CustomerFrame(rs.getInt("customer_id"),rs.getString("name"),rs.getString("customer_address"),rs.getString("phone_no"),rs.getString("email"));
                 customersList.add(customerframe);
             }
         }catch (Exception e) {
            e.printStackTrace();
        }
         return customersList;
    }
    
    public void show_customer(){
        ArrayList<CustomerFrame> list = customersList();
        DefaultTableModel model = (DefaultTableModel)Display_Customer.getModel();
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).getCustomer_id();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getCustomer_address();
            row[3] = list.get(i).getPhone_no();
            row[4] = list.get(i).getEmail();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        c_id = new javax.swing.JTextField();
        c_name = new javax.swing.JTextField();
        c_address = new javax.swing.JTextField();
        c_phone = new javax.swing.JTextField();
        c_email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Display_Customer = new javax.swing.JTable();
        c_backButton = new javax.swing.JButton();
        c_editButton = new javax.swing.JButton();
        c_deleteButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        c_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(380, 380, 380))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel2.setText("Customer Id");

        jLabel3.setText("Name");

        jLabel4.setText("Address");

        jLabel5.setText("Phone");

        jLabel6.setText("Email");

        c_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_phoneActionPerformed(evt);
            }
        });

        c_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_emailActionPerformed(evt);
            }
        });

        Display_Customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Name", "Address", "Phone", "Email"
            }
        ));
        Display_Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Display_CustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Display_Customer);

        c_backButton.setForeground(new java.awt.Color(255, 51, 0));
        c_backButton.setText("Back");
        c_backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_backButtonActionPerformed(evt);
            }
        });

        c_editButton.setForeground(new java.awt.Color(255, 51, 0));
        c_editButton.setText("Edit");
        c_editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_editButtonActionPerformed(evt);
            }
        });

        c_deleteButton.setForeground(new java.awt.Color(255, 51, 0));
        c_deleteButton.setText("Delete");
        c_deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_deleteButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Search");

        c_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_phone)
                            .addComponent(c_email)
                            .addComponent(c_name)
                            .addComponent(c_address)
                            .addComponent(c_id)
                            .addComponent(c_search)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(96, Short.MAX_VALUE)
                        .addComponent(c_backButton)
                        .addGap(40, 40, 40)
                        .addComponent(c_editButton)
                        .addGap(28, 28, 28)
                        .addComponent(c_deleteButton)))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(c_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(c_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(c_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(c_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_backButton)
                    .addComponent(c_editButton)
                    .addComponent(c_deleteButton))
                .addGap(51, 51, 51))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_phoneActionPerformed

    private void c_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_emailActionPerformed

    private void c_editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_editButtonActionPerformed
        // TODO add your handling code here:
          try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=WarehouseManagementSystem;user=sa;password=123467";
            Connection con = DriverManager.getConnection(url);
            int row = Display_Customer.getSelectedRow();
            String value = (Display_Customer.getModel().getValueAt(row, 0)).toString();
            String query = "update Customer set name=?,customer_address=?,phone_no=?,email=? where customer_id="+value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, c_name.getText());
            pst.setString(2, c_address.getText());
            pst.setString(3, c_phone.getText());
            pst.setString(4, c_email.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)Display_Customer.getModel();
            model.setRowCount(0);
            show_customer();
            JOptionPane.showMessageDialog(null, "Updated Successfully!");
        }catch (Exception e) {
            e.printStackTrace();
        }
                        
    }//GEN-LAST:event_c_editButtonActionPerformed

    private void c_deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_deleteButtonActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=WarehouseManagementSystem;user=sa;password=123467";
            Connection con = DriverManager.getConnection(url);
            int row = Display_Customer.getSelectedRow();
            String value = (Display_Customer.getModel().getValueAt(row, 0)).toString();
            String query ="delete from customer where customer_id="+value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)Display_Customer.getModel();
            model.setRowCount(0);
            show_customer();
            JOptionPane.showMessageDialog(null, "Deleted Successfully!");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_c_deleteButtonActionPerformed

    private void c_backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_backButtonActionPerformed
       // Menu_Frame mf = new Menu_Frame();
        //mf.setVisible(true);
        dispose();

    }//GEN-LAST:event_c_backButtonActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void Display_CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Display_CustomerMouseClicked
        // TODO add your handling code here:
           int i = Display_Customer.getSelectedRow();
        TableModel model = Display_Customer.getModel();
        c_id.setText(model.getValueAt(i, 0).toString());
        c_name.setText(model.getValueAt(i, 1).toString());
        c_address.setText(model.getValueAt(i, 2).toString());
        c_phone.setText(model.getValueAt(i, 3).toString());
        c_email.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_Display_CustomerMouseClicked

    private void c_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_searchKeyReleased
        // TODO add your handling code here:
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=WarehouseManagementSystem;user=sa;password=123467";
            Connection con = DriverManager.getConnection(url);
            String sql = "Select * from Customer where customer_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,c_search.getText());
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                String setid = rs.getString("customer_id");
                c_id.setText(setid);
                
                String setname = rs.getString("name");
                c_name.setText(setname);
                
                String setadd = rs.getString("customer_address");
                c_address.setText(setadd);
                
                String setphone = rs.getString("phone_no");
                c_phone.setText(setphone);
                
                String setemail = rs.getString("email");
                c_email.setText(setemail);
                
                
                
            }
            }catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_c_searchKeyReleased

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
            java.util.logging.Logger.getLogger(CustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Display_Customer;
    private javax.swing.JTextField c_address;
    private javax.swing.JButton c_backButton;
    private javax.swing.JButton c_deleteButton;
    private javax.swing.JButton c_editButton;
    private javax.swing.JTextField c_email;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField c_name;
    private javax.swing.JTextField c_phone;
    private javax.swing.JTextField c_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
