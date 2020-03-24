/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Bernd OK
 */
public class CustomerAdmin {

    public static String getCustomer(String CustID) throws NotFoundException {
        final String driverName = "com.mysql.cj.jdbc.Driver";
        final String dbURL = "jdbc:mysql://localhost/Customers?user=abc&password=abc";
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String sql = "SELECT CName from Customers WHERE CustID = " + CustID;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception ex) { 
        	throw new NotFoundException();
        }
        return null;
    }
}