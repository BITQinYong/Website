package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.javaBean.BookInfoBean;
import com.javaBean.DataBaseBean;

//�û���ѯͼ��
public class UserSelectBookServlet extends HttpServlet {

    public UserSelectBookServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        httpServletRequest.setCharacterEncoding("utf-8");
        String keyword = httpServletRequest.getParameter("keyword");
        Vector booklistVector = new Vector();
        HttpSession httpSession = httpServletRequest.getSession();
        String selectBookInfo = "SELECT * FROM BookInfo ";
        if(httpSession.getAttribute("booklist") != null) {
            httpSession.removeAttribute("booklist");
        }
        if(keyword == null) {
            if(httpServletRequest.getParameter("type") != null) {
                String bookType = "";
                if(httpServletRequest.getParameter("type").equals("computer")) {
                	//bookType = "computer";	//�����
                	bookType = "����";
                }
                if(httpServletRequest.getParameter("type").equals("electric")) {
                	//bookType = "electric";	//����
                	bookType = "����";
                }
                if(httpServletRequest.getParameter("type").equals("transmit")) {
                	//bookType = "transmit";	//ͨ��
                	bookType = "����";
                }
                if(httpServletRequest.getParameter("type").equals("biology")) {
                	//bookType = "biology";	//����
                	bookType = "�ƻ�";
                }
                if(httpServletRequest.getParameter("type").equals("medicine")) {
                	bookType = "ϲ��";	//ҽѧ
                	//bookType = "medicine";
                }
                if(httpServletRequest.getParameter("type").equals("geography")) {
                	//bookType = "geography";	//����
                	bookType = "��Ϸ";
                }
                selectBookInfo = (new StringBuilder()).append(selectBookInfo + 
                		"WHERE bookType = '" + bookType + "'").toString();
                httpSession.removeAttribute("type");
            }
        } else {
        	selectBookInfo = (new StringBuilder()).append(selectBookInfo + 
        			 " WHERE bookName LIKE '%" + keyword + "%' OR bookAuthor LIKE '%" +
        			 keyword + "%' OR bookPublisher LIKE '%" + keyword + "%'").toString();
        	httpSession.removeAttribute("keyword");
        }
        DataBaseBean dataBaseBean = new DataBaseBean();
        dataBaseBean.connect();
        ResultSet resultSet = dataBaseBean.executeQuery(selectBookInfo);
        try {
            while(resultSet.next()) {
                BookInfoBean bookBean = new BookInfoBean(
                		resultSet.getString("bookID"), 
                		resultSet.getString("bookType"), 
                		resultSet.getString("bookName"), 
                		resultSet.getString("bookAuthor"), 
                		resultSet.getString("bookPublisher"), 
                		resultSet.getString("bookPublicTime"), 
                		resultSet.getString("bookPlace"),
                		resultSet.getString("bookBorrowCondition"));
                booklistVector.addElement(bookBean);
                System.out.println("name"+resultSet.getString("bookName"));
            }
        } catch(SQLException sqlException) {
        	System.err.println((new StringBuilder()).
        				append("executeUpdate:" + sqlException).toString());
        }
        dataBaseBean.closeConnection();
        httpSession.setAttribute("booklist", booklistVector);
        httpServletResponse.sendRedirect("/BookManagement/index.jsp");
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
}
