package com.navi.jdbclearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchApp8
{
    public static void main(String[] args)
    {
        Connection connect = null;
        PreparedStatement pstmnt = null;

        try
        {
            connect = JdbcUtil.getConnection();

            String sql = "DELETE FROM studentInfo WHERE id=?";
            pstmnt = connect.prepareStatement(sql);

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter info that need to be Deleted");
            System.out.println("Kindly enter your id: ");
            int id = scan.nextInt();

            pstmnt.setInt(1,id);

            int rowsAffected = pstmnt.executeUpdate();
            //process the result
            if(rowsAffected==0)
            {
                System.out.println("Unable to delete the data");
            }
            else
            {
                System.out.println("Data Deleted Successfully!");
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
