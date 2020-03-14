/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import Model.Khoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lab06
 */
public class KhoaQuery {
    
    public List<Khoa> getKhoa() {
        List<Khoa> players = new ArrayList<>();
        try {
            Statement st = BKConnection.getConnection().createStatement();
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
}
