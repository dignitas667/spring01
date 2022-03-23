package net.developia.spring01.autocloseable;

public class MyClass implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("MyClass.close() 수행함....");
	}
	public void run() {
		System.out.println("run~");
	}
}
