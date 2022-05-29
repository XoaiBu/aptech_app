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
public class Student {
    private String idStudent; 
    private String studentName;
    private String idClass;
    private String course ;
    private String birthday; 
    private String address ;
    private int sex ;
    private String tel ;

    public Student() {
    }

    public Student(String idStudent, String studentName, String idClass, String course, String birthday, String address, int sex, String tel) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.idClass = idClass;
        this.course = course;
        this.birthday = birthday;
        this.address = address;
        this.sex = sex;
        this.tel = tel;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

}
