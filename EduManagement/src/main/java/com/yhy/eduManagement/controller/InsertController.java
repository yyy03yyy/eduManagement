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

public class InsertController {
    public TextField tfStudentName;
    public TextField tfStudentAge;
    public TextField tfStudentAddress;
    public ToggleGroup tgSex;
    public RadioButton rbMan;
    public RadioButton rbWoman;
    public Label studentResult;
    
    public TextField tfCourseName;
    public TextField tfCourseCredit;
    public RadioButton rbYun;
    public RadioButton rbJin;
    public Label courseResult;
    public RadioButton rbFlower;
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
    private void onInsertStudentClicked() throws SQLException {
        int sex = getSexType();
        if (sex==-1){
            courseResult.setText("请选择性别");
            return;
        }
        int id = StudentDao.insertStudent(new Student(tfStudentName.getText(),sex,Integer.parseInt(tfStudentAge.getText()),tfStudentAddress.getText()));
        studentResult.setText("生成"+id+"号学生");
    }
    @FXML
    private void onInsertCourseClicked() throws SQLException {
        int address = getAddressType();
        if (address==-1){
            courseResult.setText("请选择校区");
            return;
        }
        int id = CourseDao.insertCourse(new Course(tfCourseName.getText(),address,Integer.parseInt(tfCourseCredit.getText())));
        courseResult.setText("生成"+id+"号课程");
    }
    @FXML
    private void onInsertGradeClicked() throws SQLException {
        GradeDao.insertGrade(new Grade(Integer.parseInt(tfSno.getText()),Integer.parseInt(tfCno.getText()),Integer.parseInt(tfGrade.getText())));
        gradeResult.setText("生成学生选课情况成功");
    }
    private int getSexType(){
        if (rbMan.isSelected())return 1;
        else if (rbWoman.isSelected())return 2;
        else return -1;
    }
    private int getAddressType(){
        if (rbYun.isSelected())return 1;
        else if (rbJin.isSelected())return 2;
        else return -1;
    }
}
