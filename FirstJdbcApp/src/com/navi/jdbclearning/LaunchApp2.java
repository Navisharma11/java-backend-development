package com.navi.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp2
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

        String sql = "UPDATE studentInfo SET sage=24 WHERE id=2";
        int rowAffected = statement.executeUpdate(sql);
        //process the result
        if(rowAffected==0)
        {
            System.out.println("Updation failed");
        }
        else
        {
            System.out.println("Update successfull!");
        }

        //close the resources
        statement.close();
        connect.close();
    }
}
