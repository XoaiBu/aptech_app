/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import AptechApp.model.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author XoaiBuuu
 */
public class TeacherDAO extends DatabaseDAO{
    public boolean insertTC(Teacher tc){
        try{
            String sql = "INSERT INTO roleuser(idUser, name, email, teachingSubject,birthday,address,sex,tel,idRole) VALUES (?,?,?,?,?,?,?,?.?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tc.getIdTeacher());
            ps.setString(2,tc.getTeacherName());
            ps.setString(3,tc.getEmail());
            ps.setString(4,tc.getTeachingSubject());
            ps.setString(5,tc.getBirthday());
            ps.setString(6,tc.getAddress());
            ps.setInt(7,tc.getSex());
            ps.setString(8,tc.getTel());
            ps.setInt(9,tc.getRole());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateTC(Teacher tc){
        try{
            String sql = "UPDATE useraccount SET name=?, email=?, teachingSubject=?, birthday=?, address=?,sex=?,tel=?, idRole WHERE idUser=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(8,tc.getIdTeacher());
            ps.setString(1,tc.getTeacherName());
            ps.setString(2,tc.getEmail());
            ps.setString(3,tc.getTeachingSubject());
            ps.setString(4,tc.getBirthday());
            ps.setString(5,tc.getAddress());
            ps.setInt(6,tc.getSex());
            ps.setString(7,tc.getTel());
            ps.setInt(8,tc.getRole());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteTC(String MaGV){
        try{
            String sql = "DELETE FROM useraccount WHERE idUser=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,MaGV);
            
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Teacher> getAllTC(){
        try{
            String sql = "SELECT * FROM roleuser";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Teacher> listTC = new ArrayList<Teacher>();
            while(rs.next()){
                Teacher tc = new Teacher();
                tc.setRole(rs.getInt(1));
                tc.setIdTeacher(rs.getString(2));
                tc.setTeacherName(rs.getString(3));
                tc.setEmail(rs.getString(4));
                tc.setTeachingSubject(rs.getString(5));
                tc.setBirthday(rs.getString(6));
                tc.setAddress(rs.getString(7));
                tc.setSex(rs.getInt(8));
                tc.setTel(rs.getString(9));
                listTC.add(tc);
            }
            return listTC;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Teacher findTCById(String id){
        try{
            String sql = "SELECT * FROM roleuser WHERE idUser=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Teacher tc = new Teacher();
                tc.setRole(rs.getInt(1));
                tc.setIdTeacher(rs.getString(2));
                tc.setTeacherName(rs.getString(3));
                tc.setEmail(rs.getString(4));
                tc.setTeachingSubject(rs.getString(5));
                tc.setBirthday(rs.getString(6));
                tc.setAddress(rs.getString(7));
                tc.setSex(rs.getInt(8));
                tc.setTel(rs.getString(9));
                return tc;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
