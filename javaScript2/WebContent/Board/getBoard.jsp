<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.yedam.board.BoardDAO" %>
<%@page import="com.yedam.board.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String bNo = request.getParameter("boardNo");
		BoardDAO dao = new BoardDAO();
		Board b = dao.getBoardInfo(Integer.parseInt(bNo));
		
		%>
		<h1><a href="getBoardList.html">Board List</a></h1>
		<table border=1>
		<tr><td>Board_No</td><td><%= bNo %></td></tr>
		<tr><td>content</td><td><%=b.getContent() %></td></tr>
		<tr><td>writer</td><td><%=b.getWriter() %></td></tr>
		<tr><td>create_date</td><td><%=b.getDate()%></td></tr>
		</table>
</body>
</html>



