package net.developia.spring01.jdbc3;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import net.developia.spring01.di05.TV;
import net.developia.spring01.di05.TVTest;

public class JdbcTest {
	public static void main(String[] args) {
		GenericApplicationContext context = new GenericXmlApplicationContext(
				JdbcTest.class, "beaninit.xml");
		MsController ms = (MsController) context.getBean("msController");
		//ms.insertDept();
		//ms.deleteDept();
		//ms.updateDept();
		//ms.listDept();
		ms.countDept();
		//ms.listEmployees();
	}
}
