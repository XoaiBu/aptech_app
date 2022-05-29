/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import AptechApp.model.Grade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author XoaiBuuu
 */
public class GradeDAO extends DatabaseDAO{
    public ArrayList<String> getClassName(){
        try{
            String sql = "SELECT className FROM class";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> listClassName = new ArrayList<String>();
            while(rs.next()){
                    listClassName.add(rs.getString(1));
            }
            return listClassName;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String getIdClassByClassName(String className) {
        try {
            String sql = "SELECT idClass FROM class WHERE className = '" + className + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("idClass");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public boolean insertClass(Grade lop){
        try{
            String sql = "INSERT INTO class VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,lop.getIdClass());
            ps.setString(2,lop.getClassName());
            ps.setString(3,lop.getIdDepartment());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateClass(Grade lop){
        try{
            String sql = "UPDATE class SET idClass=?, className=?, idDepartment=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,lop.getIdClass());
            ps.setString(2,lop.getClassName());
            ps.setString(3,lop.getIdDepartment());
           
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteClass(String idClass){
        try{
            String sql = "DELETE FROM class WHERE idClass=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idClass);
            
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Grade findClassById(String idClass){
        try{
            String sql = "SELECT * FROM class WHERE idClass=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idClass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Grade lop = new Grade();
                lop.setIdClass(idClass);
                lop.setClassName(rs.getString(2));
                lop.setIdDepartment(rs.getString(3));
                return lop;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Grade> getAllClass(){
        try{
            String sql = "SELECT * FROM class";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Grade> listCLass = new ArrayList<Grade>();
            while(rs.next()){
                Grade lop = new Grade();
                lop.setIdClass(rs.getString(1));
                lop.setClassName(rs.getString(2));
                lop.setIdDepartment(rs.getString(3));
                listCLass.add(lop);
            }
            return listCLass;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
