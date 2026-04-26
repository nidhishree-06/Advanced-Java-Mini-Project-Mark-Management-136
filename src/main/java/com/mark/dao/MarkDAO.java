package com.mark.dao;

import java.sql.*;
import java.util.*;
import com.mark.model.StudentMark;

public class MarkDAO {

    private String url = "jdbc:mysql://localhost:3306/MarkDB";
    private String user = "root";
    private String pass = "nidhi2006";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    // =========================
    // ADD MARK
    // =========================
    public int addMark(StudentMark m) throws Exception {

        Connection con = getConnection();

        String sql = "INSERT INTO StudentMarks (StudentID, StudentName, Subject, Marks, ExamDate) VALUES (?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, m.getStudentId());
        ps.setString(2, m.getStudentName());
        ps.setString(3, m.getSubject());
        ps.setInt(4, m.getMarks());
        ps.setString(5, m.getExamDate());

        return ps.executeUpdate();
    }

    // =========================
    // UPDATE ONLY MARKS
    // =========================
 // UPDATE ONLY MARKS (safe version)
    public int updateMark(int studentId, int marks) throws Exception {

        Connection con = getConnection();

        String sql = "UPDATE StudentMarks SET Marks=? WHERE StudentID=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, marks);
        ps.setInt(2, studentId);

        return ps.executeUpdate();
    }
    // =========================
    // DELETE MARK
    // =========================
    public int deleteMark(int id) throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM StudentMarks WHERE StudentID=?"
        );

        ps.setInt(1, id);

        return ps.executeUpdate();
    }

    // =========================
    // GET ALL MARKS
    // =========================
    public List<StudentMark> getAll() throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM StudentMarks"
        );

        ResultSet rs = ps.executeQuery();

        List<StudentMark> list = new ArrayList<>();

        while (rs.next()) {

            StudentMark m = new StudentMark();

            m.setStudentId(rs.getInt("StudentID"));
            m.setStudentName(rs.getString("StudentName"));
            m.setSubject(rs.getString("Subject"));
            m.setMarks(rs.getInt("Marks"));
            m.setExamDate(rs.getString("ExamDate"));

            list.add(m);
        }

        return list;
    }

    // =========================
    // MARKS ABOVE VALUE
    // =========================
    public List<StudentMark> getAboveMarks(int marks) throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM StudentMarks WHERE Marks > ?"
        );

        ps.setInt(1, marks);

        ResultSet rs = ps.executeQuery();

        List<StudentMark> list = new ArrayList<>();

        while (rs.next()) {

            StudentMark m = new StudentMark();

            m.setStudentId(rs.getInt("StudentID"));
            m.setStudentName(rs.getString("StudentName"));
            m.setSubject(rs.getString("Subject"));
            m.setMarks(rs.getInt("Marks"));
            m.setExamDate(rs.getString("ExamDate"));

            list.add(m);
        }

        return list;
    }

    // =========================
    // SUBJECT WISE REPORT
    // =========================
    public List<StudentMark> getBySubject(String subject) throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM StudentMarks WHERE Subject = ?"
        );

        ps.setString(1, subject);

        ResultSet rs = ps.executeQuery();

        List<StudentMark> list = new ArrayList<>();

        while (rs.next()) {

            StudentMark m = new StudentMark();

            m.setStudentId(rs.getInt("StudentID"));
            m.setStudentName(rs.getString("StudentName"));
            m.setSubject(rs.getString("Subject"));
            m.setMarks(rs.getInt("Marks"));
            m.setExamDate(rs.getString("ExamDate"));

            list.add(m);
        }

        return list;
    }

    // =========================
    // TOP N STUDENTS
    // =========================
    public List<StudentMark> getTopN(int n) throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM StudentMarks ORDER BY Marks DESC LIMIT ?"
        );

        ps.setInt(1, n);

        ResultSet rs = ps.executeQuery();

        List<StudentMark> list = new ArrayList<>();

        while (rs.next()) {

            StudentMark m = new StudentMark();

            m.setStudentId(rs.getInt("StudentID"));
            m.setStudentName(rs.getString("StudentName"));
            m.setSubject(rs.getString("Subject"));
            m.setMarks(rs.getInt("Marks"));
            m.setExamDate(rs.getString("ExamDate"));

            list.add(m);
        }

        return list;
    }
}