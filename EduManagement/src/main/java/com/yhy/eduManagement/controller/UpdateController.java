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

public class UpdateController {

    public TextField tfStudentNo;
    public TextField tfStudentName;
    public TextField tfStudentAddress;
    public TextField tfStudentAge;
    public RadioButton rbMan;
    public RadioButton rbWoman;
    public ToggleGroup student;
    public Label studentResult;

    public TextField tfCourseNo;
    public TextField tfCourseName;
    public TextField tfCourseCredit;
    public RadioButton rbYun;
    public RadioButton rbJin;
    public ToggleGroup course;
    public Label courseResult;
    
    public TextField tfSno;
    public TextField tfCno;
    public TextField tfGrade;
    public Label gradeResult;
    public Button btnBack;

    @FXML
    private void back() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/MainMenu.fxml"));//跳转对应界面
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private void onUpdateStudentClicked() throws SQLException {
        int id = Integer.parseInt(tfStudentNo.getText());
        int type = getSex();
        if (type==-1){
            studentResult.setText("请选择性别");
            return;
        }
        int t=StudentDao.updateStudent(new Student(
                Integer.parseInt(tfStudentNo.getText()),
                tfStudentName.getText(),
                type,
                Integer.parseInt(tfStudentAge.getText()),
                tfStudentAddress.getText()));
        if(t!=0) {
            studentResult.setText("修改" + id + "号学生");
        }
        else{
            studentResult.setText("无此学号学生");
        }
    }
    @FXML
    private void onUpdateCourseClicked() throws SQLException {
        int type = getAddress();
        if (type==-1){
            courseResult.setText("请选择上课地点");
            return;
        }
        int t = CourseDao.updateCourse(new Course(Integer.parseInt(tfCourseNo.getText()),tfCourseName.getText(),type,Integer.parseInt(tfCourseCredit.getText())));
        if(t!=0) {
            courseResult.setText("修改" + Integer.parseInt(tfCourseNo.getText()) + "号课程");
        }
        else{
            gradeResult.setText("无该编号课程");
        }
    }
    @FXML
    private void onUpdateGradeClicked() throws SQLException {
        int t = GradeDao.updateGrade(new Grade(Integer.parseInt(tfSno.getText()),Integer.parseInt(tfCno.getText()),Integer.parseInt(tfGrade.getText())));
        if(t!=0) {
            gradeResult.setText("修改成绩为" + Integer.parseInt(tfGrade.getText()));
        }
        else{
            gradeResult.setText(Integer.parseInt(tfSno.getText()) + "号学生未选修" + Integer.parseInt(tfCno.getText()) + "号课程");
        }
    }
    private int getSex(){
        if (rbMan.isSelected())return 1;
        else if (rbWoman.isSelected())return 2;
        else return -1;
    }
    private int getAddress(){
        if (rbYun.isSelected())return 1;
        else if (rbJin.isSelected())return 2;
        else return -1;
    }
}