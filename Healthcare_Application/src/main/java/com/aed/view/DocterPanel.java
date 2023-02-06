/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.aed.view;

import com.aed.aedlab2.AedLab2;
import com.aed.model.Docter;
import com.aed.model.Encounter;
import com.aed.model.Hospital;
import com.aed.model.Person;
import com.aed.model.VitalSigns;
import java.awt.Color;
import static java.awt.Frame.NORMAL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yashpawar
 */
public class DocterPanel extends javax.swing.JPanel {

    /**
     * Creates new form DocterPanel
     */
    Person per = null;
    Encounter enc = null;
    int hosTable = 1;

    public DocterPanel() {
        initComponents();

        addDocterButton.setForeground(Color.white);
        updateEncounterButton.setForeground(Color.white);
        updateProfileButton.setForeground(Color.white);
        resetButton.setForeground(Color.white);
        deleteDocterButton.setForeground(Color.white);

        if (LoginJFrame.loggedInPerson.getRole().equals("DOCTER")) {
            per = LoginJFrame.loggedInPerson;
        } else {
            per = AdminViewDoctersPanel.p;
        }
        setProfile();
        setEncounterTable();
        if (SystemAdminJFrame.ad.equals("SYSTEMADMIN")) {
            //addDocterButton.setVisible(true);
            deleteDocterButton.setVisible(true);
            addDocterButton.setVisible(true);
        } else {
            //addDocterButton.setVisible(false);
            deleteDocterButton.setVisible(false);
            addDocterButton.setVisible(false);
        }
        hospitalNameField.setEditable(false);
        statusComboBox.addItem("ACCEPTED");
        statusComboBox.addItem("PENDING");
        statusComboBox.addItem("REJECTED");
    }

    void setProfile() {
        profileNameField.setText(per.getName());
        profileUserNameField.setText(per.getUserName());
        profilePasswordField.setText(per.getPassword());
        profileAgeField.setText(String.valueOf(per.getAge()));

        if (per.getGender().equalsIgnoreCase(genderComboBox.getItemAt(0))) {
            genderComboBox.setSelectedItem("MALE");
        } else {
            genderComboBox.setSelectedItem("FEMALE");
        }
        for (Docter d : AedLab2.docterMap.values()) {
            if (d.getPersonId() == per.getPersonID()) {
                for (Integer i : d.getHospitalId()) {
                    profileHospitalComboBox.addItem(AedLab2.hospitalMap.get(i).getName());
                }
            }
        }
    }

    void resetAction() {
        hospitalNameField.setText("");
        dateField.setText("");
        remarkField.setText("");
        temperatureField.setText("");
        bloodPressureField.setText("");
        heartRateField.setText("");
        setEncounterTable();
    }

    String giveCommunity(int hospitalID) {
        String hos = "";
        for (Hospital h : AedLab2.hospitalMap.values()) {
            if (h.getHospitalId() == hospitalID) {
                for (Integer i : h.getCommunityId()) {
                    hos += AedLab2.communityMap.get(i).getName() + ", ";
                }
            }
        }
        return hos;
    }

    String giveDoctor(int hospitalID) {
        String hos = "";
        for (Hospital h : AedLab2.hospitalMap.values()) {
            if (h.getHospitalId() == hospitalID) {
                for (Integer i : h.getDocterId()) {
                    hos += AedLab2.personMap.get(AedLab2.docterMap.get(i).getPersonId()).getName() + ", ";
                }
            }
        }
        return hos;
    }

    void sethospitalTable() {
        int rIndex = 0;
        String[][] data = new String[AedLab2.hospitalMap.size()][5];
        for (Hospital e
                : AedLab2.hospitalMap.values()) {
            data[rIndex][0] = String.valueOf(e.getHospitalId());
            data[rIndex][1] = e.getName();
            data[rIndex][2] = e.getCity();
            data[rIndex][3] = giveCommunity(e.getHospitalId());
            data[rIndex][4] = giveDoctor(e.getHospitalId());
            //StringUtils.join(<List>, "|");
            rIndex++;
        }

        String[] col = {"ID", "HospitalName", "City", "Community", "Docters"};
        DefaultTableModel model = new DefaultTableModel(data, col);
        encounterTable.setModel(model);
        hosTable = 0;
    }

    void setEncounterTable() {
        Map<Integer, Encounter> en = new HashMap<>();
        for (Encounter e : AedLab2.encounterMap.values()) {
            if (AedLab2.docterMap.get(e.getDoctorId()).getPersonId() == per.getPersonID()) {
                en.put(e.getHospitalId(), e);
            }
        }

        int rIndex = 0;

        String[][] data = new String[en.size()][6];
        for (Encounter e
                : en.values()) {
            data[rIndex][0] = String.valueOf(e.getEncounterID());
            data[rIndex][1] = AedLab2.personMap.get(AedLab2.patientMap.get(e.getPatientId()).getPersonId()).getName();
            data[rIndex][2] = e.getDateOfEncounter();
            data[rIndex][3] = e.getStatus();
            data[rIndex][4] = e.getRemark();
            //StringUtils.join(<List>, "|");
            data[rIndex][5] = AedLab2.hospitalMap.get(e.getHospitalId()).getName();
            rIndex++;
        }

        String[] col = {"ID", "PatientName", "Date", "Status", "Remark", "HospitalName"};
        DefaultTableModel model = new DefaultTableModel(data, col);
        encounterTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPanel = new javax.swing.JPanel();
        operationsLayout = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        updateProfileButton = new javax.swing.JButton();
        updateEncounterButton = new javax.swing.JButton();
        addDocterButton = new javax.swing.JButton();
        deleteDocterButton = new javax.swing.JButton();
        detailsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hospitalNameField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        heartRateField = new javax.swing.JTextField();
        temperatureField = new javax.swing.JTextField();
        bloodPressureField = new javax.swing.JTextField();
        statusComboBox = new javax.swing.JComboBox<>();
        remarkField = new javax.swing.JTextField();
        profilePanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        profileNameField = new javax.swing.JTextField();
        profileUserNameField = new javax.swing.JTextField();
        profilePasswordField = new javax.swing.JTextField();
        profileAgeField = new javax.swing.JTextField();
        profileHospitalComboBox = new javax.swing.JComboBox<>();
        genderComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        encounterTable = new javax.swing.JTable();

        operationsLayout.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        updateProfileButton.setText("Update Profile");
        updateProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileButtonActionPerformed(evt);
            }
        });

        updateEncounterButton.setText("Update Encounter");
        updateEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEncounterButtonActionPerformed(evt);
            }
        });

        addDocterButton.setText("Create Docter");
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

        javax.swing.GroupLayout operationsLayoutLayout = new javax.swing.GroupLayout(operationsLayout);
        operationsLayout.setLayout(operationsLayoutLayout);
        operationsLayoutLayout.setHorizontalGroup(
            operationsLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, operationsLayoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(operationsLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateEncounterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateProfileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addDocterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteDocterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        operationsLayoutLayout.setVerticalGroup(
            operationsLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operationsLayoutLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(addDocterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteDocterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        detailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        jLabel1.setText("Hospital Name:");

        jLabel2.setText("Status:");

        jLabel3.setText("Date:");

        jLabel4.setText("Remark:");

        jLabel5.setText("Temperature:");

        jLabel6.setText("Blood Pressure:");

        jLabel7.setText("Heart Rate:");

        heartRateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                heartRateFieldKeyPressed(evt);
            }
        });

        temperatureField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                temperatureFieldKeyPressed(evt);
            }
        });

        bloodPressureField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodPressureFieldActionPerformed(evt);
            }
        });
        bloodPressureField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bloodPressureFieldKeyPressed(evt);
            }
        });

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACCEPTED", "PENDING", "REJECTED" }));

        remarkField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remarkFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateField)
                    .addComponent(heartRateField)
                    .addComponent(temperatureField)
                    .addComponent(bloodPressureField)
                    .addComponent(statusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(remarkField)
                    .addComponent(hospitalNameField))
                .addContainerGap())
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(hospitalNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(remarkField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(temperatureField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bloodPressureField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(heartRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        profilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        jLabel8.setText("Name:");

        jLabel9.setText("UserName:");

        jLabel10.setText("Password:");

        jLabel11.setText("Age:");

        jLabel12.setText("Gender:");

        jLabel13.setText("Hospital IDs:");

        profileNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileNameFieldActionPerformed(evt);
            }
        });

        profileAgeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileAgeFieldActionPerformed(evt);
            }
        });
        profileAgeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                profileAgeFieldKeyPressed(evt);
            }
        });

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderComboBox.setToolTipText("");

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(profileNameField)
                            .addComponent(profileUserNameField)
                            .addComponent(profilePasswordField)
                            .addComponent(profileAgeField)
                            .addComponent(profileHospitalComboBox, 0, 97, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(genderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(profileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(profileUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(profilePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(profileAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(profileHospitalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(operationsLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(operationsLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        encounterTable.setModel(new javax.swing.table.DefaultTableModel(
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
        encounterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encounterTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(encounterTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProfileButtonActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(profileAgeField.getText()) < 20 || Integer.parseInt(profileAgeField.getText()) > 100)
            JOptionPane.showMessageDialog(this, "Age not between 20 and 100");
        else {
            per.setName(profileNameField.getText());
            per.setUserName(profileUserNameField.getText());
            per.setPassword(profilePasswordField.getText());
            per.setAge(Integer.parseInt(profileAgeField.getText()));
            per.setGender(profileHospitalComboBox.getSelectedItem().toString());

            AedLab2.personMap.replace(per.getPersonID(), per);
            JOptionPane.showMessageDialog(this, "Profile Updated");
        }
    }//GEN-LAST:event_updateProfileButtonActionPerformed

    private void bloodPressureFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodPressureFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodPressureFieldActionPerformed

    private void remarkFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remarkFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remarkFieldActionPerformed

    private void profileNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileNameFieldActionPerformed

    private void profileAgeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileAgeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileAgeFieldActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        resetAction();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void encounterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encounterTableMouseClicked
        // TODO add your handling code here:
        if (hosTable == 0) {
            int id1 = Integer.parseInt(encounterTable.getValueAt(encounterTable.getSelectedRow(), NORMAL).toString());
            //added docter to hospital
            AedLab2.hospitalMap.get(id1).setDocterId(utility.UtilityFunctions.addInttoList(
                    AedLab2.hospitalMap.get(id1).getDocterId(), AedLab2.docterId));
            AedLab2.personMap.put(AedLab2.personId, new Person(AedLab2.personId++, profileNameField.getText(),
                    profileUserNameField.getText(), profilePasswordField.getText(),
                    "DOCTER", Integer.parseInt(profileAgeField.getText()),
                    profileHospitalComboBox.getSelectedItem().toString(), "", 501));

            AedLab2.docterMap.put(AedLab2.docterId, new Docter(AedLab2.docterId++, (AedLab2.personId - 1),
                    Arrays.asList(AedLab2.hospitalMap.get(id1).getHospitalId())));

            SystemAdminJFrame.peopleStatField.setText(String.valueOf(AedLab2.personMap.size()));
            SystemAdminJFrame.docterStatField.setText(String.valueOf(AedLab2.docterMap.size()));
            JOptionPane.showMessageDialog(this, "Hospital Added");
            hosTable = 1;
        } else {
            System.out.println("in encounter mouse click");
            int id = Integer.parseInt(encounterTable.getValueAt(encounterTable.getSelectedRow(), NORMAL).toString());
            enc = AedLab2.encounterMap.get(id);
            hospitalNameField.setText(AedLab2.hospitalMap.get(enc.getHospitalId()).getName());
            if (enc.getStatus().equalsIgnoreCase("ACCEPTED")) {
                statusComboBox.setSelectedItem("ACCEPTED");
            } else if (enc.getStatus().equalsIgnoreCase("PENDING")) {
                statusComboBox.setSelectedItem("PENDING");
            } else {
                statusComboBox.setSelectedItem("REJECTED");
            }

            dateField.setText(enc.getDateOfEncounter());
            remarkField.setText(enc.getRemark());
            temperatureField.setText(String.valueOf(AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).getTemperature()));
            bloodPressureField.setText(String.valueOf(AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).getBloodPressure()));
            heartRateField.setText(String.valueOf(AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).getHeartRate()));

        }
    }//GEN-LAST:event_encounterTableMouseClicked

    private void updateEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEncounterButtonActionPerformed
        // TODO add your handling code here:
        if (Double.parseDouble(temperatureField.getText()) < 50 || Double.parseDouble(temperatureField.getText()) > 200)
            JOptionPane.showMessageDialog(this, "Age not between 50 and 200");
        else if (Integer.parseInt(bloodPressureField.getText()) < 50 || Integer.parseInt(bloodPressureField.getText()) > 300)
            JOptionPane.showMessageDialog(this, "Age not between 50 and 300");
        else if (Integer.parseInt(heartRateField.getText()) < 50 || Integer.parseInt(heartRateField.getText()) > 200)
            JOptionPane.showMessageDialog(this, "Age not between 50 and 200");
        else if (hospitalNameField.getText().isEmpty() || temperatureField.getText().isEmpty()
                || bloodPressureField.getText().isEmpty() || heartRateField.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Please enter all details");
        else {
            VitalSigns v = new VitalSigns(enc.getVitalSignsId(),
                    Double.parseDouble(temperatureField.getText()),
                    Integer.parseInt(bloodPressureField.getText()),
                    Integer.parseInt(heartRateField.getText()));
            enc.setDateOfEncounter(dateField.getText());
            enc.setRemark(remarkField.getText());
            enc.setStatus(statusComboBox.getSelectedItem().toString());
            AedLab2.vitalSignsMap.replace(v.getVitalSignsId(), v);
            AedLab2.encounterMap.replace(enc.getEncounterID(), enc);
            JOptionPane.showMessageDialog(this, "Encounter Updated");

            setEncounterTable();
        }//validation else
    }//GEN-LAST:event_updateEncounterButtonActionPerformed

    private void deleteDocterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDocterButtonActionPerformed
        // TODO add your handling code here:
        Docter doc = null;
        Person p = null;
        int dontDelete = 0;
        for (Encounter e : AedLab2.encounterMap.values()) {
            if (AedLab2.docterMap.get(e.getDoctorId()).getPersonId() == per.getPersonID()) {
                if (e.getStatus().equalsIgnoreCase("PENDING")) {
                    dontDelete = 1;
                }
            }
        }
        if (dontDelete == 0) {
            for (Docter d : AedLab2.docterMap.values()) {
                if (per.getPersonID() == d.getPersonId()) {
                    p = per;
                    doc = d;
                    for (Hospital h : AedLab2.hospitalMap.values()) {
                        if (h.getDocterId().contains(d.getDocterId())) {
                            h.setDocterId(utility.UtilityFunctions.removeIntFromList(h.getDocterId(), d.getDocterId()));
                        }
                    }
//                AedLab2.docterMap.remove(d.getDocterId(), d);
//                AedLab2.personMap.remove(per.getPersonID(), per);
                }
            }
            AedLab2.docterMap.remove(doc.getDocterId(), doc);
            AedLab2.personMap.remove(p.getPersonID(), p);

            SystemAdminJFrame.peopleStatField.setText(String.valueOf(AedLab2.personMap.size()));
            SystemAdminJFrame.docterStatField.setText(String.valueOf(AedLab2.docterMap.size()));
            JOptionPane.showMessageDialog(this, "Docter Deleted");
        } else {
            JOptionPane.showMessageDialog(this, "Docter Has Pending Encounters\nhence cannot be deleted");
        }
    }//GEN-LAST:event_deleteDocterButtonActionPerformed

    private void temperatureFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_temperatureFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == ' ') {
            temperatureField.setEditable(false);
            JOptionPane.showMessageDialog(this, "Temperature should be a number");
        } else {
        }
        temperatureField.setEditable(true);
    }//GEN-LAST:event_temperatureFieldKeyPressed

    private void bloodPressureFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bloodPressureFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == ' ') {
            bloodPressureField.setEditable(false);
            JOptionPane.showMessageDialog(this, "BloodPressure should be a number");
        } else {
        }
        bloodPressureField.setEditable(true);
    }//GEN-LAST:event_bloodPressureFieldKeyPressed

    private void heartRateFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heartRateFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == ' ') {
            heartRateField.setEditable(false);
            JOptionPane.showMessageDialog(this, "Heart Rate should be a number");
        } else {
        }
        heartRateField.setEditable(true);
    }//GEN-LAST:event_heartRateFieldKeyPressed

    private void profileAgeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_profileAgeFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == ' ') {
            profileAgeField.setEditable(false);
            JOptionPane.showMessageDialog(this, "Age should be a number");
        } else {
        }
        profileAgeField.setEditable(true);
    }//GEN-LAST:event_profileAgeFieldKeyPressed

    private void addDocterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocterButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Please Select Hospital from Table");
        sethospitalTable();
    }//GEN-LAST:event_addDocterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDocterButton;
    private javax.swing.JTextField bloodPressureField;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton deleteDocterButton;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JTable encounterTable;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JTextField heartRateField;
    private javax.swing.JTextField hospitalNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel operationsLayout;
    private javax.swing.JTextField profileAgeField;
    private javax.swing.JComboBox<String> profileHospitalComboBox;
    private javax.swing.JTextField profileNameField;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JTextField profilePasswordField;
    private javax.swing.JTextField profileUserNameField;
    private javax.swing.JTextField remarkField;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JTextField temperatureField;
    private javax.swing.JButton updateEncounterButton;
    private javax.swing.JButton updateProfileButton;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
