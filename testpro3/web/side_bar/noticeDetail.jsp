<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 이력 상세</title>
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
			<h2>공지사항입니다.</h2>		
			<table id="staff_list">
				
					<tr>
						<td>재목 : </td>
						<td colspan="4">(title) "${Dto.not_nm }"</td>
						<td></td>
					</tr>
					<tr>
						<td>작 성 자 : ${Dto.empl_nm }</td>
						<td>세션에 있는 admin가지고 오기</td>
						<td>작 성 일</td>
						<td>${Dto.not_dt }</td>
						<td>조 회 수</td>
						<td>${Dto.not_hits }</td>
					</tr>
					<tr>
						<td colspan="6" >${Dto.notcon }<td>
					</tr>
					
				
			</table>
			<a href="allMember?command=notice">목록</a>
			<a href="allMember?command=noticeUpdateForm&notno=${Dto.notno }">수정</a>
			<a href="allMember?command=noticeDelete&notno=${Dto.notno }">삭제</a>
		</div>
	</div>
</div>
<%-- 푸터입니다. --%>
	<div id="footer">
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>