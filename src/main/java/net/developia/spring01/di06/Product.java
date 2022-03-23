package net.developia.spring01.di06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Product {

	@Bean
	public TV tv() {
		return new SamsungTV();
	}
	
	@Bean
	public Speaker speaker() {
		return new MarshallSpeaker();
	}
}
