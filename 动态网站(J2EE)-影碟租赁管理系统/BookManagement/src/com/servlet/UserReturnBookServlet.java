package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.DataBaseBean;

//用户归还图书
public class UserReturnBookServlet extends HttpServlet {

    public UserReturnBookServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jpsName = "/BookManagement/userManageBorrow.jsp";
        if(httpSession.getAttribute("userID") != null) {
            DataBaseBean dataBaseBean = new DataBaseBean();
            dataBaseBean.connect();
            String userID = (String) httpSession.getAttribute("userID");
            String bookID = httpServletRequest.getParameter("bookID");
            String deleteBorrowInfo = (new StringBuilder()).
            			append("DELETE FROM  BorrowInfo WHERE userID='" + 
            					userID + "' AND bookID = '" + bookID + "'").toString();
            dataBaseBean.executeUpdate(deleteBorrowInfo);
            String updateBookInfo = (new StringBuilder()).append("UPDATE BookInfo SET "
            			+ "bookBorrowCondition = '"+"0-0-0"+"' WHERE bookID = '" + 
			    		bookID + "'").toString();
			dataBaseBean.executeUpdate(updateBookInfo);
    
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
