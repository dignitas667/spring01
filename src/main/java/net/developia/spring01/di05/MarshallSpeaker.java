package net.developia.spring01.di05;

import org.springframework.stereotype.Component;

@Component
public class MarshallSpeaker implements Speaker {
	public void soundUp() {
		System.out.println("MarshallSpeaker : 소리를 키웁니다.");
	}

	public void soundDown() {
		System.out.println("MarshallSpeaker : 소리를 줄입니다.");
	}
}
