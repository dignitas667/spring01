package net.developia.spring01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplate {
	private static final JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public static JdbcTemplate getInstance() {
		return jdbcTemplate;
	}
	
	private JdbcTemplate() {
		try {
			Class.forName("net.sf.log4jdbc.DriverSpy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int update(String query, Object[] args) throws SQLException {
		try(Connection conn = DriverManager.getConnection(
			"jdbc:log4jdbc:oracle:thin:@localhost:1521/xepdb1","ace","me");
			PreparedStatement pstmt = conn.prepareStatement(query)){
			for(int i=0; i < args.length; i++) {
				pstmt.setObject(i+1, args[i]);
			}
			return pstmt.executeUpdate();
		}
	}
}
