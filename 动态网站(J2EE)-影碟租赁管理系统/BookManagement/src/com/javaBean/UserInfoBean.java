package com.javaBean;

public class UserInfoBean {
	
	private String userID;				//用户ID
    private String userPassword;		//密码
    private String userName;			//姓名
    private String userSex;				//性别
    private String userPhone;			//电话
    private String userEmail;			//邮箱
    
    public UserInfoBean() {
        userID = "";
        userPassword = "";
        userName = "";
        userSex = "";
        userPhone = "";
        userEmail = "";
    }

    public UserInfoBean(String userID, String userPassword, String userName, 
    		String userSex, String userPhone, String userEmail) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
    }

    public String getUserID() {
        return userID;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getUserSex() {
        return userSex;
    }
    
    public String getUserPhone() {
        return userPhone;
    }
    
    public String getU_email() {
        return userEmail;
    }
    
    public void setUserID(String userID) {
    	this.userID = userID;
    }

    public void setUserPassword(String userPassword) {
    	this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
    	this.userName = userName;
    }

    public void setUserSex(String userSex) {
    	this.userSex = userSex;
    }

    public void setUserPhone(String userPhone) {
    	this.userPhone = userPhone;
    }

    public void setUserEmail(String userEmail) {
    	this.userEmail = userEmail;
    }
    
}
