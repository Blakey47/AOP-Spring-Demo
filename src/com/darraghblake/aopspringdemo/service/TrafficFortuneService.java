package com.darraghblake.aopspringdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Expect Heavy Traffic This Morning";
	}

	public String getFortune(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("Exception has occurred.");
		}
		return getFortune();
	}
	
}
