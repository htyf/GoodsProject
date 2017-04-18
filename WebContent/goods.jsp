<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	ul{
		list-style:none;
	}
	ul li{
		float: left;
		width: 45px;
	}
</style>
</head>
<body>
	<pre>商品名称  商品数量  商品价格</pre>
	<%-- 我怎么找到request域中的list对象
<%
	pageContext.findAttribute("list");
%> --%>
	<c:forEach var="good" items="${list}">
		<a href="#?id=${good.g_id}" target="_self">${good.g_name}  ${good.g_count}  ${good.g_price}</a><br/>
	</c:forEach>
	<div class="pager">
		<ul id="ul_1">
			<li><a href="doGoods?id=2&page=${pager.prevPage}">上一页</a></li>
			<c:forEach items="${pager.groupList}" var="i">
				<c:if test="${ i == pager.currentPage }">
					<li>${i}</li>
				</c:if>  
				<c:if test="${ i != pager.currentPage }">
					<li><a href="doGoods?id=2&page=${i}">${i}</a></li>
				</c:if>
			</c:forEach>
			<li><a href="doGoods?id=2&page=${pager.nextPage}">下一页</a></li>
		</ul>
	</div>
</body>
</html>