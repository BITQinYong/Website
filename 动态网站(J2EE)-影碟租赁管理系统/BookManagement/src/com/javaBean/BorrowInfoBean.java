package com.javaBean;

public class BorrowInfoBean {
	
	private String userID;				//用户ID
	private String bookID;				//图书ID
	private String borrowBeginDate;		//借阅开始日期
	private String borrowEndDate;		//借阅截止日期
	
    public BorrowInfoBean() {
    	userID = "";
    	bookID = "";
    	borrowBeginDate = "";
    	borrowEndDate = "";
    }

    public BorrowInfoBean(String borrowID, String userID, String bookID,
    		String borrowBeginDate, String borrowEndDate) {
    	this.userID = userID;
    	this.bookID = bookID;
    	this.borrowBeginDate = borrowBeginDate;
    	this.borrowEndDate = borrowEndDate;
    }
    
    public String getUserID() {
        return userID;
    }

    public String getBookID() {
        return bookID;
    }
    
    public String getBorrowDate() {
        return borrowBeginDate;
    }
    
    public String getBorrowDuration() {
        return borrowEndDate;
    }
    
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    
    public void setBorrowDate(String borrowBeginDate) {
        this.borrowBeginDate = borrowBeginDate;
    }
    
    public void setBorrowDuration(String borrowEndDate) {
        this.borrowEndDate = borrowEndDate;
    }
    
}
