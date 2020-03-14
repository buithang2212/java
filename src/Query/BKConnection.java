/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NgoTheHai
 */
public class BKConnection {
    private static final String CHUOI_KET_NOI = "jdbc:sqlserver://localhost\\NTH\\NGOTHEHAI:1433;databaseName=JVP";
    private static final String TAI_KHOAN = "sa";
    private static final String MAT_KHAU = "1771999";
    
    public static Connection getConnection(){
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(CHUOI_KET_NOI,TAI_KHOAN,MAT_KHAU);
            return conn;
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
            return null;
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
            return null;
        }
    }
}
