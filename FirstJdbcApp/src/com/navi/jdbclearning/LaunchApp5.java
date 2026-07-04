package com.navi.jdbclearning;

import java.sql.*;

public class LaunchApp5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connect = null;
        Statement statement = null;

        try {
            connect = JdbcUtil.getConnection();


            //creating Statement
            statement = connect.createStatement();

            //execute query

            String sql = "UPDATE studentInfo SET sage=16 WHERE id=1";
            boolean status = statement.execute(sql);

            //process the result
            if (status) {
                System.out.println("If Block");
                //select
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
                }
            } else {
                //insert, update, delete
                System.out.println("Else Block");
                int rowsAffected = statement.getUpdateCount();
                if (rowsAffected == 0)
                    System.out.println("Operation failed");
                else
                    System.out.println("Operation successfull!");
            }
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

            //close the resources
             finally
            {
                //close the resources
                try
                {
                    JdbcUtil.closeConnection(connect,statement);
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }


    }
}