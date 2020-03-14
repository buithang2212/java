/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author NgoTheHai
 */
public class GiangVien {
    private int maGV;
    private String tenGV;
    private Boolean gioiTinh;
    private Date ngaySinh;
    private String email;
    private String soDT;
    private String diaChi;
    private String hocVi;
    private String chucVu;
    private int maKhoa;
    private String tenKhoa;

    public GiangVien() {
    }

    public GiangVien(int maGV, String tenGV, Boolean gioiTinh, Date ngaySinh, String email, String soDT, String diaChi, String hocVi, String chucVu, int maKhoa, String tenKhoa) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.hocVi = hocVi;
        this.chucVu = chucVu;
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    

   

    public GiangVien(String tenGV, Boolean gioiTinh, Date ngaySinh, String email, String soDT, String diaChi, String hocVi, String chucVu, int maKhoa) {
        this.tenGV = tenGV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.hocVi = hocVi;
        this.chucVu = chucVu;
        this.maKhoa = maKhoa;
    }

    
    
    public GiangVien(int maGV, String tenGV, Boolean gioiTinh, Date ngaySinh, String email, String soDT, String diaChi, String hocVi, String chucVu, int maKhoa) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.hocVi = hocVi;
        this.chucVu = chucVu;
        this.maKhoa = maKhoa;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
    
}
