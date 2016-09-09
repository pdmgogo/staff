<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
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
		<h2>공지사항</h2>
		
			<table id="noticeList">
					<tr>
						<td>순  번</td>
						<td>제  목 </td>
						<td>등록일</td>
						<td>조  회</td>
					</tr>
					<c:forEach var = "noticeList" items="${List}">
						<tr>
						<td>${noticeList.notno}</td>
						<td><a href="allMember?command=noticeDetail&notno=${noticeList.notno}" >${noticeList.not_nm}</td>
						<td>${noticeList.not_dt}</td>
						<td>${noticeList.not_hits}</td>
						</tr>
					</c:forEach>
	
					<tr>
						<td>
							<c:if test="${Dto.prevPage != 0}">
								<a href="allMember?command=notice&pageNum=${Dto.prevPage}">이전</a>
							</c:if>
						</td>
						<td colspan="2">
							<c:forEach var="i" begin="${Dto.firstPage}" end="${Dto.lastPage}">
       						[
       						<a href="allMember?command=notice&pageNum=${i}">${i}</a>
      						]
   							</c:forEach>
						</td>
						<td>
							<c:if test="${Dto.nextPage != 0}">
								<a href="allMember?command=notice&pageNum=${Dto.nextPage }">이후</a>
							</c:if>
						</td>  
					</tr>
			</table>
			<a href="allMember?command=noticeInsertForm">등록</a>
		</div>
	</div>
</div>
<%-- 푸터입니다. --%>
	<div id="footer">
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>