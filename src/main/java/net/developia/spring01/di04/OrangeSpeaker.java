package net.developia.spring01.di04;

import org.springframework.stereotype.Component;

@Component
public class OrangeSpeaker implements Speaker {
	public void soundUp() {
		System.out.println("OrangeSpeaker : 소리를 키웁니다.");
	}

	public void soundDown() {
		System.out.println("OrangeSpeaker : 소리를 줄입니다.");
	}
}
