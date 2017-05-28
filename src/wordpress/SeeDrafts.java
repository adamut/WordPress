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


public class SeeDrafts extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet result = null;
    Statement statement = null;
    private final int idUser;

    public SeeDrafts() {
        initComponents();
        idUser = 0;
    }

    public SeeDrafts(int user) {
        initComponents();
        idUser = user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListaDrafts = new javax.swing.JList<>();
        IdLabel = new javax.swing.JLabel();
        TitleLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        PublishedArticle = new javax.swing.JLabel();
        PublishArticleButton = new javax.swing.JButton();
        EditDraftButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListaDrafts.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaDrafts.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                ListaDraftsComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(ListaDrafts);

        IdLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        IdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IdLabel.setText("Id");

        TitleLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("Title");

        DateLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        DateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateLabel.setText("Date");

        UserLabel.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        UserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLabel.setText("User");

        PublishedArticle.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        PublishedArticle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PublishedArticle.setText("Drafts");

        PublishArticleButton.setText("Publish Draft");
        PublishArticleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublishArticleButtonActionPerformed(evt);
            }
        });

        EditDraftButton.setText("Edit Draft");
        EditDraftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDraftButtonActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(PublishedArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(EditDraftButton, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(PublishArticleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addGap(76, 76, 76))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(PublishedArticle, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PublishArticleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditDraftButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaDraftsComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_ListaDraftsComponentAdded

    }//GEN-LAST:event_ListaDraftsComponentAdded

    private void PublishArticleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublishArticleButtonActionPerformed
       try{ pushDraft();
        eraseDraft();
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_PublishArticleButtonActionPerformed

    private void EditDraftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDraftButtonActionPerformed
        try {
            String value = ListaDrafts.getSelectedValue();
            value = value.substring(0, value.indexOf(" "));
            int idDraft = Integer.parseInt(value);
            System.out.println(idDraft);
            if (!value.equals("")) {
                // System.out.println("acum avem "+ idUser+ " "+ idArticle);
                EditDraft editDraft = new EditDraft(idUser, idDraft);
                editDraft.showTitleAndText(idUser, idDraft);
                editDraft.setVisible(true);
                setVisible(false);
                //System.out.println(idArticle);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a draft", "Draft not selected", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EditDraftButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        backToSeeArticle();
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
            java.util.logging.Logger.getLogger(SeeDrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeeDrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeeDrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeeDrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeeDrafts().setVisible(true);
            }
        });
    }

    public void backToSeeArticle() {
        MainMenu main = new MainMenu(idUser);
        main.setVisible(true);
        setVisible(false);
        dispose();
    }

    DefaultListModel dim1;

    public void showDrafts() {
        try {
            dim1 = new DefaultListModel();
            Wordpress a = new Wordpress();
            conn = a.ConnectDB();
            statement = conn.createStatement();
            result = statement.executeQuery("SELECT id_draft, draft_name, saved_date, username \n"
                    + "FROM draft\n"
                    + "JOIN user ON(id_user=iduser);");
            while (result.next()) {
                dim1.addElement(String.format("%-10s %15s %n", result.getInt("id_draft"), result.getString("draft_name"))
                        + String.format("%25s %25s ", result.getDate("saved_date"), result.getString("username")));

            }
            ListaDrafts.setModel(dim1);

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

    public String searchTitle(int id_draft) {
        Wordpress a = new Wordpress();
        conn = a.ConnectDB();
        String Sql = "Select * from draft where id_draft=?";
        try {
            pst = conn.prepareStatement(Sql);
            pst.setInt(1, id_draft);
            result = pst.executeQuery();
            //search for input SubmitUser and SubmitPassword in MySQL database
            if (result.next()) {
                return result.getString("draft_name");
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
        return null;
    }

    public String searchText(int id_draft) {
        Wordpress a = new Wordpress();
        conn = a.ConnectDB();
        String Sql = "Select * from draft where id_draft=?";
        try {
            pst = conn.prepareStatement(Sql);
            pst.setInt(1, id_draft);
            result = pst.executeQuery();
            //search for input SubmitUser and SubmitPassword in MySQL database
            if (result.next()) {
                return result.getString("draft_text");
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
        return null;
    }

    public void pushDraft() {
       try{
        String value = ListaDrafts.getSelectedValue();
        value = value.substring(0, value.indexOf(" "));
        int idArticol = Integer.parseInt(value);
        if (!value.equals("")) {
            try {
                Wordpress a = new Wordpress();
                conn = a.ConnectDB();
                String query = " insert into publish (id_user, publish_name, publish_text, publish_date, views)" + " values (? , ?, ?, ?, ?)";
                com.mysql.jdbc.PreparedStatement preparedStmt = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(query);
                Calendar calendar = Calendar.getInstance();
                java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
                preparedStmt.setInt(1, idUser);
                String titlu = searchTitle(idArticol);
                String text = searchText(idArticol);
                preparedStmt.setString(2, titlu);
                preparedStmt.setString(3, text);
                preparedStmt.setDate(4, startDate);
                preparedStmt.setInt(5, 0);
                // execute the preparedstatement
                preparedStmt.execute();
                preparedStmt.close();
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
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Please select a draft", "Draft not selected", JOptionPane.ERROR_MESSAGE);
     
       }
    }

    public void eraseDraft() {
        String value = ListaDrafts.getSelectedValue();
        value = value.substring(0, value.indexOf(" "));
        int idArticol = Integer.parseInt(value);
        if (idArticol != -1) {
            String deleteQuery = "delete from draft where id_draft = ?";
            try {
                Wordpress a = new Wordpress();
                conn = a.ConnectDB();
                pst = conn.prepareStatement(deleteQuery);
                pst.setInt(1, idArticol);
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(SeeArticle.class.getName()).log(Level.SEVERE, null, ex);
            }
            ((DefaultListModel) ListaDrafts.getModel()).remove(ListaDrafts.getSelectedIndex());
        }
        ListaDrafts.updateUI();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JButton EditDraftButton;
    private javax.swing.JLabel IdLabel;
    private javax.swing.JList<String> ListaDrafts;
    private javax.swing.JButton PublishArticleButton;
    private javax.swing.JLabel PublishedArticle;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
