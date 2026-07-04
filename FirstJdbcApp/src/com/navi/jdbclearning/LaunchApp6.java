package com.navi.jdbclearning;

import java.sql.*;
import java.util.Scanner;

public class LaunchApp6
{
    public static void main(String[] args)
    {
        Connection connect = null;
        Statement statement;
        PreparedStatement pstmnt = null;

        try
        {
            connect = JdbcUtil.getConnection();


        //creating Statement
//        statement = connect.createStatement();

        //execute query

            //execute query
            String query = "INSERT INTO studentInfo(id,sname,sage,scity) VALUES (?,?,?,?)";
            pstmnt = connect.prepareStatement(query);

            System.out.println("Please enter the following details to be stored in DB");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter yout id");
            Integer id = scan.nextInt();

            System.out.println("Enter your name");
            String name = scan.next();

            System.out.println("Enter your age");
            Integer age = scan.nextInt();

            System.out.println("Enter your city");
            String city = scan.next();

            pstmnt.setInt(1,id);
            pstmnt.setString(2,name);
            pstmnt.setInt(3,age);
            pstmnt.setString(4,city);


            int rowAffected = pstmnt.executeUpdate();
            //process the result
            if(rowAffected==0)
            {
                System.out.println("Unable to insert the data");
            }
            else
            {
                System.out.println("Data Inserted Successfully!");
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
