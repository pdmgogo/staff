package com.staff.controller.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.staff.common.util.DBManager;
import com.staff.controller.Dto.AddressDto;

public class AddrDao {
	
	private AddrDao() {
			
	}
		
	private static AddrDao instance = new AddrDao();
			
	public static AddrDao getInstance() {
		return instance;
	}
	
	public List<AddressDto> selectAllAddr(String search) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select							");
		sql.append("Addrno							");
		sql.append("zip_cd							");
		sql.append("sido							");
		sql.append("sigungu							");
		sql.append("dong							");
		sql.append(",NVL(ri,' ') as ri				");
		sql.append(",NVL(bldg,' ') as bldg			");
		sql.append(",NVL(bungi,' ') as bungi		");
		sql.append("where							");
		sql.append("dong like ?||'%'				");
		
		List<AddressDto> list = new ArrayList<AddressDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {	
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			while (rs.next())	{
				AddressDto dto = new AddressDto();
					dto.setAddrno(rs.getString("Addrno")); 	
					dto.setZip_cd(rs.getString("zip_cd"));			
					dto.setSido(rs.getString("sido"));			
					dto.setSigungu(rs.getString("sigungu"));		
					dto.setDong(rs.getString("dong"));		
					dto.setRi(rs.getString("ri"));		
					dto.setBldg(rs.getString("bldg")); 	
					dto.setBungi(rs.getString("bungi"));
					list.add(dto);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
