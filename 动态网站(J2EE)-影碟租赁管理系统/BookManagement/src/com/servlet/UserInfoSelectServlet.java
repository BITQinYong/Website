package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.*;

//��ѯ�û���Ϣ
public class UserInfoSelectServlet extends HttpServlet {

    public UserInfoSelectServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
       ;
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

}
