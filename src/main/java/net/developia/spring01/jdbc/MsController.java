package net.developia.spring01.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MsController {

	@Autowired
	private MsService msService;
	
	public String testStr() {
		return msService.testStr();
	}

	public void listDept() {
		try {
			List<DeptDTO> list = msService.listDept();
			for(DeptDTO dto: list) {
				System.out.println(dto);
			}
		} catch (Exception e) {
			System.out.println("예외가 발생하였습니다.");
		}
	}

	public void insertDept() {
		DeptDTO dto = new DeptDTO();
		dto.setDeptno(60);
		dto.setDname("dev2");
		dto.setLoc("newyork");
		
		try {
			msService.insertDept(dto);
			System.out.println("입력되었습니다.");
		} catch (Exception e) {
			System.out.println("입력 에러");
		}
	}

	public void deleteDept() {
		try {
			msService.deleteDept(60);
			System.out.println("삭제 성공");
		} catch (Exception e) {
			System.out.println("삭제 에러");
		}
	}

	public void updateDept() {
		try {
			msService.updateDept(new DeptDTO(60, "software", "boston"));
			System.out.println("수정 성공");
		} catch (Exception e) {
			System.out.println("수정 에러");
		}
	}
}
