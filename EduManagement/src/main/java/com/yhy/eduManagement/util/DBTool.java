package com.yhy.eduManagement.util;

import java.sql.*;

public class DBTool {
    private static String databaseName = "eduManagement_202108060520";//数据库名字
    private static String username = "sa";//数据库超管账号，默认sa
    private static String password = "123";//数据库超管密码，安装时自己设置的
    private static Connection conn;//与数据库的连接
    public static Connection getConn() {
        return conn;
    }
    static {
        init();
    }
    public static boolean init(){
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;trustServerCertificate=true;databaseName=" + databaseName;
            conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("数据库初始化成功");
            return true;
        } catch (SQLException e) {
            System.out.println("数据库初始化失败");
            e.printStackTrace();
            return false;
        }
    }
}