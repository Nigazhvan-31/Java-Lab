/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javalab8;

/**
 *
 * @author Nigazhvan
 */

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mehakklunkar
 */
public class Msc extends javax.swing.JFrame {

    /**
     * Creates new form Msc
     */
    public Msc() {
        initComponents();
        Connect();
        Load();
    }
    Connection c;
    PreparedStatement pat;
    CallableStatement cstat;
    DefaultTableModel def;
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/AttendeeManagement","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Msc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Msc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Load()
    {
        try {
            pat=c.prepareStatement("select * from Attendee");
            ResultSet rs=pat.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            int c=rss.getColumnCount();
            def=(DefaultTableModel)jTable1.getModel();
            def.setRowCount(0);
            while(rs.next())
            {
                Vector v=new Vector();
                for(int i=0;i<=c;i++)
                {
                    v.add(rs.getString("id"));
                     v.add(rs.getString("fullname"));
                     v.add(rs.getString("email"));
                      v.add(rs.getString("contactnumber"));
                       v.add(rs.getString("country"));
                }
                def.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Msc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void generateStatistics() {
        try {
            // Direct SQL query instead of stored procedure
            Statement stmt = c.createStatement();
            String sql = "SELECT country, COUNT(*) AS attendee_count FROM Attendee GROUP BY country";
            ResultSet rs = stmt.executeQuery(sql);

            // Display the results in a dialog box
            StringBuilder stats = new StringBuilder("Attendee Statistics:\n");
            while (rs.next()) {
                stats.append("Country: ").append(rs.getString("country"))
                     .append(", Count: ").append(rs.getInt("attendee_count"))
                     .append("\n");
            }
            JOptionPane.showMessageDialog(this, stats.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Msc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfullname = new javax.swing.JTextField();
        temail = new javax.swing.JTextField();
        tcontactnumber = new javax.swing.JTextField();
        tcountry = new javax.swing.JTextField();
        badd = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bdel = new javax.swing.JButton();
        bsearch = new javax.swing.JButton();
        bclose = new javax.swing.JButton();
        bstats = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("Attendee Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FULL NAME", "EMAIL", "CONTACT NUMBER", "COUNTRY"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Full Name");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Contact Number");
       
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Country");

        tfullname.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        temail.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        tcontactnumber.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
       
        tcountry.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        badd.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        badd.setText("ADD");
        badd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baddActionPerformed(evt);
            }
        });

        bedit.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bdel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        bdel.setText("DELETE");
        bdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdelActionPerformed(evt);
            }
        });

        bsearch.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        bsearch.setText("SEARCH");

        bclose.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        bclose.setText("CLOSE");
        bclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcloseActionPerformed(evt);
            }
        });
       
        bstats.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        bstats.setText("STATISTICS");
        bstats.addActionListener(evt -> generateStatistics());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
jPanel2.setLayout(jPanel2Layout);

jPanel2Layout.setHorizontalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(badd)
                .addGap(18, 18, 18)
                .addComponent(bedit)
                .addGap(18, 18, 18)
                .addComponent(bdel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfullname, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(tcontactnumber)
                    .addComponent(temail)
                    .addComponent(tcountry))
                .addGap(33, 33, 33))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(bsearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bclose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bstats)
                .addGap(0, 0, Short.MAX_VALUE))
);

jPanel2Layout.setVerticalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel2)
            .addComponent(tfullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3)
            .addComponent(temail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel4)
            .addComponent(tcontactnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel5)
            .addComponent(tcountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(30, 30, 30)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(badd)
            .addComponent(bedit)
            .addComponent(bdel))
        .addGap(26, 26, 26)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(bsearch)
            .addComponent(bclose)
            .addComponent(bstats))
        .addContainerGap(47, Short.MAX_VALUE))
);

// Layout for the main content pane
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);

layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
);

layout.setVerticalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(79, Short.MAX_VALUE))
);


        pack();
    }// </editor-fold>          
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   

    private void baddActionPerformed(java.awt.event.ActionEvent evt) {                                    
        try {
            String fullname = tfullname.getText();
            String email = temail.getText();
            String contactnumber = tcontactnumber.getText();
            String country = tcountry.getText();
   
            // Check if any field is empty
            if (fullname.isEmpty() || email.isEmpty() || contactnumber.isEmpty() || country.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled");
                return;
            }
            if (contactnumber.trim().length()!=10) {
                JOptionPane.showMessageDialog(this, "Invalid contact number.");
                return;
            }
            // Check for duplicate email
        pat = c.prepareStatement("SELECT * FROM Attendee WHERE email = ?");
        pat.setString(1, email);
        ResultSet emailResult = pat.executeQuery();
        if (emailResult.next()) {
            JOptionPane.showMessageDialog(this, "An attendee with this email already exists.");
            return;
        }

        // Check for duplicate contact number
        pat = c.prepareStatement("SELECT * FROM Attendee WHERE contactnumber = ?");
        pat.setString(1, contactnumber);
        ResultSet contactResult = pat.executeQuery();
        if (contactResult.next()) {
            JOptionPane.showMessageDialog(this, "An attendee with this contact number already exists.");
            return;
        }

        // Check if the exact same record already exists
        pat = c.prepareStatement("SELECT * FROM Attendee WHERE fullname = ? AND email = ? AND contactnumber = ? AND country = ?");
        pat.setString(1, fullname);
        pat.setString(2, email);
        pat.setString(3, contactnumber);
        pat.setString(4, country);
        ResultSet recordResult = pat.executeQuery();
        if (recordResult.next()) {
            JOptionPane.showMessageDialog(this, "This record already exists.");
            return;
        }
           
   
            // Prepare and execute the insert statement
            pat = c.prepareStatement("insert into Attendee(fullname, email, contactnumber, country) values(?, ?, ?, ?)");
            pat.setString(1, fullname);
            pat.setString(2, email);
            pat.setString(3, contactnumber);
            pat.setString(4, country);
            pat.executeUpdate();
   
            JOptionPane.showMessageDialog(this, "Records are added successfully");
            Load();  // Reload the table to show the new record
   
            // Clear input fields after adding
            tfullname.setText("");
            temail.setText("");
            tcontactnumber.setText("");
            tcountry.setText("");
            tfullname.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(Msc.class.getName()).log(Level.SEVERE, "Error while adding records", ex);
        }
    }                                    

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        def=(DefaultTableModel)jTable1.getModel();
        int s=jTable1.getSelectedRow();
        int id=Integer.parseInt(def.getValueAt(s, 0).toString());
        tfullname.setText(def.getValueAt(s, 1).toString());
        temail.setText(def.getValueAt(s, 2).toString());
        tcontactnumber.setText(def.getValueAt(s, 3).toString());
        tcountry.setText(def.getValueAt(s, 4).toString());
        badd.setEnabled(false);
       
    }                                    

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        def=(DefaultTableModel)jTable1.getModel();
        int s=jTable1.getSelectedRow();
        int id=Integer.parseInt(def.getValueAt(s, 0).toString());
        try {
            String fullname,email,contactnumber,country;
            fullname=tfullname.getText();
            email=temail.getText();
            contactnumber=tcontactnumber.getText();
            country=tcountry.getText();
            pat=c.prepareStatement("update Attendee set fullname=?,email=?,contactnumber=?,country=? where id=?");
            pat.setString(1, fullname);
            pat.setString(2, email);
            pat.setString(3, contactnumber);
            pat.setString(4, country);
            pat.setInt(5, id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Records are updated");
            Load();
            tfullname.setText("");
            temail.setText("");
            tcontactnumber.setText("");
            tcountry.setText("");
            tfullname.requestFocus();
            badd.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Msc.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     
    }                                    

    private void bdelActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        def=(DefaultTableModel)jTable1.getModel();
        int s=jTable1.getSelectedRow();
        int id=Integer.parseInt(def.getValueAt(s, 0).toString());
        try {
            String fullname,email,contactnumber,country;
            fullname=tfullname.getText();
            email=temail.getText();
            contactnumber=tcontactnumber.getText();
            country=tcountry.getText();
            pat=c.prepareStatement("delete from Attendee where id=?");
            pat.setInt(1, id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Records are Deleted");
            Load();
            tfullname.setText("");
            temail.setText("");
            tcontactnumber.setText("");
            tcountry.setText("");
            tfullname.requestFocus();
            badd.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Msc.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }                                    

    private void bcloseActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        System.exit(0);
    }                                      

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
            java.util.logging.Logger.getLogger(Msc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Msc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Msc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Msc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Msc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                    
    private javax.swing.JButton badd;
    private javax.swing.JButton bclose;
    private javax.swing.JButton bdel;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tcountry;
    private javax.swing.JTextField tcontactnumber;
    private javax.swing.JTextField temail;
    private javax.swing.JTextField tfullname;
    private javax.swing.JButton bstats;
    // End of variables declaration                  
}
