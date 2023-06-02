package com.yhy.eduManagement.dao;

import com.yhy.eduManagement.entity.Grade;
import com.yhy.eduManagement.util.DBTool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeDao {
    public static List<Grade> selectGrades() throws SQLException {
        String sql = "select * from grade";
        Statement statement = DBTool.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Grade> grades = new ArrayList<>();
        while (resultSet.next()) {
            Grade grade = new Grade();
            grade.setSno(resultSet.getInt("Sno"));
            grade.setCno(resultSet.getInt("Cno"));
            grade.setGrade(resultSet.getInt("grade"));
            grades.add(grade);
        }
        return grades;
    }

    public static List<Grade> selectGrades(String where) throws SQLException {
        String sql = "select * from grade where " + where;
        Statement statement = DBTool.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Grade> grades = new ArrayList<>();
        while (resultSet.next()) {
            Grade grade = new Grade();
            grade.setSno(resultSet.getInt("Sno"));
            grade.setCno(resultSet.getInt("Cno"));
            grade.setGrade(resultSet.getInt("grade"));
            grades.add(grade);
        }
        return grades;
    }

    public static void insertGrade(Grade grade) throws SQLException {
        String sql = "insert into grade(Sno,Cno,grade) values('" + grade.getSno() + "'," + grade.getCno() + "," + grade.getGrade() + ")";
        System.out.println(sql);
        Statement statement = DBTool.getConn().createStatement();
        statement.executeUpdate(sql);
    }
    public static int updateGrade(Grade grade) throws SQLException {
        String sql = "update grade set Sno='" + grade.getSno() + "',Cno=" +
                grade.getCno() + ",grade=" + grade.getGrade() +
                " where Sno=" + grade.getSno()+" and Cno=" + grade.getCno();
        Statement statement = DBTool.getConn().createStatement();
        return statement.executeUpdate(sql);//返回所影响的行数
    }
    public static int deleteGrade(Grade grade) throws SQLException {
        String sql = "delete from grade where Sno="+grade.getSno()+" and Cno=" + grade.getCno();
        Statement statement = DBTool.getConn().createStatement();
        return statement.executeUpdate(sql);//返回所影响的行数
    }
}
