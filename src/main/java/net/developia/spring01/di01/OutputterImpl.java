package net.developia.spring01.di01;

import java.io.File;
import java.io.FileWriter;

public class OutputterImpl implements Outputter {
	private String fileName;
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void output(String msg) throws Exception {
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file);
		fw.write(msg);
		fw.close();
	}
}
