package net.developia.spring01.jdbc3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MsService {
	
	@Autowired
	private IMsDAO msDAO;

	public List<DeptDTO> listDept() throws Exception {
		try {
			List<DeptDTO> list = msDAO.listDept();
			if (list == null) {
				throw new RuntimeException("데이터가 없습니다.");
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

/*	public void insertDept(DeptDTO dto) throws Exception {
		try {
			msDAO.insertDept(dto);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteDept(int deptno) throws Exception {
		try {
			if (msDAO.deleteDept(deptno) != 1) {
				throw new RuntimeException("삭제된 부서가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateDept(DeptDTO deptDTO) throws Exception {
		try {
			if (msDAO.updateDept(deptDTO) != 1) {
				throw new RuntimeException("수정된 부서가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public int countDept() {
		try {
			return msDAO.countDept();
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
	}

	public List<EmployeesDTO> listEmployees() {
		try {
			return msDAO.listEmployees();
		} catch (Exception e) {
			log.info(e.toString());
			throw e;
		}
	}*/
}
