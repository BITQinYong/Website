<%@ page contentType="text/html; charset=GB2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
		<title>ע��ɹ�</title>
		<link href="css/BookManagement.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="pagecell1">
    		<div align="center">
      			<p>&nbsp;</p>
      			<p class="successInf">��ϲ��ע��ɹ���</p>
      			<p><img src="image/time.gif" width="22" height="16">���Ӻ�ת����ҳ</p>
     			<p>��������û�з�Ӧ�뵥��<a href="/BookManagement/index.jsp">�˴�</a></p>
      			<p>&nbsp;</p>
    		</div>
  		</div>
<%
	response.setHeader("Refresh","3; URL=/BookManagement/index.jsp");
%>	
	</body>
</html>
