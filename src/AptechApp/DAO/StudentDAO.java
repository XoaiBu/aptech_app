/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import AptechApp.model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author XoaiBuuu
 */
public class StudentDAO extends DatabaseDAO{
    public boolean insertSV(Student sv){
        try{
            String sql = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,sv.getIdStudent());
            ps.setString(2,sv.getStudentName());
            ps.setString(3,sv.getIdClass());
            ps.setString(4,sv.getCourse());
            ps.setString(5,sv.getBirthday());
            ps.setString(6,sv.getAddress());
            ps.setInt(7,sv.getSex());
            ps.setString(8,sv.getTel());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateSV(Student sv){
        try{
            String sql = "UPDATE student SET studentName=?, idClass=?, course=?, birthday=?, address=?,sex=?,tel=? WHERE idStudent=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(8,sv.getIdStudent());
            ps.setString(1,sv.getStudentName());
            ps.setString(2,sv.getIdClass());
            ps.setString(3,sv.getCourse());
            ps.setString(4,sv.getBirthday());
            ps.setString(5,sv.getAddress());
            ps.setInt(6,sv.getSex());
            ps.setString(7,sv.getTel());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteSV(String MaSV){
        try{
            String sql = "DELETE FROM student WHERE idStudent=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,MaSV);
            
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Student findSVById(String MaSV){
        try{
            String sql = "SELECT * FROM student WHERE idStudent=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,MaSV);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Student sv = new Student();
                sv.setIdStudent(MaSV);
                sv.setStudentName(rs.getString(2));
                sv.setIdClass(rs.getString(3));
                sv.setCourse(rs.getString(4));
                sv.setBirthday(rs.getString(5));
                sv.setAddress(rs.getString(6));
                sv.setSex(rs.getInt(7));
                sv.setTel(rs.getString(8));
                return sv;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Student> getAllSV(){
        try{
            String sql = "SELECT * FROM student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Student> listSV = new ArrayList<Student>();
            while(rs.next()){
                Student sv = new Student();
                sv.setIdStudent(rs.getString(1));
                sv.setStudentName(rs.getString(2));
                sv.setIdClass(rs.getString(3));
                sv.setCourse(rs.getString(4));
                sv.setBirthday(rs.getString(5));
                sv.setAddress(rs.getString(6));
                sv.setSex(rs.getInt(7));
                sv.setTel(rs.getString(8));
                listSV.add(sv);
            }
            return listSV;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
