package com.kh.exam14;

public class Sample1 {

	public static void main(String[] args) {
		Person[] p =  new Person[5];
		p[0] = new StudentA();
		p[0].setName("윤두준");	p[0].setAge(33);	p[0].setGender('남');
		
		p[1] = new StudentB();
		p[1].setName("양요섭");	p[1].setAge(32);	p[1].setGender('남');
		// ((Foreigner)p[1]).setDurationDay(90);
		
		p[2] = new StudentC();
		p[2].setName("이기광");	p[2].setAge(32);	p[2].setGender('남');
		// ((Foreigner)p[2]).setDurationDay(90);
		
		p[3] = new StudentA();
		p[3].setName("손동운");	p[3].setAge(31);	p[3].setGender('남');
		
		p[4] = new StudentB();
		p[4].setName("라이트");	p[4].setAge(12);	p[4].setGender('여');
		// ((Foreigner)p[4]).setDurationDay(90);
		
		// 외국인이면 기본 체류기간 90일로 초기화
		for(Person ps:p) {
			if(ps instanceof Foreigner) {
				((Foreigner)ps).setDurationDay(90);
			}
		}
		
		for(Person ps:p) {
			if(ps instanceof Sports) {
				((Sports)ps).run();
			}
			if(ps instanceof Art) {
				((Art)ps).draw();
			}
		}
	}
	
}
