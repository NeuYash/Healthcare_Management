/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.aed.aedlab2.AedLab2;
import com.aed.model.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class UtilityFunctions {

    //Convert functions
    public int convertToInt(String text) {

        return Integer.parseInt(text);

    }

    public double convertToDouble(String text) {

        return Double.parseDouble(text);

    }

    public LocalDate convertToDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        formatter = formatter.withLocale(Locale.US);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH

        LocalDate dt;
        //System.out.println(date);

        try {
            dt = LocalDate.parse(date, formatter);
        } catch (Exception e) {
            dt = LocalDate.parse("1-Jan-1990", formatter);
        }

        return dt;
    }

    public String covertDateToString(LocalDate dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        String dt;

        try {
            dt = dob.format(formatter);
        } catch (Exception e) {
            LocalDate ld = LocalDate.now();
            dt = ld.format(formatter);
        }
        return dt;

    }

    public int runValidation(String pattern, String matcher) {

        //USed for defining the pattern
        Pattern ptn = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        //Used to search the pattern
        Matcher mchr = ptn.matcher(matcher);

        if (mchr.find()) {
            return 0;
        } else {
            return 1;
        }

    }
    public static List<Integer> sortList(List<Integer> l){
        Set<Integer> s= new HashSet<Integer>();
                s.addAll(l);
                return new ArrayList<Integer>(s);
    }
    
    public static List<Integer> removeIntFromList(List<Integer> l, int f){
        List<Integer> ret= new ArrayList<>();
        for(Integer i: l)
            if(i!=f)
                ret.add(i);
        return ret;
    }
    
    public static List<Integer> addInttoList(List<Integer> l, int f){
        Set<Integer> s= new HashSet<>(l);
        s.add(f);
        return new ArrayList<Integer>(s);
    }
    
    public static boolean validateUsername(String username){
        for(Person p: AedLab2.personMap.values())
            if(p.getUserName().equals(username))
                return false;
        return true;
    }
    
    public static boolean validateRole(int id,String role){
        if(AedLab2.personMap.get(id).getRole().equals(role))
            return true;
        return false;
    }
    
    public static String convertIntToString(int num) {

        return num + "";

    }

    public static String convertDoubleToString(double num) {

        return num + "";

    }

//     public ImageIcon scaleImage(ImageIcon icon, int w, int h)
//    {
//        int nw = icon.getIconWidth();
//        int nh = icon.getIconHeight();
//
//        if(icon.getIconWidth() > w)
//        {
//          nw = w;
//          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
//        }
//
//        if(nh > h)
//        {
//          nh = h;
//          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
//        }
//
//        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
//    }
}
