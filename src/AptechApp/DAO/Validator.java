/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import java.util.regex.Matcher;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.regex.Pattern;
/**
 *
 * @author XoaiBuuu
 */
public class Validator {
    private static String pattern = "\\d+\\.\\d{4}";
    private static String Birthdaypattern = "/^[0-9]{2}/[0-9]{2}/[0-9]{4}$/gm";
    private static String markPattern = "/^1?2?[0-9]{1}$/gm";
    public Validator() {
    }
    
    public boolean validateLogin(JTextField account, JPasswordField password){
        Pattern r = Pattern.compile(pattern);
        Matcher m;
        Matcher m2;
        m = r.matcher(account.getText());
        m2 = r.matcher(password.getText());
        if(m.matches() && m2.matches()){
            return true;
        }
        return false;
        
    }
    public boolean emptyTextField(JTextField txt){
        if(txt.getText().equals("")){
            return true;
        }
        return false;
    }
    public boolean validateBirthday(JTextField txt){
        Pattern r = Pattern.compile(Birthdaypattern);
        Matcher m;
        m = r.matcher(txt.getText());
        if(m.matches()){
            return true;
        }
        return false;
    }
    public boolean validateMark(JTextField txt){
        Pattern r = Pattern.compile(markPattern);
        Matcher m;
        m = r.matcher(txt.getText());
        if(m.matches()){
            return true;
        }
        return false;
    }
}
