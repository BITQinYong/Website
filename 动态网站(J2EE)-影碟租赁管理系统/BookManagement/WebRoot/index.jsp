<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*,com.javaBean.BookInfoBean" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="{$keywords}" />
		<meta name="description" content="{$description}" />
		<title>影音游戏租借系统</title>
		<link rel="stylesheet" type="text/css" href="css/StyleSheets.css" />
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	if(session.getAttribute("booklist") == null) { 
		response.sendRedirect("/BookManagement/UserSelectBookServlet");
	} else { 
		Vector booklist = (Vector)session.getAttribute("booklist");
		String bookNumber;
		if(request.getParameter("bookNumber") == null) {
			bookNumber = "1";
		} else {
			bookNumber = request.getParameter("bookNumber");
		}
		int bookAmount = (int)(booklist.size() + 5) / 6;
		int bookIndex = (Integer.parseInt(bookNumber) - 1) * 6;
%>
	</head>
	<body>
		<div class="mainbox">
			<div class="left">
				<div class="logo"></div>
 <%
		String requestURL = request.getRequestURI();
		String param = request.getQueryString(); 
		String hideAddress = "/BookManagement/MenuHideServlet?jspURL=" + 
				requestURL + "&param=" + param ;
		String showAddress = "/BookManagement/MenuShowServlet?jspURL=" +
				requestURL + "&param="+ param ;
 %>
				<ul>
					<li style="text-align:left"><a href=<%=hideAddress%> align="left">隐藏</a> / <a href=<%=showAddress%>>显示</a></li>
				</ul>
<%
		if(session.getAttribute("hide") == null) {
%>
<% 
			if(session.getAttribute("userID")==null){ 
%>
				<div style = "margin-right:10px" >
	      				
	      				
	      				<embed src="video/three.mp4" width="200" height="200" loop="false" autostart="false"></embed> 
	      		
	      		       
	      		</div>      		
	      		
	  			<form name="form" method="post" action="/BookManagement/UserLoginServlet">
					<div>
						
						<ul style="float:left;margin:0;padding:0;width:170px;display:inline">
							<li>帐号:<input name="userID" type="text" id="id" size="12"></input></li>
	  						<li>密码:<input name="userPassword" type="password" id="password" size="12"></input></li>
	  					</ul>
	  					
						<ul style="float:left;margin:0;padding:0;width:20px;display:inline">
							<ul style="float:left;margin:0;padding:0;width:40px;display:inline">
								<li style="margin-top:0px;"><a href="/BookManagement/userRegister.jsp">注册</a></li>
							</ul>
							<li style="margin-top:24px;"><input type="submit" name="Submit" value="登录"></li>
						</ul>
					</div>
	  			</form>
<% 
			} else { 
	 	 		GregorianCalendar date = new GregorianCalendar();
%>
      			<h3 ><%= (String)session.getAttribute("userID") %>,欢迎您!</h3>
	  			<p>今天是<%= date.get(Calendar.YEAR) %>年<%= date.get(Calendar.MONTH) + 1 %>月<%= date.get(Calendar.DAY_OF_MONTH) %>日</p> 
<% 
			}
%>
				<div style="margin-top:15px;">
					<ul>
						<li class="datainfo"><a href="/BookManagement/userManageBorrow.jsp">租借记录</a></li>
	      				<li class="datainfo"><a href="/BookManagement/userUpdatePassword.jsp">修改密码</a></li>
	      				<li class="datainfo"><a href="/BookManagement/userUpdateInfo.jsp">个人资料</a></li>
	      				<li class="datainfo"><a href="/BookManagement/UserExitServlet">离开系统</a></li>
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
						<li><form class="search-text" name = "search" action="/BookManagement/UserSelectBookServlet" Method="post"><Input type=text name="keyword"></Input><Input type=submit name="b" value="搜索"></Input></form></li>
					</ul>
				</div>
				<div class="rightop">
					<div class="toplink">
						<ul>
							<li><a href="/BookManagement/userLogin.jsp"></a></li>
							<li><a href="/BookManagement/userRegister.jsp"></a></li>
							<li><a href="/BookManagement/managerLogin.jsp"></a></li>
						</ul>
					</div>
				</div>
				<div class="rightmid">
<%
		String beginDiv = "<div class=\"title\" style=\"height:200px;\">"
				+ "<div class=\"datainfo\">";
		String endDiv = "</div></div>";
		String borrowInfoInsert = "/BookManagement/borrowInfoInsert.jsp";
%>
<%
		for (int i = 0; i < 6; i++) {
			if(bookIndex + i + 1 <= booklist.size()) {
				BookInfoBean bookInfoBean = (BookInfoBean)booklist.elementAt(bookIndex + i);
				String imageURL = "" + bookInfoBean.getBookID()+ ".jpg";
%>
					<%=beginDiv%>
						<ul style="float:left;width:50%;display:inline">
							<li><a href="/BookManagement/FileDownloadServlet?filepath=<%=imageURL%>"><img src="image/<%=imageURL%>" width="135" height="200" border="0" ></a></li>
						</ul>
						<ul style="float:left;display:inline">
							<li style="margin-top:50px">名称：<%=bookInfoBean.getBookName()%></li>
							<li>主演：<%=bookInfoBean.getBookAuthor()%></li>
							<li>发行公司：<%=bookInfoBean.getBookPublisher()%></li>
							<li>位置：<%=bookInfoBean.getBookPublicTime()%></li>
							<li>发行年份：<%=bookInfoBean.getBookPlace()%></li>
							<li>租借状态：<%=bookInfoBean.getBookBorrowCondition()%></li>
							<li><form name = "borrow" action="/BookManagement/UserBorrowBookServlet?bookID=<%=bookInfoBean.getBookID()%>&bookBorrowCondition=<%=bookInfoBean.getBookBorrowCondition()%>" Method="post"><Input type=submit name="b" value="借阅"></Input></form></li>
						</ul>
					<%=endDiv%>
<%
			}
		}
%>
					<div class="title">
						<div class="datainfo">
<%
		String afterPage = "/BookManagement/index.jsp?bookNumber=" 
				+ Integer.toString(bookIndex/6+2);
		String beforePage = "/BookManagement/index.jsp?bookNumber=" 
				+ Integer.toString(bookIndex/6);
		if(bookNumber.equals("1")) {
			if(Integer.parseInt(bookNumber)<bookAmount) {
%>
							<p>上一页&nbsp;&nbsp;&nbsp;共<%= bookNumber %>/<%= bookAmount %>页&nbsp;&nbsp;&nbsp;<a href=<%= afterPage %>>下一页 </a></p>
<%
			} else {
%>
							<p>上一页&nbsp;&nbsp;&nbsp;共<%= bookNumber %>/<%= bookAmount %>页&nbsp;&nbsp;&nbsp;下一页 </p>
<%
			} 
		} else { 
			if(Integer.parseInt(bookNumber)<bookAmount) {
%>	
							<p><a href=<%= beforePage %>>上一页</a>&nbsp;&nbsp;&nbsp;共<%= bookNumber %>/<%= bookAmount %>页&nbsp;&nbsp;&nbsp;<a href=<%= afterPage %>>下一页 </a></p>
<%
			} else {
%>
							<p><a href=<%= beforePage %>>上一页</a>&nbsp;&nbsp;&nbsp;共<%= bookNumber %>/<%= bookAmount %>页&nbsp;&nbsp;&nbsp;下一页</p>
<%			}
		}
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
