package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

//��ʾ�˵�
public class MenuShowServlet extends HttpServlet {

    public MenuShowServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest,
    		HttpServletResponse httpServletResponse)
    				throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        if(httpSession.getAttribute("hide") != null) {	//Ҫ����ʾ�˵�
            httpSession.removeAttribute("hide");
        }
        String showCommand = (new StringBuilder()).append(httpServletRequest.
        		getParameter("jspURL")).append("?").append(httpServletRequest.
        				getParameter("param")).toString();
        httpServletResponse.sendRedirect(showCommand);
    }
}
