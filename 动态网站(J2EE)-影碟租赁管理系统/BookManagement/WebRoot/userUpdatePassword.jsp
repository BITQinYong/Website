<%@ page contentType="text/html; charset=GB2312" language="java" import="java.util.*,java.sql.*,com.javaBean.DataBaseBean" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<meta name="keywords" content="{$keywords}" />
		<meta name="description" content="{$description}" />
		<title>更新用户密码</title>
		<link rel="stylesheet" type="text/css" href="css/StyleSheets.css" />
	</head>
	<body>
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
					<h3 ><%= (String)session.getAttribute("userID") %>,欢迎您!</h3>
					<ul><li style="text-align:left">今天是<%= date.get(Calendar.YEAR)%>年<%= date.get(Calendar.MONTH)+1 %>月<%= date.get(Calendar.DAY_OF_MONTH) %>日</li></ul>
				</div>  
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
<%
	if(session.getAttribute("userID")==null) {
		response.sendRedirect("/BookManagement/userLoginFail.jsp");
	} else {
%>
				<div class="rightmid">
					<div style="text-align:center"><h3>修 改 密 码</h3></div>
					<form name="form" method="post" action="/BookManagement/UserUpdatePasswordServlet">
						<div class="title" style="height:140px;">
							<div class="datainfo">
								<ul>
									<li><% if(request.getAttribute("blankError")!=null){ %><%= (String)request.getAttribute("blankError") %><% } %></li>
									<li><% if(request.getAttribute("newPasswordRepeatError")!=null){ %><%= (String)request.getAttribute("newPasswordRepeatError") %><% } %></li>
									<li><% if(request.getAttribute("oldPasswordError")!=null){ %><%= (String)request.getAttribute("oldPasswordError") %><% } %></li>
									<li>旧 密 码：<input name="oldPassword" type="password" id="oldPwd"></li>
									<li>新 密 码：<input name="newPassword" type="password" id="newPwd"></li>
									<li>确认密码：<input name="newPasswordRepeat" type="password" id="checkPwd"></li>
									<li style="margin-top:5px;"><input type="submit" name="Submit" value="提交"> 
										<a href="/BookManagement/index.jsp">返回</a>
									</li>
								</ul>
							</div>
						</div>
					</form>
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
<% 		
	}
%>
