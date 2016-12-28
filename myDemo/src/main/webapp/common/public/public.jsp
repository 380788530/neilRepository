<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String contextPath = request.getContextPath();
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath;
	String ctx = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath();
	request.setAttribute("path",  contextPath+"/");
	request.setAttribute("basePath",  path+"/");

%>



	<script type="text/javascript" src="${basePath }common/js/jquery-1.11.3.min.js?ran=<%=Math.random()%>" ></script>
	
<%-- 	
	<link href="${basePath}common/media/css/bootstrap.min.css" rel="stylesheet">
	
	
	
	<script src="${basePath}common/media/js/bootstrap.min.js" type="text/javascript"></script> --%>
	
 


<input type="hidden" id="basePath" value="${basePath }">