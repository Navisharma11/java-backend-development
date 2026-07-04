package com.navi.jdbclearning;

import java.sql.*;

public class LaunchApp3
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Load and Register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Establish the connection

        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "navi";
        String password ="password";
        Connection connect = DriverManager.getConnection(url, user, password);


        //creating Statement
        Statement statement = connect.createStatement();

        //execute query
        String sql = "SELECT * FROM studentInfo";
        ResultSet rs = statement.executeQuery(sql);

        //process the result
        while(rs.next())
        {
//            int id = rs.getInt(1);
//            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            System.out.println(rs.getInt("id") + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));
        }

        //close the resources
        rs.close();
        statement.close();
        connect.close();

    }
}
