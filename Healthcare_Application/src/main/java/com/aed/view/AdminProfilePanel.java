/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.aed.view;

import com.aed.aedlab2.AedLab2;
import com.aed.model.Person;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author yashpawar
 */
public class AdminProfilePanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminProfilePanel
     */
    Person admin = LoginJFrame.loggedInPerson;

    public AdminProfilePanel() {
        initComponents();
        adminUpdateButton.setForeground(Color.white);
        nameField.setText(admin.getName());
        userNameField.setText(admin.getUserName());
        passwordField.setText(admin.getPassword());
        ageField.setText(String.valueOf(admin.getAge()));
        genderField.setText(admin.getGender());
        houseIdField.setText(String.valueOf(admin.getHouseID()));
        adminImgLabel.setSize(120, 120);
        adminImgLabel.setIcon(new ImageIcon(new ImageIcon("./uploads/profileImage/yash.jpeg").getImage().getScaledInstance(adminImgLabel.getWidth(), adminImgLabel.getHeight(), Image.SCALE_SMOOTH)));;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminProfilePanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        genderField = new javax.swing.JTextField();
        houseIdLabel = new javax.swing.JLabel();
        houseIdField = new javax.swing.JTextField();
        adminImgLabel = new javax.swing.JLabel();
        adminUpdateButton = new javax.swing.JButton();

        adminProfilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N
        adminProfilePanel.setName(""); // NOI18N
        adminProfilePanel.setPreferredSize(new java.awt.Dimension(504, 0));
        adminProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel.setText("Name:");
        nameLabel.setToolTipText("");
        adminProfilePanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 30));
        adminProfilePanel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 150, 30));

        userNameLabel.setText("UserName:");
        userNameLabel.setToolTipText("");
        adminProfilePanel.add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 30));

        userNameField.setToolTipText("");
        adminProfilePanel.add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 150, 30));

        passwordLabel.setText("Password:");
        passwordLabel.setToolTipText("");
        adminProfilePanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, 30));
        adminProfilePanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 150, 30));

        ageLabel.setText("Age:");
        adminProfilePanel.add(ageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, 30));

        ageField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ageFieldKeyPressed(evt);
            }
        });
        adminProfilePanel.add(ageField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 150, 30));

        genderLabel.setText("Gender:");
        genderLabel.setToolTipText("");
        adminProfilePanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 120, 30));

        genderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderFieldActionPerformed(evt);
            }
        });
        adminProfilePanel.add(genderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 150, 30));

        houseIdLabel.setText("HouseId:");
        houseIdLabel.setToolTipText("");
        adminProfilePanel.add(houseIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 100, 30));

        houseIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseIdFieldActionPerformed(evt);
            }
        });
        adminProfilePanel.add(houseIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 150, 30));

        adminImgLabel.setToolTipText("");
        adminProfilePanel.add(adminImgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 120, 120));

        adminUpdateButton.setText("Update");
        adminUpdateButton.setToolTipText("");
        adminUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminUpdateButtonActionPerformed(evt);
            }
        });
        adminProfilePanel.add(adminUpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(adminProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(adminProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void genderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderFieldActionPerformed

    private void houseIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_houseIdFieldActionPerformed

    public boolean validation() {
        if (nameField.getText().isEmpty() || userNameField.getText().isEmpty() || ageField.getText().isEmpty()
                || genderField.getText().isEmpty() || houseIdField.getText().isEmpty()
                || passwordField.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    private void adminUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminUpdateButtonActionPerformed
        // TODO add your handling code here:
        if (validation())
            JOptionPane.showMessageDialog(this, "Please Enter All Fields");
        else if (Integer.parseInt(ageField.getText()) < 20 || Integer.parseInt(ageField.getText()) > 100)
                JOptionPane.showMessageDialog(this, "Age not between 20 and 100");
        else {
            admin.setName(nameField.getText());
            admin.setUserName(userNameField.getText());
            admin.setPassword(passwordField.getText());
            admin.setAge(Integer.valueOf(ageField.getText()));
            admin.setGender(genderField.getText());
            admin.setHouseID(Integer.valueOf(houseIdField.getText()));
            AedLab2.personMap.replace(admin.getPersonID(), admin);
            JOptionPane.showMessageDialog(this, "Admin Updated");
        }
    }//GEN-LAST:event_adminUpdateButtonActionPerformed

    private void ageFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == ' ') {
            ageField.setEditable(false);
            JOptionPane.showMessageDialog(this, "Age should be a number");
        } else {
        }
        ageField.setEditable(true);
    }//GEN-LAST:event_ageFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminImgLabel;
    private javax.swing.JPanel adminProfilePanel;
    private javax.swing.JButton adminUpdateButton;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField genderField;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField houseIdField;
    private javax.swing.JLabel houseIdLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
