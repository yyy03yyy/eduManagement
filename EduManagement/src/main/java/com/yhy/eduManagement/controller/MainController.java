package com.yhy.eduManagement.controller;

import com.yhy.eduManagement.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public Button btnInsert;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnQuery;

    /**
     * 当插入按钮被点击时触发
     */
    @FXML
    private void onInsertButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/InsertPage.fxml"));//跳转对应界面
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnInsert.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * 当删除按钮被点击时触发
     */
    @FXML
    private void onDeleteButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/DeletePage.fxml"));//跳转对应界面
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnDelete.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * 当修改按钮被点击时触发
     */
    @FXML
    private void onUpdateButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/UpdatePage.fxml"));//跳转对应界面
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnUpdate.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * 当查询按钮被点击时触发
     */
    @FXML
    private void onQueryButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/QueryPage.fxml"));//跳转对应界面
        Scene scene = new Scene(fxmlLoader.load());
        Stage primaryStage = (Stage) btnQuery.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void test(){
        System.out.println("点击测试");
    }
}
