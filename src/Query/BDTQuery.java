/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import Model.BacDaoTao;
import Model.Khoa;
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
public class BDTQuery {
    public List<BacDaoTao> getBacDaoTao() {
        List<BacDaoTao> bdt = new ArrayList<>();
        try {
            Statement st = BKConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from tblBacDaoTao");
            while(rs.next())
            {
                BacDaoTao p=new BacDaoTao(rs.getInt(1),rs.getString(2));
                bdt.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bdt;
    }
}
