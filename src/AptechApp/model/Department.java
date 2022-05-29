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
public class Department {
    private String idDeparment, departmentName;

    public Department() {
    }

    public Department(String idDeparment, String departmentName) {
        this.idDeparment = idDeparment;
        this.departmentName = departmentName;
    }

    public String getIdDeparment() {
        return idDeparment;
    }

    public void setIdDeparment(String idDeparment) {
        this.idDeparment = idDeparment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
}
