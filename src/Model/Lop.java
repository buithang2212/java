/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NgoTheHai
 */
public class Lop {
    private int maLop;
    private String tenLop;
    private int maKhoa;
    private String tenKhoa;
    private int maHDT;
    private String tenHDT;
    private int maBDT;
    private String tenBDT;

    public Lop() {
    }

    public Lop(int maLop, String tenLop, int maKhoa, String tenKhoa, int maHDT, String tenHDT, int maBDT, String tenBDT) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.maHDT = maHDT;
        this.tenHDT = tenHDT;
        this.maBDT = maBDT;
        this.tenBDT = tenBDT;
    }

    public Lop(String tenLop, int maKhoa, int maHDT, int maBDT) {
        this.tenLop = tenLop;
        this.maKhoa = maKhoa;
        this.maHDT = maHDT;
        this.maBDT = maBDT;
    }
    

    public Lop(int maLop, String tenLop, int maKhoa, int maHDT, int maBDT) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maKhoa = maKhoa;
        this.maHDT = maHDT;
        this.maBDT = maBDT;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
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

    public int getMaHDT() {
        return maHDT;
    }

    public void setMaHDT(int maHDT) {
        this.maHDT = maHDT;
    }

    public String getTenHDT() {
        return tenHDT;
    }

    public void setTenHDT(String tenHDT) {
        this.tenHDT = tenHDT;
    }

    public int getMaBDT() {
        return maBDT;
    }

    public void setMaBDT(int maBDT) {
        this.maBDT = maBDT;
    }

    public String getTenBDT() {
        return tenBDT;
    }

    public void setTenBDT(String tenBDT) {
        this.tenBDT = tenBDT;
    }
    
}
