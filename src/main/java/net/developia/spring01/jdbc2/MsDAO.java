package net.developia.spring01.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MsDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

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
		
		Class.forName("net.sf.log4jdbc.DriverSpy");
		try (Connection conn = DriverManager.getConnection(
			"jdbc:log4jdbc:oracle:thin:@localhost:1521/xepdb1","ace","me");
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			try(ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					DeptDTO dto = new DeptDTO();
					dto.setDeptno(rs.getInt("deptno"));
					dto.setDname(rs.getString("dname"));
					dto.setLoc(rs.getString("loc"));
					list.add(dto);
				}
			}
		}
		return list;
	}

	public int insertDept(DeptDTO dto) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO dept ( ");
		sql.append("    deptno, ");
		sql.append("    dname, ");
		sql.append("    loc ");
		sql.append(") VALUES ( ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ? ");
		sql.append(") ");
		
		Object[] args = {
			dto.getDeptno(),
			dto.getDname(),
			dto.getLoc()
		};
		
		return jdbcTemplate.update(sql.toString(), args);
	}

	public int deleteDept(int deptno) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("delete dept ");
		sql.append("where  deptno=? ");
		
		Object[] args = {deptno};
		return jdbcTemplate.update(sql.toString(), args);
	}

	public int updateDept(DeptDTO deptDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("update dept set ");
		sql.append("       deptno=?, dname=?, loc=? ");
		sql.append("where  deptno=? ");
		
		Object[] args= {
			deptDTO.getDeptno(),
			deptDTO.getDname(),
			deptDTO.getLoc(),
			deptDTO.getDeptno()
		};
		return jdbcTemplate.update(sql.toString(), args);
	}

}
