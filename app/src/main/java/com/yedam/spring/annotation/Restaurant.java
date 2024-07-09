package com.yedam.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	private Chef chef;
	
	
	Restaurant(Chef chef){
		System.out.println("생성자 인젝션");
		this.chef = chef;
	}
	Restaurant(){}
	@Autowired
	public void setChef(Chef chef) {
		System.out.println("세터123 인젝션");
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}