<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 이력 등록</title>
<link type="text/css" href="Css/main.css" rel="stylesheet">
</head>
<body>
<%-- 전체를 뒤덥은 컨테이너 입니다. --%>
<div id="contianer">
<%--메인에 붙는 헤더입니다. --%>
	<div id="header">
		<jsp:include page="../header.jsp"/>
	</div>
<%--컨텐츠 전체입니다. --%>
	<div id="content">
<%--사이드 매뉴 역활을 하는 바 부분입니다.  a링크 예정--%>
		<div id="left">
			<h1><a href ="allMember?command=main">목록</a>입니다.</h1>
			<p>개인 프로젝트 이력 관리</p>
			<p>  - <a href ="allMember?command=pj_History_List">프로젝트 이력 목록</a></p>
			<p>  - <a href ="allMember?command=pj_History_InsertForm">프로젝트 이력 등록</a></p>
			<p>개인 정보 관리</p>
			<p>  - <a href ="allMember?command=staff_History_ListView">사원 정보 목록</a></p>
			<p>  - <a href ="allMember?command=staff_History_View">사원 정보 수정</a></p>
			<p><a href ="allMember?command=notice">공지 사항</a></p>
		</div>
		<div id="notice">
		<h2>프로젝트 이력 등록</h2>
		<form action="allMember?command=pj_History_Insert" method="post">
		<input type="hidden" name="pregdate" id="pregdate">
		<table>
			<tr>
				<td>사 번</td>
				<td>${empno} </td>
			</tr>
			<tr>
				<td>I D</td>
				<td>${id }</td>
			</tr>
			<tr>
				<td>프로젝트 명</td>
				<td><input type="text" name="pro_nm" id="pro_nm"></td>
			</tr>
			<tr>
				<td>시작일</td>
				<td><input type="text" name="prostr" id="prostr"></td>
			</tr>
			<tr>
				<td>종료일</td>
				<td><input type="text" name="proend" id="proend"></td>
			</tr>
			<tr>
				<td>사용스킬</td>
				<td><label for = "skill">
					<input type="checkbox" name="sknum" value ="1">java
					<input type="checkbox" name="sknum" value ="2">html
					<input type="checkbox" name="sknum" value ="3">js
					<input type="checkbox" name="sknum" value ="4">min's<br>
					<input type="checkbox" name="sknum" value ="5">디자인
					<input type="checkbox" name="sknum" value ="6">색상
					<input type="checkbox" name="sknum" value ="7">DB
					<input type="checkbox" name="sknum" value ="8">관리자<br>
				</label></td>
			</tr>
			<tr>
				<td>상세내용</td>
				<td><textarea rows="5" cols="60" name="pcontent" id="pcontent"></textarea></td>
			</tr>
			<tr>
				<td>수행역활</td>
				<td>
					<select name="rolenum">
						<option value="1">프론트</option>
						<option value="2">백앤드</option>
						<option value="3">DB파트</option>
						<option value="4">노는닝겐</option>
						<option value="5">오버워치</option>								
					</select>
				</td>
			</tr>
			
		
		</table>
		<input type="submit" value="수정" >
		</form>
		</div>
	</div>
</div>
<%-- 푸터입니다. --%>
	<div id="footer">
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>