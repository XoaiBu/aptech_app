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
public class Mark {
    private String idStudent, idSubject, idUser;
    private int examTimes, theory, pratical;

    public Mark() {
    }

    public Mark(String idStudent, String idSubject, String idUser, int examTimes, int theory, int pratical) {
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.idUser = idUser;
        this.examTimes = examTimes;
        this.theory = theory;
        this.pratical = pratical;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getExamTimes() {
        return examTimes;
    }

    public void setExamTimes(int examTimes) {
        this.examTimes = examTimes;
    }

    public int getTheory() {
        return theory;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public int getPratical() {
        return pratical;
    }

    public void setPratical(int pratical) {
        this.pratical = pratical;
    }

    
}
