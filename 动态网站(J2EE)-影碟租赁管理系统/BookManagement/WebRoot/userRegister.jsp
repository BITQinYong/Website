<%@ page contentType="text/html; charset=GB2312" language="java" import="java.util.*,java.sql.*,com.javaBean.DataBaseBean" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<meta name="keywords" content="{$keywords}" />
		<meta name="description" content="{$description}" />
		<title>�û�ע��</title>
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
					<div style="text-align:center"><h3>�û�ע��</h3></div>
 					<form name="form" method="post" action="/BookManagement/UserRegisterServlet">
						<div class="title" style="height:70px;text-align:center">
							<div class="datainfo">
								<ul style="float:left;width:600px;display:block">
							</div>
						</div>
						<div style="text-align:center"><h3>�û���Ϣ</h3></div>
						<div class="title" style="height:200px;text-align:center"><div class="datainfo">
							<ul style="float:left;width:600px;display:block">
								<li style="display:block">ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��<input name="userID" type="text" ></input><% if(request.getAttribute("userIDError")!=null){ %><%= (String)request.getAttribute("userIDError") %><% } %><% if(request.getAttribute("userIDRepeatError")!=null){ %><%= (String)request.getAttribute("userIDRepeatError") %><% } %></li>
								<li style="display:block">����&nbsp;&nbsp;&nbsp;&nbsp;��<input name="userPassword" type="password" ></input><% if(request.getAttribute("userPasswordError")!=null){ %><%= (String)request.getAttribute("userPasswordError") %><% } %></li>
								<li style="display:block">�ٴ�ȷ�ϣ�<input name="userPasswordRepeat" type="password" ></input><% if(request.getAttribute("userPasswordRepeatError")!=null){ %><%= (String)request.getAttribute("userPasswordRepeatError") %><% } %></li>
								<li style="display:block">����&nbsp;&nbsp;&nbsp;&nbsp;��<input name="userName" type="text" ></input><% if(request.getAttribute("userNameError")!=null){ %><%= (String)request.getAttribute("userNameError") %><% } %></li>
								<li style="display:block">�Ա�&nbsp;&nbsp;&nbsp;&nbsp;��

									<input name="userSex" type="radio" value="��" > ��&nbsp;</input>
                      				<input type="radio" name="userSex" value="Ů" checked> Ů </input>
								</li>
								<li style="display:block">�绰&nbsp;&nbsp;&nbsp;&nbsp;��<input type="text" name="userPhone" ></input><% if(request.getAttribute("userPhoneError")!=null){ %><%= (String)request.getAttribute("userPhoneError") %><% } %></li>
								<li style="display:block">E-mail&nbsp;&nbsp;��<input type="text" name="userEmail" ></input><% if(request.getAttribute("userEmailError")!=null){ %><%= (String)request.getAttribute("userEmailError") %><% } %></li>
								<li style="display:block;margin-top:20px;"><input type="submit" name="Submit" value="�ύ" >     <a href="/BookManagement/index.jsp">����</a></li>
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