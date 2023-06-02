package com.yhy.eduManagement.dao;

import com.yhy.eduManagement.entity.Course;
import com.yhy.eduManagement.util.DBTool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    public static List<Course> selectCourses() throws SQLException {
        String sql = "select * from course";
        Statement statement = DBTool.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Course> courses = new ArrayList<>();
        while (resultSet.next()) {
            Course course = new Course();
            course.setNo(resultSet.getInt("no"));
            course.setName(resultSet.getString("name"));
            course.setAddress(resultSet.getInt("address"));
            course.setCredit(resultSet.getInt("credit"));
            course.setAddressName(getCourseAddressName(course.getAddress()));
            courses.add(course);
        }
        return courses;
    }

    public static List<Course> selectCourses(String where) throws SQLException {
        String sql = "select * from course where " + where;
        Statement statement = DBTool.getConn().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Course> courses = new ArrayList<>();
        while (resultSet.next()) {
            Course course = new Course();
            course.setNo(resultSet.getInt("no"));
            course.setName(resultSet.getString("name"));
            course.setAddress(resultSet.getInt("address"));
            course.setCredit(resultSet.getInt("credit"));
            course.setAddressName(getCourseAddressName(course.getAddress()));
            courses.add(course);
        }
        return courses;
    }
    private static String getCourseAddressName(int address){
        if (address==1) return "云塘";
        else return "金盆岭";
    }
    public static int insertCourse(Course course) throws SQLException {
        String sql = "insert into course(name,address,credit) values('" + course.getName() + "'," + course.getAddress() + "," + course.getCredit() + ")";
        System.out.println(sql);
        Statement statement = DBTool.getConn().createStatement();
        statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }
    public static int updateCourse(Course course) throws SQLException {
        String sql = "update course set name='" + course.getName() + "',address=" +
                course.getAddress() + ",credit=" + course.getCredit() +
                " where no=" + course.getNo();
        Statement statement = DBTool.getConn().createStatement();
        return statement.executeUpdate(sql);//返回所影响的行数
    }
    public static int deleteCourse(Course course) throws SQLException {
        String sql = "delete from course where no="+course.getNo();
        Statement statement = DBTool.getConn().createStatement();
        return statement.executeUpdate(sql);//返回所影响的行数
    }
}
