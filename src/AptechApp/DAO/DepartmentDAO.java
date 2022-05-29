/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import AptechApp.model.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author XoaiBuuu
 */
public class DepartmentDAO extends DatabaseDAO{
    public ArrayList<String> getDepartmentName(){
        try{
            String sql = "SELECT departmentName FROM department";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> listDepartmentName = new ArrayList<String>();
            while(rs.next()){
                    listDepartmentName.add(rs.getString(1));
            }
            return listDepartmentName;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String getIdDepartmentByDepartmentName(String departmentName) {
        try {
            String sql = "SELECT idDepartment FROM department WHERE departmentName = '" + departmentName + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("idDepartment");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public boolean insertDepartment(Department dpm){
        try{
            String sql = "INSERT INTO department VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dpm.getIdDeparment());
            ps.setString(2,dpm.getDepartmentName());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateDepartment(Department dpm){
        try{
            String sql = "UPDATE department SET departmentName=? WHERE idDepartment = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dpm.getDepartmentName());
            ps.setString(1,dpm.getIdDeparment());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteDepartment(String idDepartment){
        try{
            String sql = "DELETE FROM department WHERE idDepartment=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idDepartment);
            
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Department findDepartmentById(String idDpm){
        try{
            String sql = "SELECT * FROM department WHERE idDepartment=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idDpm);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Department dpm = new Department();
                dpm.setIdDeparment(idDpm);
                dpm.setDepartmentName(rs.getString(2));
                return dpm;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Department> getAllDepartment(){
        try{
            String sql = "SELECT * FROM department";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Department> listDpm = new ArrayList<Department>();
            while(rs.next()){
                Department dpm = new Department();
                dpm.setIdDeparment(rs.getString(1));
                dpm.setDepartmentName(rs.getString(2));
                listDpm.add(dpm);
            }
            return listDpm;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
