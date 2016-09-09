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
<script type="text/javascript" src="js/tapJs.js"></script>
<script type="text/javascript" src="js/comp.js"></script>
<script type="text/javascript" src="js/lic.js"></script>
<script type="text/javascript" src="js/school.js"></script>
<!-- <link type="text/css" href="Css/staff_History_View.css" rel="stylesheet"> -->
<!--  <script type="text/javascript" src = "js/staff_History_Update.js"></script>-->

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
			<form action="allMember?command=staff_History_UpdateForm" method="post">
			
			<table>
				<tr>
					<td>사진공간</td>
					<td>
						<table>
							<tr>
								<td>사번  </td>
								<td> : </td>
								<td>${Dto.empno}</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>
								<td>이름   </td>
								<td> : </td>
								<td>${Dto.empl_nm}</td>
							</tr>
							<tr>
								<td>비밀번호  </td>
								<td> : </td>
								<td></td>
							</tr>
							<tr>
								<td>부서  </td>
								<td> : </td>
								<td>${Dto.dept_nm}</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>
								<td>직급  </td>
								<td> : </td>
								<td> ${Dto.job_nm}</td>
							</tr>
							<tr>
								<td>이메일  </td>
								<td> : </td>
								<td>${Dto.email}</td>
							</tr>
							<tr>
								<td>입사일  </td>
								<td> : </td>
								<td>${Dto.hiredate}</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>
								<td>퇴사일  </td>
								<td> : </td>
								<td>${Dto.resigndate}</td>
							</tr>
							<tr>
								<td>우편번호  </td>
								<td> : </td>
								<td>${Dto.zip_cd}</td>
							</tr>
							<tr>
								<td>주소  </td>
								<td> : </td>
								<td>${Dto.addr}</td>
							</tr>
							<tr>
								<td>상세주소  </td>
								<td> : </td>
								<td>${Dto.deaddr}</td>
							</tr>
							<tr>
								<td>급여  </td>
								<td> : </td>
								<td>${Dto.sal}</td>
							</tr>
							<tr>
								<td>비고  </td>
								<td> : </td>
								<td>${Dto.etc}</td>
							</tr>
							
							<tr>
								<td>등록일 </td>
								<td> : </td>
								<td>${Dto.eregdate}</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		<input type="submit" value="수정">
		</form> 
		<!--  -->
<table>
  	<tr>
  <td onclick="ShowTabex('0')" style=" cursor: pointer;">[ 학력  ]</td>
  <td onclick="ShowTabex('1')" style=" cursor: pointer;">[ 경력  ]</td>
  <td onclick="ShowTabex('2')" style=" cursor: pointer;">[ 자격증  ]</td>
  	</tr>
</table>

<div>
  <div id="tab_0" style="display:none">
  	<h2>각 사원의 학력 empno</h2>
  	<table>
  		<tr>
  			<td>최종학교이름 / 졸업여부</td>
  			<td>SCH_NM / GRADU</td>
  		</tr>
  		<tr>
  			<td>입학일 / 졸업일</td>
  			<td>ADM_DT / GRA_DT</td>
  		</tr>
  		<tr>
  			<td>전공</td>
  			<td>major</td>
  		</tr>
  		<tr>
  			<td>주소</td>
  			<td>loc</td>
  		</tr>
  		<button id="school">클릭</button>
  	</table>
  	
  </div>
  <div id="tab_1" style="display:none">
  	<h2>각 사원의 경력 empno</h2>
  	<table>
  		<tr>
  			<td>예전회사의 회사명 (최근)</td>
  			<td>COMP_NM</td>
  		</tr>
  		<tr>
  			<td>입사일 / 퇴사일(최근 회사기준)</td>
  			<td>COMSTA / COMEND </td>
  		</tr>
  		<tr>
  			<td>부서명 / 직급명(최근 회사기준)</td>
  			<td>DEPT_NM_B / JOB_NM_B</td>
  		</tr>
  		<tr>
  			<td>담당업무 (최근 회사기준)</td>
  			<td>COMBUS</td>
  		</tr>
  		<button id="comp">클릭</button>
  	</table>
  	

  </div>
  <div id="tab_2" style="display:none">
  	<h2>각 사원의 자격증 empno 여기는 등록과 업뎃이 있어야함</h2>
  	<table>
  		<tr>
  			<td>자격증명 / 자격증번호</td>
  			<td>LIC_NM / LICNO</td>
  		</tr>
  		<tr>
  			<td>취득일 / 만료일자</td>
  			<td>LIC_DT / LIC_END_DT</td>
  		</tr>
  		<tr>
  			<td>발행처</td>
  			<td>LICORG</td>
  		</tr>
  		<button id="lic">클릭</button>
  	</table>

  </div>
</div>
		</div>
	</div>
</div>

<%-- 푸터입니다. --%>
	<div id="footer">
		<jsp:include page="../footer.jsp"/>
	</div>
<div id="company" title="수리중">
  	<form action="allMember" method="post">
  	<input type="hidden" name="command" value="staff_History_UpdateForm">
  	<p>경력</p>
    	<fieldset>
    		<!-- EMPNO	VARCHAR2(10)			이걸 기반으로 정리합니다.
	COMP_NM	VARCHAR2(100)			예전회사명입니다.
	COMSTA	DATE			예전에 일했던 회사입사일입니다.
	COMEND	DATE			예전회사의 퇴사일입니다.
	DEPT_NM_B	VARCHAR2(30)			예전회사의 무서명입니다.
	JOB_NM_B	VARCHAR2(30)			예전회사의 직급명입니다.
	COMBUS	VARCHAR2(2000)			예전회사의 담당업무입니다.
	REASON	VARCHAR2(2000)			예전회사의 퇴사이유입니다. -->
      		<table>
 				<tr>
 					<td>예전 회사명</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="comp_nm" id="comp_nm">
 					</td>
 				</tr>
 				<tr>
 					<td>입사일  </td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="comsta" id="comsta">
 					</td>
 				</tr>
 				<tr>
 					<td>퇴사일</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="comend" id="comend">
 					</td>
 				</tr>
 				<tr>
 					<td>부서명</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="dept_nm_b" id="dept_nm_b">
 					</td>
 				</tr>
 				<tr>
 					<td>직급명</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="job_nm_b" id="job_nm_b">
 					</td>
 				</tr>
 				<tr>
 					<td>담당업무</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="combus" id="combus">
 					</td>
 				</tr>
 				<tr>
 					<td>퇴사이유</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>REASON
 						<input type="text" name="comp_nm" id="comp_nm">
 					</td>
 				</tr>
 			</table>
    
    	</fieldset>
  	</form>

<div id="schoolList" title="수리중">
  	<form action="allMember" method="post">
  	<input type="hidden" name="command" value="staff_History_UpdateForm">
  	<p>학력</p>
    	<fieldset>
      		<table>
 				<tr>
 					<td>자격증 명</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="lic_nm" id="lic_nm">
 					</td>
 				</tr>
 				<tr>
 					<td>자격증 번호</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="licno" id="licno">
 					</td>
 				</tr>
 				<tr>
 					<td>취득일</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="lic_dt" id="lic_dt">
 					</td>
 				</tr>
 				<tr>
 					<td>만료일자</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="lic_end_dt" id="lic_end_dt">
 					</td>
 				</tr>
 				<tr>
 					<td>발행처</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="licorg" id="licorg">
 					</td>
 				</tr>
 			</table>
    
    	</fieldset>
  	</form>
</div>

</div>
<div id="licList" title="수리중">
  	<form action="allMember" method="post">
  	<input type="hidden" name="command" value="staff_History_UpdateForm">
  	<p>자격증</p>
    	<fieldset>
    	<!--empno다 빠짐  -->
   <!--    		자격증명 LIC_NM
      		 자격증번호	LICNO
	취득일 	LIC_DT
	만료일자	 LIC_END_DT
 	발행처	LICORG -->
 			<table>
 				<tr>
 					<td>자격증 명</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="lic_nm" id="lic_nm">
 					</td>
 				</tr>
 				<tr>
 					<td>자격증 번호</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="licno" id="licno">
 					</td>
 				</tr>
 				<tr>
 					<td>취득일</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="lic_dt" id="lic_dt">
 					</td>
 				</tr>
 				<tr>
 					<td>만료일자</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="lic_end_dt" id="lic_end_dt">
 					</td>
 				</tr>
 				<tr>
 					<td>발행처</td>
 					<td>&nbsp;</td>
 					<td>:</td>
 					<td>
 						<input type="text" name="licorg" id="licorg">
 					</td>
 				</tr>
 			</table>
    	</fieldset>
  	</form>
</div>
</body>
</html>