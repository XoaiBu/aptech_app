/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author XoaiBuuu
 */
public class DatabaseDAO {
    protected Connection conn;
    public  DatabaseDAO(){
        try{
            String url = "jdbc:mysql://localhost:3306/aptech_app";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            System.err.println("Lỗi kết nối");
        }
        
    }
}
