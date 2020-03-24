
package injection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Bernd OK
 */
public class PasswordSafe {

    public static boolean validate(String user, String password) {
        final String driverName = "com.mysql.cj.jdbc.Driver";
        final String dbURL = "jdbc:mysql://localhost/Users?user=abc&password=abc";
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(dbURL);

            String sql = "SELECT * from Users WHERE Uname = ? AND Passwd = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(" " + rs.getString(2));
                System.out.println(" " + rs.getString(3));
                return true;
            }
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
}