package com.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.BorrowInfoBean;
import com.javaBean.DataBaseBean;

//”√ªßΩË‘ƒÕº È
public class UserBorrowBookServlet extends HttpServlet {

    public UserBorrowBookServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jspName = "/BookManagement/userBorrowBookSucceed.jsp";
        String bookBorrowCondition = httpServletRequest.getParameter("bookBorrowCondition");
        if(httpSession.getAttribute("userID") == null) {
            jspName = "/BookManagement/userLoginFail.jsp";
        } else if(bookBorrowCondition.compareTo("0-0-0") == 0){
            String userID = (String)httpSession.getAttribute("userID");
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
            } else 
            {
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
            httpSession.removeAttribute("bookID");
            if(httpSession.getAttribute("booklist") != null) {
                httpSession.removeAttribute("booklist");
            }
        } else {
        	jspName = "/BookManagement/userBorrowBookFail.jsp";
        }
        httpServletResponse.sendRedirect(jspName);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
}
