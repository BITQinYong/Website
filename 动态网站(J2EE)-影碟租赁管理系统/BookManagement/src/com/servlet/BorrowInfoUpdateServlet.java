package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.DataBaseBean;

//更新借阅信息
public class BorrowInfoUpdateServlet extends HttpServlet {

    public BorrowInfoUpdateServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
    	javax.servlet.http.HttpSession httpSession = httpServletRequest.
    			getSession();
        String jspName = "/borrowInfoManage.jsp";
        httpServletRequest.setCharacterEncoding("GB2312");
        String userID = httpServletRequest.getParameter("userID").trim();
        String bookID = httpServletRequest.getParameter("bookID").trim();
        String borrowBeginDate = httpServletRequest.getParameter("borrowBeginDate").trim();
        String borrowEndDate = httpServletRequest.getParameter("borrowEndDate").trim();
        DataBaseBean dataBaseBean = new DataBaseBean();
        if(borrowBeginDate.equals("")) {
        	httpServletRequest.setAttribute("borrowBeginDateError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
        	//*本项必须填写!
            jspName = (new StringBuilder()).append("/borrowInfoUpdate.jsp?userID=" + 
            		userID +"&bookID=" + bookID).toString();
        }
        if(borrowEndDate.equals("")) {
        	httpServletRequest.setAttribute("borrowEndDateError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
        	jspName = (new StringBuilder()).append("/borrowInfoUpdate.jsp?userID=" + 
            		userID +"&bookID=" + bookID).toString();
        }
        if(jspName.equals("/borrowInfoManage.jsp")) {
            String updateBorrowInfo = (new StringBuilder()).append("UPDATE borrowInfo SET "
            		+ "borrowBeginDate = '" + borrowBeginDate + "', borrowEndDate = '" + 
            		borrowEndDate + "' WHERE userID = '" + userID + "' AND bookID = '" + 
            		bookID + "'").toString();
            dataBaseBean.connect();
            dataBaseBean.executeUpdate(updateBorrowInfo);
            String updateBookInfo = (new StringBuilder()).append("UPDATE BookInfo SET "
            		+ "bookBorrowCondition = '" + borrowBeginDate + "' WHERE bookID = '" + 
		    		bookID + "'").toString();
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
