<%@ page contentType="text/html; charset=gb2312" language="java" import="java.util.*,java.sql.*,com.javaBean.DataBaseBean" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<meta name="keywords" content="{$keywords}" />
		<meta name="description" content="{$description}" />
		<title>�����Ϣ����</title>
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
		String param=request.getQueryString(); 
		String hidAddr="/BookManagement/MenuHideServlet?jspURL=" + requestURL +"&param="+ param ;
		String showAddr="/BookManagement/MenuShowServlet?jspURL=" + requestURL +"&param="+ param ;
%>
				<ul><li style="text-align:left"><a href=<%=hidAddr%> align="left">����</a> / <a href=<%=showAddr%>>��ʾ</a></li></ul>
<%
		if(session.getAttribute("hide")==null) {
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
						<li><Form action="/BookManagement/UserSelectBookServlet" Method="post"><Input type=text name="keyword"></Input><Input type=submit name="b" value="����"></Input></Form></li>
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
					<form name="form" method="post" action="/BookManagement/BorrowInfoDeleteServlet">
						<%=beginDiv%>
							<ul style="float:left;width:600px;display:inline">
								<li style="float:left;width:16%;display:inline">ɾ��</li>
								<li style="float:left;width:16%;display:inline">�û�ID</li>
								<li style="float:left;width:16%;display:inline">Ӱ����ϷID</li>
								<li style="float:left;width:16%;display:inline">��ʼ����</li>
								<li style="float:left;width:16%;display:inline">��ֹ����</li>
							</ul>
						<%=endDiv%>
<%
		String borrowNumber = "";
		if(request.getParameter("borrowNumber")==null) {
			borrowNumber = "1";
		} else {
			borrowNumber = request.getParameter("borrowNumber");
		}
		int borrowIndex = (Integer.parseInt(borrowNumber) - 1) * 30;
	   	String selectBorrowInfo = "SELECT * FROM BorrowInfo";
		DataBaseBean dataBaseBean = new DataBaseBean();
		dataBaseBean.connect();
		ResultSet resultSet = dataBaseBean.executeQuery(selectBorrowInfo);
		for(int amount = 0; amount < borrowIndex;amount++) {
			resultSet.next();
		}
		int amount = 0;
	    while(resultSet.next() && amount < 30){
			amount++;
			String userID = resultSet.getString("userID");
			String bookID = resultSet.getString("bookID");
			String borrowBeginDate = resultSet.getString("borrowBeginDate");
			String borrowEndDate = resultSet.getString("borrowEndDate");
			String borrowInfoUpdateURL = "/BookManagement/borrowInfoUpdate.jsp?userID=" + userID + "&bookID=" + bookID;
%>
						<%=beginDiv%>
							<ul style="float:left;width:600px;height:40px;display:inline">
								<li style="float:left;width:16%;display:inline"><input name="borrowID" type="checkbox" id="borrowID" value="<%= userID%>&<%=bookID %>"></input></li>
								<li style="float:left;width:16%;display:inline"><%= userID %></li>
								<li style="float:left;width:16%;display:inline"><%= bookID %></li>
								<li style="float:left;width:16%;display:inline"><%= borrowBeginDate %></li>
								<li style="float:left;width:16%;display:inline"><%= borrowEndDate %></li>
								<li style="float:left;width:16%;display:inline"><a href="<%= borrowInfoUpdateURL %>">�޸�</a></li>
						</ul>
						<%=endDiv%>
<%
		}
%>
						<%=beginDiv%>
							<ul style="float:left;width:600px;display:inline"><li><input type="submit" name="Submit" value="ɾ��"></input>&nbsp;&nbsp;&nbsp;<a href="/BookManagement/borrowInfoInsert.jsp">������</a></li></ul>
						<%=endDiv%>
					</form>
					<div class="title">
						<div class="datainfo">
<%
		String beforePage = "/BookManagement/bookManage.jsp?borrowNumber=" + Integer.toString(borrowIndex / 30);
		String afterPage = "/BookManagement/bookManage.jsp?borrowNumber=" + Integer.toString(borrowIndex / 30 + 2);
		if(borrowNumber.equals("1")) {
			if(resultSet.next()) {
%>
							<div>��һҳ/<a href=<%= afterPage %>>��һҳ</a></div>
<%
			} else {  
%>
							<div>��һҳ/��һҳ</div>
<%	
			}
		} else {
			  if(resultSet.next()) {
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
