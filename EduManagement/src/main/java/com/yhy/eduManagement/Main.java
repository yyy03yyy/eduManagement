package com.yhy.eduManagement;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("img/csustIcon.png")));//设置应用左上角图标（选加）
        primaryStage.setTitle("长理教务管理系统");//设置应用上方标题
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}