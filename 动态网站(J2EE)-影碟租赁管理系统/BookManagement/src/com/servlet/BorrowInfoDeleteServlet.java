package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.DataBaseBean;

//É¾³ý½èÔÄÐÅÏ¢
public class BorrowInfoDeleteServlet extends HttpServlet {

    public BorrowInfoDeleteServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jpsName = "/BookManagement/borrowInfoManage.jsp";
        if(httpSession.getAttribute("managerID") != null && 
        		httpServletRequest.getParameterValues("borrowID") != null) {
            String borrowIDValues[] = httpServletRequest.
            		getParameterValues("borrowID");
            DataBaseBean dataBaseBean = new DataBaseBean();
            dataBaseBean.connect();
            
            for(int i = 0; i < borrowIDValues.length; i++)
            {
            	String userID = "";
            	String bookID = "";
            	int pos = borrowIDValues[i].indexOf('&');
            	userID = borrowIDValues[i].substring(0, pos);
            	bookID = borrowIDValues[i].substring(pos + 1);
                String deleteBorrowInfo = (new StringBuilder()).
                		append("DELETE FROM  BorrowInfo WHERE userID='" + 
                		userID + "' AND bookID = '" + bookID + "'").toString();
                System.out.println(deleteBorrowInfo);
                dataBaseBean.executeUpdate(deleteBorrowInfo);
                String updateBookInfo = (new StringBuilder()).append("UPDATE BookInfo SET "
	            		+ "bookBorrowCondition = '"+"0-0-0"+"' WHERE bookID = '" + 
			    		bookID + "'").toString();
			    dataBaseBean.executeUpdate(updateBookInfo);
            }
            if(httpSession.getAttribute("booklist") != null) {
                httpSession.removeAttribute("booklist");
            }
            dataBaseBean.closeConnection();
        }
        httpServletResponse.sendRedirect(jpsName);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
}
