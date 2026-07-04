package com.navi.jdbclearning;
import java.sql.*;
public class LaunchApp1
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
        String sql = "INSERT INTO studentInfo(id,sname,sage,scity) VALUES (3, 'Rohit', 17, 'Pune')";
        int rowAffected = statement.executeUpdate(sql);
        //process the result
        if(rowAffected==0)
        {
            System.out.println("Unable to insert the data");
        }
        else
        {
            System.out.println("Data Inserted Successfully!");
        }

        //close the resources
        statement.close();
        connect.close();
    }
}
