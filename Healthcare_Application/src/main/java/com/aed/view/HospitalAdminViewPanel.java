/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.aed.view;

import com.aed.aedlab2.AedLab2;
import com.aed.model.Community;
import com.aed.model.Docter;
import com.aed.model.Hospital;
import com.aed.model.Person;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author yashpawar
 */
public class HospitalAdminViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form HospitalAdminViewPanel
     */
    Hospital hs;

    //List<Integer> docIds;
    public HospitalAdminViewPanel() {
        initComponents();
        hospitalCityField.setEditable(false);
        updateButton.setForeground(Color.white);

//        for (Map.Entry<Integer, Hospital> set
//                : AedLab2.hospitalMap.entrySet()) {
//            if(set.getValue().getPersonId() == LoginJFrame.loggedInPerson.getPersonID())
//                hs=set.getValue();
//        }
        for (Hospital set : AedLab2.hospitalMap.values()) {
            if (set.getPersonId() == LoginJFrame.loggedInPerson.getPersonID()) {
                hs = set;
            }
        }
        
            setValues(hs);
        
    }

    public void setValues(Hospital hs) {
        hospitalNameField.setText(hs.getName());
        hospitalCityField.setText(hs.getCity());
        System.out.println("namefield value before setting:" + nameField.getText());
        nameField.setText(LoginJFrame.loggedInPerson.getName());
        System.out.println("namefield value after setting:" + nameField.getText());
        userNameField.setText(LoginJFrame.loggedInPerson.getUserName());
        passwordField.setText(LoginJFrame.loggedInPerson.getPassword());
        ageField.setText(String.valueOf(LoginJFrame.loggedInPerson.getAge()));
        for (Integer i : hs.getCommunityId()) {
            //comboBox.add(AedLab2.communityMap.get(i).getName());
            communityIdComboBox.addItem(AedLab2.communityMap.get(i).getName());
        }
        for (Integer i : hs.getDocterId()) {
            //comboBox.add(AedLab2.personMap.get(AedLab2.docterMap.get(i).getPersonId()).getName());
            docterIdComboBox.addItem(AedLab2.personMap.get(AedLab2.docterMap.get(i).getPersonId()).getName());
        }
    }

    public void update() {

    }

    public void deleteDocter() {
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "current Docter Id from dropbox will be deleted",
                "Are you sure to delete the current value?",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            for (Person p : AedLab2.personMap.values()) {
                if (p.getName().equals(docterIdComboBox.getSelectedItem().toString())) {
                    for (Docter d : AedLab2.docterMap.values()) {
                        if (d.getPersonId() == p.getPersonID()) {
                            System.out.println("doctor hospital list before:" + d.getHospitalId());
                            //remove hospital from doctor and save doctor to directory
                            d.setHospitalId(utility.UtilityFunctions.removeIntFromList(
                                    d.getHospitalId(), hs.getHospitalId()));
                            AedLab2.docterMap.replace(d.getDocterId(), d);
                            System.out.println("doctor hospital list before:" + d.getHospitalId());

                            System.out.println("hospital doctor list before:" + hs.getDocterId());
                            //remove doctor from hospital and save hospital to directory
                            hs.setDocterId(utility.UtilityFunctions.removeIntFromList(
                                    hs.getDocterId(), d.getDocterId()));
                            AedLab2.hospitalMap.replace(hs.getHospitalId(), hs);
                            System.out.println("hospital doctor list after:" + hs.getDocterId());
                        }//if
                    }//for
                }
            }//for
            JOptionPane.showMessageDialog(this, "Docter deleted");
            setValues(hs);
        }

    }

    public void deleteCommunity() {
        
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "current Community Id from dropbox will be deleted",
                "Are you sure to delete the current value?",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            for (Community d : AedLab2.communityMap.values()) {
                if (d.getName().equals(communityIdComboBox.getSelectedItem().toString())) {
                    //remove hospital from community and save community to directorys
                    d.setHospitalId(utility.UtilityFunctions.removeIntFromList(
                            d.getHospitalId(), hs.getHospitalId()));
                    AedLab2.communityMap.replace(d.getCommunityId(), d);

                    //remove community from hospital and save community    
                    hs.setCommunityId(utility.UtilityFunctions.removeIntFromList(
                            hs.getCommunityId(), d.getCommunityId()));
                    AedLab2.hospitalMap.replace(hs.getHospitalId(), hs);
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Community deleted");
        setValues(hs);
    }

    public void addCommunity() {

        String com = "";
        int id;
        //get list of communities which are not in Hospital h
        for (Community c : AedLab2.communityMap.values()) {
            if (!hs.getCommunityId().contains(c.getCommunityId())) {
                com += c.getName() + ",";
            }
        }
        String search = JOptionPane.showInputDialog(String.format("Communities:[%s]\nPlease enter Community Name", com));

        for (Community c : AedLab2.communityMap.values()) {
            if (search.equalsIgnoreCase(c.getName())) {
                //add community to hospital and update directory
                hs.setCommunityId(utility.UtilityFunctions.addInttoList(
                        hs.getCommunityId(), c.getCommunityId()));
                AedLab2.hospitalMap.replace(hs.getHospitalId(), hs);

                //add hospital to community and update community checklist
                AedLab2.communityMap.get(c.getCommunityId()).setHospitalId(
                        utility.UtilityFunctions.addInttoList(
                                AedLab2.communityMap.get(c.getCommunityId()).getHospitalId(), hs.getHospitalId()));

            }
        }
        JOptionPane.showMessageDialog(this, "Community added");

    }

    public void addDocter() {
//        int selectedOption = JOptionPane.showConfirmDialog(null,
//                "current Docter Id from dropbox will be added",
//                "Are you sure to add the current value?",
//                JOptionPane.YES_NO_OPTION);
//        if (selectedOption == JOptionPane.NO_OPTION){
//            docterIdComboBox.removeAllItems();
//            JOptionPane.showMessageDialog(this, "Please select Docter from dropdown");
//            for (Docter i : AedLab2.docterMap.values()) {
//            System.out.println("hospital docter ID"+hs.getDocterId());
//            //comboBox.add(AedLab2.personMap.get(AedLab2.docterMap.get(i).getPersonId()).getName());
//            if (!hs.getDocterId().contains(i.getDocterId())) {
//                System.out.println("docter ID other than hospital id"+i.getDocterId());
//                docterIdComboBox.addItem(AedLab2.personMap.get(i.getPersonId()).getName());
//            }
//        }
//            return false;
//        }
//        else if (selectedOption == JOptionPane.YES_OPTION) {
//            Docter d = null;
//            for (Person p : AedLab2.personMap.values()) {
//                System.out.print("person name:"+p.getName()+" Comboboxvalue="+docterIdComboBox.getSelectedItem().toString());
//                if (p.getName().equals(docterIdComboBox.getSelectedItem().toString())) {
//                    d = (Docter)AedLab2.docterMap.entrySet().stream().filter(e -> e.getValue().getPersonId() == p.getPersonID())
//                            .map(Map.Entry::getValue).findFirst().get();
//                    System.out.println("Selected item="+docterIdComboBox.getSelectedItem().toString());
//                    System.out.println("docter name"+AedLab2.personMap.get(d.getPersonId()).getName());
//                }
//            }
//            d.setHospitalId(utility.UtilityFunctions.addInttoList(
//                    d.getHospitalId(), hs.getHospitalId()));
//
//            //add docter in hospital
//            hs.setDocterId(utility.UtilityFunctions.addInttoList(
//                    hs.getDocterId(), d.getDocterId()));
//            //add that doc to hospital
//            AedLab2.hospitalMap.replace(hs.getHospitalId(), hs);
//            JOptionPane.showMessageDialog(this, "Docter added");
//            return true;
//        }
//       return false; 
        String docs = "";
        for (Docter i : AedLab2.docterMap.values()) {
            System.out.println("hospital docter ID" + hs.getDocterId());
            //comboBox.add(AedLab2.personMap.get(AedLab2.docterMap.get(i).getPersonId()).getName());
            if (!hs.getDocterId().contains(i.getDocterId())) {
                System.out.println("docter ID other than hospital id" + i.getDocterId());
                //docterIdComboBox.addItem(AedLab2.personMap.get(i.getPersonId()).getName());
                docs = docs + AedLab2.personMap.get(AedLab2.docterMap.get(i.getDocterId()).getPersonId()).getName() + ",";
            }
        }
        System.out.println(docs);
        Docter d = null;
        //String search = JOptionPane.showInputDialog("Available Doctors:[%s]\nPlease enter Docter Name to Search",docs);
        String search = JOptionPane.showInputDialog(String.format("Doctors:[%s]\nPlease enter Docter Name", docs));
        for (Person p : AedLab2.personMap.values()) {
            //System.out.print("person name:" + p.getName() + " Comboboxvalue=" + docterIdComboBox.getSelectedItem().toString());
            if (p.getName().equalsIgnoreCase(search)) {
                for (Docter d1 : AedLab2.docterMap.values()) {
                    if (d1.getPersonId() == p.getPersonID()) {
                        d = d1;
                    }
                }
                //System.out.println("Selected item=" + docterIdComboBox.getSelectedItem().toString());
                //System.out.println("docter name" + AedLab2.personMap.get(d.getPersonId()).getName());
            }
        }
        //add docter in hospital
        hs.setDocterId(utility.UtilityFunctions.addInttoList(
                hs.getDocterId(), d.getDocterId()));
        System.out.println("Adding doctor to Hospital with docter ID:" + d.getDocterId() + "\nhospital doctor ids:" + hs.getDocterId());
        //add that hospital to hospital directory
        AedLab2.hospitalMap.replace(hs.getHospitalId(), hs);

        //add hospital to doctor 
        d.setHospitalId(utility.UtilityFunctions.addInttoList(
                d.getHospitalId(), hs.getHospitalId()));
        //add doctor to doctor directory
        AedLab2.docterMap.replace(d.getDocterId(), d);
        JOptionPane.showMessageDialog(this, "Docter added");

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
        hospitalNameField = new javax.swing.JTextField();
        hospitalCityField = new javax.swing.JTextField();
        communityIdComboBox = new javax.swing.JComboBox<>();
        docterIdComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        userNameField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();

        jLabel1.setText("Hospital Name:");

        jLabel3.setText("Hospital City:");

        jLabel4.setText("Commuity Ids:");

        jLabel5.setText("Docter Ids:");

        hospitalCityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hospitalCityFieldActionPerformed(evt);
            }
        });

        communityIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                communityIdComboBoxActionPerformed(evt);
            }
        });

        docterIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docterIdComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Age:");

        jLabel7.setText("User Name:");

        jLabel8.setText("Password:");

        jLabel9.setText("Name:");

        ageField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ageFieldKeyPressed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(communityIdComboBox, 0, 110, Short.MAX_VALUE)
                    .addComponent(hospitalCityField)
                    .addComponent(docterIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hospitalNameField)
                    .addComponent(ageField)
                    .addComponent(passwordField)
                    .addComponent(userNameField)
                    .addComponent(nameField))
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hospitalNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hospitalCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(communityIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(docterIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hospitalCityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hospitalCityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hospitalCityFieldActionPerformed

    private void communityIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_communityIdComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_communityIdComboBoxActionPerformed

    private void docterIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docterIdComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docterIdComboBoxActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        if (hospitalNameField.getText().isEmpty() || hospitalCityField.getText().isEmpty()
                || nameField.getText().isEmpty() || userNameField.getText().isEmpty()
                || passwordField.getText().isEmpty() || ageField.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Please Enter All Fields");
        else {
            hs.setName(hospitalNameField.getText());
            //update hospital
            AedLab2.hospitalMap.replace(hs.getHospitalId(), hs);
            System.out.println("namefield value before setting:" + nameField.getText());
            System.err.println("NameField Value:" + nameField.getText());
            LoginJFrame.loggedInPerson.setName(nameField.getText());
            System.out.println("NameField value of login person:" + LoginJFrame.loggedInPerson.getName());
            LoginJFrame.loggedInPerson.setUserName(userNameField.getText());
            LoginJFrame.loggedInPerson.setPassword(passwordField.getText());
            LoginJFrame.loggedInPerson.setAge(Integer.parseInt(ageField.getText()));
            //update admin
            AedLab2.personMap.replace(LoginJFrame.loggedInPerson.getPersonID(), LoginJFrame.loggedInPerson);
            JOptionPane.showMessageDialog(this, "Data Updated");
            new HospitalAdminViewPanel();
        }//validation else
    }//GEN-LAST:event_updateButtonActionPerformed

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
    private javax.swing.JTextField ageField;
    private javax.swing.JComboBox<String> communityIdComboBox;
    private javax.swing.JComboBox<String> docterIdComboBox;
    private javax.swing.JTextField hospitalCityField;
    private javax.swing.JTextField hospitalNameField;
    private javax.swing.JLabel jLabel1;
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
    // End of variables declaration//GEN-END:variables
}
