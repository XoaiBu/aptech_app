/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import AptechApp.model.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author XoaiBuuu
 */
public class SubjectDAO extends DatabaseDAO{
    public ArrayList<String> getSubjectName(){
        try{
            String sql = "SELECT subjectName FROM subject";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> listSubjectName = new ArrayList<String>();
            while(rs.next()){
                    listSubjectName.add(rs.getString(1));
            }
            return listSubjectName;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String getIdSubjectBySubjectName(String subjectName) {
        try {
            String sql = "SELECT idSubject FROM subject WHERE subjectName = '" + subjectName + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("idSubject");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public boolean insertSubject(Subject sj){
        try{
            String sql = "INSERT INTO subject VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,sj.getIdSubject());
            ps.setString(2,sj.getSubjectName());
            ps.setString(3,sj.getIdDepartment());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateSubject(Subject sj){
        try{
            String sql = "UPDATE subject SET subjectName=?, idDepartment=? WHERE idSubject=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,sj.getSubjectName());
            ps.setString(2,sj.getIdDepartment());
            ps.setString(3,sj.getIdSubject());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteSubject(String idSubject){
        try{
            String sql = "DELETE FROM subject WHERE idSubject=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idSubject);
            
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Subject findSubjectById(String idSubject){
        try{
            String sql = "SELECT * FROM subject WHERE idSubject=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idSubject);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Subject sj = new Subject();
                sj.setIdSubject(idSubject);
                sj.setSubjectName(rs.getString(2));
                sj.setIdDepartment(rs.getString(3));
                return sj;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Subject> getAllSubject(){
        try{
            String sql = "SELECT * FROM subject";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Subject> listSubject = new ArrayList<Subject>();
            while(rs.next()){
                Subject sj = new Subject();
                sj.setIdSubject(rs.getString(2));
                sj.setSubjectName(rs.getString(2));
                sj.setIdDepartment(rs.getString(3));
                listSubject.add(sj);
            }
            return listSubject;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
