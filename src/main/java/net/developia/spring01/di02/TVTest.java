package net.developia.spring01.di02;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVTest {
	public static void main(String[] args) {
		GenericApplicationContext context = new GenericXmlApplicationContext(
				TVTest.class, "product.xml");
		System.out.println("--------------------");
		TV tv = (TV) context.getBean("tv"); //new SamsungTV();
		tv.powerOn();
		tv.channelUp();
		tv.channelUp();
		tv.soundUp();
		tv.soundUp();
		tv.powerOff();
		
		TV tv2 = (TV) context.getBean("tv");
		tv2.powerOn();
		tv2.channelUp();
		tv2.channelUp();
		tv2.soundUp();
		tv2.soundUp();
		tv2.powerOff();
		System.out.println(tv.hashCode());
		System.out.println(tv2.hashCode());
	}
}
