package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.javaBean.DataBaseBean;

//����Ա��½
public class ManagerLoginServlet extends HttpServlet {
    
	public ManagerLoginServlet() {
    	;
    }

    public void doGet(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        String jpsName = "";
        String managerID = httpServletRequest.getParameter("managerID");
        String managerPassword = httpServletRequest.getParameter("managerPassword");
        String selectManagerInfo = (new StringBuilder()).
        		append("SELECT * FROM ManagerInfo WHERE managerID='" + managerID + 
        		"' AND managerPassword='" + managerPassword + "'").toString();
        DataBaseBean dataBaseBean = new DataBaseBean();
        dataBaseBean.connect();
        ResultSet resultset = dataBaseBean.executeQuery(selectManagerInfo);
        try {
            if(resultset.next()) {	//����ù���Ա���ڣ����¼�ɹ�
                httpSession.setAttribute("managerID", managerID);
                jpsName = "/borrowInfoManage.jsp";
            } else {				//����ù���Ա�����ڣ����¼ʧ��
            	jpsName = "/managerLogin.jsp";
                httpServletRequest.setAttribute("managerLoginError",
                		"*\u5BC6\u7801\u4E0E\u5E10\u53F7\u4E0D\u5339\u914D!");
                		//*�������ʺŲ�ƥ��!
            }
        } catch(SQLException sqlException) {
            System.err.println((new StringBuilder()).append("Error with connection:").
            		append(sqlException).toString());
        }
        dataBaseBean.closeConnection();
        RequestDispatcher requestDispatcher = httpServletRequest.
        		getRequestDispatcher(jpsName);
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse)
    		throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
    
}
