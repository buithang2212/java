/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import Model.GiangVien;
import Model.Lop;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgoTheHai
 */
public class LopQuery {
    public List<Lop> getAllLop(){
        List<Lop> l = new ArrayList<>();
        try {
            Statement st = BKConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT maLop,tenLop,l.idKhoa,tenKhoa,l.idHDT,tenHDT,l.idBDT,tenBDT FROM tblLop l, tblKhoa k, tblHeDaoTao hdt, tblBacDaoTao bdt WHERE l.idKhoa = k.MaKhoa AND l.idHDT = hdt.MaHDT AND l.idBDT = bdt.MaBDT");
            while(rs.next())
            {
                Lop lh = new Lop(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8));
                l.add(lh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    public boolean insert(Lop l){
        String sql = "INSERT INTO tblLop VALUES(?,?,?,?)";
        
        try {
            PreparedStatement pStt = BKConnection.getConnection().prepareStatement(sql);
            pStt.setString(1, l.getTenLop());
            pStt.setInt(2, l.getMaKhoa());
            pStt.setInt(3, l.getMaHDT());
            pStt.setInt(4, l.getMaBDT());
            
            return pStt.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(LopQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean update(Lop l){
        String sql = "UPDATE tblLop SET TenLop = ?, idKhoa =?, idHDT = ? ,idBDT = ? WHERE MaLop = ?";
        
        try {
            PreparedStatement pStt = BKConnection.getConnection().prepareStatement(sql);
            
            pStt.setString(1, l.getTenLop());
            pStt.setInt(2, l.getMaKhoa());
            pStt.setInt(3, l.getMaHDT());
            pStt.setInt(4, l.getMaBDT());
            pStt.setInt(5, l.getMaLop());
            return pStt.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(LopQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(String id){
        String sql = "DELEtE FROM tblLop WHERE MaLop = ?";
        
        try {
            PreparedStatement pStt = BKConnection.getConnection().prepareStatement(sql);
            pStt.setString(1, id);
            return pStt.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(LopQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
