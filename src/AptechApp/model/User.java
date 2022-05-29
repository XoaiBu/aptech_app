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
public class User {
    private String TenNguoiDung, MatKhau;
    private int VaiTro;

    public User() {
    }

    public User(String TenNguoiDung, String MatKhau, int VaiTro) {
        this.TenNguoiDung = TenNguoiDung;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public String getTenNguoiDung() {
        return TenNguoiDung;
    }

    public void setTenNguoiDung(String TenNguoiDung) {
        this.TenNguoiDung = TenNguoiDung;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public int getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(int VaiTro) {
        this.VaiTro = VaiTro;
    }
    
}
