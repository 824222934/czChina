<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>有什么想说的？快快写下你的心情吧。。。</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <span>有什么想说的？快快写下你的心情吧。。。</span>
    <form action="core/PublishServlet" enctype="multipart/form-data" method="post">
    	<input type="text" name="DDtitle"/></br>
    	<textarea name="DDcontent" rows="10" cols="50"></textarea></br>
    	  上传图片：<input type="file" name="DDfile" accept="image/gif, image/jpeg"/></br>  
    	<input type="submit" value="发表"/>
    </form>
  </body>
</html>
