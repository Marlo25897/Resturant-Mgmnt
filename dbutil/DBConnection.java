/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
    private static Connection conn;
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-INVLS7L/XE","projectuser","java");
            JOptionPane.showMessageDialog(null,"Connected Successfully to the database","SUCCESS!",JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch(ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error loading Driver class"+ex,"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
         catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in Connection"+ex,"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return conn;
    }
    public static void closeConnection() {
        try {
            conn.close();
             JOptionPane.showMessageDialog(null,"Connection closed Successfully","SUCCESS!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in closing Connection"+ex,"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
}
