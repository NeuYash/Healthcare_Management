/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.aed.aedlab2;

import com.aed.model.Community;
import com.aed.model.Docter;
import com.aed.model.Encounter;
import com.aed.model.Hospital;
import com.aed.model.House;
import com.aed.model.Patient;
import com.aed.model.Person;
import com.aed.model.VitalSigns;
import com.aed.view.LoginJFrame;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkIJTheme;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yashpawar
 */
public class AedLab2 {

    public static int VitalSignsId = 100, docterId = 200, hospitalId = 300, communityId = 400, houseId = 500, encounterId = 600,
            patientId = 700, personId = 800;
    public static String role = "PATIENT",remark="No remark";
    public static Map<Integer, VitalSigns> vitalSignsMap = new HashMap<>();
    public static Map<Integer, Docter> docterMap = new HashMap<>();
    public static Map<Integer, Hospital> hospitalMap = new HashMap<>();
    public static Map<Integer, Community> communityMap = new HashMap<>();
    public static Map<Integer, House> houseMap = new HashMap<>();
    public static Map<Integer, Person> personMap = new HashMap<>();
    public static Map<Integer, Patient> patientMap = new HashMap<>();
    public static Map<Integer, Encounter> encounterMap = new HashMap<>();

    public static void main(String[] args) {
        
        vitalSignsMap.put(VitalSignsId, new VitalSigns(VitalSignsId++, 97, 130, 86));
        vitalSignsMap.put(VitalSignsId, new VitalSigns(VitalSignsId++, 97, 180, 78));
        vitalSignsMap.put(VitalSignsId, new VitalSigns(VitalSignsId++, 103, 150, 120));
        vitalSignsMap.put(VitalSignsId, new VitalSigns(VitalSignsId++, 100, 110, 95));
        vitalSignsMap.put(VitalSignsId, new VitalSigns(VitalSignsId++, 99, 125, 72));

        docterMap.put(docterId, new Docter(docterId++, 816, Arrays.asList(300, 301, 304)));
        docterMap.put(docterId, new Docter(docterId++, 817, Arrays.asList(300, 302, 303)));
        docterMap.put(docterId, new Docter(docterId++, 818, Arrays.asList(300, 302, 304)));
        docterMap.put(docterId, new Docter(docterId++, 819, Arrays.asList(300, 301, 303)));
        docterMap.put(docterId, new Docter(docterId++, 820, Arrays.asList(300, 302, 301)));
        
        hospitalMap.put(hospitalId, new Hospital(hospitalId++, "HealthSure", "Boston",
                Arrays.asList(400, 401, 403), Arrays.asList(200, 201, 203),805));
        hospitalMap.put(hospitalId, new Hospital(hospitalId++, "Apex", "Boston",
                Arrays.asList(400, 401, 402), Arrays.asList(200, 202, 203),806));
        hospitalMap.put(hospitalId, new Hospital(hospitalId++, "Subrata", "Boston",
                Arrays.asList(400, 402, 403), Arrays.asList(200, 201, 202),807));
        hospitalMap.put(hospitalId, new Hospital(hospitalId++, "Shivani", "Boston",
                Arrays.asList(400, 402, 404), Arrays.asList(200, 201, 204),808));
        hospitalMap.put(hospitalId, new Hospital(hospitalId++, "Poonam", "Boston",
                Arrays.asList(400, 404, 403), Arrays.asList(200, 204, 203),809));
        
        communityMap.put(communityId, new Community(communityId++, "MissionHill", "Boston", "02115",
                Arrays.asList(500, 501, 502), Arrays.asList(300, 301, 304),810));
        communityMap.put(communityId, new Community(communityId++, "MissionPark", "Boston", "02120",
                Arrays.asList(503, 504), Arrays.asList(300, 302),811));
        communityMap.put(communityId, new Community(communityId++, "Bolyston Street", "Boston", "02116",
                Arrays.asList(505), Arrays.asList(300),812));
        communityMap.put(communityId, new Community(communityId++, "South End", "Boston", "02117",
                Arrays.asList(506, 507), Arrays.asList(301, 304),813));
        communityMap.put(communityId, new Community(communityId++, "ChinaTown", "Boston", "02118",
                Arrays.asList(508, 509), Arrays.asList(301, 302, 303, 304),814));

        houseMap.put(houseId, new House(houseId++, 400, "ABC"));
        houseMap.put(houseId, new House(houseId++, 400, "ABC"));
        houseMap.put(houseId, new House(houseId++, 400, "ABC"));
        houseMap.put(houseId, new House(houseId++, 401, "ABC"));
        houseMap.put(houseId, new House(houseId++, 401, "ABC"));
        houseMap.put(houseId, new House(houseId++, 402, "ABC"));
        houseMap.put(houseId, new House(houseId++, 403, "ABC"));
        houseMap.put(houseId, new House(houseId++, 403, "ABC"));
        houseMap.put(houseId, new House(houseId++, 404, "ABC"));
        houseMap.put(houseId, new House(houseId++, 404, "ABC"));
        
        personMap.put(personId, new Person(personId++, "anush", "anush", "anush123",
                role, 32, "MALE", "./uploads/profileImage/pass.png", 500));
        personMap.put(personId, new Person(personId++, "dhanush", "dhanush", "dhanush123",
                role, 23, "MALE", "./uploads/profileImage/pass.png", 500));
        personMap.put(personId, new Person(personId++, "rajesh", "rajesh", "rajesh123",
                role, 43, "MALE", "./uploads/profileImage/pass.png", 506));
        personMap.put(personId, new Person(personId++, "raj", "raj", "raj123",
                role, 23, "MALE", "./uploads/profileImage/pass.png", 507));
        personMap.put(personId, new Person(personId++, "Yash", "ya", "ya",
                "SYSTEMADMIN", 50, "MALE", "./uploads/profileImage/yash.jpeg", 509));
        //805
        personMap.put(personId, new Person(personId++, "hardik", "hardik", "hardik123",
                "HOSPITALADMIN", 23, "MALE", "./uploads/profileImage/pass.png", 500));
        personMap.put(personId, new Person(personId++, "palak", "palak", "palak123",
                "HOSPITALADMIN", 34, "FEMALE", "./uploads/profileImage/pass.png", 506));
        personMap.put(personId, new Person(personId++, "harshila", "harshila", "harshila123",
                "HOSPITALADMIN", 50, "FEMALE", "./uploads/profileImage/pass.png", 507));
        personMap.put(personId, new Person(personId++, "maitree", "maitree", "maitree123",
                "HOSPITALADMIN", 35, "FEMALE", "./uploads/profileImage/pass.png", 504));
        personMap.put(personId, new Person(personId++, "sweety", "sweety", "sweety123",
                "HOSPITALADMIN", 50, "FEMALE", "./uploads/profileImage/pass.png", 507));
        //810
        personMap.put(personId, new Person(personId++, "Disha", "disha", "disha123",
                "COMMUNITYADMIN", 30, "FEMALE", "./uploads/profileImage/pass.png", 502));
        personMap.put(personId, new Person(personId++, "amruta", "amruta", "amruta123",
                "COMMUNITYADMIN", 30, "FEMALE", "./uploads/profileImage/pass.png", 503));
        personMap.put(personId, new Person(personId++, "radhe", "radhe", "radhe123",
                "COMMUNITYADMIN", 30, "MALE", "./uploads/profileImage/pass.png", 505));
        personMap.put(personId, new Person(personId++, "prem", "prem", "prem123",
                "COMMUNITYADMIN", 30, "MALE", "./uploads/profileImage/pass.png", 506));
        personMap.put(personId, new Person(personId++, "rakshit", "rakshit", "rakshit123",
                "COMMUNITYADMIN", 30, "MALE", "./uploads/profileImage/pass.png", 508));
        //815
        //System.out.println("personId="+personId);
        personMap.put(personId, new Person(personId++, "dhanush", "dhanush", "dhanush123",
                "HOSPITALADMIN", 23, "MALE", "./uploads/profileImage/pass.png", 502));
        personMap.put(personId, new Person(personId++, "prasad", "prasad", "prasad123",
                "DOCTER", 62, "MALE", "./uploads/profileImage/pass.png", 503));
        personMap.put(personId, new Person(personId++, "padma", "padma", "padma123",
                "DOCTER", 52, "FEMALE", "./uploads/profileImage/pass.png", 504));
        personMap.put(personId, new Person(personId++, "shivani", "shivani", "shivani123",
                "DOCTER", 33, "FEMALE", "./uploads/profileImage/pass.png", 505));
        personMap.put(personId, new Person(personId++, "yash", "yash", "yash123",
                "DOCTER", 28, "MALE", "./uploads/profileImage/pass.png", 506));
        personMap.put(personId, new Person(personId++, "rajeshwari", "rajeshwari", "rajeshwari123",
                "DOCTER", 26, "FEMALE", "./uploads/profileImage/pass.png", 507));
        personMap.put(personId, new Person(personId++, "Disha", "com", "com123",
                "COMMUNITYADMIN", 30, "MALE", "./uploads/profileImage/pass.png", 502));
        
        patientMap.put(patientId, new Patient(patientId++, 800));
        patientMap.put(patientId, new Patient(patientId++, 801));
        patientMap.put(patientId, new Patient(patientId++, 802));
        patientMap.put(patientId, new Patient(patientId++, 803));

        encounterMap.put(encounterId, new Encounter(encounterId++, 700, 100, "12-Dec-2020", "pending", 200, 300,remark));
        encounterMap.put(encounterId, new Encounter(encounterId++, 700, 101, "12-Jan-2022", "accepted", 201, 303,remark));
        encounterMap.put(encounterId, new Encounter(encounterId++, 701, 102, "29-Jul-2022", "pending", 200, 300,remark));
        
        encounterMap.put(encounterId, new Encounter(encounterId++, 701, 102, "29-May-2022", "accepted", 202, 300,remark));
        encounterMap.put(encounterId, new Encounter(encounterId++, 702, 100, "12-Dec-2020", "rejected", 202, 302,remark));
        encounterMap.put(encounterId, new Encounter(encounterId++, 702, 100, "12-Dec-2020", "pending", 204, 304,remark));
        encounterMap.put(encounterId, new Encounter(encounterId++, 702, 100, "12-Jan-2019", "accepted", 200, 302,remark));
        encounterMap.put(encounterId, new Encounter(encounterId++, 702, 102, "12-Dec-2020", "pending", 204, 304,remark));
        encounterMap.put(encounterId, new Encounter(encounterId++, 703, 101, "12-Feb-2020", "accepted", 204, 304,remark));
        encounterMap.put(encounterId, new Encounter(encounterId++, 703, 100, "12-Sep-2022", "pending", 204, 301,remark));
        
        
        try{
            //UIManager.setLookAndFeel(new FlatArcDarkIJTheme());
            //FlatSolarizedDarkContrastIJTheme.setup();
            FlatMonokaiProContrastIJTheme.setup();
            //FlatGitHubDarkContrastIJTheme.setup();
            //FlatAtomOneLightIJTheme.setup();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        new LoginJFrame().setVisible(true);
        
    }
}
