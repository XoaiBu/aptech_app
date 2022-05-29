/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;

import AptechApp.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author XoaiBuuu
 */
public class UserDAO extends DatabaseDAO{
    public User CheckLogin(String TenNguoiDung, String MatKhau){
        try{
            String sql = "SELECT account,password FROM useraccount WHERE account='"+TenNguoiDung+"' AND password='"+MatKhau+"'";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            if(rs.next()){
                User nd = new User();
                nd.setTenNguoiDung(TenNguoiDung);
                return nd;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
