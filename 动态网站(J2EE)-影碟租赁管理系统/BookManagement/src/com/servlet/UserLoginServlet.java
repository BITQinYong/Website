package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.javaBean.DataBaseBean;

//用户登录
public class UserLoginServlet extends HttpServlet {

    public UserLoginServlet(){
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jspName = "/userLoginRepeat.jsp";
        if(httpSession.getAttribute("userID") == null) {
            String userID = httpServletRequest.getParameter("userID");
            String userPassword = httpServletRequest.getParameter("userPassword");
            String selcetUserInfo = (new StringBuilder()).
            		append("SELECT * FROM UserInfo WHERE userID = '").append(userID).
            		append("'").append("AND userPassword = ").append("'").
            		append(userPassword).append("'").toString();
            DataBaseBean dataBaseBean = new DataBaseBean();
            dataBaseBean.connect();
            ResultSet resultSet = dataBaseBean.executeQuery(selcetUserInfo);
            try {
                if(resultSet.next()) {	//如果该用户存在，则登录成功
                    httpSession.setAttribute("userID", userID);
                    jspName = "/index.jsp";
                } else {				//如果该用户不存在，则登录失败
                    jspName = "/userLogin.jsp";
                    httpServletRequest.setAttribute("userLoginError",
                    		"*\u5BC6\u7801\u4E0E\u5E10\u53F7\u4E0D\u5339\u914D!");
                    		//*密码与帐号不匹配!
                }
            } catch(SQLException sqlException) {
                System.err.println((new StringBuilder()).
                		append("Error with connection:").append(sqlException).
                		toString());
            }
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
