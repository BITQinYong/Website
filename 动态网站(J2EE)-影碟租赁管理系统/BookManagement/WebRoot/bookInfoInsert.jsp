<%@ page contentType="text/html; charset=GB2312" language="java" import="java.util.*,java.sql.*,com.javaBean.DataBaseBean" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-cn" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<meta name="keywords" content="{$keywords}" />
		<meta name="description" content="{$description}" />
		<title>影音游戏租借系统</title>
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
		String showAddr="/BookManagement/MenuShowServlet?jspURL=" + requestURL +"&param="+ param ; %>
				<ul><li style="text-align:left"><a href=<%= hidAddr %> align="left">隐藏</a> / <a href=<%= showAddr %>>显示</a></li></ul>
<% 
		if(session.getAttribute("hide")==null) { 
%>
<%
 			GregorianCalendar date=new GregorianCalendar();
%>
				<div>
					<h3>管理员,欢迎回来!</h3>
					<ul><li style="text-align:left">今天是<%= date.get(Calendar.MONTH)+1 %>月<%= date.get(Calendar.DAY_OF_MONTH) %>日</li></ul>
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
						<li><a href="/BookManagement/UserSelectBookServlet?type=computer">爱情</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=electric">动作</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=transmit">剧情</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=biology">科幻</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=medicine">喜剧</a></li>
						<li><a href="/BookManagement/UserSelectBookServlet?type=geography">游戏</a></li>
						<li><Form action="/BookManagement/UserSelectBookServlet" Method="post"><Input type=text name="keyword"></Input><Input type=submit name="b" value="搜索"></Input></Form></li>
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
	  				<div class="title" style="height:300px;">
						<div><h3>添加影音游戏信息</h3></div>
						<div class="datainfo">
							<div class="bookInsertForm" style="width: 360px; ">
								<form name="form" method="post" action="/BookManagement/BookInfoInsertServlet">
									<ul style="float:left;width: 380px;display:inline">
										<li style="width:100%;display:block">影音游戏编号：<input name="bookID" type="text" id="bid"><% if(request.getAttribute("bookIDError")!=null){ %><%= (String)request.getAttribute("bookIDError") %><% } %><% if(request.getAttribute("bookIDRepeatError")!=null){ %><%= (String)request.getAttribute("bookIDRepeatError") %><% } %></li>
										<li style="width:100%;display:block">类别&nbsp;&nbsp;&nbsp;&nbsp;：
											<select name="bookType" id="type">
						    					<option value="computer" selected>爱情</option>
						    					<option value="electric">动作</option>
						    					<option value="transmit">剧情</option>
						    					<option value="biology">科幻</option>
						    					<option value="medicine">喜剧</option>
						    					<option value="geography">游戏</option>
	                        				</select><% if(request.getAttribute("bookTypeError")!=null){ %><%= (String)request.getAttribute("bookTypeError") %><% } %>
	                        			</li>
										<li style="width:100%;display:block">名称&nbsp;&nbsp;&nbsp;&nbsp;：<input name="bookName" type="text" id="bname"  ><% if(request.getAttribute("bookNameError")!=null){ %><%= (String)request.getAttribute("bookNameError") %><% } %></li>
										<li style="width:100%;display:block">主演&nbsp;&nbsp;&nbsp;&nbsp;：<input name="bookAuthor" type="text" id="author" ><% if(request.getAttribute("bookAuthorError")!=null){ %><%= (String)request.getAttribute("bookAuthorError") %><% } %></li>
										<li style="width:100%;display:block">发行公司&nbsp;&nbsp;：<input name="bookPublisher" type="text" id="publisher" ><% if(request.getAttribute("bookPubliserError")!=null){ %><%= (String)request.getAttribute("bookPubliserError") %><% } %></li>
										<li style="width:100%;display:block">发行年份：<input name="bookPublicTime" type="text" id="price" ><% if(request.getAttribute("bookPublicTimeError")!=null){ %><%= (String)request.getAttribute("bookPublicTimeError") %><% } %></li>
										<li style="width:100%;display:block">放置位置：<input name="bookPlace" type="text" id="price" ><% if(request.getAttribute("bookPlaceError")!=null){ %><%= (String)request.getAttribute("bookPlaceError") %><% } %></li>
										<li style="float:left;width:100%;display:block;margin-top:20px;"><input type="submit" name="Submit" value="提交">&nbsp;&nbsp;&nbsp;<a href="/BookManagement/bookInfoManage.jsp">返回</a></li>
									</ul>
								</form>
							</div>
							<div class = "imageInsert" style="height: 190px; width: 180px; ">
								<%String imageURL = (String)request.getAttribute("imageURL");
								if(imageURL == null) {imageURL = "blank.jpg";}
								System.out.println(imageURL);
								imageURL = "/BookManagement/image/" + imageURL;%>
								<img src=<%=imageURL%> width="104" height="140" border="0" > 
								<form action="/BookManagement/FileUploadServlet" method="post" enctype="multipart/form-data">  
									<input type="file" name="file" value="选择图片"/>  
									<br/>
									 
									<input type="submit" name="submit" value="上传"/>  
									<input type="reset" name="reset" value="取消"/>  
								</form>
							</div>
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


