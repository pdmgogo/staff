<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href ="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/tapJs.js"></script>
<script type="text/javascript" src="js/lic.js"></script>
<script type="text/javascript" src="js/school.js"></script>
<script type="text/javascript" src="js/comp.js"></script>
</head>
<body>
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
  	</table>
  	<input type="button" id ="school" name="school" value="수정">
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
  		
  	</table>
  	<input type="button" id ="comp" name="comp" value="수정">
  </div>
<div id="schoolList" title="학력">
  	<form action="allMember" method="post">
  	<input type="hidden" name="command" value="staff_History_UpdateForm">
  	<p>학력</p>
    	<fieldset>
      
    
    	</fieldset>
  	</form>
</div>
<div id="company" title="경력">
  	<form action="allMember" method="post">
  	<input type="hidden" name="command" value="staff_History_UpdateForm">
  	<p>경력</p>
    	<fieldset>
      
    
    	</fieldset>
  	</form>
</div>
<div id="licList" title="자격증">
  	<form action="allMember" method="post">
  	<input type="hidden" name="command" value="staff_History_UpdateForm">
  	<p>자격증</p>
    	<fieldset>
      
    
    	</fieldset>
  	</form>
</div>
</body>
</html>