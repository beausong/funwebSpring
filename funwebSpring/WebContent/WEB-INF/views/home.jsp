<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<!-- <h1> -->
<!-- 	Hello world!    -->
<!-- </h1> -->

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
<!-- index.html -->
<script>
//location.href="main/main.html";
// location.href="main/main.jsp";
location.href='<c:url value="/member/insert"/>'

// 가상주소 
//   http://localhost:8080/FunWeb/board/main
//   http://localhost:8080/FunWeb/member/insert
//   http://localhost:8080/FunWeb/member/login
//   http://localhost:8080/FunWeb/board/write
//   http://localhost:8080/FunWeb/board/list


</script>
</body>
</html>


