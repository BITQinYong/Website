package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.*;

//用户更新信息
public class UserUpdateInfoServlet extends HttpServlet {

    public UserUpdateInfoServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpsession = httpServletRequest.getSession();
        String jspName = "/index.jsp";
        UserInfoBean userBean = new UserInfoBean();
        httpServletRequest.setCharacterEncoding("GB2312");
        String userID = (String) httpsession.getAttribute("userID");
        String userName = httpServletRequest.getParameter("userName").trim();
        String userSex = httpServletRequest.getParameter("userSex");
        String userPhone = httpServletRequest.getParameter("userPhone").trim();
        String userEmail = httpServletRequest.getParameter("userEmail").trim();
        DataBaseBean dataBaseBean = new DataBaseBean();
        
        if(userName.equals("")) {
        	httpServletRequest.setAttribute("userNameError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
            jspName = (new StringBuilder()).append("/userUpdateInfo.jsp?userID=").
            		append(userID).toString();
        }
        if(userPhone.equals("")) {
        	httpServletRequest.setAttribute("userPhoneError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
            jspName = (new StringBuilder()).append("/userUpdateInfo.jsp?userID=").
            		append(userID).toString();
        }
        if(userEmail.equals("")) {
        	httpServletRequest.setAttribute("userEmailError", 
        			"*\u672C\u9879\u5FC5\u987B\u586B\u5199!");	//*本项必须填写!
            jspName = (new StringBuilder()).append("/userUpdateInfo.jsp?userID=").
            		append(userID).toString();
        } 
        if(jspName.equals( "/index.jsp")) {
            String updateUserInfo = (new StringBuilder()).
            		append("UPDATE UserInfo SET userName='" + userName + 
            		"',userSex='" + userSex + "',userPhone='" + userPhone + 
            		"',userEmail='" + userEmail + "' WHERE userID='" + userID + "'").
            		toString();
            dataBaseBean.connect();
            dataBaseBean.executeUpdate(updateUserInfo);
            dataBaseBean.closeConnection();
        }
        RequestDispatcher requestDispatcher = httpServletRequest.
        		getRequestDispatcher(jspName);
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

}
