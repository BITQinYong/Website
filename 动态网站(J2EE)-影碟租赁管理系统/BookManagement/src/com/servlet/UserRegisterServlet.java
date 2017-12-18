package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.javaBean.*;

//用户注册
public class UserRegisterServlet extends HttpServlet {

    public UserRegisterServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        String jspName = "/index.jsp";
        UserInfoBean userInfoBean = new UserInfoBean();
        httpServletRequest.setCharacterEncoding("GB2312");
        String userID = httpServletRequest.getParameter("userID").trim();
        String userPassword = httpServletRequest.getParameter("userPassword");
        String userPasswordRepeat = httpServletRequest.
        		getParameter("userPasswordRepeat");
        String userName = httpServletRequest.getParameter("userName").trim();
        String userSex = httpServletRequest.getParameter("userSex").trim();
        String userPhone = httpServletRequest.getParameter("userPhone").trim();
        String userEmail = httpServletRequest.getParameter("userEmail").trim();
        if(userID.equals(""))
        {
        	httpServletRequest.setAttribute("userIDError", 
                    "*\u672C\u9879\u5FC5\u987B\u586B\u5199!");  //*本项必须填写!
            jspName = "/userRegister.jsp";
        } else if(isUserIDExisting(userID)) {
        	httpServletRequest.setAttribute("userIDRepeatError", 
                    "**\u5E10\u53F7\u5DF2\u7ECF\u5B58\u5728!");  //**帐号已经存在!
            jspName = "/userRegister.jsp";
        }
        if(userPassword.equals(""))
        {
        	httpServletRequest.setAttribute("userPasswordError", 
                    "*\u672C\u9879\u5FC5\u987B\u586B\u5199!");  //*本项必须填写!
            jspName = "/userRegister.jsp";
        } else if(!userPassword.equals(userPasswordRepeat))
        {
        	httpServletRequest.setAttribute("userPasswordRepeatError", 
                    "*\u4E0E\u786E\u8BA4\u5BC6\u7801\u4E0D\u7B26!");  
        			//*与确认密码不符!
            jspName = "/userRegister.jsp";
        }
        if(userName.equals(""))
        {
        	httpServletRequest.setAttribute("userNameError", 
                    "*\u672C\u9879\u5FC5\u987B\u586B\u5199!");  //*本项必须填写!
            jspName = "/userRegister.jsp";
        }
        if(userPhone.equals(""))
        {
        	httpServletRequest.setAttribute("userPhoneError", 
                    "*\u672C\u9879\u5FC5\u987B\u586B\u5199!");  //*本项必须填写!
            jspName = "/userRegister.jsp";
        }
        if(userEmail.equals(""))
        {
        	httpServletRequest.setAttribute("userEmailError", 
                    "*\u672C\u9879\u5FC5\u987B\u586B\u5199!");  //*本项必须填写!
            jspName = "/userRegister.jsp";
        } 
        if(!jspName.equals("/userRegister.jsp"))
        {
            String insertUserInfo = (new StringBuilder()).
            		append("INSERT INTO UserInfo VALUES('").append(userID).
            		append("'").append(",").append("'").append(userPassword).
            		append("'").append(",").append("'").append(userName).
            		append("'").append(",").append("'").append(userSex).
            		append("'").append(",").append("'").append(userPhone).
            		append("'").append(",").append("'").append(userEmail).
            		append("'").append(")").toString();
            DataBaseBean dataBaseBean = new DataBaseBean();
            dataBaseBean.connect();
            dataBaseBean.executeUpdate(insertUserInfo);
            dataBaseBean.closeConnection();
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("userID",userID);
        }
        httpServletRequest.setAttribute("userInfoBean", userInfoBean);
        RequestDispatcher requestdispatcher = httpServletRequest.
        		getRequestDispatcher(jspName);
        requestdispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

    public boolean isUserIDExisting(String UserID) {
        boolean UserIDExistingFlag = false;
        String judgeUserID = (new StringBuilder()).
        		append("SELECT * FROM UserInfo WHERE userID='").
        		append(UserID).append("'").toString();
        DataBaseBean dataBaseBean = new DataBaseBean();
        dataBaseBean.connect();
        ResultSet resultset = dataBaseBean.executeQuery(judgeUserID);
        try {
            if(resultset.next()) {
                UserIDExistingFlag = true;
            }
        } catch(SQLException sqlexception) {
            System.err.println((new StringBuilder()).
            		append("Error with connection:").append(sqlexception).
            		toString());
        }
        dataBaseBean.closeConnection();
        return UserIDExistingFlag;
    }
    
}
