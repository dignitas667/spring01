package net.developia.spring01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MsDAO {

	public String testStr() {
		return "msDAO test~";
	}

	public List<DeptDTO> listDept() throws Exception {
		List<DeptDTO> list = new ArrayList<>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    deptno, ");
		sql.append("    dname, ");
		sql.append("    loc ");
		sql.append("FROM ");
		sql.append("    dept ");
		
		try (Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521/xepdb1","ace","me");
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			try(ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					DeptDTO dto = new DeptDTO();
					dto.setDeptno(rs.getInt(1));
					dto.setDname(rs.getString("dname"));
					dto.setLoc(rs.getString("loc"));
					list.add(dto);
				}
			}
		}
		return list;
	}

}
