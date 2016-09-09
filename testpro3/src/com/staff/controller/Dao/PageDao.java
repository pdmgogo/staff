package com.staff.controller.Dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.staff.common.util.DBManager;
import com.staff.controller.Dto.EmpDto;
import com.staff.controller.Dto.PageDto;
import com.staff.controller.Dto.ProjectDto;
import com.staff.controller.Dto.noticeDto;

public class PageDao {
	private PageDao() {
		
	}
	
	private static PageDao instance = new PageDao();
		
	public static PageDao getInstance() {
		return instance;
	}
	public ArrayList StaffPageView(int start, int end) {
		EmpDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList Stafflist = null;
		try {
			conn = DBManager.getConnection();
			String StaffPageViewSql="SELECT empl_nm, jobno, eregdate FROM (" +
					"SELECT ROWNUM R, A.* FROM (" + 
					"SELECT empl_nm, jobno, eregdate FROM emp ORDER BY empno DESC) A) " +
					"WHERE R BETWEEN ? AND ?";
			
			Stafflist =  new ArrayList();
			pstmt = conn.prepareStatement(StaffPageViewSql);
			int nono = start;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new EmpDto();
				dto.setNono(start++);
				dto.setEmpl_nm(rs.getString("empl_nm"));
				dto.setJobno(rs.getString("jobno"));
				dto.setEregdate(rs.getString("eregdate"));
				Stafflist.add(dto);
			}
			
//				Date wdate = rs.getDate("eregdate");
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return Stafflist;
	}
	
	
	//staff페이지 재료는 생각중 아마 emp테이블이 될듯
	public int StaffPage() {
		PageDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//토탈레코드 초기화변수
		int totalRecord = 0;
		try {
			conn = DBManager.getConnection();
			String StaffPageSql = "SELECT count(*) FROM emp";
			pstmt = conn.prepareStatement(StaffPageSql);
			rs = pstmt.executeQuery();
			//?
			rs.next();
			totalRecord = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt,rs);
		}
		//토탈레코드수를 반환합니다.
		return totalRecord;
		
	}
	
	//공지사항 리스트입니다.
	public ArrayList noticeList(int start, int end) {
		noticeDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList noticeL = null;
		try {
			conn = DBManager.getConnection();
			String noticeListSql="SELECT * FROM (" +
					"SELECT ROWNUM R, A.* FROM (" + 
					"SELECT * FROM notice ORDER BY notno DESC) A) " +
					"WHERE R BETWEEN ? AND ?";
			
			noticeL = new ArrayList();
			pstmt = conn.prepareStatement(noticeListSql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new noticeDto();
				dto.setNotno(rs.getInt("notno"));
				dto.setNot_nm(rs.getString("not_nm"));
				dto.setNot_dt(rs.getTimestamp("not_dt"));
				dto.setNot_hits(rs.getInt("not_hits"));
				noticeL.add(dto);
			}
			
//				Date wdate = rs.getDate("eregdate");
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return noticeL;
	}
	
	
	//재료는 생각중 아마 notice테이블
	public int noticePage() {
		noticeDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//토탈레코드 초기화변수
		int totalRecord = 0;
		try {
			conn = DBManager.getConnection();
			String noticePageSql = "SELECT count(*) FROM notice";
			pstmt = conn.prepareStatement(noticePageSql);
			rs = pstmt.executeQuery();
			//?
			rs.next();
			totalRecord = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt,rs);
		}
		//토탈레코드수를 반환합니다.
		return totalRecord;
		
	}
	//프로젝트
	public ArrayList proList(int start, int end) {
		ProjectDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList proL = null;
		try {
			conn = DBManager.getConnection();
			String proListSql="SELECT * FROM (" +
					"SELECT ROWNUM R, A.* FROM (" + 
					"SELECT * FROM cproject ORDER BY prono DESC) A) " +
					"WHERE R BETWEEN ? AND ?";
			
			proL = new ArrayList();
			pstmt = conn.prepareStatement(proListSql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new ProjectDto();
				dto.setProno(rs.getInt("prono"));
				dto.setPro_nm(rs.getString("pro_nm"));
				dto.setPregdate(rs.getTimestamp("pregdate"));
				dto.setProend(rs.getString("proend"));
				dto.setProsta(rs.getString("prosta"));
				dto.setPcontent(rs.getString("pcontent"));
				dto.setId(rs.getString("id"));
				proL.add(dto);
			}
			
//				Date wdate = rs.getDate("eregdate");
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return proL;
	}
	
	
	//재료는 생각중 아마 notice테이블
	public int proPage() {
		ProjectDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//토탈레코드 초기화변수
		int totalRecord = 0;
		try {
			conn = DBManager.getConnection();
			String proPageSql = "SELECT count(*) FROM cproject";
			pstmt = conn.prepareStatement(proPageSql);
			rs = pstmt.executeQuery();
			//?
			rs.next();
			totalRecord = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt,rs);
		}
		//토탈레코드수를 반환합니다.
		return totalRecord;
		
	}
	
}
//		
//		int numPerPage 		= 10; //한 페이지에서 보일 레코드 수
//		int totalPage 		= 0; //총 페이지수
//
//
//		if (totalRecord != 0) {
//			if (totalRecord % numPerPage == 0) {
//				totalPage = totalRecord / numPerPage;
//			} else {
//				totalPage = totalRecord / numPerPage + 1;
//			}
//		}
//		//3.첫번째 레코드 번호와 마지막 레코드 번호를 구한다.
//		int curPage = request.getParameter("curPage") == null ? 1 : Integer.parseInt(request.getParameter("curPage"));
//		//시작 레코드 계산
//		int start = (curPage - 1) * numPerPage + 1;
//		//마지막 레코드 계산
//		int end = start + numPerPage - 1;
//	}
