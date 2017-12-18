package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

//ÓÃ»§µÇ³ö
public class UserExitServlet extends HttpServlet {

    public UserExitServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jspName = "";
        if(httpSession.getAttribute("userID") == null) {
            jspName = "/BookManagement/userLoginFail.jsp";
        } else {
        	httpSession.removeAttribute("userID");
        }
        httpServletResponse.sendRedirect(jspName);
    }
}
