/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordpress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static wordpress.Wordpress.myConn;

public class EditDraft extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet result = null;
    Statement statement = null;
    int idUser;
    int idArticle;

    public EditDraft() {
        initComponents();
        idUser = 0;
    }

    public EditDraft(int user, int idArticle) {
        initComponents();
        this.idUser = user;
        this.idArticle = idArticle;
    }

    public int getIdUser() {
        return idUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PublishButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        DraftTitleLabel = new javax.swing.JLabel();
        EditedDraft = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        EditedDraftText = new javax.swing.JTextArea();
        EditDraftLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PublishButton.setText("Publish");
        PublishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublishButtonActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        DraftTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DraftTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DraftTitleLabel.setText("Draft Title");

        EditedDraftText.setColumns(20);
        EditedDraftText.setLineWrap(true);
        EditedDraftText.setRows(5);
        EditedDraftText.setWrapStyleWord(true);
        jScrollPane3.setViewportView(EditedDraftText);

        EditDraftLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EditDraftLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EditDraftLabel.setText("Edit Draft");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(PublishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DraftTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(EditedDraft, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(EditDraftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addGap(73, 73, 73)))
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(EditDraftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(DraftTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addComponent(EditedDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PublishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PublishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublishButtonActionPerformed
        Wordpress a = new Wordpress();
        conn = a.ConnectDB();
        try {
            String query = " insert into publish (id_user, publish_name, publish_text, publish_date, views)" + " values (? , ?, ?, ?, ?)";
            com.mysql.jdbc.PreparedStatement preparedStmt = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(query);
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
            preparedStmt.setInt(1, idUser);
            preparedStmt.setString(2, EditedDraft.getText());
            preparedStmt.setString(3, EditedDraftText.getText());
            preparedStmt.setDate(4, startDate);
            preparedStmt.setInt(5, 0);
            // execute the preparedstatement
            preparedStmt.execute();
            EditedDraft.setText("");
            EditedDraftText.setText("");
            preparedStmt.close();
            String deleteQuery="delete from draft where id_draft = ?";
            pst = conn.prepareStatement(deleteQuery);
            pst.setInt(1,idArticle);
            pst.execute();
            backToSeeDrafts();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                result.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                pst.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }//GEN-LAST:event_PublishButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        backToSeeDrafts();
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EditDraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditDraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditDraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditDraft().setVisible(true);
            }
        });
    }

    public void backToSeeDrafts() {
        SeeDrafts see = new SeeDrafts(idUser);
        see.showDrafts();
        see.setVisible(true);
        setVisible(false);
        dispose();
    }

    public void showTitleAndText(int user, int article) {

        try {
            Wordpress a = new Wordpress();
            conn = a.ConnectDB();
            statement = conn.createStatement();
            String sql = "select * from draft;";
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (result.getInt("id_draft") == article) {
                        EditedDraftText.setText(result.getString("draft_text"));
                        EditedDraft.setText(result.getString("draft_name"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                result.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                pst.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel DraftTitleLabel;
    private javax.swing.JLabel EditDraftLabel;
    private javax.swing.JTextField EditedDraft;
    private javax.swing.JTextArea EditedDraftText;
    private javax.swing.JButton PublishButton;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}