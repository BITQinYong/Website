package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.DataBaseBean;

//删除用户信息
public class UserInfoDeleteServlet extends HttpServlet {

    public UserInfoDeleteServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jspName = "/BookManagement/userInfoManage.jsp";
        if(httpSession.getAttribute("managerID") != null && 
        		httpServletRequest.getParameterValues("userID") != null) {
            String parameterValues[] = httpServletRequest.
            		getParameterValues("userID");
            DataBaseBean dataBaseBean = new DataBaseBean();
            dataBaseBean.connect();
            for(int i = 0; i < parameterValues.length; i++) {
                String deleteUser = (new StringBuilder()).
                		append("DELETE FROM UserInfo WHERE userID='").
                		append(parameterValues[i]).append("'").toString();
                dataBaseBean.executeUpdate(deleteUser);
                String deleteBorrowInfo = (new StringBuilder()).
                		append("DELETE FROM  BorrowInfo WHERE userID = '" + 
                				parameterValues[i] + "'").toString();
                dataBaseBean.executeUpdate(deleteBorrowInfo);
                if(httpSession.getAttribute("booklist") != null) {
                    httpSession.removeAttribute("booklist");
                }
            }

            dataBaseBean.closeConnection();
        }
        httpServletResponse.sendRedirect(jspName);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
}
