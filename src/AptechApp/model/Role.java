/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptechApp.model;

/**
 *
 * @author XoaiBuuu
 */
public class Role {
    private String idRole, role;

    public Role() {
    }

    public Role(String idRole, String role) {
        this.idRole = idRole;
        this.role = role;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
