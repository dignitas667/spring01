package net.developia.spring01.jdbc3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MsDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String testStr() {
		return "msDAO test~";
	}

	public List<DeptDTO> listDept() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    deptno, ");
		sql.append("    dname, ");
		sql.append("    loc ");
		sql.append("FROM ");
		sql.append("    dept ");
		sql.append("WHERE ");
		sql.append("    deptno BETWEEN ? AND ? ");
		sql.append("ORDER BY deptno ASC ");
		
		Object[] args = {
			10,
			40
		};
		
		RowMapper rowMapper = new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				DeptDTO dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			}
		};
		return jdbcTemplate.query(sql.toString(), args, rowMapper);
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

	public int countDept() {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(deptno) ");
		sql.append("from   dept ");
		return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
	}

	public List listEmployees() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    e.employee_id, ");
		sql.append("    e.last_name, ");
		sql.append("    e.salary, ");
		sql.append("    e.job_id, ");
		sql.append("    e.department_id, ");
		sql.append("    d.department_name ");
		sql.append("FROM ");
		sql.append("         employees e ");
		sql.append("    INNER JOIN departments d ON e.department_id = d.department_id ");
		sql.append("           AND d.department_id = ? ");

		RowMapper<EmployeesDTO> rowMapper = new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeesDTO edto = new EmployeesDTO();
				edto.setEmployee_id(rs.getInt("employee_id"));
				edto.setLast_name(rs.getString("last_name"));
				edto.setSalary(rs.getInt("salary"));
				edto.setJob_id(rs.getString("job_id"));
				edto.setDepartment_id(rs.getInt("department_id"));
				
				DepartmentsDTO ddto = new DepartmentsDTO();
				ddto.setDepartment_name(rs.getString("department_name"));
				
				edto.setDepartmentDTO(ddto);
				return edto;
			}
		};
		
		Object[] args = {60};
		
		return jdbcTemplate.query(sql.toString(), args, rowMapper);
	}

}
