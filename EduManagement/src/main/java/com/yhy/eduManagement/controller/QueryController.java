package com.yhy.eduManagement.controller;

import com.yhy.eduManagement.Main;
import com.yhy.eduManagement.dao.CourseDao;
import com.yhy.eduManagement.dao.GradeDao;
import com.yhy.eduManagement.dao.StudentDao;
import com.yhy.eduManagement.entity.Course;
import com.yhy.eduManagement.entity.Grade;
import com.yhy.eduManagement.entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.beans.Statement;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class QueryController {
    public Button btnBack;
    public RadioButton rbStudent;
    public RadioButton rbCourse;
    public RadioButton rbGrade;
    public ToggleGroup selectType;
    public TextField tfSno;
    public TextField tfSname;
    public TextField tfCno;
    public TextField tfCname;
    public GridPane gpStudent;
    public GridPane gpCourse;
    public TableView tableView;
    private int type = -1;
    private List<Student> students;
    private List<Course> courses;
    private List<Grade> grades;
    private static final List<String> studentColumnHeader;
    private static final List<String> studentFields;
    private static final List<String> courseColumnHeader;
    private static final List<String> courseFields;
    private static final List<String> gradeColumnHeader ;
    private static final List<String> gradeFields;
    static {
        studentColumnHeader= Arrays.asList("学生学号","学生名","性别","年龄","家庭住址");
        studentFields = Arrays.asList("no","name","sexName","age","address");
        courseColumnHeader = Arrays.asList("课程编号","课程名","上课地点","学分");
        courseFields = Arrays.asList("no","name","addressName","credit");
        gradeColumnHeader = Arrays.asList("学生学号","课程编号","成绩");
        gradeFields = Arrays.asList("Sno","Cno","grade");
    }
    @FXML
    private void back() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/MainMenu.fxml"));//跳转对应界面
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private void onQueryClicked() throws SQLException {
        type = getQueryType();
        if (type==-1) throw new InvalidParameterException("未知查询类型");
        boolean isAdded1 = false;
        StringBuilder sb1 = new StringBuilder();
        String idText1 = tfSno.getText();
        if (idText1.trim().length()!=0){
            sb1.append("no=").append(idText1);
            isAdded1 = true;
        }
        String nameText1 = tfSname.getText();
        if (nameText1.trim().length()!=0){
            if (isAdded1)sb1.append(" and ");
            sb1.append("name='").append(nameText1).append("'");
        }

        boolean isAdded2 = false;
        StringBuilder sb2 = new StringBuilder();
        String idText2 = tfCno.getText();
        if (idText2.trim().length()!=0){
            sb2.append("no=").append(idText2);
            isAdded2 = true;
        }
        String nameText2 = tfCname.getText();
        if (nameText2.trim().length()!=0){
            if (isAdded2)sb2.append(" and ");
            sb2.append("name='").append(nameText2).append("'");
        }

        boolean isAdded3 = false;
        StringBuilder sb3 = new StringBuilder();
        if (idText1.trim().length()!=0){
            sb3.append("Sno=").append(idText1);
            isAdded3 = true;
        }
        if (nameText1.trim().length()!=0){
            if (isAdded3)sb3.append(" and ");
            int i;
            List<Student> slist=StudentDao.selectStudents("name='"+nameText1+"'");
            for(i=0;i<slist.size();i++) {
                if(i>0) sb3.append(" or ");
                sb3.append("Sno=").append(slist.get(i).getNo());
            }
            if(slist.size()==0){
                sb3.append("Sno=0");
            }
            isAdded3 = true;
        }
        if (idText2.trim().length()!=0){
            if (isAdded3)sb3.append(" and ");
            sb3.append("Cno=").append(idText2);
            isAdded3 = true;
        }
        if (nameText2.trim().length()!=0){
            if (isAdded3)sb3.append(" and ");
            int i;
            List<Course> clist=CourseDao.selectCourses("name='"+nameText2+"'");
            for(i=0;i<clist.size();i++) {
                if(i>0) sb3.append(" or ");
                sb3.append("Cno=").append(clist.get(i).getNo());
            }
            if(clist.size()==0){
                sb3.append("Cno=0");
            }
        }
        ObservableList columns = tableView.getColumns();
        columns.clear();

        switch (type){
            case 1:
                if (sb1.length()==0)students = StudentDao.selectStudents();
                else students = StudentDao.selectStudents(sb1.toString());
                for (int i=0; i<studentColumnHeader.size();i++) {
                    TableColumn column = new TableColumn(studentColumnHeader.get(i));
                    column.setCellValueFactory(new PropertyValueFactory<>(studentFields.get(i)));
                    column.setStyle( "-fx-alignment: CENTER;");
                    columns.add(column);
                }
                tableView.setItems(FXCollections.observableArrayList(students));
                break;
            case 2:
                if (sb2.length()==0)courses = CourseDao.selectCourses();
                else courses = CourseDao.selectCourses(sb2.toString());
                for (int i=0; i<courseColumnHeader.size();i++) {
                    TableColumn column = new TableColumn(courseColumnHeader.get(i));
                    column.setCellValueFactory(new PropertyValueFactory<>(courseFields.get(i)));
                    column.setStyle( "-fx-alignment: CENTER;");
                    columns.add(column);
                }
                tableView.setItems(FXCollections.observableArrayList(courses));
                break;
            case 3:
                if (sb3.length()==0) grades = GradeDao.selectGrades();
                else grades = GradeDao.selectGrades(sb3.toString());
                for (int i=0; i<gradeColumnHeader.size();i++) {
                    TableColumn column = new TableColumn(gradeColumnHeader.get(i));
                    column.setCellValueFactory(new PropertyValueFactory<>(gradeFields.get(i)));
                    column.setStyle( "-fx-alignment: CENTER;");
                    columns.add(column);
                }tableView.setItems(FXCollections.observableArrayList(grades));
                break;
        }

    }
    private int getQueryType(){
        if (rbStudent.isSelected())return 1;
        else if (rbCourse.isSelected())return 2;
        else if (rbGrade.isSelected()) return 3;
        else return -1;
    }
    public void gpDisable(){
        type = getQueryType();
        if(type==1){
            gpStudent.setDisable(false);
            gpStudent.setVisible(true);
            gpCourse.setDisable(true);
            gpCourse.setVisible(false);
        }
        else if(type==2){
            gpStudent.setDisable(true);
            gpStudent.setVisible(false);
            gpCourse.setDisable(false);
            gpCourse.setVisible(true);
        }
        else if(type==3){
            gpStudent.setDisable(false);
            gpStudent.setVisible(true);
            gpCourse.setDisable(false);
            gpCourse.setVisible(true);
        }
    }
}