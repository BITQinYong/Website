package com.javaBean;

public class BookInfoBean {
	
	 private String bookID;					//ͼ��ID
	 private String bookType;				//ͼ�����
	 private String bookName;				//ͼ������
	 private String bookAuthor;				//ͼ������
	 private String bookPublisher;			//ͼ�������
	 private String bookPublicTime;			//ͼ��������
	 private String bookPlace;				//ͼ�����λ��
	 private String bookBorrowCondition;	//ͼ�����״̬
	    
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
