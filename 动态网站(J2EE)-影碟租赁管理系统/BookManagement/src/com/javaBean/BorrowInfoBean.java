package com.javaBean;

public class BorrowInfoBean {
	
	private String userID;				//�û�ID
	private String bookID;				//ͼ��ID
	private String borrowBeginDate;		//���Ŀ�ʼ����
	private String borrowEndDate;		//���Ľ�ֹ����
	
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
