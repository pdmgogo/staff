package com.staff.controller.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.staff.common.util.DBManager;

import com.staff.controller.Dto.EmpDto;
import com.staff.controller.Dto.EmpProjectDto;
import com.staff.controller.Dto.ProjectDto;
import com.staff.controller.Dto.SkillDto;
import com.staff.controller.Dto.noticeDto;


public class AllDao {
	private AllDao() {
		
	}
	
	private static AllDao instance = new AllDao();
		
	public static AllDao getInstance() {
		return instance;
	}
	//로그인시 가입회원을 db에서 가져오는 문
	public int logincheck(String id ,String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	//기본 결과값 -1로 줌
		int result = -1;
	// id값에 따른 pwd값 검색 // 나중에 비교
		String selectIdPwdSql = "select pwd from EMP where id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(selectIdPwdSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	
			if(rs.next()){
				// 조건문으로 pwd값이 널이 아니고 값이 같을경우에만 결과값을 1로 변경
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {
					
					result = 1;
				} else {
					result = 0;
				}
			}else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		//조건문으로 비교된 결과값 반환
		return result;
	}
	//회원등록
	public int insertMember(EmpDto dto) {

		//기본 결과값을 -1로 지정
		int result = -1;
		//db에 저장명령문
		String insertSql = "insert into emp("
				+ "empno, empl_nm, id, email, pwd, fjumin, bjumin, admin) "
				+ "values(empno, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int admin = 0;
		try {	
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, dto.getEmpl_nm());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPwd());
			pstmt.setString(5, dto.getFjumin());
			pstmt.setString(6, dto.getBjumin());
			pstmt.setInt(7, admin);		
			//정상 처리시 결과값이 1로 변경
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	//id값으로 간편회원정보 가지고 오기
	public EmpDto StartJoinStaff(String id) {
		EmpDto dto = null;
		String sql = "select empno, empl_nm, id, pwd, email from EMP where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()){
				dto = new EmpDto();
				dto.setEmpno(rs.getString("empno"));
				dto.setEmpl_nm(rs.getString("empl_nm"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return dto;
	}
	//세션에 저장되여있는 사원번호값으로 emp테이블정보 가지고오기
	public EmpDto SelectAll(String empno) {
		
		String sql = "select e.*, d.dept_nm as dept_nm , j.job_nm as job_nm "
				+ "from EMP e join dept d "
				+ "on e.deptno = d.deptno "
				+ "join job j "
				+ "on e.jobno = j.jobno "
				+ "where empno = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		EmpDto empdto = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			rs = pstmt.executeQuery();
			if (rs.next()){
				empdto = new EmpDto();
				empdto.setEmpno(rs.getString("empno"));
				empdto.setDeptno(rs.getString("deptno"));
				empdto.setJobno(rs.getString("jobno"));
				empdto.setId(rs.getString("id"));
				empdto.setPwd(rs.getString("pwd"));
				empdto.setEmpl_nm(rs.getString("empl_nm"));
				empdto.setFjumin(rs.getString("fjumin"));
				empdto.setBjumin(rs.getString("bjumin"));
				empdto.setHiredate(rs.getString("hiredate"));
				empdto.setResigndate(rs.getString("resigndate"));
				empdto.setEmail(rs.getString("email"));
				empdto.setZip_cd(rs.getString("zip_cd"));
				empdto.setAddr(rs.getString("addr"));
				empdto.setDeaddr(rs.getString("deaddr"));
				empdto.setSal(rs.getInt("sal"));
				empdto.setEtc(rs.getString("etc"));
				empdto.setEregdate(rs.getString("eregdate"));
				empdto.setEpic(rs.getString("epic"));
				empdto.setAdmin(rs.getString("admin"));
				//조인 이용하여 번호에 따른 부서와 직급 가지고옴
				empdto.setDept_nm(rs.getString("dept_nm"));
				empdto.setJob_nm(rs.getString("job_nm"));
			
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return empdto;
	}
		
		public void updateEmp(EmpDto dto) {
			
			String updateEmpSql = "update emp set deptno=?, "
					+ "jobno=?, pwd=?, hiredate=?, resigndate=?, "
					+ "email=?, zip_cd=?, addr=?, deaddr=?, "
					+ "sal=?, etc=?, eregdate=? where id=? ";
//			
			Connection conn = null;
			PreparedStatement pstmt = null;

			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(updateEmpSql);
				
//				
					pstmt.setString(1, dto.getDeptno());
					
					pstmt.setString(2, dto.getJobno());
				
					pstmt.setString(3, dto.getPwd());
					
					pstmt.setString(4, dto.getHiredate());
				
					pstmt.setString(5, dto.getResigndate());
					
					pstmt.setString(6, dto.getEmail());
				
					pstmt.setString(7, dto.getZip_cd());
				
					pstmt.setString(8, dto.getAddr());
					
					pstmt.setString(9, dto.getDeaddr());
					
					pstmt.setInt(10, dto.getSal());
				
					pstmt.setString(11, dto.getEtc());
					
					pstmt.setString(12, dto.getEregdate());
			
					pstmt.setString(13, dto.getId());
					
					pstmt.executeUpdate();
					
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		
		//노티스인설트
		public void noticeInsert(noticeDto dto) {
			
			//db에 저장명령문
			String Sql = "insert into notice("
					+ "notno, not_nm, not_dt, notcon, not_hits, empno) "
					+ "values(Seq_notno.nextval, ?, sysdate, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			int not_hits = 0;
			try {	
				conn = DBManager.getConnection();
				
				pstmt = conn.prepareStatement(Sql);
				pstmt.setString(1, dto.getNot_nm());
				pstmt.setString(2, dto.getNotcon());
				pstmt.setInt(3, not_hits);
				pstmt.setString(4, dto.getEmpno());
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		
		//노티스 기본 업데이트
		public void noticeUpdate(noticeDto dto) {
			
			String Sql = "update notice set "
					+ "not_nm=?, not_dt=sysdate, notcon=? "
					+ "where notno=? ";

			Connection conn = null;
			PreparedStatement pstmt = null;
			
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(Sql);
				
					pstmt.setString(1, dto.getNot_nm());
					pstmt.setString(2, dto.getNotcon());
					pstmt.setInt(3, dto.getNotno());
					
					pstmt.executeUpdate();
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		//노티스 기본딜리트 (댓글부분까지 같이)
		public void noticeDelete(noticeDto dto) {
			String deleteSql = "delete from notice where notno=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(deleteSql);
				pstmt.setInt(1, dto.getNotno());
				pstmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			
		}
		//노티스 셀렉
		public int noticeSelectList(noticeDto dto) {
			
			String sql = "select n.*, e.empl_nm as empl_nm "
					+ "from notice n join emp e "
					+ "on n.empno = e.empno "
					+ "where notno = ? ";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int result = -1;
			try {
				
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getNotno());
				rs = pstmt.executeQuery();
				if (rs.next()){

					dto.setNotno(rs.getInt("notno"));
					dto.setNot_nm(rs.getString("not_nm"));
					dto.setNot_dt(rs.getTimestamp("not_dt"));
					dto.setNotcon(rs.getString("notcon"));
					dto.setNot_hits(rs.getInt("not_hits"));
					dto.setEmpl_nm(rs.getString("empl_nm"));
					result = 1;
				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			return result;
		}
		//조회수 1씩 증가부분입니다.
		public void Updatehit(noticeDto dto) {
			String sql = "update notice set not_hits = not_hits+1 where notno = ?";
			Connection conn = null;
			PreparedStatement pstmt =null;
			
			try {
				conn = DBManager.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getNotno());
				
				pstmt.executeUpdate();
			}catch(SQLException e ){
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
		//프로젝트 select
		
	
		//프로젝트 insert
		public int proinsert(ProjectDto dto) {

			String insertSql = "insert into CPROJECT("
					+ "PRONO, PRO_NM, PROSTA, PROEND, PREGDATE, PCONTENT, id) "
					+ "values(seq_prono.nextval, ?, ?, ?, sysdate, ?, ?)" ;
			/*, sknum, rolenum , ?, ?*/
			Connection conn = null;
			PreparedStatement pstmt = null;
			int result = -1;
			try {	
				conn = DBManager.getConnection();
				
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setString(1, dto.getPro_nm());
				pstmt.setString(2, dto.getProsta());
				pstmt.setString(3, dto.getProend());
				pstmt.setString(4, dto.getPcontent());
				pstmt.setString(5, dto.getId());
				/*pstmt.setString(6, dto.getSknum().toString());
				pstmt.setString(7, dto.getRolenum());*/
			
				pstmt.executeQuery();
				result = 1;
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			return result;
		}
		//프로셀렉절
		public int proSelectList(ProjectDto dto) {
			
			String sql = "select * from CPROJECT where prono =? ";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int result = -1;
			try {
				
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getProno());
				rs = pstmt.executeQuery();
				if (rs.next()){

					dto.setProno(rs.getInt("prono"));
					dto.setPro_nm(rs.getString("pro_nm"));
					dto.setProsta(rs.getString("prosta"));
					dto.setProend(rs.getString("proend"));
					dto.setPregdate(rs.getTimestamp("pregdate"));
					dto.setPcontent(rs.getString("pcontent"));
					
					/*pstmt.setString(6, dto.getSknum().toString());
					pstmt.setString(7, dto.getRolenum());*/
					result = 1;
				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			return result;
		}
		//스킬넘버 인설트//최초
		public void prosknum(int pronum, String sk) {

			String sknumSql	= "insert into comp_skill( "
					+ "PRONO, sknum) "
					+ "values(?, ?) ";
			Connection conn = null;
			PreparedStatement pstmt = null;
		
			ResultSet rs = null;
			
			try {	
				conn = DBManager.getConnection();
		
				pstmt = conn.prepareStatement(sknumSql);
				pstmt.setInt(1, pronum);
				pstmt.setString(2, sk);
				pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		//프로젝트 현번호 '바로'가져오기
		public int pronoSelect() {
			
			String sql = "SELECT SEQ_PRONO.currval as pno FROM dual";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result= -1;
			try {
				
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {	
					result = rs.getInt("pno");
				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			return result;
		
		}
		//프로젝트 수행역활 insert
		public void proRolenumInsert(String rolenum, String empno, int pronum) {

			String sknumSql	= "insert into empproject( "
					+ "PRONO, empno, rolenum) "
					+ "values(?, ?, ?) ";
			Connection conn = null;
			PreparedStatement pstmt = null;
		
			ResultSet rs = null;
			
			try {	
				conn = DBManager.getConnection();
		
				pstmt = conn.prepareStatement(sknumSql);
				pstmt.setInt(1, pronum);
				pstmt.setString(2, empno);
				pstmt.setString(3, rolenum);
			
				pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		//디테일 셀렉트
		public ProjectDto proDetailSelectList(int prono) {
			String sql = "select p.*, pe.role , em.empno "
					+ "from cproject p join empproject em "
					+ "on p.prono = em.prono "
					+ "join perform pe "
					+ "on em.rolenum = pe.rolenum "
					+ "WHERE p.prono = ? ";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ProjectDto dto = null;
			ResultSet rs = null;
			
			try {
				
				conn = DBManager.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, prono);
				
				rs = pstmt.executeQuery();
				if(rs.next()){
					dto = new ProjectDto();
					dto.setProno(rs.getInt("prono"));
					dto.setPro_nm(rs.getString("pro_nm"));
					dto.setProsta(rs.getString("prosta"));
					dto.setProend(rs.getString("proend"));
					dto.setPregdate(rs.getTimestamp("pregdate"));
					dto.setPcontent(rs.getString("pcontent"));
					dto.setRole(rs.getString("role"));
					dto.setId(rs.getString("id"));
					dto.setEmpno(rs.getString("empno")); 
					
	
					/*pstmt.setString(6, dto.getSknum().toString());
					pstmt.setString(7, dto.getRolenum());*/
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
			return dto;
			
		}

		//각 프로젝트에 대한 스킬이름 가지고 오기
		public ArrayList proDetailSkill(int prono) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			SkillDto skDto = null;
			ResultSet rs = null;
			ArrayList skillList = null;
			try {
				
				conn = DBManager.getConnection();
				String sql = "select s.skill_nm  "
						+ "from cproject p join COMP_SKILL c "
						+ "on p.prono = c.prono "
						+ "JOIN skill s "
						+ "on c.sknum = s.sknum "
						+ "where p.prono = ? ";
				pstmt = conn.prepareStatement(sql);
				skillList = new ArrayList();
				pstmt.setInt(1, prono);
				rs = pstmt.executeQuery();
				while(rs.next()){
					skDto = new SkillDto();
					skDto.setSkill_nm(rs.getString("skill_nm"));
					skillList.add(skDto);
				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			return skillList;
		}
		//프로젝트 수정
		public void projectUpdate(ProjectDto dto) {
			
			String Sql = "update cproject set "
					+ "pro_nm= ? , prosta= ? , proend= ? , pregdate= sysdate, pcontent = ? "
					+ "where prono=? ";

			Connection conn = null;
			PreparedStatement pstmt = null;
			/*int result = -1;*/
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(Sql);
				
					pstmt.setString(1, dto.getPro_nm());
					pstmt.setString(2, dto.getProsta());
					pstmt.setString(3, dto.getProend());
					pstmt.setString(4, dto.getPcontent());
					pstmt.setInt(5, dto.getProno());
					
					pstmt.executeUpdate();
					/*result = 1;*/
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			/*return result;*/
		}
		public void empprojectUpdate(int prono , String rolenum) {
			
			String Sql = "update empproject set "
					+ "ROLENUM = ? "
					+ "where prono=? ";

			Connection conn = null;
			PreparedStatement pstmt = null;
			EmpProjectDto dto = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(Sql);
				dto = new EmpProjectDto();
					pstmt.setString(1, rolenum);
					pstmt.setInt(2, prono);
					pstmt.executeUpdate();
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		
		//스킬 지우기
		public void skillDelete(int prono) {
			String deleteSql = "delete from comp_skill where prono=? ";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(deleteSql);
				pstmt.setInt(1, prono);
				pstmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
			
		}
		//수정 인설트
		public void proSkillUpdate(int prono, String sk) {

			String sknumSql	= "insert into comp_skill( "
					+ "PRONO, sknum) "
					+ "values(?, ?) ";
			Connection conn = null;
			PreparedStatement pstmt = null;
		
			ResultSet rs = null;
			
			try {	
				conn = DBManager.getConnection();
		
				pstmt = conn.prepareStatement(sknumSql);
				pstmt.setInt(1, prono);
				pstmt.setString(2, sk);
				pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}

}
/*		public int proDeteilSelect(int prono) {
			
			String sql = "select c.*, e.sknum as sknum "
					+ "from cproject c join comp_skill e "
					+ "on c.prono = e.prono "
					+ "comp_skill e join skill s " ;
					+ "on e.sknum = s.sknum "
}	
	*/

