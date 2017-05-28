/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordpress;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Cosmin-Marian
 */
public class SignIn extends javax.swing.JFrame {

    String lastName;
    String firstName;
    String username;
    String password;
    String email;
    Connection conn;

    public SignIn() {
        initComponents();
    }

    public void CloseFrame() {
        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LastNameLabel = new javax.swing.JLabel();
        FirstNameLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        CreateAccountButton = new javax.swing.JButton();
        SubmitLastName = new javax.swing.JTextField();
        SubmitFirstName = new javax.swing.JTextField();
        SubmitUsername = new javax.swing.JTextField();
        SubmitPassword = new javax.swing.JPasswordField();
        SubmitEmail = new javax.swing.JTextField();
        RetypePasswordLabel = new javax.swing.JLabel();
        SubmitRetypePassword = new javax.swing.JPasswordField();
        SignInLabel = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LastNameLabel.setText("Last Name");

        FirstNameLabel.setText("First Name");

        UsernameLabel.setText("Username");

        PasswordLabel.setText("Password");

        EmailLabel.setText("Email");

        CreateAccountButton.setText("Create Account");
        CreateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountButtonActionPerformed(evt);
            }
        });

        RetypePasswordLabel.setText("Retype Password");

        SignInLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SignInLabel.setText("Sign in");

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RetypePasswordLabel)
                            .addComponent(FirstNameLabel)
                            .addComponent(LastNameLabel)
                            .addComponent(UsernameLabel)
                            .addComponent(PasswordLabel)
                            .addComponent(EmailLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubmitEmail)
                            .addComponent(SubmitUsername)
                            .addComponent(SubmitFirstName)
                            .addComponent(SubmitLastName)
                            .addComponent(SubmitRetypePassword)
                            .addComponent(SubmitPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(CreateAccountButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(SignInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(SignInLabel)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastNameLabel)
                    .addComponent(SubmitLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameLabel)
                    .addComponent(SubmitFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameLabel)
                    .addComponent(SubmitUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RetypePasswordLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel))
                .addGap(34, 34, 34)
                .addComponent(CreateAccountButton)
                .addGap(31, 31, 31)
                .addComponent(Back)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountButtonActionPerformed
        //creating new user in user table from DB
        Wordpress a=new Wordpress();
        conn = a.ConnectDB();
        try {
            //searching in DB is username already exists
            boolean userExist = Wordpress.searchUser(conn, SubmitUsername.getText());
            if (userExist == false) {
                //comparing password and retype password (both fields must be equal)
                if (SubmitPassword.getText().equals(SubmitRetypePassword.getText())) {
                    //if any field is empty, we must complete it in order to insert new user in DB
                    if (SubmitLastName.getText().equals("") || SubmitFirstName.getText().equals("") || SubmitUsername.getText().equals("") || SubmitPassword.getText().equals("")
                            || RetypePasswordLabel.getText().equals("") || SubmitEmail.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please complete all the fields.", "Fields not completed.", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //inserting in DB the new values of the user
                        Wordpress.newUser(SubmitLastName.getText(), SubmitFirstName.getText(), SubmitUsername.getText(), SubmitPassword.getText(), SubmitEmail.getText());
                        Login login= new Login();
                        login.setVisible(true);
                        setVisible(false);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the same password.", "Incorrect password", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please choose a different username.", "Username already exists.", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }//GEN-LAST:event_CreateAccountButtonActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
       //method for getting back to Login
        try {
            Login log = new Login();
            log.setVisible(true);
            setVisible(false);
            dispose();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton CreateAccountButton;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel RetypePasswordLabel;
    private javax.swing.JLabel SignInLabel;
    private javax.swing.JTextField SubmitEmail;
    private javax.swing.JTextField SubmitFirstName;
    private javax.swing.JTextField SubmitLastName;
    private javax.swing.JPasswordField SubmitPassword;
    private javax.swing.JPasswordField SubmitRetypePassword;
    private javax.swing.JTextField SubmitUsername;
    private javax.swing.JLabel UsernameLabel;
    // End of variables declaration//GEN-END:variables
}
