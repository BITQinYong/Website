package com.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.javaBean.BookInfoBean;
import com.javaBean.DataBaseBean;

//更新图书信息
public class BookInfoUpdateServlet extends HttpServlet {

    public BookInfoUpdateServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
    	javax.servlet.http.HttpSession httpSession = httpServletRequest.
    			getSession();
        String jspName = "/bookInfoManage.jsp";
        BookInfoBean bookBean = new BookInfoBean();
        httpServletRequest.setCharacterEncoding("GB2312");
        String bookID = httpServletRequest.getParameter("bookID").trim();
        String bookType = httpServletRequest.getParameter("bookType").trim();
        String bookName = httpServletRequest.getParameter("bookName").trim();
        String bookAuthor = httpServletRequest.getParameter("bookAuthor").trim();
        String bookPublisher = httpServletRequest.getParameter("bookPublisher").
        		trim();
        String bookPublicTime = httpServletRequest.getParameter("bookPublicTime").
        		trim();
        String bookPlace = httpServletRequest.getParameter("bookPlace").trim();
        String bookBorrowCondition = httpServletRequest.
        		getParameter("bookBorrowCondition").trim();
        DataBaseBean dataBaseBean = new DataBaseBean();
        if(bookName.equals("")) {
        	httpServletRequest.setAttribute("bookNameError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
        	//*本项必须填写!
            jspName = (new StringBuilder()).append("/bookInfoUpdate.jsp?bookID=").
            		append(bookID).toString();
        }
        if(bookAuthor.equals("")) {
        	httpServletRequest.setAttribute("bookAuthorError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
            jspName = (new StringBuilder()).append("/bookInfoUpdate.jsp?bookID=").
            		append(bookID).toString();
        }
        if(bookPublisher.equals("")) {
        	httpServletRequest.setAttribute("bookPublisherError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
            jspName = (new StringBuilder()).append("/bookInfoUpdate.jsp?bookID=").
            		append(bookID).toString();
        }
        if(bookPublicTime.equals("")) {
        	httpServletRequest.setAttribute("bookPublicTimeError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
            jspName = (new StringBuilder()).append("/bookInfoUpdate.jsp?bookID=").
            		append(bookID).toString();
        }
        if(bookPlace.equals("")) {
        	httpServletRequest.setAttribute("bookPlaceError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
            jspName = (new StringBuilder()).append("/bookInfoUpdate.jsp?bookID=").
            		append(bookID).toString();
        }
        if(bookBorrowCondition.equals("")) {
        	httpServletRequest.setAttribute("bookBorrowConditionError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
            jspName = (new StringBuilder()).append("/bookInfoUpdate.jsp?bookID=").
            		append(bookID).toString();
        }
        if(jspName.equals("/bookInfoManage.jsp")) {
            String updateBookInfo = (new StringBuilder()).append("UPDATE bookInfo SET"
            		+ " bookName='").append(bookName).append("'")
            		.append(",").append("bookAuthor=").append("'").
            		append(bookAuthor).append("'").append(",").
            		append("bookPublisher=").append("'").append(bookPublisher).
            		append("'").append(",").append("bookPublicTime=").append("'").
            		append(bookPublicTime).append("'").append(",").
            		append("bookPlace=").append("'").append(bookPlace).append("'").
            		append(",").append("bookBorrowCondition=").append("'").
            		append(bookBorrowCondition).append("'").append("WHERE bookID=").
            		append("'").append(bookID).append("'").toString();
            dataBaseBean.connect();
            dataBaseBean.executeUpdate(updateBookInfo);
            dataBaseBean.closeConnection();
            if(httpSession.getAttribute("booklist") != null) {
                httpSession.removeAttribute("booklist");
            }
        }
        RequestDispatcher requestdispatcher = httpServletRequest.
        		getRequestDispatcher(jspName);
        requestdispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
}
