package com.navi.jdbclearning;

import java.sql.*;

public class LaunchApp4
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
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

        String sql = "DELETE FROM studentInfo WHERE id=2;";
        int rowAffected = statement.executeUpdate(sql);

        //process the result
        if(rowAffected==0)
            System.out.println("Failed to delete the record");
        else
            System.out.println("Record deleted Successfully");
        //close the resources

        statement.close();
        connect.close();

    }
}
