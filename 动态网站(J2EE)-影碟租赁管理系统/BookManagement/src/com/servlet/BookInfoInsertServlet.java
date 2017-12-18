package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.javaBean.BookInfoBean;
import com.javaBean.DataBaseBean;

//插入图书信息
public class BookInfoInsertServlet extends HttpServlet {

    public BookInfoInsertServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        httpServletRequest.setCharacterEncoding("utf-8");
        if(httpSession.getAttribute("managerID") == null) {
        	httpServletResponse.sendRedirect("/BookManagement/managerLoginFail.jsp");
        } else {
        	String jspName = "/bookInfoManage.jsp";
        	BookInfoBean bookInfoBean = new BookInfoBean();
	        String bookID = httpServletRequest.getParameter("bookID").trim();
	        String bookType = httpServletRequest.getParameter("bookType").trim();
	        String bookName = httpServletRequest.getParameter("bookName").trim();
	        String bookAuthor = httpServletRequest.getParameter("bookAuthor").trim();
	        String bookPublisher = httpServletRequest.getParameter("bookPublisher").
	        		trim();
	        String bookPublicTime = httpServletRequest.getParameter("bookPublicTime").
	        		trim();
	        String bookPlace = httpServletRequest.getParameter("bookPlace").trim();
	        String bookBorrowCondition = "0-0-0";
	        DataBaseBean dataBaseBean = new DataBaseBean();
	        if(bookID.equals("")) {
	        	httpServletRequest.setAttribute("bookIDError", 
	        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
	            jspName = "/bookInfoInsert.jsp";
	        } else if(isBookIDExisting(bookID)) {
	        	httpServletRequest.setAttribute("bookIDRepeatError", 
	        			"*\u4E0E\u5176\u5B83\u56FE\u4E66\u7684ID\u51B2\u7A81\uFF01");
	        			//*与其它图书的ID冲突！
	            jspName = "/bookInfoInsert.jsp";
	        }
	        if(bookType.equals("")) {
	        	httpServletRequest.setAttribute("bookTypeError", 
	        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
	            jspName = "/bookInfoInsert.jsp";
	        }
	        if(bookName.equals("")) {
	        	httpServletRequest.setAttribute("bookNameError", 
	        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
	            jspName = "/bookInfoInsert.jsp";
	        }
	        if(bookAuthor.equals("")) {
	        	httpServletRequest.setAttribute("bookAuthorError", 
	        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
	            jspName = "/bookInfoInsert.jsp";
	        }
	        if(bookPublisher.equals("")) {
	        	httpServletRequest.setAttribute("bookPubliserError", 
	        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
	            jspName = "/bookInfoInsert.jsp";
	        }
	        if(bookPublicTime.equals("")) {
	        	httpServletRequest.setAttribute("bookPublicTimeError", 
	        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
	            jspName = "/bookInfoInsert.jsp";
	        }
	        if(bookPlace.equals("")) {
	        	httpServletRequest.setAttribute("bookPlaceError", 
	        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
	            bookInfoBean.setBookPlace("*\u672C\u9879\u5FC5\u987B\u586B\u5199!");
	            jspName = "/bookInfoInsert.jsp";
	        }
	        
	        if(jspName.equals("/bookInfoManage.jsp")) {
	            String insertBookInfo = (new StringBuilder()).
	            		append("INSERT INTO BookInfo VALUES('").append(bookID).
	            		append("'").append(",").append("'").append(bookType).
	            		append("'").append(",").append("'").append(bookName).
	            		append("'").append(",").append("'").append(bookAuthor).
	            		append("'").append(",").append("'").append(bookPublisher).
	            		append("'").append(",").append("'").append(bookPublicTime).
	            		append("'").append(",").append("'").append(bookPlace).
	            		append("'").append(",").append("'").append(bookBorrowCondition).
	            		append("'").append(")").toString();
	            System.out.println(insertBookInfo);
	            dataBaseBean.connect();
	            dataBaseBean.executeUpdate(insertBookInfo);
	            dataBaseBean.closeConnection();
	            if(httpSession.getAttribute("booklist") != null) {
	                httpSession.removeAttribute("booklist");
	            }
	        }
	        RequestDispatcher requestDispatcher = httpServletRequest.
	        		getRequestDispatcher(jspName);
	        requestDispatcher.forward(httpServletRequest, httpServletResponse);
	    }
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
            doGet(httpServletRequest, httpServletResponse);
        }
    
    public boolean isBookIDExisting(String bookID) {
        boolean bookIDExistingFlag = false;
        String judgeBookID = (new StringBuilder()).
        		append("SELECT * FROM BookInfo WHERE bookID = '").
        		append(bookID).append("'").toString();
        DataBaseBean dataBaseBean = new DataBaseBean();
        dataBaseBean.connect();
        ResultSet resultSet = dataBaseBean.executeQuery(judgeBookID);
        try	{
            if(resultSet.next()) {
            	bookIDExistingFlag = true;
            }
        } catch(SQLException sqlexception) {
            System.err.println((new StringBuilder()).
            		append("Error with connection:").
            		append(sqlexception).toString());
        }
        dataBaseBean.closeConnection();
        return bookIDExistingFlag;
    }
    
}
