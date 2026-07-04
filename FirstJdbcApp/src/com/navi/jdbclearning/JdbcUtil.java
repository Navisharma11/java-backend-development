package com.navi.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil
{
    static
    {
        //Load and Register the Driver
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException
    {
        //Establish the connection
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "navi";
        String password ="password";
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection(Connection connect, Statement statement) throws SQLException {
        statement.close();
        connect.close();
    }

}
