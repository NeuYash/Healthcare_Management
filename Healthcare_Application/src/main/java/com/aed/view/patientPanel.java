/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.aed.view;

import com.aed.aedlab2.AedLab2;
import com.aed.model.Community;
import com.aed.model.Docter;
import com.aed.model.Encounter;
import com.aed.model.Hospital;
import com.aed.model.Patient;
import com.aed.model.Person;
import com.aed.model.VitalSigns;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yashpawar
 */
public class patientPanel extends javax.swing.JPanel {

    /**
     * Creates new form patientPanel
     */
    public static Person per = null;
    Patient pat = null;
    Encounter enc = null;
    CardLayout cardLayout;

    public Patient getpatient() {
        for (Patient p : AedLab2.patientMap.values()) {
            if (p.getPersonId() == per.getPersonID()) {
                return p;
            }
        }
        return null;
    }

    public void resetAction() {
        docterNameField.setText("");
        hospitalNameField.setText("");
        dateField.setText("");
        statusComboBox.removeAllItems();
        temperatureField.setText("");
        heartRateField.setText("");
        bloodPressureField.setText("");
        remarkField.setText("");
        statusComboBox.addItem("ACCEPTED");
        statusComboBox.addItem("PENDING");
        statusComboBox.addItem("REJECTED");
        statusComboBox.setEditable(true);
        docterNameField.setEditable(true);
        hospitalNameField.setEditable(true);
        enc = null;
        setEncounterTable(pat.getPatientId());

    }
    int hosTable, docTable = 0, updAction = 0;

    public patientPanel() {
        initComponents();

        addEncounterButton.setForeground(Color.white);
        updateEncounterButton.setForeground(Color.white);
        DeleteEncounterButton.setForeground(Color.white);
        resetButton.setForeground(Color.white);
        searchEncounterButton.setForeground(Color.white);

        if (!SystemAdminJFrame.ad.equals("SYSTEMADMIN")) {
            per = LoginJFrame.loggedInPerson;
            System.out.println("com.aed.view.patientPanel.<init>() : " + per.getName());
        } else if (SystemAdminJFrame.ad.equals("SYSTEMADMIN")) {
            per = AdminViewDoctersPanel.p;
        }
//        for(Patient p: AedLab2.patientMap.values())
//            if(p.getPersonId()== per.getPersonID())
//                pat=p;
        pat = getpatient();
        setEncounterTable(pat.getPatientId());

        updateEncounterButton.setEnabled(false);
        DeleteEncounterButton.setEnabled(false);
        updateEncounterButton.setVisible(false);
        DeleteEncounterButton.setVisible(false);
        statusComboBox.addItem("ACCEPTED");
        statusComboBox.addItem("PENDING");
        statusComboBox.addItem("REJECTED");
        if (SystemAdminJFrame.ad.equals("SYSTEMADMIN")) {
            updateEncounterButton.setVisible(true);
            DeleteEncounterButton.setVisible(true);
        }
    }

    public void setEncounterTable(Integer patid) {
        Map<Integer, Encounter> map = new HashMap<>();
        for (Encounter ec : AedLab2.encounterMap.values()) {
            if (ec.getPatientId() == patid) {
                map.put(ec.getEncounterID(), ec);
            }
        }

        int rIndex = 0;

        String[][] data = new String[map.size()][5];
        for (Encounter e : map.values()) {
            data[rIndex][0] = String.valueOf(e.getEncounterID());
            data[rIndex][1] = e.getStatus();
            data[rIndex][2] = String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getTemperature());
            data[rIndex][3] = String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getBloodPressure());
            data[rIndex][4] = String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getHeartRate());
            rIndex++;
        }
        String[] col = {"ID", "Status", "Temperature", "Blood Pressure", "Heart Rate"};
        DefaultTableModel model = new DefaultTableModel(data, col);
        patientEncounterTable.setModel(model);
    }

    private void setHospitalsTable(Map<Integer, Hospital> hmap) {
        int rIndex = 0;
        hosTable = 1;
        String[][] data = new String[hmap.size()][5];
        for (Map.Entry<Integer, Hospital> e
                : hmap.entrySet()) {
            data[rIndex][0] = String.valueOf(e.getKey());
            data[rIndex][1] = e.getValue().getName();
            data[rIndex][2] = e.getValue().getCity();
            //StringUtils.join(<List>, "|");
            data[rIndex][3] = e.getValue().getCommunityId().toString();
            data[rIndex][4] = e.getValue().getDocterId().toString();
            rIndex++;
        }

        String[] col = {"ID", "Name", "City", "CommunityId", "DocterId"};
        DefaultTableModel model = new DefaultTableModel(data, col);
        patientEncounterTable.setModel(model);
    }

    private void setDocterTable(Map<Integer, Docter> doc) {
        int rIndex = 0;
        docTable = 1;
        hosTable = 0;
        String[][] data = new String[doc.size()][4];
        for (Docter d : doc.values()) {
            data[rIndex][0] = String.valueOf(d.getDocterId());
            data[rIndex][1] = AedLab2.personMap.get(d.getPersonId()).getName();
            data[rIndex][2] = String.valueOf(AedLab2.personMap.get(d.getPersonId()).getAge());
            data[rIndex][3] = AedLab2.personMap.get(d.getPersonId()).getGender();
            rIndex++;
        }
        String[] col = {"ID", "Name", "Age", "Gender"};
        DefaultTableModel model = new DefaultTableModel(data, col);
        patientEncounterTable.setModel(model);
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
        addEncounterButton = new javax.swing.JButton();
        updateEncounterButton = new javax.swing.JButton();
        DeleteEncounterButton = new javax.swing.JButton();
        searchEncounterButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientEncounterTable = new javax.swing.JTable();
        viewPanel = new javax.swing.JPanel();
        docterNameLabel = new javax.swing.JLabel();
        docterNameField = new javax.swing.JTextField();
        hospitalNameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        temperatureLabel = new javax.swing.JLabel();
        hospitalNameField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        temperatureField = new javax.swing.JTextField();
        bloodPressureLabel = new javax.swing.JLabel();
        heartRateLabel = new javax.swing.JLabel();
        remarkLabel = new javax.swing.JLabel();
        bloodPressureField = new javax.swing.JTextField();
        heartRateField = new javax.swing.JTextField();
        remarkField = new javax.swing.JTextField();
        statusComboBox = new javax.swing.JComboBox<>();

        operationsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        addEncounterButton.setText("Add Encounter");
        addEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEncounterButtonActionPerformed(evt);
            }
        });

        updateEncounterButton.setText("Update Encounter");
        updateEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEncounterButtonActionPerformed(evt);
            }
        });

        DeleteEncounterButton.setText("Delete Encounter");
        DeleteEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEncounterButtonActionPerformed(evt);
            }
        });

        searchEncounterButton.setText("Search Encounter");
        searchEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEncounterButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout operationsPanelLayout = new javax.swing.GroupLayout(operationsPanel);
        operationsPanel.setLayout(operationsPanelLayout);
        operationsPanelLayout.setHorizontalGroup(
            operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, operationsPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        operationsPanelLayout.setVerticalGroup(
            operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operationsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(addEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeleteEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        patientEncounterTable.setModel(new javax.swing.table.DefaultTableModel(
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
        patientEncounterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientEncounterTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientEncounterTable);

        viewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        docterNameLabel.setText("Docter Name:");

        docterNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docterNameFieldActionPerformed(evt);
            }
        });

        hospitalNameLabel.setText("Hospital Name:");

        dateLabel.setText("Date :");

        statusLabel.setText("Status:");

        temperatureLabel.setText("Temperature:");

        temperatureField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                temperatureFieldKeyPressed(evt);
            }
        });

        bloodPressureLabel.setText("Blood Pressure:");

        heartRateLabel.setText("Heart Rate:");

        remarkLabel.setText("Remarks:");

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

        heartRateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                heartRateFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(remarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heartRateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bloodPressureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(temperatureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hospitalNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(docterNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(temperatureField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bloodPressureField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(heartRateField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(remarkField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 133, Short.MAX_VALUE)
                    .addComponent(docterNameField)
                    .addComponent(hospitalNameField)
                    .addComponent(dateField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(docterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hospitalNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewPanelLayout.createSequentialGroup()
                        .addComponent(hospitalNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temperatureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temperatureField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bloodPressureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloodPressureField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heartRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heartRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(viewPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(remarkField, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(operationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operationsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setEncounterTable(Map<Integer, Encounter> map) {
        int rIndex = 0;

        String[][] data = new String[map.size()][5];
        for (Encounter e : map.values()) {
            data[rIndex][0] = String.valueOf(e.getEncounterID());
            data[rIndex][1] = e.getStatus();
            data[rIndex][2] = String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getTemperature());
            data[rIndex][3] = String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getBloodPressure());
            data[rIndex][4] = String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getHeartRate());
            rIndex++;
        }
        String[] col = {"ID", "Status", "Temperature", "Blood Pressure", "Heart Rate"};
        DefaultTableModel model = new DefaultTableModel(data, col);
        patientEncounterTable.setModel(model);
    }

    private void searchEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEncounterButtonActionPerformed
        // TODO add your handling code here:
        Map<Integer, Encounter> en = new HashMap<>();
        int flag = 0;
        if (!dateField.getText().isEmpty()) {
            for (Encounter e : AedLab2.encounterMap.values()) {
                if (e.getDateOfEncounter().contains(dateField.getText()) && e.getPatientId() == pat.getPatientId()) {
                    en.put(e.getEncounterID(), e);
                    setEncounterTable(en);
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            for (Encounter e : AedLab2.encounterMap.values()) {
                if (e.getStatus().equalsIgnoreCase(statusComboBox.getSelectedItem().toString())
                        && e.getPatientId() == pat.getPatientId()) {
                    en.put(e.getEncounterID(), e);
                    setEncounterTable(en);
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            if (!temperatureField.getText().isEmpty()) {
                for (Encounter e : AedLab2.encounterMap.values()) {
                    if (String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getTemperature())
                            .contains(temperatureField.getText()) && e.getPatientId() == pat.getPatientId()) {
                        en.put(e.getEncounterID(), e);
                        setEncounterTable(en);
                        flag = 1;
                    }
                }
            }
        }
        if (flag == 0) {
            if (!bloodPressureField.getText().isEmpty()) {
                for (Encounter e : AedLab2.encounterMap.values()) {
                    if (String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getBloodPressure())
                            .contains(bloodPressureField.getText()) && e.getPatientId() == pat.getPatientId()) {
                        en.put(e.getEncounterID(), e);
                        setEncounterTable(en);
                        flag = 1;
                    }
                }
            }
        }
        if (flag == 0) {
            if (!heartRateField.getText().isEmpty()) {
                for (Encounter e : AedLab2.encounterMap.values()) {
                    if (String.valueOf(AedLab2.vitalSignsMap.get(e.getVitalSignsId()).getHeartRate())
                            .contains(heartRateField.getText()) && e.getPatientId() == pat.getPatientId()) {
                        en.put(e.getEncounterID(), e);
                        setEncounterTable(en);
                        flag = 1;
                    }
                }
            }
        }

        if (!remarkField.getText().isEmpty() && flag == 0) {
            for (Encounter e : AedLab2.encounterMap.values()) {
                if (e.getRemark().contains(remarkField.getText()) && e.getPatientId() == pat.getPatientId()) {
                    en.put(e.getEncounterID(), e);
                    setEncounterTable(en);
                    flag = 1;
                }
            }
        }

    }//GEN-LAST:event_searchEncounterButtonActionPerformed

    private void docterNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docterNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docterNameFieldActionPerformed

    private void bloodPressureFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodPressureFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodPressureFieldActionPerformed

    private void patientEncounterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientEncounterTableMouseClicked
        // TODO add your handling code here:
         if(docTable==0&&hosTable==0){
            updateEncounterButton.setEnabled(true);
            DeleteEncounterButton.setEnabled(true);
            System.out.println(patientEncounterTable.getModel().getRowCount());
            int id = Integer.parseInt(patientEncounterTable.getValueAt(patientEncounterTable.getSelectedRow(), 0).toString());
            enc = AedLab2.encounterMap.get(id);

            for (Docter d : AedLab2.docterMap.values()) {
                if (d.getDocterId() == enc.getDoctorId()) {
                    docterNameField.setText(AedLab2.personMap.get(d.getPersonId()).getName());
                }
            }
            for (Hospital h : AedLab2.hospitalMap.values()) {
                if (h.getHospitalId() == enc.getHospitalId()) {
                    hospitalNameField.setText(h.getName());
                }
            }

            dateField.setText(enc.getDateOfEncounter());

            if (enc.getStatus().equalsIgnoreCase(statusComboBox.getItemAt(0))) {
                statusComboBox.setSelectedItem("ACCEPTED");
                //statusComboBox.setSelectedIndex(0);
            } else if (enc.getStatus().equalsIgnoreCase(statusComboBox.getItemAt(1))) {
                statusComboBox.setSelectedItem("PENDING");
                //statusComboBox.setSelectedIndex(1);
            } else {
                statusComboBox.setSelectedItem("REJECTED");
                //statusComboBox.setSelectedIndex(2);
            }

            temperatureField.setText(String.valueOf(AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).getTemperature()));
            bloodPressureField.setText(String.valueOf(AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).getBloodPressure()));
            heartRateField.setText(String.valueOf(AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).getHeartRate()));
            remarkField.setText(enc.getRemark());

        }
            else if (hosTable == 1) {
            int id2 = Integer.parseInt(patientEncounterTable.getValueAt(patientEncounterTable.getSelectedRow(), 0).toString());
            System.out.println("hospital id selected:"+id2);
            Map<Integer, Docter> doc = new HashMap<>();
            Hospital h = AedLab2.hospitalMap.get(id2);
            for (Integer i : h.getDocterId()) {
                doc.put(i, AedLab2.docterMap.get(i));
            }
            hospitalNameField.setText(h.getName());
            //hosTable = 0;
            JOptionPane.showMessageDialog(this, "Please Select Docter from Table");
            setDocterTable(doc);
            
            hospitalNameField.setEditable(false);
        }
        else if (docTable == 1) {
            int id1 = Integer.parseInt(patientEncounterTable.getValueAt(patientEncounterTable.getSelectedRow(), 0).toString());
            System.out.println("docter table id selected:" + id1);
            docterNameField.setText(AedLab2.personMap.get(AedLab2.docterMap.get(id1).getPersonId()).getName());
            docterNameField.setEditable(false);
            docTable = 0;

            int docid = 200, hosid = 300;
            AedLab2.vitalSignsMap.put(AedLab2.VitalSignsId, new VitalSigns(AedLab2.VitalSignsId++,
                    Double.parseDouble(temperatureField.getText()),
                    Integer.parseInt(bloodPressureField.getText()),
                    Integer.parseInt(heartRateField.getText())));

            for (Docter d : AedLab2.docterMap.values()) {
                if (docterNameField.getText().equalsIgnoreCase(AedLab2.personMap.get(d.getPersonId()).getName())) {
                    docid = d.getDocterId();
                }
            }

            for (Hospital h : AedLab2.hospitalMap.values()) {
                if (hospitalNameField.getText().equalsIgnoreCase(h.getName())) {
                    hosid = h.getHospitalId();
                }
            }
            if(updAction==1){
                AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).setTemperature(Double.parseDouble(temperatureField.getText()));
                AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).setBloodPressure(Integer.parseInt(bloodPressureField.getText()));
                AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).setHeartRate(Integer.parseInt(heartRateField.getText()));
                enc.setDateOfEncounter(dateField.getText());
                AedLab2.encounterMap.put(enc.getEncounterID(), new Encounter(enc.getEncounterID(),
                    pat.getPatientId(), enc.getVitalSignsId(), dateField.getText(),
                    enc.getStatus(), docid, hosid, enc.getRemark()));
                    setEncounterTable(pat.getPatientId());
                    remarkField.setEditable(true);
                setEncounterTable(pat.getPatientId());
            JOptionPane.showMessageDialog(this, "Encounter updated");
                updAction=0;
            }
            else{
            AedLab2.encounterMap.put(AedLab2.encounterId, new Encounter(AedLab2.encounterId++,
                    pat.getPatientId(), (AedLab2.VitalSignsId - 1), dateField.getText(),
                    statusComboBox.getItemAt(1), docid, hosid, "No Remark"));

            setEncounterTable(pat.getPatientId());
            remarkField.setEditable(true);
            JOptionPane.showMessageDialog(this, "Encounter Added");
            }
        }

    }//GEN-LAST:event_patientEncounterTableMouseClicked

    private void addEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEncounterButtonActionPerformed
        if (ValidateFields())
            JOptionPane.showMessageDialog(this, "Please Enter Vitals");
        else if (Double.parseDouble(temperatureField.getText()) < 50 || Double.parseDouble(temperatureField.getText()) > 200)
            JOptionPane.showMessageDialog(this, "Temperature not between 50 and 200");
        else if (Integer.parseInt(bloodPressureField.getText()) < 50 || Integer.parseInt(bloodPressureField.getText()) > 300)
            JOptionPane.showMessageDialog(this, "Blood pressure not between 50 and 300");
        else if (Integer.parseInt(heartRateField.getText()) < 50 || Integer.parseInt(heartRateField.getText()) > 200)
            JOptionPane.showMessageDialog(this, "heartRate not between 50 and 200");
        else {
            JOptionPane.showMessageDialog(this, "Please Select hospital from Table");

            statusComboBox.setSelectedItem("PENDING");
            statusComboBox.setEditable(false);
            remarkField.setText("No Remark");
            remarkField.setEditable(false);
            String hos = "";

            Map<Integer, Hospital> hmap = new HashMap<>();
            for (Community c : AedLab2.communityMap.values()) {
                if (c.getHouseId().contains(AedLab2.personMap.get(pat.getPersonId()).getHouseID())) {
                    for (Integer i : c.getHospitalId()) {
                        hmap.put(i, AedLab2.hospitalMap.get(i));
                    }
                }
            }
            setHospitalsTable(hmap);
        }
    }//GEN-LAST:event_addEncounterButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        resetAction();
    }//GEN-LAST:event_resetButtonActionPerformed

    public boolean ValidateFields() {
        if (temperatureField.getText().isEmpty() || bloodPressureField.getText().isEmpty()
                || heartRateField.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private void updateEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEncounterButtonActionPerformed
        // TODO add your handling code here:
        if (ValidateFields())
            JOptionPane.showMessageDialog(this, "Please Enter All Fields");
        else if (Double.parseDouble(temperatureField.getText()) < 50 || Double.parseDouble(temperatureField.getText()) > 200)
            JOptionPane.showMessageDialog(this, "Age not between 50 and 200");
        else if (Integer.parseInt(bloodPressureField.getText()) < 50 || Integer.parseInt(bloodPressureField.getText()) > 300)
            JOptionPane.showMessageDialog(this, "Age not between 50 and 300");
        else if (Integer.parseInt(heartRateField.getText()) < 50 || Integer.parseInt(heartRateField.getText()) > 200)
            JOptionPane.showMessageDialog(this, "Age not between 50 and 200");
//      else {
//            hospitalNameField.setEditable(false);
//            docterNameField.setEditable(false);
//            if (enc.getStatus().equalsIgnoreCase("pending")) {
//                String hos = "";
//                for (Hospital h : AedLab2.hospitalMap.values()) {
//                    if (!(enc.getHospitalId() == h.getHospitalId())) {
//                        hos += h.getName() + ",";
//                    }
//                }
//
//                String search = JOptionPane.showInputDialog(String.format("Hospitals:[%s]\nPlease enter Hospital Name", hos));
//                for (Hospital h : AedLab2.hospitalMap.values()) {
//                    if (h.getName().equalsIgnoreCase(search)) {
//                        enc.setHospitalId(h.getHospitalId());
//                        hos = "";
//
//                        for (Integer i : h.getDocterId()) {
//                            hos += AedLab2.personMap.get(AedLab2.docterMap.get(i).getPersonId()).getName() + ",";
//                        }
//                        String search1 = JOptionPane.showInputDialog(String.format("Docters:[%s]\nPlease enter Docter Name", hos));
//                        for (Docter d : AedLab2.docterMap.values()) {
//                            if (AedLab2.personMap.get(d.getPersonId()).getName().equalsIgnoreCase(search1)) {
//                                enc.setDoctorId(d.getDocterId());
//                            }
//                        }
//
//                    }//if
//                }//for
//                enc.setDateOfEncounter(dateField.getText());
//                statusComboBox.setEditable(false);
//                AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).setTemperature(Double.parseDouble(temperatureField.getText()));
//                AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).setBloodPressure(Integer.parseInt(bloodPressureField.getText()));
//                AedLab2.vitalSignsMap.get(enc.getVitalSignsId()).setHeartRate(Integer.parseInt(heartRateField.getText()));
//                remarkField.setVisible(false);
//                AedLab2.encounterMap.replace(enc.getEncounterID(), enc);
//                JOptionPane.showMessageDialog(this, "Encounter Updated");
//
//                hospitalNameField.setEditable(true);
//                docterNameField.setEditable(true);
//            }//if
//            JOptionPane.showMessageDialog(this, "Only Pending Encounters can be updated");
//        }//else
        else {
            updAction = 1;
            JOptionPane.showMessageDialog(this, "Please Select hospital from Table");

            statusComboBox.setSelectedItem("PENDING");
            statusComboBox.setEditable(false);
            remarkField.setText("No Remark");
            remarkField.setEditable(false);
            String hos = "";

            Map<Integer, Hospital> hmap = new HashMap<>();
            for (Community c : AedLab2.communityMap.values()) {
                if (c.getHouseId().contains(AedLab2.personMap.get(pat.getPersonId()).getHouseID())) {
                    for (Integer i : c.getHospitalId()) {
                        hmap.put(i, AedLab2.hospitalMap.get(i));
                    }
                }
            }
            setHospitalsTable(hmap);
        }
    }//GEN-LAST:event_updateEncounterButtonActionPerformed

    private void DeleteEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEncounterButtonActionPerformed
        // TODO add your handling code here:
        if(!enc.getStatus().equalsIgnoreCase("pending")){
        AedLab2.encounterMap.remove(enc.getEncounterID(), enc);
        JOptionPane.showMessageDialog(this, "Encounter deleted");
        resetAction();
        }
        else{
            JOptionPane.showMessageDialog(this, "Pending Encounters Cannot be Deleted");
        resetAction();
        }
    }//GEN-LAST:event_DeleteEncounterButtonActionPerformed

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
            JOptionPane.showMessageDialog(this, "Blood Pressure should be a number");
        } else {
        }
        bloodPressureField.setEditable(true);
    }//GEN-LAST:event_bloodPressureFieldKeyPressed

    private void heartRateFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heartRateFieldKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == ' ') {
            heartRateField.setEditable(false);
            JOptionPane.showMessageDialog(this, "heartRate should be a number");
        } else {
        }
        heartRateField.setEditable(true);
    }//GEN-LAST:event_heartRateFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteEncounterButton;
    private javax.swing.JButton addEncounterButton;
    private javax.swing.JTextField bloodPressureField;
    private javax.swing.JLabel bloodPressureLabel;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField docterNameField;
    private javax.swing.JLabel docterNameLabel;
    private javax.swing.JTextField heartRateField;
    private javax.swing.JLabel heartRateLabel;
    private javax.swing.JTextField hospitalNameField;
    private javax.swing.JLabel hospitalNameLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel operationsPanel;
    private javax.swing.JTable patientEncounterTable;
    private javax.swing.JTextField remarkField;
    private javax.swing.JLabel remarkLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchEncounterButton;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField temperatureField;
    private javax.swing.JLabel temperatureLabel;
    private javax.swing.JButton updateEncounterButton;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
