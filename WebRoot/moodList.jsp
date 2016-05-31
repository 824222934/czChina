<%@page import="entity.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
PageBean pageBean = (PageBean)request.getAttribute("pageBean");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'moodList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" type="text/javascript" src="${request.contextPath}/js/shade.js"></script>
  <script language="JavaScript" type="text/javascript">
   
  function submitForm(maxpage){
     var page = document.getElementById("page").value;
     var patrn=/^[0-9]{1,20}$/;
     if (!patrn.exec(page)){
       alert("请输入正整数字！");
     } else if(page > maxpage){
       alert("跳转页码不能超过总页数！");      
     }else if(page < 1){
       alert("跳转页码不能小与1！");      
     }else{
        document.getElementById("searchImportTask").submit();
      }
  }
   
 function checkDel(){
  	var str = "/%E6%B1%A4%E5%A7%86%E7%8C%AB";alert(str);
  	var str2 =  decodeURIComponent(str);alert(str2);
	document.location.href("/downloads/汤姆猫.zip")
 	var url = document.location.href;
    var name=""
    if (url.indexOf("=")>0)
    {
        name = url.substring(url.indexOf("=")+1,url.length)
    }
 	alert(url);
 var qq = document.getelementbyid("jiema");
	alert(qq);
  }
  </script>
  </head>
  
  <body>
    <div id="content">
    <div id="allmain">
     
<form  action="/czChina/core/MoodListServlet" method="post" id="searchImportTask">
<h2>查看所有动态</h2>
   <c:forEach var="mood" items="${pageBean.list}">  
        <tr>  
          <td id="title">标题：${mood.moodTitle }</td></br> 
          <td id="content" >内容：${mood.moodContent}</td></br>
          <p id="photourl"><img alt="" height="100" width="60" src="/upload/${mood.photoUrl}"/></p></br>
        </tr>  
	</c:forEach> 
 
<style>
.result{ text-align:center; padding-top:10px}
.red{ color:#CE490F}
a{ color:#656565}
a:hover{ color:#CE490F}
.input_blur{ width:35px; height:14px}
</style>
<p class="result">
共 <b class="red">${pageBean.allRow}</b> 条   共 <b class="red">${pageBean.totalPage}</b> 页   第 <b class="red">${pageBean.currentPage}</b> 页   
 
<if ("${pageBean.currentPage}" == "1")>
<a href="core/MoodListServlet?page=1">首页</a>   
<a href="core/MoodListServlet?page=${pageBean.currentPage+1}">下一页</a>   
</if>
 
<if ("${pageBean.currentPage}" == "${pageBean.totalPage}")>
<a href="core/MoodListServlet?page=${pageBean.currentPage-1}">上一页</a> 
<a href="core/MoodListServlet?page=${pageBean.totalPage}">末页</a>   
</if>
<input name="page" id="page" type="text" class="input_blur" />
  <a href="javascript:submitForm(${pageBean.totalPage});"  target="_self" class="go" >GO</a></p>
 
</form>
    </div>
</div>   
  </body>
</html>
