package Query;

import java.util.List;
import Model.GiangVien;
import Model.Khoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GiangVienQuery {
    Connection con;

    public GiangVienQuery() {
        con = BKConnection.getConnection();
    
    }

    public List<GiangVien> getAll() {
        List<GiangVien> sv = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select maGV ,tenGV  , gioiTinh ,ngaySinh ,email,soDT ,diaChi ,hocVi ,chucVu  ,p.idKhoa, tenKhoa  from tblGiangVien p, tblKhoa c where p.idKhoa=c.MaKhoa");
            while(rs.next())
            {
                GiangVien p=new GiangVien(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),rs.getString(11));
                sv.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }
    public List<Khoa> getAll1() {
        List<Khoa> players = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tblKhoa");
            while(rs.next())
            {
                Khoa p=new Khoa(rs.getInt(1),rs.getString(2));
                players.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return players;
    }
    
    

    public boolean insert(GiangVien gv) {
        String sql = "INSERT INTO tblGiangVien(TenGV,GioiTinh,NgaySinh,Email,SoDT,DiaChi,HocVi,ChucVu,idKhoa) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pStt = BKConnection.getConnection().prepareStatement(sql);
            pStt.setString(1, gv.getTenGV());
            pStt.setBoolean(2, gv.getGioiTinh());
            pStt.setDate(3, gv.getNgaySinh());
            pStt.setString(4, gv.getEmail());
            pStt.setString(5, gv.getSoDT());
            pStt.setString(6, gv.getDiaChi());
            pStt.setString(7, gv.getHocVi());
            pStt.setString(8, gv.getChucVu());
            pStt.setInt(9, gv.getMaKhoa());
            
            return pStt.executeUpdate()>0;
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(GiangVien gv) {
        try {
            PreparedStatement pStt=con.prepareStatement("update tblGiangVien set TenGV=?, GioiTinh=?, NgaySinh=?, Email=?, SoDT=?, DiaChi=?, HocVi=?, ChucVu=?, idKhoa=? where MaGV=?");
            pStt.setString(1, gv.getTenGV());
            pStt.setBoolean(2, gv.getGioiTinh());
            pStt.setDate(3, gv.getNgaySinh());
            pStt.setString(4, gv.getEmail());
            pStt.setString(5, gv.getSoDT());
            pStt.setString(6, gv.getDiaChi());
            pStt.setString(7, gv.getHocVi());
            pStt.setString(8, gv.getChucVu());
            pStt.setInt(9, gv.getMaKhoa());
            pStt.setInt(10, gv.getMaGV());
            return pStt.executeUpdate()>0;
            
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
      
    }

    public boolean delete(String id) {
        String sql = "delete from tblGiangVien where MaGV=?";

        try {
            PreparedStatement pStt = BKConnection.getConnection().prepareStatement(sql);
            pStt.setString(1, id);
            pStt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return false;
        }
    }

    public List<GiangVien> search(String tenGV) {
        List<GiangVien> lstGV = new ArrayList<GiangVien>();
        String sql = "SELECT gv.MaGV,gv.TenGV,CASE WHEN gv.GioiTinh = 1 THEN 'Nam' WHEN gv.GioiTinh = 0 "
                + "THEN N'Nữ' END AS GioiTinh,gv.NgaySinh,gv.Email,gv.SoDT,gv.DiaChi,gv.HocVi, gv.ChucVu, kh.TenKhoa AS TenKhoa\n"
                + "FROM tblGiangVien gv INNER JOIN tblKhoa kh ON gv.idKhoa = kh.MaKhoa where gv.TenGV like N'%" + tenGV + "%'";
        try {
            PreparedStatement preparedStatement = BKConnection.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                GiangVien giangVien = new GiangVien();

                giangVien.setMaGV(rs.getInt("MaGV"));
                giangVien.setTenGV(rs.getNString("TenGV"));
                giangVien.setGioiTinh(rs.getBoolean("GioiTinh"));
                giangVien.setNgaySinh(rs.getDate("NgaySinh"));
                giangVien.setEmail(rs.getString("Email"));
                giangVien.setSoDT(rs.getString("SoDT"));
                giangVien.setDiaChi(rs.getNString("DiaChi"));
                giangVien.setHocVi(rs.getNString("HocVi"));
                giangVien.setChucVu(rs.getNString("ChucVu"));
                giangVien.setMaKhoa(rs.getInt("TenKhoa"));

                lstGV.add(giangVien);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
        }
        return lstGV;
    }

}
