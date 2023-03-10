/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aed.view;

import com.aed.aedlab2.AedLab2;
import com.aed.model.Community;
import java.awt.CardLayout;
import java.awt.Color;

/**
 *
 * @author yashpawar
 */
public class CommunityAdminJFrame extends javax.swing.JFrame {

    /**
     * Creates new form CommunityAdminJFrame
     */
    CardLayout cardLayout;
    Community cm;
    public static int dontChange = 0;

    public CommunityAdminJFrame() {
        initComponents();
//        for (Community c : AedLab2.communityMap.values()) {
//            if (c.getPersonId() == LoginJFrame.loggedInPerson.getPersonID()) {
//                cm = c;
//            }
//        }
        logoutButton.setForeground(Color.white);
        viewDetailsButton.setForeground(Color.white);
        addHospitalButton.setForeground(Color.white);
        deleteHospitalButton.setForeground(Color.white);
        addHouseButton.setForeground(Color.white);
        deleteHouseButton.setForeground(Color.white);
        profileButton.setForeground(Color.white);
        backButton.setForeground(Color.white);
        
        if (LoginJFrame.loggedInPerson.getRole().equalsIgnoreCase("SYSTEMADMIN")) {
            profileButton.setVisible(false);
            backButton.setVisible(true);
        }
        else{
            backButton.setVisible(false);
        }
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("communityAdminViewPanel", new CommunityAdminViewPanel());
        cardLayout.next(viewPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        operationsPanel = new javax.swing.JPanel();
        viewDetailsButton = new javax.swing.JButton();
        addHospitalButton = new javax.swing.JButton();
        deleteHospitalButton = new javax.swing.JButton();
        addHouseButton = new javax.swing.JButton();
        deleteHouseButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        viewPanel = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        operationsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        viewDetailsButton.setText("View Details");
        viewDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsButtonActionPerformed(evt);
            }
        });

        addHospitalButton.setText("Add Hospital");
        addHospitalButton.setToolTipText("");
        addHospitalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHospitalButtonActionPerformed(evt);
            }
        });

        deleteHospitalButton.setText("Delete Hospital");
        deleteHospitalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHospitalButtonActionPerformed(evt);
            }
        });

        addHouseButton.setText("Add House");
        addHouseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHouseButtonActionPerformed(evt);
            }
        });

        deleteHouseButton.setText("Delete House");
        deleteHouseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHouseButtonActionPerformed(evt);
            }
        });

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout operationsPanelLayout = new javax.swing.GroupLayout(operationsPanel);
        operationsPanel.setLayout(operationsPanelLayout);
        operationsPanelLayout.setHorizontalGroup(
            operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(operationsPanelLayout.createSequentialGroup()
                        .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewDetailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addHospitalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteHospitalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addHouseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteHouseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        operationsPanelLayout.setVerticalGroup(
            operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operationsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(viewDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addHospitalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteHospitalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addHouseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deleteHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        viewPanel.setLayout(new java.awt.CardLayout());

        logoutButton.setText("logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(operationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(operationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsButtonActionPerformed
        // TODO add your handling code here:
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("communityAdminViewPanel", new CommunityAdminViewPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_viewDetailsButtonActionPerformed

    private void addHospitalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHospitalButtonActionPerformed
        // TODO add your handling code here:

        new CommunityAdminViewPanel().addHospital();
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("communityAdminViewPanel", new CommunityAdminViewPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_addHospitalButtonActionPerformed

    private void deleteHospitalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteHospitalButtonActionPerformed
        // TODO add your handling code here:
        new CommunityAdminViewPanel().deleteHospital();
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("communityAdminViewPanel", new CommunityAdminViewPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_deleteHospitalButtonActionPerformed

    private void addHouseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHouseButtonActionPerformed
        // TODO add your handling code here:
        new CommunityAdminViewPanel().addHouse();
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("communityAdminViewPanel", new CommunityAdminViewPanel());
        cardLayout.next(viewPanel);

    }//GEN-LAST:event_addHouseButtonActionPerformed

    private void deleteHouseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteHouseButtonActionPerformed
        // TODO add your handling code here:
        new CommunityAdminViewPanel().deleteHouseID();
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("communityAdminViewPanel", new CommunityAdminViewPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_deleteHouseButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("personPanel", new PersonPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_profileButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        new LoginJFrame().show();
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        new SystemAdminJFrame().show();
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CommunityAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommunityAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommunityAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommunityAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommunityAdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHospitalButton;
    private javax.swing.JButton addHouseButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteHospitalButton;
    private javax.swing.JButton deleteHouseButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel operationsPanel;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton viewDetailsButton;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
