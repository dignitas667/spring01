package net.developia.spring01.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MsService {
	
	@Autowired
	private MsDAO msDAO;

	public String testStr() {
		return msDAO.testStr();
	}

	public List<DeptDTO> listDept() throws Exception {
		try {
			List<DeptDTO> list = msDAO.listDept();
			if (list == null) {
				throw new RuntimeException("데이터가 없습니다.");
			}
			return list;
		} catch (Exception e) {
			log.info("error : " + e);
			throw e;
		}
	}
}
