package com.javaBean;

public class BookInfoBean {
	
	 private String bookID;					//图书ID
	 private String bookType;				//图书类别
	 private String bookName;				//图书名称
	 private String bookAuthor;				//图书作者
	 private String bookPublisher;			//图书出版社
	 private String bookPublicTime;			//图书出版年份
	 private String bookPlace;				//图书放置位置
	 private String bookBorrowCondition;	//图书借阅状态
	    
    public BookInfoBean() {
    	bookID = "";
    	bookType = "";
    	bookName = "";
    	bookAuthor = "";
    	bookPublisher = "";
    	bookPlace = "";
    	bookPublicTime = "";
    	bookBorrowCondition = "";
    }

    public BookInfoBean(String bookID, String bookType, String bookName, 
    		String bookAuthor, String bookPublisher, String bookPlace, 
    		String bookPublicTime, String bookBorrowCondition) {
        this.bookID = bookID;
        this.bookType = bookType;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookPlace = bookPlace;
    	this.bookPublicTime = bookPublicTime;
    	this.bookBorrowCondition = bookBorrowCondition;
    }

    public String getBookID() {
        return bookID;
    }
    
    public String getBookType() {
        return bookType;
    }
    
    public String getBookName() {
        return bookName;
    }
    
    public String getBookAuthor() {
        return bookAuthor;
    }
    
    public String getBookPublisher() {
        return bookPublisher;
    }
    
    public String getBookPublicTime() {
        return bookPublicTime;
    }
    
    public String getBookPlace() {
        return bookPlace;
    }
    
    public String getBookBorrowCondition() {
    	return bookBorrowCondition;
    }
    
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }   

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public void setBookPublicTime(String bookPublicTime) {
    	this.bookPublicTime = bookPublicTime;
    }

    public void setBookPlace(String bookPlace) {
        this.bookPlace = bookPlace;
    }
    
    public void setBookBorrowCondition(String bookBorrowCondition) {
        this.bookBorrowCondition = bookBorrowCondition;
    }
    
}
