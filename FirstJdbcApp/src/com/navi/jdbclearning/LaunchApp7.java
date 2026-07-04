package com.navi.jdbclearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchApp7
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

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter info that need to be updated");
            System.out.println("Kindly enter your id: ");
            int id = scan.nextInt();
            System.out.println("Please enter your age to be updated");
            Integer age = scan.nextInt();

            pstmnt.setInt(1,age);
            pstmnt.setInt(2,id);

            int rowsAffected = pstmnt.executeUpdate();
            //process the result
            if(rowsAffected==0)
            {
                System.out.println("Unable to update the data");
            }
            else
            {
                System.out.println("Data Updated Successfully!");
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
