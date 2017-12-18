package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

//显示菜单
public class MenuShowServlet extends HttpServlet {

    public MenuShowServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest,
    		HttpServletResponse httpServletResponse)
    				throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        if(httpSession.getAttribute("hide") != null) {	//要求显示菜单
            httpSession.removeAttribute("hide");
        }
        String showCommand = (new StringBuilder()).append(httpServletRequest.
        		getParameter("jspURL")).append("?").append(httpServletRequest.
        				getParameter("param")).toString();
        httpServletResponse.sendRedirect(showCommand);
    }
}
