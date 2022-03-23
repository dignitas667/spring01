package net.developia.spring01.di01;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageTest {
	public static void main(String[] args) {
		GenericApplicationContext context = 
				new GenericXmlApplicationContext(MessageTest.class, "beaninit.xml");
		try {
			MessageBean mb = (MessageBean) context.getBean("mb"); //new MessageBeanImpl();
			mb.sayHello();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
