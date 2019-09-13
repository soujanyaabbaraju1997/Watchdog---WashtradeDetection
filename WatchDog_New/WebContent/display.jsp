<%@page import="com.pojos.Trade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
			List<Trade> trade = (List<Trade>) request.getAttribute("data");

			for (Trade t : trade) {
		%>
		<%-- AArranging data in tabular form 
        --%>
		<tr>
			<td><%=t.getTradeId()%></td>
			<td><%=t.getTrader().getTraderName()%></td>
			<td><%=t.getTimeStamp()%></td>
			<td><%=t.isTradeType()%></td>
			<td><%=t.getSecurityId()%></td>
			<td><%=t.getQty()%></td>
			<td><%=t.getDealPrice()%></td>
			<td><%=t.getFirmId()%></td>
			<td><%=t.getBrokerId()%></td>


		</tr>
		<%
			}
		%>
	</table>
</body>
</html>