<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes - Your Purchases</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/components/header.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/view/components/topbar.jsp" ></jsp:include>

<br><br>Total ${list.size()} Orders: ${totalAmount }<br>

<table border=1 cellspacing=2 cellpadding=4>
 	<tr>
 		<td><b>Order ID</b></td>
 		<td><b>Date</b></td>
 		<td><b>Total</b></td>
 		<td><b>Items</b></td>
 	</tr>
 	<c:forEach items="${list}" var="item">
 	  	<tr>
	 		<td>${item.ID }</td>
 			<td>${item.date }</td>
 			<td>${item.total}</td>
 			<td>
 				${mapItems.get(item.ID)}
 			</td>
 	  	</tr>
 	  </c:forEach>
</table> 		

<br>
<jsp:include page="/WEB-INF/view/components/footer.jsp"></jsp:include>
</body>
</html>