/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import AptechApp.model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author XoaiBuuu
 */
public class RoleDAO extends DatabaseDAO{
    public ArrayList<String> getRole(){
        try{
            String sql = "SELECT role FROM role";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> listRole = new ArrayList<String>();
            while(rs.next()){
                    listRole.add(rs.getString(1));
            }
            return listRole;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int getIdRoleByRole(String role) {
        try {
            String sql = "SELECT role FROM role WHERE role = '" + role + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("idRole");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public boolean insertRole(Role role){
        try{
            String sql = "INSERT INTO role VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,role.getIdRole());
            ps.setString(2,role.getRole());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateRole(Role role){
        try{
            String sql = "UPDATE role SET role=? WHERE idRole = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,role.getRole());
            ps.setString(1,role.getIdRole());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteRole(String idRole){
        try{
            String sql = "DELETE FROM role WHERE idRole=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idRole);
            
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Role findRoleById(String idRole){
        try{
            String sql = "SELECT * FROM role WHERE idRole=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idRole);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Role role = new Role();
                role.setIdRole(idRole);
                role.setRole(rs.getString(2));
                return role;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Role> getAll(){
        try{
            String sql = "SELECT * FROM role";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Role> listRole = new ArrayList<Role>();
            while(rs.next()){
                Role role = new Role();
                role.setIdRole(rs.getString(1));
                role.setRole(rs.getString(2));
                listRole.add(role);
            }
            return listRole;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
