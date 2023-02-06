/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.aed.view;

import com.aed.aedlab2.AedLab2;
import static com.aed.aedlab2.AedLab2.hospitalId;
import com.aed.model.Community;
import com.aed.model.Hospital;
import com.aed.model.House;
import com.aed.model.Person;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author yashpawar
 */
public class CommunityAdminViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form CommunityAdminViewPanel
     */
    Community cm = null;

    public CommunityAdminViewPanel() {
        initComponents();
        
                updateButton.setForeground(Color.white);
                createButton.setForeground(Color.white);
        for (Community set : AedLab2.communityMap.values()) {
            if (LoginJFrame.loggedInPerson.getRole().equals("SYSTEMADMIN")) {
                if (set.getPersonId() == AdminViewDoctersPanel.p.getPersonID()) {
                    System.out.println("community admin selected:"+AdminViewDoctersPanel.p.getName()+
                            " community admin loop: "+AedLab2.personMap.get(set.getPersonId()).getName());
                    cm = set;
                }
            } else if (set.getPersonId() == LoginJFrame.loggedInPerson.getPersonID()) {
                cm = set;
            }//else
        }//for
       if(LoginJFrame.loggedInPerson.getRole().equals("SYSTEMADMIN")){
            createButton.setVisible(true);
        }
        else{
            createButton.setVisible(false);
        }
        setValues(cm);

    }

    void setValues(Community cm) {
        nameField.setText(AedLab2.personMap.get(cm.getPersonId()).getName());
        userNameField.setText(AedLab2.personMap.get(cm.getPersonId()).getUserName());
        passwordField.setText(AedLab2.personMap.get(cm.getPersonId()).getPassword());
        ageField.setText(String.valueOf(AedLab2.personMap.get(cm.getPersonId()).getAge()));
        communityNameField.setText(cm.getName());
        communityCityField.setText(cm.getCity());
        zipcodeField.setText(cm.getZipcode());
        for (Integer i : cm.getHospitalId()) {
            //comboBox.add(AedLab2.communityMap.get(i).getName());
            hospitalIdComboBox.addItem(AedLab2.hospitalMap.get(i).getName());
        }
        for (Integer i : cm.getHouseId()) {
            //comboBox.add(AedLab2.communityMap.get(i).getName());
            houseIdComboBox.addItem(i);
        }
    }

    public void deleteHospital() {
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "current Hospital Id from dropbox will be deleted",
                "Are you sure to delete the current value?",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {

            for (Hospital h : AedLab2.hospitalMap.values()) {
                if (h.getName().equals(hospitalIdComboBox.getSelectedItem().toString())) {
                    //remove hospital from community
                    cm.setHospitalId(utility.UtilityFunctions.removeIntFromList(
                            cm.getHospitalId(), h.getHospitalId()));
                    //update community in Map
                    AedLab2.communityMap.replace(cm.getCommunityId(), cm);

                    //remove community from hospital
                    h.setCommunityId(utility.UtilityFunctions.removeIntFromList(
                            h.getCommunityId(), cm.getCommunityId()));
                    //update hospital in Map
                    AedLab2.hospitalMap.replace(h.getHospitalId(), h);

                }
            }

            JOptionPane.showMessageDialog(this, "Hospital Removed");
            setValues(cm);
        }

    }

    public void deleteHouseID() {
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "current Hospital Id from dropbox will be deleted",
                "Are you sure to delete the current value?",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            for (House h : AedLab2.houseMap.values()) {
                if (String.valueOf(h.getHouseId()).equalsIgnoreCase(houseIdComboBox.getSelectedItem().toString())) {

                    cm.setHouseId(utility.UtilityFunctions.removeIntFromList(
                            cm.getHouseId(), h.getHouseId()));
                    AedLab2.communityMap.replace(cm.getCommunityId(), cm);
                }
            }
            JOptionPane.showMessageDialog(this, "House Removed");
            setValues(cm);
        }

    }

    public void addHospital() {
        String hos = "";
//        hospitalIdComboBox.removeAllItems();
//        DefaultComboBoxModel model = new DefaultComboBoxModel();
//        for(Hospital h : AedLab2.hospitalMap.values())
//            if(!cm.getHospitalId().contains(h.getHospitalId()))
//                model.addElement(h.getName());
//        hospitalIdComboBox.setModel(model);
//        System.out.println("Model="+model);
        for (Hospital h : AedLab2.hospitalMap.values()) {
            for (Integer i : cm.getHospitalId()) {
                if (!cm.getHospitalId().contains(h.getHospitalId())) {
                    if (!hos.contains(h.getName())) {
                        hos += h.getName() + ", ";
                    }
                }
            }
        }

        String m = JOptionPane.showInputDialog("Hospitals:" + hos + "\nPlease select");
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Are you sure to add the current value?",
                "Please check",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            for (Hospital h : AedLab2.hospitalMap.values()) {
                if (h.getName().equalsIgnoreCase(m)) {
                    //remove hospital from community
                    cm.setHospitalId(utility.UtilityFunctions.addInttoList(
                            cm.getHospitalId(), h.getHospitalId()));
                    //update community in Map
                    AedLab2.communityMap.replace(cm.getCommunityId(), cm);
                    //System.out.println("Community added"+m);
                    //remove community from hospital
                    h.setCommunityId(utility.UtilityFunctions.addInttoList(
                            h.getCommunityId(), cm.getCommunityId()));
                    //update hospital in Map
                    AedLab2.hospitalMap.replace(h.getHospitalId(), h);

                }
            }

            JOptionPane.showMessageDialog(this, "Hospital added");
            setValues(cm);
        }
    }

    public void addHouse() {
//        houseIdComboBox.removeAllItems();
//        for (House h : AedLab2.houseMap.values()) {
//            if (!cm.getHouseId().contains(h.getHouseId())) {
//                hospitalIdComboBox.addItem(String.valueOf(h.getHouseId()));
//            }
//        }
//
//        int selectedOption = JOptionPane.showConfirmDialog(null,
//                "current Hospital Id from dropbox will be added",
//                "Are you sure to add the current value?",
//                JOptionPane.YES_NO_OPTION);
//        if (selectedOption == JOptionPane.YES_OPTION) {
//            for (House h : AedLab2.houseMap.values()) {
//                if (String.valueOf(h.getHouseId()).equalsIgnoreCase(houseIdComboBox.getSelectedItem().toString())) {
//
//                    cm.setHouseId(utility.UtilityFunctions.addInttoList(
//                            cm.getHouseId(), h.getHouseId()));
//                    AedLab2.communityMap.replace(cm.getCommunityId(), cm);
//                }
//            }
//            JOptionPane.showMessageDialog(this, "House added");
//            setValues(cm);
//        }

        String hos = "";
        for (House h : AedLab2.houseMap.values()) {
            if (!cm.getHouseId().contains(h.getHouseId())) {
                if (!hos.contains(String.valueOf(h.getHouseId()))) {
                    hos += h.getHouseId() + ", ";
                }
            }
        }

        String m = JOptionPane.showInputDialog("House:" + hos + "\nPlease select");
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "entered Hospital Id will be added",
                "Are you sure to add the current value?",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            for (House h : AedLab2.houseMap.values()) {
                if (String.valueOf(h.getHouseId()).equalsIgnoreCase(m)) {

                    cm.setHouseId(utility.UtilityFunctions.addInttoList(
                            cm.getHouseId(), h.getHouseId()));
                    AedLab2.communityMap.replace(cm.getCommunityId(), cm);
                }
            }
            JOptionPane.showMessageDialog(this, "House added");
            setValues(cm);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        communityNameField = new javax.swing.JTextField();
        communityCityField = new javax.swing.JTextField();
        hospitalIdComboBox = new javax.swing.JComboBox<>();
        houseIdComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        userNameField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        zipcodeField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();

        jLabel1.setText("Community Name:");

        jLabel3.setText("Community City:");

        jLabel4.setText("Hospital Ids:");

        jLabel5.setText("House Ids:");

        communityCityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                communityCityFieldActionPerformed(evt);
            }
        });

        hospitalIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalIdComboBoxActionPerformed(evt);
            }
        });

        houseIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseIdComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Age:");

        jLabel7.setText("User Name:");

        jLabel8.setText("Password:");

        jLabel9.setText("Name:");

        ageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageFieldActionPerformed(evt);
            }
        });
        ageField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ageFieldKeyPressed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        updateButton.setText("Update Admin");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Zipcode");

        createButton.setText("Create Community");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hospitalIdComboBox, 0, 110, Short.MAX_VALUE)
                    .addComponent(communityCityField)
                    .addComponent(houseIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(communityNameField)
                    .addComponent(ageField)
                    .addComponent(passwordField)
                    .addComponent(userNameField)
                    .addComponent(nameField)
                    .addComponent(zipcodeField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(communityNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(communityCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hospitalIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(houseIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void communityCityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_communityCityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_communityCityFieldActionPerformed

    private void hospitalIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalIdComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hospitalIdComboBoxActionPerformed

    private void houseIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseIdComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_houseIdComboBoxActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    public boolean validation() {
        if (nameField.getText().isEmpty() || userNameField.getText().isEmpty()
                || passwordField.getText().isEmpty() || ageField.getText().isEmpty()
                || communityCityField.getText().isEmpty() || communityNameField.getText().isEmpty()
                || zipcodeField.getText().isEmpty()) {
            return true;
        }
        return false;
    }
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        if(validation())
            JOptionPane.showMessageDialog(this, "Please Enter All fields");
        else if (Integer.parseInt(ageField.getText()) < 20 || Integer.parseInt(ageField.getText()) > 100) 
                JOptionPane.showMessageDialog(this, "Age not between 20 and 100");
        else{
        cm.setName(communityNameField.getText());
        cm.setCity(communityCityField.getText());
        cm.setZipcode(zipcodeField.getText());

        //update Community
        AedLab2.communityMap.replace(cm.getCommunityId(), cm);
        LoginJFrame.loggedInPerson.setName(nameField.getText());
        LoginJFrame.loggedInPerson.setUserName(userNameField.getText());
        LoginJFrame.loggedInPerson.setPassword(passwordField.getText());
        LoginJFrame.loggedInPerson.setAge(Integer.parseInt(ageField.getText()));
        //update admin
        AedLab2.personMap.replace(LoginJFrame.loggedInPerson.getPersonID(), LoginJFrame.loggedInPerson);
        JOptionPane.showMessageDialog(this, "Data Updated");
        new CommunityAdminViewPanel();
        }//validation else
    }//GEN-LAST:event_updateButtonActionPerformed

    private void ageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void ageFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c==' ') {
            ageField.setEditable(false);
            JOptionPane.showMessageDialog(this, "Age should be a number");
        } else {
        }
        ageField.setEditable(true);
    }//GEN-LAST:event_ageFieldKeyPressed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        //System.err.print("In community create button");
        //add person first
       Person p= AedLab2.personMap.put(AedLab2.personId, new Person(AedLab2.personId++, nameField.getText(),
                userNameField.getText(), passwordField.getText(), "COMMUNITYADMIN",Integer.parseInt(ageField.getText()), "MALE", "", 502));
        System.err.print("name added to person map"+p.getName());
        // add community
        AedLab2.communityMap.put(AedLab2.communityId, new Community(AedLab2.communityId++,
                communityNameField.getText(), communityCityField.getText(), zipcodeField.getText(), Arrays.asList(502),
                Arrays.asList(304), (AedLab2.personId-1)));
        //add community to hospital
        AedLab2.hospitalMap.get(304).setCommunityId(
                utility.UtilityFunctions.addInttoList(AedLab2.hospitalMap.get(304).getCommunityId(), (AedLab2.communityId-1)));
        JOptionPane.showMessageDialog(this, "Community Added");
    }//GEN-LAST:event_createButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private javax.swing.JTextField communityCityField;
    private javax.swing.JTextField communityNameField;
    private javax.swing.JButton createButton;
    private javax.swing.JComboBox<String> hospitalIdComboBox;
    public static javax.swing.JComboBox<Integer> houseIdComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField userNameField;
    private javax.swing.JTextField zipcodeField;
    // End of variables declaration//GEN-END:variables
}
