package net.developia.spring01.di03;

public class OrangeSpeaker implements Speaker {
	public void soundUp() {
		System.out.println("OrangeSpeaker : 소리를 키웁니다.");
	}

	public void soundDown() {
		System.out.println("OrangeSpeaker : 소리를 줄입니다.");
	}
}
