package net.developia.spring01.di01;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	private Outputter outputter;
	
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHello() throws Exception {
		String msg = name + "씨, " + greeting;
		System.out.println(msg);
		outputter.output(msg);
	}
}
