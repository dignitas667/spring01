package net.developia.spring01.di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Component(value = "tv")
public class SamsungTV implements TV {
	private Speaker speaker;

	public SamsungTV(@Qualifier(value = "marshallSpeaker") Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("SamsungTV : 전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV : 전원을 끕니다.");
	}
	public void channelUp() {
		System.out.println("SamsungTV : 채널을 올립니다.");
	}
	public void channelDown() {
		System.out.println("SamsungTV : 채널을 내립니다.");
	}
	public void soundUp() {
		if (speaker == null) {
			System.out.println("SamsungTV : 소리를 키웁니다.");
		} else {
			speaker.soundUp();
		}
	}
	public void soundDown() {
		if (speaker == null) {
			System.out.println("SamsungTV : 소리를 줄입니다.");
		} else {
			speaker.soundDown();
		}
	}
}
