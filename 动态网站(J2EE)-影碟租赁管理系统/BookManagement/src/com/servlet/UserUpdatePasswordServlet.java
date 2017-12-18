package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.javaBean.DataBaseBean;

//用户更新密码
public class UserUpdatePasswordServlet extends HttpServlet {

    public UserUpdatePasswordServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String userID = (String)httpSession.getAttribute("userID");
        String jspName = "";
        DataBaseBean dataBaseBean = new DataBaseBean();
        String oldPassword = httpServletRequest.getParameter("oldPassword");
        String newPassword = httpServletRequest.getParameter("newPassword");
        String newPasswordRepeat = httpServletRequest.
        		getParameter("newPasswordRepeat");
        if(oldPassword.equals("") || newPassword.equals("") || 
        		newPasswordRepeat.equals("")) {
        	httpServletRequest.setAttribute("blankError", 
                    "*\u8868\u5355\u5404\u9879\u5747\u5FC5\u586B\uFF01");  
        			//*表单各项均必填！
            jspName = "/userUpdatePassword.jsp";
        }
        if(!newPassword.equals(newPasswordRepeat)) {
        	httpServletRequest.setAttribute("newPasswordRepeatError", 
                    "*\u65B0\u5BC6\u7801\u4E0E\u786E\u8BA4\u5BC6\u7801\u4E0D\u4E00"
                    + "\u81F4\uFF01");   //*新密码与确认密码不一致！
            jspName = "/userUpdatePassword.jsp";
        } else if(!isPasswordMatching(dataBaseBean, userID, oldPassword)) {
        	httpServletRequest.setAttribute("oldPasswordError", 
                    "*\u65E7\u5BC6\u7801\u4E0D\u6B63\u786E\uFF01");  
        			//*旧密码不正确！
            jspName = "/userUpdatePassword.jsp";
        } else {
            jspName = "/index.jsp";
            String s5 = (new StringBuilder()).
            		append("UPDATE UserInfo SET userPassword='").
            		append(newPassword).append("'").
            		append(" WHERE userID=").append("'").append(userID).
            		append("'").toString();
            dataBaseBean.connect();
            dataBaseBean.executeUpdate(s5);
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
    
    public static boolean isPasswordMatching(DataBaseBean dataBaseBean, 
    		String userID, String userPassword) {
        boolean passwordMatchingFlag = false;
        String judgeUser = (new StringBuilder()).
        		append("SELECT * FROM UserInfo WHERE userID='").append(userID).
        		append("'").append(" AND userPassword=").append("'").
        		append(userPassword).append("'").toString();
        dataBaseBean.connect();
        ResultSet resultSet = dataBaseBean.executeQuery(judgeUser);
        try {
            if(resultSet.next()) {
                passwordMatchingFlag = true;
            }
        } catch(SQLException sqlException) {
            System.err.println((new StringBuilder()).
            		append("Error with connection:").
            		append(sqlException).toString());
        }
        dataBaseBean.closeConnection();
        return passwordMatchingFlag;
    }
    
}
