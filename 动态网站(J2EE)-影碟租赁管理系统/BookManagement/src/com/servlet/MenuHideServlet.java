package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

//���ز˵�
public class MenuHideServlet extends HttpServlet {

    public MenuHideServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
        throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        if(httpSession.getAttribute("hide") == null) {		//Ҫ�����ز˵�
            httpSession.setAttribute("hide", "hide");
        }
        String hideCommand = (new StringBuilder()).append(httpServletRequest.
        		getParameter("jspURL")).append("?").append(httpServletRequest
        				.getParameter("param")).toString();
        httpServletResponse.sendRedirect(hideCommand);
    }
}
