<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href ="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src = "js/join.js"></script>
<style type="text/css">

	boby { font-size: 62.5%}
	label,input { display:bottom:12px; width:100px; padding: .4em;}
	fieldset {padding: 0; border: 0;
	margin-top: 25px;}
	.ui-dialog .ui-state-error{padding: .3em;}	

</style>
</head>
<body>
<div id="dialog-form" title="회원등록">
  <p class="validateTips">전부 입력하세요.</p>
 
  <form action="allMember" method="post" id="fmt">
  <input type="hidden" name="command" value="AllmemberAdd">
    <fieldset>
      <label for="empl_nm">이름 : </label>
      <input type="text" name="empl_nm" id="empl_nm" value="" class="text ui-widget-content ui-corner-all"><br>
      <label for="id">아이디 : </label>
      <input type="text" name="id" id="id" value="" class="text ui-widget-content ui-corner-all"><br>
      <label for="email">이메일 : </label>
      <input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all"><br>
      <label for="pwd">비밀번호 : </label>
      <input type="password" name="pwd" id="pwd" value="" class="text ui-widget-content ui-corner-all"><br>
      <label for="fjumin">주민번호 : </label>
      <input type="text" name="fjumin" id="fjumin" value="" class="text ui-widget-content ui-corner-all"><br>
      <label for="bjumin"> - </label>
      <input type="password" name="bjumin" id="bjumin" value="" class="text ui-widget-content ui-corner-all"><br>

     <input type="submit" tabindex="-1" style="position:absolute; top:-1000px"> 
    </fieldset>
  </form>
</div>


<form action="allMember" method="post">
<input type="hidden" name="command" value="loginAction">
	<div>아이디 :</div>
	<input type="text" id = "id" name = "id"><br>
	<div>비번 :</div>
	<input type="password" id = "pwd" name = "pwd"><br>
	<input type="submit" value="로그인">
	<input type="reset" value="다시작성">
</form>
	<!-- 자스 처리 dialog참고  -->
	<button id="joinUs">회원가입</button>
</body>
</html>