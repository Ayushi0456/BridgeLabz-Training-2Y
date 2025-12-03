package com.srms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public void insertStudent(Student s, Marks m, double percentage, String grade) {
        try {
            Connection con = DatabaseManager.getConnection();
            String query = "INSERT INTO students VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, s.getRollNo());
            ps.setString(2, s.getName());
            ps.setInt(3, m.getMaths());
            ps.setInt(4, m.getScience());
            ps.setInt(5, m.getEnglish());
            ps.setDouble(6, percentage);
            ps.setString(7, grade);

            ps.executeUpdate();
            System.out.println("✔ Student data inserted successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllStudents() {
        try {
            Connection con = DatabaseManager.getConnection();
            String query = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n----- All Students -----");

            while (rs.next()) {
                System.out.println("Roll: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Maths: " + rs.getInt(3));
                System.out.println("Science: " + rs.getInt(4));
                System.out.println("English: " + rs.getInt(5));
                System.out.println("Percentage: " + rs.getDouble(6));
                System.out.println("Grade: " + rs.getString(7));
                System.out.println("------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

