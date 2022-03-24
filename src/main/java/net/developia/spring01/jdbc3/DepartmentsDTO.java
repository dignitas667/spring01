package net.developia.spring01.jdbc3;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class DepartmentsDTO implements Serializable { 
	private int department_id;
	private String department_name;
	
}
