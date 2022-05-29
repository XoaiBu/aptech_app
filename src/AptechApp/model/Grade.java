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
public class Grade {
    private String idClass, className, idDepartment;

    public Grade() {
    }

    public Grade(String idClass, String className, String idDepartment) {
        this.idClass = idClass;
        this.className = className;
        this.idDepartment = idDepartment;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    

    
    
}
