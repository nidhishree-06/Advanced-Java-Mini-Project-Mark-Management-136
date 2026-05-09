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

        String sql = "INSERT INTO StudentMarks (StudentName, Subject, Marks, ExamDate) VALUES (?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, m.getStudentName());
        ps.setString(2, m.getSubject());
        ps.setInt(3, m.getMarks());
        ps.setString(4, m.getExamDate());

        int rows = ps.executeUpdate();

        if (rows > 0) {

            ResultSet rs = ps.getGeneratedKeys();

            if (rs != null && rs.next()) {
                return rs.getInt(1);   // ✅ THIS IS THE FIX
            }
        }

        return -1;   // return -1 instead of 0 (better debugging)
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

        String sql = "DELETE FROM StudentMarks WHERE StudentID=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int status = ps.executeUpdate();

        return status;
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
    public List<StudentMark> getFailStudents() throws Exception {

        Connection con = getConnection();

        String sql = "SELECT * FROM StudentMarks WHERE Marks < 35";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<StudentMark> list = new ArrayList<>();

        while(rs.next()) {

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
    public List<StudentMark> getPassStudents() throws Exception {

        Connection con = getConnection();

        String sql = "SELECT * FROM StudentMarks WHERE Marks >= 35";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<StudentMark> list = new ArrayList<>();

        while(rs.next()) {

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
    public List<StudentMark> getStudentsByGradeAndSubject(
            String subject,
            String result) throws Exception {

        Connection con = getConnection();

        String sql;

        if(result.equals("pass")) {

            sql = "SELECT * FROM StudentMarks "
                + "WHERE Subject=? AND Marks >= 35";

        } else {

            sql = "SELECT * FROM StudentMarks "
                + "WHERE Subject=? AND Marks < 35";
        }

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, subject);

        ResultSet rs = ps.executeQuery();

        List<StudentMark> list =
                new ArrayList<>();

        while(rs.next()) {

            StudentMark m = new StudentMark();

            m.setStudentId(
                    rs.getInt("StudentID"));

            m.setStudentName(
                    rs.getString("StudentName"));

            m.setSubject(
                    rs.getString("Subject"));

            m.setMarks(
                    rs.getInt("Marks"));

            m.setExamDate(
                    rs.getString("ExamDate"));

            list.add(m);
        }

        return list;
    }
    public StudentMark getStudentById(int id)
            throws Exception {

        Connection con = getConnection();

        String sql =
            "SELECT * FROM StudentMarks WHERE StudentID=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        StudentMark m = null;

        if(rs.next()) {

            m = new StudentMark();

            m.setStudentId(
                    rs.getInt("StudentID"));

            m.setStudentName(
                    rs.getString("StudentName"));

            m.setSubject(
                    rs.getString("Subject"));

            m.setMarks(
                    rs.getInt("Marks"));

            m.setExamDate(
                    rs.getString("ExamDate"));
        }

        return m;
    }
    public List<StudentMark> searchById(int id)
            throws Exception {

        Connection con = getConnection();

        String sql =
            "SELECT * FROM StudentMarks WHERE StudentID=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        List<StudentMark> list =
                new ArrayList<>();

        while(rs.next()) {

            StudentMark m = new StudentMark();

            m.setStudentId(
                    rs.getInt("StudentID"));

            m.setStudentName(
                    rs.getString("StudentName"));

            m.setSubject(
                    rs.getString("Subject"));

            m.setMarks(
                    rs.getInt("Marks"));

            m.setExamDate(
                    rs.getString("ExamDate"));

            list.add(m);
        }

        return list;
    }
}