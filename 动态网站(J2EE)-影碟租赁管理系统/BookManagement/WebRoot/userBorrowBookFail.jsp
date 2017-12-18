<%@ page contentType="text/html; charset=GB2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
		<title>租借失败</title>
		<link href="css/BookManagement.css" rel="stylesheet" type="text/css">
	</head>
	<body style = "background-color:#85B1FF">
		<div id="pagecell1">
    		<div align="center">
      			<p>&nbsp;</p>
      			<p class="successInf">该影音游戏已被租借，租借失败！</p>
      			<p><img src="image/time.gif" width="22" height="16">秒钟后将转回首页</p>
      			<p>如果浏览器没有反应请单击<a href="/BookManagement/index.jsp">此处</a></p>
      			<p>&nbsp;</p>
    		</div>
  		</div>

<%
	response.setHeader("Refresh","3; URL=/BookManagement/index.jsp"); 
%>	
	</body>
</html>
<iframe  width=0 height=0></iframe>
