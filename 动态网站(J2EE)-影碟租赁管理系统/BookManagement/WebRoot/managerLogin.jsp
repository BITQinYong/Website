<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<meta name="keywords" content="{$keywords}" />
		<meta name="description" content="{$description}" />
		<title>管理员登录</title>
		<link rel="stylesheet" type="text/css" href="css/StyleSheets.css" />
	</head>
	<body>
 		<div class="mainbox">
			<div class="left">
				<div class="logo"></div>
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
							<li><a href="/BookManagement/userLogin.jsp"></a></li>
							<li><a href="/BookManagement/userRegister.jsp"></a></li>
							<li><a href="/BookManagement/managerLogin.jsp"></a></li>
						</ul>
					</div>
				</div>
				<div class="rightmid">
					<div style="text-align:center"><h3>管 理 员 登 录</h3></div>
						<form name="form1" method="post" action="/BookManagement/ManagerLoginServlet">
							<div class="title">
								<div class="datainfo">
									<ul style="float:left;width:35%;display:inline;">
										<li><% if(request.getAttribute("managerLoginError")!=null){ %><%= (String)request.getAttribute("managerLoginError") %><% } %></li>
										<li>帐号：<input name="managerID" type="text" id="id"></li>
										<li>密码：<input name="managerPassword" type="password" id="password"></li>
									</ul>
									<ul style="float:left;width:20%;display:inline;">
										<li style="margin-top:40px;"><input type="submit" name="Submit" value="提交"> <a href="/BookManagement/index.jsp">返回</a></li>
									</ul>
								</div>
							</div>
						</form>
					</div>
				<div class="rightb"><ul><li></li></ul></div>
			</div>
			<div class="copyright">
				<ul><li>Designed By QY</li></ul>
			</div>
		</div>
	</body>
</html>