<%@ page contentType="text/html; charset=GB2312" language="java" import="java.util.*,java.sql.*,com.javaBean.DataBaseBean" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<meta name="keywords" content="{$keywords}" />
		<meta name="description" content="{$description}" />
		<title>�û���Ϣ����</title>
		<link rel="stylesheet" type="text/css" href="css/StyleSheets.css" />
	</head>
	<body>
<%
	if(session.getAttribute("managerID")==null) {
		response.sendRedirect("/BookManagement/managerLoginFail.jsp");
	} else {
%>
		<div class="mainbox">
			<div class="left">
				<div class="logo"></div>
<%
		String requestURL= request.getRequestURI();
		String param = request.getQueryString(); 
		String hideAddress = "/BookManagement/MenuHideServlet?jspURL=" + requestURL + "&param=" + param ;
		String showAddress = "/BookManagement/MenuShowServlet?jspURL=" + requestURL + "&param=" + param ;
%>
		  		<ul><li style="text-align:left"><a href=<%=hideAddress%> align="left">����</a> / <a href=<%=showAddress%>>��ʾ</a></li></ul>
<%
		if(session.getAttribute("hide")==null){
%>
<%
 			GregorianCalendar date = new GregorianCalendar();
%>
				<div>
					<h3>����Ա,��ӭ����!</h3>
					<ul><li style="text-align:left">������<%= date.get(Calendar.YEAR) %>��<%= date.get(Calendar.MONTH)+1 %>��<%= date.get(Calendar.DAY_OF_MONTH) %>��</li></ul>
				</div>  
				<div>
					<ul>
						<li class="datainfo"><a href="/BookManagement/borrowInfoManage.jsp">������</a></li>
						<li class="datainfo"><a href="/BookManagement/userInfoManage.jsp">�û�����</a></li>
						<li class="datainfo"><a href="/BookManagement/bookInfoManage.jsp">Ӱ����Ϸ����</a></li>
						<li class="datainfo"><a href="/BookManagement/ManagerExitServlet">�뿪ϵͳ</a></li>
					</ul>
				</div>
<%
		}
%>
			</div>
			<div class="right">
				<div class="menu">
					<ul>
						<li><a href="/BookManagement/index.jsp">��ҳ</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=computer">����</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=electric">����</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=transmit">����</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=biology">�ƻ�</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=medicine">ϲ��</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=geography">��Ϸ</a></li>
						<li><form name = "search" action="/BookManagement/UserSelectBookServlet" Method="post"><Input type=text name="keyword"></Input><Input type=submit name="b" value="����"></Input></form></li>
					</ul>
				</div>
				<div class="rightop">
					<div class="toplink">
						<ul>
							<li><a href="userLogin.jsp"></a></li>
							<li><a href="userRegister.jsp"></a></li>
							<li><a href="managerLogin.jsp"></a></li>
						</ul>
					</div>
				</div>
				<div class="rightmid">
<%
		String beginDiv = "<div class=\"title\" style=\"height:20px;\"><div class=\"datainfo\">";
		String endDiv = "</div></div>";
%>
					<form name="form" method="post" action="/BookManagement/UserInfoDeleteServlet">
						<%=beginDiv%>
							<ul style="float:left;width:600px;display:inline">
								<li style="float:left;width:14%;display:inline">ɾ�� </li>
								<li style="float:left;width:14%;display:inline">�û�ID</li>
								<li style="float:left;width:14%;display:inline">����</li>
								<li style="float:left;width:14%;display:inline">�Ա�</li>
								<li style="float:left;width:14%;display:inline">�绰</li>
								<li style="float:left;width:14%;display:inline">Email</li></ul>
						<%=endDiv%>

<%
		String bookNumber = "";
		if(request.getParameter("bookNumber") == null) {
			bookNumber = "1";
		} else {
			bookNumber=request.getParameter("bookNumber");
		}
		int bookIndex = (Integer.parseInt(bookNumber) - 1) * 30;
		String selectUserInfo="SELECT * FROM UserInfo";
		DataBaseBean dataBaseBean=new DataBaseBean();
		dataBaseBean.connect();
		ResultSet resultset=dataBaseBean.executeQuery(selectUserInfo);
		for(int i = 0; i < bookIndex; i++){
				resultset.next();
		}
		int n=0;
		while(resultset.next()&&n<30){
			n++;
			String userID = resultset.getString("userID");
			String userInfoUpdateURL = "/BookManagement/userInfoUpdate.jsp?userID=" + userID;
%> 
						<%=beginDiv%>
							<ul style="float:left;width:600px;display:inline">
								<li style="float:left;width:14%;display:inline"><input name="userID" type="checkbox" id="userID" value="<%= userID %>"></li>
								<li style="float:left;width:14%;display:inline"><%= resultset.getString("userID") %></li>
								<li style="float:left;width:14%;display:inline"><%= resultset.getString("userName") %></li>
								<li style="float:left;width:14%;display:inline"><%= resultset.getString("userSex") %></li>
								<li style="float:left;width:14%;display:inline"><%= resultset.getString("userPhone") %></li>
								<li style="float:left;width:14%;display:inline"><%= resultset.getString("userEmail") %></li>
								<li style="float:left;width:14%;display:inline"><a href="<%= userInfoUpdateURL %>">�޸�</a></li>
							</ul>
						<%=endDiv%>
<%
		}
%>
						<%=beginDiv%>
							<ul><li><input type="submit" name="Submit" value="ɾ��"></input>&nbsp;&nbsp;&nbsp;<a href="/BookManagement/userInfoInsert.jsp">����û�</a></li></ul>
						<%=endDiv%>
					</form>
					<div class="title">
						<div class="datainfo">
<%
		String beforePage = "/BookManagement/bookInfoMange.jsp?bookNumber=" + Integer.toString(bookIndex / 30);
		String afterPage = "/BookManagement/bookInfoMange.jsp?bookNumber=" + Integer.toString(bookIndex / 30 + 2);
		if(bookNumber.equals("1")) {
			if(resultset.next()) {  
%>
							<div>��һҳ/<a href=<%= afterPage %>>��һҳ</a></div>
<%
			}else{  
%>
							<div>��һҳ/��һҳ</div>
<%
			}
		} else {
			if(resultset.next()){
%>
							<div><a href=<%= beforePage %>>��һҳ</a>/<a href=<%= afterPage %>>��һҳ</a></div>
<% 
			} else {
%>
				    		<div><a href=<%= beforePage %>>��һҳ</a>/��һҳ</div>
<%
			}
		}
		dataBaseBean.closeConnection();
%>
						</div>
					</div>
				</div>
				<div class="rightb"><ul><li></li></ul></div>
			</div>
			<div class="copyRight">
				<ul>
					<li>Designed By QY</li>
				</ul>
			</div>
<%
	}
%>
		</div>
	</body>
</html>
	