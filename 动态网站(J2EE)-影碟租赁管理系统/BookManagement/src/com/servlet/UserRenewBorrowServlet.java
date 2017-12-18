package com.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.DataBaseBean;

//用户续借图书
public class UserRenewBorrowServlet extends HttpServlet
{

    public UserRenewBorrowServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jspName = "/BookManagement/userManageBorrow.jsp";
        if(httpSession.getAttribute("userID") == null) {
            jspName = "/BookManagement/userLoginFail.jsp";
        } else {
            String userID = (String) httpSession.getAttribute("userID");
            String bookID = httpServletRequest.getParameter("bookID");
            String borrowBeginDate = "";
            String borrowEndDate = "";
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            borrowBeginDate = (new StringBuilder()).
            		append(Integer.toString(gregorianCalendar.get(Calendar.YEAR))).
            		append("-").
            		append(Integer.toString(gregorianCalendar.get(Calendar.MONTH)
            		+ 1)).append("-").
            		append(Integer.toString(gregorianCalendar.get(Calendar.DATE)))
            		.toString();
            if(gregorianCalendar.get(Calendar.MONTH) < 12) {
            	borrowEndDate = (new StringBuilder()).
            			append(Integer.toString(gregorianCalendar.
            			get(Calendar.YEAR))).append("-").
            			append(Integer.toString(gregorianCalendar.
            			get(Calendar.MONTH) + 2)).append("-").
            			append(Integer.toString(gregorianCalendar.
            			get(Calendar.DATE))).toString();
            } else {
            	borrowEndDate = (new StringBuilder()).
            			append(Integer.toString(gregorianCalendar.
            			get(Calendar.YEAR) + 1)).append("-").
            			append(Integer.toString(gregorianCalendar.
            			get(Calendar.MONTH) + 1)).append("-").
            			append(Integer.toString(gregorianCalendar.
            			get(Calendar.DATE))).toString();
            }
            DataBaseBean dataBaseBean = new DataBaseBean();
            dataBaseBean.connect();
			String insertBorrowInfo = (new StringBuilder()).append("UPDATE "
					+ "BorrowInfo SET borrowBeginDate='").append(borrowBeginDate).
					append("'").append(",").append("borrowEndDate=").append("'").
            		append(borrowEndDate).append("'WHERE userID='").append(userID).
            		append("'AND bookID = '").append(bookID).append("'").toString();
			dataBaseBean.executeUpdate(insertBorrowInfo);
			String updateBookInfo = (new StringBuilder()).append("UPDATE BookInfo SET "
            		+ "bookBorrowCondition = '" + borrowBeginDate + "' WHERE bookID = '" + 
		    		bookID + "'").toString();
		    dataBaseBean.executeUpdate(updateBookInfo);
			dataBaseBean.closeConnection();
            httpSession.removeAttribute("borrowList");
            if(httpSession.getAttribute("booklist") != null) {
                httpSession.removeAttribute("booklist");
            }
        }
        httpServletResponse.sendRedirect(jspName);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
}