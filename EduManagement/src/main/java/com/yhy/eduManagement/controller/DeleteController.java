package com.yhy.eduManagement.controller;

import com.yhy.eduManagement.dao.CourseDao;
import com.yhy.eduManagement.dao.GradeDao;
import com.yhy.eduManagement.dao.StudentDao;
import com.yhy.eduManagement.Main;
import com.yhy.eduManagement.entity.Course;
import com.yhy.eduManagement.entity.Student;
import com.yhy.eduManagement.entity.Grade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteController {

    public Label studentResult;
    public Label courseResult;
    public Label gradeResult;
    public Button btnBack;
    public TextField tfStudentNo;
    public TextField tfCourseNo;
    public TextField tfSno;
    public TextField tfCno;
    @FXML
    private void back() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/MainMenu.fxml"));//跳转对应界面
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private void onDeleteStudentClicked() throws SQLException {
        int id = Integer.parseInt(tfStudentNo.getText());
        if(StudentDao.deleteStudent(new Student(Integer.parseInt(tfStudentNo.getText())))!=0) {
            studentResult.setText("删除" + id + "号学生");
        }
        else{
            studentResult.setText("无此学生");
        }
    }
    @FXML
    private void onDeleteCourseClicked() throws SQLException {
        int id = Integer.parseInt(tfCourseNo.getText());
        if(CourseDao.deleteCourse(new Course(Integer.parseInt(tfCourseNo.getText())))!=0) {
            courseResult.setText("删除" + id + "号课程");
        }
        else{
            courseResult.setText("无此课程");
        }
    }
    @FXML
    private void onDeleteGradeClicked() throws SQLException {
        if(GradeDao.deleteGrade(new Grade(Integer.parseInt(tfSno.getText()),Integer.parseInt(tfCno.getText())))!=0) {
            gradeResult.setText("删除"+Integer.parseInt(tfSno.getText())+ "号学生对" + Integer.parseInt(tfCno.getText()) + "号课程的选课");
        }
        else{
            gradeResult.setText("无此选课");
        }
    }
}