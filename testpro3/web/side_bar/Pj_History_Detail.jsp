<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<h1>프로젝트 이력 상세</h1>
				<table>
					<tr>
						<td>사번  </td>
						<td> : </td>
						<td>${ProDetail.empno }</td>
					</tr>
					<tr>
						<td>아이디  </td>
						<td> : </td>
						<td>${ProDetail.id }</td>
					</tr>
					<tr>
						<td>프로젝트명  </td>
						<td> : </td>
						<td>${ProDetail.pro_nm }</td>
					</tr>
					<tr>
						<td>기간  </td>
						<td> : </td>
						<td>${ProDetail.prosta } ~ ${ProDetail.proend }</td>
					</tr>
					<tr>
						<td>사용스킬  </td>
						<td> : </td>
						<td>
							<c:forEach var = "skillList" items="${skill}">
							 [ ${skillList.skill_nm} ]
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td>상세내용  </td>
						<td> : </td>
						<td>${ProDetail.pcontent }</td>
					</tr>
					<tr>
						<td>수행역활  </td>
						<td> : </td>
						<td>${ProDetail.role }</td>
					</tr>
					<tr>
						<td><a href="allMember?command=pj_History_List">목록</a></td>
						<td><a href="allMember?command=pj_History_UpdateForm&prono=${ProDetail.prono }">수정</a></td>
						<td>삭제(딜리트절Pj_History_List.jsp)</td>
					</tr>
					
					<!-- 목록(리스트 다시 보여주기Pj_History_List.jsp) --> 
					
					<!-- 수정(업데이트절Pj_History_Update.jsp)  -->
					
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