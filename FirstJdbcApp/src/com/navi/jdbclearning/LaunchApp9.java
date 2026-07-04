package com.navi.jdbclearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchApp9
{
    public static void main(String[] args)
    {
        Connection connect = null;
        PreparedStatement pstmnt = null;
        ResultSet rs = null;

        try
        {
            connect = JdbcUtil.getConnection();

            String sql = "SELECT * FROM studentInfo WHERE id=?";
            pstmnt = connect.prepareStatement(sql);

            Scanner scan = new Scanner(System.in);
            System.out.println("Kindly enter your id for which Data to be Retrieved: ");
            Integer id = scan.nextInt();
            pstmnt.setInt(1,id);


            rs = pstmnt.executeQuery();
            //process the result
            if(rs.next())
            {
                Integer sid = rs.getInt(1);
                String name = rs.getString(2);
                Integer sage = rs.getInt(3);
                String scity = rs.getString(4);
                System.out.println(sid + " " + name + " " + sage + " " + scity);
            }
            else
            {
                System.out.println("There is no record with id " + id);
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
