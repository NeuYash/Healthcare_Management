/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aed.view;

import java.awt.CardLayout;
import java.awt.Color;

/**
 *
 * @author yashpawar
 */
public class HospitalAdminJFrame extends javax.swing.JFrame {

    /**
     * Creates new form HospitalAdminJFrame
     */
    CardLayout cardLayout;
    public HospitalAdminJFrame() {
        initComponents();
        
        //profileButton.setVisible(false);
        
        logoutButton.setForeground(Color.white);
        viewDetailsButton.setForeground(Color.white);
        addCommunityButton.setForeground(Color.white);
        deleteCommunityButton.setForeground(Color.white);
        addDocterButton.setForeground(Color.white);
        deleteDocterButton.setForeground(Color.white);
        profileButton.setForeground(Color.white);
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("hospitalAdminViewJPanel", new HospitalAdminViewPanel());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        hospitalTable = new javax.swing.JTable();
        viewPanel = new javax.swing.JPanel();
        operationsPanel = new javax.swing.JPanel();
        viewDetailsButton = new javax.swing.JButton();
        addCommunityButton = new javax.swing.JButton();
        deleteCommunityButton = new javax.swing.JButton();
        addDocterButton = new javax.swing.JButton();
        deleteDocterButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        hospitalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(hospitalTable);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewPanel.setLayout(new java.awt.CardLayout());

        operationsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        viewDetailsButton.setText("View Details");
        viewDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsButtonActionPerformed(evt);
            }
        });

        addCommunityButton.setText("Add Community");
        addCommunityButton.setToolTipText("");
        addCommunityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCommunityButtonActionPerformed(evt);
            }
        });

        deleteCommunityButton.setText("Delete Community");
        deleteCommunityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCommunityButtonActionPerformed(evt);
            }
        });

        addDocterButton.setText("Add Docter");
        addDocterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocterButtonActionPerformed(evt);
            }
        });

        deleteDocterButton.setText("Delete Docter");
        deleteDocterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDocterButtonActionPerformed(evt);
            }
        });

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
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
                            .addComponent(addCommunityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteCommunityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addDocterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteDocterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        operationsPanelLayout.setVerticalGroup(
            operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operationsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(viewDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addCommunityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteCommunityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addDocterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deleteDocterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        logoutButton.setText("Logout");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(operationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(operationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addCommunityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCommunityButtonActionPerformed
        // TODO add your handling code here:
        new HospitalAdminViewPanel().addCommunity();
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("hospitalAdminViewJPanel", new HospitalAdminViewPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_addCommunityButtonActionPerformed

    private void viewDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsButtonActionPerformed
        // TODO add your handling code here:
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("hospitalAdminViewJPanel", new HospitalAdminViewPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_viewDetailsButtonActionPerformed

    private void addDocterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocterButtonActionPerformed
        // TODO add your handling code here:
        new HospitalAdminViewPanel().addDocter();
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("hospitalAdminViewJPanel", new HospitalAdminViewPanel());
        cardLayout.next(viewPanel);

    }//GEN-LAST:event_addDocterButtonActionPerformed

    private void deleteDocterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDocterButtonActionPerformed
        // TODO add your handling code here:
       
        new HospitalAdminViewPanel().deleteDocter();
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("hospitalAdminViewJPanel", new HospitalAdminViewPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_deleteDocterButtonActionPerformed

    private void deleteCommunityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCommunityButtonActionPerformed
        // TODO add your handling code here:
        
        new HospitalAdminViewPanel().deleteCommunity();
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("hospitalAdminViewJPanel", new HospitalAdminViewPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_deleteCommunityButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
        cardLayout = (CardLayout) (viewPanel.getLayout());
        viewPanel.add("PersonPanel", new PersonPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_profileButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        new LoginJFrame().show();
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(HospitalAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HospitalAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HospitalAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HospitalAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HospitalAdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCommunityButton;
    private javax.swing.JButton addDocterButton;
    private javax.swing.JButton deleteCommunityButton;
    private javax.swing.JButton deleteDocterButton;
    private javax.swing.JTable hospitalTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel operationsPanel;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton viewDetailsButton;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
