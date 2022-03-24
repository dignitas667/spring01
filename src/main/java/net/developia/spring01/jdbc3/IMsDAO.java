package net.developia.spring01.jdbc3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

public interface IMsDAO {
	public List<DeptDTO> listDept(
		@Param("begin") int begin, @Param("end") int end) throws Exception;

	public int insertDept(DeptDTO dto) throws Exception;
	public int deleteDept(int deptno) throws SQLException;
//	public int updateDept(DeptDTO deptDTO) throws SQLException;

	//@Select("select count(*) as cnt from dept")
	public int countDept() throws SQLException;
//	public List listEmployees() throws SQLException;
}
