package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

//管理员登出
public class ManagerExitServlet extends HttpServlet {

    public ManagerExitServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jspName = "/BookManagement/index.jsp";
        if(httpSession.getAttribute("managerID") != null) {
            httpSession.removeAttribute("managerID");
        }
        httpServletResponse.sendRedirect(jspName);
    }
    
}
