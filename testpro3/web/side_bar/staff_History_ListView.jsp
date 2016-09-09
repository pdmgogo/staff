<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 정보 목록</title>
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
		<h2>사원 정보 목록</h2>
			<table name="staff_select" id="staff_select">
				<form>검색기능 없음
					<tr>
						<td> I D :</td>
						<td><input type="text" name="id" id="id"></td>
						<td>등 록 일 :</td>
						<td><input type="text" name="insert_date" id="insert_date"></td>
					</tr>
					<tr>
						<td>사 원 명 :</td>
						<td><input type="text" name="staff_nm" id="staff_nm"></td>
						<td colspan="2" align="right"><input type="submit" value="검색"></td>
					</tr>
				</form>
			</table>
			<table id="staff_list">
					<tr>
						<td>순  번</td>
						<td>사 원 명</td>
						<td>직급</td>
						<td>등록일</td>
					</tr>
					<c:forEach var = "List" items="${List}">
						<tr>
						<td>${List.nono}</td>
						<td>${List.empl_nm}</td>
						<td>${List.job_nm}</td>
						<td>${List.eregdate}</td>
						</tr>
					</c:forEach>
					
					<tr>
						<td>
							<c:if test="${Dto.prevPage != 0}">
								<a href="allMember?command=staff_History_ListView&pageNum=${Dto.prevPage}">이전</a>
							</c:if>
						</td>
						<td colspan="2">
							<c:forEach var="i" begin="${Dto.firstPage}" end="${Dto.lastPage}">
       						[
       						<a href="allMember?command=staff_History_ListView&pageNum=${i}">${i}</a>
      						]
   							</c:forEach>
						</td>
						<td>
							<c:if test="${Dto.nextPage != 0}">
								<a href="allMember?command=staff_History_ListView&pageNum=${Dto.nextPage }">이후</a>
							</c:if>
						</td>  
					</tr>
			</table>
						
		</div>
	</div>
</div>
<%-- 푸터입니다. --%>
	<div id="footer">
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>