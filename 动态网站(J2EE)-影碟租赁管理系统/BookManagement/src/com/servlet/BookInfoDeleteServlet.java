package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.javaBean.DataBaseBean;

//…æ≥˝Õº È–≈œ¢
public class BookInfoDeleteServlet extends HttpServlet {

    public BookInfoDeleteServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        httpServletRequest.setCharacterEncoding("GB2312");
        if(httpSession.getAttribute("managerID") == null) {
        	httpServletResponse.sendRedirect("/BookManagement/managerLoginFail.jsp");
        } else if(httpServletRequest.getParameterValues("bookIDDelete") != null) {
        	String jpsName = "/BookManagement/bookInfoManage.jsp";
            String bookIDDeleteValues[] = httpServletRequest.
            		getParameterValues("bookIDDelete");
            DataBaseBean dataBaseBean = new DataBaseBean();
            dataBaseBean.connect();
            for(int i = 0; i < bookIDDeleteValues.length; i++) {
                String deleteBookInfo = (new StringBuilder()).
                		append("DELETE FROM BookInfo WHERE bookID = '" +
                		bookIDDeleteValues[i] + "'").toString();
                dataBaseBean.executeUpdate(deleteBookInfo);
                String deleteBorrowInfo = (new StringBuilder()).
                		append("DELETE FROM  BorrowInfo WHERE bookID = '" + 
                		bookIDDeleteValues[i] + "'").toString();
                dataBaseBean.executeUpdate(deleteBorrowInfo);
            }
            httpServletRequest.removeAttribute("bookIDDelete");
            dataBaseBean.closeConnection();
            httpServletResponse.sendRedirect(jpsName);
            if(httpSession.getAttribute("booklist") != null) {
                httpSession.removeAttribute("booklist");
            }
        }
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
}
