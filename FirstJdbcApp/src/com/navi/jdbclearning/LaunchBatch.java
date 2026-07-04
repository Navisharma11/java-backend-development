package com.navi.jdbclearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchBatch
{
    public static void main(String[] args)
    {
        Connection connect = null;
        PreparedStatement pstmnt = null;

        try
        {
            connect = JdbcUtil.getConnection();

            String sql = "UPDATE studentInfo SET sage=? WHERE id=?";
            pstmnt = connect.prepareStatement(sql);



            pstmnt.setInt(1,20);
            pstmnt.setInt(2,1);
            pstmnt.addBatch();
            pstmnt.setInt(1,29);
            pstmnt.setInt(2,5);
            pstmnt.addBatch();
            pstmnt.setInt(1,21);
            pstmnt.setInt(2,11);
            pstmnt.addBatch();

            pstmnt.executeBatch();
            System.out.println("Check the db table to see the result");
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            //close the resources
            try
            {
                JdbcUtil.closeConnection(connect,pstmnt);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }
}
