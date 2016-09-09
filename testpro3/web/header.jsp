<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	<%-- window.onload
	function logout() {
		<% session.invalidate(); %>
		location.href="index.jsp";
	} --%>

</script>
<style type="text/css">
#leftHeader{
	text-align: center;
	font-size: 2em;
	padding: 20px; 
	float: left;
}
#right{
	float: right;
	font-size: 20px;
}
</style>


<%
	String empl_nm = (String) session.getAttribute("empl_nm");
%>
<h1 id="leftHeader">사원관리 프로그램</h1>
<p id="right">
	<a>${empl_nm}</a>님 반갑습니다.
	<!-- <button id="logout">로그아웃</button> -->
</p>
