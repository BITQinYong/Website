package com.javaBean;

import java.sql.*;

public class DataBaseBean{

    private String driver;			//JDBC驱动程序
    private String url;				//URL
    private String username;		//登录用户名
    private String password;		//登录密码
    private Connection connection;	//数据库连接接口	
    private Statement statement;	//Statement对象
    private String message;			//消息
    
    public DataBaseBean() {
        driver = "com.mysql.jdbc.Driver";
        //url = "jdbc:mysql://localhost/BookManagement?useUnicode=true&characterEncoding=UTF-8";
        url = "jdbc:mysql://localhost/BookManagement?useUnicode=true&characterEncoding=UTF-8";
        username = "root";
        password = "";
        connection = null;
        statement = null;
        message = "";
    }

    public DataBaseBean(String driver, String url,
    		String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
        this.connection = null;
        this.statement = null;
        this.message = "";
    }

    public String getDriver() {
        return driver;
    }

    public String getURL() {
        return url;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public Statement getStatement() {
        return statement;
    }
    
    public String getMessage() {
        return message;
    }

    
    public void setDriver(String driver) {
    	this.driver = driver;
    }

    public void setURL(String url) {
    	this.url = url;
    }

    public void setUsername(String username) {
    	this.username = username;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public void setConnection(Connection connection) {
    	this.connection = connection;
    }

    public void setStatement(Statement statement) {
    	this.statement = statement;
    }

    public void setMessage(String message) {
    	this.message = message;
    }

    
    public void connect() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch(ClassNotFoundException classnotfoundexception) {
            message = (new StringBuilder()).append("connection:").
            		append(classnotfoundexception).toString();
        } catch(SQLException sqlexception) {
            message = (new StringBuilder()).append("executeQuery:").
            		append(sqlexception).toString();
        }
    }

    public ResultSet executeQuery(String s) {
        ResultSet resultset = null;
        try {
            resultset = statement.executeQuery(s);
        } catch(SQLException sqlexception) {
            message = (new StringBuilder()).append("executeQuery:").
            		append(sqlexception).toString();
        }
        return resultset;
    }

    public void executeUpdate(String s) {
        try {
            statement.executeUpdate(s);
        } catch(SQLException sqlexception) {
            message = (new StringBuilder()).append("executeUpdate:").
            		append(sqlexception).toString();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch(SQLException sqlexception) {
            message = (new StringBuilder()).append("closeConnection:").
            		append(sqlexception).toString();
        }
    }
    
}
