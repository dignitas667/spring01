package net.developia.spring01.autocloseable;

public class MyClassTest {
	public static void main(String[] args) {
		
		try (MyClass m = new MyClass()){
			m.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
