/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import AptechApp.model.Mark;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author XoaiBuuu
 */
public class markDAO extends DatabaseDAO{
    public boolean insertMark(Mark mark){
        try{
            String sql = "INSERT INTO mark VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,mark.getIdStudent());
            ps.setString(2,mark.getIdSubject());
            ps.setInt(3,mark.getExamTimes());
            ps.setInt(4,mark.getTheory());
            ps.setInt(5,mark.getPratical());
            ps.setString(6,mark.getIdUser());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateMark(Mark mark){
        try{
            String sql = "UPDATE mark SET idSubject=?, examTimes=?, theory=?, practical=?,idUser=? WHERE idStudent=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(6,mark.getIdStudent());
            ps.setString(1,mark.getIdSubject());
            ps.setInt(2,mark.getExamTimes());
            ps.setInt(3,mark.getTheory());
            ps.setInt(4,mark.getPratical());
            ps.setString(5,mark.getIdUser());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteMark(String idStudent){
        try{
            String sql = "DELETE FROM mark WHERE idStudent=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idStudent);
            
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Mark findMarkByStudentId(String idStudent){
        try{
            String sql = "SELECT * FROM mark WHERE idStudent=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idStudent);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Mark mark = new Mark();
                mark.setIdStudent(idStudent);
                mark.setIdSubject(rs.getString(2));
                mark.setExamTimes(rs.getInt(3));
                mark.setTheory(rs.getInt(4));
                mark.setPratical(rs.getInt(5));
                mark.setIdUser(rs.getString(6));
                return mark;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Mark> getAllMark(){
        try{
            String sql = "SELECT * FROM mark";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mark> listMark = new ArrayList<Mark>();
            while(rs.next()){
                Mark mark = new Mark();
                mark.setIdStudent(rs.getString(1));
                mark.setIdSubject(rs.getString(2));
                mark.setExamTimes(rs.getInt(3));
                mark.setTheory(rs.getInt(4));
                mark.setPratical(rs.getInt(5));
                mark.setIdUser(rs.getString(6));
                listMark.add(mark);
            }
            return listMark;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
