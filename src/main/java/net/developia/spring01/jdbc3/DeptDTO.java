package net.developia.spring01.jdbc3;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO implements Serializable {
	private int deptno;
	private String dname;
	private String loc;
}
