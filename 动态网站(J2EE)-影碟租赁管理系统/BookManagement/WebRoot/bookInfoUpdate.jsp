<%@ page contentType="text/html; charset=GB2312" language="java" import="java.util.*,java.sql.*,com.javaBean.DataBaseBean" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<meta name="keywords" content="{$keywords}" />
		<meta name="description" content="{$description}" />
		<title>修改影音游戏信息</title>
		<link rel="stylesheet" type="text/css" href="css/StyleSheets.css" />
	</head>
	<body>
<%
	if(session.getAttribute("managerID") == null) {
		response.sendRedirect("/BookManagement/managerLoginFail.jsp");
	} else {
%>
		<div class="mainbox">
			<div class="left">
				<div class="logo"></div>
<%
		String requestURL = request.getRequestURI();
		String param = request.getQueryString(); 
	  	String hideAddress = "/BookManagement/MenuHideServlet?jspURL=" + requestURL + "&param=" + param ;
	  	String showAddress = "/BookManagement/MenuShowServlet?jspURL=" + requestURL + "&param=" + param ;
%>
				<ul><li style="text-align:left"><a href=<%=hideAddress%> align="left">隐藏</a> / <a href=<%=showAddress%>>显示</a></li></ul>
<%
		if(session.getAttribute("hide")==null){
%>
<%
 			GregorianCalendar date = new GregorianCalendar();
%>
				<div>
					<h3>管理员,欢迎回来!</h3>
					<ul><li style="text-align:left">今天是<%= date.get(Calendar.YEAR)%>年<%= date.get(Calendar.MONTH)+1 %>月<%= date.get(Calendar.DAY_OF_MONTH) %>日</li></ul>
				</div>  
				<div>
					<ul>
						<li class="datainfo"><a href="/BookManagement/borrowInfoManage.jsp">租借管理</a></li>
						<li class="datainfo"><a href="/BookManagement/userInfoManage.jsp">用户管理</a></li>
						<li class="datainfo"><a href="/BookManagement/bookInfoManage.jsp">影音游戏管理</a></li>
						<li class="datainfo"><a href="/BookManagement/ManagerExitServlet">离开系统</a></li>
					</ul>
				</div>
<%
		}
%>
			</div>
			<div class="right">
				<div class="menu">
					<ul>
						<li><a href="/BookManagement/index.jsp">首页</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=computer">爱情</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=electric">动作</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=transmit">剧情</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=biology">科幻</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=medicine">喜剧</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=geography">游戏</a></li>
						<li><form name = "search" action="/BookManagement/UserSelectBookServlet" Method="post"><Input type=text name="keyword"></Input><Input type=submit name="b" value="搜索"></Input></form></li>
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
					<div style="text-align:center"><h3>修改影音游戏信息</h3></div>
<%
		String bookID = (String) request.getParameter("bookID"); 
		String message = "";
		String query = "SELECT * FROM BookInfo WHERE bookID=" + "\'" + bookID + "\'";
		DataBaseBean dataBaseBean = new DataBaseBean();
		dataBaseBean.connect();
		ResultSet resultSet = dataBaseBean.executeQuery(query);
		try {
			resultSet.next();
%>
 					<form name="form" method="post" action="/BookManagement/BookInfoUpdateServlet?bookID=<%=bookID%>">
						<div class="title" style="height:70px;text-align:center">
							<div class="datainfo">
								<ul style="float:left;width:600px;display:block">
							</div>
						</div>
						<div style="text-align:center"><h3>影音游戏信息</h3></div>
						<div class="title" style="height:200px;text-align:center"><div class="datainfo">
							<ul style="float:left;width:600px;display:block">
								<li style="display:block">类别&nbsp;&nbsp;&nbsp;&nbsp;：<input name="bookType" type="text" value=<%= resultSet.getString("bookType") %>></input><% if(request.getAttribute("bookTypeError")!=null){ %><%= (String)request.getAttribute("bookTypeError") %><% } %></li>
								<li style="display:block">名称&nbsp;&nbsp;&nbsp;&nbsp;：<input name="bookName" type="text" value=<%= resultSet.getString("bookName") %>></input><% if(request.getAttribute("bookNameError")!=null){ %><%= (String)request.getAttribute("bookNameError") %><% } %></li>
								<li style="display:block">主演&nbsp;&nbsp;&nbsp;&nbsp;：<input name="bookAuthor" type="text" value=<%= resultSet.getString("bookAuthor") %>></input><% if(request.getAttribute("bookAuthorError")!=null){ %><%= (String)request.getAttribute("bookAuthorError") %><% } %></li>
								<li style="display:block">发行公司&nbsp;&nbsp;：<input name="bookPublisher" type="text" value=<%= resultSet.getString("bookPublisher") %>></input><% if(request.getAttribute("bookPublisherError")!=null){ %><%= (String)request.getAttribute("bookPublisherError") %><% } %></li>
								<li style="display:block">发行年份：<input type="text" name="bookPublicTime" value=<%= resultSet.getString("bookPublicTime") %>></input><% if(request.getAttribute("bookPublicTimeError")!=null){ %><%= (String)request.getAttribute("bookPublicTimeError") %><% } %></li>
								<li style="display:block">放置位置：<input type="text" name="bookPlace" value=<%= resultSet.getString("bookPlace") %>></input><% if(request.getAttribute("bookPlaceError")!=null){ %><%= (String)request.getAttribute("bookPlaceError") %><% } %></li>
								<li style="display:block">租借信息：<input type="text" name="bookBorrowCondition" value=<%= resultSet.getString("bookBorrowCondition") %>></input><% if(request.getAttribute("bookBorrowConditionError")!=null){ %><%= (String)request.getAttribute("bookBorrowConditionError") %><% } %></li>
								<li style="display:block;margin-top:20px;"><input type="submit" name="Submit" value="提交" >     <a href="/BookManagement/bookInfoManage.jsp">返回</a></li>
<%
  		} catch(SQLException sqlException) {
			    message += sqlException;
		}
		dataBaseBean.closeConnection(); 
	}  
%>
							</div>
						</div>
					</form>
				</div>
				<div class="rightb"><ul><li></li></ul></div>
			</div>
			<div class="copyRight">
				<ul>
					<li>Designed By QY</li>
				</ul>
			</div>
		</div>
	</body>
</html>