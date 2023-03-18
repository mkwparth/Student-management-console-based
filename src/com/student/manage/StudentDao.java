package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insetStudentToDB(Student st){
        boolean f= false;
        // jdbc code

        try{
            Connection con = CP.createC();

            String q = "insert into students(sname, sphone, scity) values(?,?,?)";

            // prepared statement;
           PreparedStatement psmt = con.prepareStatement(q);

           // set the values
            psmt.setString(1,st.getStudentName());
            psmt.setString(2,st.getStudentPhone());
            psmt.setString(3,st.getStudentCity());

            // execute

            psmt.executeUpdate();
            f=true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {
        boolean f= false;
        // jdbc code

        try{
            Connection con = CP.createC();

            String q = "delete from students where sid=?";

            // prepared statement;
            PreparedStatement psmt = con.prepareStatement(q);

            // set the values
            psmt.setInt(1,userId);


            // execute

            psmt.executeUpdate();
            f=true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return f;

    }

    public static void showAllStudent() {

        // jdbc code

        try{
            Connection con = CP.createC();

            String q = "select * from students;";

            //   statement;
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(q);

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String city = resultSet.getString(4);

                System.out.println("ID :" + id);
                System.out.println("Name :" + name);
                System.out.println("Phone No :" + phone);
                System.out.println("City :" + city);
                System.out.println("+++++++++++++++++++++++++++++++++++++++");


            }


        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
