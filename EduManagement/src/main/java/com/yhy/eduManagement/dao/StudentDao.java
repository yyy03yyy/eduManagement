package com.yhy.eduManagement.dao;

import com.yhy.eduManagement.entity.Student;
import com.yhy.eduManagement.util.DBTool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static List<Student> selectStudents() throws SQLException {
        String sql = "select * from student";
        Statement statement = DBTool.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setNo(resultSet.getInt("no"));
            student.setName(resultSet.getString("name"));
            student.setSex(resultSet.getInt("sex"));
            student.setAge(resultSet.getInt("age"));
            student.setAddress(resultSet.getString("address"));
            student.setSexName(getStudentSexName(student.getSex()));
            students.add(student);
        }
        return students;
    }

    public static List<Student> selectStudents(String where) throws SQLException {
        String sql = "select * from student where " + where;
        Statement statement = DBTool.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setNo(resultSet.getInt("no"));
            student.setName(resultSet.getString("name"));
            student.setSex(resultSet.getInt("sex"));
            student.setAge(resultSet.getInt("age"));
            student.setAddress(resultSet.getString("address"));
            student.setSexName(getStudentSexName(student.getSex()));
            students.add(student);
        }
        return students;
    }
    private static String getStudentSexName(int sex){
        if (sex==1) return "男";
        else return "女";
    }
    public static int insertStudent(Student student) throws SQLException {
        String sql = "insert into student(name,sex,age,address) values('" + student.getName() + "'," + student.getSex() + "," + student.getAge() + ",'" +student.getAddress() + "')";
        System.out.println(sql);
        Statement statement = DBTool.getConn().createStatement();
        statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }
    public static int updateStudent(Student student) throws SQLException {
        String sql = "update student set name='" + student.getName() + "',sex=" +
                student.getSex() + ",age=" + student.getAge() + ",address='" + student.getAddress() +
                "' where no=" + student.getNo();
        Statement statement = DBTool.getConn().createStatement();
        return statement.executeUpdate(sql);//返回所影响的行数
    }
    public static int deleteStudent(Student student) throws SQLException {
        String sql = "delete from student where no="+student.getNo();
        Statement statement = DBTool.getConn().createStatement();
        return statement.executeUpdate(sql);//返回所影响的行数
    }
}
