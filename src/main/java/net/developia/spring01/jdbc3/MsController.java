package net.developia.spring01.jdbc3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MsController {

	@Autowired
	private MsService msService;
	
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
		dto.setDeptno(80);
		dto.setDname("ai");
		dto.setLoc("kwangju");
		
		try {
			msService.insertDept(dto);
			System.out.println("입력되었습니다.");
		} catch (Exception e) {
			System.out.println("입력 에러");
		}
	}

	
	public void deleteDept() {
		try {
			msService.deleteDept(80);
			System.out.println("삭제 성공");
		} catch (Exception e) {
			System.out.println("삭제 에러");
		}
	}

	/*
	public void updateDept() {
		try {
			msService.updateDept(new DeptDTO(60, "software", "boston"));
			System.out.println("수정 성공");
		} catch (Exception e) {
			System.out.println("수정 에러");
		}
	}
	*/
	public void countDept() {
		try {
			int count = msService.countDept();
			System.out.println("부서 개수 : " + count);
		} catch (Exception e) {
			System.out.println("부서 개수를 가져오지 못함.");
		}
	}

	/*
	public void listEmployees() {
		try {
			List<EmployeesDTO> list = msService.listEmployees();
			for(EmployeesDTO dto:list) {
				System.out.println(dto);
			}
		} catch (Exception e) {
			System.out.println("사원 정보 출력 에러");
		}
	}*/
}
