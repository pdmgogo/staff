<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function ShowTabex(val){
  for (i=0; i<3; i++) {
    var tb = document.getElementById('tab_' + i);
    if (i != val) tb.style.display = "none";
    else tb.style.display = "block";
  }
}

</script>
<body>

  <table>
  	<tr>
  <td onclick="ShowTabex('0')" style=" cursor: pointer;">[ 학력  ]</td>
  <td onclick="ShowTabex('1')" style=" cursor: pointer;">[ 경력  ]</td>
  <td onclick="ShowTabex('2')" style=" cursor: pointer;">[ 자격증  ]</td>
  	</tr>
  </table>

<div>
  <div id="tab_0" style="display:block">
  	학력 테이블
  </div>
  <div id="tab_1" style="display:none">
  	경력 테이블
  </div>
  <div id="tab_2" style="display:none">
  	자격증 테이블
  </div>
</div>
</body>
</html>