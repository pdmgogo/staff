<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 정보 수정</title>
<link rel ="stylesheet" href ="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link type="text/css" href="Css/main.css" rel="stylesheet">
<!-- <link type="text/css" href="Css/staff_History_Update.css" rel="stylesheet"> -->
<!--  <script type="text/javascript" src = "js/staff_History_Update.js"></script>-->
<script type="text/javascript" src = "js/addr.js"></script>
<style type="text/css">
	
</style>
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
		<h2>사원 상세 화면</h2>뷰
			<form action="allMember?command=staff_History_Update" method="post" name ="SHUpdate">
			
			<table>
				<tr>
					<td>사진공간</td>
					<td>
						<table>
							<tr>
								<td>사번 : </td>
								<td>${dto.empno}</td>
							</tr>
							<tr>
								<td>이름 : </td>
								<td>${dto.empl_nm}</td>
							</tr>
							<tr>
								<td>주민번호 : </td>
								<td>${dto.fjumin}뒷자리는 생략합니다.</td>
							</tr>
							<tr>
								<td>비밀번호 : </td>
								<td><input type="text" name="pwd" ></td>
							</tr>
							<tr>
								<td>성별 : </td>
								<td></td>
							</tr>
							<tr>
								<td>생년월일 : </td>
								<td></td>
							</tr>
							<tr>
								<td>부서 :</td>
								<td>
									<select name="deptno">
										<option value="1">총무부</option>
										<option value="2">생산부</option>
										<option value="3">개발부</option>
										<option value="4">연구부</option>
										<option value="5">놀자부</option>								
								 	</select>
								 </td>
							</tr>
							<tr>
								<td>직급 :</td>
								<td>
									<select name="jobno">
										<option value="1">사원</option>
										<option value="2">대리</option>
										<option value="3">부장</option>
										<option value="4">차장</option>
										<option value="5">사장</option>								
								 	</select>
								</td>
							</tr>
							<tr>
								<td>이메일 : </td>
								<td><input type="text" name="email" ></td>
							</tr>
							<tr>
								<td>입사일 : </td>
								<td><input type="text" name="hiredate" ></td>
							</tr>
							<tr>
								<td>퇴사일 : </td>
								<td><input type="text" name="resigndate" ></td>
							</tr>
							<tr>
								<td>우편번호 : </td>
								<td><input type="text" name="zip_cd" ></td>
							</tr>
							<tr>
								<td>주소 : </td>
								<td><input type="button" value="검색" name="addr" id="addr"></td>
							</tr>
							<tr>
								<td>상세주소 : </td>
								<td><input type="hidden" name="deaddr" id="deaddr"></td>
							</tr>
							<tr>
								<td>급여 : </td>
								<td><input type="text" name="sal" ></td>
							</tr>
							<tr>
								<td>비고 : </td>
								<td><input type="text" name="etc" ></td>
							</tr>
							
							<tr>
								<td>등록일: </td>
								<td><input type="text" name="eregdate" ></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
		</form> 
		</div>
	</div>
</div>

	<div id="footer">
		<jsp:include page="../footer.jsp"/>
	</div>
<div id="SearchAddr" title="수리중">
  	<form action="allMember" method="post">
  	<input type="hidden" name="command" value="staff_History_UpdateForm">
  	<p>주소 검색창</p>
    	<fieldset>
      
    
    	</fieldset>
  	</form>
</div>
</body>
</html>