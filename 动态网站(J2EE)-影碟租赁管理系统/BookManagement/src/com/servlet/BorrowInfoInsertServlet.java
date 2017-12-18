package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.BorrowInfoBean;
import com.javaBean.DataBaseBean;

//插入借阅信息
public class BorrowInfoInsertServlet extends HttpServlet {

    public BorrowInfoInsertServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jspName = "/borrowInfoManage.jsp";
        if(httpSession.getAttribute("managerID") == null) {
            jspName = "/managerLoginFail.jsp";
        } else {
            String userID = httpServletRequest.getParameter("userID");
            String bookID = httpServletRequest.getParameter("bookID");
            String borrowBeginDate = httpServletRequest.getParameter("borrowBeginDate");
            String borrowEndDate = httpServletRequest.getParameter("borrowEndDate");
            DataBaseBean dataBaseBean = new DataBaseBean();
            if(userID.equals("")) {
            	httpServletRequest.setAttribute("userIDError", 
            			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
                jspName = "/borrowInfoInsert.jsp";
            } 
            if(bookID.equals("")) {
            	httpServletRequest.setAttribute("bookIDError", 
            			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
                jspName = "/borrowInfoInsert.jsp";
            } else if(isBookIDExisting(bookID)) {
            	httpServletRequest.setAttribute("bookIDRepeatError", 
            			"*\u4E0E\u5176\u5B83\u56FE\u4E66\u7684ID\u51B2\u7A81\uFF01");
            			//*与其它图书的ID冲突！
                jspName = "/borrowInfoInsert.jsp";
            }
            if(borrowBeginDate.equals("")) {
            	httpServletRequest.setAttribute("borrowBeginDateError", 
            			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
                jspName = "/borrowInfoInsert.jsp";
            }
            if(borrowEndDate.equals("")) {
            	httpServletRequest.setAttribute("borrowEndDateError", 
            			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
                jspName = "/borrowInfoInsert.jsp";
            }
            if(jspName.equals("/borrowInfoManage.jsp")) {
            	dataBaseBean.connect();
            	String insertBorrowInfo = (new StringBuilder()).
            				append("INSERT INTO BorrowInfo VALUES("+"'" + userID + 
            				"','" + bookID + "','" + borrowBeginDate + "','" + 
            				borrowEndDate + "')").toString();
			    dataBaseBean.executeUpdate(insertBorrowInfo);
			    String updateBookInfo = (new StringBuilder()).append("UPDATE BookInfo SET "
	            		+ "bookBorrowCondition = '" + borrowBeginDate + "' WHERE bookID = '" + 
			    		bookID + "'").toString();
			    dataBaseBean.executeUpdate(updateBookInfo);
			    dataBaseBean.closeConnection();
			    httpSession.removeAttribute("userID");
			    httpSession.removeAttribute("bookID");
			    if(httpSession.getAttribute("booklist") != null) {
	                httpSession.removeAttribute("booklist");
	            }
            }
        } 
        RequestDispatcher requestDispatcher = httpServletRequest.
        		getRequestDispatcher(jspName);
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
    
    public boolean isBookIDExisting(String bookID) {
        boolean bookIDExistingFlag = false;
        String judgeBookID = (new StringBuilder()).
        		append("SELECT * FROM BorrowInfo WHERE bookID = '").
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
