package net.developia.spring01.di02;

public class HarmanSpeaker implements Speaker {
	public void soundUp() {
		System.out.println("HarmanSpeaker : 소리를 키웁니다.");
	}

	public void soundDown() {
		System.out.println("HarmanSpeaker : 소리를 줄입니다.");
	}
}
