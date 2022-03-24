package net.developia.spring01.jdbc3;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class EmployeesDTO implements Serializable {
	private int employee_id;
	private String last_name;
	private String job_id;
	private int salary;
	private int department_id;
	private DepartmentsDTO departmentDTO;
}
